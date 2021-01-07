package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bMS() instanceof TbPageContext) && (((TbPageContext) cVar.bMS()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bMS()).getPageActivity();
        }
        return null;
    }
}
