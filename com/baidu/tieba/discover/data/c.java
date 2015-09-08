package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean aLT;
    private boolean aLU;
    private int aLV;
    private boolean aLW;
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
        this.aLT = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.aLU = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void go(String str) {
        this.icon_url = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String HR() {
        return this.link_url;
    }

    public String HS() {
        return this.describe;
    }

    public String HT() {
        return this.statistics;
    }

    public void gp(String str) {
        this.statistics = str;
    }

    public boolean HU() {
        return this.aLT;
    }

    public void bJ(boolean z) {
        this.aLT = z;
    }

    public boolean HV() {
        return this.aLU;
    }

    public void bK(boolean z) {
        this.aLU = z;
    }

    public int HW() {
        return this.aLV;
    }

    public void eO(int i) {
        this.aLV = i;
    }

    public boolean HX() {
        return this.aLW;
    }

    public void bL(boolean z) {
        this.aLW = z;
    }
}
