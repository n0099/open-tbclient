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
    private ArrayList<ae> aEE = new ArrayList<>();
    private boolean aEF;
    private int level;

    public ArrayList<ae> HG() {
        return this.aEE;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public boolean HF() {
        return this.aEF;
    }

    public void HH() {
        Iterator<ae> it = this.aEE.iterator();
        while (it.hasNext()) {
            it.next().iK(0);
        }
    }

    public void j(List<?> list) {
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
                            this.aEF = true;
                        }
                        this.aEE.add(aeVar);
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
