package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class u {
    private static HashMap<String, Integer> aDX;
    private r aDY;
    private y aDZ;
    private com.baidu.tieba.discover.data.b aEa = new com.baidu.tieba.discover.data.b();
    private x aEb;

    public u(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aDY = new r(tbPageContext);
        this.aDZ = new y(tbPageContext, this.aEa);
        this.aDY.a(new v(this));
        this.aDZ.a((com.baidu.tbadk.mvc.model.q) new w(this));
    }

    public void Hh() {
        this.aDY.BD();
    }

    public void Gc() {
        this.aDZ.BL();
    }

    public void a(x xVar) {
        this.aEb = xVar;
    }

    private static void Hi() {
        aDX = new HashMap<>();
        aDX.put("discover_friend", Integer.valueOf(com.baidu.tieba.p.icon_find_trends));
        aDX.put("discover_nearby", Integer.valueOf(com.baidu.tieba.p.icon_find_nearby));
        aDX.put("discover_square", Integer.valueOf(com.baidu.tieba.p.icon_find_square));
        aDX.put("discover_hot_video", Integer.valueOf(com.baidu.tieba.p.icon_live_telecast));
        aDX.put("discover_one_sign", Integer.valueOf(com.baidu.tieba.p.icon_all_sign_dis));
        aDX.put("discover_look_shop", Integer.valueOf(com.baidu.tieba.p.icon_more_store));
        aDX.put("discover_rand_friend", Integer.valueOf(com.baidu.tieba.p.icon_find_chat));
        aDX.put("discover_beauty_show", Integer.valueOf(com.baidu.tieba.p.icon_find_shawty));
        aDX.put("discover_game_center", Integer.valueOf(com.baidu.tieba.p.icon_frs_game));
        aDX.put("discover_square_trend", Integer.valueOf(com.baidu.tieba.p.icon_find_myba));
    }

    public static int fM(String str) {
        if (aDX == null) {
            Hi();
        }
        Integer num = aDX.get(str);
        return num == null ? com.baidu.tieba.p.img_default_100 : num.intValue();
    }

    public com.baidu.tieba.discover.data.a Hj() {
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
