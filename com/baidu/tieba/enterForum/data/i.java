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
    private ArrayList<h> gAd = new ArrayList<>();

    public ArrayList<h> bHU() {
        return this.gAd;
    }

    public void bHV() {
        Iterator<h> it = this.gAd.iterator();
        while (it.hasNext()) {
            it.next().sf(0);
        }
    }

    public void bT(List<?> list) {
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
                            this.gAd.add(hVar);
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
