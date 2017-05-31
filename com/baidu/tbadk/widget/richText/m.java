package com.baidu.tbadk.widget.richText;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ TbRichTextView aOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(TbRichTextView tbRichTextView, int i) {
        super(i);
        this.aOF = tbRichTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        z = this.aOF.aOz;
        if (z) {
            this.aOF.setTextSize(TbConfig.getContentSizeOfLzl(this.aOF.getContext()));
        } else {
            this.aOF.setTextSize(TbConfig.getContentSize());
        }
    }
}
