package com.baidu.tieba.im.db;

import cn.jingling.lib.file.Shared;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.validate.ValidateItemData;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ValidateItemData f1677a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, ValidateItemData validateItemData) {
        this.b = lVar;
        this.f1677a = validateItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        int i;
        int i2 = 0;
        List<ValidateItemData> a2 = com.baidu.tieba.im.validate.l.a(this.b.a(0L, Shared.INFINITY, 0, "apply_join_group"));
        int size = a2.size();
        LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
        int i3 = 0;
        while (i2 < size) {
            ValidateItemData validateItemData = a2.get(i2);
            if (validateItemData.getGroupId().equals(this.f1677a.getGroupId()) && validateItemData.getUserId().equals(this.f1677a.getUserId()) && this.f1677a.isPass()) {
                validateItemData.setPass(true);
                if (this.f1677a.isShown()) {
                    validateItemData.setShown(true);
                }
                linkedList.add(validateItemData.toGroupNewsPojo());
                i = i3 + 1;
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        com.baidu.adp.lib.h.e.d("affectCount:" + i3);
        return this.b.a(linkedList);
    }
}
