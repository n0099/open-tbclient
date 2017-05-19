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
    private final /* synthetic */ com.baidu.tbadk.editortools.j aBo;
    final /* synthetic */ r aBv;
    private final /* synthetic */ n aBw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, n nVar, com.baidu.tbadk.editortools.j jVar) {
        this.aBv = rVar;
        this.aBw = nVar;
        this.aBo = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean a;
        boolean z;
        boolean a2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.aBw.fv((String) aVar.data);
                    this.aBv.aBk = false;
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
                    this.aBw.xD().showToast(w.l.over_limit_tip);
                    this.aBv.aBk = true;
                    return;
                case 8:
                    a = this.aBv.a(this.aBw.xD(), 11001);
                    if (a) {
                        this.aBw.Dm();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.aBw.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aBo.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.aBw.setVoiceModel(null);
                    this.aBo.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.aBv.aBk;
                    if (z) {
                        this.aBw.xD().showToast(w.l.over_limit_tip);
                    }
                    a2 = this.aBv.a(this.aBw.xD(), 11025);
                    if (a2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aBw.xD().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
