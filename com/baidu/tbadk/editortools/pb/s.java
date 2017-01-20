package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class s implements com.baidu.tbadk.editortools.b {
    private final /* synthetic */ com.baidu.tbadk.editortools.j avC;
    final /* synthetic */ r avJ;
    private final /* synthetic */ n avK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, n nVar, com.baidu.tbadk.editortools.j jVar) {
        this.avJ = rVar;
        this.avK = nVar;
        this.avC = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.avK.fD((String) aVar.data);
                    this.avJ.avy = false;
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
                    this.avK.xv().showToast(r.l.over_limit_tip);
                    this.avJ.avy = true;
                    return;
                case 8:
                    b = this.avJ.b(this.avK.xv(), 11001);
                    if (b) {
                        this.avK.Dr();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.avK.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.avC.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.avK.setVoiceModel(null);
                    this.avC.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.avJ.avy;
                    if (z) {
                        this.avK.xv().showToast(r.l.over_limit_tip);
                    }
                    b2 = this.avJ.b(this.avK.xv(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.avK.xv().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
