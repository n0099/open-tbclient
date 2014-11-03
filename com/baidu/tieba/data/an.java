package com.baidu.tieba.data;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends ClickableSpan {
    final /* synthetic */ ak amu;
    private String mId;
    private String mName;

    public an(ak akVar, String str, String str2) {
        this.amu = akVar;
        this.mName = null;
        this.mId = null;
        this.mName = str;
        this.mId = str2;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(aw.getColor(com.baidu.tieba.s.common_link_text));
        textPaint.setUnderlineText(false);
        textPaint.setFakeBoldText(false);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.mName != null && this.mId != null && view.getContext() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
        }
    }
}
