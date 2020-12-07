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
    private ArrayList<by> iBr;
    private l jWO;
    private aj jWP;
    private bl jWQ;
    private bq jWR;
    private b jWS;
    private SpecialColumnListData jWT;
    private boolean hasMore = true;
    private int jWN = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.jWN = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.iBr = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                by byVar = new by();
                byVar.a(threadInfo);
                byVar.bor();
                this.iBr.add(byVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!y.isEmpty(list)) {
                this.jWO = new l();
                this.jWO.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (y.getCount(list2) >= 4) {
                this.jWP = new aj();
                this.jWP.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && y.getCount(recommendForumList.forum_list) >= 5) {
                this.jWQ = new bl();
                this.jWQ.bm(recommendForumList.forum_list);
                this.jWQ.className = recommendForumList.class_name;
                this.jWQ.floorPosition = recommendForumList.floor_position.intValue();
                this.jWQ.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.jWQ.eHT = R.color.CAM_X0108;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && y.getCount(recommendUserList.user_list) >= 4) {
                this.jWR = new bq();
                this.jWR.bn(recommendUserList.user_list);
                this.jWR.floorPosition = recommendUserList.floor_position.intValue();
                this.jWR.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.jWR.eHT = R.color.CAM_X0108;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && y.getCount(hotTopic.topic_list) >= 4) {
                this.jWS = new b();
                this.jWS.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && y.getCount(specialColumnList.item_list) >= 3) {
                this.jWT = new SpecialColumnListData();
                this.jWT.a(specialColumnList);
            }
        }
    }

    public int cQF() {
        return this.jWN;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<by> cwM() {
        return this.iBr;
    }

    public bl cQG() {
        return this.jWQ;
    }

    public bq cQH() {
        return this.jWR;
    }

    public l cQI() {
        return this.jWO;
    }

    public aj cQJ() {
        return this.jWP;
    }

    public b cQK() {
        return this.jWS;
    }

    public SpecialColumnListData cQL() {
        return this.jWT;
    }
}
