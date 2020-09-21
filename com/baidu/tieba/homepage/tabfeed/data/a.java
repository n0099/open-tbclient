package com.baidu.tieba.homepage.tabfeed.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.k;
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
    private ArrayList<bw> hIr;
    private boolean hasMore = true;
    private int jbd = 1;
    private k jbe;
    private ai jbf;
    private bj jbg;
    private bo jbh;
    private b jbi;
    private SpecialColumnListData jbj;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.jbd = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.hIr = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.bfa();
                this.hIr.add(bwVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.jbe = new k();
                this.jbe.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.jbf = new ai();
                this.jbf.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.jbg = new bj();
                this.jbg.aP(recommendForumList.forum_list);
                this.jbg.className = recommendForumList.class_name;
                this.jbg.floorPosition = recommendForumList.floor_position.intValue();
                this.jbg.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.jbg.eci = R.color.cp_cont_c;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.jbh = new bo();
                this.jbh.aQ(recommendUserList.user_list);
                this.jbh.floorPosition = recommendUserList.floor_position.intValue();
                this.jbh.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.jbh.eci = R.color.cp_cont_c;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.jbi = new b();
                this.jbi.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.jbj = new SpecialColumnListData();
                this.jbj.a(specialColumnList);
            }
        }
    }

    public int cCt() {
        return this.jbd;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<bw> cjQ() {
        return this.hIr;
    }

    public bj cCu() {
        return this.jbg;
    }

    public bo cCv() {
        return this.jbh;
    }

    public k cCw() {
        return this.jbe;
    }

    public ai cCx() {
        return this.jbf;
    }

    public b cCy() {
        return this.jbi;
    }

    public SpecialColumnListData cCz() {
        return this.jbj;
    }
}
