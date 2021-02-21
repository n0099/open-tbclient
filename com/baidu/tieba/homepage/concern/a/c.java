package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.a.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.core.data.a {
    private boolean kbR = false;
    private List<n> kbS;

    public List<n> cPj() {
        return this.kbS;
    }

    public void dR(List<n> list) {
        this.kbS = list;
    }

    public static boolean a(DiscoverHotForum discoverHotForum, int i) {
        return TbadkApplication.isLogin() && com.baidu.tbadk.a.d.bjd() && discoverHotForum != null && discoverHotForum.floor != null && (i < 0 || i == discoverHotForum.floor.intValue() + (-1)) && !y.isEmpty(discoverHotForum.tab_list);
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb bln() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blp() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return k.iBa;
    }

    public boolean cPk() {
        return this.kbR;
    }

    public boolean dS(List<DiscoverTabCard> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        List<n> arrayList = new ArrayList<>();
        dR(arrayList);
        for (int i = 0; i < list.size(); i++) {
            DiscoverTabCard discoverTabCard = list.get(i);
            if (discoverTabCard.forum_list != null && discoverTabCard.forum_list.size() >= 3) {
                d dVar = new d();
                this.kbR = StringUtils.isNull(discoverTabCard.name) || this.kbR;
                dVar.kbT = discoverTabCard.name;
                dVar.kbU = discoverTabCard.is_show_order_number == null ? false : discoverTabCard.is_show_order_number.booleanValue();
                dVar.aHq = discoverTabCard.jump_name;
                for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                    dVar.kbV[i2] = new d.a();
                    dVar.kbV[i2].LR(discoverTabCard.forum_list.get(i2).forum_name).LQ(discoverTabCard.forum_list.get(i2).avatar).LT(discoverTabCard.forum_list.get(i2).hot_text).LS(discoverTabCard.forum_list.get(i2).slogan).Bw(discoverTabCard.forum_list.get(i2).member_count.intValue()).Bx(discoverTabCard.forum_list.get(i2).thread_count.intValue()).rY(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1).g(discoverTabCard.forum_list.get(i2).forum_id).gD(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
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
