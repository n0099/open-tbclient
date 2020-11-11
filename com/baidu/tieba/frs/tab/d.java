package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.bg;
/* loaded from: classes22.dex */
public class d {
    public bg jgk;
    public String name;
    public int tabId;
    public int tabType;
    public String url;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        if (this.tabId == ((d) obj).tabId && this.name != null && this.name.equals(((d) obj).name)) {
            return true;
        }
        return super.equals(obj);
    }
}
