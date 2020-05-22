package com.baidu.tieba.enterForum.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes9.dex */
public class i {
    private ArrayList<h> gOT = new ArrayList<>();

    public ArrayList<h> bOm() {
        return this.gOT;
    }

    public void bOn() {
        Iterator<h> it = this.gOT.iterator();
        while (it.hasNext()) {
            it.next().sK(0);
        }
    }

    public void bQ(List<?> list) {
        if (list != null) {
            b(list, null);
        }
    }

    public void b(List<?> list, Context context) {
        if (list != null) {
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) instanceof LikeForum) {
                        h hVar = new h();
                        hVar.a((LikeForum) list.get(i));
                        if (!TextUtils.isEmpty(hVar.getName())) {
                            this.gOT.add(hVar);
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
