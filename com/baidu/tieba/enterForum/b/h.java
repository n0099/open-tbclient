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
    private ArrayList<g> bYR = new ArrayList<>();
    private boolean bYS;
    private int level;

    public ArrayList<g> abL() {
        return this.bYR;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void abM() {
        Iterator<g> it = this.bYR.iterator();
        while (it.hasNext()) {
            it.next().ig(0);
        }
    }

    public void ao(List<?> list) {
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
                            this.bYS = true;
                        }
                        if (!TextUtils.isEmpty(gVar.getName())) {
                            this.bYR.add(gVar);
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
