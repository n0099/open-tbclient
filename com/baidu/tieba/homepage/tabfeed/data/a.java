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
    private ArrayList<bw> ipL;
    private k jIA;
    private ai jIB;
    private bj jIC;
    private bo jID;
    private b jIE;
    private SpecialColumnListData jIF;
    private boolean hasMore = true;
    private int jIz = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.jIz = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.ipL = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.bmc();
                this.ipL.add(bwVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.jIA = new k();
                this.jIA.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.jIB = new ai();
                this.jIB.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.jIC = new bj();
                this.jIC.bj(recommendForumList.forum_list);
                this.jIC.className = recommendForumList.class_name;
                this.jIC.floorPosition = recommendForumList.floor_position.intValue();
                this.jIC.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.jIC.eCC = R.color.cp_cont_c;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.jID = new bo();
                this.jID.bk(recommendUserList.user_list);
                this.jID.floorPosition = recommendUserList.floor_position.intValue();
                this.jID.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.jID.eCC = R.color.cp_cont_c;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.jIE = new b();
                this.jIE.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.jIF = new SpecialColumnListData();
                this.jIF.a(specialColumnList);
            }
        }
    }

    public int cLK() {
        return this.jIz;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<bw> csU() {
        return this.ipL;
    }

    public bj cLL() {
        return this.jIC;
    }

    public bo cLM() {
        return this.jID;
    }

    public k cLN() {
        return this.jIA;
    }

    public ai cLO() {
        return this.jIB;
    }

    public b cLP() {
        return this.jIE;
    }

    public SpecialColumnListData cLQ() {
        return this.jIF;
    }
}
