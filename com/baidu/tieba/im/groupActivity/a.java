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
/* loaded from: classes5.dex */
public class a extends c<BaseFragmentActivity> {
    private int KA;
    private int KC;
    private int Ky;
    private int Kz;
    private int aIA;
    private TextWatcher fmj;
    private DatePickerDialog gIA;
    private TimePickerDialog gIB;
    private EditText gIC;
    private TextWatcher gID;
    private boolean gIE;
    private CreateGroupActivityActivity gIs;
    private EditText gIt;
    private ImageButton gIu;
    private TextView gIv;
    private EditText gIw;
    private ImageButton gIx;
    private Button gIy;
    private Button gIz;
    private View gyH;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.gIA = null;
        this.gIB = null;
        this.Ky = 0;
        this.Kz = 0;
        this.KA = 0;
        this.aIA = 0;
        this.KC = 0;
        this.gIE = false;
        this.gIs = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.gIs.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gIs.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.gyH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gyH.setOnClickListener(this.gIs);
        this.gIv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gIs.getResources().getString(R.string.group_activity_create_btntext));
        this.gIv.setOnClickListener(this.gIs);
        this.gIv.setEnabled(false);
        this.gIt = (EditText) this.gIs.findViewById(R.id.txt_group_activity_name);
        this.gIu = (ImageButton) this.gIs.findViewById(R.id.btn_del_name);
        this.gIw = (EditText) this.gIs.findViewById(R.id.txt_group_activity_place);
        this.gIx = (ImageButton) this.gIs.findViewById(R.id.btn_del_place);
        this.gIC = (EditText) this.gIs.findViewById(R.id.txt_group_activity_content);
        this.gIy = (Button) this.gIs.findViewById(R.id.btn_create_group_date);
        this.gIz = (Button) this.gIs.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.Ky = calendar.get(1);
        this.Kz = calendar.get(2);
        this.KA = calendar.get(5);
        this.aIA = calendar.get(11);
        this.KC = calendar.get(12);
        bDT();
        bDS();
        this.gIs.ShowSoftKeyPadDelay(this.gIt, 500);
        this.gIy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gIA == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.gIs.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.Ky = i;
                            a.this.Kz = i2;
                            a.this.KA = i3;
                            g.b(a.this.gIA, a.this.gIs.getPageContext());
                            a.this.bDT();
                            a.this.gIE = true;
                        }
                    };
                    a.this.gIA = new DatePickerDialog(a.this.gIs.getPageContext().getPageActivity(), onDateSetListener, a.this.Ky, a.this.Kz, a.this.KA);
                }
                a.this.gIA.updateDate(a.this.Ky, a.this.Kz, a.this.KA);
                g.a(a.this.gIA, a.this.gIs.getPageContext());
            }
        });
        this.gIz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gIB == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.aIA = i;
                            a.this.KC = i2;
                            g.b(a.this.gIB, a.this.gIs.getPageContext());
                            a.this.bDS();
                            a.this.gIE = true;
                        }
                    };
                    a.this.gIB = new TimePickerDialog(a.this.gIs.getPageContext().getPageActivity(), onTimeSetListener, a.this.aIA, a.this.KC, false);
                }
                a.this.gIB.updateTime(a.this.aIA, a.this.KC);
                g.a(a.this.gIB, a.this.gIs.getPageContext());
            }
        });
        this.gIu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gIt.setText("");
            }
        });
        this.gIx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gIw.setText("");
            }
        });
        this.fmj = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gIt.getText().length() > 0) {
                    a.this.gIu.setVisibility(0);
                    a.this.gIv.setEnabled(true);
                    return;
                }
                a.this.gIu.setVisibility(8);
                a.this.gIv.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gIt.addTextChangedListener(this.fmj);
        this.gID = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gIw.getText().length() > 0) {
                    a.this.gIx.setVisibility(0);
                } else {
                    a.this.gIx.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gIw.addTextChangedListener(this.gID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDS() {
        if (this.aIA > 12) {
            this.gIz.setText(this.gIs.getResources().getString(R.string.afternoon) + " " + (this.aIA - 12) + ":" + (this.KC < 10 ? "0" : "") + this.KC);
        } else {
            this.gIz.setText(this.gIs.getResources().getString(R.string.morning) + " " + this.aIA + ":" + (this.KC < 10 ? "0" : "") + this.KC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDT() {
        this.gIy.setText(this.Ky + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Kz + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.KA + " " + aq.q(this.Ky, this.Kz, this.KA));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.gIt.removeTextChangedListener(this.fmj);
        this.gIw.removeTextChangedListener(this.gID);
    }

    public View bDU() {
        return this.gyH;
    }

    public TextView bDV() {
        return this.gIv;
    }

    public String getTitle() {
        return this.gIt.getText().toString();
    }

    public String bDW() {
        return this.gIw.getText().toString();
    }

    public String getContent() {
        return this.gIC.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.Ky + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.Kz + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.KA + " " + this.aIA + ":" + this.KC).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.gIt.setText(str);
    }

    public void setContent(String str) {
        this.gIC.setText(str);
    }

    public void zf(String str) {
        this.gIw.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.Ky = date.getYear() + 1900;
        this.Kz = date.getMonth();
        this.KA = date.getDate();
        this.aIA = date.getHours();
        this.KC = date.getMinutes();
        bDT();
        bDS();
    }

    public void onChangeSkinType(int i) {
        this.gIs.getLayoutMode().setNightMode(i == 1);
        this.gIs.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gIs.getPageContext(), i);
        this.gIv.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.gIv.setText(this.gIs.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                zf(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.gIv.setText(this.gIs.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bDX() {
        return this.gIE;
    }
}
