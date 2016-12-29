package com.baidu.tbadk.widget.richText;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class t extends CustomMessageListener {
    final /* synthetic */ TbRichTextView aJR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(TbRichTextView tbRichTextView, int i) {
        super(i);
        this.aJR = tbRichTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        z = this.aJR.aJK;
        if (z) {
            this.aJR.setTextSize(TbConfig.getContentSizeOfLzl(this.aJR.getContext()));
        } else {
            this.aJR.setTextSize(TbConfig.getContentSize());
        }
    }
}
