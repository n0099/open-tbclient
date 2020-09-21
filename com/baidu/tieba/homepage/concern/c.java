package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes21.dex */
public class c {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, int i) {
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.bcY() != null && !StringUtils.isNull(absThreadDataSupport.bcY().getTid())) {
            aq aqVar = new aq("c12352");
            bw bcY = absThreadDataSupport.bcY();
            if (bcY.isLinkThread()) {
                aqVar.ai("obj_type", 4);
            } else if (bcY.isShareThread) {
                aqVar.ai("obj_type", 5);
            } else if (bcY.beg()) {
                aqVar.ai("obj_type", 6);
            } else if (bcY.bht()) {
                aqVar.ai("obj_type", 7);
            } else if (bcY.beh()) {
                aqVar.ai("obj_type", 8);
            } else if (bcY.bhu()) {
                aqVar.ai("obj_type", 9);
            } else if (bcY.getType() == bw.edg) {
                aqVar.ai("obj_type", 1);
            } else if (bcY.bee()) {
                aqVar.ai("obj_type", 2);
            }
            aqVar.ai("obj_locate", i);
            aqVar.dF("tid", absThreadDataSupport.bcY().getTid());
            aqVar.u("fid", absThreadDataSupport.bcY().getFid());
            aqVar.ai("obj_source", 1);
            if (absThreadDataSupport instanceof com.baidu.tieba.card.data.c) {
                aqVar.ai("obj_param1", ((com.baidu.tieba.card.data.c) absThreadDataSupport).cfE() ? 2 : 1);
            }
            if (absThreadDataSupport.bcY().bfy() != null) {
                aqVar.dF("uid", absThreadDataSupport.bcY().bfy().getUserId());
            }
            if (bcY.getBaijiahaoData() != null) {
                aqVar.dF("obj_id", bcY.getBaijiahaoData().oriUgcNid);
            } else {
                aqVar.dF("obj_id", bcY.getTid());
            }
            TiebaStatic.log(aqVar);
            d(bcY, i);
        }
    }

    public static boolean a(DiscoverHotForum.Builder builder, long j, boolean z) {
        if (j == 0 || builder == null) {
            return false;
        }
        List<DiscoverTabCard> list = builder.tab_list;
        if (y.isEmpty(list)) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            DiscoverTabCard.Builder builder2 = new DiscoverTabCard.Builder(list.get(i));
            List<RecommendForumInfo> list2 = builder2.forum_list;
            if (!y.isEmpty(list2)) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    RecommendForumInfo.Builder builder3 = new RecommendForumInfo.Builder(list2.get(i2));
                    int i3 = z ? 1 : 0;
                    if (builder3.forum_id.longValue() == j && builder3.is_like.intValue() != i3) {
                        builder3.is_like = Integer.valueOf(i3);
                        list2.set(i2, builder3.build(true));
                        list.set(i, builder2.build(true));
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    private static void d(bw bwVar, int i) {
        aq aqVar = null;
        switch (i) {
            case 1:
                aqVar = com.baidu.tieba.s.a.a("c13692", bwVar, 3);
                break;
        }
        TiebaStatic.log(aqVar);
    }
}
