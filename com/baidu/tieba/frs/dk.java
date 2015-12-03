package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.tbadkCore.NewChildViewPager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk implements NewChildViewPager.b {
    final /* synthetic */ dh bdU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dh dhVar) {
        this.bdU = dhVar;
    }

    @Override // com.baidu.tieba.tbadkCore.NewChildViewPager.b
    public void gh(int i) {
        dh.a aVar;
        com.baidu.tbadk.core.data.s sVar;
        Context context;
        aVar = this.bdU.bdR;
        int db = aVar.db(i);
        sVar = this.bdU.bdS;
        List<PhotoLiveCardData> sj = sVar.sj();
        if (sj != null && db >= 0 && db < sj.size()) {
            PhotoLiveCardData photoLiveCardData = sj.get(db);
            context = this.bdU.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context, String.valueOf(photoLiveCardData.getThreadId())).cn("from_frs").bv(18003).rw()));
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10242").ab(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", db + 1));
        }
    }
}
