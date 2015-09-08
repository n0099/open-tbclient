package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class c {
    private ArrayList<v> aMr = new ArrayList<>();
    private boolean aMs;
    private int level;

    public ArrayList<v> Ig() {
        return this.aMr;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void Ih() {
        Iterator<v> it = this.aMr.iterator();
        while (it.hasNext()) {
            it.next().kq(0);
        }
    }

    public void k(List<?> list) {
        if (list != null) {
            a(list, null);
        }
    }

    public void a(List<?> list, Context context) {
        if (list != null) {
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) instanceof LikeForum) {
                        v vVar = new v();
                        vVar.a((LikeForum) list.get(i));
                        if (vVar.getLevel() >= this.level) {
                            this.aMs = true;
                        }
                        this.aMr.add(vVar);
                    } else {
                        return;
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
