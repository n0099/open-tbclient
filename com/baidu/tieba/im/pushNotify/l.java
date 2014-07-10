package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Comparator<ImMessageCenterShowItemData> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ImMessageCenterShowItemData imMessageCenterShowItemData, ImMessageCenterShowItemData imMessageCenterShowItemData2) {
        if (imMessageCenterShowItemData.getServerTime() < imMessageCenterShowItemData2.getServerTime()) {
            return 1;
        }
        if (imMessageCenterShowItemData.getServerTime() > imMessageCenterShowItemData2.getServerTime()) {
            return -1;
        }
        return 0;
    }
}
