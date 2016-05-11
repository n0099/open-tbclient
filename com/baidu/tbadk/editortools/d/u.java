package com.baidu.tbadk.editortools.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.editortools.b {
    private final /* synthetic */ com.baidu.tbadk.editortools.l arT;
    final /* synthetic */ t asa;
    private final /* synthetic */ p asb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, p pVar, com.baidu.tbadk.editortools.l lVar) {
        this.asa = tVar;
        this.asb = pVar;
        this.arT = lVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.asb.fx((String) aVar.data);
                    this.asa.arP = false;
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
                    this.asb.Cf().showToast(t.j.over_limit_tip);
                    this.asa.arP = true;
                    return;
                case 8:
                    b = this.asa.b(this.asb.Cf(), 11001);
                    if (b) {
                        this.asb.Ch();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.asb.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.arT.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.asb.setVoiceModel(null);
                    this.arT.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.asa.arP;
                    if (z) {
                        this.asb.Cf().showToast(t.j.over_limit_tip);
                    }
                    b2 = this.asa.b(this.asb.Cf(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asb.Cf().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
