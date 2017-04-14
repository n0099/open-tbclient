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
    private final /* synthetic */ com.baidu.tbadk.editortools.j aBn;
    final /* synthetic */ r aBu;
    private final /* synthetic */ n aBv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, n nVar, com.baidu.tbadk.editortools.j jVar) {
        this.aBu = rVar;
        this.aBv = nVar;
        this.aBn = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean a;
        boolean z;
        boolean a2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.aBv.fy((String) aVar.data);
                    this.aBu.aBj = false;
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
                    this.aBv.yp().showToast(w.l.over_limit_tip);
                    this.aBu.aBj = true;
                    return;
                case 8:
                    a = this.aBu.a(this.aBv.yp(), 11001);
                    if (a) {
                        this.aBv.Ei();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.aBv.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aBn.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.aBv.setVoiceModel(null);
                    this.aBn.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.aBu.aBj;
                    if (z) {
                        this.aBv.yp().showToast(w.l.over_limit_tip);
                    }
                    a2 = this.aBu.a(this.aBv.yp(), 11025);
                    if (a2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aBv.yp().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
