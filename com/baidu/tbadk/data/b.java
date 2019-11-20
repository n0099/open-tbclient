package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.BannerFollowLive;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId cCW = BdUniqueId.gen();
    private List<com.baidu.adp.widget.ListView.m> mList;

    public List<com.baidu.adp.widget.ListView.m> getList() {
        return this.mList;
    }

    public void a(BannerFollowLive bannerFollowLive) {
        if (bannerFollowLive != null) {
            if (this.mList == null) {
                this.mList = new ArrayList();
            } else {
                this.mList.clear();
            }
            List<AlaLiveInfo> list = bannerFollowLive.ala_live_list;
            if (!v.isEmpty(list)) {
                atq();
                for (AlaLiveInfo alaLiveInfo : list) {
                    if (alaLiveInfo != null) {
                        a aVar = new a();
                        aVar.parserProtoBuf(alaLiveInfo);
                        this.mList.add(aVar);
                    }
                }
            }
        }
    }

    private void atq() {
        String string;
        a aVar = new a();
        aVar.cCT = -100;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_START_SYNC, String.class);
        if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
            string = (String) runTask.getData();
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_follow_live_enter_live_square_txt);
        }
        aVar.cCU = string;
        aVar.cCV = R.drawable.icon_follow_live_recommend;
        this.mList.add(aVar);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cCW;
    }
}
