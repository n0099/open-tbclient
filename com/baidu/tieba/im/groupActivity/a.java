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
/* loaded from: classes17.dex */
public class a extends c<BaseFragmentActivity> {
    private int Ue;
    private int Uf;
    private int Ug;
    private int Ui;
    private int cKL;
    private View jfv;
    private CreateGroupActivityActivity jri;
    private EditText jrj;
    private ImageButton jrk;
    private TextView jrl;
    private EditText jrm;
    private ImageButton jrn;
    private Button jro;
    private Button jrp;
    private DatePickerDialog jrq;
    private TimePickerDialog jrr;
    private EditText jrs;
    private TextWatcher jrt;
    private TextWatcher jru;
    private boolean jrv;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.jrq = null;
        this.jrr = null;
        this.Ue = 0;
        this.Uf = 0;
        this.Ug = 0;
        this.cKL = 0;
        this.Ui = 0;
        this.jrv = false;
        this.jri = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.jri.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jri.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.jfv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jfv.setOnClickListener(this.jri);
        this.jrl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jri.getResources().getString(R.string.group_activity_create_btntext));
        this.jrl.setOnClickListener(this.jri);
        this.jrl.setEnabled(false);
        this.jrj = (EditText) this.jri.findViewById(R.id.txt_group_activity_name);
        this.jrk = (ImageButton) this.jri.findViewById(R.id.btn_del_name);
        this.jrm = (EditText) this.jri.findViewById(R.id.txt_group_activity_place);
        this.jrn = (ImageButton) this.jri.findViewById(R.id.btn_del_place);
        this.jrs = (EditText) this.jri.findViewById(R.id.txt_group_activity_content);
        this.jro = (Button) this.jri.findViewById(R.id.btn_create_group_date);
        this.jrp = (Button) this.jri.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Ue = calendar.get(1);
        this.Uf = calendar.get(2);
        this.Ug = calendar.get(5);
        this.cKL = calendar.get(11);
        this.Ui = calendar.get(12);
        cFH();
        cFG();
        this.jri.ShowSoftKeyPadDelay(this.jrj, 500);
        this.jro.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jrq == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.jri.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.Ue = i;
                            a.this.Uf = i2;
                            a.this.Ug = i3;
                            g.b(a.this.jrq, a.this.jri.getPageContext());
                            a.this.cFH();
                            a.this.jrv = true;
                        }
                    };
                    a.this.jrq = new DatePickerDialog(a.this.jri.getPageContext().getPageActivity(), onDateSetListener, a.this.Ue, a.this.Uf, a.this.Ug);
                }
                a.this.jrq.updateDate(a.this.Ue, a.this.Uf, a.this.Ug);
                g.a(a.this.jrq, a.this.jri.getPageContext());
            }
        });
        this.jrp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jrr == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.cKL = i;
                            a.this.Ui = i2;
                            g.b(a.this.jrr, a.this.jri.getPageContext());
                            a.this.cFG();
                            a.this.jrv = true;
                        }
                    };
                    a.this.jrr = new TimePickerDialog(a.this.jri.getPageContext().getPageActivity(), onTimeSetListener, a.this.cKL, a.this.Ui, false);
                }
                a.this.jrr.updateTime(a.this.cKL, a.this.Ui);
                g.a(a.this.jrr, a.this.jri.getPageContext());
            }
        });
        this.jrk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jrj.setText("");
            }
        });
        this.jrn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jrm.setText("");
            }
        });
        this.jrt = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jrj.getText().length() > 0) {
                    a.this.jrk.setVisibility(0);
                    a.this.jrl.setEnabled(true);
                    return;
                }
                a.this.jrk.setVisibility(8);
                a.this.jrl.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jrj.addTextChangedListener(this.jrt);
        this.jru = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jrm.getText().length() > 0) {
                    a.this.jrn.setVisibility(0);
                } else {
                    a.this.jrn.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jrm.addTextChangedListener(this.jru);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFG() {
        if (this.cKL > 12) {
            this.jrp.setText(this.jri.getResources().getString(R.string.afternoon) + " " + (this.cKL - 12) + ":" + (this.Ui < 10 ? "0" : "") + this.Ui);
        } else {
            this.jrp.setText(this.jri.getResources().getString(R.string.morning) + " " + this.cKL + ":" + (this.Ui < 10 ? "0" : "") + this.Ui);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFH() {
        this.jro.setText(this.Ue + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Uf + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ug + " " + at.getWeekString(this.Ue, this.Uf, this.Ug));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.jrj.removeTextChangedListener(this.jrt);
        this.jrm.removeTextChangedListener(this.jru);
    }

    public View cFI() {
        return this.jfv;
    }

    public TextView cFJ() {
        return this.jrl;
    }

    public String getTitle() {
        return this.jrj.getText().toString();
    }

    public String cFK() {
        return this.jrm.getText().toString();
    }

    public String getContent() {
        return this.jrs.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Ue + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Uf + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ug + " " + this.cKL + ":" + this.Ui).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.jrj.setText(str);
    }

    public void setContent(String str) {
        this.jrs.setText(str);
    }

    public void KK(String str) {
        this.jrm.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Ue = date.getYear() + FeatureCodes.SKY_SEG;
        this.Uf = date.getMonth();
        this.Ug = date.getDate();
        this.cKL = date.getHours();
        this.Ui = date.getMinutes();
        cFH();
        cFG();
    }

    public void onChangeSkinType(int i) {
        this.jri.getLayoutMode().setNightMode(i == 1);
        this.jri.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jri.getPageContext(), i);
        this.jrl.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.jrl.setText(this.jri.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                KK(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.jrl.setText(this.jri.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cFL() {
        return this.jrv;
    }
}
