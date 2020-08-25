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
/* loaded from: classes15.dex */
public class d extends g {
    @Override // com.baidu.tbadk.editortools.pb.g, com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e ed(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_d);
        editorTools.ji(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.a(bst());
        eVar.isBJH = true;
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.g, com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar instanceof e) {
            final EditorTools brv = eVar.brv();
            final e eVar2 = (e) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.d.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (eVar2 != null && eVar2.brv() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar2.BZ(aVar.data.toString());
                                return;
                            case 5:
                                if (!brv.brx()) {
                                    TiebaStatic.eventStat(brv.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                eVar2.bmF().showToast(R.string.over_limit_tip);
                                return;
                            case 8:
                                if (d.this.a(eVar2.bmF(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                                    eVar2.a((String) null, (WriteData) null);
                                    return;
                                }
                                return;
                            case 14:
                                if (eVar2.getWriteImagesInfo() != null) {
                                    eVar2.getWriteImagesInfo().setMaxImagesAllowed(1);
                                }
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) eVar2.bmF().getPageActivity(), eVar2.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(d.this.getFrom(), true)) {
                                    albumActivityConfig.getIntent().putExtra("from", d.this.getFrom());
                                }
                                if (d.this.bss() != null && !StringUtils.isNull(d.this.bss().getId(), true)) {
                                    albumActivityConfig.getIntent().putExtra("forum_id", d.this.bss().getId());
                                }
                                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                l.hideSoftKeyPad(eVar2.bmF().getPageActivity(), eVar2.bmF().getPageActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (eVar2.getWriteImagesInfo() != null && eVar2.getWriteImagesInfo().getChosedFiles() != null && (size = eVar2.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(eVar2.bmF().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, eVar2.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            brv.setActionListener(5, bVar);
            brv.setActionListener(4, bVar);
            brv.setActionListener(7, bVar);
            brv.setActionListener(14, bVar);
            brv.setActionListener(15, bVar);
            brv.setActionListener(8, bVar);
            brv.setActionListener(32, bVar);
            brv.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.g, com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        EditorTools brv = eVar.brv();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        brv.b(new com.baidu.tbadk.editortools.imagetool.d(brv.getContext(), 1));
        brv.b(new f(brv.getContext(), true, true));
        brv.bc(arrayList);
        m qe = brv.qe(5);
        if (qe != null) {
            qe.eLq = 2;
            qe.jk(false);
        }
        brv.build();
        brv.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
