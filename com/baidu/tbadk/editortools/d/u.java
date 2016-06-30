package com.baidu.tbadk.editortools.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.editortools.b {
    private final /* synthetic */ com.baidu.tbadk.editortools.l asJ;
    final /* synthetic */ t asQ;
    private final /* synthetic */ p asR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, p pVar, com.baidu.tbadk.editortools.l lVar) {
        this.asQ = tVar;
        this.asR = pVar;
        this.asJ = lVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.asR.fD((String) aVar.data);
                    this.asQ.asF = false;
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
                    this.asR.Co().showToast(u.j.over_limit_tip);
                    this.asQ.asF = true;
                    return;
                case 8:
                    b = this.asQ.b(this.asR.Co(), 11001);
                    if (b) {
                        this.asR.Cq();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.asR.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.asJ.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.asR.setVoiceModel(null);
                    this.asJ.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.asQ.asF;
                    if (z) {
                        this.asR.Co().showToast(u.j.over_limit_tip);
                    }
                    b2 = this.asQ.b(this.asR.Co(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asR.Co().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
