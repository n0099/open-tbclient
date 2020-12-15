package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private String hPa;
    private ArrayList<b> hPb = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.hPb.add(bVar);
    }

    public b xA(int i) {
        return (b) y.getItem(this.hPb, i);
    }

    public String cmX() {
        return this.hPa;
    }

    public void IX(String str) {
        this.hPa = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
