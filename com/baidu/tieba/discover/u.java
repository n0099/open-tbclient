package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class u {
    private static HashMap<String, Integer> aLK;
    private r aLL;
    private x aLM;
    private com.baidu.tieba.discover.data.b aLN = new com.baidu.tieba.discover.data.b();
    private a aLO;

    /* loaded from: classes.dex */
    public interface a {
        void HK();

        void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2);
    }

    public u(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aLL = new r(tbPageContext);
        this.aLM = new x(tbPageContext, this.aLN);
        this.aLL.a(new v(this));
        this.aLM.a(new w(this));
    }

    public void HL() {
        this.aLL.CV();
    }

    public void GD() {
        this.aLM.Df();
    }

    public void a(a aVar) {
        this.aLO = aVar;
    }

    private static void HM() {
        aLK = new HashMap<>();
        aLK.put("discover_friend", Integer.valueOf(i.e.icon_find_trends));
        aLK.put("discover_nearby", Integer.valueOf(i.e.icon_find_nearby));
        aLK.put("discover_square", Integer.valueOf(i.e.icon_find_square));
        aLK.put("discover_hot_video", Integer.valueOf(i.e.icon_live_telecast));
        aLK.put("discover_one_sign", Integer.valueOf(i.e.icon_all_sign_dis));
        aLK.put("discover_look_shop", Integer.valueOf(i.e.icon_more_store));
        aLK.put("discover_rand_friend", Integer.valueOf(i.e.icon_find_chat));
        aLK.put("discover_beauty_show", Integer.valueOf(i.e.icon_find_shawty));
        aLK.put("discover_game_center", Integer.valueOf(i.e.icon_frs_game));
        aLK.put("discover_square_trend", Integer.valueOf(i.e.icon_find_myba));
    }

    public static int gm(String str) {
        if (aLK == null) {
            HM();
        }
        Integer num = aLK.get(str);
        return num == null ? i.e.img_default_100 : num.intValue();
    }

    public com.baidu.tieba.discover.data.a HN() {
        com.baidu.tieba.discover.data.a aVar = new com.baidu.tieba.discover.data.a();
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_friend", i.h.friendsnews));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_nearby", i.h.neighbors));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_square", i.h.square));
        dVar.H(arrayList2);
        dVar.setType(1);
        arrayList.add(dVar);
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_square_trend", i.h.mybardongtai));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_hot_video", i.h.livetelecast));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_one_sign", i.h.signallforum));
        dVar2.H(arrayList3);
        dVar2.setType(0);
        arrayList.add(dVar2);
        com.baidu.tieba.discover.data.d dVar3 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_look_shop", i.h.face_store));
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_rand_friend", i.h.laiyifa));
        dVar3.H(arrayList4);
        dVar3.setType(0);
        arrayList.add(dVar3);
        aVar.G(arrayList);
        return aVar;
    }

    public String gn(String str) {
        if ("com.baidu.tieba.pluginNeighbors".equals(str)) {
            return "discover_nearby";
        }
        if ("com.baidu.tieba.pluginRandomChat".equals(str)) {
            return "discover_rand_friend";
        }
        return null;
    }
}
