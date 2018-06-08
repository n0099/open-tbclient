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
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.c {
    private boolean aNv = false;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d aZ(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(d.C0141d.cp_bg_line_d);
        editorTools.bC(false);
        return new g(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            final EditorTools Hg = dVar.Hg();
            final g gVar = (g) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.h.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    k eM;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                gVar.gM((String) aVar.data);
                                h.this.aNv = false;
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
                                gVar.BR().showToast(d.k.over_limit_tip);
                                h.this.aNv = true;
                                return;
                            case 8:
                                if (h.this.a(gVar.BR(), 11001)) {
                                    gVar.HY();
                                    TiebaStatic.log("c10090");
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    gVar.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                    gVar.a((PostWriteCallBackData) null);
                                    return;
                                }
                                return;
                            case 11:
                                gVar.setVoiceModel(null);
                                if (Hg != null && (eM = Hg.eM(6)) != null && eM.aLj != null) {
                                    eM.aLj.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (h.this.aNv) {
                                    gVar.BR().showToast(d.k.over_limit_tip);
                                }
                                if (h.this.a(gVar.BR(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(gVar.BR().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Hg.setActionListener(4, bVar);
            Hg.setActionListener(7, bVar);
            Hg.setActionListener(16, bVar);
            Hg.setActionListener(8, bVar);
            Hg.setActionListener(10, bVar);
            Hg.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        k kVar;
        EditorTools Hg = dVar.Hg();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Hg.F(arrayList);
        k eM = Hg.eM(5);
        if (eM != null) {
            eM.bE(false);
            eM.aLY = 1;
            eM.aLW = d.f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.byj() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, Hg.getContext()), k.class)) != null && (kVar = (k) runTask.getData()) != null) {
            kVar.aLW = d.f.new_pbeditor_voice_button;
            kVar.aLY = 2;
            Hg.b(kVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Hg.getContext(), 4);
        aVar.aLW = d.f.new_pbeditor_at_button;
        Hg.b(aVar);
        e eVar = new e(Hg.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Hg.b(eVar);
        Hg.Hh();
        Hg.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Hg.FB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.k.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
