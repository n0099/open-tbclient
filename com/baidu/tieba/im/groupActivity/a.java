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
import com.baidu.tbadk.core.util.au;
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
    private int US;
    private int UT;
    private int UU;
    private int UW;
    private int dlH;
    private View jWk;
    private CreateGroupActivityActivity khT;
    private EditText khU;
    private ImageButton khV;
    private TextView khW;
    private EditText khX;
    private ImageButton khY;
    private Button khZ;
    private Button kia;
    private DatePickerDialog kib;
    private TimePickerDialog kic;
    private EditText kie;
    private TextWatcher kif;
    private TextWatcher kig;
    private boolean kih;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.kib = null;
        this.kic = null;
        this.US = 0;
        this.UT = 0;
        this.UU = 0;
        this.dlH = 0;
        this.UW = 0;
        this.kih = false;
        this.khT = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.khT.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.khT.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.jWk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jWk.setOnClickListener(this.khT);
        this.khW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.khT.getResources().getString(R.string.group_activity_create_btntext));
        this.khW.setOnClickListener(this.khT);
        this.khW.setEnabled(false);
        this.khU = (EditText) this.khT.findViewById(R.id.txt_group_activity_name);
        this.khV = (ImageButton) this.khT.findViewById(R.id.btn_del_name);
        this.khX = (EditText) this.khT.findViewById(R.id.txt_group_activity_place);
        this.khY = (ImageButton) this.khT.findViewById(R.id.btn_del_place);
        this.kie = (EditText) this.khT.findViewById(R.id.txt_group_activity_content);
        this.khZ = (Button) this.khT.findViewById(R.id.btn_create_group_date);
        this.kia = (Button) this.khT.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.US = calendar.get(1);
        this.UT = calendar.get(2);
        this.UU = calendar.get(5);
        this.dlH = calendar.get(11);
        this.UW = calendar.get(12);
        cSl();
        cSk();
        this.khT.ShowSoftKeyPadDelay(this.khU, 500);
        this.khZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kib == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.khT.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.US = i;
                            a.this.UT = i2;
                            a.this.UU = i3;
                            g.b(a.this.kib, a.this.khT.getPageContext());
                            a.this.cSl();
                            a.this.kih = true;
                        }
                    };
                    a.this.kib = new DatePickerDialog(a.this.khT.getPageContext().getPageActivity(), onDateSetListener, a.this.US, a.this.UT, a.this.UU);
                }
                a.this.kib.updateDate(a.this.US, a.this.UT, a.this.UU);
                g.a(a.this.kib, a.this.khT.getPageContext());
            }
        });
        this.kia.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kic == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.dlH = i;
                            a.this.UW = i2;
                            g.b(a.this.kic, a.this.khT.getPageContext());
                            a.this.cSk();
                            a.this.kih = true;
                        }
                    };
                    a.this.kic = new TimePickerDialog(a.this.khT.getPageContext().getPageActivity(), onTimeSetListener, a.this.dlH, a.this.UW, false);
                }
                a.this.kic.updateTime(a.this.dlH, a.this.UW);
                g.a(a.this.kic, a.this.khT.getPageContext());
            }
        });
        this.khV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.khU.setText("");
            }
        });
        this.khY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.khX.setText("");
            }
        });
        this.kif = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.khU.getText().length() > 0) {
                    a.this.khV.setVisibility(0);
                    a.this.khW.setEnabled(true);
                    return;
                }
                a.this.khV.setVisibility(8);
                a.this.khW.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.khU.addTextChangedListener(this.kif);
        this.kig = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.khX.getText().length() > 0) {
                    a.this.khY.setVisibility(0);
                } else {
                    a.this.khY.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.khX.addTextChangedListener(this.kig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSk() {
        if (this.dlH > 12) {
            this.kia.setText(this.khT.getResources().getString(R.string.afternoon) + " " + (this.dlH - 12) + ":" + (this.UW < 10 ? "0" : "") + this.UW);
        } else {
            this.kia.setText(this.khT.getResources().getString(R.string.morning) + " " + this.dlH + ":" + (this.UW < 10 ? "0" : "") + this.UW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSl() {
        this.khZ.setText(this.US + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.UT + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UU + " " + au.getWeekString(this.US, this.UT, this.UU));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.khU.removeTextChangedListener(this.kif);
        this.khX.removeTextChangedListener(this.kig);
    }

    public View cSm() {
        return this.jWk;
    }

    public TextView cSn() {
        return this.khW;
    }

    public String getTitle() {
        return this.khU.getText().toString();
    }

    public String cSo() {
        return this.khX.getText().toString();
    }

    public String getContent() {
        return this.kie.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.US + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.UT + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UU + " " + this.dlH + ":" + this.UW).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.khU.setText(str);
    }

    public void setContent(String str) {
        this.kie.setText(str);
    }

    public void Ms(String str) {
        this.khX.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.US = date.getYear() + FeatureCodes.SKY_SEG;
        this.UT = date.getMonth();
        this.UU = date.getDate();
        this.dlH = date.getHours();
        this.UW = date.getMinutes();
        cSl();
        cSk();
    }

    public void onChangeSkinType(int i) {
        this.khT.getLayoutMode().setNightMode(i == 1);
        this.khT.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.khT.getPageContext(), i);
        this.khW.setTextColor(ap.getColor(R.color.CAM_X0106));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.khW.setText(this.khT.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                Ms(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.khW.setText(this.khT.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cSp() {
        return this.kih;
    }
}
