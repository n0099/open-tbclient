package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.aVF() instanceof TbPageContext) && (((TbPageContext) cVar.aVF()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.aVF()).getPageActivity();
        }
        return null;
    }
}
