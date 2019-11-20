package com.baidu.tieba.enterForum.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes4.dex */
public class g {
    private ArrayList<f> faf = new ArrayList<>();

    public ArrayList<f> bdW() {
        return this.faf;
    }

    public void bdX() {
        Iterator<f> it = this.faf.iterator();
        while (it.hasNext()) {
            it.next().pu(0);
        }
    }

    public void bP(List<?> list) {
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
                        f fVar = new f();
                        fVar.a((LikeForum) list.get(i));
                        if (!TextUtils.isEmpty(fVar.getName())) {
                            this.faf.add(fVar);
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
