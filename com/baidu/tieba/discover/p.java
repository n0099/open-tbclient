package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    private static HashMap<String, Integer> asY;
    private m asZ;
    private t ata;
    private com.baidu.tieba.discover.data.b atb = new com.baidu.tieba.discover.data.b();
    private s atc;

    public p(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.asZ = new m(tbPageContext);
        this.ata = new t(tbPageContext, this.atb);
        this.asZ.a(new q(this));
        this.ata.a((com.baidu.tbadk.mvc.model.q) new r(this));
    }

    public void CK() {
        this.asZ.xn();
    }

    public void AY() {
        this.ata.xv();
    }

    public void a(s sVar) {
        this.atc = sVar;
    }

    private static void CL() {
        asY = new HashMap<>();
        asY.put("discover_friend", Integer.valueOf(com.baidu.tieba.v.icon_find_trends));
        asY.put("discover_nearby", Integer.valueOf(com.baidu.tieba.v.icon_find_nearby));
        asY.put("discover_square", Integer.valueOf(com.baidu.tieba.v.icon_find_square));
        asY.put("discover_hot_video", Integer.valueOf(com.baidu.tieba.v.icon_live_telecast));
        asY.put("discover_one_sign", Integer.valueOf(com.baidu.tieba.v.icon_all_sign_dis));
        asY.put("discover_look_shop", Integer.valueOf(com.baidu.tieba.v.icon_more_store));
        asY.put("discover_rand_friend", Integer.valueOf(com.baidu.tieba.v.icon_find_chat));
        asY.put("discover_beauty_show", Integer.valueOf(com.baidu.tieba.v.icon_find_shawty));
        asY.put("discover_game_center", Integer.valueOf(com.baidu.tieba.v.icon_frs_game));
    }

    public static int fb(String str) {
        if (asY == null) {
            CL();
        }
        Integer num = asY.get(str);
        return num == null ? com.baidu.tieba.v.img_default_100 : num.intValue();
    }

    public com.baidu.tieba.discover.data.a CM() {
        com.baidu.tieba.discover.data.a aVar = new com.baidu.tieba.discover.data.a();
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_friend", z.friendsnews));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_nearby", z.neighbors));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_square", z.square));
        dVar.K(arrayList2);
        dVar.setType(1);
        arrayList.add(dVar);
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_hot_video", z.livetelecast));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_one_sign", z.signallforum));
        dVar2.K(arrayList3);
        dVar2.setType(0);
        arrayList.add(dVar2);
        com.baidu.tieba.discover.data.d dVar3 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_look_shop", z.face_store));
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_rand_friend", z.laiyifa));
        dVar3.K(arrayList4);
        dVar3.setType(0);
        arrayList.add(dVar3);
        aVar.J(arrayList);
        return aVar;
    }
}
