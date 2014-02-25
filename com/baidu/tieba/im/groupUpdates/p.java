package com.baidu.tieba.im.groupUpdates;

import cn.jingling.lib.file.Shared;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.c<LinkedList<GroupNewsPojo>> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public LinkedList<GroupNewsPojo> b() {
        return com.baidu.tieba.im.db.c.a().a(0L, Shared.INFINITY, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change");
    }
}
