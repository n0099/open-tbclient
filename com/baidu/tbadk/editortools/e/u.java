package com.baidu.tbadk.editortools.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.editortools.b {
    private final /* synthetic */ com.baidu.tbadk.editortools.l awi;
    final /* synthetic */ t awp;
    private final /* synthetic */ p awq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, p pVar, com.baidu.tbadk.editortools.l lVar) {
        this.awp = tVar;
        this.awq = pVar;
        this.awi = lVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.awq.fH((String) aVar.data);
                    this.awp.awe = false;
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
                    this.awq.DI().showToast(r.j.over_limit_tip);
                    this.awp.awe = true;
                    return;
                case 8:
                    b = this.awp.b(this.awq.DI(), 11001);
                    if (b) {
                        this.awq.DK();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.awq.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.awi.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.awq.setVoiceModel(null);
                    this.awi.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.awp.awe;
                    if (z) {
                        this.awq.DI().showToast(r.j.over_limit_tip);
                    }
                    b2 = this.awp.b(this.awq.DI(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.awq.DI().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
