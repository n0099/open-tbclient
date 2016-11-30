package com.baidu.tbadk.widget.richText;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class u extends CustomMessageListener {
    final /* synthetic */ TbRichTextView aKA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(TbRichTextView tbRichTextView, int i) {
        super(i);
        this.aKA = tbRichTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        z = this.aKA.aKt;
        if (z) {
            this.aKA.setTextSize(TbConfig.getContentSizeOfLzl(this.aKA.getContext()));
        } else {
            this.aKA.setTextSize(TbConfig.getContentSize());
        }
    }
}
