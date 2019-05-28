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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class a extends c<BaseFragmentActivity> {
    private int Kn;
    private int Ko;
    private int Kp;
    private int Kr;
    private int aHS;
    private TextWatcher fhh;
    private CreateGroupActivityActivity gCg;
    private EditText gCh;
    private ImageButton gCi;
    private TextView gCj;
    private EditText gCk;
    private ImageButton gCl;
    private Button gCm;
    private Button gCn;
    private DatePickerDialog gCo;
    private TimePickerDialog gCp;
    private EditText gCq;
    private TextWatcher gCr;
    private boolean gCs;
    private View gsu;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.gCo = null;
        this.gCp = null;
        this.Kn = 0;
        this.Ko = 0;
        this.Kp = 0;
        this.aHS = 0;
        this.Kr = 0;
        this.gCs = false;
        this.gCg = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.gCg.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gCg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.gsu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gsu.setOnClickListener(this.gCg);
        this.gCj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gCg.getResources().getString(R.string.group_activity_create_btntext));
        this.gCj.setOnClickListener(this.gCg);
        this.gCj.setEnabled(false);
        this.gCh = (EditText) this.gCg.findViewById(R.id.txt_group_activity_name);
        this.gCi = (ImageButton) this.gCg.findViewById(R.id.btn_del_name);
        this.gCk = (EditText) this.gCg.findViewById(R.id.txt_group_activity_place);
        this.gCl = (ImageButton) this.gCg.findViewById(R.id.btn_del_place);
        this.gCq = (EditText) this.gCg.findViewById(R.id.txt_group_activity_content);
        this.gCm = (Button) this.gCg.findViewById(R.id.btn_create_group_date);
        this.gCn = (Button) this.gCg.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Kn = calendar.get(1);
        this.Ko = calendar.get(2);
        this.Kp = calendar.get(5);
        this.aHS = calendar.get(11);
        this.Kr = calendar.get(12);
        bBl();
        bBk();
        this.gCg.ShowSoftKeyPadDelay(this.gCh, 500);
        this.gCm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gCo == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.gCg.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.Kn = i;
                            a.this.Ko = i2;
                            a.this.Kp = i3;
                            g.b(a.this.gCo, a.this.gCg.getPageContext());
                            a.this.bBl();
                            a.this.gCs = true;
                        }
                    };
                    a.this.gCo = new DatePickerDialog(a.this.gCg.getPageContext().getPageActivity(), onDateSetListener, a.this.Kn, a.this.Ko, a.this.Kp);
                }
                a.this.gCo.updateDate(a.this.Kn, a.this.Ko, a.this.Kp);
                g.a(a.this.gCo, a.this.gCg.getPageContext());
            }
        });
        this.gCn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gCp == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.aHS = i;
                            a.this.Kr = i2;
                            g.b(a.this.gCp, a.this.gCg.getPageContext());
                            a.this.bBk();
                            a.this.gCs = true;
                        }
                    };
                    a.this.gCp = new TimePickerDialog(a.this.gCg.getPageContext().getPageActivity(), onTimeSetListener, a.this.aHS, a.this.Kr, false);
                }
                a.this.gCp.updateTime(a.this.aHS, a.this.Kr);
                g.a(a.this.gCp, a.this.gCg.getPageContext());
            }
        });
        this.gCi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gCh.setText("");
            }
        });
        this.gCl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gCk.setText("");
            }
        });
        this.fhh = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gCh.getText().length() > 0) {
                    a.this.gCi.setVisibility(0);
                    a.this.gCj.setEnabled(true);
                    return;
                }
                a.this.gCi.setVisibility(8);
                a.this.gCj.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gCh.addTextChangedListener(this.fhh);
        this.gCr = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gCk.getText().length() > 0) {
                    a.this.gCl.setVisibility(0);
                } else {
                    a.this.gCl.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gCk.addTextChangedListener(this.gCr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBk() {
        if (this.aHS > 12) {
            this.gCn.setText(this.gCg.getResources().getString(R.string.afternoon) + " " + (this.aHS - 12) + ":" + (this.Kr < 10 ? "0" : "") + this.Kr);
        } else {
            this.gCn.setText(this.gCg.getResources().getString(R.string.morning) + " " + this.aHS + ":" + (this.Kr < 10 ? "0" : "") + this.Kr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBl() {
        this.gCm.setText(this.Kn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Ko + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kp + " " + ap.q(this.Kn, this.Ko, this.Kp));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.gCh.removeTextChangedListener(this.fhh);
        this.gCk.removeTextChangedListener(this.gCr);
    }

    public View bBm() {
        return this.gsu;
    }

    public TextView bBn() {
        return this.gCj;
    }

    public String getTitle() {
        return this.gCh.getText().toString();
    }

    public String bBo() {
        return this.gCk.getText().toString();
    }

    public String getContent() {
        return this.gCq.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Kn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Ko + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kp + " " + this.aHS + ":" + this.Kr).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.gCh.setText(str);
    }

    public void setContent(String str) {
        this.gCq.setText(str);
    }

    public void ys(String str) {
        this.gCk.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Kn = date.getYear() + 1900;
        this.Ko = date.getMonth();
        this.Kp = date.getDate();
        this.aHS = date.getHours();
        this.Kr = date.getMinutes();
        bBl();
        bBk();
    }

    public void onChangeSkinType(int i) {
        this.gCg.getLayoutMode().setNightMode(i == 1);
        this.gCg.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gCg.getPageContext(), i);
        this.gCj.setTextColor(al.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.gCj.setText(this.gCg.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                ys(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.gCj.setText(this.gCg.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bBp() {
        return this.gCs;
    }
}
