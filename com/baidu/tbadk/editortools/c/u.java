package com.baidu.tbadk.editortools.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.editortools.b {
    private final /* synthetic */ com.baidu.tbadk.editortools.j aqV;
    final /* synthetic */ t arb;
    private final /* synthetic */ p arc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, p pVar, com.baidu.tbadk.editortools.j jVar) {
        this.arb = tVar;
        this.arc = pVar;
        this.aqV = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.arc.fb((String) aVar.data);
                    this.arb.aqR = false;
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
                    this.arc.Bj().showToast(i.h.over_limit_tip);
                    this.arb.aqR = true;
                    return;
                case 8:
                    b = this.arb.b(this.arc.Bj().getPageContext(), 11001);
                    if (b) {
                        this.arc.By();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.arc.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aqV.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.arc.setVoiceModel(null);
                    this.aqV.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.arb.aqR;
                    if (z) {
                        this.arc.Bj().showToast(i.h.over_limit_tip);
                    }
                    b2 = this.arb.b(this.arc.Bj().getPageContext(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.arc.Bj().getActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
