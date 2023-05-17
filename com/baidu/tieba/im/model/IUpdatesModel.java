package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
/* loaded from: classes6.dex */
public interface IUpdatesModel {
    UpdatesItemData convertToUpdatesItem(GroupNewsPojo groupNewsPojo);
}
