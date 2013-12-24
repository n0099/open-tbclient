package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.br;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ ag a;

    private ap(ag agVar) {
        this.a = agVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ap(ag agVar, ah ahVar) {
        this(agVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        com.baidu.tieba.im.message.n l;
        String[] split;
        if (nVar != null) {
            if (nVar.t() == 103112) {
                if (nVar instanceof br) {
                    br brVar = (br) nVar;
                    if (!brVar.i() && (l = brVar.l()) != null && (l instanceof com.baidu.tieba.im.message.ak)) {
                        String c = ((com.baidu.tieba.im.message.ak) l).c();
                        if (!TextUtils.isEmpty(c) && (split = c.split(",")) != null && split.length != 0) {
                            String id = TiebaApplication.F().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        this.a.a(brVar.a());
                                        com.baidu.tieba.im.m.a(new aq(this, brVar), null);
                                        ag.a().a(brVar.a());
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (nVar.t() == 103101 && (nVar instanceof com.baidu.tieba.im.message.av)) {
                com.baidu.tieba.im.message.av avVar = (com.baidu.tieba.im.message.av) nVar;
                if (!avVar.i()) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    com.baidu.tieba.im.message.v vVar = (com.baidu.tieba.im.message.v) avVar.l();
                    imMessageCenterPojo.setGroup_name(vVar.c());
                    imMessageCenterPojo.setGroup_type(vVar.i());
                    imMessageCenterPojo.setGroup_head(vVar.e());
                    AddGroupInfoData a = avVar.a();
                    if (a != null) {
                        imMessageCenterPojo.setGid(String.valueOf(a.getGroupId()));
                        LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
                        linkedHashMap.put(imMessageCenterPojo.getGid(), 0L);
                        d.a().a(linkedHashMap, (com.baidu.tieba.im.a<Void>) null);
                        t.a().a(imMessageCenterPojo, (com.baidu.tieba.im.a<Boolean>) null);
                        ag.a().b(imMessageCenterPojo);
                    }
                }
            }
        }
    }
}
