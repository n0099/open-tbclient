package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.InputFilter;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.d {
    private boolean aEq = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aS(Context context) {
        i iVar = new i(context);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.e.common_color_10099);
        iVar.bF(true);
        return new e(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            final i Da = fVar.Da();
            final e eVar = (e) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.f.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar.fX((String) aVar.data);
                                f.this.aEq = false;
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
                                eVar.yg().showToast(d.l.over_limit_tip);
                                f.this.aEq = true;
                                return;
                            case 8:
                                if (f.this.a(eVar.yg(), 11001)) {
                                    eVar.DU();
                                    TiebaStatic.log("c10090");
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    eVar.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                }
                                Da.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                                return;
                            case 11:
                                eVar.setVoiceModel(null);
                                Da.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                                return;
                            case 16:
                                if (f.this.aEq) {
                                    eVar.yg().showToast(d.l.over_limit_tip);
                                }
                                if (f.this.a(eVar.yg(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(eVar.yg().getPageActivity(), 12005, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Da.a(4, bVar);
            Da.a(7, bVar);
            Da.a(16, bVar);
            Da.a(8, bVar);
            Da.a(10, bVar);
            Da.a(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        i Da = fVar.Da();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Da.A(arrayList);
        r eE = Da.eE(5);
        if (eE != null) {
            eE.bH(false);
        }
        if (com.baidu.tieba.tbadkCore.voice.c.btD() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Da.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.aCP = 2;
            Da.b(rVar);
        }
        Da.b(new com.baidu.tbadk.editortools.a.a(Da.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Da.getContext(), true);
        if (aVar.aCc instanceof EditText) {
            ((EditText) aVar.aCc).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Da.b(aVar);
        Da.b(new com.baidu.tbadk.editortools.sendtool.a(Da.getContext()));
        Da.Db();
        Da.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Da.Bu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
