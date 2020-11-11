package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes21.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bHG() instanceof TbPageContext) && (((TbPageContext) cVar.bHG()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bHG()).getPageActivity();
        }
        return null;
    }
}
