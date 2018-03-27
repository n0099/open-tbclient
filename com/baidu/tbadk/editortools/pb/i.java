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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.editortools.d {
    private boolean buz = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f be(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        iVar.setBackgroundColorId(0);
        iVar.setBarLauncherType(2);
        iVar.setBarBackgroundColorId(d.C0141d.cp_bg_line_d);
        iVar.cg(false);
        return new h(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            final com.baidu.tbadk.editortools.i Lc = fVar.Lc();
            final h hVar = (h) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.i.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    r hI;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                hVar.gx((String) aVar.data);
                                i.this.buz = false;
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
                                hVar.FF().showToast(d.j.over_limit_tip);
                                i.this.buz = true;
                                return;
                            case 8:
                                if (i.this.a(hVar.FF(), 11001)) {
                                    hVar.LT();
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
                                if (Lc != null && (hI = Lc.hI(6)) != null && hI.bsm != null) {
                                    hI.bsm.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (i.this.buz) {
                                    hVar.FF().showToast(d.j.over_limit_tip);
                                }
                                if (i.this.a(hVar.FF(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(hVar.FF().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Lc.a(4, bVar);
            Lc.a(7, bVar);
            Lc.a(16, bVar);
            Lc.a(8, bVar);
            Lc.a(10, bVar);
            Lc.a(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        com.baidu.tbadk.editortools.i Lc = fVar.Lc();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Lc.K(arrayList);
        r hI = Lc.hI(5);
        if (hI != null) {
            hI.ci(false);
            hI.btb = 1;
            hI.bsZ = d.f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.byg() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, Lc.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.bsZ = d.f.new_pbeditor_voice_button;
            rVar.btb = 2;
            Lc.b(rVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Lc.getContext(), 4);
        aVar.bsZ = d.f.new_pbeditor_at_button;
        Lc.b(aVar);
        e eVar = new e(Lc.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Lc.b(eVar);
        Lc.Ld();
        Lc.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Lc.Jm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
