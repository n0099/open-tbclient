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
    private ArrayList<bw> hBp;
    private bj iSA;
    private bo iSB;
    private b iSC;
    private SpecialColumnListData iSD;
    private k iSy;
    private ai iSz;
    private boolean hasMore = true;
    private int iSx = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.iSx = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.hBp = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.beg();
                this.hBp.add(bwVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.iSy = new k();
                this.iSy.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.iSz = new ai();
                this.iSz.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.iSA = new bj();
                this.iSA.aL(recommendForumList.forum_list);
                this.iSA.className = recommendForumList.class_name;
                this.iSA.floorPosition = recommendForumList.floor_position.intValue();
                this.iSA.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.iSA.dZY = R.color.cp_cont_c;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.iSB = new bo();
                this.iSB.aM(recommendUserList.user_list);
                this.iSB.floorPosition = recommendUserList.floor_position.intValue();
                this.iSB.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.iSB.dZY = R.color.cp_cont_c;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.iSC = new b();
                this.iSC.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.iSD = new SpecialColumnListData();
                this.iSD.a(specialColumnList);
            }
        }
    }

    public int cyM() {
        return this.iSx;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<bw> cgB() {
        return this.hBp;
    }

    public bj cyN() {
        return this.iSA;
    }

    public bo cyO() {
        return this.iSB;
    }

    public k cyP() {
        return this.iSy;
    }

    public ai cyQ() {
        return this.iSz;
    }

    public b cyR() {
        return this.iSC;
    }

    public SpecialColumnListData cyS() {
        return this.iSD;
    }
}
