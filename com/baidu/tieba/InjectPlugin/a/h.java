package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.OF() instanceof TbPageContext) && (((TbPageContext) cVar.OF()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.OF()).getPageActivity();
        }
        return null;
    }
}
