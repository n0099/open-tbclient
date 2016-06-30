package com.baidu.tieba.emotion.editortool;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
/* loaded from: classes.dex */
class e implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestStaticEmotionMessage)) {
            return null;
        }
        RequestStaticEmotionMessage requestStaticEmotionMessage = (RequestStaticEmotionMessage) customMessage;
        return new CustomResponsedMessage<>(customMessage.getCmd(), x.RA().aD(requestStaticEmotionMessage.getGroupID(), requestStaticEmotionMessage.getSharpText()));
    }
}
