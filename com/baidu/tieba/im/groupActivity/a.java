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
    private int Te;
    private int Tf;
    private int Tg;
    private int Ti;
    private int cvc;
    private CreateGroupActivityActivity iCf;
    private EditText iCg;
    private ImageButton iCh;
    private TextView iCi;
    private EditText iCj;
    private ImageButton iCk;
    private Button iCl;
    private Button iCm;
    private DatePickerDialog iCn;
    private TimePickerDialog iCo;
    private EditText iCp;
    private TextWatcher iCq;
    private TextWatcher iCr;
    private boolean iCs;
    private View isy;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.iCn = null;
        this.iCo = null;
        this.Te = 0;
        this.Tf = 0;
        this.Tg = 0;
        this.cvc = 0;
        this.Ti = 0;
        this.iCs = false;
        this.iCf = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.iCf.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.iCf.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.isy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.isy.setOnClickListener(this.iCf);
        this.iCi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iCf.getResources().getString(R.string.group_activity_create_btntext));
        this.iCi.setOnClickListener(this.iCf);
        this.iCi.setEnabled(false);
        this.iCg = (EditText) this.iCf.findViewById(R.id.txt_group_activity_name);
        this.iCh = (ImageButton) this.iCf.findViewById(R.id.btn_del_name);
        this.iCj = (EditText) this.iCf.findViewById(R.id.txt_group_activity_place);
        this.iCk = (ImageButton) this.iCf.findViewById(R.id.btn_del_place);
        this.iCp = (EditText) this.iCf.findViewById(R.id.txt_group_activity_content);
        this.iCl = (Button) this.iCf.findViewById(R.id.btn_create_group_date);
        this.iCm = (Button) this.iCf.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Te = calendar.get(1);
        this.Tf = calendar.get(2);
        this.Tg = calendar.get(5);
        this.cvc = calendar.get(11);
        this.Ti = calendar.get(12);
        cmT();
        cmS();
        this.iCf.ShowSoftKeyPadDelay(this.iCg, 500);
        this.iCl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iCn == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.iCf.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.Te = i;
                            a.this.Tf = i2;
                            a.this.Tg = i3;
                            g.b(a.this.iCn, a.this.iCf.getPageContext());
                            a.this.cmT();
                            a.this.iCs = true;
                        }
                    };
                    a.this.iCn = new DatePickerDialog(a.this.iCf.getPageContext().getPageActivity(), onDateSetListener, a.this.Te, a.this.Tf, a.this.Tg);
                }
                a.this.iCn.updateDate(a.this.Te, a.this.Tf, a.this.Tg);
                g.a(a.this.iCn, a.this.iCf.getPageContext());
            }
        });
        this.iCm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iCo == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.cvc = i;
                            a.this.Ti = i2;
                            g.b(a.this.iCo, a.this.iCf.getPageContext());
                            a.this.cmS();
                            a.this.iCs = true;
                        }
                    };
                    a.this.iCo = new TimePickerDialog(a.this.iCf.getPageContext().getPageActivity(), onTimeSetListener, a.this.cvc, a.this.Ti, false);
                }
                a.this.iCo.updateTime(a.this.cvc, a.this.Ti);
                g.a(a.this.iCo, a.this.iCf.getPageContext());
            }
        });
        this.iCh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iCg.setText("");
            }
        });
        this.iCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iCj.setText("");
            }
        });
        this.iCq = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.iCg.getText().length() > 0) {
                    a.this.iCh.setVisibility(0);
                    a.this.iCi.setEnabled(true);
                    return;
                }
                a.this.iCh.setVisibility(8);
                a.this.iCi.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.iCg.addTextChangedListener(this.iCq);
        this.iCr = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.iCj.getText().length() > 0) {
                    a.this.iCk.setVisibility(0);
                } else {
                    a.this.iCk.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.iCj.addTextChangedListener(this.iCr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmS() {
        if (this.cvc > 12) {
            this.iCm.setText(this.iCf.getResources().getString(R.string.afternoon) + " " + (this.cvc - 12) + ":" + (this.Ti < 10 ? "0" : "") + this.Ti);
        } else {
            this.iCm.setText(this.iCf.getResources().getString(R.string.morning) + " " + this.cvc + ":" + (this.Ti < 10 ? "0" : "") + this.Ti);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmT() {
        this.iCl.setText(this.Te + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Tf + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tg + " " + aq.getWeekString(this.Te, this.Tf, this.Tg));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.iCg.removeTextChangedListener(this.iCq);
        this.iCj.removeTextChangedListener(this.iCr);
    }

    public View cmU() {
        return this.isy;
    }

    public TextView cmV() {
        return this.iCi;
    }

    public String getTitle() {
        return this.iCg.getText().toString();
    }

    public String cmW() {
        return this.iCj.getText().toString();
    }

    public String getContent() {
        return this.iCp.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Te + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Tf + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tg + " " + this.cvc + ":" + this.Ti).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.iCg.setText(str);
    }

    public void setContent(String str) {
        this.iCp.setText(str);
    }

    public void GB(String str) {
        this.iCj.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Te = date.getYear() + FeatureCodes.SKY_SEG;
        this.Tf = date.getMonth();
        this.Tg = date.getDate();
        this.cvc = date.getHours();
        this.Ti = date.getMinutes();
        cmT();
        cmS();
    }

    public void onChangeSkinType(int i) {
        this.iCf.getLayoutMode().setNightMode(i == 1);
        this.iCf.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iCf.getPageContext(), i);
        this.iCi.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.iCi.setText(this.iCf.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                GB(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.iCi.setText(this.iCf.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cmX() {
        return this.iCs;
    }
}
