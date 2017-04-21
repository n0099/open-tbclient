package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class e {
    private ArrayList<u> bGy = new ArrayList<>();
    private boolean bGz;
    private int level;

    public ArrayList<u> WH() {
        return this.bGy;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void WI() {
        Iterator<u> it = this.bGy.iterator();
        while (it.hasNext()) {
            it.next().eq(0);
        }
    }

    public void ac(List<?> list) {
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
                        u uVar = new u();
                        uVar.a((LikeForum) list.get(i));
                        if (uVar.getLevel() >= this.level) {
                            this.bGz = true;
                        }
                        this.bGy.add(uVar);
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
