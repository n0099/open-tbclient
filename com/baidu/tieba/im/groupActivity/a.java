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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes23.dex */
public class a extends c<BaseFragmentActivity> {
    private int UR;
    private int US;
    private int UT;
    private int UV;
    private int dht;
    private View jPD;
    private CreateGroupActivityActivity kbm;
    private EditText kbn;
    private ImageButton kbo;
    private TextView kbp;
    private EditText kbq;
    private ImageButton kbr;
    private Button kbs;
    private Button kbt;
    private DatePickerDialog kbu;
    private TimePickerDialog kbv;
    private EditText kbw;
    private TextWatcher kbx;
    private TextWatcher kby;
    private boolean kbz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.kbu = null;
        this.kbv = null;
        this.UR = 0;
        this.US = 0;
        this.UT = 0;
        this.dht = 0;
        this.UV = 0;
        this.kbz = false;
        this.kbm = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.kbm.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.kbm.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.jPD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jPD.setOnClickListener(this.kbm);
        this.kbp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kbm.getResources().getString(R.string.group_activity_create_btntext));
        this.kbp.setOnClickListener(this.kbm);
        this.kbp.setEnabled(false);
        this.kbn = (EditText) this.kbm.findViewById(R.id.txt_group_activity_name);
        this.kbo = (ImageButton) this.kbm.findViewById(R.id.btn_del_name);
        this.kbq = (EditText) this.kbm.findViewById(R.id.txt_group_activity_place);
        this.kbr = (ImageButton) this.kbm.findViewById(R.id.btn_del_place);
        this.kbw = (EditText) this.kbm.findViewById(R.id.txt_group_activity_content);
        this.kbs = (Button) this.kbm.findViewById(R.id.btn_create_group_date);
        this.kbt = (Button) this.kbm.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.UR = calendar.get(1);
        this.US = calendar.get(2);
        this.UT = calendar.get(5);
        this.dht = calendar.get(11);
        this.UV = calendar.get(12);
        cQe();
        cQd();
        this.kbm.ShowSoftKeyPadDelay(this.kbn, 500);
        this.kbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kbu == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.kbm.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.UR = i;
                            a.this.US = i2;
                            a.this.UT = i3;
                            g.b(a.this.kbu, a.this.kbm.getPageContext());
                            a.this.cQe();
                            a.this.kbz = true;
                        }
                    };
                    a.this.kbu = new DatePickerDialog(a.this.kbm.getPageContext().getPageActivity(), onDateSetListener, a.this.UR, a.this.US, a.this.UT);
                }
                a.this.kbu.updateDate(a.this.UR, a.this.US, a.this.UT);
                g.a(a.this.kbu, a.this.kbm.getPageContext());
            }
        });
        this.kbt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kbv == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.dht = i;
                            a.this.UV = i2;
                            g.b(a.this.kbv, a.this.kbm.getPageContext());
                            a.this.cQd();
                            a.this.kbz = true;
                        }
                    };
                    a.this.kbv = new TimePickerDialog(a.this.kbm.getPageContext().getPageActivity(), onTimeSetListener, a.this.dht, a.this.UV, false);
                }
                a.this.kbv.updateTime(a.this.dht, a.this.UV);
                g.a(a.this.kbv, a.this.kbm.getPageContext());
            }
        });
        this.kbo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.kbn.setText("");
            }
        });
        this.kbr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.kbq.setText("");
            }
        });
        this.kbx = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.kbn.getText().length() > 0) {
                    a.this.kbo.setVisibility(0);
                    a.this.kbp.setEnabled(true);
                    return;
                }
                a.this.kbo.setVisibility(8);
                a.this.kbp.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.kbn.addTextChangedListener(this.kbx);
        this.kby = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.kbq.getText().length() > 0) {
                    a.this.kbr.setVisibility(0);
                } else {
                    a.this.kbr.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.kbq.addTextChangedListener(this.kby);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQd() {
        if (this.dht > 12) {
            this.kbt.setText(this.kbm.getResources().getString(R.string.afternoon) + " " + (this.dht - 12) + ":" + (this.UV < 10 ? "0" : "") + this.UV);
        } else {
            this.kbt.setText(this.kbm.getResources().getString(R.string.morning) + " " + this.dht + ":" + (this.UV < 10 ? "0" : "") + this.UV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQe() {
        this.kbs.setText(this.UR + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.US + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UT + " " + at.getWeekString(this.UR, this.US, this.UT));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.kbn.removeTextChangedListener(this.kbx);
        this.kbq.removeTextChangedListener(this.kby);
    }

    public View cQf() {
        return this.jPD;
    }

    public TextView cQg() {
        return this.kbp;
    }

    public String getTitle() {
        return this.kbn.getText().toString();
    }

    public String cQh() {
        return this.kbq.getText().toString();
    }

    public String getContent() {
        return this.kbw.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.UR + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.US + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UT + " " + this.dht + ":" + this.UV).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.kbn.setText(str);
    }

    public void setContent(String str) {
        this.kbw.setText(str);
    }

    public void MA(String str) {
        this.kbq.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.UR = date.getYear() + FeatureCodes.SKY_SEG;
        this.US = date.getMonth();
        this.UT = date.getDate();
        this.dht = date.getHours();
        this.UV = date.getMinutes();
        cQe();
        cQd();
    }

    public void onChangeSkinType(int i) {
        this.kbm.getLayoutMode().setNightMode(i == 1);
        this.kbm.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kbm.getPageContext(), i);
        this.kbp.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.kbp.setText(this.kbm.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                MA(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.kbp.setText(this.kbm.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cQi() {
        return this.kbz;
    }
}
