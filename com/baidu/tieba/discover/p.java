package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    private static HashMap<String, Integer> aBW;
    private m aBX;
    private t aBY;
    private com.baidu.tieba.discover.data.b aBZ = new com.baidu.tieba.discover.data.b();
    private s aCa;

    public p(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aBX = new m(tbPageContext);
        this.aBY = new t(tbPageContext, this.aBZ);
        this.aBX.a(new q(this));
        this.aBY.a((com.baidu.tbadk.mvc.model.q) new r(this));
    }

    public void Ge() {
        this.aBX.AR();
    }

    public void Fj() {
        this.aBY.AZ();
    }

    public void a(s sVar) {
        this.aCa = sVar;
    }

    private static void Gf() {
        aBW = new HashMap<>();
        aBW.put("discover_friend", Integer.valueOf(com.baidu.tieba.u.icon_find_trends));
        aBW.put("discover_nearby", Integer.valueOf(com.baidu.tieba.u.icon_find_nearby));
        aBW.put("discover_square", Integer.valueOf(com.baidu.tieba.u.icon_find_square));
        aBW.put("discover_hot_video", Integer.valueOf(com.baidu.tieba.u.icon_live_telecast));
        aBW.put("discover_one_sign", Integer.valueOf(com.baidu.tieba.u.icon_all_sign_dis));
        aBW.put("discover_look_shop", Integer.valueOf(com.baidu.tieba.u.icon_more_store));
        aBW.put("discover_rand_friend", Integer.valueOf(com.baidu.tieba.u.icon_find_chat));
        aBW.put("discover_beauty_show", Integer.valueOf(com.baidu.tieba.u.icon_find_shawty));
        aBW.put("discover_game_center", Integer.valueOf(com.baidu.tieba.u.icon_frs_game));
        aBW.put("discover_square_trend", Integer.valueOf(com.baidu.tieba.u.icon_find_myba));
    }

    public static int fp(String str) {
        if (aBW == null) {
            Gf();
        }
        Integer num = aBW.get(str);
        return num == null ? com.baidu.tieba.u.img_default_100 : num.intValue();
    }

    public com.baidu.tieba.discover.data.a Gg() {
        com.baidu.tieba.discover.data.a aVar = new com.baidu.tieba.discover.data.a();
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_friend", y.friendsnews));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_nearby", y.neighbors));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_square", y.square));
        dVar.E(arrayList2);
        dVar.setType(1);
        arrayList.add(dVar);
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_square_trend", y.mybardongtai));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_hot_video", y.livetelecast));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_one_sign", y.signallforum));
        dVar2.E(arrayList3);
        dVar2.setType(0);
        arrayList.add(dVar2);
        com.baidu.tieba.discover.data.d dVar3 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_look_shop", y.face_store));
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_rand_friend", y.laiyifa));
        dVar3.E(arrayList4);
        dVar3.setType(0);
        arrayList.add(dVar3);
        aVar.D(arrayList);
        return aVar;
    }
}
