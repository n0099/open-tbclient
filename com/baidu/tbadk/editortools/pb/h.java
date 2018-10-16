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
    private boolean aWg = false;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d bN(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(e.d.cp_bg_line_d);
        editorTools.bZ(false);
        return new g(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            final EditorTools KH = dVar.KH();
            final g gVar = (g) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.h.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    k fi;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                gVar.hw((String) aVar.data);
                                h.this.aWg = false;
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
                                gVar.Fm().showToast(e.j.over_limit_tip);
                                h.this.aWg = true;
                                return;
                            case 8:
                                if (h.this.a(gVar.Fm(), 11001)) {
                                    gVar.Lz();
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
                                if (KH != null && (fi = KH.fi(6)) != null && fi.aTV != null) {
                                    fi.aTV.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (h.this.aWg) {
                                    gVar.Fm().showToast(e.j.over_limit_tip);
                                }
                                if (h.this.a(gVar.Fm(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(gVar.Fm().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            KH.setActionListener(4, bVar);
            KH.setActionListener(7, bVar);
            KH.setActionListener(16, bVar);
            KH.setActionListener(8, bVar);
            KH.setActionListener(10, bVar);
            KH.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        k kVar;
        EditorTools KH = dVar.KH();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        KH.w(arrayList);
        k fi = KH.fi(5);
        if (fi != null) {
            fi.cb(false);
            fi.aUK = 1;
            fi.aUI = e.f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bDn() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, KH.getContext()), k.class)) != null && (kVar = (k) runTask.getData()) != null) {
            kVar.aUI = e.f.new_pbeditor_voice_button;
            kVar.aUK = 2;
            KH.b(kVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(KH.getContext(), 4);
        aVar.aUI = e.f.new_pbeditor_at_button;
        KH.b(aVar);
        e eVar = new e(KH.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        KH.b(eVar);
        KH.KI();
        KH.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        KH.Jg();
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
