package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.azn() instanceof TbPageContext) && (((TbPageContext) cVar.azn()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.azn()).getPageActivity();
        }
        return null;
    }
}
