package com.baidu.tieba.adkiller;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements o.a<String> {
    private final /* synthetic */ String aPI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str) {
        this.aPI = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aw */
    public void g(String str, String str2) {
        boolean z = false;
        if (!StringUtils.isNULL(str2)) {
            String[] split = str2.split(",");
            if (split != null) {
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str3 = split[i];
                    if (str3.startsWith("submit*")) {
                        if (this.aPI.equals(str3.substring("submit*".length()))) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                }
            }
            if (z) {
                TbadkCoreApplication.m411getInst().handler.post(new g(this, this.aPI));
            }
        }
    }
}
