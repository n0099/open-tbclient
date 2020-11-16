package com.baidu.tieba.homepage.tabfeed.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.l;
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
/* loaded from: classes21.dex */
public class a {
    private ArrayList<bx> iqz;
    private l jJl;
    private aj jJm;
    private bk jJn;
    private bp jJo;
    private b jJp;
    private SpecialColumnListData jJq;
    private boolean hasMore = true;
    private int jJk = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.jJk = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.iqz = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bx bxVar = new bx();
                bxVar.a(threadInfo);
                bxVar.ble();
                this.iqz.add(bxVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.jJl = new l();
                this.jJl.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.jJm = new aj();
                this.jJm.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.jJn = new bk();
                this.jJn.bj(recommendForumList.forum_list);
                this.jJn.className = recommendForumList.class_name;
                this.jJn.floorPosition = recommendForumList.floor_position.intValue();
                this.jJn.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.jJn.eAT = R.color.CAM_X0108;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.jJo = new bp();
                this.jJo.bk(recommendUserList.user_list);
                this.jJo.floorPosition = recommendUserList.floor_position.intValue();
                this.jJo.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.jJo.eAT = R.color.CAM_X0108;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.jJp = new b();
                this.jJp.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.jJq = new SpecialColumnListData();
                this.jJq.a(specialColumnList);
            }
        }
    }

    public int cLr() {
        return this.jJk;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<bx> csx() {
        return this.iqz;
    }

    public bk cLs() {
        return this.jJn;
    }

    public bp cLt() {
        return this.jJo;
    }

    public l cLu() {
        return this.jJl;
    }

    public aj cLv() {
        return this.jJm;
    }

    public b cLw() {
        return this.jJp;
    }

    public SpecialColumnListData cLx() {
        return this.jJq;
    }
}
