package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.text.InputFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b extends com.baidu.tbadk.editortools.c {
    private boolean dyQ = false;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dW(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(false);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.gC(false);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            EditorTools aOr = dVar.aOr();
            final a aVar = (a) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    int size;
                    if (aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                            case 6:
                                aVar.vm((String) aVar2.data);
                                b.this.dyQ = false;
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
                                aVar.aJo().showToast((int) R.string.over_limit_tip);
                                b.this.dyQ = true;
                                return;
                            case 8:
                                if (b.this.a(aVar.aJo(), 11001)) {
                                    aVar.aPm();
                                    TiebaStatic.log(new an("c13363").cy("topic_id", String.valueOf(aVar.bPs())));
                                    return;
                                }
                                return;
                            case 14:
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) aVar.aJo().getPageActivity(), aVar.getWriteImagesInfo().toJsonString(), true, true);
                                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                if (com.baidu.tbadk.editortools.pb.a.aON().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(4);
                                    if (aVar.getWriteImagesInfo() != null) {
                                        aVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (aVar.getWriteImagesInfo() != null) {
                                    aVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.hideSoftKeyPad(aVar.aJo().getPageActivity(), aVar.aJo().getPageActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar2.data).intValue();
                                if (aVar.getWriteImagesInfo() != null && aVar.getWriteImagesInfo().getChosedFiles() != null && (size = aVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(aVar.aJo().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, aVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            aOr.setActionListener(5, bVar);
            aOr.setActionListener(4, bVar);
            aOr.setActionListener(6, bVar);
            aOr.setActionListener(7, bVar);
            aOr.setActionListener(16, bVar);
            aOr.setActionListener(14, bVar);
            aOr.setActionListener(15, bVar);
            aOr.setActionListener(8, bVar);
            aOr.setActionListener(32, bVar);
            aOr.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        EditorTools aOr = dVar.aOr();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        aOr.aI(arrayList);
        com.baidu.tbadk.editortools.l mp = aOr.mp(5);
        if (mp != null) {
            mp.gE(false);
            mp.dxp = 1;
        }
        aOr.b(new com.baidu.tbadk.editortools.imagetool.d(aOr.getContext(), 3));
        c cVar = new c(aOr.getContext());
        if (cVar.getInputView() != null) {
            cVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(14000)});
        }
        aOr.b(cVar);
        aOr.build();
        aOr.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        aOr.aMO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }
}
