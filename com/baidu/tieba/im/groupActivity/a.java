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
    private int cKP;
    private View jfB;
    private TextWatcher jrA;
    private boolean jrB;
    private CreateGroupActivityActivity jro;
    private EditText jrp;
    private ImageButton jrq;
    private TextView jrr;
    private EditText jrs;
    private ImageButton jrt;
    private Button jru;
    private Button jrv;
    private DatePickerDialog jrw;
    private TimePickerDialog jrx;
    private EditText jry;
    private TextWatcher jrz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.jrw = null;
        this.jrx = null;
        this.Ue = 0;
        this.Uf = 0;
        this.Ug = 0;
        this.cKP = 0;
        this.Ui = 0;
        this.jrB = false;
        this.jro = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.jro.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jro.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.jfB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jfB.setOnClickListener(this.jro);
        this.jrr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jro.getResources().getString(R.string.group_activity_create_btntext));
        this.jrr.setOnClickListener(this.jro);
        this.jrr.setEnabled(false);
        this.jrp = (EditText) this.jro.findViewById(R.id.txt_group_activity_name);
        this.jrq = (ImageButton) this.jro.findViewById(R.id.btn_del_name);
        this.jrs = (EditText) this.jro.findViewById(R.id.txt_group_activity_place);
        this.jrt = (ImageButton) this.jro.findViewById(R.id.btn_del_place);
        this.jry = (EditText) this.jro.findViewById(R.id.txt_group_activity_content);
        this.jru = (Button) this.jro.findViewById(R.id.btn_create_group_date);
        this.jrv = (Button) this.jro.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Ue = calendar.get(1);
        this.Uf = calendar.get(2);
        this.Ug = calendar.get(5);
        this.cKP = calendar.get(11);
        this.Ui = calendar.get(12);
        cFI();
        cFH();
        this.jro.ShowSoftKeyPadDelay(this.jrp, 500);
        this.jru.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jrw == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.jro.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.Ue = i;
                            a.this.Uf = i2;
                            a.this.Ug = i3;
                            g.b(a.this.jrw, a.this.jro.getPageContext());
                            a.this.cFI();
                            a.this.jrB = true;
                        }
                    };
                    a.this.jrw = new DatePickerDialog(a.this.jro.getPageContext().getPageActivity(), onDateSetListener, a.this.Ue, a.this.Uf, a.this.Ug);
                }
                a.this.jrw.updateDate(a.this.Ue, a.this.Uf, a.this.Ug);
                g.a(a.this.jrw, a.this.jro.getPageContext());
            }
        });
        this.jrv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jrx == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.cKP = i;
                            a.this.Ui = i2;
                            g.b(a.this.jrx, a.this.jro.getPageContext());
                            a.this.cFH();
                            a.this.jrB = true;
                        }
                    };
                    a.this.jrx = new TimePickerDialog(a.this.jro.getPageContext().getPageActivity(), onTimeSetListener, a.this.cKP, a.this.Ui, false);
                }
                a.this.jrx.updateTime(a.this.cKP, a.this.Ui);
                g.a(a.this.jrx, a.this.jro.getPageContext());
            }
        });
        this.jrq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jrp.setText("");
            }
        });
        this.jrt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jrs.setText("");
            }
        });
        this.jrz = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jrp.getText().length() > 0) {
                    a.this.jrq.setVisibility(0);
                    a.this.jrr.setEnabled(true);
                    return;
                }
                a.this.jrq.setVisibility(8);
                a.this.jrr.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jrp.addTextChangedListener(this.jrz);
        this.jrA = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jrs.getText().length() > 0) {
                    a.this.jrt.setVisibility(0);
                } else {
                    a.this.jrt.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jrs.addTextChangedListener(this.jrA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFH() {
        if (this.cKP > 12) {
            this.jrv.setText(this.jro.getResources().getString(R.string.afternoon) + " " + (this.cKP - 12) + ":" + (this.Ui < 10 ? "0" : "") + this.Ui);
        } else {
            this.jrv.setText(this.jro.getResources().getString(R.string.morning) + " " + this.cKP + ":" + (this.Ui < 10 ? "0" : "") + this.Ui);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFI() {
        this.jru.setText(this.Ue + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Uf + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ug + " " + at.getWeekString(this.Ue, this.Uf, this.Ug));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.jrp.removeTextChangedListener(this.jrz);
        this.jrs.removeTextChangedListener(this.jrA);
    }

    public View cFJ() {
        return this.jfB;
    }

    public TextView cFK() {
        return this.jrr;
    }

    public String getTitle() {
        return this.jrp.getText().toString();
    }

    public String cFL() {
        return this.jrs.getText().toString();
    }

    public String getContent() {
        return this.jry.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Ue + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Uf + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ug + " " + this.cKP + ":" + this.Ui).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.jrp.setText(str);
    }

    public void setContent(String str) {
        this.jry.setText(str);
    }

    public void KL(String str) {
        this.jrs.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Ue = date.getYear() + FeatureCodes.SKY_SEG;
        this.Uf = date.getMonth();
        this.Ug = date.getDate();
        this.cKP = date.getHours();
        this.Ui = date.getMinutes();
        cFI();
        cFH();
    }

    public void onChangeSkinType(int i) {
        this.jro.getLayoutMode().setNightMode(i == 1);
        this.jro.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jro.getPageContext(), i);
        this.jrr.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.jrr.setText(this.jro.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                KL(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.jrr.setText(this.jro.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cFM() {
        return this.jrB;
    }
}
