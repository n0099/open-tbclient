package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bka() instanceof TbPageContext) && (((TbPageContext) cVar.bka()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bka()).getPageActivity();
        }
        return null;
    }
}
