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
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes3.dex */
public class a extends c<BaseFragmentActivity> {
    private int Jn;
    private int Jo;
    private int Jp;
    private int Jr;
    private TextWatcher deY;
    private View ekr;
    private CreateGroupActivityActivity euh;
    private EditText eui;
    private ImageButton euj;
    private TextView euk;
    private EditText eul;
    private ImageButton eum;
    private Button eun;
    private Button euo;
    private DatePickerDialog eup;
    private TimePickerDialog euq;
    private EditText eur;
    private TextWatcher eus;
    private int eut;
    private boolean euu;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eup = null;
        this.euq = null;
        this.Jn = 0;
        this.Jo = 0;
        this.Jp = 0;
        this.eut = 0;
        this.Jr = 0;
        this.euu = false;
        this.euh = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(f.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.euh.findViewById(f.g.parent);
        this.mNavigationBar = (NavigationBar) this.euh.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(f.j.group_activity_create);
        this.ekr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ekr.setOnClickListener(this.euh);
        this.euk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.euh.getResources().getString(f.j.group_activity_create_btntext));
        this.euk.setOnClickListener(this.euh);
        this.euk.setEnabled(false);
        this.eui = (EditText) this.euh.findViewById(f.g.txt_group_activity_name);
        this.euj = (ImageButton) this.euh.findViewById(f.g.btn_del_name);
        this.eul = (EditText) this.euh.findViewById(f.g.txt_group_activity_place);
        this.eum = (ImageButton) this.euh.findViewById(f.g.btn_del_place);
        this.eur = (EditText) this.euh.findViewById(f.g.txt_group_activity_content);
        this.eun = (Button) this.euh.findViewById(f.g.btn_create_group_date);
        this.euo = (Button) this.euh.findViewById(f.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Jn = calendar.get(1);
        this.Jo = calendar.get(2);
        this.Jp = calendar.get(5);
        this.eut = calendar.get(11);
        this.Jr = calendar.get(12);
        aKO();
        aKN();
        this.euh.ShowSoftKeyPadDelay(this.eui, 500);
        this.eun.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eup == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.euh.showToast(f.j.group_activity_time_val);
                                return;
                            }
                            a.this.Jn = i;
                            a.this.Jo = i2;
                            a.this.Jp = i3;
                            g.b(a.this.eup, a.this.euh.getPageContext());
                            a.this.aKO();
                            a.this.euu = true;
                        }
                    };
                    a.this.eup = new DatePickerDialog(a.this.euh.getPageContext().getPageActivity(), onDateSetListener, a.this.Jn, a.this.Jo, a.this.Jp);
                }
                a.this.eup.updateDate(a.this.Jn, a.this.Jo, a.this.Jp);
                g.a(a.this.eup, a.this.euh.getPageContext());
            }
        });
        this.euo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.euq == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.eut = i;
                            a.this.Jr = i2;
                            g.b(a.this.euq, a.this.euh.getPageContext());
                            a.this.aKN();
                            a.this.euu = true;
                        }
                    };
                    a.this.euq = new TimePickerDialog(a.this.euh.getPageContext().getPageActivity(), onTimeSetListener, a.this.eut, a.this.Jr, false);
                }
                a.this.euq.updateTime(a.this.eut, a.this.Jr);
                g.a(a.this.euq, a.this.euh.getPageContext());
            }
        });
        this.euj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eui.setText("");
            }
        });
        this.eum.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eul.setText("");
            }
        });
        this.deY = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eui.getText().length() > 0) {
                    a.this.euj.setVisibility(0);
                    a.this.euk.setEnabled(true);
                    return;
                }
                a.this.euj.setVisibility(8);
                a.this.euk.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eui.addTextChangedListener(this.deY);
        this.eus = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eul.getText().length() > 0) {
                    a.this.eum.setVisibility(0);
                } else {
                    a.this.eum.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eul.addTextChangedListener(this.eus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKN() {
        if (this.eut > 12) {
            this.euo.setText(this.euh.getResources().getString(f.j.afternoon) + " " + (this.eut - 12) + SystemInfoUtil.COLON + (this.Jr < 10 ? "0" : "") + this.Jr);
        } else {
            this.euo.setText(this.euh.getResources().getString(f.j.morning) + " " + this.eut + SystemInfoUtil.COLON + (this.Jr < 10 ? "0" : "") + this.Jr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKO() {
        this.eun.setText(this.Jn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Jo + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jp + " " + ap.k(this.Jn, this.Jo, this.Jp));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eui.removeTextChangedListener(this.deY);
        this.eul.removeTextChangedListener(this.eus);
    }

    public View aKP() {
        return this.ekr;
    }

    public TextView aKQ() {
        return this.euk;
    }

    public String getTitle() {
        return this.eui.getText().toString();
    }

    public String aKR() {
        return this.eul.getText().toString();
    }

    public String getContent() {
        return this.eur.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Jn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Jo + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jp + " " + this.eut + SystemInfoUtil.COLON + this.Jr).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eui.setText(str);
    }

    public void setContent(String str) {
        this.eur.setText(str);
    }

    public void ox(String str) {
        this.eul.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Jn = date.getYear() + 1900;
        this.Jo = date.getMonth();
        this.Jp = date.getDate();
        this.eut = date.getHours();
        this.Jr = date.getMinutes();
        aKO();
        aKN();
    }

    public void onChangeSkinType(int i) {
        this.euh.getLayoutMode().setNightMode(i == 1);
        this.euh.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.euh.getPageContext(), i);
        this.euk.setTextColor(am.getColor(f.d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.euk.setText(this.euh.getPageContext().getContext().getString(f.j.done));
            this.mNavigationBar.setTitleText(f.j.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                ox(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.euk.setText(this.euh.getPageContext().getContext().getString(f.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(f.j.group_activity_create);
    }

    public boolean aKS() {
        return this.euu;
    }
}
