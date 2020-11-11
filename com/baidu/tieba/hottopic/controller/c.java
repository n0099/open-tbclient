package com.baidu.tieba.hottopic.controller;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c {
    private OvalActionButton jaA;
    private TbPageContext<?> mPageContext;
    private String mPostContent;
    private String mTopicId;

    public c(OvalActionButton ovalActionButton, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.jaA = ovalActionButton;
        this.jaA.setIsCircle(true);
        this.jaA.setHasShadow(false);
        this.jaA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.controller.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cLZ();
            }
        });
    }

    public void setTopicId(String str) {
        this.mTopicId = str;
    }

    public void DP(String str) {
        this.mPostContent = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLZ() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
        writeActivityConfig.setTopicId(String.valueOf(this.mTopicId));
        writeActivityConfig.getIntent().putExtra("from", "topic_detail");
        writeActivityConfig.setCallFrom("1");
        if (!StringUtils.isNull(this.mPostContent)) {
            writeActivityConfig.setTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_write_name), this.mPostContent), true);
        }
        writeActivityConfig.setForumLevel(-1);
        writeActivityConfig.setForumAvatar(null);
        writeActivityConfig.setPrivateThread(0);
        writeActivityConfig.setForumDir("", "");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }
}
