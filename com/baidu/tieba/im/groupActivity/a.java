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
    private int asC;
    private int asE;
    private CreateGroupActivityActivity eFA;
    private EditText eFB;
    private ImageButton eFC;
    private TextView eFD;
    private EditText eFE;
    private ImageButton eFF;
    private Button eFG;
    private Button eFH;
    private DatePickerDialog eFI;
    private TimePickerDialog eFJ;
    private EditText eFK;
    private TextWatcher eFL;
    private TextWatcher eFM;
    private int eFN;
    private boolean eFO;
    private View evO;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eFI = null;
        this.eFJ = null;
        this.asA = 0;
        this.asB = 0;
        this.asC = 0;
        this.eFN = 0;
        this.asE = 0;
        this.eFO = false;
        this.eFA = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eFA.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eFA.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
        this.evO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.evO.setOnClickListener(this.eFA);
        this.eFD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eFA.getResources().getString(d.j.group_activity_create_btntext));
        this.eFD.setOnClickListener(this.eFA);
        this.eFD.setEnabled(false);
        this.eFB = (EditText) this.eFA.findViewById(d.g.txt_group_activity_name);
        this.eFC = (ImageButton) this.eFA.findViewById(d.g.btn_del_name);
        this.eFE = (EditText) this.eFA.findViewById(d.g.txt_group_activity_place);
        this.eFF = (ImageButton) this.eFA.findViewById(d.g.btn_del_place);
        this.eFK = (EditText) this.eFA.findViewById(d.g.txt_group_activity_content);
        this.eFG = (Button) this.eFA.findViewById(d.g.btn_create_group_date);
        this.eFH = (Button) this.eFA.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.asA = calendar.get(1);
        this.asB = calendar.get(2);
        this.asC = calendar.get(5);
        this.eFN = calendar.get(11);
        this.asE = calendar.get(12);
        aJt();
        aJs();
        this.eFA.ShowSoftKeyPadDelay(this.eFB, 500);
        this.eFG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eFI == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eFA.showToast(d.j.group_activity_time_val);
                                return;
                            }
                            a.this.asA = i;
                            a.this.asB = i2;
                            a.this.asC = i3;
                            g.b(a.this.eFI, a.this.eFA.getPageContext());
                            a.this.aJt();
                            a.this.eFO = true;
                        }
                    };
                    a.this.eFI = new DatePickerDialog(a.this.eFA.getPageContext().getPageActivity(), onDateSetListener, a.this.asA, a.this.asB, a.this.asC);
                }
                a.this.eFI.updateDate(a.this.asA, a.this.asB, a.this.asC);
                g.a(a.this.eFI, a.this.eFA.getPageContext());
            }
        });
        this.eFH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eFJ == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.eFN = i;
                            a.this.asE = i2;
                            g.b(a.this.eFJ, a.this.eFA.getPageContext());
                            a.this.aJs();
                            a.this.eFO = true;
                        }
                    };
                    a.this.eFJ = new TimePickerDialog(a.this.eFA.getPageContext().getPageActivity(), onTimeSetListener, a.this.eFN, a.this.asE, false);
                }
                a.this.eFJ.updateTime(a.this.eFN, a.this.asE);
                g.a(a.this.eFJ, a.this.eFA.getPageContext());
            }
        });
        this.eFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eFB.setText("");
            }
        });
        this.eFF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eFE.setText("");
            }
        });
        this.eFL = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eFB.getText().length() > 0) {
                    a.this.eFC.setVisibility(0);
                    a.this.eFD.setEnabled(true);
                    return;
                }
                a.this.eFC.setVisibility(8);
                a.this.eFD.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eFB.addTextChangedListener(this.eFL);
        this.eFM = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eFE.getText().length() > 0) {
                    a.this.eFF.setVisibility(0);
                } else {
                    a.this.eFF.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eFE.addTextChangedListener(this.eFM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJs() {
        if (this.eFN > 12) {
            this.eFH.setText(this.eFA.getResources().getString(d.j.afternoon) + " " + (this.eFN - 12) + ":" + (this.asE < 10 ? "0" : "") + this.asE);
        } else {
            this.eFH.setText(this.eFA.getResources().getString(d.j.morning) + " " + this.eFN + ":" + (this.asE < 10 ? "0" : "") + this.asE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJt() {
        this.eFG.setText(this.asA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.asB + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asC + " " + am.v(this.asA, this.asB, this.asC));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eFB.removeTextChangedListener(this.eFL);
        this.eFE.removeTextChangedListener(this.eFM);
    }

    public View aJu() {
        return this.evO;
    }

    public TextView aJv() {
        return this.eFD;
    }

    public String getTitle() {
        return this.eFB.getText().toString();
    }

    public String aJw() {
        return this.eFE.getText().toString();
    }

    public String getContent() {
        return this.eFK.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.asA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.asB + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asC + " " + this.eFN + ":" + this.asE).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eFB.setText(str);
    }

    public void setContent(String str) {
        this.eFK.setText(str);
    }

    public void nx(String str) {
        this.eFE.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.asA = date.getYear() + 1900;
        this.asB = date.getMonth();
        this.asC = date.getDate();
        this.eFN = date.getHours();
        this.asE = date.getMinutes();
        aJt();
        aJs();
    }

    public void onChangeSkinType(int i) {
        this.eFA.getLayoutMode().aQ(i == 1);
        this.eFA.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eFA.getPageContext(), i);
        this.eFD.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eFD.setText(this.eFA.getPageContext().getContext().getString(d.j.done));
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
        this.eFD.setText(this.eFA.getPageContext().getContext().getString(d.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
    }

    public boolean aJx() {
        return this.eFO;
    }
}
