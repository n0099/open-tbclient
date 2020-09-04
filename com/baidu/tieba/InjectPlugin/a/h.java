package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes15.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bzt() instanceof TbPageContext) && (((TbPageContext) cVar.bzt()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bzt()).getPageActivity();
        }
        return null;
    }
}
