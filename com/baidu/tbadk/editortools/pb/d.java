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
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class d extends g {
    @Override // com.baidu.tbadk.editortools.pb.g, com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e eO(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0201);
        editorTools.kt(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.a(bDq());
        eVar.isBJH = true;
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.g, com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar instanceof e) {
            final EditorTools bCn = eVar.bCn();
            final e eVar2 = (e) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.d.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (eVar2 != null && eVar2.bCn() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar2.DW(aVar.data.toString());
                                return;
                            case 5:
                                if (!bCn.bCr()) {
                                    TiebaStatic.eventStat(bCn.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                eVar2.bxs().showToast(R.string.over_limit_tip);
                                return;
                            case 8:
                                if (d.this.a(eVar2.bxs(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                                    eVar2.a((String) null, (WriteData) null);
                                    return;
                                }
                                return;
                            case 14:
                                if (eVar2.getWriteImagesInfo() != null) {
                                    eVar2.getWriteImagesInfo().setMaxImagesAllowed(1);
                                }
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) eVar2.bxs().getPageActivity(), eVar2.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(d.this.getFrom(), true)) {
                                    albumActivityConfig.getIntent().putExtra("from", d.this.getFrom());
                                }
                                if (d.this.bDp() != null && !StringUtils.isNull(d.this.bDp().getId(), true)) {
                                    albumActivityConfig.getIntent().putExtra("forum_id", d.this.bDp().getId());
                                }
                                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                l.hideSoftKeyPad(eVar2.bxs().getPageActivity(), eVar2.bxs().getPageActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (eVar2.getWriteImagesInfo() != null && eVar2.getWriteImagesInfo().getChosedFiles() != null && (size = eVar2.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(eVar2.bxs().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, eVar2.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bCn.setActionListener(5, bVar);
            bCn.setActionListener(4, bVar);
            bCn.setActionListener(7, bVar);
            bCn.setActionListener(14, bVar);
            bCn.setActionListener(15, bVar);
            bCn.setActionListener(8, bVar);
            bCn.setActionListener(32, bVar);
            bCn.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.g, com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        EditorTools bCn = eVar.bCn();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        bCn.b(new com.baidu.tbadk.editortools.imagetool.d(bCn.getContext(), 1));
        bCn.b(new f(bCn.getContext(), true, false));
        bCn.bE(arrayList);
        m sj = bCn.sj(5);
        if (sj != null) {
            sj.fuU = 2;
            sj.kv(false);
        }
        bCn.build();
        bCn.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
