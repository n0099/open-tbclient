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
import com.baidu.searchbox.ng.ai.apps.res.ui.BdDatePicker;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes3.dex */
public class a extends c<BaseFragmentActivity> {
    private TextWatcher dDn;
    private View eKB;
    private CreateGroupActivityActivity eUj;
    private EditText eUk;
    private ImageButton eUl;
    private TextView eUm;
    private EditText eUn;
    private ImageButton eUo;
    private Button eUp;
    private Button eUq;
    private DatePickerDialog eUr;
    private TimePickerDialog eUs;
    private EditText eUt;
    private TextWatcher eUu;
    private boolean eUv;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int mMonth;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int mYear;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eUr = null;
        this.eUs = null;
        this.mYear = 0;
        this.mMonth = 0;
        this.mDay = 0;
        this.mHour = 0;
        this.mMinute = 0;
        this.eUv = false;
        this.eUj = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(e.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eUj.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eUj.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
        this.eKB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eKB.setOnClickListener(this.eUj);
        this.eUm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eUj.getResources().getString(e.j.group_activity_create_btntext));
        this.eUm.setOnClickListener(this.eUj);
        this.eUm.setEnabled(false);
        this.eUk = (EditText) this.eUj.findViewById(e.g.txt_group_activity_name);
        this.eUl = (ImageButton) this.eUj.findViewById(e.g.btn_del_name);
        this.eUn = (EditText) this.eUj.findViewById(e.g.txt_group_activity_place);
        this.eUo = (ImageButton) this.eUj.findViewById(e.g.btn_del_place);
        this.eUt = (EditText) this.eUj.findViewById(e.g.txt_group_activity_content);
        this.eUp = (Button) this.eUj.findViewById(e.g.btn_create_group_date);
        this.eUq = (Button) this.eUj.findViewById(e.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2);
        this.mDay = calendar.get(5);
        this.mHour = calendar.get(11);
        this.mMinute = calendar.get(12);
        aSu();
        aSt();
        this.eUj.ShowSoftKeyPadDelay(this.eUk, 500);
        this.eUp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eUr == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eUj.showToast(e.j.group_activity_time_val);
                                return;
                            }
                            a.this.mYear = i;
                            a.this.mMonth = i2;
                            a.this.mDay = i3;
                            g.b(a.this.eUr, a.this.eUj.getPageContext());
                            a.this.aSu();
                            a.this.eUv = true;
                        }
                    };
                    a.this.eUr = new DatePickerDialog(a.this.eUj.getPageContext().getPageActivity(), onDateSetListener, a.this.mYear, a.this.mMonth, a.this.mDay);
                }
                a.this.eUr.updateDate(a.this.mYear, a.this.mMonth, a.this.mDay);
                g.a(a.this.eUr, a.this.eUj.getPageContext());
            }
        });
        this.eUq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eUs == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.mHour = i;
                            a.this.mMinute = i2;
                            g.b(a.this.eUs, a.this.eUj.getPageContext());
                            a.this.aSt();
                            a.this.eUv = true;
                        }
                    };
                    a.this.eUs = new TimePickerDialog(a.this.eUj.getPageContext().getPageActivity(), onTimeSetListener, a.this.mHour, a.this.mMinute, false);
                }
                a.this.eUs.updateTime(a.this.mHour, a.this.mMinute);
                g.a(a.this.eUs, a.this.eUj.getPageContext());
            }
        });
        this.eUl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eUk.setText("");
            }
        });
        this.eUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eUn.setText("");
            }
        });
        this.dDn = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eUk.getText().length() > 0) {
                    a.this.eUl.setVisibility(0);
                    a.this.eUm.setEnabled(true);
                    return;
                }
                a.this.eUl.setVisibility(8);
                a.this.eUm.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eUk.addTextChangedListener(this.dDn);
        this.eUu = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eUn.getText().length() > 0) {
                    a.this.eUo.setVisibility(0);
                } else {
                    a.this.eUo.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eUn.addTextChangedListener(this.eUu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSt() {
        if (this.mHour > 12) {
            this.eUq.setText(this.eUj.getResources().getString(e.j.afternoon) + " " + (this.mHour - 12) + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        } else {
            this.eUq.setText(this.eUj.getResources().getString(e.j.morning) + " " + this.mHour + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSu() {
        this.eUp.setText(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + ao.m(this.mYear, this.mMonth, this.mDay));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eUk.removeTextChangedListener(this.dDn);
        this.eUn.removeTextChangedListener(this.eUu);
    }

    public View aSv() {
        return this.eKB;
    }

    public TextView aSw() {
        return this.eUm;
    }

    public String getTitle() {
        return this.eUk.getText().toString();
    }

    public String aSx() {
        return this.eUn.getText().toString();
    }

    public String getContent() {
        return this.eUt.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + this.mHour + ":" + this.mMinute).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eUk.setText(str);
    }

    public void setContent(String str) {
        this.eUt.setText(str);
    }

    public void qk(String str) {
        this.eUn.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.mYear = date.getYear() + BdDatePicker.START_YEAR;
        this.mMonth = date.getMonth();
        this.mDay = date.getDate();
        this.mHour = date.getHours();
        this.mMinute = date.getMinutes();
        aSu();
        aSt();
    }

    public void onChangeSkinType(int i) {
        this.eUj.getLayoutMode().setNightMode(i == 1);
        this.eUj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eUj.getPageContext(), i);
        this.eUm.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eUm.setText(this.eUj.getPageContext().getContext().getString(e.j.done));
            this.mNavigationBar.setTitleText(e.j.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                qk(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.eUm.setText(this.eUj.getPageContext().getContext().getString(e.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
    }

    public boolean aSy() {
        return this.eUv;
    }
}
