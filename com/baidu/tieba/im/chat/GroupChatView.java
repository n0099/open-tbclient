package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class GroupChatView extends CommonGroupMsglistView {
    protected TextView iPT;
    protected ImageView iPU;
    private GroupChatActivity iPV;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        this.iPV = (GroupChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.msglist_groupinfo);
        if (string != null) {
            String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.iPT = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.iPT.setText(string);
            this.iPU = (ImageView) this.mBtnGroupInfo.findViewById(R.id.red_dot);
            this.iPU.setVisibility(8);
            if (!StringUtils.isNull(stringExtra) && stringExtra.equals(TbadkApplication.getCurrentAccount())) {
                cqA();
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START) == null) {
                this.mBtnGroupInfo.setVisibility(4);
            } else {
                this.mBtnGroupInfo.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iPT != null) {
            ao.setViewTextColor(this.iPT, R.color.cp_cont_b, 1);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    public void cqA() {
        if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.HAS_SHOWN_GROUP_BTN_DOT, false)) {
            this.iPU.setVisibility(0);
        }
    }

    public void cqB() {
        this.iPU.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.HAS_SHOWN_GROUP_BTN_DOT, true);
    }
}
