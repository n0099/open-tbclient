package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes15.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bzs() instanceof TbPageContext) && (((TbPageContext) cVar.bzs()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bzs()).getPageActivity();
        }
        return null;
    }
}
