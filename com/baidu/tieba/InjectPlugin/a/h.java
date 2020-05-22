package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bjY() instanceof TbPageContext) && (((TbPageContext) cVar.bjY()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bjY()).getPageActivity();
        }
        return null;
    }
}
