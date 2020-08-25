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
/* loaded from: classes16.dex */
public class a {
    private ArrayList<bw> hBj;
    private boolean hasMore = true;
    private int iSr = 1;
    private k iSs;
    private ai iSt;
    private bj iSu;
    private bo iSv;
    private b iSw;
    private SpecialColumnListData iSx;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.iSr = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.hBj = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.beg();
                this.hBj.add(bwVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.iSs = new k();
                this.iSs.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.iSt = new ai();
                this.iSt.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.iSu = new bj();
                this.iSu.aL(recommendForumList.forum_list);
                this.iSu.className = recommendForumList.class_name;
                this.iSu.floorPosition = recommendForumList.floor_position.intValue();
                this.iSu.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.iSu.dZU = R.color.cp_cont_c;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.iSv = new bo();
                this.iSv.aM(recommendUserList.user_list);
                this.iSv.floorPosition = recommendUserList.floor_position.intValue();
                this.iSv.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.iSv.dZU = R.color.cp_cont_c;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.iSw = new b();
                this.iSw.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.iSx = new SpecialColumnListData();
                this.iSx.a(specialColumnList);
            }
        }
    }

    public int cyL() {
        return this.iSr;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<bw> cgA() {
        return this.hBj;
    }

    public bj cyM() {
        return this.iSu;
    }

    public bo cyN() {
        return this.iSv;
    }

    public k cyO() {
        return this.iSs;
    }

    public ai cyP() {
        return this.iSt;
    }

    public b cyQ() {
        return this.iSw;
    }

    public SpecialColumnListData cyR() {
        return this.iSx;
    }
}
