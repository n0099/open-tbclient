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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.c {
    private boolean aOn = false;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d aZ(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(f.d.cp_bg_line_d);
        editorTools.bE(false);
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
                    k eN;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                gVar.gM((String) aVar.data);
                                h.this.aOn = false;
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
                                gVar.BX().showToast(f.j.over_limit_tip);
                                h.this.aOn = true;
                                return;
                            case 8:
                                if (h.this.a(gVar.BX(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
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
                                if (Ht != null && (eN = Ht.eN(6)) != null && eN.aMc != null) {
                                    eN.aMc.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (h.this.aOn) {
                                    gVar.BX().showToast(f.j.over_limit_tip);
                                }
                                if (h.this.a(gVar.BX(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(gVar.BX().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
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
        k eN = Ht.eN(5);
        if (eN != null) {
            eN.bG(false);
            eN.aMR = 1;
            eN.aMP = f.C0146f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bxr() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, Ht.getContext()), k.class)) != null && (kVar = (k) runTask.getData()) != null) {
            kVar.aMP = f.C0146f.new_pbeditor_voice_button;
            kVar.aMR = 2;
            Ht.b(kVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Ht.getContext(), 4);
        aVar.aMP = f.C0146f.new_pbeditor_at_button;
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
