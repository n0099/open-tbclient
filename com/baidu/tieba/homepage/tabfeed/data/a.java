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
    private ArrayList<cb> iOG;
    private m knE;
    private ak knF;
    private bo knG;
    private bt knH;
    private b knI;
    private SpecialColumnListData knJ;
    private boolean hasMore = true;
    private int knD = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.knD = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.iOG = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                cb cbVar = new cb();
                cbVar.a(threadInfo);
                cbVar.bns();
                this.iOG.add(cbVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.knE = new m();
                this.knE.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.knF = new ak();
                this.knF.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.knG = new bo();
                this.knG.bo(recommendForumList.forum_list);
                this.knG.className = recommendForumList.class_name;
                this.knG.floorPosition = recommendForumList.floor_position.intValue();
                this.knG.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.knG.ePm = R.color.CAM_X0108;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.knH = new bt();
                this.knH.bp(recommendUserList.user_list);
                this.knH.floorPosition = recommendUserList.floor_position.intValue();
                this.knH.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.knH.ePm = R.color.CAM_X0108;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.knI = new b();
                this.knI.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.knJ = new SpecialColumnListData();
                this.knJ.a(specialColumnList);
            }
        }
    }

    public int cRU() {
        return this.knD;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<cb> cxb() {
        return this.iOG;
    }

    public bo cRV() {
        return this.knG;
    }

    public bt cRW() {
        return this.knH;
    }

    public m cRX() {
        return this.knE;
    }

    public ak cRY() {
        return this.knF;
    }

    public b cRZ() {
        return this.knI;
    }

    public SpecialColumnListData cSa() {
        return this.knJ;
    }
}
