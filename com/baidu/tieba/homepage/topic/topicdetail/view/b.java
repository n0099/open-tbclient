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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class b extends com.baidu.tbadk.editortools.c {
    private boolean ePQ = false;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e ec(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(false);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.ji(false);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar != null) {
            EditorTools bsv = eVar.bsv();
            final a aVar = (a) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    int size;
                    if (aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                            case 6:
                                aVar.Cw((String) aVar2.data);
                                b.this.ePQ = false;
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
                                aVar.bnz().showToast(R.string.over_limit_tip);
                                b.this.ePQ = true;
                                return;
                            case 8:
                                if (b.this.a(aVar.bnz(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                                    aVar.btz();
                                    TiebaStatic.log(new aq("c13363").dF("topic_id", String.valueOf(aVar.cCJ())));
                                    return;
                                }
                                return;
                            case 14:
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) aVar.bnz().getPageActivity(), aVar.getWriteImagesInfo().toJsonString(), true, true);
                                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                if (com.baidu.tbadk.editortools.pb.a.bsY().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(4);
                                    if (aVar.getWriteImagesInfo() != null) {
                                        aVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (aVar.getWriteImagesInfo() != null) {
                                    aVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.hideSoftKeyPad(aVar.bnz().getPageActivity(), aVar.bnz().getPageActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar2.data).intValue();
                                if (aVar.getWriteImagesInfo() != null && aVar.getWriteImagesInfo().getChosedFiles() != null && (size = aVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(aVar.bnz().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, aVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bsv.setActionListener(5, bVar);
            bsv.setActionListener(4, bVar);
            bsv.setActionListener(6, bVar);
            bsv.setActionListener(7, bVar);
            bsv.setActionListener(16, bVar);
            bsv.setActionListener(14, bVar);
            bsv.setActionListener(15, bVar);
            bsv.setActionListener(8, bVar);
            bsv.setActionListener(32, bVar);
            bsv.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        EditorTools bsv = eVar.bsv();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        bsv.bg(arrayList);
        m qr = bsv.qr(5);
        if (qr != null) {
            qr.jk(false);
            qr.eNL = 1;
        }
        bsv.b(new com.baidu.tbadk.editortools.imagetool.d(bsv.getContext(), 3));
        c cVar = new c(bsv.getContext());
        if (cVar.getInputView() != null) {
            cVar.getInputView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(14000)});
        }
        bsv.b(cVar);
        bsv.build();
        bsv.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        bsv.bqS();
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
