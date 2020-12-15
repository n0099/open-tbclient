package com.baidu.tieba.homepage.tabfeed.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class a {
    private ArrayList<by> iBt;
    private l jWQ;
    private aj jWR;
    private bl jWS;
    private bq jWT;
    private b jWU;
    private SpecialColumnListData jWV;
    private boolean hasMore = true;
    private int jWP = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.jWP = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.iBt = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                by byVar = new by();
                byVar.a(threadInfo);
                byVar.bor();
                this.iBt.add(byVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.jWQ = new l();
                this.jWQ.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.jWR = new aj();
                this.jWR.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.jWS = new bl();
                this.jWS.bm(recommendForumList.forum_list);
                this.jWS.className = recommendForumList.class_name;
                this.jWS.floorPosition = recommendForumList.floor_position.intValue();
                this.jWS.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.jWS.eHT = R.color.CAM_X0108;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.jWT = new bq();
                this.jWT.bn(recommendUserList.user_list);
                this.jWT.floorPosition = recommendUserList.floor_position.intValue();
                this.jWT.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.jWT.eHT = R.color.CAM_X0108;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.jWU = new b();
                this.jWU.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.jWV = new SpecialColumnListData();
                this.jWV.a(specialColumnList);
            }
        }
    }

    public int cQG() {
        return this.jWP;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<by> cwN() {
        return this.iBt;
    }

    public bl cQH() {
        return this.jWS;
    }

    public bq cQI() {
        return this.jWT;
    }

    public l cQJ() {
        return this.jWQ;
    }

    public aj cQK() {
        return this.jWR;
    }

    public b cQL() {
        return this.jWU;
    }

    public SpecialColumnListData cQM() {
        return this.jWV;
    }
}
