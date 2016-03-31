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
    private final /* synthetic */ com.baidu.tbadk.editortools.l avU;
    final /* synthetic */ t awb;
    private final /* synthetic */ p awc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, p pVar, com.baidu.tbadk.editortools.l lVar) {
        this.awb = tVar;
        this.awc = pVar;
        this.avU = lVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.awc.fA((String) aVar.data);
                    this.awb.avQ = false;
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
                    this.awc.Em().showToast(t.j.over_limit_tip);
                    this.awb.avQ = true;
                    return;
                case 8:
                    b = this.awb.b(this.awc.Em(), 11001);
                    if (b) {
                        this.awc.Eo();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.awc.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.avU.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.awc.setVoiceModel(null);
                    this.avU.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.awb.avQ;
                    if (z) {
                        this.awc.Em().showToast(t.j.over_limit_tip);
                    }
                    b2 = this.awb.b(this.awc.Em(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.awc.Em().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
