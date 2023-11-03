package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes6.dex */
public class gw9 extends be5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoiceData.VoiceModel b;
    public PbEditorData.ThreadData c;
    public BaseActivity<?> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gw9(EditorTools editorTools) {
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

    public void e(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseActivity) == null) && !StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
            a().K(new xd5(2, 12, " "));
        }
    }

    public BaseActivity<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (BaseActivity) invokeV.objValue;
    }

    public VoiceData.VoiceModel c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (VoiceData.VoiceModel) invokeV.objValue;
    }

    public void f(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) && i2 == -1 && i == 23004) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
        }
    }

    public void g() {
        PbEditorData.ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (threadData = this.c) != null && !StringUtils.isNull(threadData.getAuthorName()) && this.c.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.c.getAuthorId());
            if (valueOf != null && !valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.d.getActivity(), this.c.getAuthorId(), this.c.getAuthorName(), this.c.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, JavaTypesHelper.toLong(this.c.getThreadId(), 0L), JavaTypesHelper.toLong(this.c.getPostId(), 0L))));
            } else {
                BdUtilHelper.showToast(this.d.getActivity(), (int) R.string.can_not_send_gift_to_yourself);
            }
        }
    }

    public void h(BaseActivity<?> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, baseActivity) == null) {
            this.d = baseActivity;
        }
    }

    public void j(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, voiceModel) == null) {
            this.b = voiceModel;
        }
    }

    public void i(PbEditorData.ThreadData threadData) {
        String forumName;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            this.c = threadData;
            if (a() != null && this.c != null) {
                a().setFid(JavaTypesHelper.toLong(this.c.getForumId(), 0L));
                EditorTools a = a();
                String str = "";
                if (StringUtils.isNull(this.c.getForumName())) {
                    forumName = "";
                } else {
                    forumName = this.c.getForumName();
                }
                a.setFname(forumName);
                EditorTools a2 = a();
                if (!StringUtils.isNull(this.c.getThreadId())) {
                    str = this.c.getThreadId();
                }
                a2.setTid(str);
                a().K(new xd5(70, -1, this.c.getForumId()));
            }
        }
    }
}
