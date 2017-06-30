package com.baidu.tieba.enterForum.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class h {
    private ArrayList<g> bSL = new ArrayList<>();
    private boolean bSM;
    private int level;

    public ArrayList<g> aaz() {
        return this.bSL;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void aaA() {
        Iterator<g> it = this.bSL.iterator();
        while (it.hasNext()) {
            it.next().hX(0);
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
                        g gVar = new g();
                        gVar.a((LikeForum) list.get(i));
                        if (gVar.getLevel() >= this.level) {
                            this.bSM = true;
                        }
                        if (!TextUtils.isEmpty(gVar.getName())) {
                            this.bSL.add(gVar);
                        }
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
