package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.a.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
/* loaded from: classes21.dex */
public class c extends com.baidu.tbadk.core.data.a {
    private boolean jxP = false;
    private List<q> jxQ;

    public List<q> cIB() {
        return this.jxQ;
    }

    public void dB(List<q> list) {
        this.jxQ = list;
    }

    public static boolean a(DiscoverHotForum discoverHotForum, int i) {
        return TbadkApplication.isLogin() && com.baidu.tbadk.a.d.bhs() && discoverHotForum != null && discoverHotForum.floor != null && (i < 0 || i == discoverHotForum.floor.intValue() + (-1)) && !y.isEmpty(discoverHotForum.tab_list);
    }

    @Override // com.baidu.tbadk.core.data.a
    public bx bjd() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public as bjf() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return k.icp;
    }

    public boolean cIC() {
        return this.jxP;
    }

    public boolean dC(List<DiscoverTabCard> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        List<q> arrayList = new ArrayList<>();
        dB(arrayList);
        for (int i = 0; i < list.size(); i++) {
            DiscoverTabCard discoverTabCard = list.get(i);
            if (discoverTabCard.forum_list != null && discoverTabCard.forum_list.size() >= 3) {
                d dVar = new d();
                this.jxP = StringUtils.isNull(discoverTabCard.name) || this.jxP;
                dVar.jxR = discoverTabCard.name;
                dVar.jxS = discoverTabCard.is_show_order_number == null ? false : discoverTabCard.is_show_order_number.booleanValue();
                dVar.aGz = discoverTabCard.jump_name;
                for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                    dVar.jxT[i2] = new d.a();
                    dVar.jxT[i2].Lg(discoverTabCard.forum_list.get(i2).forum_name).Lf(discoverTabCard.forum_list.get(i2).avatar).Li(discoverTabCard.forum_list.get(i2).hot_text).Lh(discoverTabCard.forum_list.get(i2).slogan).BK(discoverTabCard.forum_list.get(i2).member_count.intValue()).BL(discoverTabCard.forum_list.get(i2).thread_count.intValue()).qS(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1).g(discoverTabCard.forum_list.get(i2).forum_id).fT(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
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
