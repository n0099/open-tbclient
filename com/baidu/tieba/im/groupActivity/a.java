package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.f.g;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes10.dex */
public class a extends c<BaseFragmentActivity> {
    private int bKx;
    private CreateGroupActivityActivity hCd;
    private EditText hCe;
    private ImageButton hCf;
    private TextView hCg;
    private EditText hCh;
    private ImageButton hCi;
    private Button hCj;
    private Button hCk;
    private DatePickerDialog hCl;
    private TimePickerDialog hCm;
    private EditText hCn;
    private TextWatcher hCo;
    private TextWatcher hCp;
    private boolean hCq;
    private View hsw;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int zD;
    private int zE;
    private int zF;
    private int zH;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.hCl = null;
        this.hCm = null;
        this.zD = 0;
        this.zE = 0;
        this.zF = 0;
        this.bKx = 0;
        this.zH = 0;
        this.hCq = false;
        this.hCd = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.hCd.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hCd.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.hsw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hsw.setOnClickListener(this.hCd);
        this.hCg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hCd.getResources().getString(R.string.group_activity_create_btntext));
        this.hCg.setOnClickListener(this.hCd);
        this.hCg.setEnabled(false);
        this.hCe = (EditText) this.hCd.findViewById(R.id.txt_group_activity_name);
        this.hCf = (ImageButton) this.hCd.findViewById(R.id.btn_del_name);
        this.hCh = (EditText) this.hCd.findViewById(R.id.txt_group_activity_place);
        this.hCi = (ImageButton) this.hCd.findViewById(R.id.btn_del_place);
        this.hCn = (EditText) this.hCd.findViewById(R.id.txt_group_activity_content);
        this.hCj = (Button) this.hCd.findViewById(R.id.btn_create_group_date);
        this.hCk = (Button) this.hCd.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.zD = calendar.get(1);
        this.zE = calendar.get(2);
        this.zF = calendar.get(5);
        this.bKx = calendar.get(11);
        this.zH = calendar.get(12);
        bVE();
        bVD();
        this.hCd.ShowSoftKeyPadDelay(this.hCe, 500);
        this.hCj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hCl == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.hCd.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.zD = i;
                            a.this.zE = i2;
                            a.this.zF = i3;
                            g.b(a.this.hCl, a.this.hCd.getPageContext());
                            a.this.bVE();
                            a.this.hCq = true;
                        }
                    };
                    a.this.hCl = new DatePickerDialog(a.this.hCd.getPageContext().getPageActivity(), onDateSetListener, a.this.zD, a.this.zE, a.this.zF);
                }
                a.this.hCl.updateDate(a.this.zD, a.this.zE, a.this.zF);
                g.a(a.this.hCl, a.this.hCd.getPageContext());
            }
        });
        this.hCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hCm == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.bKx = i;
                            a.this.zH = i2;
                            g.b(a.this.hCm, a.this.hCd.getPageContext());
                            a.this.bVD();
                            a.this.hCq = true;
                        }
                    };
                    a.this.hCm = new TimePickerDialog(a.this.hCd.getPageContext().getPageActivity(), onTimeSetListener, a.this.bKx, a.this.zH, false);
                }
                a.this.hCm.updateTime(a.this.bKx, a.this.zH);
                g.a(a.this.hCm, a.this.hCd.getPageContext());
            }
        });
        this.hCf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hCe.setText("");
            }
        });
        this.hCi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hCh.setText("");
            }
        });
        this.hCo = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hCe.getText().length() > 0) {
                    a.this.hCf.setVisibility(0);
                    a.this.hCg.setEnabled(true);
                    return;
                }
                a.this.hCf.setVisibility(8);
                a.this.hCg.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hCe.addTextChangedListener(this.hCo);
        this.hCp = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hCh.getText().length() > 0) {
                    a.this.hCi.setVisibility(0);
                } else {
                    a.this.hCi.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hCh.addTextChangedListener(this.hCp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVD() {
        if (this.bKx > 12) {
            this.hCk.setText(this.hCd.getResources().getString(R.string.afternoon) + HanziToPinyin.Token.SEPARATOR + (this.bKx - 12) + ":" + (this.zH < 10 ? "0" : "") + this.zH);
        } else {
            this.hCk.setText(this.hCd.getResources().getString(R.string.morning) + HanziToPinyin.Token.SEPARATOR + this.bKx + ":" + (this.zH < 10 ? "0" : "") + this.zH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVE() {
        this.hCj.setText(this.zD + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zE + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zF + HanziToPinyin.Token.SEPARATOR + aq.getWeekString(this.zD, this.zE, this.zF));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.hCe.removeTextChangedListener(this.hCo);
        this.hCh.removeTextChangedListener(this.hCp);
    }

    public View bVF() {
        return this.hsw;
    }

    public TextView bVG() {
        return this.hCg;
    }

    public String getTitle() {
        return this.hCe.getText().toString();
    }

    public String bVH() {
        return this.hCh.getText().toString();
    }

    public String getContent() {
        return this.hCn.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.zD + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zE + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zF + HanziToPinyin.Token.SEPARATOR + this.bKx + ":" + this.zH).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.hCe.setText(str);
    }

    public void setContent(String str) {
        this.hCn.setText(str);
    }

    public void Dh(String str) {
        this.hCh.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.zD = date.getYear() + 1900;
        this.zE = date.getMonth();
        this.zF = date.getDate();
        this.bKx = date.getHours();
        this.zH = date.getMinutes();
        bVE();
        bVD();
    }

    public void onChangeSkinType(int i) {
        this.hCd.getLayoutMode().setNightMode(i == 1);
        this.hCd.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hCd.getPageContext(), i);
        this.hCg.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.hCg.setText(this.hCd.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                Dh(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.hCg.setText(this.hCd.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bVI() {
        return this.hCq;
    }
}
