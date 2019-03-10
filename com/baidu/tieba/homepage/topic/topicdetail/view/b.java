package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.text.InputFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b extends com.baidu.tbadk.editortools.c {
    private boolean ckK = false;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d de(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(false);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(d.C0236d.cp_bg_line_d);
        editorTools.eI(false);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            EditorTools alT = dVar.alT();
            final a aVar = (a) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    int size;
                    if (aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                            case 6:
                                aVar.oS((String) aVar2.data);
                                b.this.ckK = false;
                                return;
                            case 5:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            default:
                                return;
                            case 7:
                                aVar.agj().showToast(d.j.over_limit_tip);
                                b.this.ckK = true;
                                return;
                            case 8:
                                if (b.this.a(aVar.agj(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                                    aVar.amM();
                                    TiebaStatic.log(new am("c13363").bJ("topic_id", String.valueOf(aVar.bnk())));
                                    return;
                                }
                                return;
                            case 14:
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) aVar.agj().getPageActivity(), aVar.getWriteImagesInfo().toJsonString(), true, true);
                                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                                if (com.baidu.tbadk.editortools.pb.a.amq().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(4);
                                    if (aVar.getWriteImagesInfo() != null) {
                                        aVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (aVar.getWriteImagesInfo() != null) {
                                    aVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.b(aVar.agj().getPageActivity(), aVar.agj().getPageActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar2.data).intValue();
                                if (aVar.getWriteImagesInfo() != null && aVar.getWriteImagesInfo().getChosedFiles() != null && (size = aVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(aVar.agj().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, aVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            alT.setActionListener(5, bVar);
            alT.setActionListener(4, bVar);
            alT.setActionListener(6, bVar);
            alT.setActionListener(7, bVar);
            alT.setActionListener(16, bVar);
            alT.setActionListener(14, bVar);
            alT.setActionListener(15, bVar);
            alT.setActionListener(8, bVar);
            alT.setActionListener(32, bVar);
            alT.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        EditorTools alT = dVar.alT();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        alT.ab(arrayList);
        k jw = alT.jw(5);
        if (jw != null) {
            jw.eK(false);
            jw.cjk = 1;
            jw.cji = d.f.new_pbeditor_face_button;
        }
        com.baidu.tbadk.editortools.imagetool.d dVar2 = new com.baidu.tbadk.editortools.imagetool.d(alT.getContext(), 3);
        dVar2.cji = d.f.new_pbeditor_image_button;
        alT.b(dVar2);
        c cVar = new c(alT.getContext());
        if (cVar.getInputView() != null) {
            cVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(14000)});
        }
        alT.b(cVar);
        alT.alU();
        alT.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        alT.akq();
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
