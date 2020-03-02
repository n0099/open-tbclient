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
    private int bKw;
    private CreateGroupActivityActivity hBR;
    private EditText hBS;
    private ImageButton hBT;
    private TextView hBU;
    private EditText hBV;
    private ImageButton hBW;
    private Button hBX;
    private Button hBY;
    private DatePickerDialog hBZ;
    private TimePickerDialog hCa;
    private EditText hCb;
    private TextWatcher hCc;
    private TextWatcher hCd;
    private boolean hCe;
    private View hsk;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int zD;
    private int zE;
    private int zF;
    private int zH;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.hBZ = null;
        this.hCa = null;
        this.zD = 0;
        this.zE = 0;
        this.zF = 0;
        this.bKw = 0;
        this.zH = 0;
        this.hCe = false;
        this.hBR = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.hBR.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hBR.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.hsk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hsk.setOnClickListener(this.hBR);
        this.hBU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hBR.getResources().getString(R.string.group_activity_create_btntext));
        this.hBU.setOnClickListener(this.hBR);
        this.hBU.setEnabled(false);
        this.hBS = (EditText) this.hBR.findViewById(R.id.txt_group_activity_name);
        this.hBT = (ImageButton) this.hBR.findViewById(R.id.btn_del_name);
        this.hBV = (EditText) this.hBR.findViewById(R.id.txt_group_activity_place);
        this.hBW = (ImageButton) this.hBR.findViewById(R.id.btn_del_place);
        this.hCb = (EditText) this.hBR.findViewById(R.id.txt_group_activity_content);
        this.hBX = (Button) this.hBR.findViewById(R.id.btn_create_group_date);
        this.hBY = (Button) this.hBR.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.zD = calendar.get(1);
        this.zE = calendar.get(2);
        this.zF = calendar.get(5);
        this.bKw = calendar.get(11);
        this.zH = calendar.get(12);
        bVD();
        bVC();
        this.hBR.ShowSoftKeyPadDelay(this.hBS, 500);
        this.hBX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hBZ == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.hBR.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.zD = i;
                            a.this.zE = i2;
                            a.this.zF = i3;
                            g.b(a.this.hBZ, a.this.hBR.getPageContext());
                            a.this.bVD();
                            a.this.hCe = true;
                        }
                    };
                    a.this.hBZ = new DatePickerDialog(a.this.hBR.getPageContext().getPageActivity(), onDateSetListener, a.this.zD, a.this.zE, a.this.zF);
                }
                a.this.hBZ.updateDate(a.this.zD, a.this.zE, a.this.zF);
                g.a(a.this.hBZ, a.this.hBR.getPageContext());
            }
        });
        this.hBY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hCa == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.bKw = i;
                            a.this.zH = i2;
                            g.b(a.this.hCa, a.this.hBR.getPageContext());
                            a.this.bVC();
                            a.this.hCe = true;
                        }
                    };
                    a.this.hCa = new TimePickerDialog(a.this.hBR.getPageContext().getPageActivity(), onTimeSetListener, a.this.bKw, a.this.zH, false);
                }
                a.this.hCa.updateTime(a.this.bKw, a.this.zH);
                g.a(a.this.hCa, a.this.hBR.getPageContext());
            }
        });
        this.hBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hBS.setText("");
            }
        });
        this.hBW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hBV.setText("");
            }
        });
        this.hCc = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hBS.getText().length() > 0) {
                    a.this.hBT.setVisibility(0);
                    a.this.hBU.setEnabled(true);
                    return;
                }
                a.this.hBT.setVisibility(8);
                a.this.hBU.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hBS.addTextChangedListener(this.hCc);
        this.hCd = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hBV.getText().length() > 0) {
                    a.this.hBW.setVisibility(0);
                } else {
                    a.this.hBW.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hBV.addTextChangedListener(this.hCd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVC() {
        if (this.bKw > 12) {
            this.hBY.setText(this.hBR.getResources().getString(R.string.afternoon) + HanziToPinyin.Token.SEPARATOR + (this.bKw - 12) + ":" + (this.zH < 10 ? "0" : "") + this.zH);
        } else {
            this.hBY.setText(this.hBR.getResources().getString(R.string.morning) + HanziToPinyin.Token.SEPARATOR + this.bKw + ":" + (this.zH < 10 ? "0" : "") + this.zH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVD() {
        this.hBX.setText(this.zD + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zE + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zF + HanziToPinyin.Token.SEPARATOR + aq.getWeekString(this.zD, this.zE, this.zF));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.hBS.removeTextChangedListener(this.hCc);
        this.hBV.removeTextChangedListener(this.hCd);
    }

    public View bVE() {
        return this.hsk;
    }

    public TextView bVF() {
        return this.hBU;
    }

    public String getTitle() {
        return this.hBS.getText().toString();
    }

    public String bVG() {
        return this.hBV.getText().toString();
    }

    public String getContent() {
        return this.hCb.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.zD + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zE + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zF + HanziToPinyin.Token.SEPARATOR + this.bKw + ":" + this.zH).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.hBS.setText(str);
    }

    public void setContent(String str) {
        this.hCb.setText(str);
    }

    public void Dg(String str) {
        this.hBV.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.zD = date.getYear() + 1900;
        this.zE = date.getMonth();
        this.zF = date.getDate();
        this.bKw = date.getHours();
        this.zH = date.getMinutes();
        bVD();
        bVC();
    }

    public void onChangeSkinType(int i) {
        this.hBR.getLayoutMode().setNightMode(i == 1);
        this.hBR.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hBR.getPageContext(), i);
        this.hBU.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.hBU.setText(this.hBR.getPageContext().getContext().getString(R.string.done));
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
        this.hBU.setText(this.hBR.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bVH() {
        return this.hCe;
    }
}
