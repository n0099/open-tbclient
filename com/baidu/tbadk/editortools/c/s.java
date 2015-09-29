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
    private final /* synthetic */ com.baidu.tbadk.editortools.j asq;
    final /* synthetic */ r asw;
    private final /* synthetic */ n asx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, n nVar, com.baidu.tbadk.editortools.j jVar) {
        this.asw = rVar;
        this.asx = nVar;
        this.asq = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.asx.eZ((String) aVar.data);
                    this.asw.asm = false;
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
                    this.asx.Bv().showToast(i.h.over_limit_tip);
                    this.asw.asm = true;
                    return;
                case 8:
                    b = this.asw.b(this.asx.Bv().getPageContext(), 11001);
                    if (b) {
                        this.asx.BI();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.asx.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.asq.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.asx.setVoiceModel(null);
                    this.asq.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.asw.asm;
                    if (z) {
                        this.asx.Bv().showToast(i.h.over_limit_tip);
                    }
                    b2 = this.asw.b(this.asx.Bv().getPageContext(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asx.Bv().getActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
