package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bJz() instanceof TbPageContext) && (((TbPageContext) cVar.bJz()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bJz()).getPageActivity();
        }
        return null;
    }
}
