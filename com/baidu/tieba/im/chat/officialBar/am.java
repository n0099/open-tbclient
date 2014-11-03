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
    private BaseActivity Or;
    private BarImageView aRL;
    private TextView aRM;
    private TextView aRN;
    private SettingTextSwitchView aRO;
    private RelativeLayout aRP;
    private RelativeLayout aRQ;
    private Button aRR;
    private NavigationBar aop;
    private View mRoot;

    public am(BaseActivity baseActivity) {
        super(baseActivity);
        this.Or = baseActivity;
        nu();
    }

    private void nu() {
        this.mRoot = View.inflate(this.Or, com.baidu.tieba.w.official_bar_info_activity, null);
        this.Or.setContentView(this.mRoot);
        this.aop = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aop.setTitleText(com.baidu.tieba.y.officical_bar_info_title);
        this.aop.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aRL = (BarImageView) this.mRoot.findViewById(com.baidu.tieba.v.bar_img);
        this.aRM = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.bar_name);
        this.aRN = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.bar_authen_content);
        this.aRO = (SettingTextSwitchView) this.mRoot.findViewById(com.baidu.tieba.v.bar_notify);
        this.aRP = (RelativeLayout) this.mRoot.findViewById(com.baidu.tieba.v.bar_info_clean_lay);
        this.aRQ = (RelativeLayout) this.mRoot.findViewById(com.baidu.tieba.v.bar_info_history_lay);
        this.aRR = (Button) this.mRoot.findViewById(com.baidu.tieba.v.bar_info_goto_btn);
    }

    public void cH(boolean z) {
        if (z) {
            this.aRO.gN();
        } else {
            this.aRO.gO();
        }
    }

    public RelativeLayout Kw() {
        return this.aRP;
    }

    public RelativeLayout Kx() {
        return this.aRQ;
    }

    public Button Ky() {
        return this.aRR;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aRP.setOnClickListener(onClickListener);
        this.aRQ.setOnClickListener(onClickListener);
        this.aRR.setOnClickListener(onClickListener);
    }

    public void fC(String str) {
        this.aRN.setText(str);
    }

    public void setName(String str) {
        String str2 = String.valueOf(str) + this.Or.getString(com.baidu.tieba.y.bar);
        this.aRM.setText(str2);
        this.aRR.setText(String.valueOf(this.Or.getString(com.baidu.tieba.y.visit)) + str2);
    }

    public void fD(String str) {
        this.aRL.c(str, 10, false);
    }

    public void a(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.aRO.setSwitchStateChangeListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.Or.getLayoutMode().L(i == 1);
        this.Or.getLayoutMode().h(this.mRoot);
        this.aop.onChangeSkinType(i);
        this.aRO.cu(i);
    }
}
