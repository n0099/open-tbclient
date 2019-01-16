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
    private boolean bbh = false;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d bN(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(e.d.cp_bg_line_d);
        editorTools.cu(false);
        return new g(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            final EditorTools Mp = dVar.Mp();
            final g gVar = (g) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.h.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    k fL;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                gVar.m18if((String) aVar.data);
                                h.this.bbh = false;
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
                                gVar.GQ().showToast(e.j.over_limit_tip);
                                h.this.bbh = true;
                                return;
                            case 8:
                                if (h.this.a(gVar.GQ(), 11001)) {
                                    gVar.Nh();
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
                                if (Mp != null && (fL = Mp.fL(6)) != null && fL.aYV != null) {
                                    fL.aYV.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (h.this.bbh) {
                                    gVar.GQ().showToast(e.j.over_limit_tip);
                                }
                                if (h.this.a(gVar.GQ(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(gVar.GQ().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Mp.setActionListener(4, bVar);
            Mp.setActionListener(7, bVar);
            Mp.setActionListener(16, bVar);
            Mp.setActionListener(8, bVar);
            Mp.setActionListener(10, bVar);
            Mp.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        k kVar;
        EditorTools Mp = dVar.Mp();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Mp.w(arrayList);
        k fL = Mp.fL(5);
        if (fL != null) {
            fL.cw(false);
            fL.aZK = 1;
            fL.aZI = e.f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bGd() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, Mp.getContext()), k.class)) != null && (kVar = (k) runTask.getData()) != null) {
            kVar.aZI = e.f.new_pbeditor_voice_button;
            kVar.aZK = 2;
            Mp.b(kVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Mp.getContext(), 4);
        aVar.aZI = e.f.new_pbeditor_at_button;
        Mp.b(aVar);
        e eVar = new e(Mp.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Mp.b(eVar);
        Mp.Mq();
        Mp.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Mp.KM();
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
