package com.baidu.tbadk.widget.richText;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ TbRichTextView aIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbRichTextView tbRichTextView, int i) {
        super(i);
        this.aIy = tbRichTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        z = this.aIy.aIr;
        if (z) {
            this.aIy.setTextSize(TbConfig.getContentSizeOfLzl(this.aIy.getContext()));
        } else {
            this.aIy.setTextSize(TbConfig.getContentSize());
        }
    }
}
