package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tieba.rw4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes5.dex */
public class PrivSetsData extends rw4 implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bazhuShowInside;
    public int bazhuShowOutside;
    public int friend;
    public int group;
    public int like;
    public int live;
    public int location;
    public int post;
    public int reply;

    public PrivSetsData() {
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

    public int getBazhuShowInside() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bazhuShowInside;
        }
        return invokeV.intValue;
    }

    public int getBazhuShowOutside() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bazhuShowOutside;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw4
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.location = jSONObject.optInt("location", 0);
            this.like = jSONObject.optInt("like", 0);
            this.group = jSONObject.optInt("group", 0);
            this.post = jSONObject.optInt(CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, 0);
            this.friend = jSONObject.optInt("friend", 0);
            this.live = jSONObject.optInt("live", 0);
            this.reply = jSONObject.optInt("reply", 0);
            this.bazhuShowInside = jSONObject.optInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, 0);
            this.bazhuShowOutside = jSONObject.optInt("bazhu_show_outside", 0);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, privSets) != null) || privSets == null) {
            return;
        }
        this.location = privSets.location.intValue();
        this.like = privSets.like.intValue();
        this.group = privSets.group.intValue();
        this.post = privSets.post.intValue();
        this.friend = privSets.friend.intValue();
        this.live = privSets.live.intValue();
        this.reply = privSets.reply.intValue();
        this.bazhuShowInside = privSets.bazhu_show_inside.intValue();
        this.bazhuShowOutside = privSets.bazhu_show_outside.intValue();
    }
}
