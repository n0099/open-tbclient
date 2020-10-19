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
/* loaded from: classes22.dex */
public class a {
    private ArrayList<bw> hXm;
    private boolean hasMore = true;
    private int jqc = 1;
    private k jqd;
    private ai jqe;
    private bj jqf;
    private bo jqg;
    private b jqh;
    private SpecialColumnListData jqi;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.jqc = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.hXm = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.bhJ();
                this.hXm.add(bwVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.jqd = new k();
                this.jqd.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.jqe = new ai();
                this.jqe.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.jqf = new bj();
                this.jqf.aS(recommendForumList.forum_list);
                this.jqf.className = recommendForumList.class_name;
                this.jqf.floorPosition = recommendForumList.floor_position.intValue();
                this.jqf.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.jqf.eon = R.color.cp_cont_c;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.jqg = new bo();
                this.jqg.aT(recommendUserList.user_list);
                this.jqg.floorPosition = recommendUserList.floor_position.intValue();
                this.jqg.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.jqg.eon = R.color.cp_cont_c;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.jqh = new b();
                this.jqh.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.jqi = new SpecialColumnListData();
                this.jqi.a(specialColumnList);
            }
        }
    }

    public int cGc() {
        return this.jqc;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<bw> cnm() {
        return this.hXm;
    }

    public bj cGd() {
        return this.jqf;
    }

    public bo cGe() {
        return this.jqg;
    }

    public k cGf() {
        return this.jqd;
    }

    public ai cGg() {
        return this.jqe;
    }

    public b cGh() {
        return this.jqh;
    }

    public SpecialColumnListData cGi() {
        return this.jqi;
    }
}
