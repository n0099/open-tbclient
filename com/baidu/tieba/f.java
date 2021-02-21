package com.baidu.tieba;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class f {
    public static void Eq(String str) {
        ar arVar = new ar("c14075");
        arVar.dR("obj_type", str);
        TiebaStatic.log(arVar);
    }

    public static void ef(String str, String str2) {
        ar arVar = new ar("c14076");
        arVar.dR("obj_source", str);
        arVar.dR("obj_type", str2);
        TiebaStatic.log(arVar);
    }
}
