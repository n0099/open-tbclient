package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ac;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.Banner;
/* loaded from: classes.dex */
public class h {
    private ArrayList<ac> aWg = new ArrayList<>();

    public ArrayList<ac> LS() {
        return this.aWg;
    }

    public void I(List<?> list) {
        if (list != null && !list.isEmpty()) {
            a(list, null);
        }
    }

    public void a(List<?> list, Context context) {
        if (list != null && !list.isEmpty()) {
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) instanceof Banner) {
                        ac acVar = new ac();
                        acVar.a((Banner) list.get(i));
                        this.aWg.add(acVar);
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
