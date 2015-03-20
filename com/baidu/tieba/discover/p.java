package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    private static HashMap<String, Integer> aBO;
    private m aBP;
    private t aBQ;
    private com.baidu.tieba.discover.data.b aBR = new com.baidu.tieba.discover.data.b();
    private s aBS;

    public p(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aBP = new m(tbPageContext);
        this.aBQ = new t(tbPageContext, this.aBR);
        this.aBP.a(new q(this));
        this.aBQ.a((com.baidu.tbadk.mvc.model.q) new r(this));
    }

    public void FY() {
        this.aBP.AL();
    }

    public void Fd() {
        this.aBQ.AT();
    }

    public void a(s sVar) {
        this.aBS = sVar;
    }

    private static void FZ() {
        aBO = new HashMap<>();
        aBO.put("discover_friend", Integer.valueOf(com.baidu.tieba.u.icon_find_trends));
        aBO.put("discover_nearby", Integer.valueOf(com.baidu.tieba.u.icon_find_nearby));
        aBO.put("discover_square", Integer.valueOf(com.baidu.tieba.u.icon_find_square));
        aBO.put("discover_hot_video", Integer.valueOf(com.baidu.tieba.u.icon_live_telecast));
        aBO.put("discover_one_sign", Integer.valueOf(com.baidu.tieba.u.icon_all_sign_dis));
        aBO.put("discover_look_shop", Integer.valueOf(com.baidu.tieba.u.icon_more_store));
        aBO.put("discover_rand_friend", Integer.valueOf(com.baidu.tieba.u.icon_find_chat));
        aBO.put("discover_beauty_show", Integer.valueOf(com.baidu.tieba.u.icon_find_shawty));
        aBO.put("discover_game_center", Integer.valueOf(com.baidu.tieba.u.icon_frs_game));
        aBO.put("discover_square_trend", Integer.valueOf(com.baidu.tieba.u.icon_find_myba));
    }

    public static int fm(String str) {
        if (aBO == null) {
            FZ();
        }
        Integer num = aBO.get(str);
        return num == null ? com.baidu.tieba.u.img_default_100 : num.intValue();
    }

    public com.baidu.tieba.discover.data.a Ga() {
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
