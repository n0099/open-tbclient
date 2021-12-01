package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.q0.s.e0.b;
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
/* loaded from: classes10.dex */
public class GroupChatView extends CommonGroupMsglistView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45800e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f45801f;

    /* renamed from: g  reason: collision with root package name */
    public GroupChatActivity f45802g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msglistActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((MsglistActivity) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f45801f.setVisibility(8);
            b.j().t("has_shown_group_btn_dot", true);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || b.j().g("has_shown_group_btn_dot", false)) {
            return;
        }
        this.f45801f.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, talkableActivity, z) == null) {
            super.initHeader(talkableActivity, z);
            this.f45802g = (GroupChatActivity) talkableActivity;
            String string = talkableActivity.getPageContext().getString(R.string.msglist_groupinfo);
            if (string != null) {
                String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
                View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
                this.mBtnGroupInfo = addCustomView;
                TextView textView = (TextView) addCustomView.findViewById(R.id.group_info_btn_txt);
                this.f45800e = textView;
                textView.setText(string);
                ImageView imageView = (ImageView) this.mBtnGroupInfo.findViewById(R.id.red_dot);
                this.f45801f = imageView;
                imageView.setVisibility(8);
                if (!StringUtils.isNull(stringExtra) && stringExtra.equals(TbadkCoreApplication.getCurrentAccount())) {
                    d();
                }
                if (MessageManager.getInstance().findTask(2008011) == null) {
                    this.mBtnGroupInfo.setVisibility(4);
                } else {
                    this.mBtnGroupInfo.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            TextView textView = this.f45800e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
            }
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i2);
            }
        }
    }
}
