package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a {
    private String ibw;
    private ArrayList<b> ibx = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.ibx.add(bVar);
    }

    public b ws(int i) {
        return (b) y.getItem(this.ibx, i);
    }

    public String cnd() {
        return this.ibw;
    }

    public void Io(String str) {
        this.ibw = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
