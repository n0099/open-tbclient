package com.baidu.tieba.discover.data;

import com.baidu.tbadk.TbadkApplication;
import tbclient.FoundNew.Menu;
/* loaded from: classes.dex */
public class c {
    private boolean aSj;
    private boolean aSk;
    private int aSl;
    private boolean aSm;
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
        this.aSj = menu.is_new != null && menu.is_new.intValue() == 1;
        if (menu.is_red_point == null || menu.is_red_point.intValue() != 1) {
            z = false;
        }
        this.aSk = z;
        return this;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void gS(String str) {
        this.icon_url = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String Jo() {
        return this.link_url;
    }

    public String Jp() {
        return this.describe;
    }

    public String Jq() {
        return this.statistics;
    }

    public void gT(String str) {
        this.statistics = str;
    }

    public boolean Jr() {
        return this.aSj;
    }

    public void bU(boolean z) {
        this.aSj = z;
    }

    public boolean Js() {
        return this.aSk;
    }

    public void bV(boolean z) {
        this.aSk = z;
    }

    public int Jt() {
        return this.aSl;
    }

    public void fd(int i) {
        this.aSl = i;
    }

    public boolean Ju() {
        return this.aSm;
    }

    public void bW(boolean z) {
        this.aSm = z;
    }
}
