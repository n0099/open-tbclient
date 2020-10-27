package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes21.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bFh() instanceof TbPageContext) && (((TbPageContext) cVar.bFh()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bFh()).getPageActivity();
        }
        return null;
    }
}
