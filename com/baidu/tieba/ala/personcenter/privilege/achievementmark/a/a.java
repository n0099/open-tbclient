package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private String hOY;
    private ArrayList<b> hOZ = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.hOZ.add(bVar);
    }

    public b xA(int i) {
        return (b) y.getItem(this.hOZ, i);
    }

    public String cmW() {
        return this.hOY;
    }

    public void IX(String str) {
        this.hOY = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
