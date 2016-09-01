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
    private final /* synthetic */ com.baidu.tbadk.editortools.l awF;
    final /* synthetic */ t awM;
    private final /* synthetic */ p awN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, p pVar, com.baidu.tbadk.editortools.l lVar) {
        this.awM = tVar;
        this.awN = pVar;
        this.awF = lVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.awN.fE((String) aVar.data);
                    this.awM.awB = false;
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
                    this.awN.DI().showToast(t.j.over_limit_tip);
                    this.awM.awB = true;
                    return;
                case 8:
                    b = this.awM.b(this.awN.DI(), 11001);
                    if (b) {
                        this.awN.DK();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.awN.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.awF.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.awN.setVoiceModel(null);
                    this.awF.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.awM.awB;
                    if (z) {
                        this.awN.DI().showToast(t.j.over_limit_tip);
                    }
                    b2 = this.awM.b(this.awN.DI(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.awN.DI().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
