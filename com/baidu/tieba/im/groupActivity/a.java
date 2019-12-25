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
/* loaded from: classes7.dex */
public class a extends c<BaseFragmentActivity> {
    private int bFF;
    private View hmG;
    private boolean hwA;
    private CreateGroupActivityActivity hwn;
    private EditText hwo;
    private ImageButton hwp;
    private TextView hwq;
    private EditText hwr;
    private ImageButton hws;
    private Button hwt;
    private Button hwu;
    private DatePickerDialog hwv;
    private TimePickerDialog hww;
    private EditText hwx;
    private TextWatcher hwy;
    private TextWatcher hwz;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int zh;
    private int zi;
    private int zj;
    private int zl;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.hwv = null;
        this.hww = null;
        this.zh = 0;
        this.zi = 0;
        this.zj = 0;
        this.bFF = 0;
        this.zl = 0;
        this.hwA = false;
        this.hwn = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.hwn.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hwn.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.hmG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hmG.setOnClickListener(this.hwn);
        this.hwq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hwn.getResources().getString(R.string.group_activity_create_btntext));
        this.hwq.setOnClickListener(this.hwn);
        this.hwq.setEnabled(false);
        this.hwo = (EditText) this.hwn.findViewById(R.id.txt_group_activity_name);
        this.hwp = (ImageButton) this.hwn.findViewById(R.id.btn_del_name);
        this.hwr = (EditText) this.hwn.findViewById(R.id.txt_group_activity_place);
        this.hws = (ImageButton) this.hwn.findViewById(R.id.btn_del_place);
        this.hwx = (EditText) this.hwn.findViewById(R.id.txt_group_activity_content);
        this.hwt = (Button) this.hwn.findViewById(R.id.btn_create_group_date);
        this.hwu = (Button) this.hwn.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.zh = calendar.get(1);
        this.zi = calendar.get(2);
        this.zj = calendar.get(5);
        this.bFF = calendar.get(11);
        this.zl = calendar.get(12);
        bSR();
        bSQ();
        this.hwn.ShowSoftKeyPadDelay(this.hwo, 500);
        this.hwt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hwv == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.hwn.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.zh = i;
                            a.this.zi = i2;
                            a.this.zj = i3;
                            g.b(a.this.hwv, a.this.hwn.getPageContext());
                            a.this.bSR();
                            a.this.hwA = true;
                        }
                    };
                    a.this.hwv = new DatePickerDialog(a.this.hwn.getPageContext().getPageActivity(), onDateSetListener, a.this.zh, a.this.zi, a.this.zj);
                }
                a.this.hwv.updateDate(a.this.zh, a.this.zi, a.this.zj);
                g.a(a.this.hwv, a.this.hwn.getPageContext());
            }
        });
        this.hwu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hww == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.bFF = i;
                            a.this.zl = i2;
                            g.b(a.this.hww, a.this.hwn.getPageContext());
                            a.this.bSQ();
                            a.this.hwA = true;
                        }
                    };
                    a.this.hww = new TimePickerDialog(a.this.hwn.getPageContext().getPageActivity(), onTimeSetListener, a.this.bFF, a.this.zl, false);
                }
                a.this.hww.updateTime(a.this.bFF, a.this.zl);
                g.a(a.this.hww, a.this.hwn.getPageContext());
            }
        });
        this.hwp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hwo.setText("");
            }
        });
        this.hws.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hwr.setText("");
            }
        });
        this.hwy = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hwo.getText().length() > 0) {
                    a.this.hwp.setVisibility(0);
                    a.this.hwq.setEnabled(true);
                    return;
                }
                a.this.hwp.setVisibility(8);
                a.this.hwq.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hwo.addTextChangedListener(this.hwy);
        this.hwz = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hwr.getText().length() > 0) {
                    a.this.hws.setVisibility(0);
                } else {
                    a.this.hws.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hwr.addTextChangedListener(this.hwz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSQ() {
        if (this.bFF > 12) {
            this.hwu.setText(this.hwn.getResources().getString(R.string.afternoon) + HanziToPinyin.Token.SEPARATOR + (this.bFF - 12) + ":" + (this.zl < 10 ? "0" : "") + this.zl);
        } else {
            this.hwu.setText(this.hwn.getResources().getString(R.string.morning) + HanziToPinyin.Token.SEPARATOR + this.bFF + ":" + (this.zl < 10 ? "0" : "") + this.zl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSR() {
        this.hwt.setText(this.zh + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zi + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zj + HanziToPinyin.Token.SEPARATOR + aq.getWeekString(this.zh, this.zi, this.zj));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.hwo.removeTextChangedListener(this.hwy);
        this.hwr.removeTextChangedListener(this.hwz);
    }

    public View bSS() {
        return this.hmG;
    }

    public TextView bST() {
        return this.hwq;
    }

    public String getTitle() {
        return this.hwo.getText().toString();
    }

    public String bSU() {
        return this.hwr.getText().toString();
    }

    public String getContent() {
        return this.hwx.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.zh + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zi + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zj + HanziToPinyin.Token.SEPARATOR + this.bFF + ":" + this.zl).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.hwo.setText(str);
    }

    public void setContent(String str) {
        this.hwx.setText(str);
    }

    public void CG(String str) {
        this.hwr.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.zh = date.getYear() + 1900;
        this.zi = date.getMonth();
        this.zj = date.getDate();
        this.bFF = date.getHours();
        this.zl = date.getMinutes();
        bSR();
        bSQ();
    }

    public void onChangeSkinType(int i) {
        this.hwn.getLayoutMode().setNightMode(i == 1);
        this.hwn.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hwn.getPageContext(), i);
        this.hwq.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.hwq.setText(this.hwn.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                CG(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.hwq.setText(this.hwn.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bSV() {
        return this.hwA;
    }
}
