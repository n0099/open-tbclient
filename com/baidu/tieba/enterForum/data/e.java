package com.baidu.tieba.enterForum.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes4.dex */
public class e {
    private ArrayList<d> eCb = new ArrayList<>();

    public ArrayList<d> aWu() {
        return this.eCb;
    }

    public void aWv() {
        Iterator<d> it = this.eCb.iterator();
        while (it.hasNext()) {
            it.next().pd(0);
        }
    }

    public void bu(List<?> list) {
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
                        d dVar = new d();
                        dVar.a((LikeForum) list.get(i));
                        if (!TextUtils.isEmpty(dVar.getName())) {
                            this.eCb.add(dVar);
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
