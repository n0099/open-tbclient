package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.InputFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.utils.SapiGIDEvent;
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
    private boolean aOq = false;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d ba(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(d.C0140d.cp_bg_line_d);
        editorTools.bD(false);
        return new g(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            final EditorTools Ht = dVar.Ht();
            final g gVar = (g) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.h.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    k eO;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                gVar.gM((String) aVar.data);
                                h.this.aOq = false;
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
                                gVar.Ca().showToast(d.j.over_limit_tip);
                                h.this.aOq = true;
                                return;
                            case 8:
                                if (h.this.a(gVar.Ca(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                                    gVar.Il();
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
                                if (Ht != null && (eO = Ht.eO(6)) != null && eO.aMf != null) {
                                    eO.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (h.this.aOq) {
                                    gVar.Ca().showToast(d.j.over_limit_tip);
                                }
                                if (h.this.a(gVar.Ca(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(gVar.Ca().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Ht.setActionListener(4, bVar);
            Ht.setActionListener(7, bVar);
            Ht.setActionListener(16, bVar);
            Ht.setActionListener(8, bVar);
            Ht.setActionListener(10, bVar);
            Ht.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        k kVar;
        EditorTools Ht = dVar.Ht();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Ht.F(arrayList);
        k eO = Ht.eO(5);
        if (eO != null) {
            eO.bF(false);
            eO.aMU = 1;
            eO.aMS = d.f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bxq() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, Ht.getContext()), k.class)) != null && (kVar = (k) runTask.getData()) != null) {
            kVar.aMS = d.f.new_pbeditor_voice_button;
            kVar.aMU = 2;
            Ht.b(kVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Ht.getContext(), 4);
        aVar.aMS = d.f.new_pbeditor_at_button;
        Ht.b(aVar);
        e eVar = new e(Ht.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Ht.b(eVar);
        Ht.Hu();
        Ht.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Ht.FP();
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
