package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.aSN() instanceof TbPageContext) && (((TbPageContext) cVar.aSN()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.aSN()).getPageActivity();
        }
        return null;
    }
}
