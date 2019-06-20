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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.c {
    private boolean csW = false;
    public String ctk;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d cK(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_d);
        editorTools.fe(false);
        return new g(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            final EditorTools aqS = dVar.aqS();
            final g gVar = (g) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.h.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    k kj;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                if (aVar.data instanceof i) {
                                    gVar.a((i) aVar.data);
                                } else if (aVar.data instanceof String) {
                                    gVar.qa((String) aVar.data);
                                }
                                h.this.csW = false;
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
                                gVar.alf().showToast((int) R.string.over_limit_tip);
                                h.this.csW = true;
                                return;
                            case 8:
                                if (h.this.a(gVar.alf(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                                    gVar.arL();
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
                                if (aqS != null && (kj = aqS.kj(6)) != null && kj.cqF != null) {
                                    kj.cqF.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (h.this.csW) {
                                    gVar.alf().showToast((int) R.string.over_limit_tip);
                                }
                                if (h.this.a(gVar.alf(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(gVar.alf().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            aqS.setActionListener(4, bVar);
            aqS.setActionListener(7, bVar);
            aqS.setActionListener(16, bVar);
            aqS.setActionListener(8, bVar);
            aqS.setActionListener(10, bVar);
            aqS.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        k kVar;
        EditorTools aqS = dVar.aqS();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        aqS.ai(arrayList);
        k kj = aqS.kj(5);
        if (kj != null) {
            kj.fg(false);
            kj.crw = 1;
            kj.cru = R.drawable.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.cnH() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, aqS.getContext()), k.class)) != null && (kVar = (k) runTask.getData()) != null) {
            kVar.cru = R.drawable.new_pbeditor_voice_button;
            kVar.crw = 2;
            aqS.b(kVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(aqS.getContext(), 4);
        aVar.cru = R.drawable.new_pbeditor_at_button;
        aqS.b(aVar);
        e eVar = new e(aqS.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        if (!ap.isEmpty(this.ctk)) {
            eVar.setHint(this.ctk);
        }
        aqS.b(eVar);
        aqS.aqT();
        aqS.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        aqS.app();
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

    public void qh(String str) {
        this.ctk = str;
    }
}
