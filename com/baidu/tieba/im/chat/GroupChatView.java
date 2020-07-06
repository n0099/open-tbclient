package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class GroupChatView extends CommonGroupMsglistView {
    protected TextView iJM;
    protected ImageView iJN;
    private GroupChatActivity iJO;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        this.iJO = (GroupChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.msglist_groupinfo);
        if (string != null) {
            String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.iJM = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.iJM.setText(string);
            this.iJN = (ImageView) this.mBtnGroupInfo.findViewById(R.id.red_dot);
            this.iJN.setVisibility(8);
            if (!StringUtils.isNull(stringExtra) && stringExtra.equals(TbadkApplication.getCurrentAccount())) {
                cna();
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
        if (this.iJM != null) {
            an.setViewTextColor(this.iJM, R.color.cp_cont_b, 1);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    public void cna() {
        if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.HAS_SHOWN_GROUP_BTN_DOT, false)) {
            this.iJN.setVisibility(0);
        }
    }

    public void cnb() {
        this.iJN.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.HAS_SHOWN_GROUP_BTN_DOT, true);
    }
}
