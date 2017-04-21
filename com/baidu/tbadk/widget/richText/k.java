package com.baidu.tbadk.widget.richText;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ TbRichTextView aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbRichTextView tbRichTextView, int i) {
        super(i);
        this.aOn = tbRichTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        z = this.aOn.aOg;
        if (z) {
            this.aOn.setTextSize(TbConfig.getContentSizeOfLzl(this.aOn.getContext()));
        } else {
            this.aOn.setTextSize(TbConfig.getContentSize());
        }
    }
}
