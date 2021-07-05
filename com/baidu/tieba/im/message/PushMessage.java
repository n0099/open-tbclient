package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PushMessage extends CustomResponsedMessage<GroupNewsPojo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushMessage(int i2, GroupNewsPojo groupNewsPojo) {
        super(i2, groupNewsPojo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), groupNewsPojo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static PushMessage newInstance(GroupNewsPojo groupNewsPojo) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, groupNewsPojo)) == null) {
            String cmd = groupNewsPojo.getCmd();
            if (cmd.equals("apply_join_group")) {
                i2 = 2001125;
            } else if (cmd.equals("apply_join_success")) {
                i2 = 2001126;
            } else if (cmd.equals("apply_join_fail")) {
                i2 = 2001127;
            } else if (cmd.equals("kick_out")) {
                i2 = 2001128;
            } else if (cmd.equals("group_notice_change")) {
                i2 = 2001129;
            } else if (cmd.equals("group_name_change")) {
                i2 = 2001130;
            } else if (cmd.equals("group_event_info")) {
                i2 = 2001131;
            } else if (cmd.equals("group_intro_change")) {
                i2 = 2001132;
            } else if (cmd.equals("group_level_up")) {
                i2 = 2001133;
            } else if (cmd.equals("group_head_change")) {
                i2 = 2001134;
            } else if (cmd.equals("group_activitys_change")) {
                i2 = 2001135;
            } else if (cmd.equals("dismiss_group")) {
                i2 = 2001137;
            } else if (cmd.equals("hide_group_warn")) {
                i2 = 2001138;
            } else if (cmd.equals("hide_group")) {
                i2 = 2001139;
            } else if (cmd.equals("apply_new_friend")) {
                i2 = 2001172;
            } else if (cmd.equals("passed_new_friend")) {
                i2 = 2001173;
            } else if (cmd.equals("delete_new_friend")) {
                i2 = 2001209;
            } else if (cmd.equals("apply_reply_message")) {
                i2 = 2001219;
            } else if (cmd.equals("apply_add_friend")) {
                i2 = 2001220;
            } else if (cmd.equals("apply_pass_friend")) {
                i2 = 2001221;
            } else if (cmd.equals("upload_stat")) {
                i2 = 2001320;
            } else if (cmd.equals("plugin_config_sync")) {
                i2 = 2001401;
            } else if (!cmd.equals("offline_debug")) {
                return null;
            } else {
                i2 = 2001413;
            }
            return new PushMessage(i2, groupNewsPojo);
        }
        return (PushMessage) invokeL.objValue;
    }

    public GroupNewsPojo getP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getData() : (GroupNewsPojo) invokeV.objValue;
    }
}
