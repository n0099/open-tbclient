package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.Ul() instanceof TbPageContext) && (((TbPageContext) cVar.Ul()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.Ul()).getPageActivity();
        }
        return null;
    }
}
