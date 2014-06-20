package com.baidu.tieba.data;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends ClickableSpan {
    final /* synthetic */ ai a;
    private String b;
    private String c;
    private Context d;

    public al(ai aiVar, Context context, String str, String str2) {
        this.a = aiVar;
        this.b = null;
        this.c = null;
        this.d = null;
        this.b = str;
        this.c = str2;
        this.d = context;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.d != null) {
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                textPaint.setColor(this.d.getResources().getColor(com.baidu.tieba.s.common_link_text_1));
            } else {
                textPaint.setColor(this.d.getResources().getColor(com.baidu.tieba.s.common_link_text));
            }
        }
        textPaint.setUnderlineText(false);
        textPaint.setFakeBoldText(false);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.b != null && this.c != null && this.d != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new com.baidu.tbadk.core.atomData.as(this.d, this.c, this.b)));
        }
    }
}
