package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean atA;
    private int atB;
    private boolean atz;
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
        this.atz = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.atA = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public String getTitle() {
        return this.title;
    }

    public String CQ() {
        return this.link_url;
    }

    public String CR() {
        return this.describe;
    }

    public String CS() {
        return this.statistics;
    }

    public boolean CT() {
        return this.atz;
    }

    public void br(boolean z) {
        this.atz = z;
    }

    public boolean CU() {
        return this.atA;
    }

    public void bs(boolean z) {
        this.atA = z;
    }

    public int CV() {
        return this.atB;
    }

    public void eq(int i) {
        this.atB = i;
    }
}
