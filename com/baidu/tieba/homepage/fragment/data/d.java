package com.baidu.tieba.homepage.fragment.data;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class d {
    public static void a(e eVar) {
        if (eVar instanceof com.baidu.tieba.homepage.listview.card.b.b) {
            TiebaStatic.log("c10555");
        } else if (eVar instanceof com.baidu.tieba.homepage.listview.card.j.b) {
            TiebaStatic.log("c10552");
        } else if (eVar instanceof com.baidu.tieba.homepage.listview.card.i.b) {
            TiebaStatic.log("c10560");
        } else if (eVar instanceof com.baidu.tieba.homepage.listview.card.h.b) {
            TiebaStatic.log("c10548");
        } else if (eVar instanceof com.baidu.tieba.homepage.listview.card.f.b) {
            TiebaStatic.log("c10546");
        } else if (eVar instanceof com.baidu.tieba.homepage.listview.card.d.b) {
            TiebaStatic.log("c10542");
        }
    }

    public static void D(String str, int i) {
        if (i > 0) {
            TiebaStatic.log(new av(str).r("obj_locate", i));
        }
    }

    public static void b(e eVar) {
        if (eVar instanceof com.baidu.tieba.homepage.listview.card.j.b) {
            TiebaStatic.log("c10550");
        } else if (eVar instanceof com.baidu.tieba.homepage.listview.card.g.b) {
            TiebaStatic.log("c10562");
        }
    }
}
