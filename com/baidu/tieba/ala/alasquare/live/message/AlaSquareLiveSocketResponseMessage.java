package com.baidu.tieba.ala.alasquare.live.message;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.d.l;
import c.a.t0.a0.f.a.d;
import c.a.t0.a0.f.b.b.a;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import tbclient.LiveSquare.DataRes;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.LiveSquare.LiveSquareResIdl;
/* loaded from: classes12.dex */
public class AlaSquareLiveSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<a> categoryList;
    public LinkedList<FunctionListInfo> functionList;
    public HeadLiveInfo headLiveInfo;
    public int isSmallFollow;
    public boolean mHasMore;
    public int mPn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaSquareLiveSocketResponseMessage() {
        super(AlaCmdConfigSocket.CMD_SQUARE_LIVE);
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
        this.mPn = 0;
    }

    public LinkedList<a> getCategoryList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.categoryList : (LinkedList) invokeV.objValue;
    }

    public LinkedList<FunctionListInfo> getFunctionList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.functionList : (LinkedList) invokeV.objValue;
    }

    public HeadLiveInfo getHeadLiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.headLiveInfo : (HeadLiveInfo) invokeV.objValue;
    }

    public int getIsSmallFollow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.isSmallFollow : invokeV.intValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mHasMore : invokeV.booleanValue;
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mPn = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        l<byte[]> a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || hasError() || ListUtils.isEmpty(this.categoryList) || this.mPn != 1 || (a = BdCacheService.k().a("ala_square_space", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20)) == null) {
            return;
        }
        a.e("ala_square_live_key", bArr, 604800000L);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            LiveSquareResIdl liveSquareResIdl = (LiveSquareResIdl) new Wire(new Class[0]).parseFrom(bArr, LiveSquareResIdl.class);
            setError(liveSquareResIdl.error.errorno.intValue());
            setErrorString(liveSquareResIdl.error.usermsg);
            if (hasError()) {
                return;
            }
            this.functionList = new LinkedList<>();
            LinkedList<a> linkedList = new LinkedList<>();
            this.categoryList = linkedList;
            linkedList.addAll(d.a(liveSquareResIdl.data.live_with_category));
            this.functionList.addAll(liveSquareResIdl.data.function_list_info);
            DataRes dataRes = liveSquareResIdl.data;
            this.headLiveInfo = dataRes.head_live_info;
            this.isSmallFollow = dataRes.is_small_follow.intValue();
            this.mHasMore = liveSquareResIdl.data.has_more.intValue() == 1;
        }
    }
}
