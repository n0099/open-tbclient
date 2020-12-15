package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.a.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
/* loaded from: classes22.dex */
public class c extends com.baidu.tbadk.core.data.a {
    private boolean jLt = false;
    private List<q> jLu;

    public List<q> cNR() {
        return this.jLu;
    }

    public void dM(List<q> list) {
        this.jLu = list;
    }

    public static boolean a(DiscoverHotForum discoverHotForum, int i) {
        return TbadkApplication.isLogin() && com.baidu.tbadk.a.d.bkw() && discoverHotForum != null && discoverHotForum.floor != null && (i < 0 || i == discoverHotForum.floor.intValue() + (-1)) && !y.isEmpty(discoverHotForum.tab_list);
    }

    @Override // com.baidu.tbadk.core.data.a
    public by bmn() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bmp() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return k.ino;
    }

    public boolean cNS() {
        return this.jLt;
    }

    public boolean dN(List<DiscoverTabCard> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        List<q> arrayList = new ArrayList<>();
        dM(arrayList);
        for (int i = 0; i < list.size(); i++) {
            DiscoverTabCard discoverTabCard = list.get(i);
            if (discoverTabCard.forum_list != null && discoverTabCard.forum_list.size() >= 3) {
                d dVar = new d();
                this.jLt = StringUtils.isNull(discoverTabCard.name) || this.jLt;
                dVar.jLv = discoverTabCard.name;
                dVar.jLw = discoverTabCard.is_show_order_number == null ? false : discoverTabCard.is_show_order_number.booleanValue();
                dVar.aJj = discoverTabCard.jump_name;
                for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                    dVar.jLx[i2] = new d.a();
                    dVar.jLx[i2].Mn(discoverTabCard.forum_list.get(i2).forum_name).Mm(discoverTabCard.forum_list.get(i2).avatar).Mp(discoverTabCard.forum_list.get(i2).hot_text).Mo(discoverTabCard.forum_list.get(i2).slogan).Cz(discoverTabCard.forum_list.get(i2).member_count.intValue()).CA(discoverTabCard.forum_list.get(i2).thread_count.intValue()).rt(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1).g(discoverTabCard.forum_list.get(i2).forum_id).gy(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
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
