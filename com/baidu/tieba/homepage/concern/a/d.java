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
    private boolean jeD = false;
    private List<q> jeE;

    public List<q> cDo() {
        return this.jeE;
    }

    public void dk(List<q> list) {
        this.jeE = list;
    }

    public static boolean a(DiscoverHotForum discoverHotForum, int i) {
        return TbadkApplication.isLogin() && com.baidu.tbadk.a.d.bdH() && discoverHotForum != null && discoverHotForum.floor != null && (i < 0 || i == discoverHotForum.floor.intValue() + (-1)) && !y.isEmpty(discoverHotForum.tab_list);
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bfI() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return l.hJe;
    }

    public boolean cDp() {
        return this.jeD;
    }

    public boolean dl(List<DiscoverTabCard> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        List<q> arrayList = new ArrayList<>();
        dk(arrayList);
        for (int i = 0; i < list.size(); i++) {
            DiscoverTabCard discoverTabCard = list.get(i);
            if (discoverTabCard.forum_list != null && discoverTabCard.forum_list.size() >= 3) {
                e eVar = new e();
                this.jeD = StringUtils.isNull(discoverTabCard.name) || this.jeD;
                eVar.jeF = discoverTabCard.name;
                eVar.jeG = discoverTabCard.is_show_order_number == null ? false : discoverTabCard.is_show_order_number.booleanValue();
                eVar.aHf = discoverTabCard.jump_name;
                for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                    eVar.jeH[i2] = new e.a();
                    eVar.jeH[i2].KQ(discoverTabCard.forum_list.get(i2).forum_name).KP(discoverTabCard.forum_list.get(i2).avatar).KS(discoverTabCard.forum_list.get(i2).hot_text).KR(discoverTabCard.forum_list.get(i2).slogan).AG(discoverTabCard.forum_list.get(i2).member_count.intValue()).AH(discoverTabCard.forum_list.get(i2).thread_count.intValue()).qo(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1).e(discoverTabCard.forum_list.get(i2).forum_id).ft(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
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
