package com.baidu.tieba.im.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.r0.d1.k0;
import c.a.r0.d1.n0;
import c.a.r0.d1.s;
import c.a.s0.s1.h.d;
import c.a.s0.s1.k.b;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class ValidateModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ValidateModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            } catch (JSONException e2) {
                e2.printStackTrace();
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

    public static void deleteValidateData(ValidateItemData validateItemData, s<Boolean> sVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, validateItemData, sVar) == null) || validateItemData == null) {
            return;
        }
        n0.c(new k0<Boolean>(validateItemData) { // from class: com.baidu.tieba.im.model.ValidateModel.3
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$data = validateItemData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.r0.d1.k0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.f().a(this.val$data.getNotice_id())) : (Boolean) invokeV.objValue;
            }
        }, sVar);
    }

    public static ValidateItemData getByNoticeid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? convertToValidateItemData(d.f().d(str)) : (ValidateItemData) invokeL.objValue;
    }

    public static void markShown(List<ValidateItemData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ValidateItemData validateItemData = list.get(i2);
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
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                    d.f().n(this.val$list);
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }.execute(new Void[0]);
    }

    public static void requestValidateDataCountFromDB(s<Integer> sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, sVar) == null) {
            n0.c(new k0<Integer>() { // from class: com.baidu.tieba.im.model.ValidateModel.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // c.a.r0.d1.k0
                public Integer doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Integer.valueOf(d.f().e("apply_join_group")) : (Integer) invokeV.objValue;
                }
            }, sVar);
        }
    }

    public static void requestValidateDataFromDB(int i2, int i3, s<LinkedList<GroupNewsPojo>> sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65543, null, i2, i3, sVar) == null) {
            n0.c(new k0<LinkedList<GroupNewsPojo>>(i2, i3) { // from class: com.baidu.tieba.im.model.ValidateModel.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int val$count;
                public final /* synthetic */ int val$offset;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$count = i2;
                    this.val$offset = i3;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // c.a.r0.d1.k0
                public LinkedList<GroupNewsPojo> doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.f().c(0L, this.val$count, this.val$offset, "apply_join_group") : (LinkedList) invokeV.objValue;
                }
            }, sVar);
        }
    }

    public static void setGroupName(ValidateItemData validateItemData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, validateItemData, str) == null) {
            if (!BdBaseApplication.getInst().isDebugMode() || m.B()) {
                ImMessageCenterPojo i2 = b.o().i(str, 1);
                validateItemData.setGroupName(i2 != null ? i2.getGroup_name() : "");
            }
        }
    }

    public static void updateValidateData(s<Boolean> sVar, ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, sVar, validateItemData) == null) || validateItemData == null) {
            return;
        }
        n0.c(new k0<Boolean>(validateItemData) { // from class: com.baidu.tieba.im.model.ValidateModel.1
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$data = validateItemData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.r0.d1.k0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.f().j(this.val$data)) : (Boolean) invokeV.objValue;
            }
        }, sVar);
    }
}
