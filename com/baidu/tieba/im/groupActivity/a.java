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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes10.dex */
public class a extends c<BaseFragmentActivity> {
    private int SQ;
    private int SR;
    private int SS;
    private int SU;
    private int cjs;
    private View idJ;
    private Button inA;
    private DatePickerDialog inB;
    private TimePickerDialog inC;
    private EditText inD;
    private TextWatcher inE;
    private TextWatcher inF;
    private boolean inG;

    /* renamed from: int  reason: not valid java name */
    private CreateGroupActivityActivity f4int;
    private EditText inu;
    private ImageButton inv;
    private TextView inw;
    private EditText inx;
    private ImageButton iny;
    private Button inz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.inB = null;
        this.inC = null;
        this.SQ = 0;
        this.SR = 0;
        this.SS = 0;
        this.cjs = 0;
        this.SU = 0;
        this.inG = false;
        this.f4int = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.f4int.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.f4int.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.idJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.idJ.setOnClickListener(this.f4int);
        this.inw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f4int.getResources().getString(R.string.group_activity_create_btntext));
        this.inw.setOnClickListener(this.f4int);
        this.inw.setEnabled(false);
        this.inu = (EditText) this.f4int.findViewById(R.id.txt_group_activity_name);
        this.inv = (ImageButton) this.f4int.findViewById(R.id.btn_del_name);
        this.inx = (EditText) this.f4int.findViewById(R.id.txt_group_activity_place);
        this.iny = (ImageButton) this.f4int.findViewById(R.id.btn_del_place);
        this.inD = (EditText) this.f4int.findViewById(R.id.txt_group_activity_content);
        this.inz = (Button) this.f4int.findViewById(R.id.btn_create_group_date);
        this.inA = (Button) this.f4int.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.SQ = calendar.get(1);
        this.SR = calendar.get(2);
        this.SS = calendar.get(5);
        this.cjs = calendar.get(11);
        this.SU = calendar.get(12);
        cgx();
        cgw();
        this.f4int.ShowSoftKeyPadDelay(this.inu, 500);
        this.inz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.inB == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.f4int.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.SQ = i;
                            a.this.SR = i2;
                            a.this.SS = i3;
                            g.b(a.this.inB, a.this.f4int.getPageContext());
                            a.this.cgx();
                            a.this.inG = true;
                        }
                    };
                    a.this.inB = new DatePickerDialog(a.this.f4int.getPageContext().getPageActivity(), onDateSetListener, a.this.SQ, a.this.SR, a.this.SS);
                }
                a.this.inB.updateDate(a.this.SQ, a.this.SR, a.this.SS);
                g.a(a.this.inB, a.this.f4int.getPageContext());
            }
        });
        this.inA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.inC == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.cjs = i;
                            a.this.SU = i2;
                            g.b(a.this.inC, a.this.f4int.getPageContext());
                            a.this.cgw();
                            a.this.inG = true;
                        }
                    };
                    a.this.inC = new TimePickerDialog(a.this.f4int.getPageContext().getPageActivity(), onTimeSetListener, a.this.cjs, a.this.SU, false);
                }
                a.this.inC.updateTime(a.this.cjs, a.this.SU);
                g.a(a.this.inC, a.this.f4int.getPageContext());
            }
        });
        this.inv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.inu.setText("");
            }
        });
        this.iny.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.inx.setText("");
            }
        });
        this.inE = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.inu.getText().length() > 0) {
                    a.this.inv.setVisibility(0);
                    a.this.inw.setEnabled(true);
                    return;
                }
                a.this.inv.setVisibility(8);
                a.this.inw.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.inu.addTextChangedListener(this.inE);
        this.inF = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.inx.getText().length() > 0) {
                    a.this.iny.setVisibility(0);
                } else {
                    a.this.iny.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.inx.addTextChangedListener(this.inF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgw() {
        if (this.cjs > 12) {
            this.inA.setText(this.f4int.getResources().getString(R.string.afternoon) + " " + (this.cjs - 12) + ":" + (this.SU < 10 ? "0" : "") + this.SU);
        } else {
            this.inA.setText(this.f4int.getResources().getString(R.string.morning) + " " + this.cjs + ":" + (this.SU < 10 ? "0" : "") + this.SU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgx() {
        this.inz.setText(this.SQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.SR + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.SS + " " + aq.getWeekString(this.SQ, this.SR, this.SS));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.inu.removeTextChangedListener(this.inE);
        this.inx.removeTextChangedListener(this.inF);
    }

    public View cgy() {
        return this.idJ;
    }

    public TextView cgz() {
        return this.inw;
    }

    public String getTitle() {
        return this.inu.getText().toString();
    }

    public String cgA() {
        return this.inx.getText().toString();
    }

    public String getContent() {
        return this.inD.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.SQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.SR + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.SS + " " + this.cjs + ":" + this.SU).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.inu.setText(str);
    }

    public void setContent(String str) {
        this.inD.setText(str);
    }

    public void EP(String str) {
        this.inx.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.SQ = date.getYear() + FeatureCodes.SKY_SEG;
        this.SR = date.getMonth();
        this.SS = date.getDate();
        this.cjs = date.getHours();
        this.SU = date.getMinutes();
        cgx();
        cgw();
    }

    public void onChangeSkinType(int i) {
        this.f4int.getLayoutMode().setNightMode(i == 1);
        this.f4int.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.f4int.getPageContext(), i);
        this.inw.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.inw.setText(this.f4int.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                EP(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.inw.setText(this.f4int.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cgB() {
        return this.inG;
    }
}
