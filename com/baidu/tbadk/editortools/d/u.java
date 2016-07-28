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
    final /* synthetic */ t atF;
    private final /* synthetic */ p atG;
    private final /* synthetic */ com.baidu.tbadk.editortools.l aty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, p pVar, com.baidu.tbadk.editortools.l lVar) {
        this.atF = tVar;
        this.atG = pVar;
        this.aty = lVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.atG.fB((String) aVar.data);
                    this.atF.atu = false;
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
                    this.atG.Cn().showToast(u.j.over_limit_tip);
                    this.atF.atu = true;
                    return;
                case 8:
                    b = this.atF.b(this.atG.Cn(), 11001);
                    if (b) {
                        this.atG.Cp();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.atG.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aty.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.atG.setVoiceModel(null);
                    this.aty.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.atF.atu;
                    if (z) {
                        this.atG.Cn().showToast(u.j.over_limit_tip);
                    }
                    b2 = this.atF.b(this.atG.Cn(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.atG.Cn().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
