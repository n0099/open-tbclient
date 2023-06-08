package com.baidu.tieba.forumSquare.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.ww5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetForumSquare.DataReq;
import tbclient.GetForumSquare.GetForumSquareReqIdl;
/* loaded from: classes5.dex */
public class ForumSquareRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_RN = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public String className;
    public int pn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumSquareRequestMessage() {
        super(CmdConfigHttp.CMD_FORUM_SQUARE, 309653);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pn = 1;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.class_name = this.className;
                builder.pn = Integer.valueOf(this.pn);
                builder.rn = 20;
                builder.user_id = Long.valueOf(TbadkCoreApplication.getCurrentAccountId());
                if (z) {
                    ww5.a(builder, true);
                }
                GetForumSquareReqIdl.Builder builder2 = new GetForumSquareReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }
}
