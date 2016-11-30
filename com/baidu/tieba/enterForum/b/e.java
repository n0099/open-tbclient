package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class e {
    private ArrayList<w> bJt = new ArrayList<>();
    private boolean bJu;
    private int level;

    public ArrayList<w> YE() {
        return this.bJt;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void YF() {
        Iterator<w> it = this.bJt.iterator();
        while (it.hasNext()) {
            it.next().eq(0);
        }
    }

    public void ai(List<?> list) {
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
                        w wVar = new w();
                        wVar.a((LikeForum) list.get(i));
                        if (wVar.getLevel() >= this.level) {
                            this.bJu = true;
                        }
                        this.bJt.add(wVar);
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
