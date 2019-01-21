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
    private TextWatcher dDX;
    private View eLo;
    private CreateGroupActivityActivity eUX;
    private EditText eUY;
    private ImageButton eUZ;
    private TextView eVa;
    private EditText eVb;
    private ImageButton eVc;
    private Button eVd;
    private Button eVe;
    private DatePickerDialog eVf;
    private TimePickerDialog eVg;
    private EditText eVh;
    private TextWatcher eVi;
    private boolean eVj;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int mMonth;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int mYear;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eVf = null;
        this.eVg = null;
        this.mYear = 0;
        this.mMonth = 0;
        this.mDay = 0;
        this.mHour = 0;
        this.mMinute = 0;
        this.eVj = false;
        this.eUX = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(e.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eUX.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eUX.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
        this.eLo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eLo.setOnClickListener(this.eUX);
        this.eVa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eUX.getResources().getString(e.j.group_activity_create_btntext));
        this.eVa.setOnClickListener(this.eUX);
        this.eVa.setEnabled(false);
        this.eUY = (EditText) this.eUX.findViewById(e.g.txt_group_activity_name);
        this.eUZ = (ImageButton) this.eUX.findViewById(e.g.btn_del_name);
        this.eVb = (EditText) this.eUX.findViewById(e.g.txt_group_activity_place);
        this.eVc = (ImageButton) this.eUX.findViewById(e.g.btn_del_place);
        this.eVh = (EditText) this.eUX.findViewById(e.g.txt_group_activity_content);
        this.eVd = (Button) this.eUX.findViewById(e.g.btn_create_group_date);
        this.eVe = (Button) this.eUX.findViewById(e.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2);
        this.mDay = calendar.get(5);
        this.mHour = calendar.get(11);
        this.mMinute = calendar.get(12);
        aSU();
        aST();
        this.eUX.ShowSoftKeyPadDelay(this.eUY, 500);
        this.eVd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eVf == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eUX.showToast(e.j.group_activity_time_val);
                                return;
                            }
                            a.this.mYear = i;
                            a.this.mMonth = i2;
                            a.this.mDay = i3;
                            g.b(a.this.eVf, a.this.eUX.getPageContext());
                            a.this.aSU();
                            a.this.eVj = true;
                        }
                    };
                    a.this.eVf = new DatePickerDialog(a.this.eUX.getPageContext().getPageActivity(), onDateSetListener, a.this.mYear, a.this.mMonth, a.this.mDay);
                }
                a.this.eVf.updateDate(a.this.mYear, a.this.mMonth, a.this.mDay);
                g.a(a.this.eVf, a.this.eUX.getPageContext());
            }
        });
        this.eVe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eVg == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.mHour = i;
                            a.this.mMinute = i2;
                            g.b(a.this.eVg, a.this.eUX.getPageContext());
                            a.this.aST();
                            a.this.eVj = true;
                        }
                    };
                    a.this.eVg = new TimePickerDialog(a.this.eUX.getPageContext().getPageActivity(), onTimeSetListener, a.this.mHour, a.this.mMinute, false);
                }
                a.this.eVg.updateTime(a.this.mHour, a.this.mMinute);
                g.a(a.this.eVg, a.this.eUX.getPageContext());
            }
        });
        this.eUZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eUY.setText("");
            }
        });
        this.eVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eVb.setText("");
            }
        });
        this.dDX = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eUY.getText().length() > 0) {
                    a.this.eUZ.setVisibility(0);
                    a.this.eVa.setEnabled(true);
                    return;
                }
                a.this.eUZ.setVisibility(8);
                a.this.eVa.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eUY.addTextChangedListener(this.dDX);
        this.eVi = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eVb.getText().length() > 0) {
                    a.this.eVc.setVisibility(0);
                } else {
                    a.this.eVc.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eVb.addTextChangedListener(this.eVi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aST() {
        if (this.mHour > 12) {
            this.eVe.setText(this.eUX.getResources().getString(e.j.afternoon) + " " + (this.mHour - 12) + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        } else {
            this.eVe.setText(this.eUX.getResources().getString(e.j.morning) + " " + this.mHour + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSU() {
        this.eVd.setText(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + ao.m(this.mYear, this.mMonth, this.mDay));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eUY.removeTextChangedListener(this.dDX);
        this.eVb.removeTextChangedListener(this.eVi);
    }

    public View aSV() {
        return this.eLo;
    }

    public TextView aSW() {
        return this.eVa;
    }

    public String getTitle() {
        return this.eUY.getText().toString();
    }

    public String aSX() {
        return this.eVb.getText().toString();
    }

    public String getContent() {
        return this.eVh.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + this.mHour + ":" + this.mMinute).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eUY.setText(str);
    }

    public void setContent(String str) {
        this.eVh.setText(str);
    }

    public void qA(String str) {
        this.eVb.setText(str);
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
        this.eUX.getLayoutMode().setNightMode(i == 1);
        this.eUX.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eUX.getPageContext(), i);
        this.eVa.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eVa.setText(this.eUX.getPageContext().getContext().getString(e.j.done));
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
        this.eVa.setText(this.eUX.getPageContext().getContext().getString(e.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
    }

    public boolean aSY() {
        return this.eVj;
    }
}
