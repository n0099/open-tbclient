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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes3.dex */
public class a extends c<BaseFragmentActivity> {
    private int Df;
    private int Dg;
    private int Dh;
    private int Dj;
    private View dQr;
    private CreateGroupActivityActivity eac;
    private EditText ead;
    private ImageButton eae;
    private TextView eaf;
    private EditText eag;
    private ImageButton eah;
    private Button eai;
    private Button eaj;
    private DatePickerDialog eak;
    private TimePickerDialog eal;
    private EditText eam;
    private TextWatcher ean;
    private TextWatcher eao;
    private int eap;
    private boolean eaq;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eak = null;
        this.eal = null;
        this.Df = 0;
        this.Dg = 0;
        this.Dh = 0;
        this.eap = 0;
        this.Dj = 0;
        this.eaq = false;
        this.eac = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.i.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eac.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eac.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.group_activity_create);
        this.dQr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dQr.setOnClickListener(this.eac);
        this.eaf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eac.getResources().getString(d.k.group_activity_create_btntext));
        this.eaf.setOnClickListener(this.eac);
        this.eaf.setEnabled(false);
        this.ead = (EditText) this.eac.findViewById(d.g.txt_group_activity_name);
        this.eae = (ImageButton) this.eac.findViewById(d.g.btn_del_name);
        this.eag = (EditText) this.eac.findViewById(d.g.txt_group_activity_place);
        this.eah = (ImageButton) this.eac.findViewById(d.g.btn_del_place);
        this.eam = (EditText) this.eac.findViewById(d.g.txt_group_activity_content);
        this.eai = (Button) this.eac.findViewById(d.g.btn_create_group_date);
        this.eaj = (Button) this.eac.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Df = calendar.get(1);
        this.Dg = calendar.get(2);
        this.Dh = calendar.get(5);
        this.eap = calendar.get(11);
        this.Dj = calendar.get(12);
        aEq();
        aEp();
        this.eac.ShowSoftKeyPadDelay(this.ead, 500);
        this.eai.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eak == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eac.showToast(d.k.group_activity_time_val);
                                return;
                            }
                            a.this.Df = i;
                            a.this.Dg = i2;
                            a.this.Dh = i3;
                            g.b(a.this.eak, a.this.eac.getPageContext());
                            a.this.aEq();
                            a.this.eaq = true;
                        }
                    };
                    a.this.eak = new DatePickerDialog(a.this.eac.getPageContext().getPageActivity(), onDateSetListener, a.this.Df, a.this.Dg, a.this.Dh);
                }
                a.this.eak.updateDate(a.this.Df, a.this.Dg, a.this.Dh);
                g.a(a.this.eak, a.this.eac.getPageContext());
            }
        });
        this.eaj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eal == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.eap = i;
                            a.this.Dj = i2;
                            g.b(a.this.eal, a.this.eac.getPageContext());
                            a.this.aEp();
                            a.this.eaq = true;
                        }
                    };
                    a.this.eal = new TimePickerDialog(a.this.eac.getPageContext().getPageActivity(), onTimeSetListener, a.this.eap, a.this.Dj, false);
                }
                a.this.eal.updateTime(a.this.eap, a.this.Dj);
                g.a(a.this.eal, a.this.eac.getPageContext());
            }
        });
        this.eae.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.ead.setText("");
            }
        });
        this.eah.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.eag.setText("");
            }
        });
        this.ean = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.ead.getText().length() > 0) {
                    a.this.eae.setVisibility(0);
                    a.this.eaf.setEnabled(true);
                    return;
                }
                a.this.eae.setVisibility(8);
                a.this.eaf.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.ead.addTextChangedListener(this.ean);
        this.eao = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eag.getText().length() > 0) {
                    a.this.eah.setVisibility(0);
                } else {
                    a.this.eah.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eag.addTextChangedListener(this.eao);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEp() {
        if (this.eap > 12) {
            this.eaj.setText(this.eac.getResources().getString(d.k.afternoon) + " " + (this.eap - 12) + ":" + (this.Dj < 10 ? "0" : "") + this.Dj);
        } else {
            this.eaj.setText(this.eac.getResources().getString(d.k.morning) + " " + this.eap + ":" + (this.Dj < 10 ? "0" : "") + this.Dj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEq() {
        this.eai.setText(this.Df + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Dg + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dh + " " + an.k(this.Df, this.Dg, this.Dh));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.ead.removeTextChangedListener(this.ean);
        this.eag.removeTextChangedListener(this.eao);
    }

    public View aEr() {
        return this.dQr;
    }

    public TextView aEs() {
        return this.eaf;
    }

    public String getTitle() {
        return this.ead.getText().toString();
    }

    public String aEt() {
        return this.eag.getText().toString();
    }

    public String getContent() {
        return this.eam.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Df + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Dg + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dh + " " + this.eap + ":" + this.Dj).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.ead.setText(str);
    }

    public void setContent(String str) {
        this.eam.setText(str);
    }

    public void nB(String str) {
        this.eag.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Df = date.getYear() + 1900;
        this.Dg = date.getMonth();
        this.Dh = date.getDate();
        this.eap = date.getHours();
        this.Dj = date.getMinutes();
        aEq();
        aEp();
    }

    public void onChangeSkinType(int i) {
        this.eac.getLayoutMode().setNightMode(i == 1);
        this.eac.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eac.getPageContext(), i);
        this.eaf.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eaf.setText(this.eac.getPageContext().getContext().getString(d.k.done));
            this.mNavigationBar.setTitleText(d.k.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                nB(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.eaf.setText(this.eac.getPageContext().getContext().getString(d.k.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.k.group_activity_create);
    }

    public boolean aEu() {
        return this.eaq;
    }
}
