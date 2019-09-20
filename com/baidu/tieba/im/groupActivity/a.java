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
import com.baidu.adp.lib.g.g;
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
/* loaded from: classes5.dex */
public class a extends c<BaseFragmentActivity> {
    private int KA;
    private int KC;
    private int Ky;
    private int Kz;
    private int aIY;
    private TextWatcher fov;
    private View gBq;
    private CreateGroupActivityActivity gLc;
    private EditText gLd;
    private ImageButton gLe;
    private TextView gLf;
    private EditText gLg;
    private ImageButton gLh;
    private Button gLi;
    private Button gLj;
    private DatePickerDialog gLk;
    private TimePickerDialog gLl;
    private EditText gLm;
    private TextWatcher gLn;
    private boolean gLo;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.gLk = null;
        this.gLl = null;
        this.Ky = 0;
        this.Kz = 0;
        this.KA = 0;
        this.aIY = 0;
        this.KC = 0;
        this.gLo = false;
        this.gLc = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.gLc.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gLc.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.gBq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gBq.setOnClickListener(this.gLc);
        this.gLf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gLc.getResources().getString(R.string.group_activity_create_btntext));
        this.gLf.setOnClickListener(this.gLc);
        this.gLf.setEnabled(false);
        this.gLd = (EditText) this.gLc.findViewById(R.id.txt_group_activity_name);
        this.gLe = (ImageButton) this.gLc.findViewById(R.id.btn_del_name);
        this.gLg = (EditText) this.gLc.findViewById(R.id.txt_group_activity_place);
        this.gLh = (ImageButton) this.gLc.findViewById(R.id.btn_del_place);
        this.gLm = (EditText) this.gLc.findViewById(R.id.txt_group_activity_content);
        this.gLi = (Button) this.gLc.findViewById(R.id.btn_create_group_date);
        this.gLj = (Button) this.gLc.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Ky = calendar.get(1);
        this.Kz = calendar.get(2);
        this.KA = calendar.get(5);
        this.aIY = calendar.get(11);
        this.KC = calendar.get(12);
        bEV();
        bEU();
        this.gLc.ShowSoftKeyPadDelay(this.gLd, 500);
        this.gLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gLk == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.gLc.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.Ky = i;
                            a.this.Kz = i2;
                            a.this.KA = i3;
                            g.b(a.this.gLk, a.this.gLc.getPageContext());
                            a.this.bEV();
                            a.this.gLo = true;
                        }
                    };
                    a.this.gLk = new DatePickerDialog(a.this.gLc.getPageContext().getPageActivity(), onDateSetListener, a.this.Ky, a.this.Kz, a.this.KA);
                }
                a.this.gLk.updateDate(a.this.Ky, a.this.Kz, a.this.KA);
                g.a(a.this.gLk, a.this.gLc.getPageContext());
            }
        });
        this.gLj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gLl == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.aIY = i;
                            a.this.KC = i2;
                            g.b(a.this.gLl, a.this.gLc.getPageContext());
                            a.this.bEU();
                            a.this.gLo = true;
                        }
                    };
                    a.this.gLl = new TimePickerDialog(a.this.gLc.getPageContext().getPageActivity(), onTimeSetListener, a.this.aIY, a.this.KC, false);
                }
                a.this.gLl.updateTime(a.this.aIY, a.this.KC);
                g.a(a.this.gLl, a.this.gLc.getPageContext());
            }
        });
        this.gLe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gLd.setText("");
            }
        });
        this.gLh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gLg.setText("");
            }
        });
        this.fov = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gLd.getText().length() > 0) {
                    a.this.gLe.setVisibility(0);
                    a.this.gLf.setEnabled(true);
                    return;
                }
                a.this.gLe.setVisibility(8);
                a.this.gLf.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gLd.addTextChangedListener(this.fov);
        this.gLn = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gLg.getText().length() > 0) {
                    a.this.gLh.setVisibility(0);
                } else {
                    a.this.gLh.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gLg.addTextChangedListener(this.gLn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEU() {
        if (this.aIY > 12) {
            this.gLj.setText(this.gLc.getResources().getString(R.string.afternoon) + " " + (this.aIY - 12) + ":" + (this.KC < 10 ? "0" : "") + this.KC);
        } else {
            this.gLj.setText(this.gLc.getResources().getString(R.string.morning) + " " + this.aIY + ":" + (this.KC < 10 ? "0" : "") + this.KC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEV() {
        this.gLi.setText(this.Ky + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Kz + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.KA + " " + aq.q(this.Ky, this.Kz, this.KA));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.gLd.removeTextChangedListener(this.fov);
        this.gLg.removeTextChangedListener(this.gLn);
    }

    public View bEW() {
        return this.gBq;
    }

    public TextView bEX() {
        return this.gLf;
    }

    public String getTitle() {
        return this.gLd.getText().toString();
    }

    public String bEY() {
        return this.gLg.getText().toString();
    }

    public String getContent() {
        return this.gLm.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Ky + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Kz + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.KA + " " + this.aIY + ":" + this.KC).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.gLd.setText(str);
    }

    public void setContent(String str) {
        this.gLm.setText(str);
    }

    public void zF(String str) {
        this.gLg.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Ky = date.getYear() + 1900;
        this.Kz = date.getMonth();
        this.KA = date.getDate();
        this.aIY = date.getHours();
        this.KC = date.getMinutes();
        bEV();
        bEU();
    }

    public void onChangeSkinType(int i) {
        this.gLc.getLayoutMode().setNightMode(i == 1);
        this.gLc.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gLc.getPageContext(), i);
        this.gLf.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.gLf.setText(this.gLc.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                zF(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.gLf.setText(this.gLc.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bEZ() {
        return this.gLo;
    }
}
