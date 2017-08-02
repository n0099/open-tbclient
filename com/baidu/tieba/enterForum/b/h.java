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
    private ArrayList<g> bWZ = new ArrayList<>();
    private boolean bXa;
    private int level;

    public ArrayList<g> abl() {
        return this.bWZ;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void abm() {
        Iterator<g> it = this.bWZ.iterator();
        while (it.hasNext()) {
            it.next().ie(0);
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
                            this.bXa = true;
                        }
                        if (!TextUtils.isEmpty(gVar.getName())) {
                            this.bWZ.add(gVar);
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
