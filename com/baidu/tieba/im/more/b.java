package com.baidu.tieba.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ SecretSettingActivity bjX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.bjX = secretSettingActivity;
    }

    @Override // com.baidu.tieba.im.more.j
    public void RI() {
        this.bjX.RH();
    }

    @Override // com.baidu.tieba.im.more.j
    public void onBackPressed() {
        this.bjX.finish();
    }

    @Override // com.baidu.tieba.im.more.j
    public void RJ() {
        this.bjX.aD("group", this.bjX.getPageContext().getString(z.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.im.more.j
    public void RK() {
        this.bjX.aD("post", this.bjX.getPageContext().getString(z.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.im.more.j
    public void RL() {
        this.bjX.aD("like", this.bjX.getPageContext().getString(z.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.im.more.j
    public void a(BdSwitchView.SwitchState switchState) {
        this.bjX.P("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.bjX.showProgressBar();
    }
}
