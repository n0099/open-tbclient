package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.bd;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.Banner;
/* loaded from: classes.dex */
public class i {
    private ArrayList<bd> bEn = new ArrayList<>();

    public ArrayList<bd> VL() {
        return this.bEn;
    }

    public void ab(List<?> list) {
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
                        bd bdVar = new bd();
                        bdVar.a((Banner) list.get(i));
                        this.bEn.add(bdVar);
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
