package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.repackage.e77;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import protobuf.GetGroupMsg.DataReq;
import protobuf.GetGroupMsg.GetGroupMsgReqIdl;
import protobuf.GroupLastId;
import protobuf.NewpushRepair;
/* loaded from: classes3.dex */
public class MessageSyncMessage extends TbSocketMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int height;
    public LongSparseArray<Long> mMids;
    public NewpushRepair newpushRepire;
    public long notifyMsgId;
    public int smallHeight;
    public int smallWidth;
    public String syncTypeString;
    public int width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSyncMessage() {
        super(202003);
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
        this.mMids = null;
    }

    public static String groupLastIdToString(@Nullable GroupLastId groupLastId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, groupLastId)) == null) {
            if (groupLastId == null) {
                return "GroupLastId{null}";
            }
            return "GroupLastId{groupId=" + groupLastId.groupId + ", lastMsgId=" + groupLastId.lastMsgId + ", excludeMid=" + groupLastId.excludeMid + '}';
        }
        return (String) invokeL.objValue;
    }

    public static String groupMidsToString(@Nullable List<GroupLastId> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, list)) != null) {
            return (String) invokeL.objValue;
        }
        if (list == null) {
            return "[null]";
        }
        Iterator<GroupLastId> it = list.iterator();
        if (!it.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true) {
            sb.append(groupLastIdToString(it.next()));
            if (!it.hasNext()) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(',');
            sb.append(WebvttCueParser.CHAR_SPACE);
        }
    }

    public static String newpushRepairToString(@Nullable NewpushRepair newpushRepair) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, newpushRepair)) == null) {
            if (newpushRepair == null) {
                return "NewpushRepair{null}";
            }
            return "NewpushRepair{followType='" + newpushRepair.followType + "', groups=" + newpushRepair.groups + '}';
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.height = Integer.valueOf(getHeight());
            builder.width = Integer.valueOf(getWidth());
            builder.smallHeight = Integer.valueOf(getSmallHeight());
            builder.smallWidth = Integer.valueOf(getSmallWidth());
            builder.gettype = getSyncTypeString();
            builder.notify_msg_id = Long.valueOf(this.notifyMsgId);
            if (builder.groupMids == null) {
                builder.groupMids = new ArrayList();
            }
            long d = e77.e().d();
            boolean z = false;
            for (int i = 0; i < this.mMids.size(); i++) {
                long keyAt = this.mMids.keyAt(i);
                Long valueAt = this.mMids.valueAt(i);
                if (valueAt != null) {
                    GroupLastId.Builder builder2 = new GroupLastId.Builder();
                    builder2.groupId = Long.valueOf(keyAt);
                    builder2.lastMsgId = valueAt;
                    if (d == keyAt) {
                        builder2.excludeMid = e77.e().g();
                        z = true;
                    }
                    builder.groupMids.add(builder2.build(false));
                }
            }
            if (!z && e77.e().i()) {
                GroupLastId.Builder builder3 = new GroupLastId.Builder();
                builder3.groupId = Long.valueOf(d);
                builder3.lastMsgId = e77.e().f();
                builder3.excludeMid = e77.e().g();
                builder.groupMids.add(builder3.build(false));
            }
            builder.newpushRepire = getNewpushRepire();
            GetGroupMsgReqIdl.Builder builder4 = new GetGroupMsgReqIdl.Builder();
            builder4.cuid = TbadkCoreApplication.getUniqueIdentifier();
            builder4.data = builder.build(false);
            return builder4.build(false);
        }
        return invokeV.objValue;
    }

    public LongSparseArray<Long> getGroupMids() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMids : (LongSparseArray) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.height : invokeV.intValue;
    }

    public NewpushRepair getNewpushRepire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.newpushRepire : (NewpushRepair) invokeV.objValue;
    }

    public int getSmallHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.smallHeight : invokeV.intValue;
    }

    public int getSmallWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.smallWidth : invokeV.intValue;
    }

    public String getSyncTypeString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.syncTypeString : (String) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.width : invokeV.intValue;
    }

    public void setGroupMids(LongSparseArray<Long> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, longSparseArray) == null) {
            this.mMids = longSparseArray;
        }
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.height = i;
        }
    }

    public void setNewpushRepire(NewpushRepair newpushRepair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, newpushRepair) == null) {
            this.newpushRepire = newpushRepair;
        }
    }

    public void setNotifyMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.notifyMsgId = j;
        }
    }

    public void setSmallHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.smallHeight = i;
        }
    }

    public void setSmallWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.smallWidth = i;
        }
    }

    public void setSyncTypeString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.syncTypeString = str;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.width = i;
        }
    }
}
