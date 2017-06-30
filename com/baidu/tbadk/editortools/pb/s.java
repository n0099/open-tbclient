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
    private final /* synthetic */ com.baidu.tbadk.editortools.j aCd;
    final /* synthetic */ r aCk;
    private final /* synthetic */ n aCl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, n nVar, com.baidu.tbadk.editortools.j jVar) {
        this.aCk = rVar;
        this.aCl = nVar;
        this.aCd = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean a;
        boolean z;
        boolean a2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.aCl.fN((String) aVar.data);
                    this.aCk.aBZ = false;
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
                    this.aCl.xN().showToast(w.l.over_limit_tip);
                    this.aCk.aBZ = true;
                    return;
                case 8:
                    a = this.aCk.a(this.aCl.xN(), 11001);
                    if (a) {
                        this.aCl.DA();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.aCl.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aCd.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.aCl.setVoiceModel(null);
                    this.aCd.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.aCk.aBZ;
                    if (z) {
                        this.aCl.xN().showToast(w.l.over_limit_tip);
                    }
                    a2 = this.aCk.a(this.aCl.xN(), 11025);
                    if (a2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aCl.xN().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
