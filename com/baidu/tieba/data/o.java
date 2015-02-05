package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.NewRecommend;
/* loaded from: classes.dex */
public class o {
    private ArrayList<k> atz = new ArrayList<>();

    public void i(List<?> list) {
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
                        k kVar = new k();
                        kVar.a((NewRecommend) list.get(i));
                        this.atz.add(kVar);
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
