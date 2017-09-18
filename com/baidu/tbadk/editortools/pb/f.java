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
    private boolean aDG = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aY(Context context) {
        i iVar = new i(context);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.e.cp_bg_line_d);
        iVar.bE(false);
        return new e(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            final i CV = fVar.CV();
            final e eVar = (e) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.f.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar.fV((String) aVar.data);
                                f.this.aDG = false;
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
                                eVar.yi().showToast(d.l.over_limit_tip);
                                f.this.aDG = true;
                                return;
                            case 8:
                                if (f.this.a(eVar.yi(), 11001)) {
                                    eVar.DP();
                                    TiebaStatic.log("c10090");
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    eVar.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                }
                                CV.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                                return;
                            case 11:
                                eVar.setVoiceModel(null);
                                CV.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                                return;
                            case 16:
                                if (f.this.aDG) {
                                    eVar.yi().showToast(d.l.over_limit_tip);
                                }
                                if (f.this.a(eVar.yi(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(eVar.yi().getPageActivity(), 12005, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            CV.a(4, bVar);
            CV.a(7, bVar);
            CV.a(16, bVar);
            CV.a(8, bVar);
            CV.a(10, bVar);
            CV.a(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        i CV = fVar.CV();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        CV.A(arrayList);
        r eE = CV.eE(5);
        if (eE != null) {
            eE.bG(false);
        }
        if (com.baidu.tieba.tbadkCore.voice.c.btE() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CV.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.aCb = 2;
            CV.b(rVar);
        }
        CV.b(new com.baidu.tbadk.editortools.a.a(CV.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(CV.getContext(), true);
        if (aVar.aBn instanceof EditText) {
            ((EditText) aVar.aBn).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        CV.b(aVar);
        CV.b(new com.baidu.tbadk.editortools.sendtool.a(CV.getContext()));
        CV.CW();
        CV.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        CV.Bp();
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
