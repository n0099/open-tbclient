package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class c {
    private ArrayList<ae> aCu = new ArrayList<>();
    private boolean aCv;
    private int level;

    public ArrayList<ae> Gw() {
        return this.aCu;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public boolean Gv() {
        return this.aCv;
    }

    public void Gx() {
        Iterator<ae> it = this.aCu.iterator();
        while (it.hasNext()) {
            it.next().il(0);
        }
    }

    public void i(List<?> list) {
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
                        ae aeVar = new ae();
                        aeVar.a((LikeForum) list.get(i));
                        if (aeVar.getLevel() >= this.level) {
                            this.aCv = true;
                        }
                        this.aCu.add(aeVar);
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
