package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bMR() instanceof TbPageContext) && (((TbPageContext) cVar.bMR()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bMR()).getPageActivity();
        }
        return null;
    }
}
