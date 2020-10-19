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
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes23.dex */
public class a extends c<BaseFragmentActivity> {
    private int UQ;
    private int UR;
    private int US;
    private int UU;
    private int cYS;
    private View jDe;
    private CreateGroupActivityActivity jON;
    private EditText jOO;
    private ImageButton jOP;
    private TextView jOQ;
    private EditText jOR;
    private ImageButton jOS;
    private Button jOT;
    private Button jOU;
    private DatePickerDialog jOV;
    private TimePickerDialog jOW;
    private EditText jOX;
    private TextWatcher jOY;
    private TextWatcher jOZ;
    private boolean jPa;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.jOV = null;
        this.jOW = null;
        this.UQ = 0;
        this.UR = 0;
        this.US = 0;
        this.cYS = 0;
        this.UU = 0;
        this.jPa = false;
        this.jON = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.jON.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jON.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.jDe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jDe.setOnClickListener(this.jON);
        this.jOQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jON.getResources().getString(R.string.group_activity_create_btntext));
        this.jOQ.setOnClickListener(this.jON);
        this.jOQ.setEnabled(false);
        this.jOO = (EditText) this.jON.findViewById(R.id.txt_group_activity_name);
        this.jOP = (ImageButton) this.jON.findViewById(R.id.btn_del_name);
        this.jOR = (EditText) this.jON.findViewById(R.id.txt_group_activity_place);
        this.jOS = (ImageButton) this.jON.findViewById(R.id.btn_del_place);
        this.jOX = (EditText) this.jON.findViewById(R.id.txt_group_activity_content);
        this.jOT = (Button) this.jON.findViewById(R.id.btn_create_group_date);
        this.jOU = (Button) this.jON.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.UQ = calendar.get(1);
        this.UR = calendar.get(2);
        this.US = calendar.get(5);
        this.cYS = calendar.get(11);
        this.UU = calendar.get(12);
        cMX();
        cMW();
        this.jON.ShowSoftKeyPadDelay(this.jOO, 500);
        this.jOT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jOV == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.jON.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.UQ = i;
                            a.this.UR = i2;
                            a.this.US = i3;
                            g.b(a.this.jOV, a.this.jON.getPageContext());
                            a.this.cMX();
                            a.this.jPa = true;
                        }
                    };
                    a.this.jOV = new DatePickerDialog(a.this.jON.getPageContext().getPageActivity(), onDateSetListener, a.this.UQ, a.this.UR, a.this.US);
                }
                a.this.jOV.updateDate(a.this.UQ, a.this.UR, a.this.US);
                g.a(a.this.jOV, a.this.jON.getPageContext());
            }
        });
        this.jOU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jOW == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.cYS = i;
                            a.this.UU = i2;
                            g.b(a.this.jOW, a.this.jON.getPageContext());
                            a.this.cMW();
                            a.this.jPa = true;
                        }
                    };
                    a.this.jOW = new TimePickerDialog(a.this.jON.getPageContext().getPageActivity(), onTimeSetListener, a.this.cYS, a.this.UU, false);
                }
                a.this.jOW.updateTime(a.this.cYS, a.this.UU);
                g.a(a.this.jOW, a.this.jON.getPageContext());
            }
        });
        this.jOP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jOO.setText("");
            }
        });
        this.jOS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jOR.setText("");
            }
        });
        this.jOY = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jOO.getText().length() > 0) {
                    a.this.jOP.setVisibility(0);
                    a.this.jOQ.setEnabled(true);
                    return;
                }
                a.this.jOP.setVisibility(8);
                a.this.jOQ.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jOO.addTextChangedListener(this.jOY);
        this.jOZ = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jOR.getText().length() > 0) {
                    a.this.jOS.setVisibility(0);
                } else {
                    a.this.jOS.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jOR.addTextChangedListener(this.jOZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMW() {
        if (this.cYS > 12) {
            this.jOU.setText(this.jON.getResources().getString(R.string.afternoon) + " " + (this.cYS - 12) + ":" + (this.UU < 10 ? "0" : "") + this.UU);
        } else {
            this.jOU.setText(this.jON.getResources().getString(R.string.morning) + " " + this.cYS + ":" + (this.UU < 10 ? "0" : "") + this.UU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMX() {
        this.jOT.setText(this.UQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.UR + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.US + " " + at.getWeekString(this.UQ, this.UR, this.US));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.jOO.removeTextChangedListener(this.jOY);
        this.jOR.removeTextChangedListener(this.jOZ);
    }

    public View cMY() {
        return this.jDe;
    }

    public TextView cMZ() {
        return this.jOQ;
    }

    public String getTitle() {
        return this.jOO.getText().toString();
    }

    public String cNa() {
        return this.jOR.getText().toString();
    }

    public String getContent() {
        return this.jOX.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.UQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.UR + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.US + " " + this.cYS + ":" + this.UU).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.jOO.setText(str);
    }

    public void setContent(String str) {
        this.jOX.setText(str);
    }

    public void Mc(String str) {
        this.jOR.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.UQ = date.getYear() + FeatureCodes.SKY_SEG;
        this.UR = date.getMonth();
        this.US = date.getDate();
        this.cYS = date.getHours();
        this.UU = date.getMinutes();
        cMX();
        cMW();
    }

    public void onChangeSkinType(int i) {
        this.jON.getLayoutMode().setNightMode(i == 1);
        this.jON.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jON.getPageContext(), i);
        this.jOQ.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.jOQ.setText(this.jON.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                Mc(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.jOQ.setText(this.jON.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cNb() {
        return this.jPa;
    }
}
