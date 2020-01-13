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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
/* loaded from: classes8.dex */
public class a extends c<BaseFragmentActivity> {
    private int bGq;
    private EditText hAa;
    private TextWatcher hAb;
    private TextWatcher hAc;
    private boolean hAd;
    private View hqj;
    private CreateGroupActivityActivity hzQ;
    private EditText hzR;
    private ImageButton hzS;
    private TextView hzT;
    private EditText hzU;
    private ImageButton hzV;
    private Button hzW;
    private Button hzX;
    private DatePickerDialog hzY;
    private TimePickerDialog hzZ;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int zl;
    private int zm;
    private int zn;
    private int zp;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.hzY = null;
        this.hzZ = null;
        this.zl = 0;
        this.zm = 0;
        this.zn = 0;
        this.bGq = 0;
        this.zp = 0;
        this.hAd = false;
        this.hzQ = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.hzQ.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hzQ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.hqj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hqj.setOnClickListener(this.hzQ);
        this.hzT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hzQ.getResources().getString(R.string.group_activity_create_btntext));
        this.hzT.setOnClickListener(this.hzQ);
        this.hzT.setEnabled(false);
        this.hzR = (EditText) this.hzQ.findViewById(R.id.txt_group_activity_name);
        this.hzS = (ImageButton) this.hzQ.findViewById(R.id.btn_del_name);
        this.hzU = (EditText) this.hzQ.findViewById(R.id.txt_group_activity_place);
        this.hzV = (ImageButton) this.hzQ.findViewById(R.id.btn_del_place);
        this.hAa = (EditText) this.hzQ.findViewById(R.id.txt_group_activity_content);
        this.hzW = (Button) this.hzQ.findViewById(R.id.btn_create_group_date);
        this.hzX = (Button) this.hzQ.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.zl = calendar.get(1);
        this.zm = calendar.get(2);
        this.zn = calendar.get(5);
        this.bGq = calendar.get(11);
        this.zp = calendar.get(12);
        bUa();
        bTZ();
        this.hzQ.ShowSoftKeyPadDelay(this.hzR, 500);
        this.hzW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hzY == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.hzQ.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.zl = i;
                            a.this.zm = i2;
                            a.this.zn = i3;
                            g.b(a.this.hzY, a.this.hzQ.getPageContext());
                            a.this.bUa();
                            a.this.hAd = true;
                        }
                    };
                    a.this.hzY = new DatePickerDialog(a.this.hzQ.getPageContext().getPageActivity(), onDateSetListener, a.this.zl, a.this.zm, a.this.zn);
                }
                a.this.hzY.updateDate(a.this.zl, a.this.zm, a.this.zn);
                g.a(a.this.hzY, a.this.hzQ.getPageContext());
            }
        });
        this.hzX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hzZ == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.bGq = i;
                            a.this.zp = i2;
                            g.b(a.this.hzZ, a.this.hzQ.getPageContext());
                            a.this.bTZ();
                            a.this.hAd = true;
                        }
                    };
                    a.this.hzZ = new TimePickerDialog(a.this.hzQ.getPageContext().getPageActivity(), onTimeSetListener, a.this.bGq, a.this.zp, false);
                }
                a.this.hzZ.updateTime(a.this.bGq, a.this.zp);
                g.a(a.this.hzZ, a.this.hzQ.getPageContext());
            }
        });
        this.hzS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hzR.setText("");
            }
        });
        this.hzV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hzU.setText("");
            }
        });
        this.hAb = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hzR.getText().length() > 0) {
                    a.this.hzS.setVisibility(0);
                    a.this.hzT.setEnabled(true);
                    return;
                }
                a.this.hzS.setVisibility(8);
                a.this.hzT.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hzR.addTextChangedListener(this.hAb);
        this.hAc = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hzU.getText().length() > 0) {
                    a.this.hzV.setVisibility(0);
                } else {
                    a.this.hzV.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hzU.addTextChangedListener(this.hAc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTZ() {
        if (this.bGq > 12) {
            this.hzX.setText(this.hzQ.getResources().getString(R.string.afternoon) + HanziToPinyin.Token.SEPARATOR + (this.bGq - 12) + ":" + (this.zp < 10 ? "0" : "") + this.zp);
        } else {
            this.hzX.setText(this.hzQ.getResources().getString(R.string.morning) + HanziToPinyin.Token.SEPARATOR + this.bGq + ":" + (this.zp < 10 ? "0" : "") + this.zp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUa() {
        this.hzW.setText(this.zl + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zm + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zn + HanziToPinyin.Token.SEPARATOR + aq.getWeekString(this.zl, this.zm, this.zn));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.hzR.removeTextChangedListener(this.hAb);
        this.hzU.removeTextChangedListener(this.hAc);
    }

    public View bUb() {
        return this.hqj;
    }

    public TextView bUc() {
        return this.hzT;
    }

    public String getTitle() {
        return this.hzR.getText().toString();
    }

    public String bUd() {
        return this.hzU.getText().toString();
    }

    public String getContent() {
        return this.hAa.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.zl + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zm + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zn + HanziToPinyin.Token.SEPARATOR + this.bGq + ":" + this.zp).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.hzR.setText(str);
    }

    public void setContent(String str) {
        this.hAa.setText(str);
    }

    public void CQ(String str) {
        this.hzU.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.zl = date.getYear() + 1900;
        this.zm = date.getMonth();
        this.zn = date.getDate();
        this.bGq = date.getHours();
        this.zp = date.getMinutes();
        bUa();
        bTZ();
    }

    public void onChangeSkinType(int i) {
        this.hzQ.getLayoutMode().setNightMode(i == 1);
        this.hzQ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hzQ.getPageContext(), i);
        this.hzT.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.hzT.setText(this.hzQ.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                CQ(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.hzT.setText(this.hzQ.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bUe() {
        return this.hAd;
    }
}
