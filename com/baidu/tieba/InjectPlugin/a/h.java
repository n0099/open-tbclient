package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes7.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.bJa() instanceof TbPageContext) && (((TbPageContext) cVar.bJa()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.bJa()).getPageActivity();
        }
        return null;
    }
}
