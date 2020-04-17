package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bdP() instanceof TbPageContext) && (((TbPageContext) cVar.bdP()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bdP()).getPageActivity();
        }
        return null;
    }
}
