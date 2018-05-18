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
    private int De;
    private int Df;
    private int Dg;
    private int Di;
    private View dRy;
    private CreateGroupActivityActivity ebj;
    private EditText ebk;
    private ImageButton ebl;
    private TextView ebm;
    private EditText ebn;
    private ImageButton ebo;
    private Button ebp;
    private Button ebq;
    private DatePickerDialog ebr;
    private TimePickerDialog ebs;
    private EditText ebt;
    private TextWatcher ebu;
    private TextWatcher ebv;
    private int ebw;
    private boolean ebx;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.ebr = null;
        this.ebs = null;
        this.De = 0;
        this.Df = 0;
        this.Dg = 0;
        this.ebw = 0;
        this.Di = 0;
        this.ebx = false;
        this.ebj = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.i.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.ebj.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.ebj.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.group_activity_create);
        this.dRy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dRy.setOnClickListener(this.ebj);
        this.ebm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ebj.getResources().getString(d.k.group_activity_create_btntext));
        this.ebm.setOnClickListener(this.ebj);
        this.ebm.setEnabled(false);
        this.ebk = (EditText) this.ebj.findViewById(d.g.txt_group_activity_name);
        this.ebl = (ImageButton) this.ebj.findViewById(d.g.btn_del_name);
        this.ebn = (EditText) this.ebj.findViewById(d.g.txt_group_activity_place);
        this.ebo = (ImageButton) this.ebj.findViewById(d.g.btn_del_place);
        this.ebt = (EditText) this.ebj.findViewById(d.g.txt_group_activity_content);
        this.ebp = (Button) this.ebj.findViewById(d.g.btn_create_group_date);
        this.ebq = (Button) this.ebj.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.De = calendar.get(1);
        this.Df = calendar.get(2);
        this.Dg = calendar.get(5);
        this.ebw = calendar.get(11);
        this.Di = calendar.get(12);
        aEo();
        aEn();
        this.ebj.ShowSoftKeyPadDelay(this.ebk, 500);
        this.ebp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.ebr == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.ebj.showToast(d.k.group_activity_time_val);
                                return;
                            }
                            a.this.De = i;
                            a.this.Df = i2;
                            a.this.Dg = i3;
                            g.b(a.this.ebr, a.this.ebj.getPageContext());
                            a.this.aEo();
                            a.this.ebx = true;
                        }
                    };
                    a.this.ebr = new DatePickerDialog(a.this.ebj.getPageContext().getPageActivity(), onDateSetListener, a.this.De, a.this.Df, a.this.Dg);
                }
                a.this.ebr.updateDate(a.this.De, a.this.Df, a.this.Dg);
                g.a(a.this.ebr, a.this.ebj.getPageContext());
            }
        });
        this.ebq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.ebs == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.ebw = i;
                            a.this.Di = i2;
                            g.b(a.this.ebs, a.this.ebj.getPageContext());
                            a.this.aEn();
                            a.this.ebx = true;
                        }
                    };
                    a.this.ebs = new TimePickerDialog(a.this.ebj.getPageContext().getPageActivity(), onTimeSetListener, a.this.ebw, a.this.Di, false);
                }
                a.this.ebs.updateTime(a.this.ebw, a.this.Di);
                g.a(a.this.ebs, a.this.ebj.getPageContext());
            }
        });
        this.ebl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.ebk.setText("");
            }
        });
        this.ebo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.ebn.setText("");
            }
        });
        this.ebu = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.ebk.getText().length() > 0) {
                    a.this.ebl.setVisibility(0);
                    a.this.ebm.setEnabled(true);
                    return;
                }
                a.this.ebl.setVisibility(8);
                a.this.ebm.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.ebk.addTextChangedListener(this.ebu);
        this.ebv = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.ebn.getText().length() > 0) {
                    a.this.ebo.setVisibility(0);
                } else {
                    a.this.ebo.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.ebn.addTextChangedListener(this.ebv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEn() {
        if (this.ebw > 12) {
            this.ebq.setText(this.ebj.getResources().getString(d.k.afternoon) + " " + (this.ebw - 12) + ":" + (this.Di < 10 ? "0" : "") + this.Di);
        } else {
            this.ebq.setText(this.ebj.getResources().getString(d.k.morning) + " " + this.ebw + ":" + (this.Di < 10 ? "0" : "") + this.Di);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEo() {
        this.ebp.setText(this.De + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Df + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dg + " " + an.k(this.De, this.Df, this.Dg));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.ebk.removeTextChangedListener(this.ebu);
        this.ebn.removeTextChangedListener(this.ebv);
    }

    public View aEp() {
        return this.dRy;
    }

    public TextView aEq() {
        return this.ebm;
    }

    public String getTitle() {
        return this.ebk.getText().toString();
    }

    public String aEr() {
        return this.ebn.getText().toString();
    }

    public String getContent() {
        return this.ebt.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.De + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Df + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dg + " " + this.ebw + ":" + this.Di).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.ebk.setText(str);
    }

    public void setContent(String str) {
        this.ebt.setText(str);
    }

    public void nE(String str) {
        this.ebn.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.De = date.getYear() + 1900;
        this.Df = date.getMonth();
        this.Dg = date.getDate();
        this.ebw = date.getHours();
        this.Di = date.getMinutes();
        aEo();
        aEn();
    }

    public void onChangeSkinType(int i) {
        this.ebj.getLayoutMode().setNightMode(i == 1);
        this.ebj.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ebj.getPageContext(), i);
        this.ebm.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.ebm.setText(this.ebj.getPageContext().getContext().getString(d.k.done));
            this.mNavigationBar.setTitleText(d.k.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                nE(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.ebm.setText(this.ebj.getPageContext().getContext().getString(d.k.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.k.group_activity_create);
    }

    public boolean aEs() {
        return this.ebx;
    }
}
