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
/* loaded from: classes22.dex */
public class d extends AbsThreadDataSupport {
    private boolean jrb = false;
    private List<q> jrc;

    public List<q> cGv() {
        return this.jrc;
    }

    public void dt(List<q> list) {
        this.jrc = list;
    }

    public static boolean a(DiscoverHotForum discoverHotForum, int i) {
        return TbadkApplication.isLogin() && com.baidu.tbadk.a.d.bfA() && discoverHotForum != null && discoverHotForum.floor != null && (i < 0 || i == discoverHotForum.floor.intValue() + (-1)) && !y.isEmpty(discoverHotForum.tab_list);
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bhB() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return l.hVB;
    }

    public boolean cGw() {
        return this.jrb;
    }

    public boolean du(List<DiscoverTabCard> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        List<q> arrayList = new ArrayList<>();
        dt(arrayList);
        for (int i = 0; i < list.size(); i++) {
            DiscoverTabCard discoverTabCard = list.get(i);
            if (discoverTabCard.forum_list != null && discoverTabCard.forum_list.size() >= 3) {
                e eVar = new e();
                this.jrb = StringUtils.isNull(discoverTabCard.name) || this.jrb;
                eVar.jrd = discoverTabCard.name;
                eVar.jre = discoverTabCard.is_show_order_number == null ? false : discoverTabCard.is_show_order_number.booleanValue();
                eVar.aHs = discoverTabCard.jump_name;
                for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                    eVar.jrf[i2] = new e.a();
                    eVar.jrf[i2].Lo(discoverTabCard.forum_list.get(i2).forum_name).Ln(discoverTabCard.forum_list.get(i2).avatar).Lq(discoverTabCard.forum_list.get(i2).hot_text).Lp(discoverTabCard.forum_list.get(i2).slogan).AZ(discoverTabCard.forum_list.get(i2).member_count.intValue()).Ba(discoverTabCard.forum_list.get(i2).thread_count.intValue()).qG(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1).f(discoverTabCard.forum_list.get(i2).forum_id).fu(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
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
