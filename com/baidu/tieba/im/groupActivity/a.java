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
    private int aFZ;
    private TextWatcher eQY;
    private View gbd;
    private CreateGroupActivityActivity gkS;
    private EditText gkT;
    private ImageButton gkU;
    private TextView gkV;
    private EditText gkW;
    private ImageButton gkX;
    private Button gkY;
    private Button gkZ;
    private DatePickerDialog gla;
    private TimePickerDialog glb;
    private EditText glc;
    private TextWatcher gld;
    private boolean gle;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.gla = null;
        this.glb = null;
        this.MC = 0;
        this.MD = 0;
        this.ME = 0;
        this.aFZ = 0;
        this.MG = 0;
        this.gle = false;
        this.gkS = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(d.h.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.gkS.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.gkS.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
        this.gbd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gbd.setOnClickListener(this.gkS);
        this.gkV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gkS.getResources().getString(d.j.group_activity_create_btntext));
        this.gkV.setOnClickListener(this.gkS);
        this.gkV.setEnabled(false);
        this.gkT = (EditText) this.gkS.findViewById(d.g.txt_group_activity_name);
        this.gkU = (ImageButton) this.gkS.findViewById(d.g.btn_del_name);
        this.gkW = (EditText) this.gkS.findViewById(d.g.txt_group_activity_place);
        this.gkX = (ImageButton) this.gkS.findViewById(d.g.btn_del_place);
        this.glc = (EditText) this.gkS.findViewById(d.g.txt_group_activity_content);
        this.gkY = (Button) this.gkS.findViewById(d.g.btn_create_group_date);
        this.gkZ = (Button) this.gkS.findViewById(d.g.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.MC = calendar.get(1);
        this.MD = calendar.get(2);
        this.ME = calendar.get(5);
        this.aFZ = calendar.get(11);
        this.MG = calendar.get(12);
        btw();
        btv();
        this.gkS.ShowSoftKeyPadDelay(this.gkT, 500);
        this.gkY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gla == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.gkS.showToast(d.j.group_activity_time_val);
                                return;
                            }
                            a.this.MC = i;
                            a.this.MD = i2;
                            a.this.ME = i3;
                            g.b(a.this.gla, a.this.gkS.getPageContext());
                            a.this.btw();
                            a.this.gle = true;
                        }
                    };
                    a.this.gla = new DatePickerDialog(a.this.gkS.getPageContext().getPageActivity(), onDateSetListener, a.this.MC, a.this.MD, a.this.ME);
                }
                a.this.gla.updateDate(a.this.MC, a.this.MD, a.this.ME);
                g.a(a.this.gla, a.this.gkS.getPageContext());
            }
        });
        this.gkZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.glb == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.aFZ = i;
                            a.this.MG = i2;
                            g.b(a.this.glb, a.this.gkS.getPageContext());
                            a.this.btv();
                            a.this.gle = true;
                        }
                    };
                    a.this.glb = new TimePickerDialog(a.this.gkS.getPageContext().getPageActivity(), onTimeSetListener, a.this.aFZ, a.this.MG, false);
                }
                a.this.glb.updateTime(a.this.aFZ, a.this.MG);
                g.a(a.this.glb, a.this.gkS.getPageContext());
            }
        });
        this.gkU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gkT.setText("");
            }
        });
        this.gkX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gkW.setText("");
            }
        });
        this.eQY = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gkT.getText().length() > 0) {
                    a.this.gkU.setVisibility(0);
                    a.this.gkV.setEnabled(true);
                    return;
                }
                a.this.gkU.setVisibility(8);
                a.this.gkV.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gkT.addTextChangedListener(this.eQY);
        this.gld = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gkW.getText().length() > 0) {
                    a.this.gkX.setVisibility(0);
                } else {
                    a.this.gkX.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gkW.addTextChangedListener(this.gld);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btv() {
        if (this.aFZ > 12) {
            this.gkZ.setText(this.gkS.getResources().getString(d.j.afternoon) + " " + (this.aFZ - 12) + Config.TRACE_TODAY_VISIT_SPLIT + (this.MG < 10 ? "0" : "") + this.MG);
        } else {
            this.gkZ.setText(this.gkS.getResources().getString(d.j.morning) + " " + this.aFZ + Config.TRACE_TODAY_VISIT_SPLIT + (this.MG < 10 ? "0" : "") + this.MG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btw() {
        this.gkY.setText(this.MC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.MD + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ME + " " + ap.p(this.MC, this.MD, this.ME));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.gkT.removeTextChangedListener(this.eQY);
        this.gkW.removeTextChangedListener(this.gld);
    }

    public View btx() {
        return this.gbd;
    }

    public TextView bty() {
        return this.gkV;
    }

    public String getTitle() {
        return this.gkT.getText().toString();
    }

    public String btz() {
        return this.gkW.getText().toString();
    }

    public String getContent() {
        return this.glc.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.MC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.MD + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ME + " " + this.aFZ + Config.TRACE_TODAY_VISIT_SPLIT + this.MG).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.gkT.setText(str);
    }

    public void setContent(String str) {
        this.glc.setText(str);
    }

    public void xd(String str) {
        this.gkW.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.MC = date.getYear() + 1900;
        this.MD = date.getMonth();
        this.ME = date.getDate();
        this.aFZ = date.getHours();
        this.MG = date.getMinutes();
        btw();
        btv();
    }

    public void onChangeSkinType(int i) {
        this.gkS.getLayoutMode().setNightMode(i == 1);
        this.gkS.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gkS.getPageContext(), i);
        this.gkV.setTextColor(al.getColor(d.C0277d.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.gkV.setText(this.gkS.getPageContext().getContext().getString(d.j.done));
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
        this.gkV.setText(this.gkS.getPageContext().getContext().getString(d.j.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(d.j.group_activity_create);
    }

    public boolean btA() {
        return this.gle;
    }
}
