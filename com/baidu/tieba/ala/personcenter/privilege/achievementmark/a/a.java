package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private String eyB;
    private ArrayList<b> eyC = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.eyC.add(bVar);
    }

    public b oi(int i) {
        return (b) v.getItem(this.eyC, i);
    }

    public String aXJ() {
        return this.eyB;
    }

    public void ul(String str) {
        this.eyB = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
