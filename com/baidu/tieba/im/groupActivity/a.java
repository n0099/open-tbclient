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
import com.baidu.tbadk.core.util.au;
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
    private int VJ;
    private int VK;
    private int VL;
    private int VN;
    private int dsI;
    private View kjP;
    private EditText kvA;
    private TextWatcher kvB;
    private TextWatcher kvC;
    private boolean kvD;
    private CreateGroupActivityActivity kvq;
    private EditText kvr;
    private ImageButton kvs;
    private TextView kvt;
    private EditText kvu;
    private ImageButton kvv;
    private Button kvw;
    private Button kvx;
    private DatePickerDialog kvy;
    private TimePickerDialog kvz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.kvy = null;
        this.kvz = null;
        this.VJ = 0;
        this.VK = 0;
        this.VL = 0;
        this.dsI = 0;
        this.VN = 0;
        this.kvD = false;
        this.kvq = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.kvq.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.kvq.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.kjP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kjP.setOnClickListener(this.kvq);
        this.kvt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kvq.getResources().getString(R.string.group_activity_create_btntext));
        this.kvt.setOnClickListener(this.kvq);
        this.kvt.setEnabled(false);
        this.kvr = (EditText) this.kvq.findViewById(R.id.txt_group_activity_name);
        this.kvs = (ImageButton) this.kvq.findViewById(R.id.btn_del_name);
        this.kvu = (EditText) this.kvq.findViewById(R.id.txt_group_activity_place);
        this.kvv = (ImageButton) this.kvq.findViewById(R.id.btn_del_place);
        this.kvA = (EditText) this.kvq.findViewById(R.id.txt_group_activity_content);
        this.kvw = (Button) this.kvq.findViewById(R.id.btn_create_group_date);
        this.kvx = (Button) this.kvq.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.VJ = calendar.get(1);
        this.VK = calendar.get(2);
        this.VL = calendar.get(5);
        this.dsI = calendar.get(11);
        this.VN = calendar.get(12);
        cXx();
        cXw();
        this.kvq.ShowSoftKeyPadDelay(this.kvr, 500);
        this.kvw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kvy == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.kvq.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.VJ = i;
                            a.this.VK = i2;
                            a.this.VL = i3;
                            g.b(a.this.kvy, a.this.kvq.getPageContext());
                            a.this.cXx();
                            a.this.kvD = true;
                        }
                    };
                    a.this.kvy = new DatePickerDialog(a.this.kvq.getPageContext().getPageActivity(), onDateSetListener, a.this.VJ, a.this.VK, a.this.VL);
                }
                a.this.kvy.updateDate(a.this.VJ, a.this.VK, a.this.VL);
                g.a(a.this.kvy, a.this.kvq.getPageContext());
            }
        });
        this.kvx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kvz == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.dsI = i;
                            a.this.VN = i2;
                            g.b(a.this.kvz, a.this.kvq.getPageContext());
                            a.this.cXw();
                            a.this.kvD = true;
                        }
                    };
                    a.this.kvz = new TimePickerDialog(a.this.kvq.getPageContext().getPageActivity(), onTimeSetListener, a.this.dsI, a.this.VN, false);
                }
                a.this.kvz.updateTime(a.this.dsI, a.this.VN);
                g.a(a.this.kvz, a.this.kvq.getPageContext());
            }
        });
        this.kvs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.kvr.setText("");
            }
        });
        this.kvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.kvu.setText("");
            }
        });
        this.kvB = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.kvr.getText().length() > 0) {
                    a.this.kvs.setVisibility(0);
                    a.this.kvt.setEnabled(true);
                    return;
                }
                a.this.kvs.setVisibility(8);
                a.this.kvt.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.kvr.addTextChangedListener(this.kvB);
        this.kvC = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.kvu.getText().length() > 0) {
                    a.this.kvv.setVisibility(0);
                } else {
                    a.this.kvv.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.kvu.addTextChangedListener(this.kvC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXw() {
        if (this.dsI > 12) {
            this.kvx.setText(this.kvq.getResources().getString(R.string.afternoon) + " " + (this.dsI - 12) + ":" + (this.VN < 10 ? "0" : "") + this.VN);
        } else {
            this.kvx.setText(this.kvq.getResources().getString(R.string.morning) + " " + this.dsI + ":" + (this.VN < 10 ? "0" : "") + this.VN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXx() {
        this.kvw.setText(this.VJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.VK + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.VL + " " + au.getWeekString(this.VJ, this.VK, this.VL));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.kvr.removeTextChangedListener(this.kvB);
        this.kvu.removeTextChangedListener(this.kvC);
    }

    public View cXy() {
        return this.kjP;
    }

    public TextView cXz() {
        return this.kvt;
    }

    public String getTitle() {
        return this.kvr.getText().toString();
    }

    public String cXA() {
        return this.kvu.getText().toString();
    }

    public String getContent() {
        return this.kvA.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.VJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.VK + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.VL + " " + this.dsI + ":" + this.VN).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.kvr.setText(str);
    }

    public void setContent(String str) {
        this.kvA.setText(str);
    }

    public void NA(String str) {
        this.kvu.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.VJ = date.getYear() + FeatureCodes.SKY_SEG;
        this.VK = date.getMonth();
        this.VL = date.getDate();
        this.dsI = date.getHours();
        this.VN = date.getMinutes();
        cXx();
        cXw();
    }

    public void onChangeSkinType(int i) {
        this.kvq.getLayoutMode().setNightMode(i == 1);
        this.kvq.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kvq.getPageContext(), i);
        this.kvt.setTextColor(ap.getColor(R.color.CAM_X0106));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.kvt.setText(this.kvq.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                NA(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.kvt.setText(this.kvq.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cXB() {
        return this.kvD;
    }
}
