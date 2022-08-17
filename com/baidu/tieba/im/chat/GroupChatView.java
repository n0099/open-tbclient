package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ru4;
/* loaded from: classes3.dex */
public class GroupChatView extends CommonGroupMsglistView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ImageView b;
    public GroupChatActivity c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msglistActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((MsglistActivity) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, talkableActivity, z) == null) {
            super.initHeader(talkableActivity, z);
            this.c = (GroupChatActivity) talkableActivity;
            String string = talkableActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0af7);
            if (string != null) {
                String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
                View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d037e, talkableActivity);
                this.mBtnGroupInfo = addCustomView;
                TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090ce3);
                this.a = textView;
                textView.setText(string);
                ImageView imageView = (ImageView) this.mBtnGroupInfo.findViewById(R.id.obfuscated_res_0x7f091b76);
                this.b = imageView;
                imageView.setVisibility(8);
                if (!StringUtils.isNull(stringExtra) && stringExtra.equals(TbadkCoreApplication.getCurrentAccount())) {
                    k();
                }
                if (MessageManager.getInstance().findTask(2008011) == null) {
                    this.mBtnGroupInfo.setVisibility(4);
                } else {
                    this.mBtnGroupInfo.setVisibility(0);
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.setVisibility(8);
            ru4.k().u("has_shown_group_btn_dot", true);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ru4.k().h("has_shown_group_btn_dot", false)) {
            return;
        }
        this.b.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            TextView textView = this.a;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
            }
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
            }
        }
    }
}
