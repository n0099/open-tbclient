package com.baidu.tieba.homepage.tabfeed.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class a {
    private ArrayList<bv> hos;
    private k iDu;
    private ah iDv;
    private bi iDw;
    private bn iDx;
    private b iDy;
    private SpecialColumnListData iDz;
    private boolean hasMore = true;
    private int iDt = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.iDt = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.hos = new ArrayList<>(x.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bv bvVar = new bv();
                bvVar.a(threadInfo);
                bvVar.aVN();
                this.hos.add(bvVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!x.isEmpty(list)) {
                this.iDu = new k();
                this.iDu.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (x.getCount(list2) >= 4) {
                this.iDv = new ah();
                this.iDv.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && x.getCount(recommendForumList.forum_list) >= 5) {
                this.iDw = new bi();
                this.iDw.aL(recommendForumList.forum_list);
                this.iDw.className = recommendForumList.class_name;
                this.iDw.floorPosition = recommendForumList.floor_position.intValue();
                this.iDw.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.iDw.dQB = R.color.cp_cont_c;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && x.getCount(recommendUserList.user_list) >= 4) {
                this.iDx = new bn();
                this.iDx.aM(recommendUserList.user_list);
                this.iDx.floorPosition = recommendUserList.floor_position.intValue();
                this.iDx.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.iDx.dQB = R.color.cp_cont_c;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && x.getCount(hotTopic.topic_list) >= 4) {
                this.iDy = new b();
                this.iDy.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && x.getCount(specialColumnList.item_list) >= 3) {
                this.iDz = new SpecialColumnListData();
                this.iDz.a(specialColumnList);
            }
        }
    }

    public int cnS() {
        return this.iDt;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<bv> bWn() {
        return this.hos;
    }

    public bi cnT() {
        return this.iDw;
    }

    public bn cnU() {
        return this.iDx;
    }

    public k cnV() {
        return this.iDu;
    }

    public ah cnW() {
        return this.iDv;
    }

    public b cnX() {
        return this.iDy;
    }

    public SpecialColumnListData cnY() {
        return this.iDz;
    }
}
