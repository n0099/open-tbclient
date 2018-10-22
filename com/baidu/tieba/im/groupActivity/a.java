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
    private TextWatcher dsU;
    private CreateGroupActivityActivity eJl;
    private EditText eJm;
    private ImageButton eJn;
    private TextView eJo;
    private EditText eJp;
    private ImageButton eJq;
    private Button eJr;
    private Button eJs;
    private DatePickerDialog eJt;
    private TimePickerDialog eJu;
    private EditText eJv;
    private TextWatcher eJw;
    private boolean eJx;
    private View ezC;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int mMonth;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int mYear;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eJt = null;
        this.eJu = null;
        this.mYear = 0;
        this.mMonth = 0;
        this.mDay = 0;
        this.mHour = 0;
        this.mMinute = 0;
        this.eJx = false;
        this.eJl = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(e.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eJl.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eJl.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
        this.ezC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ezC.setOnClickListener(this.eJl);
        this.eJo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eJl.getResources().getString(e.j.group_activity_create_btntext));
        this.eJo.setOnClickListener(this.eJl);
        this.eJo.setEnabled(false);
        this.eJm = (EditText) this.eJl.findViewById(e.g.txt_group_activity_name);
        this.eJn = (ImageButton) this.eJl.findViewById(e.g.btn_del_name);
        this.eJp = (EditText) this.eJl.findViewById(e.g.txt_group_activity_place);
        this.eJq = (ImageButton) this.eJl.findViewById(e.g.btn_del_place);
        this.eJv = (EditText) this.eJl.findViewById(e.g.txt_group_activity_content);
        this.eJr = (Button) this.eJl.findViewById(e.g.btn_create_group_date);
        this.eJs = (Button) this.eJl.findViewById(e.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2);
        this.mDay = calendar.get(5);
        this.mHour = calendar.get(11);
        this.mMinute = calendar.get(12);
        aQs();
        aQr();
        this.eJl.ShowSoftKeyPadDelay(this.eJm, 500);
        this.eJr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eJt == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eJl.showToast(e.j.group_activity_time_val);
                                return;
                            }
                            a.this.mYear = i;
                            a.this.mMonth = i2;
                            a.this.mDay = i3;
                            g.b(a.this.eJt, a.this.eJl.getPageContext());
                            a.this.aQs();
                            a.this.eJx = true;
                        }
                    };
                    a.this.eJt = new DatePickerDialog(a.this.eJl.getPageContext().getPageActivity(), onDateSetListener, a.this.mYear, a.this.mMonth, a.this.mDay);
                }
                a.this.eJt.updateDate(a.this.mYear, a.this.mMonth, a.this.mDay);
                g.a(a.this.eJt, a.this.eJl.getPageContext());
            }
        });
        this.eJs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eJu == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.mHour = i;
                            a.this.mMinute = i2;
                            g.b(a.this.eJu, a.this.eJl.getPageContext());
                            a.this.aQr();
                            a.this.eJx = true;
                        }
                    };
                    a.this.eJu = new TimePickerDialog(a.this.eJl.getPageContext().getPageActivity(), onTimeSetListener, a.this.mHour, a.this.mMinute, false);
                }
                a.this.eJu.updateTime(a.this.mHour, a.this.mMinute);
                g.a(a.this.eJu, a.this.eJl.getPageContext());
            }
        });
        this.eJn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eJm.setText("");
            }
        });
        this.eJq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eJp.setText("");
            }
        });
        this.dsU = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eJm.getText().length() > 0) {
                    a.this.eJn.setVisibility(0);
                    a.this.eJo.setEnabled(true);
                    return;
                }
                a.this.eJn.setVisibility(8);
                a.this.eJo.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eJm.addTextChangedListener(this.dsU);
        this.eJw = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eJp.getText().length() > 0) {
                    a.this.eJq.setVisibility(0);
                } else {
                    a.this.eJq.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eJp.addTextChangedListener(this.eJw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQr() {
        if (this.mHour > 12) {
            this.eJs.setText(this.eJl.getResources().getString(e.j.afternoon) + " " + (this.mHour - 12) + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        } else {
            this.eJs.setText(this.eJl.getResources().getString(e.j.morning) + " " + this.mHour + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQs() {
        this.eJr.setText(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + ao.m(this.mYear, this.mMonth, this.mDay));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eJm.removeTextChangedListener(this.dsU);
        this.eJp.removeTextChangedListener(this.eJw);
    }

    public View aQt() {
        return this.ezC;
    }

    public TextView aQu() {
        return this.eJo;
    }

    public String getTitle() {
        return this.eJm.getText().toString();
    }

    public String aQv() {
        return this.eJp.getText().toString();
    }

    public String getContent() {
        return this.eJv.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + this.mHour + ":" + this.mMinute).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eJm.setText(str);
    }

    public void setContent(String str) {
        this.eJv.setText(str);
    }

    public void pE(String str) {
        this.eJp.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.mYear = date.getYear() + BdDatePicker.START_YEAR;
        this.mMonth = date.getMonth();
        this.mDay = date.getDate();
        this.mHour = date.getHours();
        this.mMinute = date.getMinutes();
        aQs();
        aQr();
    }

    public void onChangeSkinType(int i) {
        this.eJl.getLayoutMode().setNightMode(i == 1);
        this.eJl.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eJl.getPageContext(), i);
        this.eJo.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eJo.setText(this.eJl.getPageContext().getContext().getString(e.j.done));
            this.mNavigationBar.setTitleText(e.j.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                pE(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.eJo.setText(this.eJl.getPageContext().getContext().getString(e.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
    }

    public boolean aQw() {
        return this.eJx;
    }
}
