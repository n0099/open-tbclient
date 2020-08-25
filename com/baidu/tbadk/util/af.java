package com.baidu.tbadk.util;

import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class af {
    private boolean eev;
    private List<com.baidu.tieba.card.data.d> list = new LinkedList();

    public List<com.baidu.tieba.card.data.d> j(List<PbLinkData> list, List<PbGoodsData> list2) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                PbLinkData pbLinkData = list.get(i);
                if (pbLinkData.urlType == 2 && !this.eev) {
                    this.eev = true;
                }
                this.list.add(pbLinkData);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(list2)) {
            this.eev = true;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                this.list.add(list2.get(i2));
            }
        }
        Collections.sort(this.list, new Comparator<com.baidu.tieba.card.data.d>() { // from class: com.baidu.tbadk.util.af.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(com.baidu.tieba.card.data.d dVar, com.baidu.tieba.card.data.d dVar2) {
                return dVar.sort() - dVar2.sort();
            }
        });
        return this.list;
    }

    public boolean bvK() {
        return this.eev;
    }
}
