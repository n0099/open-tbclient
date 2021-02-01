package com.baidu.tieba.hottopic.controller;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c {
    private OvalActionButton jCn;
    private TbPageContext<?> mPageContext;
    private String mPostContent;
    private String mTopicId;

    public c(OvalActionButton ovalActionButton, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.jCn = ovalActionButton;
        this.jCn.setIsCircle(true);
        this.jCn.setHasShadow(false);
        this.jCn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.controller.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cSj();
            }
        });
    }

    public void setTopicId(String str) {
        this.mTopicId = str;
    }

    public void CY(String str) {
        this.mPostContent = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSj() {
        if (!WriteActivityConfig.isAsyncWriting() && this.mTopicId != null) {
            String str = null;
            if (!StringUtils.isNull(this.mPostContent)) {
                str = String.format(TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_write_name), this.mPostContent);
            }
            WriteActivityConfig.newInstance(this.mPageContext.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.mTopicId)).setFrom("topic_detail").setCallFrom("1").setTitle(str).send();
        }
    }
}
