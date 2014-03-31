package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.Comparator;
/* loaded from: classes.dex */
final class v implements Comparator<ImMessageCenterShowItemData> {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(p pVar) {
        this.a = pVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(ImMessageCenterShowItemData imMessageCenterShowItemData, ImMessageCenterShowItemData imMessageCenterShowItemData2) {
        ImMessageCenterShowItemData imMessageCenterShowItemData3 = imMessageCenterShowItemData;
        ImMessageCenterShowItemData imMessageCenterShowItemData4 = imMessageCenterShowItemData2;
        if (imMessageCenterShowItemData3 == null || imMessageCenterShowItemData4 == null) {
            return 0;
        }
        if (imMessageCenterShowItemData3.getServerTime() < imMessageCenterShowItemData4.getServerTime()) {
            return 1;
        }
        return imMessageCenterShowItemData3.getServerTime() > imMessageCenterShowItemData4.getServerTime() ? -1 : 0;
    }
}
