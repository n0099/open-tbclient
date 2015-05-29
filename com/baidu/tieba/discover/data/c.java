package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean aEg;
    private boolean aEh;
    private int aEi;
    private boolean aEj;
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
        this.aEg = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.aEh = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void fO(String str) {
        this.icon_url = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String Hn() {
        return this.link_url;
    }

    public String Ho() {
        return this.describe;
    }

    public String Hp() {
        return this.statistics;
    }

    public void fP(String str) {
        this.statistics = str;
    }

    public boolean Hq() {
        return this.aEg;
    }

    public void bC(boolean z) {
        this.aEg = z;
    }

    public boolean Hr() {
        return this.aEh;
    }

    public void bD(boolean z) {
        this.aEh = z;
    }

    public int Hs() {
        return this.aEi;
    }

    public void eB(int i) {
        this.aEi = i;
    }

    public boolean Ht() {
        return this.aEj;
    }

    public void bE(boolean z) {
        this.aEj = z;
    }
}
