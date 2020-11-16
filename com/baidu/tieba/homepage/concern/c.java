package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes21.dex */
public class c {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.bjd() != null && !StringUtils.isNull(aVar.bjd().getTid())) {
            ar arVar = new ar("c12352");
            bx bjd = aVar.bjd();
            if (bjd.isLinkThread()) {
                arVar.ak("obj_type", 4);
            } else if (bjd.isShareThread) {
                arVar.ak("obj_type", 5);
            } else if (bjd.bkk()) {
                arVar.ak("obj_type", 6);
            } else if (bjd.bnz()) {
                arVar.ak("obj_type", 7);
            } else if (bjd.bkl()) {
                arVar.ak("obj_type", 8);
            } else if (bjd.bnA()) {
                arVar.ak("obj_type", 9);
            } else if (bjd.getType() == bx.eBR) {
                arVar.ak("obj_type", 1);
            } else if (bjd.bki()) {
                arVar.ak("obj_type", 2);
            }
            arVar.ak("obj_locate", i);
            arVar.dR("tid", aVar.bjd().getTid());
            arVar.w("fid", aVar.bjd().getFid());
            arVar.ak("obj_source", 1);
            if (aVar instanceof com.baidu.tieba.card.data.b) {
                arVar.ak("obj_param1", ((com.baidu.tieba.card.data.b) aVar).cok() ? 2 : 1);
            }
            if (aVar.bjd().blC() != null) {
                arVar.dR("uid", aVar.bjd().blC().getUserId());
            }
            if (bjd.getBaijiahaoData() != null) {
                arVar.dR("obj_id", bjd.getBaijiahaoData().oriUgcNid);
            } else {
                arVar.dR("obj_id", bjd.getTid());
            }
            TiebaStatic.log(arVar);
            d(bjd, i);
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

    private static void d(bx bxVar, int i) {
        ar arVar = null;
        switch (i) {
            case 1:
                arVar = com.baidu.tieba.t.a.a("c13692", bxVar, 3);
                break;
        }
        TiebaStatic.log(arVar);
    }
}
