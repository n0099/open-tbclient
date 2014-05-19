package com.baidu.tieba.im.f;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.bw;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.aa;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class i {
    public static void a(ImMessageCenterPojo imMessageCenterPojo) {
        com.baidu.tbadk.coreExtra.messageCenter.e.a().b(com.baidu.adp.lib.f.b.a(imMessageCenterPojo.getGid(), 0), bw.c(imMessageCenterPojo.getPulled_msgId()));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(imMessageCenterPojo.getGid(), 0L);
        com.baidu.tieba.im.i.a(new j(imMessageCenterPojo, linkedHashMap), new k(imMessageCenterPojo));
    }

    public static void a(String str) {
        com.baidu.tbadk.coreExtra.messageCenter.e.a().a(com.baidu.adp.lib.f.b.a(str, 0));
        com.baidu.tieba.im.db.i.a().b(str);
        com.baidu.tieba.im.pushNotify.a.f().b((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.i.a(new l(str), null);
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.im.i.a(new m(str, str2), new n(str, str2));
        }
    }

    public static void b(String str, String str2) {
        com.baidu.tieba.im.i.a(new o(str, str2), new p(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str) {
        if (aa.a().c(TbadkApplication.getCurrentAccount(), str)) {
            aa.a().a(TbadkApplication.getCurrentAccount(), str, false);
            aa.a().b(TbadkApplication.getCurrentAccount(), str, false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true & com.baidu.tieba.im.db.d.a().a(str, "apply_join_group") & com.baidu.tieba.im.db.h.a().a(str) & com.baidu.tieba.im.db.c.a().e(str);
    }
}
