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
    private ArrayList<bw> ijM;
    private k jCD;
    private ai jCE;
    private bj jCF;
    private bo jCG;
    private b jCH;
    private SpecialColumnListData jCI;
    private boolean hasMore = true;
    private int jCC = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.jCC = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.ijM = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.bjC();
                this.ijM.add(bwVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.jCD = new k();
                this.jCD.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.jCE = new ai();
                this.jCE.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.jCF = new bj();
                this.jCF.bc(recommendForumList.forum_list);
                this.jCF.className = recommendForumList.class_name;
                this.jCF.floorPosition = recommendForumList.floor_position.intValue();
                this.jCF.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.jCF.ewK = R.color.cp_cont_c;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.jCG = new bo();
                this.jCG.bd(recommendUserList.user_list);
                this.jCG.floorPosition = recommendUserList.floor_position.intValue();
                this.jCG.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.jCG.ewK = R.color.cp_cont_c;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.jCH = new b();
                this.jCH.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.jCI = new SpecialColumnListData();
                this.jCI.a(specialColumnList);
            }
        }
    }

    public int cJj() {
        return this.jCC;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<bw> cqt() {
        return this.ijM;
    }

    public bj cJk() {
        return this.jCF;
    }

    public bo cJl() {
        return this.jCG;
    }

    public k cJm() {
        return this.jCD;
    }

    public ai cJn() {
        return this.jCE;
    }

    public b cJo() {
        return this.jCH;
    }

    public SpecialColumnListData cJp() {
        return this.jCI;
    }
}
