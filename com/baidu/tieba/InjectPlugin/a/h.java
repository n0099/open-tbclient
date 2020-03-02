package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.aVA() instanceof TbPageContext) && (((TbPageContext) cVar.aVA()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.aVA()).getPageActivity();
        }
        return null;
    }
}
