package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes20.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bAC() instanceof TbPageContext) && (((TbPageContext) cVar.bAC()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bAC()).getPageActivity();
        }
        return null;
    }
}
