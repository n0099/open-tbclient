package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.InputFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.editortools.d {
    private boolean aEh = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aW(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        iVar.setBackgroundColorId(0);
        iVar.setBarLauncherType(2);
        iVar.setBarBackgroundColorId(d.C0096d.cp_bg_line_d);
        iVar.bz(false);
        return new h(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.i De = fVar.De();
            final h hVar = (h) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.i.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                hVar.fX((String) aVar.data);
                                i.this.aEh = false;
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
                                hVar.xR().showToast(d.j.over_limit_tip);
                                i.this.aEh = true;
                                return;
                            case 8:
                                if (i.this.a(hVar.xR(), 11001)) {
                                    hVar.DW();
                                    TiebaStatic.log("c10090");
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    hVar.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                    hVar.a((PostWriteCallBackData) null);
                                    return;
                                }
                                return;
                            case 11:
                                hVar.setVoiceModel(null);
                                return;
                            case 16:
                                if (i.this.aEh) {
                                    hVar.xR().showToast(d.j.over_limit_tip);
                                }
                                if (i.this.a(hVar.xR(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(hVar.xR().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            De.a(4, bVar);
            De.a(7, bVar);
            De.a(16, bVar);
            De.a(8, bVar);
            De.a(10, bVar);
            De.a(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        com.baidu.tbadk.editortools.i De = fVar.De();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        De.B(arrayList);
        r eP = De.eP(5);
        if (eP != null) {
            eP.bB(false);
            eP.aCI = 1;
            eP.aCG = d.f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.byc() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, De.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.aCG = d.f.new_pbeditor_voice_button;
            rVar.aCI = 2;
            De.b(rVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(De.getContext(), 4);
        aVar.aCG = d.f.new_pbeditor_at_button;
        De.b(aVar);
        e eVar = new e(De.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        De.b(eVar);
        De.Df();
        De.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        De.Bn();
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
