package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean aKW;
    private boolean aKX;
    private int aKY;
    private boolean aKZ;
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
        this.aKW = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.aKX = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void gr(String str) {
        this.icon_url = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String HH() {
        return this.link_url;
    }

    public String HI() {
        return this.describe;
    }

    public String HJ() {
        return this.statistics;
    }

    public void gs(String str) {
        this.statistics = str;
    }

    public boolean HK() {
        return this.aKW;
    }

    public void bG(boolean z) {
        this.aKW = z;
    }

    public boolean HL() {
        return this.aKX;
    }

    public void bH(boolean z) {
        this.aKX = z;
    }

    public int HM() {
        return this.aKY;
    }

    public void eT(int i) {
        this.aKY = i;
    }

    public boolean HN() {
        return this.aKZ;
    }

    public void bI(boolean z) {
        this.aKZ = z;
    }
}
