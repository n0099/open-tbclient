package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class t {
    private static HashMap<String, Integer> aSa;
    private r aSb;
    private w aSc;
    private com.baidu.tieba.discover.data.b aSd = new com.baidu.tieba.discover.data.b();
    private a aSe;

    /* loaded from: classes.dex */
    public interface a {
        void Jh();

        void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2);
    }

    public t(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aSb = new r(tbPageContext);
        this.aSc = new w(tbPageContext, this.aSd);
        this.aSb.a(new u(this));
        this.aSc.a(new v(this));
    }

    public void Ji() {
        this.aSb.Do();
    }

    public void Hm() {
        this.aSc.Dy();
    }

    public void a(a aVar) {
        this.aSe = aVar;
    }

    private static void Jj() {
        aSa = new HashMap<>();
        aSa.put("discover_friend", Integer.valueOf(n.f.icon_find_trends));
        aSa.put("discover_nearby", Integer.valueOf(n.f.icon_find_nearby));
        aSa.put("discover_square", Integer.valueOf(n.f.icon_find_square));
        aSa.put("discover_hot_video", Integer.valueOf(n.f.icon_live_telecast));
        aSa.put("discover_one_sign", Integer.valueOf(n.f.icon_all_sign_dis));
        aSa.put("discover_look_shop", Integer.valueOf(n.f.icon_more_store));
        aSa.put("discover_rand_friend", Integer.valueOf(n.f.icon_find_chat));
        aSa.put("discover_beauty_show", Integer.valueOf(n.f.icon_find_shawty));
        aSa.put("discover_game_center", Integer.valueOf(n.f.icon_frs_game));
        aSa.put("discover_square_trend", Integer.valueOf(n.f.icon_find_myba));
    }

    public static int gR(String str) {
        if (aSa == null) {
            Jj();
        }
        Integer num = aSa.get(str);
        return num == null ? n.f.img_default_100 : num.intValue();
    }

    public com.baidu.tieba.discover.data.a Jk() {
        com.baidu.tieba.discover.data.a aVar = new com.baidu.tieba.discover.data.a();
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_friend", n.j.friendsnews));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_nearby", n.j.neighbors));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_square", n.j.square));
        dVar.J(arrayList2);
        dVar.setType(1);
        arrayList.add(dVar);
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_square_trend", n.j.mybardongtai));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_hot_video", n.j.livetelecast));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_one_sign", n.j.signallforum));
        dVar2.J(arrayList3);
        dVar2.setType(0);
        arrayList.add(dVar2);
        com.baidu.tieba.discover.data.d dVar3 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_look_shop", n.j.face_store));
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_rand_friend", n.j.laiyifa));
        dVar3.J(arrayList4);
        dVar3.setType(0);
        arrayList.add(dVar3);
        aVar.I(arrayList);
        return aVar;
    }

    public String gS(String str) {
        if ("com.baidu.tieba.pluginNeighbors".equals(str)) {
            return "discover_nearby";
        }
        if ("com.baidu.tieba.pluginRandomChat".equals(str)) {
            return "discover_rand_friend";
        }
        return null;
    }
}
