package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.OK() instanceof TbPageContext) && (((TbPageContext) cVar.OK()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.OK()).getPageActivity();
        }
        return null;
    }
}
