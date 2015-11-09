package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean aJQ;
    private boolean aJR;
    private int aJS;
    private boolean aJT;
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
        this.aJQ = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.aJR = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void gt(String str) {
        this.icon_url = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String HE() {
        return this.link_url;
    }

    public String HF() {
        return this.describe;
    }

    public String HG() {
        return this.statistics;
    }

    public void gu(String str) {
        this.statistics = str;
    }

    public boolean HH() {
        return this.aJQ;
    }

    public void bI(boolean z) {
        this.aJQ = z;
    }

    public boolean HI() {
        return this.aJR;
    }

    public void bJ(boolean z) {
        this.aJR = z;
    }

    public int HJ() {
        return this.aJS;
    }

    public void eT(int i) {
        this.aJS = i;
    }

    public boolean HK() {
        return this.aJT;
    }

    public void bK(boolean z) {
        this.aJT = z;
    }
}
