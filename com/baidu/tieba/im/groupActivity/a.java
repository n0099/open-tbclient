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
    private View kjR;
    private DatePickerDialog kvA;
    private TimePickerDialog kvB;
    private EditText kvC;
    private TextWatcher kvD;
    private TextWatcher kvE;
    private boolean kvF;
    private CreateGroupActivityActivity kvs;
    private EditText kvt;
    private ImageButton kvu;
    private TextView kvv;
    private EditText kvw;
    private ImageButton kvx;
    private Button kvy;
    private Button kvz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.kvA = null;
        this.kvB = null;
        this.VJ = 0;
        this.VK = 0;
        this.VL = 0;
        this.dsI = 0;
        this.VN = 0;
        this.kvF = false;
        this.kvs = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.kvs.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.kvs.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.kjR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kjR.setOnClickListener(this.kvs);
        this.kvv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kvs.getResources().getString(R.string.group_activity_create_btntext));
        this.kvv.setOnClickListener(this.kvs);
        this.kvv.setEnabled(false);
        this.kvt = (EditText) this.kvs.findViewById(R.id.txt_group_activity_name);
        this.kvu = (ImageButton) this.kvs.findViewById(R.id.btn_del_name);
        this.kvw = (EditText) this.kvs.findViewById(R.id.txt_group_activity_place);
        this.kvx = (ImageButton) this.kvs.findViewById(R.id.btn_del_place);
        this.kvC = (EditText) this.kvs.findViewById(R.id.txt_group_activity_content);
        this.kvy = (Button) this.kvs.findViewById(R.id.btn_create_group_date);
        this.kvz = (Button) this.kvs.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.VJ = calendar.get(1);
        this.VK = calendar.get(2);
        this.VL = calendar.get(5);
        this.dsI = calendar.get(11);
        this.VN = calendar.get(12);
        cXy();
        cXx();
        this.kvs.ShowSoftKeyPadDelay(this.kvt, 500);
        this.kvy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kvA == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.kvs.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.VJ = i;
                            a.this.VK = i2;
                            a.this.VL = i3;
                            g.b(a.this.kvA, a.this.kvs.getPageContext());
                            a.this.cXy();
                            a.this.kvF = true;
                        }
                    };
                    a.this.kvA = new DatePickerDialog(a.this.kvs.getPageContext().getPageActivity(), onDateSetListener, a.this.VJ, a.this.VK, a.this.VL);
                }
                a.this.kvA.updateDate(a.this.VJ, a.this.VK, a.this.VL);
                g.a(a.this.kvA, a.this.kvs.getPageContext());
            }
        });
        this.kvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kvB == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.dsI = i;
                            a.this.VN = i2;
                            g.b(a.this.kvB, a.this.kvs.getPageContext());
                            a.this.cXx();
                            a.this.kvF = true;
                        }
                    };
                    a.this.kvB = new TimePickerDialog(a.this.kvs.getPageContext().getPageActivity(), onTimeSetListener, a.this.dsI, a.this.VN, false);
                }
                a.this.kvB.updateTime(a.this.dsI, a.this.VN);
                g.a(a.this.kvB, a.this.kvs.getPageContext());
            }
        });
        this.kvu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.kvt.setText("");
            }
        });
        this.kvx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.kvw.setText("");
            }
        });
        this.kvD = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.kvt.getText().length() > 0) {
                    a.this.kvu.setVisibility(0);
                    a.this.kvv.setEnabled(true);
                    return;
                }
                a.this.kvu.setVisibility(8);
                a.this.kvv.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.kvt.addTextChangedListener(this.kvD);
        this.kvE = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.kvw.getText().length() > 0) {
                    a.this.kvx.setVisibility(0);
                } else {
                    a.this.kvx.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.kvw.addTextChangedListener(this.kvE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXx() {
        if (this.dsI > 12) {
            this.kvz.setText(this.kvs.getResources().getString(R.string.afternoon) + " " + (this.dsI - 12) + ":" + (this.VN < 10 ? "0" : "") + this.VN);
        } else {
            this.kvz.setText(this.kvs.getResources().getString(R.string.morning) + " " + this.dsI + ":" + (this.VN < 10 ? "0" : "") + this.VN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXy() {
        this.kvy.setText(this.VJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.VK + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.VL + " " + au.getWeekString(this.VJ, this.VK, this.VL));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.kvt.removeTextChangedListener(this.kvD);
        this.kvw.removeTextChangedListener(this.kvE);
    }

    public View cXz() {
        return this.kjR;
    }

    public TextView cXA() {
        return this.kvv;
    }

    public String getTitle() {
        return this.kvt.getText().toString();
    }

    public String cXB() {
        return this.kvw.getText().toString();
    }

    public String getContent() {
        return this.kvC.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.VJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.VK + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.VL + " " + this.dsI + ":" + this.VN).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.kvt.setText(str);
    }

    public void setContent(String str) {
        this.kvC.setText(str);
    }

    public void NA(String str) {
        this.kvw.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.VJ = date.getYear() + FeatureCodes.SKY_SEG;
        this.VK = date.getMonth();
        this.VL = date.getDate();
        this.dsI = date.getHours();
        this.VN = date.getMinutes();
        cXy();
        cXx();
    }

    public void onChangeSkinType(int i) {
        this.kvs.getLayoutMode().setNightMode(i == 1);
        this.kvs.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kvs.getPageContext(), i);
        this.kvv.setTextColor(ap.getColor(R.color.CAM_X0106));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.kvv.setText(this.kvs.getPageContext().getContext().getString(R.string.done));
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
        this.kvv.setText(this.kvs.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean cXC() {
        return this.kvF;
    }
}
