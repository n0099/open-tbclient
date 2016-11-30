package com.baidu.tbadk.editortools.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.editortools.b {
    private final /* synthetic */ com.baidu.tbadk.editortools.l axb;
    final /* synthetic */ t axi;
    private final /* synthetic */ p axj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, p pVar, com.baidu.tbadk.editortools.l lVar) {
        this.axi = tVar;
        this.axj = pVar;
        this.axb = lVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean z;
        boolean b2;
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.axj.fK((String) aVar.data);
                    this.axi.awX = false;
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
                    this.axj.xL().showToast(r.j.over_limit_tip);
                    this.axi.awX = true;
                    return;
                case 8:
                    b = this.axi.b(this.axj.xL(), 11001);
                    if (b) {
                        this.axj.DO();
                        TiebaStatic.log("c10090");
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.axj.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.axb.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.axj.setVoiceModel(null);
                    this.axb.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 16:
                    z = this.axi.awX;
                    if (z) {
                        this.axj.xL().showToast(r.j.over_limit_tip);
                    }
                    b2 = this.axi.b(this.axj.xL(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.axj.xL().getPageActivity(), 12005, true)));
                        return;
                    }
                    return;
            }
        }
    }
}
