package com.baidu.tieba.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ SecretSettingActivity bjW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.bjW = secretSettingActivity;
    }

    @Override // com.baidu.tieba.im.more.j
    public void RD() {
        this.bjW.RC();
    }

    @Override // com.baidu.tieba.im.more.j
    public void onBackPressed() {
        this.bjW.finish();
    }

    @Override // com.baidu.tieba.im.more.j
    public void RE() {
        this.bjW.aD("group", this.bjW.getPageContext().getString(z.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.im.more.j
    public void RF() {
        this.bjW.aD("post", this.bjW.getPageContext().getString(z.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.im.more.j
    public void RG() {
        this.bjW.aD("like", this.bjW.getPageContext().getString(z.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.im.more.j
    public void a(BdSwitchView.SwitchState switchState) {
        this.bjW.P("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.bjW.showProgressBar();
    }
}
