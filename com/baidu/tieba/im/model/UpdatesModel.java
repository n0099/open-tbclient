package com.baidu.tieba.im.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.hf5;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.lf5;
import com.baidu.tieba.oe5;
import com.baidu.tieba.u77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UpdatesModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<UpdatesItemData> dataToDelete;

    public UpdatesModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dataToDelete = new ArrayList();
    }

    public static UpdatesItemData convertToUpdatesItem(GroupNewsPojo groupNewsPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, groupNewsPojo)) == null) {
            String content = groupNewsPojo.getContent();
            if (TextUtils.isEmpty(content)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                if (true == jSONObject.isNull("notice_id")) {
                    UpdatesItemData updatesItemData = new UpdatesItemData();
                    updatesItemData.setNotice_id(groupNewsPojo.getNotice_id());
                    updatesItemData.setContent(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG));
                    JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                    if (optJSONObject == null) {
                        return null;
                    }
                    updatesItemData.setUpdatesType(groupNewsPojo.getCmd());
                    updatesItemData.setGroupHeadUrl(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_IMAGE));
                    updatesItemData.setGroupId(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID));
                    updatesItemData.setGroupName(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME));
                    updatesItemData.setAuthorId(optJSONObject.optString("                                                                                                                                                                   "));
                    updatesItemData.setAuthorName(optJSONObject.optString("authorName"));
                    updatesItemData.setTime(groupNewsPojo.getTime());
                    updatesItemData.setTitle(optJSONObject.optString("title"));
                    updatesItemData.setEventLink(optJSONObject.optString("eventLink"));
                    updatesItemData.setGroupActivityId(optJSONObject.optString("activityId"));
                    return updatesItemData;
                }
                return (UpdatesItemData) OrmObject.objectWithJsonStr(content, UpdatesItemData.class);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (UpdatesItemData) invokeL.objValue;
    }

    public static List<UpdatesItemData> convertToUpdatesItemData(LinkedList<GroupNewsPojo> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, linkedList)) == null) {
            LinkedList linkedList2 = new LinkedList();
            if (linkedList == null) {
                return linkedList2;
            }
            Iterator<GroupNewsPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                UpdatesItemData convertToUpdatesItem = convertToUpdatesItem(it.next());
                if (convertToUpdatesItem != null) {
                    linkedList2.add(convertToUpdatesItem);
                }
            }
            return linkedList2;
        }
        return (List) invokeL.objValue;
    }

    public static void deleteUpdatesData(UpdatesItemData updatesItemData, oe5<Boolean> oe5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, updatesItemData, oe5Var) == null) || updatesItemData == null) {
            return;
        }
        lf5.c(new hf5<Boolean>(updatesItemData) { // from class: com.baidu.tieba.im.model.UpdatesModel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UpdatesItemData val$data;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {updatesItemData};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$data = updatesItemData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tieba.hf5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(u77.f().a(this.val$data.getNotice_id())) : (Boolean) invokeV.objValue;
            }
        }, oe5Var);
    }

    public static void requestUpdatesDataFromDB(oe5<LinkedList<GroupNewsPojo>> oe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, oe5Var) == null) {
            lf5.c(new hf5<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.model.UpdatesModel.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.hf5
                public LinkedList<GroupNewsPojo> doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? u77.f().c(0L, Integer.MAX_VALUE, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change") : (LinkedList) invokeV.objValue;
                }
            }, oe5Var);
        }
    }

    public static void updateUpdatesData(oe5<Boolean> oe5Var, UpdatesItemData... updatesItemDataArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, oe5Var, updatesItemDataArr) == null) || updatesItemDataArr == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (UpdatesItemData updatesItemData : updatesItemDataArr) {
            linkedList.add(updatesItemData.toGroupNewsPojo());
        }
        lf5.c(new hf5<Boolean>(linkedList) { // from class: com.baidu.tieba.im.model.UpdatesModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LinkedList val$list;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {linkedList};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$list = linkedList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tieba.hf5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? u77.f().m(this.val$list) : (Boolean) invokeV.objValue;
            }
        }, oe5Var);
    }

    public void addSelect(UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, updatesItemData) == null) {
            this.dataToDelete.add(updatesItemData);
        }
    }

    public void calculateSelects(List<UpdatesItemData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
            return;
        }
        for (UpdatesItemData updatesItemData : list) {
            if (updatesItemData.isSelected()) {
                this.dataToDelete.add(updatesItemData);
            }
        }
    }

    public void cancelSelect(UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, updatesItemData) == null) {
            this.dataToDelete.remove(updatesItemData);
        }
    }

    public void clearSelect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.dataToDelete.clear();
        }
    }

    public void deleteDatas(oe5<Boolean> oe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oe5Var) == null) {
            lf5.c(new hf5<Boolean>(this) { // from class: com.baidu.tieba.im.model.UpdatesModel.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UpdatesModel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.hf5
                public Boolean doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(u77.f().b(this.this$0.dataToDelete)) : (Boolean) invokeV.objValue;
                }
            }, oe5Var);
        }
    }

    public String deleteDatasIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            List<UpdatesItemData> list = this.dataToDelete;
            if (list == null || list.size() == 0) {
                return null;
            }
            int size = this.dataToDelete.size();
            for (int i = 0; i < size; i++) {
                UpdatesItemData updatesItemData = this.dataToDelete.get(i);
                if (updatesItemData != null && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
                    stringBuffer.append(Long.parseLong(updatesItemData.getNotice_id()) / 100);
                    if (i < size - 1) {
                        stringBuffer.append(",");
                    }
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            clearSelect();
        }
    }

    public int getDeleteSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.dataToDelete.size() : invokeV.intValue;
    }
}
