package com.baidu.tbadk.data;

import tbclient.TailInfo;
/* loaded from: classes.dex */
public class a {
    private int ahN;
    private String content;
    private String icon_link;
    private String icon_url;

    public void a(TailInfo tailInfo) {
        try {
            this.icon_url = tailInfo.icon_url;
            this.icon_link = tailInfo.icon_link;
            this.content = tailInfo.content;
            this.ahN = tailInfo.tail_type.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getIconUrl() {
        return this.icon_url;
    }

    public String yF() {
        return this.icon_link;
    }

    public String getContent() {
        return this.content;
    }

    public int yG() {
        return this.ahN;
    }
}
