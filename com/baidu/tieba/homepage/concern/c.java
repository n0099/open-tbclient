package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class c {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.blp() != null && !StringUtils.isNull(aVar.blp().getTid())) {
            ar arVar = new ar("c12352");
            cb blp = aVar.blp();
            if (blp.isLinkThread()) {
                arVar.aq("obj_type", 4);
            } else if (blp.isShareThread) {
                arVar.aq("obj_type", 5);
            } else if (blp.bmz()) {
                arVar.aq("obj_type", 6);
            } else if (blp.bpP()) {
                arVar.aq("obj_type", 7);
            } else if (blp.bmA()) {
                arVar.aq("obj_type", 8);
            } else if (blp.bpQ()) {
                arVar.aq("obj_type", 9);
            } else if (blp.getType() == cb.eRN) {
                arVar.aq("obj_type", 1);
            } else if (blp.bmx()) {
                arVar.aq("obj_type", 2);
            }
            arVar.aq("obj_locate", i);
            arVar.dR("tid", aVar.blp().getTid());
            arVar.v("fid", aVar.blp().getFid());
            arVar.aq("obj_source", 1);
            if (aVar instanceof com.baidu.tieba.card.data.b) {
                arVar.aq("obj_param1", ((com.baidu.tieba.card.data.b) aVar).csZ() ? 2 : 1);
            }
            if (aVar.blp().bnS() != null) {
                arVar.dR("uid", aVar.blp().bnS().getUserId());
            }
            if (blp.getBaijiahaoData() != null) {
                arVar.dR("obj_id", blp.getBaijiahaoData().oriUgcNid);
            } else {
                arVar.dR("obj_id", blp.getTid());
            }
            TiebaStatic.log(arVar);
            d(blp, i);
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

    private static void d(cb cbVar, int i) {
        ar arVar = null;
        switch (i) {
            case 1:
                arVar = com.baidu.tieba.s.a.a("c13692", cbVar, 3);
                break;
        }
        TiebaStatic.log(arVar);
    }
}
