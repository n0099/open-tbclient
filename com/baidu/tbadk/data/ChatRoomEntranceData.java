package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Loop.ChatroomFrsRes;
import tbclient.Loop.ChatroomList;
/* loaded from: classes4.dex */
public class ChatRoomEntranceData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2669260759526247252L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ChatRoomInfoData> chatRoomInfoList;
    public Integer hotListOriginNum;
    public List<Long> hotRoomList;

    public ChatRoomEntranceData() {
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

    public List<ChatRoomInfoData> getChatRoomInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.chatRoomInfoList;
        }
        return (List) invokeV.objValue;
    }

    public int getHotListOriginNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.hotListOriginNum.intValue();
        }
        return invokeV.intValue;
    }

    public List<Long> getHotRoomList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.hotRoomList;
        }
        return (List) invokeV.objValue;
    }

    public void parserProtobuf(ChatroomFrsRes chatroomFrsRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, chatroomFrsRes) != null) || chatroomFrsRes == null) {
            return;
        }
        List<Long> list = chatroomFrsRes.hot_list;
        if (list != null) {
            this.hotRoomList = list;
        }
        List<ChatroomList> list2 = chatroomFrsRes.room_list;
        if (list2 != null && !ListUtils.isEmpty(list2)) {
            if (this.chatRoomInfoList == null) {
                this.chatRoomInfoList = new ArrayList();
            }
            this.chatRoomInfoList.clear();
            for (ChatroomList chatroomList : chatroomFrsRes.room_list) {
                ChatRoomInfoData chatRoomInfoData = new ChatRoomInfoData();
                chatRoomInfoData.parseProto(chatroomList);
                this.chatRoomInfoList.add(chatRoomInfoData);
            }
        }
        this.hotListOriginNum = chatroomFrsRes.hot_list_origin_num;
    }
}
