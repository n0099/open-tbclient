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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.c {
    private boolean aWW = false;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d bK(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(e.d.cp_bg_line_d);
        editorTools.cq(false);
        return new g(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            final EditorTools KT = dVar.KT();
            final g gVar = (g) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.h.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    k fw;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                gVar.hx((String) aVar.data);
                                h.this.aWW = false;
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
                                gVar.Fy().showToast(e.j.over_limit_tip);
                                h.this.aWW = true;
                                return;
                            case 8:
                                if (h.this.a(gVar.Fy(), 11001)) {
                                    gVar.LL();
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
                                if (KT != null && (fw = KT.fw(6)) != null && fw.aUL != null) {
                                    fw.aUL.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (h.this.aWW) {
                                    gVar.Fy().showToast(e.j.over_limit_tip);
                                }
                                if (h.this.a(gVar.Fy(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(gVar.Fy().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            KT.setActionListener(4, bVar);
            KT.setActionListener(7, bVar);
            KT.setActionListener(16, bVar);
            KT.setActionListener(8, bVar);
            KT.setActionListener(10, bVar);
            KT.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        k kVar;
        EditorTools KT = dVar.KT();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        KT.w(arrayList);
        k fw = KT.fw(5);
        if (fw != null) {
            fw.cs(false);
            fw.aVA = 1;
            fw.aVy = e.f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bCI() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, KT.getContext()), k.class)) != null && (kVar = (k) runTask.getData()) != null) {
            kVar.aVy = e.f.new_pbeditor_voice_button;
            kVar.aVA = 2;
            KT.b(kVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(KT.getContext(), 4);
        aVar.aVy = e.f.new_pbeditor_at_button;
        KT.b(aVar);
        e eVar = new e(KT.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        KT.b(eVar);
        KT.KU();
        KT.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        KT.Js();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }
}
