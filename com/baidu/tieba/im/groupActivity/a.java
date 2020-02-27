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
/* loaded from: classes10.dex */
public class a extends c<BaseFragmentActivity> {
    private int bKv;
    private CreateGroupActivityActivity hBP;
    private EditText hBQ;
    private ImageButton hBR;
    private TextView hBS;
    private EditText hBT;
    private ImageButton hBU;
    private Button hBV;
    private Button hBW;
    private DatePickerDialog hBX;
    private TimePickerDialog hBY;
    private EditText hBZ;
    private TextWatcher hCa;
    private TextWatcher hCb;
    private boolean hCc;
    private View hsi;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int zD;
    private int zE;
    private int zF;
    private int zH;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.hBX = null;
        this.hBY = null;
        this.zD = 0;
        this.zE = 0;
        this.zF = 0;
        this.bKv = 0;
        this.zH = 0;
        this.hCc = false;
        this.hBP = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.hBP.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hBP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.hsi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hsi.setOnClickListener(this.hBP);
        this.hBS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hBP.getResources().getString(R.string.group_activity_create_btntext));
        this.hBS.setOnClickListener(this.hBP);
        this.hBS.setEnabled(false);
        this.hBQ = (EditText) this.hBP.findViewById(R.id.txt_group_activity_name);
        this.hBR = (ImageButton) this.hBP.findViewById(R.id.btn_del_name);
        this.hBT = (EditText) this.hBP.findViewById(R.id.txt_group_activity_place);
        this.hBU = (ImageButton) this.hBP.findViewById(R.id.btn_del_place);
        this.hBZ = (EditText) this.hBP.findViewById(R.id.txt_group_activity_content);
        this.hBV = (Button) this.hBP.findViewById(R.id.btn_create_group_date);
        this.hBW = (Button) this.hBP.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.zD = calendar.get(1);
        this.zE = calendar.get(2);
        this.zF = calendar.get(5);
        this.bKv = calendar.get(11);
        this.zH = calendar.get(12);
        bVB();
        bVA();
        this.hBP.ShowSoftKeyPadDelay(this.hBQ, 500);
        this.hBV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hBX == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.hBP.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.zD = i;
                            a.this.zE = i2;
                            a.this.zF = i3;
                            g.b(a.this.hBX, a.this.hBP.getPageContext());
                            a.this.bVB();
                            a.this.hCc = true;
                        }
                    };
                    a.this.hBX = new DatePickerDialog(a.this.hBP.getPageContext().getPageActivity(), onDateSetListener, a.this.zD, a.this.zE, a.this.zF);
                }
                a.this.hBX.updateDate(a.this.zD, a.this.zE, a.this.zF);
                g.a(a.this.hBX, a.this.hBP.getPageContext());
            }
        });
        this.hBW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hBY == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.bKv = i;
                            a.this.zH = i2;
                            g.b(a.this.hBY, a.this.hBP.getPageContext());
                            a.this.bVA();
                            a.this.hCc = true;
                        }
                    };
                    a.this.hBY = new TimePickerDialog(a.this.hBP.getPageContext().getPageActivity(), onTimeSetListener, a.this.bKv, a.this.zH, false);
                }
                a.this.hBY.updateTime(a.this.bKv, a.this.zH);
                g.a(a.this.hBY, a.this.hBP.getPageContext());
            }
        });
        this.hBR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hBQ.setText("");
            }
        });
        this.hBU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hBT.setText("");
            }
        });
        this.hCa = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hBQ.getText().length() > 0) {
                    a.this.hBR.setVisibility(0);
                    a.this.hBS.setEnabled(true);
                    return;
                }
                a.this.hBR.setVisibility(8);
                a.this.hBS.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hBQ.addTextChangedListener(this.hCa);
        this.hCb = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hBT.getText().length() > 0) {
                    a.this.hBU.setVisibility(0);
                } else {
                    a.this.hBU.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hBT.addTextChangedListener(this.hCb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVA() {
        if (this.bKv > 12) {
            this.hBW.setText(this.hBP.getResources().getString(R.string.afternoon) + HanziToPinyin.Token.SEPARATOR + (this.bKv - 12) + ":" + (this.zH < 10 ? "0" : "") + this.zH);
        } else {
            this.hBW.setText(this.hBP.getResources().getString(R.string.morning) + HanziToPinyin.Token.SEPARATOR + this.bKv + ":" + (this.zH < 10 ? "0" : "") + this.zH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVB() {
        this.hBV.setText(this.zD + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zE + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zF + HanziToPinyin.Token.SEPARATOR + aq.getWeekString(this.zD, this.zE, this.zF));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.hBQ.removeTextChangedListener(this.hCa);
        this.hBT.removeTextChangedListener(this.hCb);
    }

    public View bVC() {
        return this.hsi;
    }

    public TextView bVD() {
        return this.hBS;
    }

    public String getTitle() {
        return this.hBQ.getText().toString();
    }

    public String bVE() {
        return this.hBT.getText().toString();
    }

    public String getContent() {
        return this.hBZ.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.zD + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zE + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zF + HanziToPinyin.Token.SEPARATOR + this.bKv + ":" + this.zH).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.hBQ.setText(str);
    }

    public void setContent(String str) {
        this.hBZ.setText(str);
    }

    public void Dg(String str) {
        this.hBT.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.zD = date.getYear() + 1900;
        this.zE = date.getMonth();
        this.zF = date.getDate();
        this.bKv = date.getHours();
        this.zH = date.getMinutes();
        bVB();
        bVA();
    }

    public void onChangeSkinType(int i) {
        this.hBP.getLayoutMode().setNightMode(i == 1);
        this.hBP.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hBP.getPageContext(), i);
        this.hBS.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.hBS.setText(this.hBP.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                Dg(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.hBS.setText(this.hBP.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bVF() {
        return this.hCc;
    }
}
