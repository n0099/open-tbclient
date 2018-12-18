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
    private TextWatcher dAA;
    private View eHK;
    private DatePickerDialog eRA;
    private TimePickerDialog eRB;
    private EditText eRC;
    private TextWatcher eRD;
    private boolean eRE;
    private CreateGroupActivityActivity eRs;
    private EditText eRt;
    private ImageButton eRu;
    private TextView eRv;
    private EditText eRw;
    private ImageButton eRx;
    private Button eRy;
    private Button eRz;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int mMonth;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int mYear;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eRA = null;
        this.eRB = null;
        this.mYear = 0;
        this.mMonth = 0;
        this.mDay = 0;
        this.mHour = 0;
        this.mMinute = 0;
        this.eRE = false;
        this.eRs = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(e.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eRs.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eRs.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
        this.eHK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eHK.setOnClickListener(this.eRs);
        this.eRv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eRs.getResources().getString(e.j.group_activity_create_btntext));
        this.eRv.setOnClickListener(this.eRs);
        this.eRv.setEnabled(false);
        this.eRt = (EditText) this.eRs.findViewById(e.g.txt_group_activity_name);
        this.eRu = (ImageButton) this.eRs.findViewById(e.g.btn_del_name);
        this.eRw = (EditText) this.eRs.findViewById(e.g.txt_group_activity_place);
        this.eRx = (ImageButton) this.eRs.findViewById(e.g.btn_del_place);
        this.eRC = (EditText) this.eRs.findViewById(e.g.txt_group_activity_content);
        this.eRy = (Button) this.eRs.findViewById(e.g.btn_create_group_date);
        this.eRz = (Button) this.eRs.findViewById(e.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2);
        this.mDay = calendar.get(5);
        this.mHour = calendar.get(11);
        this.mMinute = calendar.get(12);
        aRG();
        aRF();
        this.eRs.ShowSoftKeyPadDelay(this.eRt, 500);
        this.eRy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eRA == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eRs.showToast(e.j.group_activity_time_val);
                                return;
                            }
                            a.this.mYear = i;
                            a.this.mMonth = i2;
                            a.this.mDay = i3;
                            g.b(a.this.eRA, a.this.eRs.getPageContext());
                            a.this.aRG();
                            a.this.eRE = true;
                        }
                    };
                    a.this.eRA = new DatePickerDialog(a.this.eRs.getPageContext().getPageActivity(), onDateSetListener, a.this.mYear, a.this.mMonth, a.this.mDay);
                }
                a.this.eRA.updateDate(a.this.mYear, a.this.mMonth, a.this.mDay);
                g.a(a.this.eRA, a.this.eRs.getPageContext());
            }
        });
        this.eRz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eRB == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.mHour = i;
                            a.this.mMinute = i2;
                            g.b(a.this.eRB, a.this.eRs.getPageContext());
                            a.this.aRF();
                            a.this.eRE = true;
                        }
                    };
                    a.this.eRB = new TimePickerDialog(a.this.eRs.getPageContext().getPageActivity(), onTimeSetListener, a.this.mHour, a.this.mMinute, false);
                }
                a.this.eRB.updateTime(a.this.mHour, a.this.mMinute);
                g.a(a.this.eRB, a.this.eRs.getPageContext());
            }
        });
        this.eRu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eRt.setText("");
            }
        });
        this.eRx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eRw.setText("");
            }
        });
        this.dAA = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eRt.getText().length() > 0) {
                    a.this.eRu.setVisibility(0);
                    a.this.eRv.setEnabled(true);
                    return;
                }
                a.this.eRu.setVisibility(8);
                a.this.eRv.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eRt.addTextChangedListener(this.dAA);
        this.eRD = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eRw.getText().length() > 0) {
                    a.this.eRx.setVisibility(0);
                } else {
                    a.this.eRx.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eRw.addTextChangedListener(this.eRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRF() {
        if (this.mHour > 12) {
            this.eRz.setText(this.eRs.getResources().getString(e.j.afternoon) + " " + (this.mHour - 12) + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        } else {
            this.eRz.setText(this.eRs.getResources().getString(e.j.morning) + " " + this.mHour + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRG() {
        this.eRy.setText(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + ao.m(this.mYear, this.mMonth, this.mDay));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eRt.removeTextChangedListener(this.dAA);
        this.eRw.removeTextChangedListener(this.eRD);
    }

    public View aRH() {
        return this.eHK;
    }

    public TextView aRI() {
        return this.eRv;
    }

    public String getTitle() {
        return this.eRt.getText().toString();
    }

    public String aRJ() {
        return this.eRw.getText().toString();
    }

    public String getContent() {
        return this.eRC.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + this.mHour + ":" + this.mMinute).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eRt.setText(str);
    }

    public void setContent(String str) {
        this.eRC.setText(str);
    }

    public void qh(String str) {
        this.eRw.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.mYear = date.getYear() + BdDatePicker.START_YEAR;
        this.mMonth = date.getMonth();
        this.mDay = date.getDate();
        this.mHour = date.getHours();
        this.mMinute = date.getMinutes();
        aRG();
        aRF();
    }

    public void onChangeSkinType(int i) {
        this.eRs.getLayoutMode().setNightMode(i == 1);
        this.eRs.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eRs.getPageContext(), i);
        this.eRv.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eRv.setText(this.eRs.getPageContext().getContext().getString(e.j.done));
            this.mNavigationBar.setTitleText(e.j.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                qh(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.eRv.setText(this.eRs.getPageContext().getContext().getString(e.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
    }

    public boolean aRK() {
        return this.eRE;
    }
}
