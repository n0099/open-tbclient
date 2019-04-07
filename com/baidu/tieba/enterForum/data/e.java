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
    private ArrayList<d> eBI = new ArrayList<>();

    public ArrayList<d> aWr() {
        return this.eBI;
    }

    public void aWs() {
        Iterator<d> it = this.eBI.iterator();
        while (it.hasNext()) {
            it.next().oZ(0);
        }
    }

    public void bs(List<?> list) {
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
                            this.eBI.add(dVar);
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
