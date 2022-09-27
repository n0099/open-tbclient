package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hy7 extends l55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoiceData.VoiceModel b;
    public PbEditorData.ThreadData c;
    public BaseActivity<?> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hy7(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public VoiceData.VoiceModel b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (VoiceData.VoiceModel) invokeV.objValue;
    }

    public void c(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseActivity) == null) || StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) || a() == null) {
            return;
        }
        a().A(new h55(2, 12, " "));
    }

    public void d(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) && i2 == -1 && i == 23004) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
        }
    }

    public void e() {
        PbEditorData.ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (threadData = this.c) == null || StringUtils.isNull(threadData.getAuthorName()) || this.c.getAuthorId() <= 0) {
            return;
        }
        String valueOf = String.valueOf(this.c.getAuthorId());
        if (valueOf != null && !valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.d.getActivity(), this.c.getAuthorId(), this.c.getAuthorName(), this.c.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, dh.g(this.c.getThreadId(), 0L), dh.g(this.c.getPostId(), 0L))));
        } else {
            ej.M(this.d.getActivity(), R.string.obfuscated_res_0x7f0f0372);
        }
    }

    public void f(BaseActivity<?> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, baseActivity) == null) {
            this.d = baseActivity;
        }
    }

    public void g(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) {
            this.c = threadData;
            if (a() == null || this.c == null) {
                return;
            }
            a().setFid(dh.g(this.c.getForumId(), 0L));
            a().setTid(this.c.getThreadId());
        }
    }

    public BaseActivity<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : (BaseActivity) invokeV.objValue;
    }

    public void h(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, voiceModel) == null) {
            this.b = voiceModel;
        }
    }
}
