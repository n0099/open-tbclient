package com.baidu.tieba.enterForum.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes22.dex */
public class g {
    private ArrayList<f> hQv = new ArrayList<>();

    public ArrayList<f> clE() {
        return this.hQv;
    }

    public void clF() {
        Iterator<f> it = this.hQv.iterator();
        while (it.hasNext()) {
            it.next().wZ(0);
        }
    }

    public void aT(List<?> list) {
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
                            this.hQv.add(fVar);
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
