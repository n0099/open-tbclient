package com.baidu.tieba.hottopic.controller;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class c {
    private OvalActionButton jwH;
    private TbPageContext<?> mPageContext;
    private String mPostContent;
    private String mTopicId;

    public c(OvalActionButton ovalActionButton, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.jwH = ovalActionButton;
        this.jwH.setIsCircle(true);
        this.jwH.setHasShadow(false);
        this.jwH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.controller.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cQk();
            }
        });
    }

    public void setTopicId(String str) {
        this.mTopicId = str;
    }

    public void CH(String str) {
        this.mPostContent = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQk() {
        if (!WriteActivityConfig.isAsyncWriting() && this.mTopicId != null) {
            String str = null;
            if (!StringUtils.isNull(this.mPostContent)) {
                str = String.format(TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_write_name), this.mPostContent);
            }
            WriteActivityConfig.newInstance(this.mPageContext.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.mTopicId)).setFrom("topic_detail").setCallFrom("1").setTitle(str).send();
        }
    }
}
