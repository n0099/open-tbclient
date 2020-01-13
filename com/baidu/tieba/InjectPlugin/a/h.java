package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.aTh() instanceof TbPageContext) && (((TbPageContext) cVar.aTh()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.aTh()).getPageActivity();
        }
        return null;
    }
}
