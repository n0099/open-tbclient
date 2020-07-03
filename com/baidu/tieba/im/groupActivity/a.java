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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
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
    private int TG;
    private int TH;
    private int TI;
    private int TK;
    private int czN;
    private View iKr;
    private CreateGroupActivityActivity iTW;
    private EditText iTX;
    private ImageButton iTY;
    private TextView iTZ;
    private EditText iUa;
    private ImageButton iUb;
    private Button iUc;
    private Button iUd;
    private DatePickerDialog iUe;
    private TimePickerDialog iUf;
    private EditText iUg;
    private TextWatcher iUh;
    private TextWatcher iUi;
    private boolean iUj;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.iUe = null;
        this.iUf = null;
        this.TG = 0;
        this.TH = 0;
        this.TI = 0;
        this.czN = 0;
        this.TK = 0;
        this.iUj = false;
        this.iTW = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.iTW.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.iTW.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.iKr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iKr.setOnClickListener(this.iTW);
        this.iTZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iTW.getResources().getString(R.string.group_activity_create_btntext));
        this.iTZ.setOnClickListener(this.iTW);
        this.iTZ.setEnabled(false);
        this.iTX = (EditText) this.iTW.findViewById(R.id.txt_group_activity_name);
        this.iTY = (ImageButton) this.iTW.findViewById(R.id.btn_del_name);
        this.iUa = (EditText) this.iTW.findViewById(R.id.txt_group_activity_place);
        this.iUb = (ImageButton) this.iTW.findViewById(R.id.btn_del_place);
        this.iUg = (EditText) this.iTW.findViewById(R.id.txt_group_activity_content);
        this.iUc = (Button) this.iTW.findViewById(R.id.btn_create_group_date);
        this.iUd = (Button) this.iTW.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.TG = calendar.get(1);
        this.TH = calendar.get(2);
        this.TI = calendar.get(5);
        this.czN = calendar.get(11);
        this.TK = calendar.get(12);
        cqR();
        cqQ();
        this.iTW.ShowSoftKeyPadDelay(this.iTX, 500);
        this.iUc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iUe == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.iTW.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.TG = i;
                            a.this.TH = i2;
                            a.this.TI = i3;
                            g.b(a.this.iUe, a.this.iTW.getPageContext());
                            a.this.cqR();
                            a.this.iUj = true;
                        }
                    };
                    a.this.iUe = new DatePickerDialog(a.this.iTW.getPageContext().getPageActivity(), onDateSetListener, a.this.TG, a.this.TH, a.this.TI);
                }
                a.this.iUe.updateDate(a.this.TG, a.this.TH, a.this.TI);
                g.a(a.this.iUe, a.this.iTW.getPageContext());
            }
        });
        this.iUd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iUf == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.czN = i;
                            a.this.TK = i2;
                            g.b(a.this.iUf, a.this.iTW.getPageContext());
                            a.this.cqQ();
                            a.this.iUj = true;
                        }
                    };
                    a.this.iUf = new TimePickerDialog(a.this.iTW.getPageContext().getPageActivity(), onTimeSetListener, a.this.czN, a.this.TK, false);
                }
                a.this.iUf.updateTime(a.this.czN, a.this.TK);
                g.a(a.this.iUf, a.this.iTW.getPageContext());
            }
        });
        this.iTY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iTX.setText("");
            }
        });
        this.iUb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iUa.setText("");
            }
        });
        this.iUh = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.iTX.getText().length() > 0) {
                    a.this.iTY.setVisibility(0);
                    a.this.iTZ.setEnabled(true);
                    return;
                }
                a.this.iTY.setVisibility(8);
                a.this.iTZ.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.iTX.addTextChangedListener(this.iUh);
        this.iUi = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.iUa.getText().length() > 0) {
                    a.this.iUb.setVisibility(0);
                } else {
                    a.this.iUb.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.iUa.addTextChangedListener(this.iUi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqQ() {
        if (this.czN > 12) {
            this.iUd.setText(this.iTW.getResources().getString(R.string.afternoon) + " " + (this.czN - 12) + ":" + (this.TK < 10 ? "0" : "") + this.TK);
        } else {
            this.iUd.setText(this.iTW.getResources().getString(R.string.morning) + " " + this.czN + ":" + (this.TK < 10 ? "0" : "") + this.TK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqR() {
        this.iUc.setText(this.TG + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.TH + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.TI + " " + ar.getWeekString(this.TG, this.TH, this.TI));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.iTX.removeTextChangedListener(this.iUh);
        this.iUa.removeTextChangedListener(this.iUi);
    }

    public View cqS() {
        return this.iKr;
    }

    public TextView cqT() {
        return this.iTZ;
    }

    public String getTitle() {
        return this.iTX.getText().toString();
    }

    public String cqU() {
        return this.iUa.getText().toString();
    }

    public String getContent() {
        return this.iUg.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.TG + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.TH + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.TI + " " + this.czN + ":" + this.TK).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.iTX.setText(str);
    }

    public void setContent(String str) {
        this.iUg.setText(str);
    }

    public void Hd(String str) {
        this.iUa.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.TG = date.getYear() + FeatureCodes.SKY_SEG;
        this.TH = date.getMonth();
        this.TI = date.getDate();
        this.czN = date.getHours();
        this.TK = date.getMinutes();
        cqR();
        cqQ();
    }

    public void onChangeSkinType(int i) {
        this.iTW.getLayoutMode().setNightMode(i == 1);
        this.iTW.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iTW.getPageContext(), i);
        this.iTZ.setTextColor(an.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.iTZ.setText(this.iTW.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                Hd(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.iTZ.setText(this.iTW.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cqV() {
        return this.iUj;
    }
}
