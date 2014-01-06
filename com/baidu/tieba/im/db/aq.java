package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.bu;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ ag a;

    private aq(ag agVar) {
        this.a = agVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aq(ag agVar, ah ahVar) {
        this(agVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        com.baidu.tieba.im.message.o l;
        String[] split;
        if (oVar != null) {
            if (oVar.u() == 103112) {
                if (oVar instanceof bu) {
                    bu buVar = (bu) oVar;
                    if (!buVar.i() && (l = buVar.l()) != null && (l instanceof com.baidu.tieba.im.message.an)) {
                        String c = ((com.baidu.tieba.im.message.an) l).c();
                        if (!TextUtils.isEmpty(c) && (split = c.split(",")) != null && split.length != 0) {
                            String id = TiebaApplication.F().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        this.a.a(buVar.a());
                                        com.baidu.tieba.im.m.a(new ar(this, buVar), null);
                                        ag.a().a(buVar.a());
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (oVar.u() == 103101 && (oVar instanceof com.baidu.tieba.im.message.ay)) {
                com.baidu.tieba.im.message.ay ayVar = (com.baidu.tieba.im.message.ay) oVar;
                if (!ayVar.i()) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    com.baidu.tieba.im.message.y yVar = (com.baidu.tieba.im.message.y) ayVar.l();
                    imMessageCenterPojo.setGroup_name(yVar.c());
                    imMessageCenterPojo.setGroup_type(yVar.i());
                    AddGroupInfoData a = ayVar.a();
                    if (a != null) {
                        imMessageCenterPojo.setGroup_head(a.getPortrait());
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
