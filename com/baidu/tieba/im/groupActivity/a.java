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
    private int UR;
    private int US;
    private int UT;
    private int UV;
    private int dno;
    private View jVA;
    private CreateGroupActivityActivity khj;
    private EditText khk;
    private ImageButton khl;
    private TextView khm;
    private EditText khn;
    private ImageButton kho;
    private Button khp;
    private Button khq;
    private DatePickerDialog khr;
    private TimePickerDialog khs;
    private EditText kht;
    private TextWatcher khu;
    private TextWatcher khv;
    private boolean khw;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.khr = null;
        this.khs = null;
        this.UR = 0;
        this.US = 0;
        this.UT = 0;
        this.dno = 0;
        this.UV = 0;
        this.khw = false;
        this.khj = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.khj.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.khj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.jVA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jVA.setOnClickListener(this.khj);
        this.khm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.khj.getResources().getString(R.string.group_activity_create_btntext));
        this.khm.setOnClickListener(this.khj);
        this.khm.setEnabled(false);
        this.khk = (EditText) this.khj.findViewById(R.id.txt_group_activity_name);
        this.khl = (ImageButton) this.khj.findViewById(R.id.btn_del_name);
        this.khn = (EditText) this.khj.findViewById(R.id.txt_group_activity_place);
        this.kho = (ImageButton) this.khj.findViewById(R.id.btn_del_place);
        this.kht = (EditText) this.khj.findViewById(R.id.txt_group_activity_content);
        this.khp = (Button) this.khj.findViewById(R.id.btn_create_group_date);
        this.khq = (Button) this.khj.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.UR = calendar.get(1);
        this.US = calendar.get(2);
        this.UT = calendar.get(5);
        this.dno = calendar.get(11);
        this.UV = calendar.get(12);
        cSF();
        cSE();
        this.khj.ShowSoftKeyPadDelay(this.khk, 500);
        this.khp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.khr == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.khj.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.UR = i;
                            a.this.US = i2;
                            a.this.UT = i3;
                            g.b(a.this.khr, a.this.khj.getPageContext());
                            a.this.cSF();
                            a.this.khw = true;
                        }
                    };
                    a.this.khr = new DatePickerDialog(a.this.khj.getPageContext().getPageActivity(), onDateSetListener, a.this.UR, a.this.US, a.this.UT);
                }
                a.this.khr.updateDate(a.this.UR, a.this.US, a.this.UT);
                g.a(a.this.khr, a.this.khj.getPageContext());
            }
        });
        this.khq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.khs == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.dno = i;
                            a.this.UV = i2;
                            g.b(a.this.khs, a.this.khj.getPageContext());
                            a.this.cSE();
                            a.this.khw = true;
                        }
                    };
                    a.this.khs = new TimePickerDialog(a.this.khj.getPageContext().getPageActivity(), onTimeSetListener, a.this.dno, a.this.UV, false);
                }
                a.this.khs.updateTime(a.this.dno, a.this.UV);
                g.a(a.this.khs, a.this.khj.getPageContext());
            }
        });
        this.khl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.khk.setText("");
            }
        });
        this.kho.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.khn.setText("");
            }
        });
        this.khu = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.khk.getText().length() > 0) {
                    a.this.khl.setVisibility(0);
                    a.this.khm.setEnabled(true);
                    return;
                }
                a.this.khl.setVisibility(8);
                a.this.khm.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.khk.addTextChangedListener(this.khu);
        this.khv = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.khn.getText().length() > 0) {
                    a.this.kho.setVisibility(0);
                } else {
                    a.this.kho.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.khn.addTextChangedListener(this.khv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSE() {
        if (this.dno > 12) {
            this.khq.setText(this.khj.getResources().getString(R.string.afternoon) + " " + (this.dno - 12) + ":" + (this.UV < 10 ? "0" : "") + this.UV);
        } else {
            this.khq.setText(this.khj.getResources().getString(R.string.morning) + " " + this.dno + ":" + (this.UV < 10 ? "0" : "") + this.UV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSF() {
        this.khp.setText(this.UR + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.US + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UT + " " + at.getWeekString(this.UR, this.US, this.UT));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.khk.removeTextChangedListener(this.khu);
        this.khn.removeTextChangedListener(this.khv);
    }

    public View cSG() {
        return this.jVA;
    }

    public TextView cSH() {
        return this.khm;
    }

    public String getTitle() {
        return this.khk.getText().toString();
    }

    public String cSI() {
        return this.khn.getText().toString();
    }

    public String getContent() {
        return this.kht.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.UR + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.US + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UT + " " + this.dno + ":" + this.UV).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.khk.setText(str);
    }

    public void setContent(String str) {
        this.kht.setText(str);
    }

    public void MR(String str) {
        this.khn.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.UR = date.getYear() + FeatureCodes.SKY_SEG;
        this.US = date.getMonth();
        this.UT = date.getDate();
        this.dno = date.getHours();
        this.UV = date.getMinutes();
        cSF();
        cSE();
    }

    public void onChangeSkinType(int i) {
        this.khj.getLayoutMode().setNightMode(i == 1);
        this.khj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.khj.getPageContext(), i);
        this.khm.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.khm.setText(this.khj.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                MR(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.khm.setText(this.khj.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cSJ() {
        return this.khw;
    }
}
