package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.model.Hao123Model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class z {
    private boolean aly;
    private int level;
    private ArrayList<y> likeForums = new ArrayList<>();

    public ArrayList<y> zz() {
        return this.likeForums;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public boolean yV() {
        return this.aly;
    }

    public void zA() {
        Iterator<y> it = this.likeForums.iterator();
        while (it.hasNext()) {
            it.next().ec(0);
        }
    }

    public void A(List<?> list) {
        if (list != null) {
            a(list, null);
        }
    }

    public void a(List<?> list, Context context) {
        if (list != null) {
            try {
                Hao123Model.setHao123Cache(Hao123Model.getHao123JosnStr(Hao123Model.parserLikeForumsProtoBuf(list)));
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) instanceof LikeForum) {
                        y yVar = new y();
                        yVar.a((LikeForum) list.get(i));
                        if (yVar.getLevel() >= this.level) {
                            this.aly = true;
                        }
                        this.likeForums.add(yVar);
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
