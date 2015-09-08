package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.ch;
import com.baidu.tieba.tbadkCore.ChildViewPager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements ChildViewPager.a {
    final /* synthetic */ ch aYg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ch chVar) {
        this.aYg = chVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ChildViewPager.a
    public void fx(int i) {
        ch.a aVar;
        com.baidu.tbadk.core.data.p pVar;
        Context context;
        aVar = this.aYg.aYd;
        int fz = aVar.fz(i);
        pVar = this.aYg.aYe;
        List<PhotoLiveCardData> rS = pVar.rS();
        if (rS != null && fz >= 0 && fz < rS.size()) {
            PhotoLiveCardData photoLiveCardData = rS.get(fz);
            context = this.aYg.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context, String.valueOf(photoLiveCardData.getThreadId())).ch("from_frs").bs(18003).ro()));
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10242").af(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", fz + 1));
        }
    }
}
