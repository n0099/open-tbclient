package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public interface IValidateModel {
    ValidateItemData convertToValidateItemData(GroupNewsPojo groupNewsPojo);

    List<ValidateItemData> convertToValidateItemDataList(LinkedList<GroupNewsPojo> linkedList);
}
