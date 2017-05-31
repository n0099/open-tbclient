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
    private final /* synthetic */ com.baidu.tbadk.editortools.j aBa;
    final /* synthetic */ r aBh;
    private final /* synthetic */ n aBi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, n nVar, com.baidu.tbadk.editortools.j jVar) {
        this.aBh = rVar;
        this.aBi = nVar;
        this.aBa = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean a;
        boolean z;
        boolean a2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.aBi.ft((String) aVar.data);
                    this.aBh.aAW = false;
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
                    this.aBi.xw().showToast(w.l.over_limit_tip);
                    this.aBh.aAW = true;
                    return;
                case 8:
                    a = this.aBh.a(this.aBi.xw(), 11001);
                    if (a) {
                        this.aBi.Dg();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.aBi.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aBa.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.aBi.setVoiceModel(null);
                    this.aBa.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.aBh.aAW;
                    if (z) {
                        this.aBi.xw().showToast(w.l.over_limit_tip);
                    }
                    a2 = this.aBh.a(this.aBi.xw(), 11025);
                    if (a2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aBi.xw().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
