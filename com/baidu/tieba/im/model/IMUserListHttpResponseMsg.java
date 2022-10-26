package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.da7;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.ps4;
import com.baidu.tieba.ua7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMUserListHttpResponseMsg extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap changedList;
    public List userDataResultList;

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

    public List getUserDataResultList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.userDataResultList;
        }
        return (List) invokeV.objValue;
    }

    private void saveToMemoryAndDb(List list) {
        ImMessageCenterPojo g;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, list) == null) {
            this.changedList = new HashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                UserData userData = (UserData) it.next();
                if (userData != null && !TextUtils.isEmpty(userData.getUserId()) && (g = da7.f().g(userData.getUserId(), 2)) != null && g.getCustomGroupType() == 2) {
                    boolean z = false;
                    boolean z2 = true;
                    if (!TextUtils.isEmpty(userData.getName_show()) && !userData.getName_show().equals(g.getNameShow())) {
                        g.setNameShow(userData.getName_show());
                        z = true;
                    }
                    if (!TextUtils.isEmpty(userData.getPortrait()) && !userData.getPortrait().equals(g.getGroup_head())) {
                        g.setGroup_head(userData.getPortrait());
                        z = true;
                    }
                    if (g.getIsFriend() != userData.getRelation()) {
                        g.setIsFriend(userData.getRelation());
                        z = true;
                    }
                    ps4 ps4Var = new ps4();
                    ps4Var.b(userData);
                    if (g.getImUserExtraData() == null) {
                        g.setImUserExtraData(ps4Var);
                    } else {
                        String c = ps4Var.c();
                        String c2 = g.getImUserExtraData().c();
                        if (c != null && !c.equals(c2)) {
                            g.setImUserExtraData(ps4Var);
                        } else {
                            z2 = z;
                        }
                    }
                    if (z2) {
                        this.changedList.put(userData.getUserId(), g);
                        da7.f().k(g);
                        ImMessageCenterPojo i = ua7.o().i(g.getGid(), 2);
                        if (i != null) {
                            i.setNameShow(g.getNameShow());
                            i.setGroup_head(g.getGroup_head());
                            i.setIsFriend(g.getIsFriend());
                            i.setImUserExtraData(g.getImUserExtraData());
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
