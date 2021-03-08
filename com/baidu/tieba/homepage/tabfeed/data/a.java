package com.baidu.tieba.homepage.tabfeed.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.DataRes;
import tbclient.ActivityPage.HotTopic;
import tbclient.ActivityPage.RecommendForumList;
import tbclient.ActivityPage.RecommendUserList;
import tbclient.ActivityPage.SpecialColumnList;
import tbclient.BannerImage;
import tbclient.Page;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class a {
    private ArrayList<cb> iQD;
    private m kpU;
    private ak kpV;
    private bo kpW;
    private bt kpX;
    private b kpY;
    private SpecialColumnListData kpZ;
    private boolean hasMore = true;
    private int kpT = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.kpT = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.iQD = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                cb cbVar = new cb();
                cbVar.a(threadInfo);
                cbVar.bnu();
                this.iQD.add(cbVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.kpU = new m();
                this.kpU.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.kpV = new ak();
                this.kpV.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.kpW = new bo();
                this.kpW.bo(recommendForumList.forum_list);
                this.kpW.className = recommendForumList.class_name;
                this.kpW.floorPosition = recommendForumList.floor_position.intValue();
                this.kpW.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.kpW.eQN = R.color.CAM_X0108;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.kpX = new bt();
                this.kpX.bp(recommendUserList.user_list);
                this.kpX.floorPosition = recommendUserList.floor_position.intValue();
                this.kpX.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.kpX.eQN = R.color.CAM_X0108;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.kpY = new b();
                this.kpY.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.kpZ = new SpecialColumnListData();
                this.kpZ.a(specialColumnList);
            }
        }
    }

    public int cSi() {
        return this.kpT;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<cb> cxo() {
        return this.iQD;
    }

    public bo cSj() {
        return this.kpW;
    }

    public bt cSk() {
        return this.kpX;
    }

    public m cSl() {
        return this.kpU;
    }

    public ak cSm() {
        return this.kpV;
    }

    public b cSn() {
        return this.kpY;
    }

    public SpecialColumnListData cSo() {
        return this.kpZ;
    }
}
