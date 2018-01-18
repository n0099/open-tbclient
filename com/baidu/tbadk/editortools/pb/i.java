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
    private boolean bsn = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f bi(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        iVar.setBackgroundColorId(0);
        iVar.setBarLauncherType(2);
        iVar.setBarBackgroundColorId(d.C0107d.cp_bg_line_d);
        iVar.cb(false);
        return new h(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            final com.baidu.tbadk.editortools.i Ku = fVar.Ku();
            final h hVar = (h) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.i.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    r hJ;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                hVar.gf((String) aVar.data);
                                i.this.bsn = false;
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
                                hVar.Fh().showToast(d.j.over_limit_tip);
                                i.this.bsn = true;
                                return;
                            case 8:
                                if (i.this.a(hVar.Fh(), 11001)) {
                                    hVar.Ll();
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
                                if (Ku != null && (hJ = Ku.hJ(6)) != null && hJ.bqa != null) {
                                    hJ.bqa.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (i.this.bsn) {
                                    hVar.Fh().showToast(d.j.over_limit_tip);
                                }
                                if (i.this.a(hVar.Fh(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(hVar.Fh().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Ku.a(4, bVar);
            Ku.a(7, bVar);
            Ku.a(16, bVar);
            Ku.a(8, bVar);
            Ku.a(10, bVar);
            Ku.a(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        com.baidu.tbadk.editortools.i Ku = fVar.Ku();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Ku.I(arrayList);
        r hJ = Ku.hJ(5);
        if (hJ != null) {
            hJ.cd(false);
            hJ.bqP = 1;
            hJ.bqN = d.f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bwQ() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, Ku.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.bqN = d.f.new_pbeditor_voice_button;
            rVar.bqP = 2;
            Ku.b(rVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Ku.getContext(), 4);
        aVar.bqN = d.f.new_pbeditor_at_button;
        Ku.b(aVar);
        e eVar = new e(Ku.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Ku.b(eVar);
        Ku.Kv();
        Ku.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Ku.IE();
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
