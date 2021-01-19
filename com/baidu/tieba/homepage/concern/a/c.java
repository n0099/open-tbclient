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
    private boolean jUc = false;
    private List<n> jUd;

    public List<n> cNg() {
        return this.jUd;
    }

    public void dU(List<n> list) {
        this.jUd = list;
    }

    public static boolean a(DiscoverHotForum discoverHotForum, int i) {
        return TbadkApplication.isLogin() && com.baidu.tbadk.a.d.biR() && discoverHotForum != null && discoverHotForum.floor != null && (i < 0 || i == discoverHotForum.floor.intValue() + (-1)) && !x.isEmpty(discoverHotForum.tab_list);
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz bkV() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bkX() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return k.ivc;
    }

    public boolean cNh() {
        return this.jUc;
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
                this.jUc = StringUtils.isNull(discoverTabCard.name) || this.jUc;
                dVar.jUe = discoverTabCard.name;
                dVar.jUf = discoverTabCard.is_show_order_number == null ? false : discoverTabCard.is_show_order_number.booleanValue();
                dVar.aEU = discoverTabCard.jump_name;
                for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                    dVar.jUg[i2] = new d.a();
                    dVar.jUg[i2].Lf(discoverTabCard.forum_list.get(i2).forum_name).Le(discoverTabCard.forum_list.get(i2).avatar).Lh(discoverTabCard.forum_list.get(i2).hot_text).Lg(discoverTabCard.forum_list.get(i2).slogan).Bg(discoverTabCard.forum_list.get(i2).member_count.intValue()).Bh(discoverTabCard.forum_list.get(i2).thread_count.intValue()).rM(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1).g(discoverTabCard.forum_list.get(i2).forum_id).gy(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
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
