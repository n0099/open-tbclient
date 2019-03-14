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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.c {
    private boolean ckK = false;
    public String ckY;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d de(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(d.C0277d.cp_bg_line_d);
        editorTools.eI(false);
        return new g(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            final EditorTools alS = dVar.alS();
            final g gVar = (g) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.h.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    k jw;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                if (aVar.data instanceof i) {
                                    gVar.a((i) aVar.data);
                                } else if (aVar.data instanceof String) {
                                    gVar.oS((String) aVar.data);
                                }
                                h.this.ckK = false;
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
                                gVar.agj().showToast(d.j.over_limit_tip);
                                h.this.ckK = true;
                                return;
                            case 8:
                                if (h.this.a(gVar.agj(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                                    gVar.amL();
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
                                if (alS != null && (jw = alS.jw(6)) != null && jw.ciu != null) {
                                    jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (h.this.ckK) {
                                    gVar.agj().showToast(d.j.over_limit_tip);
                                }
                                if (h.this.a(gVar.agj(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(gVar.agj().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            alS.setActionListener(4, bVar);
            alS.setActionListener(7, bVar);
            alS.setActionListener(16, bVar);
            alS.setActionListener(8, bVar);
            alS.setActionListener(10, bVar);
            alS.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        k kVar;
        EditorTools alS = dVar.alS();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        alS.ab(arrayList);
        k jw = alS.jw(5);
        if (jw != null) {
            jw.eK(false);
            jw.cjk = 1;
            jw.cji = d.f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.cfE() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, alS.getContext()), k.class)) != null && (kVar = (k) runTask.getData()) != null) {
            kVar.cji = d.f.new_pbeditor_voice_button;
            kVar.cjk = 2;
            alS.b(kVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(alS.getContext(), 4);
        aVar.cji = d.f.new_pbeditor_at_button;
        alS.b(aVar);
        e eVar = new e(alS.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        if (!ap.isEmpty(this.ckY)) {
            eVar.setHint(this.ckY);
        }
        alS.b(eVar);
        alS.alT();
        alS.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        alS.akp();
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

    public void oZ(String str) {
        this.ckY = str;
    }
}
