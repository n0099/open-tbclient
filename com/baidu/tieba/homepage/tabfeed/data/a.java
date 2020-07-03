package com.baidu.tieba.homepage.tabfeed.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes9.dex */
public class a {
    private ArrayList<bu> hiJ;
    private k ixo;
    private ag ixp;
    private bh ixq;
    private bm ixr;
    private b ixs;
    private SpecialColumnListData ixt;
    private boolean hasMore = true;
    private int ixn = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.ixn = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.hiJ = new ArrayList<>(w.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bu buVar = new bu();
                buVar.a(threadInfo);
                buVar.aRR();
                this.hiJ.add(buVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!w.isEmpty(list)) {
                this.ixo = new k();
                this.ixo.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (w.getCount(list2) >= 4) {
                this.ixp = new ag();
                this.ixp.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && w.getCount(recommendForumList.forum_list) >= 5) {
                this.ixq = new bh();
                this.ixq.aE(recommendForumList.forum_list);
                this.ixq.className = recommendForumList.class_name;
                this.ixq.floorPosition = recommendForumList.floor_position.intValue();
                this.ixq.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.ixq.dKp = R.color.cp_cont_c;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && w.getCount(recommendUserList.user_list) >= 4) {
                this.ixr = new bm();
                this.ixr.aF(recommendUserList.user_list);
                this.ixr.floorPosition = recommendUserList.floor_position.intValue();
                this.ixr.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.ixr.dKp = R.color.cp_cont_c;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && w.getCount(hotTopic.topic_list) >= 4) {
                this.ixs = new b();
                this.ixs.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && w.getCount(specialColumnList.item_list) >= 3) {
                this.ixt = new SpecialColumnListData();
                this.ixt.a(specialColumnList);
            }
        }
    }

    public int ckr() {
        return this.ixn;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<bu> bSV() {
        return this.hiJ;
    }

    public bh cks() {
        return this.ixq;
    }

    public bm ckt() {
        return this.ixr;
    }

    public k cku() {
        return this.ixo;
    }

    public ag ckv() {
        return this.ixp;
    }

    public b ckw() {
        return this.ixs;
    }

    public SpecialColumnListData ckx() {
        return this.ixt;
    }
}
