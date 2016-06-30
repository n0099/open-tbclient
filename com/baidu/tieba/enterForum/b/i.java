package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.au;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.Banner;
/* loaded from: classes.dex */
public class i {
    private ArrayList<au> bsS = new ArrayList<>();

    public ArrayList<au> RU() {
        return this.bsS;
    }

    public void aa(List<?> list) {
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
                        au auVar = new au();
                        auVar.a((Banner) list.get(i));
                        this.bsS.add(auVar);
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
