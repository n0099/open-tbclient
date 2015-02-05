package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.v;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    private static HashMap<String, Integer> auc;
    private m aud;
    private t aue;
    private com.baidu.tieba.discover.data.b auf = new com.baidu.tieba.discover.data.b();
    private s aug;

    public p(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aud = new m(tbPageContext);
        this.aue = new t(tbPageContext, this.auf);
        this.aud.a(new q(this));
        this.aue.a((com.baidu.tbadk.mvc.model.q) new r(this));
    }

    public void Dd() {
        this.aud.xx();
    }

    public void Bs() {
        this.aue.xF();
    }

    public void a(s sVar) {
        this.aug = sVar;
    }

    private static void De() {
        auc = new HashMap<>();
        auc.put("discover_friend", Integer.valueOf(v.icon_find_trends));
        auc.put("discover_nearby", Integer.valueOf(v.icon_find_nearby));
        auc.put("discover_square", Integer.valueOf(v.icon_find_square));
        auc.put("discover_hot_video", Integer.valueOf(v.icon_live_telecast));
        auc.put("discover_one_sign", Integer.valueOf(v.icon_all_sign_dis));
        auc.put("discover_look_shop", Integer.valueOf(v.icon_more_store));
        auc.put("discover_rand_friend", Integer.valueOf(v.icon_find_chat));
        auc.put("discover_beauty_show", Integer.valueOf(v.icon_find_shawty));
        auc.put("discover_game_center", Integer.valueOf(v.icon_frs_game));
    }

    public static int fd(String str) {
        if (auc == null) {
            De();
        }
        Integer num = auc.get(str);
        return num == null ? v.img_default_100 : num.intValue();
    }

    public com.baidu.tieba.discover.data.a Df() {
        com.baidu.tieba.discover.data.a aVar = new com.baidu.tieba.discover.data.a();
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_friend", com.baidu.tieba.z.friendsnews));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_nearby", com.baidu.tieba.z.neighbors));
        arrayList2.add(new com.baidu.tieba.discover.data.c("discover_square", com.baidu.tieba.z.square));
        dVar.M(arrayList2);
        dVar.setType(1);
        arrayList.add(dVar);
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_hot_video", com.baidu.tieba.z.livetelecast));
        arrayList3.add(new com.baidu.tieba.discover.data.c("discover_one_sign", com.baidu.tieba.z.signallforum));
        dVar2.M(arrayList3);
        dVar2.setType(0);
        arrayList.add(dVar2);
        com.baidu.tieba.discover.data.d dVar3 = new com.baidu.tieba.discover.data.d();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_look_shop", com.baidu.tieba.z.face_store));
        arrayList4.add(new com.baidu.tieba.discover.data.c("discover_rand_friend", com.baidu.tieba.z.laiyifa));
        dVar3.M(arrayList4);
        dVar3.setType(0);
        arrayList.add(dVar3);
        aVar.L(arrayList);
        return aVar;
    }
}
