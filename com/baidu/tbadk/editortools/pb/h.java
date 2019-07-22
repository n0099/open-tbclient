package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.InputFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.c {
    private boolean cuj = false;
    public String cuy;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d cL(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_d);
        editorTools.fi(false);
        return new g(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            final EditorTools arY = dVar.arY();
            final g gVar = (g) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.h.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    k kp;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                if (aVar.data instanceof i) {
                                    gVar.a((i) aVar.data);
                                } else if (aVar.data instanceof String) {
                                    gVar.qr((String) aVar.data);
                                }
                                h.this.cuj = false;
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
                                gVar.amk().showToast((int) R.string.over_limit_tip);
                                h.this.cuj = true;
                                return;
                            case 8:
                                if (h.this.a(gVar.amk(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                                    gVar.asR();
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
                                if (arY != null && (kp = arY.kp(6)) != null && kp.crT != null) {
                                    kp.crT.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (h.this.cuj) {
                                    gVar.amk().showToast((int) R.string.over_limit_tip);
                                }
                                if (h.this.a(gVar.amk(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(gVar.amk().getPageActivity(), 12005, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            arY.setActionListener(4, bVar);
            arY.setActionListener(7, bVar);
            arY.setActionListener(16, bVar);
            arY.setActionListener(8, bVar);
            arY.setActionListener(10, bVar);
            arY.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        k kVar;
        EditorTools arY = dVar.arY();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arY.ai(arrayList);
        k kp = arY.kp(5);
        if (kp != null) {
            kp.fk(false);
            kp.csJ = 1;
            kp.csH = R.drawable.new_pbeditor_face_button;
        }
        if (com.baidu.tieba.tbadkCore.voice.c.cqA() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, arY.getContext()), k.class)) != null && (kVar = (k) runTask.getData()) != null) {
            kVar.csH = R.drawable.new_pbeditor_voice_button;
            kVar.csJ = 2;
            arY.b(kVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(arY.getContext(), 4);
        aVar.csH = R.drawable.new_pbeditor_at_button;
        arY.b(aVar);
        e eVar = new e(arY.getContext());
        if (eVar.getInputView() != null) {
            eVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        if (!aq.isEmpty(this.cuy)) {
            eVar.setHint(this.cuy);
        }
        arY.b(eVar);
        arY.arZ();
        arY.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        arY.aqu();
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

    public void qy(String str) {
        this.cuy = str;
    }
}
