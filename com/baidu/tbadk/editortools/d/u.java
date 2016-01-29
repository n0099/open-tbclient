package com.baidu.tbadk.editortools.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ t avA;
    private final /* synthetic */ p avB;
    private final /* synthetic */ com.baidu.tbadk.editortools.k avu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, p pVar, com.baidu.tbadk.editortools.k kVar) {
        this.avA = tVar;
        this.avB = pVar;
        this.avu = kVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.avB.fs((String) aVar.data);
                    this.avA.avq = false;
                    return;
                case 5:
                case 6:
                case 9:
                case 12:
                case 13:
                case 14:
                case 15:
                default:
                    return;
                case 7:
                    this.avB.DC().showToast(t.j.over_limit_tip);
                    this.avA.avq = true;
                    return;
                case 8:
                    b = this.avA.b(this.avB.DC(), 11001);
                    if (b) {
                        this.avB.DE();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.avB.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.avu.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.avB.setVoiceModel(null);
                    this.avu.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.avA.avq;
                    if (z) {
                        this.avB.DC().showToast(t.j.over_limit_tip);
                    }
                    b2 = this.avA.b(this.avB.DC(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.avB.DC().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
