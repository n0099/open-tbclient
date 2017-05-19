package com.baidu.tieba.frs.d;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h {
    public static void a(com.baidu.tieba.frs.r rVar, com.baidu.tieba.tbadkCore.n nVar, Intent intent) {
        a(rVar, nVar, e(nVar), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private static ShareFromFrsMsgData e(com.baidu.tieba.tbadkCore.n nVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(nVar.aHE().getImage_url());
        shareFromFrsMsgData.setName(nVar.aHE().getName());
        shareFromFrsMsgData.setMemberNum(nVar.aHE().getMember_num());
        shareFromFrsMsgData.setPostNum(nVar.aHE().getPost_num());
        shareFromFrsMsgData.setContent(nVar.aHE().getSlogan());
        return shareFromFrsMsgData;
    }

    private static void a(com.baidu.tieba.frs.r rVar, com.baidu.tieba.tbadkCore.n nVar, ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (nVar != null && nVar.aHE() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(rVar.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.i iVar = new com.baidu.tieba.frs.view.i(rVar.getPageContext().getPageActivity());
            iVar.setPageId(rVar.getUniqueId());
            iVar.setData(shareFromFrsMsgData);
            aVar.bZ(1);
            aVar.v(iVar);
            aVar.a(w.l.share, new i(rVar, iVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(w.l.alert_no_button, new j(rVar, iVar));
            aVar.at(true);
            aVar.b(rVar.getPageContext()).td();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                iVar.G(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    public static void a(com.baidu.tieba.frs.r rVar, com.baidu.tieba.tbadkCore.n nVar, int i, String str, long j) {
        if (nVar != null && nVar.aHE() != null) {
            ShareFromFrsMsgData e = e(nVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(rVar.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.i iVar = new com.baidu.tieba.frs.view.i(rVar.getPageContext().getPageActivity());
            iVar.setPageId(rVar.getUniqueId());
            iVar.setData(e);
            aVar.bZ(1);
            aVar.v(iVar);
            aVar.a(w.l.share, new k(rVar, iVar, i, str, j, e));
            aVar.b(w.l.alert_no_button, new l(rVar, iVar));
            aVar.at(true);
            aVar.b(rVar.getPageContext()).td();
            if (!com.baidu.adp.lib.util.j.isEmpty(e.getImageUrl())) {
                iVar.G(e.getImageUrl(), false);
            }
        }
    }
}
