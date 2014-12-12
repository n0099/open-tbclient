package com.baidu.tieba.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ SecretSettingActivity biA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.biA = secretSettingActivity;
    }

    @Override // com.baidu.tieba.im.more.j
    public void Rm() {
        this.biA.Rl();
    }

    @Override // com.baidu.tieba.im.more.j
    public void onBackPressed() {
        this.biA.finish();
    }

    @Override // com.baidu.tieba.im.more.j
    public void Rn() {
        this.biA.aA("group", this.biA.getPageContext().getString(z.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.im.more.j
    public void Ro() {
        this.biA.aA("post", this.biA.getPageContext().getString(z.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.im.more.j
    public void Rp() {
        this.biA.aA("like", this.biA.getPageContext().getString(z.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.im.more.j
    public void a(BdSwitchView.SwitchState switchState) {
        this.biA.P("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.biA.showProgressBar();
    }
}
