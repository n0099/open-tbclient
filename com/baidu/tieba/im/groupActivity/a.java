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
    private TextWatcher dDW;
    private View eLn;
    private CreateGroupActivityActivity eUW;
    private EditText eUX;
    private ImageButton eUY;
    private TextView eUZ;
    private EditText eVa;
    private ImageButton eVb;
    private Button eVc;
    private Button eVd;
    private DatePickerDialog eVe;
    private TimePickerDialog eVf;
    private EditText eVg;
    private TextWatcher eVh;
    private boolean eVi;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int mMonth;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int mYear;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eVe = null;
        this.eVf = null;
        this.mYear = 0;
        this.mMonth = 0;
        this.mDay = 0;
        this.mHour = 0;
        this.mMinute = 0;
        this.eVi = false;
        this.eUW = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(e.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eUW.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eUW.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
        this.eLn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eLn.setOnClickListener(this.eUW);
        this.eUZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eUW.getResources().getString(e.j.group_activity_create_btntext));
        this.eUZ.setOnClickListener(this.eUW);
        this.eUZ.setEnabled(false);
        this.eUX = (EditText) this.eUW.findViewById(e.g.txt_group_activity_name);
        this.eUY = (ImageButton) this.eUW.findViewById(e.g.btn_del_name);
        this.eVa = (EditText) this.eUW.findViewById(e.g.txt_group_activity_place);
        this.eVb = (ImageButton) this.eUW.findViewById(e.g.btn_del_place);
        this.eVg = (EditText) this.eUW.findViewById(e.g.txt_group_activity_content);
        this.eVc = (Button) this.eUW.findViewById(e.g.btn_create_group_date);
        this.eVd = (Button) this.eUW.findViewById(e.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2);
        this.mDay = calendar.get(5);
        this.mHour = calendar.get(11);
        this.mMinute = calendar.get(12);
        aSU();
        aST();
        this.eUW.ShowSoftKeyPadDelay(this.eUX, 500);
        this.eVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eVe == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eUW.showToast(e.j.group_activity_time_val);
                                return;
                            }
                            a.this.mYear = i;
                            a.this.mMonth = i2;
                            a.this.mDay = i3;
                            g.b(a.this.eVe, a.this.eUW.getPageContext());
                            a.this.aSU();
                            a.this.eVi = true;
                        }
                    };
                    a.this.eVe = new DatePickerDialog(a.this.eUW.getPageContext().getPageActivity(), onDateSetListener, a.this.mYear, a.this.mMonth, a.this.mDay);
                }
                a.this.eVe.updateDate(a.this.mYear, a.this.mMonth, a.this.mDay);
                g.a(a.this.eVe, a.this.eUW.getPageContext());
            }
        });
        this.eVd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eVf == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.mHour = i;
                            a.this.mMinute = i2;
                            g.b(a.this.eVf, a.this.eUW.getPageContext());
                            a.this.aST();
                            a.this.eVi = true;
                        }
                    };
                    a.this.eVf = new TimePickerDialog(a.this.eUW.getPageContext().getPageActivity(), onTimeSetListener, a.this.mHour, a.this.mMinute, false);
                }
                a.this.eVf.updateTime(a.this.mHour, a.this.mMinute);
                g.a(a.this.eVf, a.this.eUW.getPageContext());
            }
        });
        this.eUY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eUX.setText("");
            }
        });
        this.eVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eVa.setText("");
            }
        });
        this.dDW = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eUX.getText().length() > 0) {
                    a.this.eUY.setVisibility(0);
                    a.this.eUZ.setEnabled(true);
                    return;
                }
                a.this.eUY.setVisibility(8);
                a.this.eUZ.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eUX.addTextChangedListener(this.dDW);
        this.eVh = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eVa.getText().length() > 0) {
                    a.this.eVb.setVisibility(0);
                } else {
                    a.this.eVb.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eVa.addTextChangedListener(this.eVh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aST() {
        if (this.mHour > 12) {
            this.eVd.setText(this.eUW.getResources().getString(e.j.afternoon) + " " + (this.mHour - 12) + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        } else {
            this.eVd.setText(this.eUW.getResources().getString(e.j.morning) + " " + this.mHour + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSU() {
        this.eVc.setText(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + ao.m(this.mYear, this.mMonth, this.mDay));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eUX.removeTextChangedListener(this.dDW);
        this.eVa.removeTextChangedListener(this.eVh);
    }

    public View aSV() {
        return this.eLn;
    }

    public TextView aSW() {
        return this.eUZ;
    }

    public String getTitle() {
        return this.eUX.getText().toString();
    }

    public String aSX() {
        return this.eVa.getText().toString();
    }

    public String getContent() {
        return this.eVg.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + this.mHour + ":" + this.mMinute).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eUX.setText(str);
    }

    public void setContent(String str) {
        this.eVg.setText(str);
    }

    public void qA(String str) {
        this.eVa.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.mYear = date.getYear() + BdDatePicker.START_YEAR;
        this.mMonth = date.getMonth();
        this.mDay = date.getDate();
        this.mHour = date.getHours();
        this.mMinute = date.getMinutes();
        aSU();
        aST();
    }

    public void onChangeSkinType(int i) {
        this.eUW.getLayoutMode().setNightMode(i == 1);
        this.eUW.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eUW.getPageContext(), i);
        this.eUZ.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eUZ.setText(this.eUW.getPageContext().getContext().getString(e.j.done));
            this.mNavigationBar.setTitleText(e.j.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                qA(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.eUZ.setText(this.eUW.getPageContext().getContext().getString(e.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
    }

    public boolean aSY() {
        return this.eVi;
    }
}
