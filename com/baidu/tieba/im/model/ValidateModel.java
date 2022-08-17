package com.baidu.tieba.im.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cf5;
import com.repackage.gf5;
import com.repackage.je5;
import com.repackage.l87;
import com.repackage.o77;
import com.repackage.qi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ValidateModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ValidateModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ValidateItemData convertToValidateItemData(GroupNewsPojo groupNewsPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, groupNewsPojo)) == null) {
            if (groupNewsPojo == null) {
                return null;
            }
            String content = groupNewsPojo.getContent();
            if (TextUtils.isEmpty(content)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                if (true == jSONObject.isNull("notice_id")) {
                    ValidateItemData validateItemData = new ValidateItemData();
                    validateItemData.setNotice_id(groupNewsPojo.getNotice_id());
                    validateItemData.setApplyReason(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG));
                    validateItemData.setApplyTime(groupNewsPojo.getTime());
                    JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                    if (optJSONObject == null) {
                        return null;
                    }
                    validateItemData.setUserName(optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
                    validateItemData.setPortrait(optJSONObject.optString("portrait"));
                    String optString = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                    validateItemData.setGroupId(optString);
                    setGroupName(validateItemData, optString);
                    validateItemData.setUserId(optJSONObject.optString("userId"));
                    validateItemData.setInviterUserId(optJSONObject.optLong(ApplyJoinGroupActivityConfig.INVITE_USER_ID));
                    validateItemData.setJoinType(optJSONObject.optInt(ApplyJoinGroupActivityConfig.JOIN_TYPE));
                    validateItemData.setExt(groupNewsPojo.getExt());
                    return validateItemData;
                }
                ValidateItemData validateItemData2 = (ValidateItemData) OrmObject.objectWithJsonStr(content, ValidateItemData.class);
                setGroupName(validateItemData2, validateItemData2.getGroupId());
                return validateItemData2;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (ValidateItemData) invokeL.objValue;
    }

    public static List<ValidateItemData> convertToValidateItemDataList(LinkedList<GroupNewsPojo> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, linkedList)) == null) {
            LinkedList linkedList2 = new LinkedList();
            if (linkedList == null) {
                return linkedList2;
            }
            Iterator<GroupNewsPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                ValidateItemData convertToValidateItemData = convertToValidateItemData(it.next());
                if (convertToValidateItemData != null) {
                    linkedList2.add(convertToValidateItemData);
                }
            }
            return linkedList2;
        }
        return (List) invokeL.objValue;
    }

    public static void deleteValidateData(ValidateItemData validateItemData, je5<Boolean> je5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, validateItemData, je5Var) == null) || validateItemData == null) {
            return;
        }
        gf5.c(new cf5<Boolean>(validateItemData) { // from class: com.baidu.tieba.im.model.ValidateModel.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ValidateItemData val$data;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {validateItemData};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$data = validateItemData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.repackage.cf5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(o77.f().a(this.val$data.getNotice_id())) : (Boolean) invokeV.objValue;
            }
        }, je5Var);
    }

    public static ValidateItemData getByNoticeid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? convertToValidateItemData(o77.f().d(str)) : (ValidateItemData) invokeL.objValue;
    }

    public static void markShown(List<ValidateItemData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ValidateItemData validateItemData = list.get(i);
            if (validateItemData != null && !validateItemData.isShown()) {
                validateItemData.setShown(true);
                linkedList.add(new GroupNewsPojo(validateItemData));
            }
        }
        new BdAsyncTask<Void, Void, Void>(linkedList) { // from class: com.baidu.tieba.im.model.ValidateModel.2
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$list = linkedList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                    o77.f().m(this.val$list);
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }.execute(new Void[0]);
    }

    public static void requestValidateDataCountFromDB(je5<Integer> je5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, je5Var) == null) {
            gf5.c(new cf5<Integer>() { // from class: com.baidu.tieba.im.model.ValidateModel.5
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
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.repackage.cf5
                public Integer doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Integer.valueOf(o77.f().e("apply_join_group")) : (Integer) invokeV.objValue;
                }
            }, je5Var);
        }
    }

    public static void requestValidateDataFromDB(int i, int i2, je5<LinkedList<GroupNewsPojo>> je5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65543, null, i, i2, je5Var) == null) {
            gf5.c(new cf5<LinkedList<GroupNewsPojo>>(i, i2) { // from class: com.baidu.tieba.im.model.ValidateModel.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int val$count;
                public final /* synthetic */ int val$offset;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$count = i;
                    this.val$offset = i2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.repackage.cf5
                public LinkedList<GroupNewsPojo> doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? o77.f().c(0L, this.val$count, this.val$offset, "apply_join_group") : (LinkedList) invokeV.objValue;
                }
            }, je5Var);
        }
    }

    public static void setGroupName(ValidateItemData validateItemData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, validateItemData, str) == null) {
            if (!BdBaseApplication.getInst().isDebugMode() || qi.C()) {
                ImMessageCenterPojo i = l87.o().i(str, 1);
                validateItemData.setGroupName(i != null ? i.getGroup_name() : "");
            }
        }
    }

    public static void updateValidateData(je5<Boolean> je5Var, ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, je5Var, validateItemData) == null) || validateItemData == null) {
            return;
        }
        gf5.c(new cf5<Boolean>(validateItemData) { // from class: com.baidu.tieba.im.model.ValidateModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ValidateItemData val$data;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {validateItemData};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$data = validateItemData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.repackage.cf5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(o77.f().j(this.val$data)) : (Boolean) invokeV.objValue;
            }
        }, je5Var);
    }
}
