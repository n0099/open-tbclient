package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class c {
    private ArrayList<u> aMe = new ArrayList<>();
    private boolean aMf;
    private int level;

    public ArrayList<u> Is() {
        return this.aMe;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void It() {
        Iterator<u> it = this.aMe.iterator();
        while (it.hasNext()) {
            it.next().jF(0);
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
                        u uVar = new u();
                        uVar.a((LikeForum) list.get(i));
                        if (uVar.getLevel() >= this.level) {
                            this.aMf = true;
                        }
                        this.aMe.add(uVar);
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
