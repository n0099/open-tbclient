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
    private TextWatcher fhg;
    private CreateGroupActivityActivity gCf;
    private EditText gCg;
    private ImageButton gCh;
    private TextView gCi;
    private EditText gCj;
    private ImageButton gCk;
    private Button gCl;
    private Button gCm;
    private DatePickerDialog gCn;
    private TimePickerDialog gCo;
    private EditText gCp;
    private TextWatcher gCq;
    private boolean gCr;
    private View gst;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.gCn = null;
        this.gCo = null;
        this.Kn = 0;
        this.Ko = 0;
        this.Kp = 0;
        this.aHS = 0;
        this.Kr = 0;
        this.gCr = false;
        this.gCf = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.gCf.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gCf.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.gst = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gst.setOnClickListener(this.gCf);
        this.gCi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gCf.getResources().getString(R.string.group_activity_create_btntext));
        this.gCi.setOnClickListener(this.gCf);
        this.gCi.setEnabled(false);
        this.gCg = (EditText) this.gCf.findViewById(R.id.txt_group_activity_name);
        this.gCh = (ImageButton) this.gCf.findViewById(R.id.btn_del_name);
        this.gCj = (EditText) this.gCf.findViewById(R.id.txt_group_activity_place);
        this.gCk = (ImageButton) this.gCf.findViewById(R.id.btn_del_place);
        this.gCp = (EditText) this.gCf.findViewById(R.id.txt_group_activity_content);
        this.gCl = (Button) this.gCf.findViewById(R.id.btn_create_group_date);
        this.gCm = (Button) this.gCf.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Kn = calendar.get(1);
        this.Ko = calendar.get(2);
        this.Kp = calendar.get(5);
        this.aHS = calendar.get(11);
        this.Kr = calendar.get(12);
        bBi();
        bBh();
        this.gCf.ShowSoftKeyPadDelay(this.gCg, 500);
        this.gCl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gCn == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.gCf.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.Kn = i;
                            a.this.Ko = i2;
                            a.this.Kp = i3;
                            g.b(a.this.gCn, a.this.gCf.getPageContext());
                            a.this.bBi();
                            a.this.gCr = true;
                        }
                    };
                    a.this.gCn = new DatePickerDialog(a.this.gCf.getPageContext().getPageActivity(), onDateSetListener, a.this.Kn, a.this.Ko, a.this.Kp);
                }
                a.this.gCn.updateDate(a.this.Kn, a.this.Ko, a.this.Kp);
                g.a(a.this.gCn, a.this.gCf.getPageContext());
            }
        });
        this.gCm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gCo == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.aHS = i;
                            a.this.Kr = i2;
                            g.b(a.this.gCo, a.this.gCf.getPageContext());
                            a.this.bBh();
                            a.this.gCr = true;
                        }
                    };
                    a.this.gCo = new TimePickerDialog(a.this.gCf.getPageContext().getPageActivity(), onTimeSetListener, a.this.aHS, a.this.Kr, false);
                }
                a.this.gCo.updateTime(a.this.aHS, a.this.Kr);
                g.a(a.this.gCo, a.this.gCf.getPageContext());
            }
        });
        this.gCh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gCg.setText("");
            }
        });
        this.gCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gCj.setText("");
            }
        });
        this.fhg = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gCg.getText().length() > 0) {
                    a.this.gCh.setVisibility(0);
                    a.this.gCi.setEnabled(true);
                    return;
                }
                a.this.gCh.setVisibility(8);
                a.this.gCi.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gCg.addTextChangedListener(this.fhg);
        this.gCq = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gCj.getText().length() > 0) {
                    a.this.gCk.setVisibility(0);
                } else {
                    a.this.gCk.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gCj.addTextChangedListener(this.gCq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBh() {
        if (this.aHS > 12) {
            this.gCm.setText(this.gCf.getResources().getString(R.string.afternoon) + " " + (this.aHS - 12) + ":" + (this.Kr < 10 ? "0" : "") + this.Kr);
        } else {
            this.gCm.setText(this.gCf.getResources().getString(R.string.morning) + " " + this.aHS + ":" + (this.Kr < 10 ? "0" : "") + this.Kr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBi() {
        this.gCl.setText(this.Kn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Ko + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kp + " " + ap.q(this.Kn, this.Ko, this.Kp));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.gCg.removeTextChangedListener(this.fhg);
        this.gCj.removeTextChangedListener(this.gCq);
    }

    public View bBj() {
        return this.gst;
    }

    public TextView bBk() {
        return this.gCi;
    }

    public String getTitle() {
        return this.gCg.getText().toString();
    }

    public String bBl() {
        return this.gCj.getText().toString();
    }

    public String getContent() {
        return this.gCp.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Kn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Ko + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kp + " " + this.aHS + ":" + this.Kr).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.gCg.setText(str);
    }

    public void setContent(String str) {
        this.gCp.setText(str);
    }

    public void ys(String str) {
        this.gCj.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Kn = date.getYear() + 1900;
        this.Ko = date.getMonth();
        this.Kp = date.getDate();
        this.aHS = date.getHours();
        this.Kr = date.getMinutes();
        bBi();
        bBh();
    }

    public void onChangeSkinType(int i) {
        this.gCf.getLayoutMode().setNightMode(i == 1);
        this.gCf.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gCf.getPageContext(), i);
        this.gCi.setTextColor(al.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.gCi.setText(this.gCf.getPageContext().getContext().getString(R.string.done));
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
        this.gCi.setText(this.gCf.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bBm() {
        return this.gCr;
    }
}
