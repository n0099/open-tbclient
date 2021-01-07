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
    private ArrayList<bz> iNF;
    private l kkc;
    private aj kkd;
    private bm kke;
    private br kkf;
    private b kkg;
    private SpecialColumnListData kkh;
    private boolean hasMore = true;
    private int kkb = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Page page = dataRes.page_info;
            if (page != null) {
                this.kkb = page.current_page.intValue();
                this.hasMore = page.has_more.intValue() == 1;
            }
            this.iNF = new ArrayList<>(x.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bz bzVar = new bz();
                bzVar.a(threadInfo);
                bzVar.bqT();
                this.iNF.add(bzVar);
            }
            List<BannerImage> list = dataRes.banner_image;
            if (!x.isEmpty(list)) {
                this.kkc = new l();
                this.kkc.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (x.getCount(list2) >= 4) {
                this.kkd = new aj();
                this.kkd.parserProtobuf(list2);
            }
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && x.getCount(recommendForumList.forum_list) >= 5) {
                this.kke = new bm();
                this.kke.bt(recommendForumList.forum_list);
                this.kke.className = recommendForumList.class_name;
                this.kke.floorPosition = recommendForumList.floor_position.intValue();
                this.kke.title = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                this.kke.eRL = R.color.CAM_X0108;
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && x.getCount(recommendUserList.user_list) >= 4) {
                this.kkf = new br();
                this.kkf.bu(recommendUserList.user_list);
                this.kkf.floorPosition = recommendUserList.floor_position.intValue();
                this.kkf.title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                this.kkf.eRL = R.color.CAM_X0108;
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && x.getCount(hotTopic.topic_list) >= 4) {
                this.kkg = new b();
                this.kkg.a(hotTopic);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && x.getCount(specialColumnList.item_list) >= 3) {
                this.kkh = new SpecialColumnListData();
                this.kkh.a(specialColumnList);
            }
        }
    }

    public int cTN() {
        return this.kkb;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ArrayList<bz> czH() {
        return this.iNF;
    }

    public bm cTO() {
        return this.kke;
    }

    public br cTP() {
        return this.kkf;
    }

    public l cTQ() {
        return this.kkc;
    }

    public aj cTR() {
        return this.kkd;
    }

    public b cTS() {
        return this.kkg;
    }

    public SpecialColumnListData cTT() {
        return this.kkh;
    }
}
