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
    private ArrayList<x> bsM = new ArrayList<>();
    private boolean bsN;
    private int level;

    public ArrayList<x> RQ() {
        return this.bsM;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void RR() {
        Iterator<x> it = this.bsM.iterator();
        while (it.hasNext()) {
            it.next().ea(0);
        }
    }

    public void aa(List<?> list) {
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
                            this.bsN = true;
                        }
                        this.bsM.add(xVar);
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
