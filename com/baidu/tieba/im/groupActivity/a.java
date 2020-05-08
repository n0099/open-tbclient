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
    private int ST;
    private int SU;
    private int SV;
    private int SX;
    private int cjy;
    private View idP;
    private EditText inA;
    private ImageButton inB;
    private TextView inC;
    private EditText inD;
    private ImageButton inE;
    private Button inF;
    private Button inG;
    private DatePickerDialog inH;
    private TimePickerDialog inI;
    private EditText inJ;
    private TextWatcher inK;
    private TextWatcher inL;
    private boolean inM;
    private CreateGroupActivityActivity inz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.inH = null;
        this.inI = null;
        this.ST = 0;
        this.SU = 0;
        this.SV = 0;
        this.cjy = 0;
        this.SX = 0;
        this.inM = false;
        this.inz = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.inz.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.inz.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.idP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.idP.setOnClickListener(this.inz);
        this.inC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.inz.getResources().getString(R.string.group_activity_create_btntext));
        this.inC.setOnClickListener(this.inz);
        this.inC.setEnabled(false);
        this.inA = (EditText) this.inz.findViewById(R.id.txt_group_activity_name);
        this.inB = (ImageButton) this.inz.findViewById(R.id.btn_del_name);
        this.inD = (EditText) this.inz.findViewById(R.id.txt_group_activity_place);
        this.inE = (ImageButton) this.inz.findViewById(R.id.btn_del_place);
        this.inJ = (EditText) this.inz.findViewById(R.id.txt_group_activity_content);
        this.inF = (Button) this.inz.findViewById(R.id.btn_create_group_date);
        this.inG = (Button) this.inz.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.ST = calendar.get(1);
        this.SU = calendar.get(2);
        this.SV = calendar.get(5);
        this.cjy = calendar.get(11);
        this.SX = calendar.get(12);
        cgv();
        cgu();
        this.inz.ShowSoftKeyPadDelay(this.inA, 500);
        this.inF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.inH == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.inz.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.ST = i;
                            a.this.SU = i2;
                            a.this.SV = i3;
                            g.b(a.this.inH, a.this.inz.getPageContext());
                            a.this.cgv();
                            a.this.inM = true;
                        }
                    };
                    a.this.inH = new DatePickerDialog(a.this.inz.getPageContext().getPageActivity(), onDateSetListener, a.this.ST, a.this.SU, a.this.SV);
                }
                a.this.inH.updateDate(a.this.ST, a.this.SU, a.this.SV);
                g.a(a.this.inH, a.this.inz.getPageContext());
            }
        });
        this.inG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.inI == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.cjy = i;
                            a.this.SX = i2;
                            g.b(a.this.inI, a.this.inz.getPageContext());
                            a.this.cgu();
                            a.this.inM = true;
                        }
                    };
                    a.this.inI = new TimePickerDialog(a.this.inz.getPageContext().getPageActivity(), onTimeSetListener, a.this.cjy, a.this.SX, false);
                }
                a.this.inI.updateTime(a.this.cjy, a.this.SX);
                g.a(a.this.inI, a.this.inz.getPageContext());
            }
        });
        this.inB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.inA.setText("");
            }
        });
        this.inE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.inD.setText("");
            }
        });
        this.inK = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.inA.getText().length() > 0) {
                    a.this.inB.setVisibility(0);
                    a.this.inC.setEnabled(true);
                    return;
                }
                a.this.inB.setVisibility(8);
                a.this.inC.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.inA.addTextChangedListener(this.inK);
        this.inL = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.inD.getText().length() > 0) {
                    a.this.inE.setVisibility(0);
                } else {
                    a.this.inE.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.inD.addTextChangedListener(this.inL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgu() {
        if (this.cjy > 12) {
            this.inG.setText(this.inz.getResources().getString(R.string.afternoon) + " " + (this.cjy - 12) + ":" + (this.SX < 10 ? "0" : "") + this.SX);
        } else {
            this.inG.setText(this.inz.getResources().getString(R.string.morning) + " " + this.cjy + ":" + (this.SX < 10 ? "0" : "") + this.SX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgv() {
        this.inF.setText(this.ST + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.SU + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.SV + " " + aq.getWeekString(this.ST, this.SU, this.SV));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.inA.removeTextChangedListener(this.inK);
        this.inD.removeTextChangedListener(this.inL);
    }

    public View cgw() {
        return this.idP;
    }

    public TextView cgx() {
        return this.inC;
    }

    public String getTitle() {
        return this.inA.getText().toString();
    }

    public String cgy() {
        return this.inD.getText().toString();
    }

    public String getContent() {
        return this.inJ.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.ST + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.SU + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.SV + " " + this.cjy + ":" + this.SX).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.inA.setText(str);
    }

    public void setContent(String str) {
        this.inJ.setText(str);
    }

    public void ES(String str) {
        this.inD.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.ST = date.getYear() + FeatureCodes.SKY_SEG;
        this.SU = date.getMonth();
        this.SV = date.getDate();
        this.cjy = date.getHours();
        this.SX = date.getMinutes();
        cgv();
        cgu();
    }

    public void onChangeSkinType(int i) {
        this.inz.getLayoutMode().setNightMode(i == 1);
        this.inz.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.inz.getPageContext(), i);
        this.inC.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.inC.setText(this.inz.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                ES(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.inC.setText(this.inz.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cgz() {
        return this.inM;
    }
}
