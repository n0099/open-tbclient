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
    private int Km;
    private int Kn;
    private int Ko;
    private int Kq;
    private int aHS;
    private TextWatcher fhh;
    private CreateGroupActivityActivity gCi;
    private EditText gCj;
    private ImageButton gCk;
    private TextView gCl;
    private EditText gCm;
    private ImageButton gCn;
    private Button gCo;
    private Button gCp;
    private DatePickerDialog gCq;
    private TimePickerDialog gCr;
    private EditText gCs;
    private TextWatcher gCt;
    private boolean gCu;
    private View gsw;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.gCq = null;
        this.gCr = null;
        this.Km = 0;
        this.Kn = 0;
        this.Ko = 0;
        this.aHS = 0;
        this.Kq = 0;
        this.gCu = false;
        this.gCi = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.gCi.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gCi.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.gsw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gsw.setOnClickListener(this.gCi);
        this.gCl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gCi.getResources().getString(R.string.group_activity_create_btntext));
        this.gCl.setOnClickListener(this.gCi);
        this.gCl.setEnabled(false);
        this.gCj = (EditText) this.gCi.findViewById(R.id.txt_group_activity_name);
        this.gCk = (ImageButton) this.gCi.findViewById(R.id.btn_del_name);
        this.gCm = (EditText) this.gCi.findViewById(R.id.txt_group_activity_place);
        this.gCn = (ImageButton) this.gCi.findViewById(R.id.btn_del_place);
        this.gCs = (EditText) this.gCi.findViewById(R.id.txt_group_activity_content);
        this.gCo = (Button) this.gCi.findViewById(R.id.btn_create_group_date);
        this.gCp = (Button) this.gCi.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Km = calendar.get(1);
        this.Kn = calendar.get(2);
        this.Ko = calendar.get(5);
        this.aHS = calendar.get(11);
        this.Kq = calendar.get(12);
        bBm();
        bBl();
        this.gCi.ShowSoftKeyPadDelay(this.gCj, 500);
        this.gCo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gCq == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.gCi.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.Km = i;
                            a.this.Kn = i2;
                            a.this.Ko = i3;
                            g.b(a.this.gCq, a.this.gCi.getPageContext());
                            a.this.bBm();
                            a.this.gCu = true;
                        }
                    };
                    a.this.gCq = new DatePickerDialog(a.this.gCi.getPageContext().getPageActivity(), onDateSetListener, a.this.Km, a.this.Kn, a.this.Ko);
                }
                a.this.gCq.updateDate(a.this.Km, a.this.Kn, a.this.Ko);
                g.a(a.this.gCq, a.this.gCi.getPageContext());
            }
        });
        this.gCp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gCr == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.aHS = i;
                            a.this.Kq = i2;
                            g.b(a.this.gCr, a.this.gCi.getPageContext());
                            a.this.bBl();
                            a.this.gCu = true;
                        }
                    };
                    a.this.gCr = new TimePickerDialog(a.this.gCi.getPageContext().getPageActivity(), onTimeSetListener, a.this.aHS, a.this.Kq, false);
                }
                a.this.gCr.updateTime(a.this.aHS, a.this.Kq);
                g.a(a.this.gCr, a.this.gCi.getPageContext());
            }
        });
        this.gCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gCj.setText("");
            }
        });
        this.gCn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gCm.setText("");
            }
        });
        this.fhh = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gCj.getText().length() > 0) {
                    a.this.gCk.setVisibility(0);
                    a.this.gCl.setEnabled(true);
                    return;
                }
                a.this.gCk.setVisibility(8);
                a.this.gCl.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gCj.addTextChangedListener(this.fhh);
        this.gCt = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gCm.getText().length() > 0) {
                    a.this.gCn.setVisibility(0);
                } else {
                    a.this.gCn.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gCm.addTextChangedListener(this.gCt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBl() {
        if (this.aHS > 12) {
            this.gCp.setText(this.gCi.getResources().getString(R.string.afternoon) + " " + (this.aHS - 12) + ":" + (this.Kq < 10 ? "0" : "") + this.Kq);
        } else {
            this.gCp.setText(this.gCi.getResources().getString(R.string.morning) + " " + this.aHS + ":" + (this.Kq < 10 ? "0" : "") + this.Kq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBm() {
        this.gCo.setText(this.Km + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Kn + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ko + " " + ap.q(this.Km, this.Kn, this.Ko));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.gCj.removeTextChangedListener(this.fhh);
        this.gCm.removeTextChangedListener(this.gCt);
    }

    public View bBn() {
        return this.gsw;
    }

    public TextView bBo() {
        return this.gCl;
    }

    public String getTitle() {
        return this.gCj.getText().toString();
    }

    public String bBp() {
        return this.gCm.getText().toString();
    }

    public String getContent() {
        return this.gCs.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Km + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Kn + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ko + " " + this.aHS + ":" + this.Kq).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.gCj.setText(str);
    }

    public void setContent(String str) {
        this.gCs.setText(str);
    }

    public void yu(String str) {
        this.gCm.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Km = date.getYear() + 1900;
        this.Kn = date.getMonth();
        this.Ko = date.getDate();
        this.aHS = date.getHours();
        this.Kq = date.getMinutes();
        bBm();
        bBl();
    }

    public void onChangeSkinType(int i) {
        this.gCi.getLayoutMode().setNightMode(i == 1);
        this.gCi.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gCi.getPageContext(), i);
        this.gCl.setTextColor(al.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.gCl.setText(this.gCi.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                yu(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.gCl.setText(this.gCi.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bBq() {
        return this.gCu;
    }
}
