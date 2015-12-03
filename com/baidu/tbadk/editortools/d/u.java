package com.baidu.tbadk.editortools.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.editortools.b {
    private final /* synthetic */ com.baidu.tbadk.editortools.k asY;
    final /* synthetic */ t ate;
    private final /* synthetic */ p atf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, p pVar, com.baidu.tbadk.editortools.k kVar) {
        this.ate = tVar;
        this.atf = pVar;
        this.asY = kVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.atf.fq((String) aVar.data);
                    this.ate.asU = false;
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
                    this.atf.Cx().showToast(n.i.over_limit_tip);
                    this.ate.asU = true;
                    return;
                case 8:
                    b = this.ate.b(this.atf.Cx(), 11001);
                    if (b) {
                        this.atf.Cz();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.atf.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.asY.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.atf.setVoiceModel(null);
                    this.asY.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.ate.asU;
                    if (z) {
                        this.atf.Cx().showToast(n.i.over_limit_tip);
                    }
                    b2 = this.ate.b(this.atf.Cx(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.atf.Cx().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
