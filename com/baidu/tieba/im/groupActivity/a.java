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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.al;
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
/* loaded from: classes5.dex */
public class a extends c<BaseFragmentActivity> {
    private int MC;
    private int MD;
    private int ME;
    private int MG;
    private int aFV;
    private TextWatcher eRl;
    private View gbp;
    private CreateGroupActivityActivity gle;
    private EditText glf;
    private ImageButton glg;
    private TextView glh;
    private EditText gli;
    private ImageButton glj;
    private Button glk;
    private Button gll;
    private DatePickerDialog glm;
    private TimePickerDialog gln;
    private EditText glo;
    private TextWatcher glp;
    private boolean glq;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.glm = null;
        this.gln = null;
        this.MC = 0;
        this.MD = 0;
        this.ME = 0;
        this.aFV = 0;
        this.MG = 0;
        this.glq = false;
        this.gle = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.gle.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.gle.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
        this.gbp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gbp.setOnClickListener(this.gle);
        this.glh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gle.getResources().getString(d.j.group_activity_create_btntext));
        this.glh.setOnClickListener(this.gle);
        this.glh.setEnabled(false);
        this.glf = (EditText) this.gle.findViewById(d.g.txt_group_activity_name);
        this.glg = (ImageButton) this.gle.findViewById(d.g.btn_del_name);
        this.gli = (EditText) this.gle.findViewById(d.g.txt_group_activity_place);
        this.glj = (ImageButton) this.gle.findViewById(d.g.btn_del_place);
        this.glo = (EditText) this.gle.findViewById(d.g.txt_group_activity_content);
        this.glk = (Button) this.gle.findViewById(d.g.btn_create_group_date);
        this.gll = (Button) this.gle.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.MC = calendar.get(1);
        this.MD = calendar.get(2);
        this.ME = calendar.get(5);
        this.aFV = calendar.get(11);
        this.MG = calendar.get(12);
        btz();
        bty();
        this.gle.ShowSoftKeyPadDelay(this.glf, 500);
        this.glk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.glm == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.gle.showToast(d.j.group_activity_time_val);
                                return;
                            }
                            a.this.MC = i;
                            a.this.MD = i2;
                            a.this.ME = i3;
                            g.b(a.this.glm, a.this.gle.getPageContext());
                            a.this.btz();
                            a.this.glq = true;
                        }
                    };
                    a.this.glm = new DatePickerDialog(a.this.gle.getPageContext().getPageActivity(), onDateSetListener, a.this.MC, a.this.MD, a.this.ME);
                }
                a.this.glm.updateDate(a.this.MC, a.this.MD, a.this.ME);
                g.a(a.this.glm, a.this.gle.getPageContext());
            }
        });
        this.gll.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gln == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.aFV = i;
                            a.this.MG = i2;
                            g.b(a.this.gln, a.this.gle.getPageContext());
                            a.this.bty();
                            a.this.glq = true;
                        }
                    };
                    a.this.gln = new TimePickerDialog(a.this.gle.getPageContext().getPageActivity(), onTimeSetListener, a.this.aFV, a.this.MG, false);
                }
                a.this.gln.updateTime(a.this.aFV, a.this.MG);
                g.a(a.this.gln, a.this.gle.getPageContext());
            }
        });
        this.glg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.glf.setText("");
            }
        });
        this.glj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gli.setText("");
            }
        });
        this.eRl = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.glf.getText().length() > 0) {
                    a.this.glg.setVisibility(0);
                    a.this.glh.setEnabled(true);
                    return;
                }
                a.this.glg.setVisibility(8);
                a.this.glh.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.glf.addTextChangedListener(this.eRl);
        this.glp = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gli.getText().length() > 0) {
                    a.this.glj.setVisibility(0);
                } else {
                    a.this.glj.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gli.addTextChangedListener(this.glp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bty() {
        if (this.aFV > 12) {
            this.gll.setText(this.gle.getResources().getString(d.j.afternoon) + " " + (this.aFV - 12) + Config.TRACE_TODAY_VISIT_SPLIT + (this.MG < 10 ? "0" : "") + this.MG);
        } else {
            this.gll.setText(this.gle.getResources().getString(d.j.morning) + " " + this.aFV + Config.TRACE_TODAY_VISIT_SPLIT + (this.MG < 10 ? "0" : "") + this.MG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btz() {
        this.glk.setText(this.MC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.MD + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ME + " " + ap.p(this.MC, this.MD, this.ME));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.glf.removeTextChangedListener(this.eRl);
        this.gli.removeTextChangedListener(this.glp);
    }

    public View btA() {
        return this.gbp;
    }

    public TextView btB() {
        return this.glh;
    }

    public String getTitle() {
        return this.glf.getText().toString();
    }

    public String btC() {
        return this.gli.getText().toString();
    }

    public String getContent() {
        return this.glo.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.MC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.MD + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ME + " " + this.aFV + Config.TRACE_TODAY_VISIT_SPLIT + this.MG).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.glf.setText(str);
    }

    public void setContent(String str) {
        this.glo.setText(str);
    }

    public void xe(String str) {
        this.gli.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.MC = date.getYear() + 1900;
        this.MD = date.getMonth();
        this.ME = date.getDate();
        this.aFV = date.getHours();
        this.MG = date.getMinutes();
        btz();
        bty();
    }

    public void onChangeSkinType(int i) {
        this.gle.getLayoutMode().setNightMode(i == 1);
        this.gle.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gle.getPageContext(), i);
        this.glh.setTextColor(al.getColor(d.C0277d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.glh.setText(this.gle.getPageContext().getContext().getString(d.j.done));
            this.mNavigationBar.setTitleText(d.j.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                xe(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.glh.setText(this.gle.getPageContext().getContext().getString(d.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
    }

    public boolean btD() {
        return this.glq;
    }
}
