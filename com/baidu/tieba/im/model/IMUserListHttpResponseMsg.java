package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.immessagecenter.service.ImAiBotDbService;
import com.baidu.tieba.mg8;
import com.baidu.tieba.qe8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMUserListHttpResponseMsg extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ImMessageCenterPojo> changedList;
    public List<UserData> userDataResultList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMUserListHttpResponseMsg() {
        super(CmdConfigHttp.CMD_GET_USER_LIST);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public List<UserData> getUserDataResultList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.userDataResultList;
        }
        return (List) invokeV.objValue;
    }

    private void saveToMemoryAndDb(List<UserData> list) {
        ImMessageCenterPojo g;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, list) == null) {
            this.changedList = new HashMap<>();
            for (UserData userData : list) {
                if (userData != null && !TextUtils.isEmpty(userData.getUserId()) && (g = qe8.f().g(userData.getUserId(), 2)) != null && g.getCustomGroupType() == 2) {
                    boolean z2 = false;
                    boolean z3 = true;
                    if (!TextUtils.isEmpty(userData.getName_show()) && !userData.getName_show().equals(g.getNameShow())) {
                        g.setNameShow(userData.getName_show());
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(userData.getPortrait()) && !userData.getPortrait().equals(g.getGroup_head())) {
                        g.setGroup_head(userData.getPortrait());
                        z = true;
                    }
                    if (g.getIsFriend() != userData.getRelation()) {
                        g.setIsFriend(userData.getRelation());
                        z = true;
                    }
                    IMUserExtraData iMUserExtraData = new IMUserExtraData();
                    iMUserExtraData.setUserData(userData);
                    if (g.getImUserExtraData() == null) {
                        g.setImUserExtraData(iMUserExtraData);
                    } else {
                        String json = iMUserExtraData.toJson();
                        String json2 = g.getImUserExtraData().toJson();
                        if (json != null && !json.equals(json2)) {
                            g.setImUserExtraData(iMUserExtraData);
                        } else {
                            z3 = z;
                        }
                    }
                    if (!ImAiBotDbService.a.a().d(g.getGid())) {
                        z2 = z3;
                    }
                    if (z2) {
                        this.changedList.put(userData.getUserId(), g);
                        qe8.f().k(g);
                        ImMessageCenterPojo h = mg8.n().h(g.getGid(), 2);
                        if (h != null) {
                            h.setNameShow(g.getNameShow());
                            h.setGroup_head(g.getGroup_head());
                            h.setIsFriend(g.getIsFriend());
                            h.setImUserExtraData(g.getImUserExtraData());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error < 0 || jSONObject == null || (optJSONArray = jSONObject.optJSONArray("user_list")) == null) {
                return;
            }
            this.userDataResultList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                UserData userData = new UserData();
                userData.parserJson(optJSONArray.optJSONObject(i2));
                this.userDataResultList.add(userData);
            }
            saveToMemoryAndDb(this.userDataResultList);
        }
    }
}
