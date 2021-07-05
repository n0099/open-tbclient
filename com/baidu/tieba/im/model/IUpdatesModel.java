package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
/* loaded from: classes5.dex */
public interface IUpdatesModel {
    UpdatesItemData convertToUpdatesItem(GroupNewsPojo groupNewsPojo);
}
