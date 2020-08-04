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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes17.dex */
public class a extends c<BaseFragmentActivity> {
    private int TA;
    private int TB;
    private int TC;
    private int TF;
    private int cCx;
    private View iQy;
    private CreateGroupActivityActivity jci;
    private EditText jcj;
    private ImageButton jck;
    private TextView jcl;
    private EditText jcm;
    private ImageButton jcn;
    private Button jco;
    private Button jcp;
    private DatePickerDialog jcq;
    private TimePickerDialog jcr;
    private EditText jcs;
    private TextWatcher jct;
    private TextWatcher jcu;
    private boolean jcv;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.jcq = null;
        this.jcr = null;
        this.TA = 0;
        this.TB = 0;
        this.TC = 0;
        this.cCx = 0;
        this.TF = 0;
        this.jcv = false;
        this.jci = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.jci.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jci.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.iQy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iQy.setOnClickListener(this.jci);
        this.jcl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jci.getResources().getString(R.string.group_activity_create_btntext));
        this.jcl.setOnClickListener(this.jci);
        this.jcl.setEnabled(false);
        this.jcj = (EditText) this.jci.findViewById(R.id.txt_group_activity_name);
        this.jck = (ImageButton) this.jci.findViewById(R.id.btn_del_name);
        this.jcm = (EditText) this.jci.findViewById(R.id.txt_group_activity_place);
        this.jcn = (ImageButton) this.jci.findViewById(R.id.btn_del_place);
        this.jcs = (EditText) this.jci.findViewById(R.id.txt_group_activity_content);
        this.jco = (Button) this.jci.findViewById(R.id.btn_create_group_date);
        this.jcp = (Button) this.jci.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.TA = calendar.get(1);
        this.TB = calendar.get(2);
        this.TC = calendar.get(5);
        this.cCx = calendar.get(11);
        this.TF = calendar.get(12);
        cuQ();
        cuP();
        this.jci.ShowSoftKeyPadDelay(this.jcj, 500);
        this.jco.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jcq == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.jci.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.TA = i;
                            a.this.TB = i2;
                            a.this.TC = i3;
                            g.b(a.this.jcq, a.this.jci.getPageContext());
                            a.this.cuQ();
                            a.this.jcv = true;
                        }
                    };
                    a.this.jcq = new DatePickerDialog(a.this.jci.getPageContext().getPageActivity(), onDateSetListener, a.this.TA, a.this.TB, a.this.TC);
                }
                a.this.jcq.updateDate(a.this.TA, a.this.TB, a.this.TC);
                g.a(a.this.jcq, a.this.jci.getPageContext());
            }
        });
        this.jcp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jcr == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.cCx = i;
                            a.this.TF = i2;
                            g.b(a.this.jcr, a.this.jci.getPageContext());
                            a.this.cuP();
                            a.this.jcv = true;
                        }
                    };
                    a.this.jcr = new TimePickerDialog(a.this.jci.getPageContext().getPageActivity(), onTimeSetListener, a.this.cCx, a.this.TF, false);
                }
                a.this.jcr.updateTime(a.this.cCx, a.this.TF);
                g.a(a.this.jcr, a.this.jci.getPageContext());
            }
        });
        this.jck.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jcj.setText("");
            }
        });
        this.jcn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jcm.setText("");
            }
        });
        this.jct = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jcj.getText().length() > 0) {
                    a.this.jck.setVisibility(0);
                    a.this.jcl.setEnabled(true);
                    return;
                }
                a.this.jck.setVisibility(8);
                a.this.jcl.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jcj.addTextChangedListener(this.jct);
        this.jcu = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jcm.getText().length() > 0) {
                    a.this.jcn.setVisibility(0);
                } else {
                    a.this.jcn.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jcm.addTextChangedListener(this.jcu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuP() {
        if (this.cCx > 12) {
            this.jcp.setText(this.jci.getResources().getString(R.string.afternoon) + " " + (this.cCx - 12) + ":" + (this.TF < 10 ? "0" : "") + this.TF);
        } else {
            this.jcp.setText(this.jci.getResources().getString(R.string.morning) + " " + this.cCx + ":" + (this.TF < 10 ? "0" : "") + this.TF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuQ() {
        this.jco.setText(this.TA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.TB + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.TC + " " + as.getWeekString(this.TA, this.TB, this.TC));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.jcj.removeTextChangedListener(this.jct);
        this.jcm.removeTextChangedListener(this.jcu);
    }

    public View cuR() {
        return this.iQy;
    }

    public TextView cuS() {
        return this.jcl;
    }

    public String getTitle() {
        return this.jcj.getText().toString();
    }

    public String cuT() {
        return this.jcm.getText().toString();
    }

    public String getContent() {
        return this.jcs.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.TA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.TB + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.TC + " " + this.cCx + ":" + this.TF).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.jcj.setText(str);
    }

    public void setContent(String str) {
        this.jcs.setText(str);
    }

    public void HS(String str) {
        this.jcm.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.TA = date.getYear() + FeatureCodes.SKY_SEG;
        this.TB = date.getMonth();
        this.TC = date.getDate();
        this.cCx = date.getHours();
        this.TF = date.getMinutes();
        cuQ();
        cuP();
    }

    public void onChangeSkinType(int i) {
        this.jci.getLayoutMode().setNightMode(i == 1);
        this.jci.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jci.getPageContext(), i);
        this.jcl.setTextColor(ao.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.jcl.setText(this.jci.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                HS(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.jcl.setText(this.jci.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cuU() {
        return this.jcv;
    }
}
