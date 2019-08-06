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
    private ArrayList<f> eWF = new ArrayList<>();

    public ArrayList<f> bfA() {
        return this.eWF;
    }

    public void bfB() {
        Iterator<f> it = this.eWF.iterator();
        while (it.hasNext()) {
            it.next().qw(0);
        }
    }

    public void bC(List<?> list) {
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
                            this.eWF.add(fVar);
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
