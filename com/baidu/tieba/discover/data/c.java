package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean aOr;
    private boolean aOs;
    private int aOt;
    private boolean aOu;
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
        this.aOr = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.aOs = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void gI(String str) {
        this.icon_url = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String IX() {
        return this.link_url;
    }

    public String IY() {
        return this.describe;
    }

    public String IZ() {
        return this.statistics;
    }

    public void gJ(String str) {
        this.statistics = str;
    }

    public boolean Ja() {
        return this.aOr;
    }

    public void bT(boolean z) {
        this.aOr = z;
    }

    public boolean Jb() {
        return this.aOs;
    }

    public void bU(boolean z) {
        this.aOs = z;
    }

    public int Jc() {
        return this.aOt;
    }

    public void fi(int i) {
        this.aOt = i;
    }

    public boolean Jd() {
        return this.aOu;
    }

    public void bV(boolean z) {
        this.aOu = z;
    }
}
