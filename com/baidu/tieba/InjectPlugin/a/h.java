package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes20.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bGZ() instanceof TbPageContext) && (((TbPageContext) cVar.bGZ()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bGZ()).getPageActivity();
        }
        return null;
    }
}
