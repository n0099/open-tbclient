package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class s implements com.baidu.tbadk.editortools.b {
    private final /* synthetic */ com.baidu.tbadk.editortools.j aAX;
    final /* synthetic */ r aBe;
    private final /* synthetic */ n aBf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, n nVar, com.baidu.tbadk.editortools.j jVar) {
        this.aBe = rVar;
        this.aBf = nVar;
        this.aAX = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean a;
        boolean z;
        boolean a2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.aBf.fs((String) aVar.data);
                    this.aBe.aAT = false;
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
                    this.aBf.xR().showToast(w.l.over_limit_tip);
                    this.aBe.aAT = true;
                    return;
                case 8:
                    a = this.aBe.a(this.aBf.xR(), 11001);
                    if (a) {
                        this.aBf.DK();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.aBf.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aAX.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.aBf.setVoiceModel(null);
                    this.aAX.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.aBe.aAT;
                    if (z) {
                        this.aBf.xR().showToast(w.l.over_limit_tip);
                    }
                    a2 = this.aBe.a(this.aBf.xR(), 11025);
                    if (a2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aBf.xR().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
