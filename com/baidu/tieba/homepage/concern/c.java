package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class c {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.bkV() != null && !StringUtils.isNull(aVar.bkV().getTid())) {
            aq aqVar = new aq("c12352");
            bz bkV = aVar.bkV();
            if (bkV.isLinkThread()) {
                aqVar.an("obj_type", 4);
            } else if (bkV.isShareThread) {
                aqVar.an("obj_type", 5);
            } else if (bkV.bme()) {
                aqVar.an("obj_type", 6);
            } else if (bkV.bpv()) {
                aqVar.an("obj_type", 7);
            } else if (bkV.bmf()) {
                aqVar.an("obj_type", 8);
            } else if (bkV.bpw()) {
                aqVar.an("obj_type", 9);
            } else if (bkV.getType() == bz.eOa) {
                aqVar.an("obj_type", 1);
            } else if (bkV.bmc()) {
                aqVar.an("obj_type", 2);
            }
            aqVar.an("obj_locate", i);
            aqVar.dW("tid", aVar.bkV().getTid());
            aqVar.w("fid", aVar.bkV().getFid());
            aqVar.an("obj_source", 1);
            if (aVar instanceof com.baidu.tieba.card.data.b) {
                aqVar.an("obj_param1", ((com.baidu.tieba.card.data.b) aVar).crA() ? 2 : 1);
            }
            if (aVar.bkV().bnx() != null) {
                aqVar.dW("uid", aVar.bkV().bnx().getUserId());
            }
            if (bkV.getBaijiahaoData() != null) {
                aqVar.dW("obj_id", bkV.getBaijiahaoData().oriUgcNid);
            } else {
                aqVar.dW("obj_id", bkV.getTid());
            }
            TiebaStatic.log(aqVar);
            d(bkV, i);
        }
    }

    public static boolean a(DiscoverHotForum.Builder builder, long j, boolean z) {
        if (j == 0 || builder == null) {
            return false;
        }
        List<DiscoverTabCard> list = builder.tab_list;
        if (x.isEmpty(list)) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            DiscoverTabCard.Builder builder2 = new DiscoverTabCard.Builder(list.get(i));
            List<RecommendForumInfo> list2 = builder2.forum_list;
            if (!x.isEmpty(list2)) {
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

    private static void d(bz bzVar, int i) {
        aq aqVar = null;
        switch (i) {
            case 1:
                aqVar = com.baidu.tieba.s.a.a("c13692", bzVar, 3);
                break;
        }
        TiebaStatic.log(aqVar);
    }
}
