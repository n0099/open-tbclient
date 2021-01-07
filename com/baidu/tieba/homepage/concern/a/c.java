package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.a.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.core.data.a {
    private boolean jYH = false;
    private List<n> jYI;

    public List<n> cQY() {
        return this.jYI;
    }

    public void dU(List<n> list) {
        this.jYI = list;
    }

    public static boolean a(DiscoverHotForum discoverHotForum, int i) {
        return TbadkApplication.isLogin() && com.baidu.tbadk.a.d.bmL() && discoverHotForum != null && discoverHotForum.floor != null && (i < 0 || i == discoverHotForum.floor.intValue() + (-1)) && !x.isEmpty(discoverHotForum.tab_list);
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz boP() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at boR() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return k.izJ;
    }

    public boolean cQZ() {
        return this.jYH;
    }

    public boolean dV(List<DiscoverTabCard> list) {
        if (x.isEmpty(list)) {
            return false;
        }
        List<n> arrayList = new ArrayList<>();
        dU(arrayList);
        for (int i = 0; i < list.size(); i++) {
            DiscoverTabCard discoverTabCard = list.get(i);
            if (discoverTabCard.forum_list != null && discoverTabCard.forum_list.size() >= 3) {
                d dVar = new d();
                this.jYH = StringUtils.isNull(discoverTabCard.name) || this.jYH;
                dVar.jYJ = discoverTabCard.name;
                dVar.jYK = discoverTabCard.is_show_order_number == null ? false : discoverTabCard.is_show_order_number.booleanValue();
                dVar.aJH = discoverTabCard.jump_name;
                for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                    dVar.jYL[i2] = new d.a();
                    dVar.jYL[i2].Mm(discoverTabCard.forum_list.get(i2).forum_name).Ml(discoverTabCard.forum_list.get(i2).avatar).Mo(discoverTabCard.forum_list.get(i2).hot_text).Mn(discoverTabCard.forum_list.get(i2).slogan).CN(discoverTabCard.forum_list.get(i2).member_count.intValue()).CO(discoverTabCard.forum_list.get(i2).thread_count.intValue()).rQ(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1).g(discoverTabCard.forum_list.get(i2).forum_id).gy(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
                }
                arrayList.add(dVar);
                if (arrayList.size() >= 6) {
                    break;
                }
            }
        }
        return arrayList.size() > 0;
    }
}
