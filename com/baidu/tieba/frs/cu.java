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
    final /* synthetic */ cr aXU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cr crVar) {
        this.aXU = crVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ChildViewPager.a
    public void fK(int i) {
        cr.a aVar;
        com.baidu.tbadk.core.data.p pVar;
        Context context;
        aVar = this.aXU.aXR;
        int fM = aVar.fM(i);
        pVar = this.aXU.aXS;
        List<PhotoLiveCardData> rM = pVar.rM();
        if (rM != null && fM >= 0 && fM < rM.size()) {
            PhotoLiveCardData photoLiveCardData = rM.get(fM);
            context = this.aXU.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context, String.valueOf(photoLiveCardData.getThreadId())).cg("from_frs").bs(18003).ri()));
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10242").ae(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", fM + 1));
        }
    }
}
