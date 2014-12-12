package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.model.Hao123Model;
import com.baidu.tieba.tbadkCore.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class j {
    private boolean aso;
    private int level;
    private ArrayList<ab> likeForums = new ArrayList<>();

    public ArrayList<ab> Cu() {
        return this.likeForums;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public boolean Ch() {
        return this.aso;
    }

    public void Cv() {
        Iterator<ab> it = this.likeForums.iterator();
        while (it.hasNext()) {
            it.next().hB(0);
        }
    }

    public void i(List<?> list) {
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
                        ab abVar = new ab();
                        abVar.a((LikeForum) list.get(i));
                        if (abVar.getLevel() >= this.level) {
                            this.aso = true;
                        }
                        this.likeForums.add(abVar);
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
