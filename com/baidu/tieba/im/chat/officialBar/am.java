package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.base.f {
    private BaseActivity On;
    private SettingTextSwitchView aRA;
    private RelativeLayout aRB;
    private RelativeLayout aRC;
    private Button aRD;
    private BarImageView aRx;
    private TextView aRy;
    private TextView aRz;
    private NavigationBar aog;
    private View mRoot;

    public am(BaseActivity baseActivity) {
        super(baseActivity);
        this.On = baseActivity;
        nu();
    }

    private void nu() {
        this.mRoot = View.inflate(this.On, com.baidu.tieba.w.official_bar_info_activity, null);
        this.On.setContentView(this.mRoot);
        this.aog = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aog.setTitleText(com.baidu.tieba.y.officical_bar_info_title);
        this.aog.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aRx = (BarImageView) this.mRoot.findViewById(com.baidu.tieba.v.bar_img);
        this.aRy = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.bar_name);
        this.aRz = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.bar_authen_content);
        this.aRA = (SettingTextSwitchView) this.mRoot.findViewById(com.baidu.tieba.v.bar_notify);
        this.aRB = (RelativeLayout) this.mRoot.findViewById(com.baidu.tieba.v.bar_info_clean_lay);
        this.aRC = (RelativeLayout) this.mRoot.findViewById(com.baidu.tieba.v.bar_info_history_lay);
        this.aRD = (Button) this.mRoot.findViewById(com.baidu.tieba.v.bar_info_goto_btn);
    }

    public void cH(boolean z) {
        if (z) {
            this.aRA.gN();
        } else {
            this.aRA.gO();
        }
    }

    public RelativeLayout Ks() {
        return this.aRB;
    }

    public RelativeLayout Kt() {
        return this.aRC;
    }

    public Button Ku() {
        return this.aRD;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aRB.setOnClickListener(onClickListener);
        this.aRC.setOnClickListener(onClickListener);
        this.aRD.setOnClickListener(onClickListener);
    }

    public void fC(String str) {
        this.aRz.setText(str);
    }

    public void setName(String str) {
        String str2 = String.valueOf(str) + this.On.getString(com.baidu.tieba.y.bar);
        this.aRy.setText(str2);
        this.aRD.setText(String.valueOf(this.On.getString(com.baidu.tieba.y.visit)) + str2);
    }

    public void fD(String str) {
        this.aRx.c(str, 10, false);
    }

    public void a(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.aRA.setSwitchStateChangeListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.On.getLayoutMode().L(i == 1);
        this.On.getLayoutMode().h(this.mRoot);
        this.aog.onChangeSkinType(i);
        this.aRA.cu(i);
    }
}
