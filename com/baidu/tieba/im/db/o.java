package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ad;
import com.baidu.tieba.im.message.az;
import com.baidu.tieba.im.message.bm;
import com.baidu.tieba.im.message.cp;
import com.baidu.tieba.im.message.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ l a;

    private o(l lVar) {
        this.a = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(l lVar, byte b) {
        this(lVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        s o;
        String[] split;
        if (sVar != null) {
            if (sVar.v() == 103112) {
                if (sVar instanceof cp) {
                    cp cpVar = (cp) sVar;
                    if (!cpVar.l() && (o = cpVar.o()) != null && (o instanceof az)) {
                        String c = ((az) o).c();
                        if (!TextUtils.isEmpty(c) && (split = c.split(",")) != null && split.length != 0) {
                            String id = TiebaApplication.y().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        this.a.a(cpVar.a());
                                        com.baidu.tieba.im.i.a(new p(this, cpVar), null);
                                        l.a().a(cpVar.a());
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (sVar.v() == 103101 && (sVar instanceof bm)) {
                bm bmVar = (bm) sVar;
                if (!bmVar.l()) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    ad adVar = (ad) bmVar.o();
                    imMessageCenterPojo.setGroup_name(adVar.b());
                    imMessageCenterPojo.setGroup_type(adVar.d());
                    AddGroupInfoData a = bmVar.a();
                    if (a != null) {
                        imMessageCenterPojo.setGroup_head(a.getPortrait());
                        imMessageCenterPojo.setGid(String.valueOf(a.getGroupId()));
                        com.baidu.tieba.im.util.d.a(imMessageCenterPojo);
                    }
                }
            }
        }
    }
}
