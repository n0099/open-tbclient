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
    private int bKI;
    private CreateGroupActivityActivity hDD;
    private EditText hDE;
    private ImageButton hDF;
    private TextView hDG;
    private EditText hDH;
    private ImageButton hDI;
    private Button hDJ;
    private Button hDK;
    private DatePickerDialog hDL;
    private TimePickerDialog hDM;
    private EditText hDN;
    private TextWatcher hDO;
    private TextWatcher hDP;
    private boolean hDQ;
    private View htW;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int zD;
    private int zE;
    private int zF;
    private int zH;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.hDL = null;
        this.hDM = null;
        this.zD = 0;
        this.zE = 0;
        this.zF = 0;
        this.bKI = 0;
        this.zH = 0;
        this.hDQ = false;
        this.hDD = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.hDD.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hDD.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.htW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.htW.setOnClickListener(this.hDD);
        this.hDG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hDD.getResources().getString(R.string.group_activity_create_btntext));
        this.hDG.setOnClickListener(this.hDD);
        this.hDG.setEnabled(false);
        this.hDE = (EditText) this.hDD.findViewById(R.id.txt_group_activity_name);
        this.hDF = (ImageButton) this.hDD.findViewById(R.id.btn_del_name);
        this.hDH = (EditText) this.hDD.findViewById(R.id.txt_group_activity_place);
        this.hDI = (ImageButton) this.hDD.findViewById(R.id.btn_del_place);
        this.hDN = (EditText) this.hDD.findViewById(R.id.txt_group_activity_content);
        this.hDJ = (Button) this.hDD.findViewById(R.id.btn_create_group_date);
        this.hDK = (Button) this.hDD.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.zD = calendar.get(1);
        this.zE = calendar.get(2);
        this.zF = calendar.get(5);
        this.bKI = calendar.get(11);
        this.zH = calendar.get(12);
        bVW();
        bVV();
        this.hDD.ShowSoftKeyPadDelay(this.hDE, 500);
        this.hDJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hDL == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.hDD.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.zD = i;
                            a.this.zE = i2;
                            a.this.zF = i3;
                            g.b(a.this.hDL, a.this.hDD.getPageContext());
                            a.this.bVW();
                            a.this.hDQ = true;
                        }
                    };
                    a.this.hDL = new DatePickerDialog(a.this.hDD.getPageContext().getPageActivity(), onDateSetListener, a.this.zD, a.this.zE, a.this.zF);
                }
                a.this.hDL.updateDate(a.this.zD, a.this.zE, a.this.zF);
                g.a(a.this.hDL, a.this.hDD.getPageContext());
            }
        });
        this.hDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hDM == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.bKI = i;
                            a.this.zH = i2;
                            g.b(a.this.hDM, a.this.hDD.getPageContext());
                            a.this.bVV();
                            a.this.hDQ = true;
                        }
                    };
                    a.this.hDM = new TimePickerDialog(a.this.hDD.getPageContext().getPageActivity(), onTimeSetListener, a.this.bKI, a.this.zH, false);
                }
                a.this.hDM.updateTime(a.this.bKI, a.this.zH);
                g.a(a.this.hDM, a.this.hDD.getPageContext());
            }
        });
        this.hDF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hDE.setText("");
            }
        });
        this.hDI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hDH.setText("");
            }
        });
        this.hDO = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hDE.getText().length() > 0) {
                    a.this.hDF.setVisibility(0);
                    a.this.hDG.setEnabled(true);
                    return;
                }
                a.this.hDF.setVisibility(8);
                a.this.hDG.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hDE.addTextChangedListener(this.hDO);
        this.hDP = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hDH.getText().length() > 0) {
                    a.this.hDI.setVisibility(0);
                } else {
                    a.this.hDI.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hDH.addTextChangedListener(this.hDP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVV() {
        if (this.bKI > 12) {
            this.hDK.setText(this.hDD.getResources().getString(R.string.afternoon) + HanziToPinyin.Token.SEPARATOR + (this.bKI - 12) + ":" + (this.zH < 10 ? "0" : "") + this.zH);
        } else {
            this.hDK.setText(this.hDD.getResources().getString(R.string.morning) + HanziToPinyin.Token.SEPARATOR + this.bKI + ":" + (this.zH < 10 ? "0" : "") + this.zH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVW() {
        this.hDJ.setText(this.zD + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zE + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zF + HanziToPinyin.Token.SEPARATOR + aq.getWeekString(this.zD, this.zE, this.zF));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.hDE.removeTextChangedListener(this.hDO);
        this.hDH.removeTextChangedListener(this.hDP);
    }

    public View bVX() {
        return this.htW;
    }

    public TextView bVY() {
        return this.hDG;
    }

    public String getTitle() {
        return this.hDE.getText().toString();
    }

    public String bVZ() {
        return this.hDH.getText().toString();
    }

    public String getContent() {
        return this.hDN.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.zD + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.zE + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zF + HanziToPinyin.Token.SEPARATOR + this.bKI + ":" + this.zH).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.hDE.setText(str);
    }

    public void setContent(String str) {
        this.hDN.setText(str);
    }

    public void Dh(String str) {
        this.hDH.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.zD = date.getYear() + 1900;
        this.zE = date.getMonth();
        this.zF = date.getDate();
        this.bKI = date.getHours();
        this.zH = date.getMinutes();
        bVW();
        bVV();
    }

    public void onChangeSkinType(int i) {
        this.hDD.getLayoutMode().setNightMode(i == 1);
        this.hDD.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hDD.getPageContext(), i);
        this.hDG.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.hDG.setText(this.hDD.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                Dh(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.hDG.setText(this.hDD.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bWa() {
        return this.hDQ;
    }
}
