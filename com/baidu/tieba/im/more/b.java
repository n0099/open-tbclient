package com.baidu.tieba.im.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ SecretSettingActivity beT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SecretSettingActivity secretSettingActivity) {
        this.beT = secretSettingActivity;
    }

    @Override // com.baidu.tieba.im.more.j
    public void QK() {
        this.beT.QJ();
    }

    @Override // com.baidu.tieba.im.more.j
    public void onBackPressed() {
        this.beT.finish();
    }

    @Override // com.baidu.tieba.im.more.j
    public void QL() {
        this.beT.au("group", this.beT.getString(y.privacy_setting_attention_group));
    }

    @Override // com.baidu.tieba.im.more.j
    public void QM() {
        this.beT.au("post", this.beT.getString(y.privacy_setting_attention_forum));
    }

    @Override // com.baidu.tieba.im.more.j
    public void QN() {
        this.beT.au("like", this.beT.getString(y.privacy_setting_attention_bar));
    }

    @Override // com.baidu.tieba.im.more.j
    public void a(BdSwitchView.SwitchState switchState) {
        this.beT.I("location", BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
        this.beT.showProgressBar();
    }
}
