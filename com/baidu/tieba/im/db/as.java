package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.bg;
import com.baidu.tieba.im.message.cg;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ ah a;

    private as(ah ahVar) {
        this.a = ahVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ as(ah ahVar, ai aiVar) {
        this(ahVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        com.baidu.tieba.im.message.q n;
        String[] split;
        if (qVar != null) {
            if (qVar.w() == 103112) {
                if (qVar instanceof cg) {
                    cg cgVar = (cg) qVar;
                    if (!cgVar.k() && (n = cgVar.n()) != null && (n instanceof com.baidu.tieba.im.message.at)) {
                        String c = ((com.baidu.tieba.im.message.at) n).c();
                        if (!TextUtils.isEmpty(c) && (split = c.split(",")) != null && split.length != 0) {
                            String id = TiebaApplication.E().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        this.a.a(cgVar.a());
                                        com.baidu.tieba.im.m.a(new at(this, cgVar), null);
                                        ah.a().a(cgVar.a());
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (qVar.w() == 103101 && (qVar instanceof bg)) {
                bg bgVar = (bg) qVar;
                if (!bgVar.k()) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    com.baidu.tieba.im.message.aa aaVar = (com.baidu.tieba.im.message.aa) bgVar.n();
                    imMessageCenterPojo.setGroup_name(aaVar.c());
                    imMessageCenterPojo.setGroup_type(aaVar.i());
                    AddGroupInfoData a = bgVar.a();
                    if (a != null) {
                        imMessageCenterPojo.setGroup_head(a.getPortrait());
                        imMessageCenterPojo.setGid(String.valueOf(a.getGroupId()));
                        LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
                        linkedHashMap.put(imMessageCenterPojo.getGid(), 0L);
                        d.a().a(linkedHashMap, (com.baidu.tieba.im.a<Void>) null);
                        t.a().a(imMessageCenterPojo, (com.baidu.tieba.im.a<Boolean>) null);
                        ah.a().b(imMessageCenterPojo);
                    }
                }
            }
        }
    }
}
