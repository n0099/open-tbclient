package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class e {
    private ArrayList<x> bvb = new ArrayList<>();
    private boolean bvc;
    private int level;

    public ArrayList<x> Sx() {
        return this.bvb;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void Sy() {
        Iterator<x> it = this.bvb.iterator();
        while (it.hasNext()) {
            it.next().ea(0);
        }
    }

    public void af(List<?> list) {
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
                        x xVar = new x();
                        xVar.a((LikeForum) list.get(i));
                        if (xVar.getLevel() >= this.level) {
                            this.bvc = true;
                        }
                        this.bvb.add(xVar);
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
