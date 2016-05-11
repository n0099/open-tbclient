package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.as;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.Banner;
/* loaded from: classes.dex */
public class h {
    private ArrayList<as> aWV = new ArrayList<>();

    public ArrayList<as> Mo() {
        return this.aWV;
    }

    public void N(List<?> list) {
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
                        as asVar = new as();
                        asVar.a((Banner) list.get(i));
                        this.aWV.add(asVar);
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
