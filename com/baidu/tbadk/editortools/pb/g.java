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
public class g extends com.baidu.tbadk.editortools.d {
    private boolean aDB = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aX(Context context) {
        i iVar = new i(context);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.C0080d.cp_bg_line_d);
        iVar.by(false);
        return new f(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            final i CU = fVar.CU();
            final f fVar2 = (f) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.g.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                fVar2.fV((String) aVar.data);
                                g.this.aDB = false;
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
                                fVar2.xP().showToast(d.j.over_limit_tip);
                                g.this.aDB = true;
                                return;
                            case 8:
                                if (g.this.a(fVar2.xP(), 11001)) {
                                    fVar2.DO();
                                    TiebaStatic.log("c10090");
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    fVar2.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                }
                                CU.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                                return;
                            case 11:
                                fVar2.setVoiceModel(null);
                                CU.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                                return;
                            case 16:
                                if (g.this.aDB) {
                                    fVar2.xP().showToast(d.j.over_limit_tip);
                                }
                                if (g.this.a(fVar2.xP(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(fVar2.xP().getPageActivity(), 12005, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            CU.a(4, bVar);
            CU.a(7, bVar);
            CU.a(16, bVar);
            CU.a(8, bVar);
            CU.a(10, bVar);
            CU.a(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        i CU = fVar.CU();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        CU.A(arrayList);
        r eO = CU.eO(5);
        if (eO != null) {
            eO.bA(false);
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bvK() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CU.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.aCa = 2;
            CU.b(rVar);
        }
        CU.b(new com.baidu.tbadk.editortools.a.a(CU.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(CU.getContext(), true);
        if (aVar.aBn instanceof EditText) {
            ((EditText) aVar.aBn).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        CU.b(aVar);
        CU.b(new com.baidu.tbadk.editortools.sendtool.a(CU.getContext()));
        CU.CV();
        CU.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        CU.Bc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
