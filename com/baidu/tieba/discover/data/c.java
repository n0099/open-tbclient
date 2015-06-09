package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean aEh;
    private boolean aEi;
    private int aEj;
    private boolean aEk;
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
        this.aEh = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.aEi = z;
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

    public String Ho() {
        return this.link_url;
    }

    public String Hp() {
        return this.describe;
    }

    public String Hq() {
        return this.statistics;
    }

    public void fP(String str) {
        this.statistics = str;
    }

    public boolean Hr() {
        return this.aEh;
    }

    public void bC(boolean z) {
        this.aEh = z;
    }

    public boolean Hs() {
        return this.aEi;
    }

    public void bD(boolean z) {
        this.aEi = z;
    }

    public int Ht() {
        return this.aEj;
    }

    public void eB(int i) {
        this.aEj = i;
    }

    public boolean Hu() {
        return this.aEk;
    }

    public void bE(boolean z) {
        this.aEk = z;
    }
}
