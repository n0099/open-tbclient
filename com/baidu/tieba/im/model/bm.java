package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.Comparator;
/* loaded from: classes.dex */
class bm implements Comparator<ImMessageCenterShowItemData> {
    final /* synthetic */ bi a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bi biVar) {
        this.a = biVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ImMessageCenterShowItemData imMessageCenterShowItemData, ImMessageCenterShowItemData imMessageCenterShowItemData2) {
        if (imMessageCenterShowItemData == null || imMessageCenterShowItemData2 == null) {
            return 0;
        }
        if (imMessageCenterShowItemData.getServerTime() < imMessageCenterShowItemData2.getServerTime()) {
            return 1;
        }
        return imMessageCenterShowItemData.getServerTime() > imMessageCenterShowItemData2.getServerTime() ? -1 : 0;
    }
}
