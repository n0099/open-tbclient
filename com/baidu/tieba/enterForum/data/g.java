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
    private ArrayList<f> dgq = new ArrayList<>();

    public ArrayList<f> atJ() {
        return this.dgq;
    }

    public void atK() {
        Iterator<f> it = this.dgq.iterator();
        while (it.hasNext()) {
            it.next().kE(0);
        }
    }

    public void be(List<?> list) {
        if (list != null) {
            a(list, null);
        }
    }

    public void a(List<?> list, Context context) {
        if (list != null) {
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) instanceof LikeForum) {
                        f fVar = new f();
                        fVar.a((LikeForum) list.get(i));
                        if (!TextUtils.isEmpty(fVar.getName())) {
                            this.dgq.add(fVar);
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
