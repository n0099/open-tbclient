package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class GroupChatView extends CommonGroupMsglistView {
    protected TextView irT;
    protected ImageView irU;
    private GroupChatActivity irV;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        this.irV = (GroupChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.msglist_groupinfo);
        if (string != null) {
            String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.irT = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.irT.setText(string);
            this.irU = (ImageView) this.mBtnGroupInfo.findViewById(R.id.red_dot);
            this.irU.setVisibility(8);
            if (!StringUtils.isNull(stringExtra) && stringExtra.equals(TbadkApplication.getCurrentAccount())) {
                cjb();
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
        if (this.irT != null) {
            am.setViewTextColor(this.irT, R.color.cp_cont_b, 1);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    public void cjb() {
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.HAS_SHOWN_GROUP_BTN_DOT, false)) {
            this.irU.setVisibility(0);
        }
    }

    public void cjc() {
        this.irU.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.HAS_SHOWN_GROUP_BTN_DOT, true);
    }
}
