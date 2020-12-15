package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes22.dex */
public class c {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.bmn() != null && !StringUtils.isNull(aVar.bmn().getTid())) {
            ar arVar = new ar("c12352");
            by bmn = aVar.bmn();
            if (bmn.isLinkThread()) {
                arVar.al("obj_type", 4);
            } else if (bmn.isShareThread) {
                arVar.al("obj_type", 5);
            } else if (bmn.bnx()) {
                arVar.al("obj_type", 6);
            } else if (bmn.bqM()) {
                arVar.al("obj_type", 7);
            } else if (bmn.bny()) {
                arVar.al("obj_type", 8);
            } else if (bmn.bqN()) {
                arVar.al("obj_type", 9);
            } else if (bmn.getType() == by.eIS) {
                arVar.al("obj_type", 1);
            } else if (bmn.bnv()) {
                arVar.al("obj_type", 2);
            }
            arVar.al("obj_locate", i);
            arVar.dY("tid", aVar.bmn().getTid());
            arVar.w("fid", aVar.bmn().getFid());
            arVar.al("obj_source", 1);
            if (aVar instanceof com.baidu.tieba.card.data.b) {
                arVar.al("obj_param1", ((com.baidu.tieba.card.data.b) aVar).csy() ? 2 : 1);
            }
            if (aVar.bmn().boP() != null) {
                arVar.dY("uid", aVar.bmn().boP().getUserId());
            }
            if (bmn.getBaijiahaoData() != null) {
                arVar.dY("obj_id", bmn.getBaijiahaoData().oriUgcNid);
            } else {
                arVar.dY("obj_id", bmn.getTid());
            }
            TiebaStatic.log(arVar);
            d(bmn, i);
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

    private static void d(by byVar, int i) {
        ar arVar = null;
        switch (i) {
            case 1:
                arVar = com.baidu.tieba.t.a.a("c13692", byVar, 3);
                break;
        }
        TiebaStatic.log(arVar);
    }
}
