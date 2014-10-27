package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.NewRecommend;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<ad> amp = new ArrayList<>();

    public ArrayList<ad> Ao() {
        return this.amp;
    }

    public void A(List<?> list) {
        if (list != null && list.size() > 0) {
            a(list, null);
        }
    }

    public void a(List<?> list, Context context) {
        if (list != null && list.size() > 0) {
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) instanceof NewRecommend) {
                        ad adVar = new ad();
                        adVar.a((NewRecommend) list.get(i));
                        this.amp.add(adVar);
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
