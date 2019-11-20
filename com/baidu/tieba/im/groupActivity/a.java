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
    private int bbU;
    private CreateGroupActivityActivity gIj;
    private EditText gIk;
    private ImageButton gIl;
    private TextView gIm;
    private EditText gIn;
    private ImageButton gIo;
    private Button gIp;
    private Button gIq;
    private DatePickerDialog gIr;
    private TimePickerDialog gIs;
    private EditText gIt;
    private TextWatcher gIu;
    private TextWatcher gIv;
    private boolean gIw;
    private View gyy;
    private NavigationBar mNavigationBar;
    private View mParent;
    private int wH;
    private int wI;
    private int wJ;
    private int wL;

    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity.getPageContext());
        this.gIr = null;
        this.gIs = null;
        this.wH = 0;
        this.wI = 0;
        this.wJ = 0;
        this.bbU = 0;
        this.wL = 0;
        this.gIw = false;
        this.gIj = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = this.gIj.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gIj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
        this.gyy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gyy.setOnClickListener(this.gIj);
        this.gIm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gIj.getResources().getString(R.string.group_activity_create_btntext));
        this.gIm.setOnClickListener(this.gIj);
        this.gIm.setEnabled(false);
        this.gIk = (EditText) this.gIj.findViewById(R.id.txt_group_activity_name);
        this.gIl = (ImageButton) this.gIj.findViewById(R.id.btn_del_name);
        this.gIn = (EditText) this.gIj.findViewById(R.id.txt_group_activity_place);
        this.gIo = (ImageButton) this.gIj.findViewById(R.id.btn_del_place);
        this.gIt = (EditText) this.gIj.findViewById(R.id.txt_group_activity_content);
        this.gIp = (Button) this.gIj.findViewById(R.id.btn_create_group_date);
        this.gIq = (Button) this.gIj.findViewById(R.id.btn_create_group_time);
        final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.wH = calendar.get(1);
        this.wI = calendar.get(2);
        this.wJ = calendar.get(5);
        this.bbU = calendar.get(11);
        this.wL = calendar.get(12);
        bBE();
        bBD();
        this.gIj.ShowSoftKeyPadDelay(this.gIk, 500);
        this.gIp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gIr == null) {
                    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.1.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            int i4 = calendar.get(1);
                            int i5 = calendar.get(2);
                            int i6 = calendar.get(5);
                            if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
                                a.this.gIj.showToast(R.string.group_activity_time_val);
                                return;
                            }
                            a.this.wH = i;
                            a.this.wI = i2;
                            a.this.wJ = i3;
                            g.b(a.this.gIr, a.this.gIj.getPageContext());
                            a.this.bBE();
                            a.this.gIw = true;
                        }
                    };
                    a.this.gIr = new DatePickerDialog(a.this.gIj.getPageContext().getPageActivity(), onDateSetListener, a.this.wH, a.this.wI, a.this.wJ);
                }
                a.this.gIr.updateDate(a.this.wH, a.this.wI, a.this.wJ);
                g.a(a.this.gIr, a.this.gIj.getPageContext());
            }
        });
        this.gIq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gIs == null) {
                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.im.groupActivity.a.2.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            a.this.bbU = i;
                            a.this.wL = i2;
                            g.b(a.this.gIs, a.this.gIj.getPageContext());
                            a.this.bBD();
                            a.this.gIw = true;
                        }
                    };
                    a.this.gIs = new TimePickerDialog(a.this.gIj.getPageContext().getPageActivity(), onTimeSetListener, a.this.bbU, a.this.wL, false);
                }
                a.this.gIs.updateTime(a.this.bbU, a.this.wL);
                g.a(a.this.gIs, a.this.gIj.getPageContext());
            }
        });
        this.gIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gIk.setText("");
            }
        });
        this.gIo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gIn.setText("");
            }
        });
        this.gIu = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gIk.getText().length() > 0) {
                    a.this.gIl.setVisibility(0);
                    a.this.gIm.setEnabled(true);
                    return;
                }
                a.this.gIl.setVisibility(8);
                a.this.gIm.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gIk.addTextChangedListener(this.gIu);
        this.gIv = new TextWatcher() { // from class: com.baidu.tieba.im.groupActivity.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gIn.getText().length() > 0) {
                    a.this.gIo.setVisibility(0);
                } else {
                    a.this.gIo.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gIn.addTextChangedListener(this.gIv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBD() {
        if (this.bbU > 12) {
            this.gIq.setText(this.gIj.getResources().getString(R.string.afternoon) + HanziToPinyin.Token.SEPARATOR + (this.bbU - 12) + ":" + (this.wL < 10 ? "0" : "") + this.wL);
        } else {
            this.gIq.setText(this.gIj.getResources().getString(R.string.morning) + HanziToPinyin.Token.SEPARATOR + this.bbU + ":" + (this.wL < 10 ? "0" : "") + this.wL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBE() {
        this.gIp.setText(this.wH + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.wI + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.wJ + HanziToPinyin.Token.SEPARATOR + aq.getWeekString(this.wH, this.wI, this.wJ));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        this.gIk.removeTextChangedListener(this.gIu);
        this.gIn.removeTextChangedListener(this.gIv);
    }

    public View bBF() {
        return this.gyy;
    }

    public TextView bBG() {
        return this.gIm;
    }

    public String getTitle() {
        return this.gIk.getText().toString();
    }

    public String bBH() {
        return this.gIn.getText().toString();
    }

    public String getContent() {
        return this.gIt.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.wH + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.wI + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.wJ + HanziToPinyin.Token.SEPARATOR + this.bbU + ":" + this.wL).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.gIk.setText(str);
    }

    public void setContent(String str) {
        this.gIt.setText(str);
    }

    public void xX(String str) {
        this.gIn.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.wH = date.getYear() + 1900;
        this.wI = date.getMonth();
        this.wJ = date.getDate();
        this.bbU = date.getHours();
        this.wL = date.getMinutes();
        bBE();
        bBD();
    }

    public void onChangeSkinType(int i) {
        this.gIj.getLayoutMode().setNightMode(i == 1);
        this.gIj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gIj.getPageContext(), i);
        this.gIm.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.gIm.setText(this.gIj.getPageContext().getContext().getString(R.string.done));
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
        this.gIm.setText(this.gIj.getPageContext().getContext().getString(R.string.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(R.string.group_activity_create);
    }

    public boolean bBI() {
        return this.gIw;
    }
}
