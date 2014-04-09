package com.baidu.tieba.im.f;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.aa;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public final class h {
    public static void a(ImMessageCenterPojo imMessageCenterPojo) {
        com.baidu.tbadk.coreExtra.messageCenter.d.a().b(com.baidu.adp.lib.f.b.a(imMessageCenterPojo.getGid(), 0), imMessageCenterPojo.getPulled_msgId() / 100);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(imMessageCenterPojo.getGid(), 0L);
        com.baidu.tieba.im.r.a(new i(imMessageCenterPojo, linkedHashMap), new j(imMessageCenterPojo));
    }

    public static void a(String str) {
        com.baidu.tbadk.coreExtra.messageCenter.d.a().a(com.baidu.adp.lib.f.b.a(str, 0));
        com.baidu.tieba.im.db.i.a().b(str);
        com.baidu.tieba.im.pushNotify.a.d().a((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.r.a(new k(str), null);
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.im.r.a(new l(str, str2), new m(str, str2));
        }
    }

    public static void b(String str, String str2) {
        com.baidu.tieba.im.r.a(new n(str, str2), new o(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean b(String str) {
        if (aa.a().c(TbadkApplication.E(), str)) {
            aa.a().a(TbadkApplication.E(), str, false);
            aa.a().b(TbadkApplication.E(), str, false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.tieba.im.db.h.a();
        return com.baidu.tieba.im.db.d.a().a(str, "apply_join_group") & true & com.baidu.tieba.im.db.h.a(str) & com.baidu.tieba.im.db.c.a().e(str);
    }
}
