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
    private int asI;
    private int asJ;
    private int asK;
    private int asM;
    private EditText eFA;
    private ImageButton eFB;
    private Button eFC;
    private Button eFD;
    private DatePickerDialog eFE;
    private TimePickerDialog eFF;
    private EditText eFG;
    private TextWatcher eFH;
    private TextWatcher eFI;
    private int eFJ;
    private boolean eFK;
    private CreateGroupActivityActivity eFw;
    private EditText eFx;
    private ImageButton eFy;
    private TextView eFz;
    private View evK;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eFE = null;
        this.eFF = null;
        this.asI = 0;
        this.asJ = 0;
        this.asK = 0;
        this.eFJ = 0;
        this.asM = 0;
        this.eFK = false;
        this.eFw = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eFw.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eFw.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
        this.evK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.evK.setOnClickListener(this.eFw);
        this.eFz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eFw.getResources().getString(d.j.group_activity_create_btntext));
        this.eFz.setOnClickListener(this.eFw);
        this.eFz.setEnabled(false);
        this.eFx = (EditText) this.eFw.findViewById(d.g.txt_group_activity_name);
        this.eFy = (ImageButton) this.eFw.findViewById(d.g.btn_del_name);
        this.eFA = (EditText) this.eFw.findViewById(d.g.txt_group_activity_place);
        this.eFB = (ImageButton) this.eFw.findViewById(d.g.btn_del_place);
        this.eFG = (EditText) this.eFw.findViewById(d.g.txt_group_activity_content);
        this.eFC = (Button) this.eFw.findViewById(d.g.btn_create_group_date);
        this.eFD = (Button) this.eFw.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.asI = calendar.get(1);
        this.asJ = calendar.get(2);
        this.asK = calendar.get(5);
        this.eFJ = calendar.get(11);
        this.asM = calendar.get(12);
        aJt();
        aJs();
        this.eFw.ShowSoftKeyPadDelay(this.eFx, 500);
        this.eFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eFE == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eFw.showToast(d.j.group_activity_time_val);
                                return;
                            }
                            a.this.asI = i;
                            a.this.asJ = i2;
                            a.this.asK = i3;
                            g.b(a.this.eFE, a.this.eFw.getPageContext());
                            a.this.aJt();
                            a.this.eFK = true;
                        }
                    };
                    a.this.eFE = new DatePickerDialog(a.this.eFw.getPageContext().getPageActivity(), onDateSetListener, a.this.asI, a.this.asJ, a.this.asK);
                }
                a.this.eFE.updateDate(a.this.asI, a.this.asJ, a.this.asK);
                g.a(a.this.eFE, a.this.eFw.getPageContext());
            }
        });
        this.eFD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eFF == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.eFJ = i;
                            a.this.asM = i2;
                            g.b(a.this.eFF, a.this.eFw.getPageContext());
                            a.this.aJs();
                            a.this.eFK = true;
                        }
                    };
                    a.this.eFF = new TimePickerDialog(a.this.eFw.getPageContext().getPageActivity(), onTimeSetListener, a.this.eFJ, a.this.asM, false);
                }
                a.this.eFF.updateTime(a.this.eFJ, a.this.asM);
                g.a(a.this.eFF, a.this.eFw.getPageContext());
            }
        });
        this.eFy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eFx.setText("");
            }
        });
        this.eFB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eFA.setText("");
            }
        });
        this.eFH = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eFx.getText().length() > 0) {
                    a.this.eFy.setVisibility(0);
                    a.this.eFz.setEnabled(true);
                    return;
                }
                a.this.eFy.setVisibility(8);
                a.this.eFz.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eFx.addTextChangedListener(this.eFH);
        this.eFI = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eFA.getText().length() > 0) {
                    a.this.eFB.setVisibility(0);
                } else {
                    a.this.eFB.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eFA.addTextChangedListener(this.eFI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJs() {
        if (this.eFJ > 12) {
            this.eFD.setText(this.eFw.getResources().getString(d.j.afternoon) + " " + (this.eFJ - 12) + ":" + (this.asM < 10 ? "0" : "") + this.asM);
        } else {
            this.eFD.setText(this.eFw.getResources().getString(d.j.morning) + " " + this.eFJ + ":" + (this.asM < 10 ? "0" : "") + this.asM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJt() {
        this.eFC.setText(this.asI + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.asJ + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asK + " " + am.v(this.asI, this.asJ, this.asK));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eFx.removeTextChangedListener(this.eFH);
        this.eFA.removeTextChangedListener(this.eFI);
    }

    public View aJu() {
        return this.evK;
    }

    public TextView aJv() {
        return this.eFz;
    }

    public String getTitle() {
        return this.eFx.getText().toString();
    }

    public String aJw() {
        return this.eFA.getText().toString();
    }

    public String getContent() {
        return this.eFG.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.asI + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.asJ + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asK + " " + this.eFJ + ":" + this.asM).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eFx.setText(str);
    }

    public void setContent(String str) {
        this.eFG.setText(str);
    }

    public void nx(String str) {
        this.eFA.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.asI = date.getYear() + 1900;
        this.asJ = date.getMonth();
        this.asK = date.getDate();
        this.eFJ = date.getHours();
        this.asM = date.getMinutes();
        aJt();
        aJs();
    }

    public void onChangeSkinType(int i) {
        this.eFw.getLayoutMode().aQ(i == 1);
        this.eFw.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eFw.getPageContext(), i);
        this.eFz.setTextColor(aj.getColor(d.C0140d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eFz.setText(this.eFw.getPageContext().getContext().getString(d.j.done));
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
        this.eFz.setText(this.eFw.getPageContext().getContext().getString(d.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
    }

    public boolean aJx() {
        return this.eFK;
    }
}
