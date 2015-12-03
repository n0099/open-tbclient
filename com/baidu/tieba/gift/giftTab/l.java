package com.baidu.tieba.gift.giftTab;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ GiftTabActivity bvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GiftTabActivity giftTabActivity) {
        this.bvt = giftTabActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v27, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        ad adVar3;
        String str;
        String str2;
        com.baidu.tieba.gift.send.b bVar;
        ad adVar4;
        ad adVar5;
        ad adVar6;
        ad adVar7;
        boolean a;
        ad adVar8;
        ad adVar9;
        ad adVar10;
        com.baidu.tbadk.core.data.l lVar;
        int i;
        com.baidu.tbadk.core.data.l lVar2;
        long j;
        com.baidu.tbadk.core.data.l lVar3;
        long j2;
        com.baidu.tbadk.core.data.l lVar4;
        long j3;
        com.baidu.tbadk.core.data.l lVar5;
        String str3;
        com.baidu.tieba.gift.send.b bVar2;
        ad adVar11;
        ad adVar12;
        String str4;
        long j4;
        String str5;
        long j5;
        long j6;
        if (view != null) {
            Activity activity = this.bvt.getActivity();
            adVar = this.bvt.bvf;
            com.baidu.adp.lib.util.k.c(activity, adVar.bug);
            adVar2 = this.bvt.bvf;
            if (view != adVar2.bui) {
                adVar3 = this.bvt.bvf;
                if (view == adVar3.bvJ) {
                    str = this.bvt.addFreeUrl;
                    if (!StringUtils.isNull(str)) {
                        this.bvt.bvl = true;
                        bf vD = bf.vD();
                        TbPageContext<?> pageContext = this.bvt.getPageContext();
                        str2 = this.bvt.addFreeUrl;
                        vD.b(pageContext, new String[]{str2});
                        return;
                    }
                    return;
                }
                return;
            }
            bVar = this.bvt.bvh;
            if (bVar != null) {
                adVar4 = this.bvt.bvf;
                if (adVar4.Tn() > 0) {
                    adVar5 = this.bvt.bvf;
                    if (adVar5.To() != null) {
                        if (!com.baidu.adp.lib.util.k.jg()) {
                            this.bvt.showToast(n.i.neterror);
                        } else if (!TbadkCoreApplication.isLogin()) {
                            TbadkCoreApplication.m411getInst().login(this.bvt.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bvt.getPageContext().getPageActivity(), this.bvt.getPageContext().getString(n.i.login_to_use), true)));
                        } else {
                            GiftTabActivity giftTabActivity = this.bvt;
                            adVar6 = this.bvt.bvf;
                            com.baidu.tbadk.core.data.l To = adVar6.To();
                            adVar7 = this.bvt.bvf;
                            a = giftTabActivity.a(To, adVar7.Tn());
                            if (a) {
                                adVar8 = this.bvt.bvf;
                                adVar8.Tl();
                                GiftTabActivity giftTabActivity2 = this.bvt;
                                adVar9 = this.bvt.bvf;
                                giftTabActivity2.bvj = adVar9.To();
                                GiftTabActivity giftTabActivity3 = this.bvt;
                                adVar10 = this.bvt.bvf;
                                giftTabActivity3.sendCount = adVar10.Tn();
                                lVar = this.bvt.bvj;
                                i = this.bvt.sendCount;
                                lVar.setSendCount(i);
                                lVar2 = this.bvt.bvj;
                                j = this.bvt.threadId;
                                lVar2.setThreadId(j);
                                lVar3 = this.bvt.bvj;
                                j2 = this.bvt.postId;
                                lVar3.setPostId(j2);
                                lVar4 = this.bvt.bvj;
                                j3 = this.bvt.mToUserId;
                                lVar4.setToUserId(j3);
                                lVar5 = this.bvt.bvj;
                                str3 = this.bvt.bvi;
                                lVar5.setToUserName(str3);
                                bVar2 = this.bvt.bvh;
                                adVar11 = this.bvt.bvf;
                                com.baidu.tbadk.core.data.l To2 = adVar11.To();
                                adVar12 = this.bvt.bvf;
                                int Tn = adVar12.Tn();
                                str4 = this.bvt.mFrom;
                                j4 = this.bvt.mToUserId;
                                str5 = this.bvt.bvi;
                                j5 = this.bvt.threadId;
                                j6 = this.bvt.postId;
                                bVar2.a(To2, Tn, str4, j4, str5, j5, j6);
                            }
                        }
                    }
                }
            }
        }
    }
}
