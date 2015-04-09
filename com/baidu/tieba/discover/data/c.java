package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean aCf;
    private boolean aCg;
    private int aCh;
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
        this.aCf = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.aCg = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public String getTitle() {
        return this.title;
    }

    public String Gk() {
        return this.link_url;
    }

    public String Gl() {
        return this.describe;
    }

    public String Gm() {
        return this.statistics;
    }

    public boolean Gn() {
        return this.aCf;
    }

    public void bt(boolean z) {
        this.aCf = z;
    }

    public boolean Go() {
        return this.aCg;
    }

    public void bu(boolean z) {
        this.aCg = z;
    }

    public int Gp() {
        return this.aCh;
    }

    public void ep(int i) {
        this.aCh = i;
    }
}
