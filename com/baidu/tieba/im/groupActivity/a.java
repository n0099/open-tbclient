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
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes3.dex */
public class a extends c<BaseFragmentActivity> {
    private int Jq;
    private int Jr;
    private int Js;
    private int Ju;
    private TextWatcher dch;
    private View egF;
    private DatePickerDialog eqA;
    private TimePickerDialog eqB;
    private EditText eqC;
    private TextWatcher eqD;
    private int eqE;
    private boolean eqF;
    private CreateGroupActivityActivity eqs;
    private EditText eqt;
    private ImageButton equ;
    private TextView eqv;
    private EditText eqw;
    private ImageButton eqx;
    private Button eqy;
    private Button eqz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eqA = null;
        this.eqB = null;
        this.Jq = 0;
        this.Jr = 0;
        this.Js = 0;
        this.eqE = 0;
        this.Ju = 0;
        this.eqF = false;
        this.eqs = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.i.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eqs.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eqs.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.group_activity_create);
        this.egF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.egF.setOnClickListener(this.eqs);
        this.eqv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eqs.getResources().getString(d.k.group_activity_create_btntext));
        this.eqv.setOnClickListener(this.eqs);
        this.eqv.setEnabled(false);
        this.eqt = (EditText) this.eqs.findViewById(d.g.txt_group_activity_name);
        this.equ = (ImageButton) this.eqs.findViewById(d.g.btn_del_name);
        this.eqw = (EditText) this.eqs.findViewById(d.g.txt_group_activity_place);
        this.eqx = (ImageButton) this.eqs.findViewById(d.g.btn_del_place);
        this.eqC = (EditText) this.eqs.findViewById(d.g.txt_group_activity_content);
        this.eqy = (Button) this.eqs.findViewById(d.g.btn_create_group_date);
        this.eqz = (Button) this.eqs.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Jq = calendar.get(1);
        this.Jr = calendar.get(2);
        this.Js = calendar.get(5);
        this.eqE = calendar.get(11);
        this.Ju = calendar.get(12);
        aJQ();
        aJP();
        this.eqs.ShowSoftKeyPadDelay(this.eqt, 500);
        this.eqy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eqA == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eqs.showToast(d.k.group_activity_time_val);
                                return;
                            }
                            a.this.Jq = i;
                            a.this.Jr = i2;
                            a.this.Js = i3;
                            g.b(a.this.eqA, a.this.eqs.getPageContext());
                            a.this.aJQ();
                            a.this.eqF = true;
                        }
                    };
                    a.this.eqA = new DatePickerDialog(a.this.eqs.getPageContext().getPageActivity(), onDateSetListener, a.this.Jq, a.this.Jr, a.this.Js);
                }
                a.this.eqA.updateDate(a.this.Jq, a.this.Jr, a.this.Js);
                g.a(a.this.eqA, a.this.eqs.getPageContext());
            }
        });
        this.eqz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eqB == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.eqE = i;
                            a.this.Ju = i2;
                            g.b(a.this.eqB, a.this.eqs.getPageContext());
                            a.this.aJP();
                            a.this.eqF = true;
                        }
                    };
                    a.this.eqB = new TimePickerDialog(a.this.eqs.getPageContext().getPageActivity(), onTimeSetListener, a.this.eqE, a.this.Ju, false);
                }
                a.this.eqB.updateTime(a.this.eqE, a.this.Ju);
                g.a(a.this.eqB, a.this.eqs.getPageContext());
            }
        });
        this.equ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eqt.setText("");
            }
        });
        this.eqx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eqw.setText("");
            }
        });
        this.dch = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eqt.getText().length() > 0) {
                    a.this.equ.setVisibility(0);
                    a.this.eqv.setEnabled(true);
                    return;
                }
                a.this.equ.setVisibility(8);
                a.this.eqv.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eqt.addTextChangedListener(this.dch);
        this.eqD = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eqw.getText().length() > 0) {
                    a.this.eqx.setVisibility(0);
                } else {
                    a.this.eqx.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eqw.addTextChangedListener(this.eqD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJP() {
        if (this.eqE > 12) {
            this.eqz.setText(this.eqs.getResources().getString(d.k.afternoon) + " " + (this.eqE - 12) + SystemInfoUtil.COLON + (this.Ju < 10 ? "0" : "") + this.Ju);
        } else {
            this.eqz.setText(this.eqs.getResources().getString(d.k.morning) + " " + this.eqE + SystemInfoUtil.COLON + (this.Ju < 10 ? "0" : "") + this.Ju);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJQ() {
        this.eqy.setText(this.Jq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Jr + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Js + " " + ap.k(this.Jq, this.Jr, this.Js));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eqt.removeTextChangedListener(this.dch);
        this.eqw.removeTextChangedListener(this.eqD);
    }

    public View aJR() {
        return this.egF;
    }

    public TextView aJS() {
        return this.eqv;
    }

    public String getTitle() {
        return this.eqt.getText().toString();
    }

    public String aJT() {
        return this.eqw.getText().toString();
    }

    public String getContent() {
        return this.eqC.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Jq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Jr + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Js + " " + this.eqE + SystemInfoUtil.COLON + this.Ju).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eqt.setText(str);
    }

    public void setContent(String str) {
        this.eqC.setText(str);
    }

    public void ot(String str) {
        this.eqw.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Jq = date.getYear() + 1900;
        this.Jr = date.getMonth();
        this.Js = date.getDate();
        this.eqE = date.getHours();
        this.Ju = date.getMinutes();
        aJQ();
        aJP();
    }

    public void onChangeSkinType(int i) {
        this.eqs.getLayoutMode().setNightMode(i == 1);
        this.eqs.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eqs.getPageContext(), i);
        this.eqv.setTextColor(am.getColor(d.C0142d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eqv.setText(this.eqs.getPageContext().getContext().getString(d.k.done));
            this.mNavigationBar.setTitleText(d.k.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                ot(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.eqv.setText(this.eqs.getPageContext().getContext().getString(d.k.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.k.group_activity_create);
    }

    public boolean aJU() {
        return this.eqF;
    }
}
