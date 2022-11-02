package com.baidu.tieba.enterForum.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.SetLikeForumSort.SetLikeForumSortResIdl;
/* loaded from: classes4.dex */
public class SetLikeForumSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetLikeForumSocketResponseMessage() {
        super(309685);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            SetLikeForumSortResIdl setLikeForumSortResIdl = (SetLikeForumSortResIdl) new Wire(new Class[0]).parseFrom(bArr, SetLikeForumSortResIdl.class);
            if (setLikeForumSortResIdl != null) {
                setError(setLikeForumSortResIdl.error.errorno.intValue());
                setErrorString(setLikeForumSortResIdl.error.errmsg);
            }
            return setLikeForumSortResIdl;
        }
        return invokeIL.objValue;
    }
}
