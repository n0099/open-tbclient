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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes22.dex */
public class a extends c<BaseFragmentActivity> {
    private int UB;
    private int Uw;
    private int Ux;
    private int Uy;
    private int cMP;
    private EditText jAa;
    private TextWatcher jAb;
    private TextWatcher jAc;
    private boolean jAd;
    private View joh;
    private CreateGroupActivityActivity jzQ;
    private EditText jzR;
    private ImageButton jzS;
    private TextView jzT;
    private EditText jzU;
    private ImageButton jzV;
    private Button jzW;
    private Button jzX;
    private DatePickerDialog jzY;
    private TimePickerDialog jzZ;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.jzY = null;
        this.jzZ = null;
        this.Uw = 0;
        this.Ux = 0;
        this.Uy = 0;
        this.cMP = 0;
        this.UB = 0;
        this.jAd = false;
        this.jzQ = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.jzQ.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jzQ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.joh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.joh.setOnClickListener(this.jzQ);
        this.jzT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jzQ.getResources().getString(R.string.group_activity_create_btntext));
        this.jzT.setOnClickListener(this.jzQ);
        this.jzT.setEnabled(false);
        this.jzR = (EditText) this.jzQ.findViewById(R.id.txt_group_activity_name);
        this.jzS = (ImageButton) this.jzQ.findViewById(R.id.btn_del_name);
        this.jzU = (EditText) this.jzQ.findViewById(R.id.txt_group_activity_place);
        this.jzV = (ImageButton) this.jzQ.findViewById(R.id.btn_del_place);
        this.jAa = (EditText) this.jzQ.findViewById(R.id.txt_group_activity_content);
        this.jzW = (Button) this.jzQ.findViewById(R.id.btn_create_group_date);
        this.jzX = (Button) this.jzQ.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Uw = calendar.get(1);
        this.Ux = calendar.get(2);
        this.Uy = calendar.get(5);
        this.cMP = calendar.get(11);
        this.UB = calendar.get(12);
        cJo();
        cJn();
        this.jzQ.ShowSoftKeyPadDelay(this.jzR, 500);
        this.jzW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jzY == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.jzQ.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.Uw = i;
                            a.this.Ux = i2;
                            a.this.Uy = i3;
                            g.b(a.this.jzY, a.this.jzQ.getPageContext());
                            a.this.cJo();
                            a.this.jAd = true;
                        }
                    };
                    a.this.jzY = new DatePickerDialog(a.this.jzQ.getPageContext().getPageActivity(), onDateSetListener, a.this.Uw, a.this.Ux, a.this.Uy);
                }
                a.this.jzY.updateDate(a.this.Uw, a.this.Ux, a.this.Uy);
                g.a(a.this.jzY, a.this.jzQ.getPageContext());
            }
        });
        this.jzX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jzZ == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.cMP = i;
                            a.this.UB = i2;
                            g.b(a.this.jzZ, a.this.jzQ.getPageContext());
                            a.this.cJn();
                            a.this.jAd = true;
                        }
                    };
                    a.this.jzZ = new TimePickerDialog(a.this.jzQ.getPageContext().getPageActivity(), onTimeSetListener, a.this.cMP, a.this.UB, false);
                }
                a.this.jzZ.updateTime(a.this.cMP, a.this.UB);
                g.a(a.this.jzZ, a.this.jzQ.getPageContext());
            }
        });
        this.jzS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jzR.setText("");
            }
        });
        this.jzV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jzU.setText("");
            }
        });
        this.jAb = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jzR.getText().length() > 0) {
                    a.this.jzS.setVisibility(0);
                    a.this.jzT.setEnabled(true);
                    return;
                }
                a.this.jzS.setVisibility(8);
                a.this.jzT.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jzR.addTextChangedListener(this.jAb);
        this.jAc = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jzU.getText().length() > 0) {
                    a.this.jzV.setVisibility(0);
                } else {
                    a.this.jzV.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jzU.addTextChangedListener(this.jAc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJn() {
        if (this.cMP > 12) {
            this.jzX.setText(this.jzQ.getResources().getString(R.string.afternoon) + " " + (this.cMP - 12) + ":" + (this.UB < 10 ? "0" : "") + this.UB);
        } else {
            this.jzX.setText(this.jzQ.getResources().getString(R.string.morning) + " " + this.cMP + ":" + (this.UB < 10 ? "0" : "") + this.UB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJo() {
        this.jzW.setText(this.Uw + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Ux + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Uy + " " + at.getWeekString(this.Uw, this.Ux, this.Uy));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.jzR.removeTextChangedListener(this.jAb);
        this.jzU.removeTextChangedListener(this.jAc);
    }

    public View cJp() {
        return this.joh;
    }

    public TextView cJq() {
        return this.jzT;
    }

    public String getTitle() {
        return this.jzR.getText().toString();
    }

    public String cJr() {
        return this.jzU.getText().toString();
    }

    public String getContent() {
        return this.jAa.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Uw + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Ux + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Uy + " " + this.cMP + ":" + this.UB).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.jzR.setText(str);
    }

    public void setContent(String str) {
        this.jAa.setText(str);
    }

    public void Ln(String str) {
        this.jzU.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Uw = date.getYear() + FeatureCodes.SKY_SEG;
        this.Ux = date.getMonth();
        this.Uy = date.getDate();
        this.cMP = date.getHours();
        this.UB = date.getMinutes();
        cJo();
        cJn();
    }

    public void onChangeSkinType(int i) {
        this.jzQ.getLayoutMode().setNightMode(i == 1);
        this.jzQ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jzQ.getPageContext(), i);
        this.jzT.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.jzT.setText(this.jzQ.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                Ln(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.jzT.setText(this.jzQ.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cJs() {
        return this.jAd;
    }
}
