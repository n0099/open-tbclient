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
    private boolean aEY = false;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d aP(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(d.C0126d.cp_bg_line_d);
        editorTools.by(false);
        return new g(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            final EditorTools DF = dVar.DF();
            final g gVar = (g) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.h.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    k eH;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                gVar.gn((String) aVar.data);
                                h.this.aEY = false;
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
                                gVar.ys().showToast(d.k.over_limit_tip);
                                h.this.aEY = true;
                                return;
                            case 8:
                                if (h.this.a(gVar.ys(), 11001)) {
                                    gVar.Ew();
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
                                if (DF != null && (eH = DF.eH(6)) != null && eH.aCM != null) {
                                    eH.aCM.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (h.this.aEY) {
                                    gVar.ys().showToast(d.k.over_limit_tip);
                                }
                                if (h.this.a(gVar.ys(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(gVar.ys().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            DF.setActionListener(4, bVar);
            DF.setActionListener(7, bVar);
            DF.setActionListener(16, bVar);
            DF.setActionListener(8, bVar);
            DF.setActionListener(10, bVar);
            DF.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        k kVar;
        EditorTools DF = dVar.DF();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        DF.C(arrayList);
        k eH = DF.eH(5);
        if (eH != null) {
            eH.bA(false);
            eH.aDB = 1;
            eH.aDz = d.f.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.btg() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, DF.getContext()), k.class)) != null && (kVar = (k) runTask.getData()) != null) {
            kVar.aDz = d.f.new_pbeditor_voice_button;
            kVar.aDB = 2;
            DF.b(kVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(DF.getContext(), 4);
        aVar.aDz = d.f.new_pbeditor_at_button;
        DF.b(aVar);
        e eVar = new e(DF.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        DF.b(eVar);
        DF.DG();
        DF.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        DF.Ca();
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
