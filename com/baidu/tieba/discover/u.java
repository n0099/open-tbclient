package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class u {
    private static HashMap<String, Integer> aDY;
    private r aDZ;
    private y aEa;
    private com.baidu.tieba.discover.data.b aEb = new com.baidu.tieba.discover.data.b();
    private x aEc;

    public u(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aDZ = new r(tbPageContext);
        this.aEa = new y(tbPageContext, this.aEb);
        this.aDZ.a(new v(this));
        this.aEa.a((com.baidu.tbadk.mvc.model.q) new w(this));
    }

    public void Hi() {
        this.aDZ.BE();
    }

    public void Gd() {
        this.aEa.BM();
    }

    public void a(x xVar) {
        this.aEc = xVar;
    }

    private static void Hj() {
        aDY = new HashMap<>();
        aDY.put("discover_friend", Integer.valueOf(com.baidu.tieba.p.icon_find_trends));
        aDY.put("discover_nearby", Integer.valueOf(com.baidu.tieba.p.icon_find_nearby));
        aDY.put("discover_square", Integer.valueOf(com.baidu.tieba.p.icon_find_square));
        aDY.put("discover_hot_video", Integer.valueOf(com.baidu.tieba.p.icon_live_telecast));
        aDY.put("discover_one_sign", Integer.valueOf(com.baidu.tieba.p.icon_all_sign_dis));
        aDY.put("discover_look_shop", Integer.valueOf(com.baidu.tieba.p.icon_more_store));
        aDY.put("discover_rand_friend", Integer.valueOf(com.baidu.tieba.p.icon_find_chat));
        aDY.put("discover_beauty_show", Integer.valueOf(com.baidu.tieba.p.icon_find_shawty));
        aDY.put("discover_game_center", Integer.valueOf(com.baidu.tieba.p.icon_frs_game));
        aDY.put("discover_square_trend", Integer.valueOf(com.baidu.tieba.p.icon_find_myba));
    }

    public static int fM(String str) {
        if (aDY == null) {
            Hj();
        }
        Integer num = aDY.get(str);
        return num == null ? com.baidu.tieba.p.img_default_100 : num.intValue();
    }

    public com.baidu.tieba.discover.data.a Hk() {
        com.baidu.tieba.discover.data.a aVar = new com.baidu.tieba.discover.data.a();
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_friend", com.baidu.tieba.t.friendsnews));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_nearby", com.baidu.tieba.t.neighbors));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_square", com.baidu.tieba.t.square));
        dVar.H(arrayList2);
        dVar.setType(1);
        arrayList.add(dVar);
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_square_trend", com.baidu.tieba.t.mybardongtai));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_hot_video", com.baidu.tieba.t.livetelecast));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_one_sign", com.baidu.tieba.t.signallforum));
        dVar2.H(arrayList3);
        dVar2.setType(0);
        arrayList.add(dVar2);
        com.baidu.tieba.discover.data.d dVar3 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_look_shop", com.baidu.tieba.t.face_store));
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_rand_friend", com.baidu.tieba.t.laiyifa));
        dVar3.H(arrayList4);
        dVar3.setType(0);
        arrayList.add(dVar3);
        aVar.G(arrayList);
        return aVar;
    }

    public String fN(String str) {
        if ("com.baidu.tieba.pluginNeighbors".equals(str)) {
            return "discover_nearby";
        }
        if ("com.baidu.tieba.pluginRandomChat".equals(str)) {
            return "discover_rand_friend";
        }
        return null;
    }
}
