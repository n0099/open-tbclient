package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.tbadk.core.util.az;
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
    private View aOT;
    private CreateGroupActivityActivity aYQ;
    private EditText aYR;
    private ImageButton aYS;
    private TextView aYT;
    private EditText aYU;
    private ImageButton aYV;
    private Button aYW;
    private Button aYX;
    private DatePickerDialog aYY;
    private TimePickerDialog aYZ;
    private EditText aZa;
    private int aZb;
    private int aZc;
    private int aZd;
    private int aZe;
    private int aZf;
    private boolean aZg;
    private View agI;
    private NavigationBar mNavigationBar;

    public e(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity);
        this.aYY = null;
        this.aYZ = null;
        this.aZb = 0;
        this.aZc = 0;
        this.aZd = 0;
        this.aZe = 0;
        this.aZf = 0;
        this.aZg = false;
        this.aYQ = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(w.create_group_activity_activity);
        initUI();
    }

    private void initUI() {
        this.agI = this.aYQ.findViewById(v.parent);
        this.mNavigationBar = (NavigationBar) this.aYQ.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(y.group_activity_create);
        this.aOT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aOT.setOnClickListener(this.aYQ);
        this.aYT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.aYQ.getResources().getString(y.group_activity_create_btntext));
        this.aYT.setOnClickListener(this.aYQ);
        this.aYT.setEnabled(false);
        this.aYR = (EditText) this.aYQ.findViewById(v.txt_group_activity_name);
        this.aYS = (ImageButton) this.aYQ.findViewById(v.btn_del_name);
        this.aYU = (EditText) this.aYQ.findViewById(v.txt_group_activity_place);
        this.aYV = (ImageButton) this.aYQ.findViewById(v.btn_del_place);
        this.aZa = (EditText) this.aYQ.findViewById(v.txt_group_activity_content);
        this.aYW = (Button) this.aYQ.findViewById(v.btn_create_group_date);
        this.aYX = (Button) this.aYQ.findViewById(v.btn_create_group_time);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.aZb = calendar.get(1);
        this.aZc = calendar.get(2);
        this.aZd = calendar.get(5);
        this.aZe = calendar.get(11);
        this.aZf = calendar.get(12);
        Od();
        Oc();
        this.aYW.setOnClickListener(new f(this, calendar));
        this.aYX.setOnClickListener(new h(this));
        this.aYS.setOnClickListener(new j(this));
        this.aYV.setOnClickListener(new k(this));
        this.aYR.addTextChangedListener(new l(this));
        this.aYU.addTextChangedListener(new m(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oc() {
        if (this.aZe > 12) {
            this.aYX.setText(String.valueOf(this.aYQ.getResources().getString(y.afternoon)) + " " + (this.aZe - 12) + ":" + (this.aZf < 10 ? "0" : "") + this.aZf);
        } else {
            this.aYX.setText(String.valueOf(this.aYQ.getResources().getString(y.morning)) + " " + this.aZe + ":" + (this.aZf < 10 ? "0" : "") + this.aZf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Od() {
        this.aYW.setText(this.aZb + "-" + (this.aZc + 1) + "-" + this.aZd + " " + az.l(this.aZb, this.aZc, this.aZd));
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
    }

    public View Oe() {
        return this.aOT;
    }

    public TextView Of() {
        return this.aYT;
    }

    public String getTitle() {
        return this.aYR.getText().toString();
    }

    public String Og() {
        return this.aYU.getText().toString();
    }

    public String getContent() {
        return this.aZa.getText().toString();
    }

    public long getTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.aZb + "-" + (this.aZc + 1) + "-" + this.aZd + " " + this.aZe + ":" + this.aZf).getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    public void setTitle(String str) {
        this.aYR.setText(str);
    }

    public void setContent(String str) {
        this.aZa.setText(str);
    }

    public void gg(String str) {
        this.aYU.setText(str);
    }

    public void setTime(long j) {
        Date date = new Date(1000 * j);
        this.aZb = date.getYear() + 1900;
        this.aZc = date.getMonth();
        this.aZd = date.getDate();
        this.aZe = date.getHours();
        this.aZf = date.getMinutes();
        Od();
        Oc();
    }

    public void onChangeSkinType(int i) {
        this.aYQ.getLayoutMode().L(i == 1);
        this.aYQ.getLayoutMode().h(this.agI);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.aYT.setText(this.aYQ.getString(y.done));
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
        this.aYT.setText(this.aYQ.getString(y.group_activity_create_btntext));
        this.mNavigationBar.setTitleText(y.group_activity_create);
    }

    public boolean Oh() {
        return this.aZg;
    }
}
