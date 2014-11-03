package com.baidu.tieba.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ SecretSettingActivity bfh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.bfh = secretSettingActivity;
    }

    @Override // com.baidu.tieba.im.more.j
    public void QN() {
        this.bfh.QM();
    }

    @Override // com.baidu.tieba.im.more.j
    public void onBackPressed() {
        this.bfh.finish();
    }

    @Override // com.baidu.tieba.im.more.j
    public void QO() {
        this.bfh.au("group", this.bfh.getString(y.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.im.more.j
    public void QP() {
        this.bfh.au("post", this.bfh.getString(y.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.im.more.j
    public void QQ() {
        this.bfh.au("like", this.bfh.getString(y.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.im.more.j
    public void a(BdSwitchView.SwitchState switchState) {
        this.bfh.I("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.bfh.showProgressBar();
    }
}
