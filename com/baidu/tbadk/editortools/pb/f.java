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
    private boolean aCW = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aY(Context context) {
        i iVar = new i(context);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.e.cp_bg_line_d);
        iVar.bD(false);
        return new e(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            final i Cz = fVar.Cz();
            final e eVar = (e) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.f.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar.fO((String) aVar.data);
                                f.this.aCW = false;
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
                                eVar.xH().showToast(d.l.over_limit_tip);
                                f.this.aCW = true;
                                return;
                            case 8:
                                if (f.this.a(eVar.xH(), 11001)) {
                                    eVar.Dt();
                                    TiebaStatic.log("c10090");
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    eVar.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                }
                                Cz.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                                return;
                            case 11:
                                eVar.setVoiceModel(null);
                                Cz.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                                return;
                            case 16:
                                if (f.this.aCW) {
                                    eVar.xH().showToast(d.l.over_limit_tip);
                                }
                                if (f.this.a(eVar.xH(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(eVar.xH().getPageActivity(), 12005, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Cz.a(4, bVar);
            Cz.a(7, bVar);
            Cz.a(16, bVar);
            Cz.a(8, bVar);
            Cz.a(10, bVar);
            Cz.a(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        i Cz = fVar.Cz();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Cz.z(arrayList);
        r eP = Cz.eP(5);
        if (eP != null) {
            eP.bF(false);
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bsD() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Cz.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.aBv = 2;
            Cz.b(rVar);
        }
        Cz.b(new com.baidu.tbadk.editortools.a.a(Cz.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Cz.getContext(), true);
        if (aVar.aAH instanceof EditText) {
            ((EditText) aVar.aAH).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Cz.b(aVar);
        Cz.b(new com.baidu.tbadk.editortools.sendtool.a(Cz.getContext()));
        Cz.CA();
        Cz.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Cz.AN();
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
