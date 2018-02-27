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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
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
    private int asA;
    private int asB;
    private int asD;
    private int asz;
    private CreateGroupActivityActivity eFk;
    private EditText eFl;
    private ImageButton eFm;
    private TextView eFn;
    private EditText eFo;
    private ImageButton eFp;
    private Button eFq;
    private Button eFr;
    private DatePickerDialog eFs;
    private TimePickerDialog eFt;
    private EditText eFu;
    private TextWatcher eFv;
    private TextWatcher eFw;
    private int eFx;
    private boolean eFy;
    private View evy;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eFs = null;
        this.eFt = null;
        this.asz = 0;
        this.asA = 0;
        this.asB = 0;
        this.eFx = 0;
        this.asD = 0;
        this.eFy = false;
        this.eFk = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eFk.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eFk.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
        this.evy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.evy.setOnClickListener(this.eFk);
        this.eFn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eFk.getResources().getString(d.j.group_activity_create_btntext));
        this.eFn.setOnClickListener(this.eFk);
        this.eFn.setEnabled(false);
        this.eFl = (EditText) this.eFk.findViewById(d.g.txt_group_activity_name);
        this.eFm = (ImageButton) this.eFk.findViewById(d.g.btn_del_name);
        this.eFo = (EditText) this.eFk.findViewById(d.g.txt_group_activity_place);
        this.eFp = (ImageButton) this.eFk.findViewById(d.g.btn_del_place);
        this.eFu = (EditText) this.eFk.findViewById(d.g.txt_group_activity_content);
        this.eFq = (Button) this.eFk.findViewById(d.g.btn_create_group_date);
        this.eFr = (Button) this.eFk.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.asz = calendar.get(1);
        this.asA = calendar.get(2);
        this.asB = calendar.get(5);
        this.eFx = calendar.get(11);
        this.asD = calendar.get(12);
        aJs();
        aJr();
        this.eFk.ShowSoftKeyPadDelay(this.eFl, 500);
        this.eFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eFs == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eFk.showToast(d.j.group_activity_time_val);
                                return;
                            }
                            a.this.asz = i;
                            a.this.asA = i2;
                            a.this.asB = i3;
                            g.b(a.this.eFs, a.this.eFk.getPageContext());
                            a.this.aJs();
                            a.this.eFy = true;
                        }
                    };
                    a.this.eFs = new DatePickerDialog(a.this.eFk.getPageContext().getPageActivity(), onDateSetListener, a.this.asz, a.this.asA, a.this.asB);
                }
                a.this.eFs.updateDate(a.this.asz, a.this.asA, a.this.asB);
                g.a(a.this.eFs, a.this.eFk.getPageContext());
            }
        });
        this.eFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eFt == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.eFx = i;
                            a.this.asD = i2;
                            g.b(a.this.eFt, a.this.eFk.getPageContext());
                            a.this.aJr();
                            a.this.eFy = true;
                        }
                    };
                    a.this.eFt = new TimePickerDialog(a.this.eFk.getPageContext().getPageActivity(), onTimeSetListener, a.this.eFx, a.this.asD, false);
                }
                a.this.eFt.updateTime(a.this.eFx, a.this.asD);
                g.a(a.this.eFt, a.this.eFk.getPageContext());
            }
        });
        this.eFm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eFl.setText("");
            }
        });
        this.eFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eFo.setText("");
            }
        });
        this.eFv = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eFl.getText().length() > 0) {
                    a.this.eFm.setVisibility(0);
                    a.this.eFn.setEnabled(true);
                    return;
                }
                a.this.eFm.setVisibility(8);
                a.this.eFn.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eFl.addTextChangedListener(this.eFv);
        this.eFw = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eFo.getText().length() > 0) {
                    a.this.eFp.setVisibility(0);
                } else {
                    a.this.eFp.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eFo.addTextChangedListener(this.eFw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJr() {
        if (this.eFx > 12) {
            this.eFr.setText(this.eFk.getResources().getString(d.j.afternoon) + " " + (this.eFx - 12) + ":" + (this.asD < 10 ? "0" : "") + this.asD);
        } else {
            this.eFr.setText(this.eFk.getResources().getString(d.j.morning) + " " + this.eFx + ":" + (this.asD < 10 ? "0" : "") + this.asD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJs() {
        this.eFq.setText(this.asz + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.asA + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asB + " " + am.v(this.asz, this.asA, this.asB));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eFl.removeTextChangedListener(this.eFv);
        this.eFo.removeTextChangedListener(this.eFw);
    }

    public View aJt() {
        return this.evy;
    }

    public TextView aJu() {
        return this.eFn;
    }

    public String getTitle() {
        return this.eFl.getText().toString();
    }

    public String aJv() {
        return this.eFo.getText().toString();
    }

    public String getContent() {
        return this.eFu.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.asz + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.asA + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asB + " " + this.eFx + ":" + this.asD).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eFl.setText(str);
    }

    public void setContent(String str) {
        this.eFu.setText(str);
    }

    public void nx(String str) {
        this.eFo.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.asz = date.getYear() + 1900;
        this.asA = date.getMonth();
        this.asB = date.getDate();
        this.eFx = date.getHours();
        this.asD = date.getMinutes();
        aJs();
        aJr();
    }

    public void onChangeSkinType(int i) {
        this.eFk.getLayoutMode().aQ(i == 1);
        this.eFk.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eFk.getPageContext(), i);
        this.eFn.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eFn.setText(this.eFk.getPageContext().getContext().getString(d.j.done));
            this.mNavigationBar.setTitleText(d.j.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                nx(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.eFn.setText(this.eFk.getPageContext().getContext().getString(d.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
    }

    public boolean aJw() {
        return this.eFy;
    }
}
