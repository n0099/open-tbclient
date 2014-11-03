package com.baidu.tieba.im.groupInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ String aOn;
    final /* synthetic */ aa bbM;
    private final /* synthetic */ String bbN;
    private final /* synthetic */ long bbO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, String str, String str2, long j) {
        this.bbM = aaVar;
        this.aOn = str;
        this.bbN = str2;
        this.bbO = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        GroupSettingItemData am = this.bbM.am(this.aOn, this.bbN);
        if (am != null && am.isAlreadyApply()) {
            if (System.currentTimeMillis() - am.getLastApplyTimeStamp() <= this.bbO) {
                return false;
            }
        }
        return true;
    }
}
