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
/* loaded from: classes5.dex */
public class a extends c<BaseFragmentActivity> {
    private int bcm;
    private CreateGroupActivityActivity gJa;
    private EditText gJb;
    private ImageButton gJc;
    private TextView gJd;
    private EditText gJe;
    private ImageButton gJf;
    private Button gJg;
    private Button gJh;
    private DatePickerDialog gJi;
    private TimePickerDialog gJj;
    private EditText gJk;
    private TextWatcher gJl;
    private TextWatcher gJm;
    private boolean gJn;
    private View gzp;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int xh;
    private int xi;
    private int xj;
    private int xl;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.gJi = null;
        this.gJj = null;
        this.xh = 0;
        this.xi = 0;
        this.xj = 0;
        this.bcm = 0;
        this.xl = 0;
        this.gJn = false;
        this.gJa = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.gJa.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gJa.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.gzp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gzp.setOnClickListener(this.gJa);
        this.gJd = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gJa.getResources().getString(R.string.group_activity_create_btntext));
        this.gJd.setOnClickListener(this.gJa);
        this.gJd.setEnabled(false);
        this.gJb = (EditText) this.gJa.findViewById(R.id.txt_group_activity_name);
        this.gJc = (ImageButton) this.gJa.findViewById(R.id.btn_del_name);
        this.gJe = (EditText) this.gJa.findViewById(R.id.txt_group_activity_place);
        this.gJf = (ImageButton) this.gJa.findViewById(R.id.btn_del_place);
        this.gJk = (EditText) this.gJa.findViewById(R.id.txt_group_activity_content);
        this.gJg = (Button) this.gJa.findViewById(R.id.btn_create_group_date);
        this.gJh = (Button) this.gJa.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.xh = calendar.get(1);
        this.xi = calendar.get(2);
        this.xj = calendar.get(5);
        this.bcm = calendar.get(11);
        this.xl = calendar.get(12);
        bBG();
        bBF();
        this.gJa.ShowSoftKeyPadDelay(this.gJb, 500);
        this.gJg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gJi == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.gJa.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.xh = i;
                            a.this.xi = i2;
                            a.this.xj = i3;
                            g.b(a.this.gJi, a.this.gJa.getPageContext());
                            a.this.bBG();
                            a.this.gJn = true;
                        }
                    };
                    a.this.gJi = new DatePickerDialog(a.this.gJa.getPageContext().getPageActivity(), onDateSetListener, a.this.xh, a.this.xi, a.this.xj);
                }
                a.this.gJi.updateDate(a.this.xh, a.this.xi, a.this.xj);
                g.a(a.this.gJi, a.this.gJa.getPageContext());
            }
        });
        this.gJh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gJj == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.bcm = i;
                            a.this.xl = i2;
                            g.b(a.this.gJj, a.this.gJa.getPageContext());
                            a.this.bBF();
                            a.this.gJn = true;
                        }
                    };
                    a.this.gJj = new TimePickerDialog(a.this.gJa.getPageContext().getPageActivity(), onTimeSetListener, a.this.bcm, a.this.xl, false);
                }
                a.this.gJj.updateTime(a.this.bcm, a.this.xl);
                g.a(a.this.gJj, a.this.gJa.getPageContext());
            }
        });
        this.gJc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gJb.setText("");
            }
        });
        this.gJf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gJe.setText("");
            }
        });
        this.gJl = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gJb.getText().length() > 0) {
                    a.this.gJc.setVisibility(0);
                    a.this.gJd.setEnabled(true);
                    return;
                }
                a.this.gJc.setVisibility(8);
                a.this.gJd.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gJb.addTextChangedListener(this.gJl);
        this.gJm = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gJe.getText().length() > 0) {
                    a.this.gJf.setVisibility(0);
                } else {
                    a.this.gJf.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gJe.addTextChangedListener(this.gJm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBF() {
        if (this.bcm > 12) {
            this.gJh.setText(this.gJa.getResources().getString(R.string.afternoon) + HanziToPinyin.Token.SEPARATOR + (this.bcm - 12) + ":" + (this.xl < 10 ? "0" : "") + this.xl);
        } else {
            this.gJh.setText(this.gJa.getResources().getString(R.string.morning) + HanziToPinyin.Token.SEPARATOR + this.bcm + ":" + (this.xl < 10 ? "0" : "") + this.xl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBG() {
        this.gJg.setText(this.xh + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.xi + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xj + HanziToPinyin.Token.SEPARATOR + aq.getWeekString(this.xh, this.xi, this.xj));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.gJb.removeTextChangedListener(this.gJl);
        this.gJe.removeTextChangedListener(this.gJm);
    }

    public View bBH() {
        return this.gzp;
    }

    public TextView bBI() {
        return this.gJd;
    }

    public String getTitle() {
        return this.gJb.getText().toString();
    }

    public String bBJ() {
        return this.gJe.getText().toString();
    }

    public String getContent() {
        return this.gJk.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.xh + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.xi + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xj + HanziToPinyin.Token.SEPARATOR + this.bcm + ":" + this.xl).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.gJb.setText(str);
    }

    public void setContent(String str) {
        this.gJk.setText(str);
    }

    public void xX(String str) {
        this.gJe.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.xh = date.getYear() + 1900;
        this.xi = date.getMonth();
        this.xj = date.getDate();
        this.bcm = date.getHours();
        this.xl = date.getMinutes();
        bBG();
        bBF();
    }

    public void onChangeSkinType(int i) {
        this.gJa.getLayoutMode().setNightMode(i == 1);
        this.gJa.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gJa.getPageContext(), i);
        this.gJd.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.gJd.setText(this.gJa.getPageContext().getContext().getString(R.string.done));
            this.mNavigationBar.setTitleText(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                xX(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.gJd.setText(this.gJa.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bBK() {
        return this.gJn;
    }
}
