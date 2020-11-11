package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private String hFK;
    private ArrayList<b> hFL = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.hFL.add(bVar);
    }

    public b wx(int i) {
        return (b) y.getItem(this.hFL, i);
    }

    public String cjJ() {
        return this.hFK;
    }

    public void IH(String str) {
        this.hFK = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
