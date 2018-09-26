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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes3.dex */
public class a extends c<BaseFragmentActivity> {
    private int LH;
    private int LI;
    private int LJ;
    private int LM;
    private TextWatcher dkQ;
    private CreateGroupActivityActivity eBA;
    private EditText eBB;
    private ImageButton eBC;
    private TextView eBD;
    private EditText eBE;
    private ImageButton eBF;
    private Button eBG;
    private Button eBH;
    private DatePickerDialog eBI;
    private TimePickerDialog eBJ;
    private EditText eBK;
    private TextWatcher eBL;
    private int eBM;
    private boolean eBN;
    private View erL;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.eBI = null;
        this.eBJ = null;
        this.LH = 0;
        this.LI = 0;
        this.LJ = 0;
        this.eBM = 0;
        this.LM = 0;
        this.eBN = false;
        this.eBA = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(e.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.eBA.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eBA.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
        this.erL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.erL.setOnClickListener(this.eBA);
        this.eBD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eBA.getResources().getString(e.j.group_activity_create_btntext));
        this.eBD.setOnClickListener(this.eBA);
        this.eBD.setEnabled(false);
        this.eBB = (EditText) this.eBA.findViewById(e.g.txt_group_activity_name);
        this.eBC = (ImageButton) this.eBA.findViewById(e.g.btn_del_name);
        this.eBE = (EditText) this.eBA.findViewById(e.g.txt_group_activity_place);
        this.eBF = (ImageButton) this.eBA.findViewById(e.g.btn_del_place);
        this.eBK = (EditText) this.eBA.findViewById(e.g.txt_group_activity_content);
        this.eBG = (Button) this.eBA.findViewById(e.g.btn_create_group_date);
        this.eBH = (Button) this.eBA.findViewById(e.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.LH = calendar.get(1);
        this.LI = calendar.get(2);
        this.LJ = calendar.get(5);
        this.eBM = calendar.get(11);
        this.LM = calendar.get(12);
        aNd();
        aNc();
        this.eBA.ShowSoftKeyPadDelay(this.eBB, 500);
        this.eBG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eBI == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.eBA.showToast(e.j.group_activity_time_val);
                                return;
                            }
                            a.this.LH = i;
                            a.this.LI = i2;
                            a.this.LJ = i3;
                            g.b(a.this.eBI, a.this.eBA.getPageContext());
                            a.this.aNd();
                            a.this.eBN = true;
                        }
                    };
                    a.this.eBI = new DatePickerDialog(a.this.eBA.getPageContext().getPageActivity(), onDateSetListener, a.this.LH, a.this.LI, a.this.LJ);
                }
                a.this.eBI.updateDate(a.this.LH, a.this.LI, a.this.LJ);
                g.a(a.this.eBI, a.this.eBA.getPageContext());
            }
        });
        this.eBH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eBJ == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.eBM = i;
                            a.this.LM = i2;
                            g.b(a.this.eBJ, a.this.eBA.getPageContext());
                            a.this.aNc();
                            a.this.eBN = true;
                        }
                    };
                    a.this.eBJ = new TimePickerDialog(a.this.eBA.getPageContext().getPageActivity(), onTimeSetListener, a.this.eBM, a.this.LM, false);
                }
                a.this.eBJ.updateTime(a.this.eBM, a.this.LM);
                g.a(a.this.eBJ, a.this.eBA.getPageContext());
            }
        });
        this.eBC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eBB.setText("");
            }
        });
        this.eBF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eBE.setText("");
            }
        });
        this.dkQ = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eBB.getText().length() > 0) {
                    a.this.eBC.setVisibility(0);
                    a.this.eBD.setEnabled(true);
                    return;
                }
                a.this.eBC.setVisibility(8);
                a.this.eBD.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eBB.addTextChangedListener(this.dkQ);
        this.eBL = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eBE.getText().length() > 0) {
                    a.this.eBF.setVisibility(0);
                } else {
                    a.this.eBF.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eBE.addTextChangedListener(this.eBL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNc() {
        if (this.eBM > 12) {
            this.eBH.setText(this.eBA.getResources().getString(e.j.afternoon) + " " + (this.eBM - 12) + ":" + (this.LM < 10 ? "0" : "") + this.LM);
        } else {
            this.eBH.setText(this.eBA.getResources().getString(e.j.morning) + " " + this.eBM + ":" + (this.LM < 10 ? "0" : "") + this.LM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNd() {
        this.eBG.setText(this.LH + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.LI + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.LJ + " " + ao.m(this.LH, this.LI, this.LJ));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.eBB.removeTextChangedListener(this.dkQ);
        this.eBE.removeTextChangedListener(this.eBL);
    }

    public View aNe() {
        return this.erL;
    }

    public TextView aNf() {
        return this.eBD;
    }

    public String getTitle() {
        return this.eBB.getText().toString();
    }

    public String aNg() {
        return this.eBE.getText().toString();
    }

    public String getContent() {
        return this.eBK.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.LH + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.LI + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.LJ + " " + this.eBM + ":" + this.LM).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.eBB.setText(str);
    }

    public void setContent(String str) {
        this.eBK.setText(str);
    }

    public void pc(String str) {
        this.eBE.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.LH = date.getYear() + 1900;
        this.LI = date.getMonth();
        this.LJ = date.getDate();
        this.eBM = date.getHours();
        this.LM = date.getMinutes();
        aNd();
        aNc();
    }

    public void onChangeSkinType(int i) {
        this.eBA.getLayoutMode().setNightMode(i == 1);
        this.eBA.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eBA.getPageContext(), i);
        this.eBD.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.eBD.setText(this.eBA.getPageContext().getContext().getString(e.j.done));
            this.mNavigationBar.setTitleText(e.j.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                pc(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.eBD.setText(this.eBA.getPageContext().getContext().getString(e.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(e.j.group_activity_create);
    }

    public boolean aNh() {
        return this.eBN;
    }
}
