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
    private int Jn;
    private int Jo;
    private int Jp;
    private int Jr;
    private TextWatcher dfa;
    private View ekv;
    private CreateGroupActivityActivity eul;
    private EditText eum;
    private ImageButton eun;
    private TextView euo;
    private EditText eup;
    private ImageButton euq;
    private Button eur;
    private Button eus;
    private DatePickerDialog eut;
    private TimePickerDialog euu;
    private EditText euv;
    private TextWatcher euw;
    private int eux;
    private boolean euy;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eut = null;
        this.euu = null;
        this.Jn = 0;
        this.Jo = 0;
        this.Jp = 0;
        this.eux = 0;
        this.Jr = 0;
        this.euy = false;
        this.eul = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eul.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eul.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
        this.ekv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ekv.setOnClickListener(this.eul);
        this.euo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eul.getResources().getString(d.j.group_activity_create_btntext));
        this.euo.setOnClickListener(this.eul);
        this.euo.setEnabled(false);
        this.eum = (EditText) this.eul.findViewById(d.g.txt_group_activity_name);
        this.eun = (ImageButton) this.eul.findViewById(d.g.btn_del_name);
        this.eup = (EditText) this.eul.findViewById(d.g.txt_group_activity_place);
        this.euq = (ImageButton) this.eul.findViewById(d.g.btn_del_place);
        this.euv = (EditText) this.eul.findViewById(d.g.txt_group_activity_content);
        this.eur = (Button) this.eul.findViewById(d.g.btn_create_group_date);
        this.eus = (Button) this.eul.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Jn = calendar.get(1);
        this.Jo = calendar.get(2);
        this.Jp = calendar.get(5);
        this.eux = calendar.get(11);
        this.Jr = calendar.get(12);
        aKR();
        aKQ();
        this.eul.ShowSoftKeyPadDelay(this.eum, 500);
        this.eur.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eut == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eul.showToast(d.j.group_activity_time_val);
                                return;
                            }
                            a.this.Jn = i;
                            a.this.Jo = i2;
                            a.this.Jp = i3;
                            g.b(a.this.eut, a.this.eul.getPageContext());
                            a.this.aKR();
                            a.this.euy = true;
                        }
                    };
                    a.this.eut = new DatePickerDialog(a.this.eul.getPageContext().getPageActivity(), onDateSetListener, a.this.Jn, a.this.Jo, a.this.Jp);
                }
                a.this.eut.updateDate(a.this.Jn, a.this.Jo, a.this.Jp);
                g.a(a.this.eut, a.this.eul.getPageContext());
            }
        });
        this.eus.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.euu == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.eux = i;
                            a.this.Jr = i2;
                            g.b(a.this.euu, a.this.eul.getPageContext());
                            a.this.aKQ();
                            a.this.euy = true;
                        }
                    };
                    a.this.euu = new TimePickerDialog(a.this.eul.getPageContext().getPageActivity(), onTimeSetListener, a.this.eux, a.this.Jr, false);
                }
                a.this.euu.updateTime(a.this.eux, a.this.Jr);
                g.a(a.this.euu, a.this.eul.getPageContext());
            }
        });
        this.eun.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eum.setText("");
            }
        });
        this.euq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eup.setText("");
            }
        });
        this.dfa = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eum.getText().length() > 0) {
                    a.this.eun.setVisibility(0);
                    a.this.euo.setEnabled(true);
                    return;
                }
                a.this.eun.setVisibility(8);
                a.this.euo.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eum.addTextChangedListener(this.dfa);
        this.euw = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eup.getText().length() > 0) {
                    a.this.euq.setVisibility(0);
                } else {
                    a.this.euq.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eup.addTextChangedListener(this.euw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKQ() {
        if (this.eux > 12) {
            this.eus.setText(this.eul.getResources().getString(d.j.afternoon) + " " + (this.eux - 12) + SystemInfoUtil.COLON + (this.Jr < 10 ? "0" : "") + this.Jr);
        } else {
            this.eus.setText(this.eul.getResources().getString(d.j.morning) + " " + this.eux + SystemInfoUtil.COLON + (this.Jr < 10 ? "0" : "") + this.Jr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKR() {
        this.eur.setText(this.Jn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Jo + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jp + " " + ap.k(this.Jn, this.Jo, this.Jp));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eum.removeTextChangedListener(this.dfa);
        this.eup.removeTextChangedListener(this.euw);
    }

    public View aKS() {
        return this.ekv;
    }

    public TextView aKT() {
        return this.euo;
    }

    public String getTitle() {
        return this.eum.getText().toString();
    }

    public String aKU() {
        return this.eup.getText().toString();
    }

    public String getContent() {
        return this.euv.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Jn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Jo + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jp + " " + this.eux + SystemInfoUtil.COLON + this.Jr).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eum.setText(str);
    }

    public void setContent(String str) {
        this.euv.setText(str);
    }

    public void ov(String str) {
        this.eup.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Jn = date.getYear() + 1900;
        this.Jo = date.getMonth();
        this.Jp = date.getDate();
        this.eux = date.getHours();
        this.Jr = date.getMinutes();
        aKR();
        aKQ();
    }

    public void onChangeSkinType(int i) {
        this.eul.getLayoutMode().setNightMode(i == 1);
        this.eul.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eul.getPageContext(), i);
        this.euo.setTextColor(am.getColor(d.C0140d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.euo.setText(this.eul.getPageContext().getContext().getString(d.j.done));
            this.mNavigationBar.setTitleText(d.j.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                ov(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.euo.setText(this.eul.getPageContext().getContext().getString(d.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
    }

    public boolean aKV() {
        return this.euy;
    }
}
