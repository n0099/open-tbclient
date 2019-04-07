package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.auh() instanceof TbPageContext) && (((TbPageContext) cVar.auh()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.auh()).getPageActivity();
        }
        return null;
    }
}
