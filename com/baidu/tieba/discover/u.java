package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class u {
    private static HashMap<String, Integer> aJH;
    private r aJI;
    private x aJJ;
    private com.baidu.tieba.discover.data.b aJK = new com.baidu.tieba.discover.data.b();
    private a aJL;

    /* loaded from: classes.dex */
    public interface a {
        void Hx();

        void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2);
    }

    public u(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aJI = new r(tbPageContext);
        this.aJJ = new x(tbPageContext, this.aJK);
        this.aJI.a(new v(this));
        this.aJJ.a(new w(this));
    }

    public void Hy() {
        this.aJI.Cy();
    }

    public void Gq() {
        this.aJJ.CI();
    }

    public void a(a aVar) {
        this.aJL = aVar;
    }

    private static void Hz() {
        aJH = new HashMap<>();
        aJH.put("discover_friend", Integer.valueOf(i.e.icon_find_trends));
        aJH.put("discover_nearby", Integer.valueOf(i.e.icon_find_nearby));
        aJH.put("discover_square", Integer.valueOf(i.e.icon_find_square));
        aJH.put("discover_hot_video", Integer.valueOf(i.e.icon_live_telecast));
        aJH.put("discover_one_sign", Integer.valueOf(i.e.icon_all_sign_dis));
        aJH.put("discover_look_shop", Integer.valueOf(i.e.icon_more_store));
        aJH.put("discover_rand_friend", Integer.valueOf(i.e.icon_find_chat));
        aJH.put("discover_beauty_show", Integer.valueOf(i.e.icon_find_shawty));
        aJH.put("discover_game_center", Integer.valueOf(i.e.icon_frs_game));
        aJH.put("discover_square_trend", Integer.valueOf(i.e.icon_find_myba));
    }

    public static int gr(String str) {
        if (aJH == null) {
            Hz();
        }
        Integer num = aJH.get(str);
        return num == null ? i.e.img_default_100 : num.intValue();
    }

    public com.baidu.tieba.discover.data.a HA() {
        com.baidu.tieba.discover.data.a aVar = new com.baidu.tieba.discover.data.a();
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_friend", i.h.friendsnews));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_nearby", i.h.neighbors));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_square", i.h.square));
        dVar.I(arrayList2);
        dVar.setType(1);
        arrayList.add(dVar);
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_square_trend", i.h.mybardongtai));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_hot_video", i.h.livetelecast));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_one_sign", i.h.signallforum));
        dVar2.I(arrayList3);
        dVar2.setType(0);
        arrayList.add(dVar2);
        com.baidu.tieba.discover.data.d dVar3 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_look_shop", i.h.face_store));
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_rand_friend", i.h.laiyifa));
        dVar3.I(arrayList4);
        dVar3.setType(0);
        arrayList.add(dVar3);
        aVar.H(arrayList);
        return aVar;
    }

    public String gs(String str) {
        if ("com.baidu.tieba.pluginNeighbors".equals(str)) {
            return "discover_nearby";
        }
        if ("com.baidu.tieba.pluginRandomChat".equals(str)) {
            return "discover_rand_friend";
        }
        return null;
    }
}
