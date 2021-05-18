package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.j0.r.d0.b;
/* loaded from: classes4.dex */
public class GroupChatView extends CommonGroupMsglistView {

    /* renamed from: e  reason: collision with root package name */
    public TextView f17063e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f17064f;

    /* renamed from: g  reason: collision with root package name */
    public GroupChatActivity f17065g;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    public void d() {
        this.f17064f.setVisibility(8);
        b.j().t("has_shown_group_btn_dot", true);
    }

    public void e() {
        if (b.j().g("has_shown_group_btn_dot", false)) {
            return;
        }
        this.f17064f.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        this.f17065g = (GroupChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.msglist_groupinfo);
        if (string != null) {
            String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mBtnGroupInfo = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.group_info_btn_txt);
            this.f17063e = textView;
            textView.setText(string);
            ImageView imageView = (ImageView) this.mBtnGroupInfo.findViewById(R.id.red_dot);
            this.f17064f = imageView;
            imageView.setVisibility(8);
            if (!StringUtils.isNull(stringExtra) && stringExtra.equals(TbadkCoreApplication.getCurrentAccount())) {
                e();
            }
            if (MessageManager.getInstance().findTask(2008011) == null) {
                this.mBtnGroupInfo.setVisibility(4);
            } else {
                this.mBtnGroupInfo.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        TextView textView = this.f17063e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        }
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), i2);
        }
    }
}
