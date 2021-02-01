package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bJu() instanceof TbPageContext) && (((TbPageContext) cVar.bJu()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bJu()).getPageActivity();
        }
        return null;
    }
}
