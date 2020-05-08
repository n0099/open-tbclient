package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bdN() instanceof TbPageContext) && (((TbPageContext) cVar.bdN()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bdN()).getPageActivity();
        }
        return null;
    }
}
