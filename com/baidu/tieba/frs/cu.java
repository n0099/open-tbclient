package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.cr;
import com.baidu.tieba.tbadkCore.ChildViewPager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements ChildViewPager.a {
    final /* synthetic */ cr aXA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cr crVar) {
        this.aXA = crVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ChildViewPager.a
    public void fC(int i) {
        cr.a aVar;
        com.baidu.tbadk.core.data.o oVar;
        Context context;
        aVar = this.aXA.aXx;
        int fE = aVar.fE(i);
        oVar = this.aXA.aXy;
        List<PhotoLiveCardData> rN = oVar.rN();
        if (rN != null && fE >= 0 && fE < rN.size()) {
            PhotoLiveCardData photoLiveCardData = rN.get(fE);
            context = this.aXA.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context, String.valueOf(photoLiveCardData.getThreadId())).ch("from_frs").bs(18003).rk()));
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10242").ae(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", fE + 1));
        }
    }
}
