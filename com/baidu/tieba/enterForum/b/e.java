package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class e {
    private ArrayList<v> bpw = new ArrayList<>();
    private boolean bpx;
    private int level;

    public ArrayList<v> SP() {
        return this.bpw;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void SQ() {
        Iterator<v> it = this.bpw.iterator();
        while (it.hasNext()) {
            it.next().er(0);
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
                        v vVar = new v();
                        vVar.a((LikeForum) list.get(i));
                        if (vVar.getLevel() >= this.level) {
                            this.bpx = true;
                        }
                        this.bpw.add(vVar);
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
