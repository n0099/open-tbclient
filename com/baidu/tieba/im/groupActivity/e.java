package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f {
    private View aOF;
    private CreateGroupActivityActivity aYD;
    private EditText aYE;
    private ImageButton aYF;
    private TextView aYG;
    private EditText aYH;
    private ImageButton aYI;
    private Button aYJ;
    private Button aYK;
    private DatePickerDialog aYL;
    private TimePickerDialog aYM;
    private EditText aYN;
    private int aYO;
    private int aYP;
    private int aYQ;
    private int aYR;
    private int aYS;
    private boolean aYT;
    private View agA;
    private NavigationBar mNavigationBar;

    public e(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity);
        this.aYL = null;
        this.aYM = null;
        this.aYO = 0;
        this.aYP = 0;
        this.aYQ = 0;
        this.aYR = 0;
        this.aYS = 0;
        this.aYT = false;
        this.aYD = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(w.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.agA = this.aYD.findViewById(v.parent);
        this.mNavigationBar = (NavigationBar) this.aYD.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(y.group_activity_create);
        this.aOF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aOF.setOnClickListener(this.aYD);
        this.aYG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.aYD.getResources().getString(y.group_activity_create_btntext));
        this.aYG.setOnClickListener(this.aYD);
        this.aYG.setEnabled(false);
        this.aYE = (EditText) this.aYD.findViewById(v.txt_group_activity_name);
        this.aYF = (ImageButton) this.aYD.findViewById(v.btn_del_name);
        this.aYH = (EditText) this.aYD.findViewById(v.txt_group_activity_place);
        this.aYI = (ImageButton) this.aYD.findViewById(v.btn_del_place);
        this.aYN = (EditText) this.aYD.findViewById(v.txt_group_activity_content);
        this.aYJ = (Button) this.aYD.findViewById(v.btn_create_group_date);
        this.aYK = (Button) this.aYD.findViewById(v.btn_create_group_time);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.aYO = calendar.get(1);
        this.aYP = calendar.get(2);
        this.aYQ = calendar.get(5);
        this.aYR = calendar.get(11);
        this.aYS = calendar.get(12);
        Oa();
        NZ();
        this.aYJ.setOnClickListener(new f(this, calendar));
        this.aYK.setOnClickListener(new h(this));
        this.aYF.setOnClickListener(new j(this));
        this.aYI.setOnClickListener(new k(this));
        this.aYE.addTextChangedListener(new l(this));
        this.aYH.addTextChangedListener(new m(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NZ() {
        if (this.aYR > 12) {
            this.aYK.setText(String.valueOf(this.aYD.getResources().getString(y.afternoon)) + " " + (this.aYR - 12) + ":" + (this.aYS < 10 ? "0" : "") + this.aYS);
        } else {
            this.aYK.setText(String.valueOf(this.aYD.getResources().getString(y.morning)) + " " + this.aYR + ":" + (this.aYS < 10 ? "0" : "") + this.aYS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oa() {
        this.aYJ.setText(this.aYO + "-" + (this.aYP + 1) + "-" + this.aYQ + " " + ay.l(this.aYO, this.aYP, this.aYQ));
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
    }

    public View Ob() {
        return this.aOF;
    }

    public TextView Oc() {
        return this.aYG;
    }

    public String getTitle() {
        return this.aYE.getText().toString();
    }

    public String Od() {
        return this.aYH.getText().toString();
    }

    public String getContent() {
        return this.aYN.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.aYO + "-" + (this.aYP + 1) + "-" + this.aYQ + " " + this.aYR + ":" + this.aYS).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.aYE.setText(str);
    }

    public void setContent(String str) {
        this.aYN.setText(str);
    }

    public void gg(String str) {
        this.aYH.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.aYO = date.getYear() + 1900;
        this.aYP = date.getMonth();
        this.aYQ = date.getDate();
        this.aYR = date.getHours();
        this.aYS = date.getMinutes();
        Oa();
        NZ();
    }

    public void onChangeSkinType(int i) {
        this.aYD.getLayoutMode().L(i == 1);
        this.aYD.getLayoutMode().h(this.agA);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.aYG.setText(this.aYD.getString(y.done));
            this.mNavigationBar.setTitleText(y.group_activity_edit_title);
            if (groupActivityData != null) {
                setContent(groupActivityData.getgActivityContent());
                setTitle(groupActivityData.getgActivityTitle());
                setTime(groupActivityData.getgActivityTime());
                gg(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.aYG.setText(this.aYD.getString(y.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(y.group_activity_create);
    }

    public boolean Oe() {
        return this.aYT;
    }
}
