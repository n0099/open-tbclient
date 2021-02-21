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
    private ArrayList<cb> iOU;
    private m knS;
    private ak knT;
    private bo knU;
    private bt knV;
    private b knW;
    private SpecialColumnListData knX;
    private boolean hasMore = true;
    private int knR = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.knR = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.iOU = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                cb cbVar = new cb();
                cbVar.a(threadInfo);
                cbVar.bns();
                this.iOU.add(cbVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.knS = new m();
                this.knS.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.knT = new ak();
                this.knT.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.knU = new bo();
                this.knU.bo(recommendForumList.forum_list);
                this.knU.className = recommendForumList.class_name;
                this.knU.floorPosition = recommendForumList.floor_position.intValue();
                this.knU.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.knU.ePm = R.color.CAM_X0108;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.knV = new bt();
                this.knV.bp(recommendUserList.user_list);
                this.knV.floorPosition = recommendUserList.floor_position.intValue();
                this.knV.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.knV.ePm = R.color.CAM_X0108;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.knW = new b();
                this.knW.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.knX = new SpecialColumnListData();
                this.knX.a(specialColumnList);
            }
        }
    }

    public int cSb() {
        return this.knR;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<cb> cxi() {
        return this.iOU;
    }

    public bo cSc() {
        return this.knU;
    }

    public bt cSd() {
        return this.knV;
    }

    public m cSe() {
        return this.knS;
    }

    public ak cSf() {
        return this.knT;
    }

    public b cSg() {
        return this.knW;
    }

    public SpecialColumnListData cSh() {
        return this.knX;
    }
}
