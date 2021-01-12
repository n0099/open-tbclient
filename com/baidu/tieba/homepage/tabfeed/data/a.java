package com.baidu.tieba.homepage.tabfeed.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.l;
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
/* loaded from: classes2.dex */
public class a {
    private ArrayList<bz> iIY;
    private b kfA;
    private SpecialColumnListData kfB;
    private l kfw;
    private aj kfx;
    private bm kfy;
    private br kfz;
    private boolean hasMore = true;
    private int kfv = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.kfv = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.iIY = new ArrayList<>(x.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bz bzVar = new bz();
                bzVar.a(threadInfo);
                bzVar.bmZ();
                this.iIY.add(bzVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!x.isEmpty(list)) {
                this.kfw = new l();
                this.kfw.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (x.getCount(list2) >= 4) {
                this.kfx = new aj();
                this.kfx.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && x.getCount(recommendForumList.forum_list) >= 5) {
                this.kfy = new bm();
                this.kfy.bt(recommendForumList.forum_list);
                this.kfy.className = recommendForumList.class_name;
                this.kfy.floorPosition = recommendForumList.floor_position.intValue();
                this.kfy.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.kfy.eNa = R.color.CAM_X0108;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && x.getCount(recommendUserList.user_list) >= 4) {
                this.kfz = new br();
                this.kfz.bu(recommendUserList.user_list);
                this.kfz.floorPosition = recommendUserList.floor_position.intValue();
                this.kfz.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.kfz.eNa = R.color.CAM_X0108;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && x.getCount(hotTopic.topic_list) >= 4) {
                this.kfA = new b();
                this.kfA.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && x.getCount(specialColumnList.item_list) >= 3) {
                this.kfB = new SpecialColumnListData();
                this.kfB.a(specialColumnList);
            }
        }
    }

    public int cPV() {
        return this.kfv;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<bz> cvP() {
        return this.iIY;
    }

    public bm cPW() {
        return this.kfy;
    }

    public br cPX() {
        return this.kfz;
    }

    public l cPY() {
        return this.kfw;
    }

    public aj cPZ() {
        return this.kfx;
    }

    public b cQa() {
        return this.kfA;
    }

    public SpecialColumnListData cQb() {
        return this.kfB;
    }
}
