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
    protected com.baidu.tbadk.editortools.d dP(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_d);
        editorTools.ig(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.a(bfW());
        eVar.isBJH = true;
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.g, com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof e) {
            final EditorTools bfa = dVar.bfa();
            final e eVar = (e) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.d.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (eVar != null && eVar.bfa() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar.yD(aVar.data.toString());
                                return;
                            case 5:
                                if (!bfa.bfc()) {
                                    TiebaStatic.eventStat(bfa.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                eVar.bfL().showToast(R.string.over_limit_tip);
                                return;
                            case 8:
                                if (d.this.a(eVar.bfL().getPageContext(), 11001)) {
                                    eVar.a((String) null, (WriteData) null);
                                    return;
                                }
                                return;
                            case 14:
                                if (eVar.getWriteImagesInfo() != null) {
                                    eVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                }
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) eVar.bfL().getActivity(), eVar.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(d.this.getFrom(), true)) {
                                    albumActivityConfig.getIntent().putExtra("from", d.this.getFrom());
                                }
                                if (d.this.bfV() != null && !StringUtils.isNull(d.this.bfV().getId(), true)) {
                                    albumActivityConfig.getIntent().putExtra("forum_id", d.this.bfV().getId());
                                }
                                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                l.hideSoftKeyPad(eVar.bfL().getActivity(), eVar.bfL().getActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (eVar.getWriteImagesInfo() != null && eVar.getWriteImagesInfo().getChosedFiles() != null && (size = eVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(eVar.bfL().getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, eVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bfa.setActionListener(5, bVar);
            bfa.setActionListener(4, bVar);
            bfa.setActionListener(7, bVar);
            bfa.setActionListener(14, bVar);
            bfa.setActionListener(15, bVar);
            bfa.setActionListener(8, bVar);
            bfa.setActionListener(32, bVar);
            bfa.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.g, com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        EditorTools bfa = dVar.bfa();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        bfa.b(new com.baidu.tbadk.editortools.imagetool.d(bfa.getContext(), 1));
        bfa.b(new f(bfa.getContext(), true));
        bfa.aW(arrayList);
        com.baidu.tbadk.editortools.l nB = bfa.nB(5);
        if (nB != null) {
            nB.euy = 2;
            nB.ii(false);
        }
        bfa.build();
        bfa.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
