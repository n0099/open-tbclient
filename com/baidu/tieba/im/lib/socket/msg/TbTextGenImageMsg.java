package com.baidu.tieba.im.lib.socket.msg;

import android.text.SpannableStringBuilder;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rv8;
import com.baidu.tieba.xv8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes6.dex */
public class TbTextGenImageMsg extends TbSingleTextImageMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 101;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @SerializedName("sec_gen_msg")
    @rv8
    public String lastPrompt;
    @SerializedName("sec_gen_config")
    @rv8
    public xv8 subSkillConfig;

    public TbTextGenImageMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setType(101);
    }

    @Nullable
    public String getLastPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.lastPrompt;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public xv8 getSubSkillConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.subSkillConfig;
        }
        return (xv8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSingleTextImageMsg
    @Nullable
    public CharSequence getCacheText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TbTaskInfo taskInfo = getTaskInfo();
            if (this.cacheText != null && taskInfo != null) {
                int taskProgress = taskInfo.getTaskProgress();
                if (taskInfo.getTaskState() == 2) {
                    return new SpannableStringBuilder(this.cacheText).append((CharSequence) String.valueOf(taskProgress)).append((CharSequence) "%");
                }
            }
            return this.cacheText;
        }
        return (CharSequence) invokeV.objValue;
    }
}
