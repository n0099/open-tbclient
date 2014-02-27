package com.baidu.tieba.im.groupUpdates;

import cn.jingling.lib.file.Shared;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends com.baidu.tieba.im.b<LinkedList<GroupNewsPojo>> {
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ LinkedList<GroupNewsPojo> a() {
        return com.baidu.tieba.im.db.c.a().a(0L, Shared.INFINITY, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change");
    }
}
