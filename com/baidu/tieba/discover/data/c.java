package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean aLG;
    private boolean aLH;
    private int aLI;
    private boolean aLJ;
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
        this.aLG = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.aLH = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void gh(String str) {
        this.icon_url = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String Id() {
        return this.link_url;
    }

    public String Ie() {
        return this.describe;
    }

    public String If() {
        return this.statistics;
    }

    public void gi(String str) {
        this.statistics = str;
    }

    public boolean Ig() {
        return this.aLG;
    }

    public void bE(boolean z) {
        this.aLG = z;
    }

    public boolean Ih() {
        return this.aLH;
    }

    public void bF(boolean z) {
        this.aLH = z;
    }

    public int Ii() {
        return this.aLI;
    }

    public void eH(int i) {
        this.aLI = i;
    }

    public boolean Ij() {
        return this.aLJ;
    }

    public void bG(boolean z) {
        this.aLJ = z;
    }
}
