package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bmz() instanceof TbPageContext) && (((TbPageContext) cVar.bmz()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bmz()).getPageActivity();
        }
        return null;
    }
}
