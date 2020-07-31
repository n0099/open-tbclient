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
    private View iQw;
    private CreateGroupActivityActivity jcg;
    private EditText jch;
    private ImageButton jci;
    private TextView jcj;
    private EditText jck;
    private ImageButton jcl;
    private Button jcm;
    private Button jcn;
    private DatePickerDialog jco;
    private TimePickerDialog jcp;
    private EditText jcq;
    private TextWatcher jcr;
    private TextWatcher jcs;
    private boolean jct;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.jco = null;
        this.jcp = null;
        this.TA = 0;
        this.TB = 0;
        this.TC = 0;
        this.cCx = 0;
        this.TF = 0;
        this.jct = false;
        this.jcg = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.jcg.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jcg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.iQw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iQw.setOnClickListener(this.jcg);
        this.jcj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jcg.getResources().getString(R.string.group_activity_create_btntext));
        this.jcj.setOnClickListener(this.jcg);
        this.jcj.setEnabled(false);
        this.jch = (EditText) this.jcg.findViewById(R.id.txt_group_activity_name);
        this.jci = (ImageButton) this.jcg.findViewById(R.id.btn_del_name);
        this.jck = (EditText) this.jcg.findViewById(R.id.txt_group_activity_place);
        this.jcl = (ImageButton) this.jcg.findViewById(R.id.btn_del_place);
        this.jcq = (EditText) this.jcg.findViewById(R.id.txt_group_activity_content);
        this.jcm = (Button) this.jcg.findViewById(R.id.btn_create_group_date);
        this.jcn = (Button) this.jcg.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.TA = calendar.get(1);
        this.TB = calendar.get(2);
        this.TC = calendar.get(5);
        this.cCx = calendar.get(11);
        this.TF = calendar.get(12);
        cuQ();
        cuP();
        this.jcg.ShowSoftKeyPadDelay(this.jch, 500);
        this.jcm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jco == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.jcg.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.TA = i;
                            a.this.TB = i2;
                            a.this.TC = i3;
                            g.b(a.this.jco, a.this.jcg.getPageContext());
                            a.this.cuQ();
                            a.this.jct = true;
                        }
                    };
                    a.this.jco = new DatePickerDialog(a.this.jcg.getPageContext().getPageActivity(), onDateSetListener, a.this.TA, a.this.TB, a.this.TC);
                }
                a.this.jco.updateDate(a.this.TA, a.this.TB, a.this.TC);
                g.a(a.this.jco, a.this.jcg.getPageContext());
            }
        });
        this.jcn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jcp == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.cCx = i;
                            a.this.TF = i2;
                            g.b(a.this.jcp, a.this.jcg.getPageContext());
                            a.this.cuP();
                            a.this.jct = true;
                        }
                    };
                    a.this.jcp = new TimePickerDialog(a.this.jcg.getPageContext().getPageActivity(), onTimeSetListener, a.this.cCx, a.this.TF, false);
                }
                a.this.jcp.updateTime(a.this.cCx, a.this.TF);
                g.a(a.this.jcp, a.this.jcg.getPageContext());
            }
        });
        this.jci.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jch.setText("");
            }
        });
        this.jcl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jck.setText("");
            }
        });
        this.jcr = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jch.getText().length() > 0) {
                    a.this.jci.setVisibility(0);
                    a.this.jcj.setEnabled(true);
                    return;
                }
                a.this.jci.setVisibility(8);
                a.this.jcj.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jch.addTextChangedListener(this.jcr);
        this.jcs = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jck.getText().length() > 0) {
                    a.this.jcl.setVisibility(0);
                } else {
                    a.this.jcl.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jck.addTextChangedListener(this.jcs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuP() {
        if (this.cCx > 12) {
            this.jcn.setText(this.jcg.getResources().getString(R.string.afternoon) + " " + (this.cCx - 12) + ":" + (this.TF < 10 ? "0" : "") + this.TF);
        } else {
            this.jcn.setText(this.jcg.getResources().getString(R.string.morning) + " " + this.cCx + ":" + (this.TF < 10 ? "0" : "") + this.TF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuQ() {
        this.jcm.setText(this.TA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.TB + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.TC + " " + as.getWeekString(this.TA, this.TB, this.TC));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.jch.removeTextChangedListener(this.jcr);
        this.jck.removeTextChangedListener(this.jcs);
    }

    public View cuR() {
        return this.iQw;
    }

    public TextView cuS() {
        return this.jcj;
    }

    public String getTitle() {
        return this.jch.getText().toString();
    }

    public String cuT() {
        return this.jck.getText().toString();
    }

    public String getContent() {
        return this.jcq.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.TA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.TB + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.TC + " " + this.cCx + ":" + this.TF).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.jch.setText(str);
    }

    public void setContent(String str) {
        this.jcq.setText(str);
    }

    public void HS(String str) {
        this.jck.setText(str);
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
        this.jcg.getLayoutMode().setNightMode(i == 1);
        this.jcg.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jcg.getPageContext(), i);
        this.jcj.setTextColor(ao.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.jcj.setText(this.jcg.getPageContext().getContext().getString(R.string.done));
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
        this.jcj.setText(this.jcg.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cuU() {
        return this.jct;
    }
}
