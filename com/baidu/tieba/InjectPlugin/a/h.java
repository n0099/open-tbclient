package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes15.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bqu() instanceof TbPageContext) && (((TbPageContext) cVar.bqu()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bqu()).getPageActivity();
        }
        return null;
    }
}
