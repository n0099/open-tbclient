package com.baidu.tbadk.widget.richText;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ TbRichTextView aPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(TbRichTextView tbRichTextView, int i) {
        super(i);
        this.aPX = tbRichTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        z = this.aPX.aPP;
        if (z) {
            this.aPX.setTextSize(TbConfig.getContentSizeOfLzl(this.aPX.getContext()));
        } else {
            this.aPX.setTextSize(TbConfig.getContentSize());
        }
    }
}
