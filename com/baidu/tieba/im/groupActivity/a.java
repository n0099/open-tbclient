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
    private TextWatcher dub;
    private View eAV;
    private CreateGroupActivityActivity eKD;
    private EditText eKE;
    private ImageButton eKF;
    private TextView eKG;
    private EditText eKH;
    private ImageButton eKI;
    private Button eKJ;
    private Button eKK;
    private DatePickerDialog eKL;
    private TimePickerDialog eKM;
    private EditText eKN;
    private TextWatcher eKO;
    private boolean eKP;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int mMonth;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int mYear;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eKL = null;
        this.eKM = null;
        this.mYear = 0;
        this.mMonth = 0;
        this.mDay = 0;
        this.mHour = 0;
        this.mMinute = 0;
        this.eKP = false;
        this.eKD = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(e.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eKD.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eKD.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
        this.eAV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eAV.setOnClickListener(this.eKD);
        this.eKG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eKD.getResources().getString(e.j.group_activity_create_btntext));
        this.eKG.setOnClickListener(this.eKD);
        this.eKG.setEnabled(false);
        this.eKE = (EditText) this.eKD.findViewById(e.g.txt_group_activity_name);
        this.eKF = (ImageButton) this.eKD.findViewById(e.g.btn_del_name);
        this.eKH = (EditText) this.eKD.findViewById(e.g.txt_group_activity_place);
        this.eKI = (ImageButton) this.eKD.findViewById(e.g.btn_del_place);
        this.eKN = (EditText) this.eKD.findViewById(e.g.txt_group_activity_content);
        this.eKJ = (Button) this.eKD.findViewById(e.g.btn_create_group_date);
        this.eKK = (Button) this.eKD.findViewById(e.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2);
        this.mDay = calendar.get(5);
        this.mHour = calendar.get(11);
        this.mMinute = calendar.get(12);
        aPP();
        aPO();
        this.eKD.ShowSoftKeyPadDelay(this.eKE, 500);
        this.eKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eKL == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eKD.showToast(e.j.group_activity_time_val);
                                return;
                            }
                            a.this.mYear = i;
                            a.this.mMonth = i2;
                            a.this.mDay = i3;
                            g.b(a.this.eKL, a.this.eKD.getPageContext());
                            a.this.aPP();
                            a.this.eKP = true;
                        }
                    };
                    a.this.eKL = new DatePickerDialog(a.this.eKD.getPageContext().getPageActivity(), onDateSetListener, a.this.mYear, a.this.mMonth, a.this.mDay);
                }
                a.this.eKL.updateDate(a.this.mYear, a.this.mMonth, a.this.mDay);
                g.a(a.this.eKL, a.this.eKD.getPageContext());
            }
        });
        this.eKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eKM == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.mHour = i;
                            a.this.mMinute = i2;
                            g.b(a.this.eKM, a.this.eKD.getPageContext());
                            a.this.aPO();
                            a.this.eKP = true;
                        }
                    };
                    a.this.eKM = new TimePickerDialog(a.this.eKD.getPageContext().getPageActivity(), onTimeSetListener, a.this.mHour, a.this.mMinute, false);
                }
                a.this.eKM.updateTime(a.this.mHour, a.this.mMinute);
                g.a(a.this.eKM, a.this.eKD.getPageContext());
            }
        });
        this.eKF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eKE.setText("");
            }
        });
        this.eKI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eKH.setText("");
            }
        });
        this.dub = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eKE.getText().length() > 0) {
                    a.this.eKF.setVisibility(0);
                    a.this.eKG.setEnabled(true);
                    return;
                }
                a.this.eKF.setVisibility(8);
                a.this.eKG.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eKE.addTextChangedListener(this.dub);
        this.eKO = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eKH.getText().length() > 0) {
                    a.this.eKI.setVisibility(0);
                } else {
                    a.this.eKI.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eKH.addTextChangedListener(this.eKO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPO() {
        if (this.mHour > 12) {
            this.eKK.setText(this.eKD.getResources().getString(e.j.afternoon) + " " + (this.mHour - 12) + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        } else {
            this.eKK.setText(this.eKD.getResources().getString(e.j.morning) + " " + this.mHour + ":" + (this.mMinute < 10 ? "0" : "") + this.mMinute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPP() {
        this.eKJ.setText(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + ao.m(this.mYear, this.mMonth, this.mDay));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eKE.removeTextChangedListener(this.dub);
        this.eKH.removeTextChangedListener(this.eKO);
    }

    public View aPQ() {
        return this.eAV;
    }

    public TextView aPR() {
        return this.eKG;
    }

    public String getTitle() {
        return this.eKE.getText().toString();
    }

    public String aPS() {
        return this.eKH.getText().toString();
    }

    public String getContent() {
        return this.eKN.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mMonth + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + this.mHour + ":" + this.mMinute).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eKE.setText(str);
    }

    public void setContent(String str) {
        this.eKN.setText(str);
    }

    public void pF(String str) {
        this.eKH.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.mYear = date.getYear() + BdDatePicker.START_YEAR;
        this.mMonth = date.getMonth();
        this.mDay = date.getDate();
        this.mHour = date.getHours();
        this.mMinute = date.getMinutes();
        aPP();
        aPO();
    }

    public void onChangeSkinType(int i) {
        this.eKD.getLayoutMode().setNightMode(i == 1);
        this.eKD.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eKD.getPageContext(), i);
        this.eKG.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eKG.setText(this.eKD.getPageContext().getContext().getString(e.j.done));
            this.mNavigationBar.setTitleText(e.j.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                pF(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.eKG.setText(this.eKD.getPageContext().getContext().getString(e.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
    }

    public boolean aPT() {
        return this.eKP;
    }
}
