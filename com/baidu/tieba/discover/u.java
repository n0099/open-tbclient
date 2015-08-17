package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class u {
    private static HashMap<String, Integer> aLx;
    private com.baidu.tieba.discover.data.b aLA = new com.baidu.tieba.discover.data.b();
    private a aLB;
    private r aLy;
    private x aLz;

    /* loaded from: classes.dex */
    public interface a {
        void HW();

        void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2);
    }

    public u(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aLy = new r(tbPageContext);
        this.aLz = new x(tbPageContext, this.aLA);
        this.aLy.a(new v(this));
        this.aLz.a(new w(this));
    }

    public void HX() {
        this.aLy.CL();
    }

    public void GP() {
        this.aLz.CV();
    }

    public void a(a aVar) {
        this.aLB = aVar;
    }

    private static void HY() {
        aLx = new HashMap<>();
        aLx.put("discover_friend", Integer.valueOf(i.e.icon_find_trends));
        aLx.put("discover_nearby", Integer.valueOf(i.e.icon_find_nearby));
        aLx.put("discover_square", Integer.valueOf(i.e.icon_find_square));
        aLx.put("discover_hot_video", Integer.valueOf(i.e.icon_live_telecast));
        aLx.put("discover_one_sign", Integer.valueOf(i.e.icon_all_sign_dis));
        aLx.put("discover_look_shop", Integer.valueOf(i.e.icon_more_store));
        aLx.put("discover_rand_friend", Integer.valueOf(i.e.icon_find_chat));
        aLx.put("discover_beauty_show", Integer.valueOf(i.e.icon_find_shawty));
        aLx.put("discover_game_center", Integer.valueOf(i.e.icon_frs_game));
        aLx.put("discover_square_trend", Integer.valueOf(i.e.icon_find_myba));
    }

    public static int gf(String str) {
        if (aLx == null) {
            HY();
        }
        Integer num = aLx.get(str);
        return num == null ? i.e.img_default_100 : num.intValue();
    }

    public com.baidu.tieba.discover.data.a HZ() {
        com.baidu.tieba.discover.data.a aVar = new com.baidu.tieba.discover.data.a();
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_friend", i.C0057i.friendsnews));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_nearby", i.C0057i.neighbors));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_square", i.C0057i.square));
        dVar.G(arrayList2);
        dVar.setType(1);
        arrayList.add(dVar);
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_square_trend", i.C0057i.mybardongtai));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_hot_video", i.C0057i.livetelecast));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_one_sign", i.C0057i.signallforum));
        dVar2.G(arrayList3);
        dVar2.setType(0);
        arrayList.add(dVar2);
        com.baidu.tieba.discover.data.d dVar3 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_look_shop", i.C0057i.face_store));
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_rand_friend", i.C0057i.laiyifa));
        dVar3.G(arrayList4);
        dVar3.setType(0);
        arrayList.add(dVar3);
        aVar.F(arrayList);
        return aVar;
    }

    public String gg(String str) {
        if ("com.baidu.tieba.pluginNeighbors".equals(str)) {
            return "discover_nearby";
        }
        if ("com.baidu.tieba.pluginRandomChat".equals(str)) {
            return "discover_rand_friend";
        }
        return null;
    }
}
