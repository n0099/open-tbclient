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
    private boolean bsw = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f bf(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        iVar.setBackgroundColorId(0);
        iVar.setBarLauncherType(2);
        iVar.setBarBackgroundColorId(d.C0108d.cp_bg_line_d);
        iVar.cc(false);
        return new h(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            final com.baidu.tbadk.editortools.i Kw = fVar.Kw();
            final h hVar = (h) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.i.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    r hJ;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                hVar.gm((String) aVar.data);
                                i.this.bsw = false;
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
                                hVar.Fj().showToast(d.j.over_limit_tip);
                                i.this.bsw = true;
                                return;
                            case 8:
                                if (i.this.a(hVar.Fj(), 11001)) {
                                    hVar.Ln();
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
                                if (Kw != null && (hJ = Kw.hJ(6)) != null && hJ.bqj != null) {
                                    hJ.bqj.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (i.this.bsw) {
                                    hVar.Fj().showToast(d.j.over_limit_tip);
                                }
                                if (i.this.a(hVar.Fj(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(hVar.Fj().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Kw.a(4, bVar);
            Kw.a(7, bVar);
            Kw.a(16, bVar);
            Kw.a(8, bVar);
            Kw.a(10, bVar);
            Kw.a(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        com.baidu.tbadk.editortools.i Kw = fVar.Kw();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Kw.I(arrayList);
        r hJ = Kw.hJ(5);
        if (hJ != null) {
            hJ.ce(false);
            hJ.bqY = 1;
            hJ.bqW = d.f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bwS() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, Kw.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.bqW = d.f.new_pbeditor_voice_button;
            rVar.bqY = 2;
            Kw.b(rVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Kw.getContext(), 4);
        aVar.bqW = d.f.new_pbeditor_at_button;
        Kw.b(aVar);
        e eVar = new e(Kw.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Kw.b(eVar);
        Kw.Kx();
        Kw.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Kw.IG();
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
