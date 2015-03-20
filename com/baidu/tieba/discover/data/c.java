package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean aBX;
    private boolean aBY;
    private int aBZ;
    private String describe;
    private String icon_url;
    private String link_url;
    private String statistics;
    private String title;

    public c() {
    }

    public c(String str, int i) {
        this.statistics = str;
        this.title = TbadkApplication.getInst().getResources().getString(i);
    }

    public c a(Menu menu) {
        boolean z = true;
        if (menu == null) {
            return null;
        }
        this.icon_url = menu.icon_url;
        this.title = menu.title;
        this.link_url = menu.link_url;
        this.describe = menu.describe;
        this.statistics = menu.statistics;
        this.aBX = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.aBY = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public String getTitle() {
        return this.title;
    }

    public String Ge() {
        return this.link_url;
    }

    public String Gf() {
        return this.describe;
    }

    public String Gg() {
        return this.statistics;
    }

    public boolean Gh() {
        return this.aBX;
    }

    public void bt(boolean z) {
        this.aBX = z;
    }

    public boolean Gi() {
        return this.aBY;
    }

    public void bu(boolean z) {
        this.aBY = z;
    }

    public int Gj() {
        return this.aBZ;
    }

    public void ep(int i) {
        this.aBZ = i;
    }
}
