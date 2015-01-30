package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private int auA;
    private boolean auy;
    private boolean auz;
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
        this.auy = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.auz = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public String getTitle() {
        return this.title;
    }

    public String Dp() {
        return this.link_url;
    }

    public String Dq() {
        return this.describe;
    }

    public String Dr() {
        return this.statistics;
    }

    public boolean Ds() {
        return this.auy;
    }

    public void bu(boolean z) {
        this.auy = z;
    }

    public boolean Dt() {
        return this.auz;
    }

    public void bv(boolean z) {
        this.auz = z;
    }

    public int Du() {
        return this.auA;
    }

    public void ew(int i) {
        this.auA = i;
    }
}
