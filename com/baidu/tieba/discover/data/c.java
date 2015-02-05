package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean auv;
    private boolean auw;
    private int aux;
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
        this.auv = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.auw = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public String getTitle() {
        return this.title;
    }

    public String Dj() {
        return this.link_url;
    }

    public String Dk() {
        return this.describe;
    }

    public String Dl() {
        return this.statistics;
    }

    public boolean Dm() {
        return this.auv;
    }

    public void bu(boolean z) {
        this.auv = z;
    }

    public boolean Dn() {
        return this.auw;
    }

    public void bv(boolean z) {
        this.auw = z;
    }

    public int Do() {
        return this.aux;
    }

    public void ew(int i) {
        this.aux = i;
    }
}
