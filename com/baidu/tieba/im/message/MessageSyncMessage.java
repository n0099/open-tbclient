package com.baidu.tieba.im.message;

import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.j1.o.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import protobuf.GetGroupMsg.DataReq;
import protobuf.GetGroupMsg.GetGroupMsgReqIdl;
import protobuf.GroupLastId;
import protobuf.NewpushRepair;
/* loaded from: classes7.dex */
public class MessageSyncMessage extends TbSocketMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int height;
    public boolean isForTimer;
    public LongSparseArray<Long> mMids;
    public NewpushRepair newpushRepire;
    public String notifyMaxTime;
    public String notifyMinTime;
    public String processType;
    public String pushTimes;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMids = null;
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
            builder.pushTimes = getPushTimes();
            builder.min_time = getNotifyMinTime();
            builder.max_time = getNotifyMaxTime();
            builder.gettype = getSyncTypeString();
            builder.process_type = getProcessType();
            if (builder.groupMids == null) {
                builder.groupMids = new ArrayList();
            }
            long d2 = c.e().d();
            boolean z = false;
            for (int i2 = 0; i2 < this.mMids.size(); i2++) {
                long keyAt = this.mMids.keyAt(i2);
                Long valueAt = this.mMids.valueAt(i2);
                if (valueAt != null) {
                    GroupLastId.Builder builder2 = new GroupLastId.Builder();
                    builder2.groupId = Long.valueOf(keyAt);
                    builder2.lastMsgId = valueAt;
                    if (d2 == keyAt) {
                        builder2.excludeMid = c.e().g();
                        z = true;
                    }
                    builder.groupMids.add(builder2.build(false));
                }
            }
            if (!z && c.e().i()) {
                GroupLastId.Builder builder3 = new GroupLastId.Builder();
                builder3.groupId = Long.valueOf(d2);
                builder3.lastMsgId = c.e().f();
                builder3.excludeMid = c.e().g();
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

    public String getNotifyMaxTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.notifyMaxTime : (String) invokeV.objValue;
    }

    public String getNotifyMinTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.notifyMinTime : (String) invokeV.objValue;
    }

    public String getProcessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.processType : (String) invokeV.objValue;
    }

    public String getPushTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.pushTimes : (String) invokeV.objValue;
    }

    public int getSmallHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.smallHeight : invokeV.intValue;
    }

    public int getSmallWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.smallWidth : invokeV.intValue;
    }

    public String getSyncTypeString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.syncTypeString : (String) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.width : invokeV.intValue;
    }

    public boolean isForTimer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.isForTimer : invokeV.booleanValue;
    }

    public void setForTimer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isForTimer = z;
        }
    }

    public void setGroupMids(LongSparseArray<Long> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, longSparseArray) == null) {
            this.mMids = longSparseArray;
        }
    }

    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.height = i2;
        }
    }

    public void setNewpushRepire(NewpushRepair newpushRepair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, newpushRepair) == null) {
            this.newpushRepire = newpushRepair;
        }
    }

    public void setNotifyMaxTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.notifyMaxTime = str;
        }
    }

    public void setNotifyMinTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.notifyMinTime = str;
        }
    }

    public void setProcessType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.processType = str;
        }
    }

    public void setPushTimes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.pushTimes = str;
        }
    }

    public void setSmallHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.smallHeight = i2;
        }
    }

    public void setSmallWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.smallWidth = i2;
        }
    }

    public void setSyncTypeString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.syncTypeString = str;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.width = i2;
        }
    }
}
