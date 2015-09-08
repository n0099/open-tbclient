package com.baidu.tbadk.editortools.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class s implements com.baidu.tbadk.editortools.b {
    private final /* synthetic */ com.baidu.tbadk.editortools.j atT;
    final /* synthetic */ r atZ;
    private final /* synthetic */ n aua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, n nVar, com.baidu.tbadk.editortools.j jVar) {
        this.atZ = rVar;
        this.aua = nVar;
        this.atT = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.aua.eU((String) aVar.data);
                    this.atZ.atP = false;
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
                    this.aua.BI().showToast(i.h.over_limit_tip);
                    this.atZ.atP = true;
                    return;
                case 8:
                    b = this.atZ.b(this.aua.BI().getPageContext(), 11001);
                    if (b) {
                        this.aua.BV();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.aua.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.atT.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.aua.setVoiceModel(null);
                    this.atT.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.atZ.atP;
                    if (z) {
                        this.aua.BI().showToast(i.h.over_limit_tip);
                    }
                    b2 = this.atZ.b(this.aua.BI().getPageContext(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aua.BI().getActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
