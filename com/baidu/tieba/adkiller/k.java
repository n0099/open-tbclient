package com.baidu.tieba.adkiller;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements be.a {
    @Override // com.baidu.tbadk.core.util.be.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        if (str.toLowerCase().startsWith("http://tieba.baidu.com/mo/q/adkillergame?tag=")) {
            b.gE(str);
            return 0;
        }
        return 3;
    }
}
