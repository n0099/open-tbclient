package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class t {
    private static HashMap<String, Integer> aOi;
    private r aOj;
    private w aOk;
    private com.baidu.tieba.discover.data.b aOl = new com.baidu.tieba.discover.data.b();
    private a aOm;

    /* loaded from: classes.dex */
    public interface a {
        void IQ();

        void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2);
    }

    public t(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aOj = new r(tbPageContext);
        this.aOk = new w(tbPageContext, this.aOl);
        this.aOj.a(new u(this));
        this.aOk.a(new v(this));
    }

    public void IR() {
        this.aOj.Dz();
    }

    public void Hx() {
        this.aOk.DJ();
    }

    public void a(a aVar) {
        this.aOm = aVar;
    }

    private static void IS() {
        aOi = new HashMap<>();
        aOi.put("discover_friend", Integer.valueOf(n.e.icon_find_trends));
        aOi.put("discover_nearby", Integer.valueOf(n.e.icon_find_nearby));
        aOi.put("discover_square", Integer.valueOf(n.e.icon_find_square));
        aOi.put("discover_hot_video", Integer.valueOf(n.e.icon_live_telecast));
        aOi.put("discover_one_sign", Integer.valueOf(n.e.icon_all_sign_dis));
        aOi.put("discover_look_shop", Integer.valueOf(n.e.icon_more_store));
        aOi.put("discover_rand_friend", Integer.valueOf(n.e.icon_find_chat));
        aOi.put("discover_beauty_show", Integer.valueOf(n.e.icon_find_shawty));
        aOi.put("discover_game_center", Integer.valueOf(n.e.icon_frs_game));
        aOi.put("discover_square_trend", Integer.valueOf(n.e.icon_find_myba));
    }

    public static int gG(String str) {
        if (aOi == null) {
            IS();
        }
        Integer num = aOi.get(str);
        return num == null ? n.e.img_default_100 : num.intValue();
    }

    public com.baidu.tieba.discover.data.a IT() {
        com.baidu.tieba.discover.data.a aVar = new com.baidu.tieba.discover.data.a();
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_friend", n.i.friendsnews));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_nearby", n.i.neighbors));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_square", n.i.square));
        dVar.I(arrayList2);
        dVar.setType(1);
        arrayList.add(dVar);
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_square_trend", n.i.mybardongtai));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_hot_video", n.i.livetelecast));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_one_sign", n.i.signallforum));
        dVar2.I(arrayList3);
        dVar2.setType(0);
        arrayList.add(dVar2);
        com.baidu.tieba.discover.data.d dVar3 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_look_shop", n.i.face_store));
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_rand_friend", n.i.laiyifa));
        dVar3.I(arrayList4);
        dVar3.setType(0);
        arrayList.add(dVar3);
        aVar.H(arrayList);
        return aVar;
    }

    public String gH(String str) {
        if ("com.baidu.tieba.pluginNeighbors".equals(str)) {
            return "discover_nearby";
        }
        if ("com.baidu.tieba.pluginRandomChat".equals(str)) {
            return "discover_rand_friend";
        }
        return null;
    }
}
