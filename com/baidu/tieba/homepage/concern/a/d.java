package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.homepage.concern.a.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
/* loaded from: classes21.dex */
public class d extends AbsThreadDataSupport {
    private boolean iPJ = false;
    private List<q> iPK;

    public List<q> czK() {
        return this.iPK;
    }

    public void dh(List<q> list) {
        this.iPK = list;
    }

    public static boolean a(DiscoverHotForum discoverHotForum, int i) {
        return TbadkApplication.isLogin() && com.baidu.tbadk.a.d.baZ() && discoverHotForum != null && discoverHotForum.floor != null && (i < 0 || i == discoverHotForum.floor.intValue() + (-1)) && !y.isEmpty(discoverHotForum.tab_list);
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bda() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return l.huj;
    }

    public boolean czL() {
        return this.iPJ;
    }

    public boolean di(List<DiscoverTabCard> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        List<q> arrayList = new ArrayList<>();
        dh(arrayList);
        for (int i = 0; i < list.size(); i++) {
            DiscoverTabCard discoverTabCard = list.get(i);
            if (discoverTabCard.forum_list != null && discoverTabCard.forum_list.size() >= 3) {
                e eVar = new e();
                this.iPJ = StringUtils.isNull(discoverTabCard.name) || this.iPJ;
                eVar.iPL = discoverTabCard.name;
                eVar.iPM = discoverTabCard.is_show_order_number == null ? false : discoverTabCard.is_show_order_number.booleanValue();
                eVar.aEb = discoverTabCard.jump_name;
                for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                    eVar.iPN[i2] = new e.a();
                    eVar.iPN[i2].Kb(discoverTabCard.forum_list.get(i2).forum_name).Ka(discoverTabCard.forum_list.get(i2).avatar).Kd(discoverTabCard.forum_list.get(i2).hot_text).Kc(discoverTabCard.forum_list.get(i2).slogan).Aa(discoverTabCard.forum_list.get(i2).member_count.intValue()).Ab(discoverTabCard.forum_list.get(i2).thread_count.intValue()).pI(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1).e(discoverTabCard.forum_list.get(i2).forum_id).fb(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
                }
                arrayList.add(eVar);
                if (arrayList.size() >= 6) {
                    break;
                }
            }
        }
        return arrayList.size() > 0;
    }
}
