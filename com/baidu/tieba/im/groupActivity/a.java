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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
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
    private int Jo;
    private int Jp;
    private int Jq;
    private int Js;
    private View ecL;
    private EditText emA;
    private ImageButton emB;
    private Button emC;
    private Button emD;
    private DatePickerDialog emE;
    private TimePickerDialog emF;
    private EditText emG;
    private TextWatcher emH;
    private TextWatcher emI;
    private int emJ;
    private boolean emK;
    private CreateGroupActivityActivity emw;
    private EditText emx;
    private ImageButton emy;
    private TextView emz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.emE = null;
        this.emF = null;
        this.Jo = 0;
        this.Jp = 0;
        this.Jq = 0;
        this.emJ = 0;
        this.Js = 0;
        this.emK = false;
        this.emw = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.i.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.emw.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.emw.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.group_activity_create);
        this.ecL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ecL.setOnClickListener(this.emw);
        this.emz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.emw.getResources().getString(d.k.group_activity_create_btntext));
        this.emz.setOnClickListener(this.emw);
        this.emz.setEnabled(false);
        this.emx = (EditText) this.emw.findViewById(d.g.txt_group_activity_name);
        this.emy = (ImageButton) this.emw.findViewById(d.g.btn_del_name);
        this.emA = (EditText) this.emw.findViewById(d.g.txt_group_activity_place);
        this.emB = (ImageButton) this.emw.findViewById(d.g.btn_del_place);
        this.emG = (EditText) this.emw.findViewById(d.g.txt_group_activity_content);
        this.emC = (Button) this.emw.findViewById(d.g.btn_create_group_date);
        this.emD = (Button) this.emw.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Jo = calendar.get(1);
        this.Jp = calendar.get(2);
        this.Jq = calendar.get(5);
        this.emJ = calendar.get(11);
        this.Js = calendar.get(12);
        aJj();
        aJi();
        this.emw.ShowSoftKeyPadDelay(this.emx, 500);
        this.emC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.emE == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.emw.showToast(d.k.group_activity_time_val);
                                return;
                            }
                            a.this.Jo = i;
                            a.this.Jp = i2;
                            a.this.Jq = i3;
                            g.b(a.this.emE, a.this.emw.getPageContext());
                            a.this.aJj();
                            a.this.emK = true;
                        }
                    };
                    a.this.emE = new DatePickerDialog(a.this.emw.getPageContext().getPageActivity(), onDateSetListener, a.this.Jo, a.this.Jp, a.this.Jq);
                }
                a.this.emE.updateDate(a.this.Jo, a.this.Jp, a.this.Jq);
                g.a(a.this.emE, a.this.emw.getPageContext());
            }
        });
        this.emD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.emF == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.emJ = i;
                            a.this.Js = i2;
                            g.b(a.this.emF, a.this.emw.getPageContext());
                            a.this.aJi();
                            a.this.emK = true;
                        }
                    };
                    a.this.emF = new TimePickerDialog(a.this.emw.getPageContext().getPageActivity(), onTimeSetListener, a.this.emJ, a.this.Js, false);
                }
                a.this.emF.updateTime(a.this.emJ, a.this.Js);
                g.a(a.this.emF, a.this.emw.getPageContext());
            }
        });
        this.emy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.emx.setText("");
            }
        });
        this.emB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.emA.setText("");
            }
        });
        this.emH = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.emx.getText().length() > 0) {
                    a.this.emy.setVisibility(0);
                    a.this.emz.setEnabled(true);
                    return;
                }
                a.this.emy.setVisibility(8);
                a.this.emz.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.emx.addTextChangedListener(this.emH);
        this.emI = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.emA.getText().length() > 0) {
                    a.this.emB.setVisibility(0);
                } else {
                    a.this.emB.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.emA.addTextChangedListener(this.emI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJi() {
        if (this.emJ > 12) {
            this.emD.setText(this.emw.getResources().getString(d.k.afternoon) + " " + (this.emJ - 12) + SystemInfoUtil.COLON + (this.Js < 10 ? "0" : "") + this.Js);
        } else {
            this.emD.setText(this.emw.getResources().getString(d.k.morning) + " " + this.emJ + SystemInfoUtil.COLON + (this.Js < 10 ? "0" : "") + this.Js);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJj() {
        this.emC.setText(this.Jo + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Jp + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jq + " " + ao.k(this.Jo, this.Jp, this.Jq));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.emx.removeTextChangedListener(this.emH);
        this.emA.removeTextChangedListener(this.emI);
    }

    public View aJk() {
        return this.ecL;
    }

    public TextView aJl() {
        return this.emz;
    }

    public String getTitle() {
        return this.emx.getText().toString();
    }

    public String aJm() {
        return this.emA.getText().toString();
    }

    public String getContent() {
        return this.emG.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Jo + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Jp + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jq + " " + this.emJ + SystemInfoUtil.COLON + this.Js).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.emx.setText(str);
    }

    public void setContent(String str) {
        this.emG.setText(str);
    }

    public void os(String str) {
        this.emA.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Jo = date.getYear() + 1900;
        this.Jp = date.getMonth();
        this.Jq = date.getDate();
        this.emJ = date.getHours();
        this.Js = date.getMinutes();
        aJj();
        aJi();
    }

    public void onChangeSkinType(int i) {
        this.emw.getLayoutMode().setNightMode(i == 1);
        this.emw.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.emw.getPageContext(), i);
        this.emz.setTextColor(al.getColor(d.C0141d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.emz.setText(this.emw.getPageContext().getContext().getString(d.k.done));
            this.mNavigationBar.setTitleText(d.k.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                os(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.emz.setText(this.emw.getPageContext().getContext().getString(d.k.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.k.group_activity_create);
    }

    public boolean aJn() {
        return this.emK;
    }
}
