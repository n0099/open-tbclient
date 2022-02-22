package com.baidu.tieba.enterForum.home;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.b;
import c.a.t0.d1.c0;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ForumRecommend.DataReq;
import tbclient.ForumRecommend.ForumRecommendReqIdl;
/* loaded from: classes12.dex */
public class forumRecommendRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Integer like_forum;
    public LinkedList<VisitedForumData> mForumData;
    public Integer recommend;
    public Integer sortType;
    public Integer topic;
    public String visit_history;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public forumRecommendRequestMessage() {
        super(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.like_forum = get_like_forum();
                builder.topic = get_topic();
                builder.recommend = get_recommend();
                builder.sort_type = get_sortType();
                JSONArray jSONArray = new JSONArray();
                if (this.mForumData != null) {
                    Iterator<VisitedForumData> it = this.mForumData.iterator();
                    while (it.hasNext()) {
                        VisitedForumData next = it.next();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("forum_id", b.g(next.getForumId(), 0L));
                        jSONObject.put("visit_time", next.E());
                        jSONArray.put(jSONObject);
                    }
                }
                builder.visit_history = jSONArray.toString();
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    c0.a(builder, true);
                }
                ForumRecommendReqIdl.Builder builder2 = new ForumRecommendReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public Integer get_like_forum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.like_forum : (Integer) invokeV.objValue;
    }

    public Integer get_recommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.recommend : (Integer) invokeV.objValue;
    }

    public Integer get_sortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sortType : (Integer) invokeV.objValue;
    }

    public Integer get_topic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.topic : (Integer) invokeV.objValue;
    }

    public String get_visit_history() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.visit_history : (String) invokeV.objValue;
    }

    public void setForumData(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, linkedList) == null) {
            this.mForumData = linkedList;
        }
    }

    public void set_like_forum(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, num) == null) {
            this.like_forum = num;
        }
    }

    public void set_recommend(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, num) == null) {
            this.recommend = num;
        }
    }

    public void set_sortType(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, num) == null) {
            this.sortType = num;
        }
    }

    public void set_topic(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, num) == null) {
            this.topic = num;
        }
    }

    public void set_visit_history(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.visit_history = str;
        }
    }
}
