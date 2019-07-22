package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.text.InputFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b extends com.baidu.tbadk.editortools.c {
    private boolean cuj = false;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d cL(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(false);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_d);
        editorTools.fi(false);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            EditorTools arY = dVar.arY();
            final a aVar = (a) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    int size;
                    if (aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                            case 6:
                                aVar.qr((String) aVar2.data);
                                b.this.cuj = false;
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
                                aVar.amk().showToast((int) R.string.over_limit_tip);
                                b.this.cuj = true;
                                return;
                            case 8:
                                if (b.this.a(aVar.amk(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                                    aVar.asR();
                                    TiebaStatic.log(new an("c13363").bT("topic_id", String.valueOf(aVar.bxq())));
                                    return;
                                }
                                return;
                            case 14:
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) aVar.amk().getPageActivity(), aVar.getWriteImagesInfo().toJsonString(), true, true);
                                albumActivityConfig.setRequestCode(12002);
                                if (com.baidu.tbadk.editortools.pb.a.asv().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(4);
                                    if (aVar.getWriteImagesInfo() != null) {
                                        aVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (aVar.getWriteImagesInfo() != null) {
                                    aVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.b(aVar.amk().getPageActivity(), aVar.amk().getPageActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar2.data).intValue();
                                if (aVar.getWriteImagesInfo() != null && aVar.getWriteImagesInfo().getChosedFiles() != null && (size = aVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(aVar.amk().getPageActivity(), 12012, aVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            arY.setActionListener(5, bVar);
            arY.setActionListener(4, bVar);
            arY.setActionListener(6, bVar);
            arY.setActionListener(7, bVar);
            arY.setActionListener(16, bVar);
            arY.setActionListener(14, bVar);
            arY.setActionListener(15, bVar);
            arY.setActionListener(8, bVar);
            arY.setActionListener(32, bVar);
            arY.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
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
        com.baidu.tbadk.editortools.imagetool.d dVar2 = new com.baidu.tbadk.editortools.imagetool.d(arY.getContext(), 3);
        dVar2.csH = R.drawable.new_pbeditor_image_button;
        arY.b(dVar2);
        c cVar = new c(arY.getContext());
        if (cVar.getInputView() != null) {
            cVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(14000)});
        }
        arY.b(cVar);
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
}
