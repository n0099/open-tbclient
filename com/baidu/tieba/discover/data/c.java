package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean aKL;
    private boolean aKM;
    private int aKN;
    private boolean aKO;
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
        this.aKL = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.aKM = z;
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

    public String HL() {
        return this.link_url;
    }

    public String HM() {
        return this.describe;
    }

    public String HN() {
        return this.statistics;
    }

    public void gs(String str) {
        this.statistics = str;
    }

    public boolean HO() {
        return this.aKL;
    }

    public void bG(boolean z) {
        this.aKL = z;
    }

    public boolean HP() {
        return this.aKM;
    }

    public void bH(boolean z) {
        this.aKM = z;
    }

    public int HQ() {
        return this.aKN;
    }

    public void eT(int i) {
        this.aKN = i;
    }

    public boolean HR() {
        return this.aKO;
    }

    public void bI(boolean z) {
        this.aKO = z;
    }
}
