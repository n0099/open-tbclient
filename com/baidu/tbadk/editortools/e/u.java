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
    final /* synthetic */ t awF;
    private final /* synthetic */ p awG;
    private final /* synthetic */ com.baidu.tbadk.editortools.j awy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, p pVar, com.baidu.tbadk.editortools.j jVar) {
        this.awF = tVar;
        this.awG = pVar;
        this.awy = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.awG.fG((String) aVar.data);
                    this.awF.awu = false;
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
                    this.awG.xz().showToast(r.j.over_limit_tip);
                    this.awF.awu = true;
                    return;
                case 8:
                    b = this.awF.b(this.awG.xz(), 11001);
                    if (b) {
                        this.awG.Dw();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.awG.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.awy.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.awG.setVoiceModel(null);
                    this.awy.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.awF.awu;
                    if (z) {
                        this.awG.xz().showToast(r.j.over_limit_tip);
                    }
                    b2 = this.awF.b(this.awG.xz(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.awG.xz().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
