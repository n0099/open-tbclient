package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    private String ftl;
    private ArrayList<b> ftm = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.ftm.add(bVar);
    }

    public b qG(int i) {
        return (b) v.getItem(this.ftm, i);
    }

    public String bqH() {
        return this.ftl;
    }

    public void zn(String str) {
        this.ftl = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
