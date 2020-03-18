package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d extends g {
    @Override // com.baidu.tbadk.editortools.pb.g, com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dV(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_d);
        editorTools.gD(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.a(aPs());
        eVar.isBJH = true;
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.g, com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof e) {
            final EditorTools aOy = dVar.aOy();
            final e eVar = (e) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.d.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (eVar != null && eVar.aOy() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar.vm((String) aVar.data);
                                return;
                            case 5:
                                if (!aOy.aOA()) {
                                    TiebaStatic.eventStat(aOy.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
                                    return;
                                }
                                return;
                            case 6:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            default:
                                return;
                            case 7:
                                eVar.aPh().showToast(R.string.over_limit_tip);
                                return;
                            case 8:
                                if (d.this.a(eVar.aPh().getPageContext(), 11001)) {
                                    eVar.a((String) null, (WriteData) null);
                                    return;
                                }
                                return;
                            case 14:
                                if (eVar.getWriteImagesInfo() != null) {
                                    eVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                }
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) eVar.aPh().getActivity(), eVar.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(d.this.getFrom(), true)) {
                                    albumActivityConfig.getIntent().putExtra("from", d.this.getFrom());
                                }
                                if (d.this.aPr() != null && !StringUtils.isNull(d.this.aPr().getId(), true)) {
                                    albumActivityConfig.getIntent().putExtra("forum_id", d.this.aPr().getId());
                                }
                                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                l.hideSoftKeyPad(eVar.aPh().getActivity(), eVar.aPh().getActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (eVar.getWriteImagesInfo() != null && eVar.getWriteImagesInfo().getChosedFiles() != null && (size = eVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(eVar.aPh().getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, eVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            aOy.setActionListener(5, bVar);
            aOy.setActionListener(4, bVar);
            aOy.setActionListener(7, bVar);
            aOy.setActionListener(14, bVar);
            aOy.setActionListener(15, bVar);
            aOy.setActionListener(8, bVar);
            aOy.setActionListener(32, bVar);
            aOy.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.g, com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        EditorTools aOy = dVar.aOy();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        aOy.b(new com.baidu.tbadk.editortools.imagetool.d(aOy.getContext(), 3));
        aOy.b(new f(aOy.getContext()));
        aOy.aI(arrayList);
        com.baidu.tbadk.editortools.l mr = aOy.mr(5);
        if (mr != null) {
            mr.dxQ = 1;
            mr.gF(false);
        }
        aOy.build();
        aOy.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
