package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class j {
    private ArrayList<ab> att = new ArrayList<>();
    private boolean atu;
    private int level;

    public ArrayList<ab> CT() {
        return this.att;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void CU() {
        Iterator<ab> it = this.att.iterator();
        while (it.hasNext()) {
            it.next().hK(0);
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
                        ab abVar = new ab();
                        abVar.a((LikeForum) list.get(i));
                        if (abVar.getLevel() >= this.level) {
                            this.atu = true;
                        }
                        this.att.add(abVar);
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
