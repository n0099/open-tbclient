package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class RequestStaticEmotionMessage extends CustomMessage<Object> {
    private String groupID;
    private String sharpText;

    public RequestStaticEmotionMessage(String str, String str2) {
        super(CmdConfigCustom.EMOTION_LOAD_STATIC_EMOTION);
        this.groupID = str;
        this.sharpText = str2;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public String getSharpText() {
        return this.sharpText;
    }

    public void setSharpText(String str) {
        this.sharpText = str;
    }
}
