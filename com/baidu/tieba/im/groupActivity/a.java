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
    private int aFY;
    private TextWatcher eQX;
    private View gbd;
    private CreateGroupActivityActivity gkR;
    private EditText gkS;
    private ImageButton gkT;
    private TextView gkU;
    private EditText gkV;
    private ImageButton gkW;
    private Button gkX;
    private Button gkY;
    private DatePickerDialog gkZ;
    private TimePickerDialog gla;
    private EditText glb;
    private TextWatcher glc;
    private boolean gld;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.gkZ = null;
        this.gla = null;
        this.MC = 0;
        this.MD = 0;
        this.ME = 0;
        this.aFY = 0;
        this.MG = 0;
        this.gld = false;
        this.gkR = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.gkR.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.gkR.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
        this.gbd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gbd.setOnClickListener(this.gkR);
        this.gkU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gkR.getResources().getString(d.j.group_activity_create_btntext));
        this.gkU.setOnClickListener(this.gkR);
        this.gkU.setEnabled(false);
        this.gkS = (EditText) this.gkR.findViewById(d.g.txt_group_activity_name);
        this.gkT = (ImageButton) this.gkR.findViewById(d.g.btn_del_name);
        this.gkV = (EditText) this.gkR.findViewById(d.g.txt_group_activity_place);
        this.gkW = (ImageButton) this.gkR.findViewById(d.g.btn_del_place);
        this.glb = (EditText) this.gkR.findViewById(d.g.txt_group_activity_content);
        this.gkX = (Button) this.gkR.findViewById(d.g.btn_create_group_date);
        this.gkY = (Button) this.gkR.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.MC = calendar.get(1);
        this.MD = calendar.get(2);
        this.ME = calendar.get(5);
        this.aFY = calendar.get(11);
        this.MG = calendar.get(12);
        btw();
        btv();
        this.gkR.ShowSoftKeyPadDelay(this.gkS, 500);
        this.gkX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gkZ == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.gkR.showToast(d.j.group_activity_time_val);
                                return;
                            }
                            a.this.MC = i;
                            a.this.MD = i2;
                            a.this.ME = i3;
                            g.b(a.this.gkZ, a.this.gkR.getPageContext());
                            a.this.btw();
                            a.this.gld = true;
                        }
                    };
                    a.this.gkZ = new DatePickerDialog(a.this.gkR.getPageContext().getPageActivity(), onDateSetListener, a.this.MC, a.this.MD, a.this.ME);
                }
                a.this.gkZ.updateDate(a.this.MC, a.this.MD, a.this.ME);
                g.a(a.this.gkZ, a.this.gkR.getPageContext());
            }
        });
        this.gkY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gla == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.aFY = i;
                            a.this.MG = i2;
                            g.b(a.this.gla, a.this.gkR.getPageContext());
                            a.this.btv();
                            a.this.gld = true;
                        }
                    };
                    a.this.gla = new TimePickerDialog(a.this.gkR.getPageContext().getPageActivity(), onTimeSetListener, a.this.aFY, a.this.MG, false);
                }
                a.this.gla.updateTime(a.this.aFY, a.this.MG);
                g.a(a.this.gla, a.this.gkR.getPageContext());
            }
        });
        this.gkT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gkS.setText("");
            }
        });
        this.gkW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gkV.setText("");
            }
        });
        this.eQX = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gkS.getText().length() > 0) {
                    a.this.gkT.setVisibility(0);
                    a.this.gkU.setEnabled(true);
                    return;
                }
                a.this.gkT.setVisibility(8);
                a.this.gkU.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gkS.addTextChangedListener(this.eQX);
        this.glc = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gkV.getText().length() > 0) {
                    a.this.gkW.setVisibility(0);
                } else {
                    a.this.gkW.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gkV.addTextChangedListener(this.glc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btv() {
        if (this.aFY > 12) {
            this.gkY.setText(this.gkR.getResources().getString(d.j.afternoon) + " " + (this.aFY - 12) + Config.TRACE_TODAY_VISIT_SPLIT + (this.MG < 10 ? "0" : "") + this.MG);
        } else {
            this.gkY.setText(this.gkR.getResources().getString(d.j.morning) + " " + this.aFY + Config.TRACE_TODAY_VISIT_SPLIT + (this.MG < 10 ? "0" : "") + this.MG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btw() {
        this.gkX.setText(this.MC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.MD + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ME + " " + ap.p(this.MC, this.MD, this.ME));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.gkS.removeTextChangedListener(this.eQX);
        this.gkV.removeTextChangedListener(this.glc);
    }

    public View btx() {
        return this.gbd;
    }

    public TextView bty() {
        return this.gkU;
    }

    public String getTitle() {
        return this.gkS.getText().toString();
    }

    public String btz() {
        return this.gkV.getText().toString();
    }

    public String getContent() {
        return this.glb.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.MC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.MD + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ME + " " + this.aFY + Config.TRACE_TODAY_VISIT_SPLIT + this.MG).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.gkS.setText(str);
    }

    public void setContent(String str) {
        this.glb.setText(str);
    }

    public void xd(String str) {
        this.gkV.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.MC = date.getYear() + 1900;
        this.MD = date.getMonth();
        this.ME = date.getDate();
        this.aFY = date.getHours();
        this.MG = date.getMinutes();
        btw();
        btv();
    }

    public void onChangeSkinType(int i) {
        this.gkR.getLayoutMode().setNightMode(i == 1);
        this.gkR.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gkR.getPageContext(), i);
        this.gkU.setTextColor(al.getColor(d.C0277d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.gkU.setText(this.gkR.getPageContext().getContext().getString(d.j.done));
            this.mNavigationBar.setTitleText(d.j.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                xd(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.gkU.setText(this.gkR.getPageContext().getContext().getString(d.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
    }

    public boolean btA() {
        return this.gld;
    }
}
