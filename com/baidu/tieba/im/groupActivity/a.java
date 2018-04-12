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
    private View dQu;
    private CreateGroupActivityActivity eaf;
    private EditText eag;
    private ImageButton eah;
    private TextView eai;
    private EditText eaj;
    private ImageButton eak;
    private Button eal;
    private Button eam;
    private DatePickerDialog ean;
    private TimePickerDialog eao;
    private EditText eap;
    private TextWatcher eaq;
    private TextWatcher ear;
    private int eas;
    private boolean eat;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.ean = null;
        this.eao = null;
        this.Df = 0;
        this.Dg = 0;
        this.Dh = 0;
        this.eas = 0;
        this.Dj = 0;
        this.eat = false;
        this.eaf = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.i.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eaf.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eaf.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.group_activity_create);
        this.dQu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dQu.setOnClickListener(this.eaf);
        this.eai = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eaf.getResources().getString(d.k.group_activity_create_btntext));
        this.eai.setOnClickListener(this.eaf);
        this.eai.setEnabled(false);
        this.eag = (EditText) this.eaf.findViewById(d.g.txt_group_activity_name);
        this.eah = (ImageButton) this.eaf.findViewById(d.g.btn_del_name);
        this.eaj = (EditText) this.eaf.findViewById(d.g.txt_group_activity_place);
        this.eak = (ImageButton) this.eaf.findViewById(d.g.btn_del_place);
        this.eap = (EditText) this.eaf.findViewById(d.g.txt_group_activity_content);
        this.eal = (Button) this.eaf.findViewById(d.g.btn_create_group_date);
        this.eam = (Button) this.eaf.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Df = calendar.get(1);
        this.Dg = calendar.get(2);
        this.Dh = calendar.get(5);
        this.eas = calendar.get(11);
        this.Dj = calendar.get(12);
        aEq();
        aEp();
        this.eaf.ShowSoftKeyPadDelay(this.eag, 500);
        this.eal.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.ean == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eaf.showToast(d.k.group_activity_time_val);
                                return;
                            }
                            a.this.Df = i;
                            a.this.Dg = i2;
                            a.this.Dh = i3;
                            g.b(a.this.ean, a.this.eaf.getPageContext());
                            a.this.aEq();
                            a.this.eat = true;
                        }
                    };
                    a.this.ean = new DatePickerDialog(a.this.eaf.getPageContext().getPageActivity(), onDateSetListener, a.this.Df, a.this.Dg, a.this.Dh);
                }
                a.this.ean.updateDate(a.this.Df, a.this.Dg, a.this.Dh);
                g.a(a.this.ean, a.this.eaf.getPageContext());
            }
        });
        this.eam.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eao == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.eas = i;
                            a.this.Dj = i2;
                            g.b(a.this.eao, a.this.eaf.getPageContext());
                            a.this.aEp();
                            a.this.eat = true;
                        }
                    };
                    a.this.eao = new TimePickerDialog(a.this.eaf.getPageContext().getPageActivity(), onTimeSetListener, a.this.eas, a.this.Dj, false);
                }
                a.this.eao.updateTime(a.this.eas, a.this.Dj);
                g.a(a.this.eao, a.this.eaf.getPageContext());
            }
        });
        this.eah.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.eag.setText("");
            }
        });
        this.eak.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.eaj.setText("");
            }
        });
        this.eaq = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eag.getText().length() > 0) {
                    a.this.eah.setVisibility(0);
                    a.this.eai.setEnabled(true);
                    return;
                }
                a.this.eah.setVisibility(8);
                a.this.eai.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eag.addTextChangedListener(this.eaq);
        this.ear = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eaj.getText().length() > 0) {
                    a.this.eak.setVisibility(0);
                } else {
                    a.this.eak.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eaj.addTextChangedListener(this.ear);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEp() {
        if (this.eas > 12) {
            this.eam.setText(this.eaf.getResources().getString(d.k.afternoon) + " " + (this.eas - 12) + ":" + (this.Dj < 10 ? "0" : "") + this.Dj);
        } else {
            this.eam.setText(this.eaf.getResources().getString(d.k.morning) + " " + this.eas + ":" + (this.Dj < 10 ? "0" : "") + this.Dj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEq() {
        this.eal.setText(this.Df + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Dg + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dh + " " + an.k(this.Df, this.Dg, this.Dh));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eag.removeTextChangedListener(this.eaq);
        this.eaj.removeTextChangedListener(this.ear);
    }

    public View aEr() {
        return this.dQu;
    }

    public TextView aEs() {
        return this.eai;
    }

    public String getTitle() {
        return this.eag.getText().toString();
    }

    public String aEt() {
        return this.eaj.getText().toString();
    }

    public String getContent() {
        return this.eap.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Df + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Dg + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dh + " " + this.eas + ":" + this.Dj).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eag.setText(str);
    }

    public void setContent(String str) {
        this.eap.setText(str);
    }

    public void nB(String str) {
        this.eaj.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Df = date.getYear() + 1900;
        this.Dg = date.getMonth();
        this.Dh = date.getDate();
        this.eas = date.getHours();
        this.Dj = date.getMinutes();
        aEq();
        aEp();
    }

    public void onChangeSkinType(int i) {
        this.eaf.getLayoutMode().setNightMode(i == 1);
        this.eaf.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eaf.getPageContext(), i);
        this.eai.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eai.setText(this.eaf.getPageContext().getContext().getString(d.k.done));
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
        this.eai.setText(this.eaf.getPageContext().getContext().getString(d.k.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.k.group_activity_create);
    }

    public boolean aEu() {
        return this.eat;
    }
}
