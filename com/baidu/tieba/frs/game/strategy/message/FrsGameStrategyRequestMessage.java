package com.baidu.tieba.frs.game.strategy.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GameForumGuideTab.DataReq;
import tbclient.GameForumGuideTab.GameForumGuideTabReqIdl;
/* loaded from: classes6.dex */
public class FrsGameStrategyRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mFid;
    public int mLabelId;
    public int mPn;
    public int mTabId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsGameStrategyRequestMessage(long j, int i, int i2, int i3) {
        super(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPn = 0;
        this.mFid = j;
        this.mPn = i;
        this.mTabId = i2;
        this.mLabelId = i3;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.forum_id = Long.valueOf(this.mFid);
            if (this.mTabId == 0 && this.mLabelId == 0) {
                i = 1;
            } else {
                i = 0;
            }
            builder.need_tab_stuct = Integer.valueOf(i);
            builder.sub_tab_id = Integer.valueOf(this.mTabId);
            builder.sub_label_id = Integer.valueOf(this.mLabelId);
            builder.pn = Integer.valueOf(this.mPn);
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                NetMessageHelper.bindCommonParamsToProtobufData(builder, true);
            }
            GameForumGuideTabReqIdl.Builder builder2 = new GameForumGuideTabReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mFid;
        }
        return invokeV.longValue;
    }
}
