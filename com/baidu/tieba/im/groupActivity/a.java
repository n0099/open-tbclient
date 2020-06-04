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
/* loaded from: classes10.dex */
public class a extends c<BaseFragmentActivity> {
    private int Te;
    private int Tf;
    private int Tg;
    private int Ti;
    private int cvc;
    private CreateGroupActivityActivity iCS;
    private EditText iCT;
    private ImageButton iCU;
    private TextView iCV;
    private EditText iCW;
    private ImageButton iCX;
    private Button iCY;
    private Button iCZ;
    private DatePickerDialog iDa;
    private TimePickerDialog iDb;
    private EditText iDc;
    private TextWatcher iDd;
    private TextWatcher iDe;
    private boolean iDf;
    private View itl;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.iDa = null;
        this.iDb = null;
        this.Te = 0;
        this.Tf = 0;
        this.Tg = 0;
        this.cvc = 0;
        this.Ti = 0;
        this.iDf = false;
        this.iCS = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.iCS.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.iCS.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.itl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.itl.setOnClickListener(this.iCS);
        this.iCV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iCS.getResources().getString(R.string.group_activity_create_btntext));
        this.iCV.setOnClickListener(this.iCS);
        this.iCV.setEnabled(false);
        this.iCT = (EditText) this.iCS.findViewById(R.id.txt_group_activity_name);
        this.iCU = (ImageButton) this.iCS.findViewById(R.id.btn_del_name);
        this.iCW = (EditText) this.iCS.findViewById(R.id.txt_group_activity_place);
        this.iCX = (ImageButton) this.iCS.findViewById(R.id.btn_del_place);
        this.iDc = (EditText) this.iCS.findViewById(R.id.txt_group_activity_content);
        this.iCY = (Button) this.iCS.findViewById(R.id.btn_create_group_date);
        this.iCZ = (Button) this.iCS.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Te = calendar.get(1);
        this.Tf = calendar.get(2);
        this.Tg = calendar.get(5);
        this.cvc = calendar.get(11);
        this.Ti = calendar.get(12);
        cnc();
        cnb();
        this.iCS.ShowSoftKeyPadDelay(this.iCT, 500);
        this.iCY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iDa == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.iCS.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.Te = i;
                            a.this.Tf = i2;
                            a.this.Tg = i3;
                            g.b(a.this.iDa, a.this.iCS.getPageContext());
                            a.this.cnc();
                            a.this.iDf = true;
                        }
                    };
                    a.this.iDa = new DatePickerDialog(a.this.iCS.getPageContext().getPageActivity(), onDateSetListener, a.this.Te, a.this.Tf, a.this.Tg);
                }
                a.this.iDa.updateDate(a.this.Te, a.this.Tf, a.this.Tg);
                g.a(a.this.iDa, a.this.iCS.getPageContext());
            }
        });
        this.iCZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iDb == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.cvc = i;
                            a.this.Ti = i2;
                            g.b(a.this.iDb, a.this.iCS.getPageContext());
                            a.this.cnb();
                            a.this.iDf = true;
                        }
                    };
                    a.this.iDb = new TimePickerDialog(a.this.iCS.getPageContext().getPageActivity(), onTimeSetListener, a.this.cvc, a.this.Ti, false);
                }
                a.this.iDb.updateTime(a.this.cvc, a.this.Ti);
                g.a(a.this.iDb, a.this.iCS.getPageContext());
            }
        });
        this.iCU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iCT.setText("");
            }
        });
        this.iCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iCW.setText("");
            }
        });
        this.iDd = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.iCT.getText().length() > 0) {
                    a.this.iCU.setVisibility(0);
                    a.this.iCV.setEnabled(true);
                    return;
                }
                a.this.iCU.setVisibility(8);
                a.this.iCV.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.iCT.addTextChangedListener(this.iDd);
        this.iDe = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.iCW.getText().length() > 0) {
                    a.this.iCX.setVisibility(0);
                } else {
                    a.this.iCX.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.iCW.addTextChangedListener(this.iDe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnb() {
        if (this.cvc > 12) {
            this.iCZ.setText(this.iCS.getResources().getString(R.string.afternoon) + " " + (this.cvc - 12) + ":" + (this.Ti < 10 ? "0" : "") + this.Ti);
        } else {
            this.iCZ.setText(this.iCS.getResources().getString(R.string.morning) + " " + this.cvc + ":" + (this.Ti < 10 ? "0" : "") + this.Ti);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnc() {
        this.iCY.setText(this.Te + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Tf + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tg + " " + aq.getWeekString(this.Te, this.Tf, this.Tg));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.iCT.removeTextChangedListener(this.iDd);
        this.iCW.removeTextChangedListener(this.iDe);
    }

    public View cnd() {
        return this.itl;
    }

    public TextView cne() {
        return this.iCV;
    }

    public String getTitle() {
        return this.iCT.getText().toString();
    }

    public String cnf() {
        return this.iCW.getText().toString();
    }

    public String getContent() {
        return this.iDc.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Te + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Tf + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tg + " " + this.cvc + ":" + this.Ti).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.iCT.setText(str);
    }

    public void setContent(String str) {
        this.iDc.setText(str);
    }

    public void GB(String str) {
        this.iCW.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Te = date.getYear() + FeatureCodes.SKY_SEG;
        this.Tf = date.getMonth();
        this.Tg = date.getDate();
        this.cvc = date.getHours();
        this.Ti = date.getMinutes();
        cnc();
        cnb();
    }

    public void onChangeSkinType(int i) {
        this.iCS.getLayoutMode().setNightMode(i == 1);
        this.iCS.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iCS.getPageContext(), i);
        this.iCV.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.iCV.setText(this.iCS.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                GB(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.iCV.setText(this.iCS.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cng() {
        return this.iDf;
    }
}
