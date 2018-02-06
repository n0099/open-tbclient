package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.aw;
/* loaded from: classes2.dex */
public class b {
    public aw dUr;
    public String name;
    public int tabId;
    public String url;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        if (this.tabId == ((b) obj).tabId && this.name != null && this.name.equals(((b) obj).name)) {
            return true;
        }
        return super.equals(obj);
    }
}
