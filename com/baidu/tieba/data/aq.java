package com.baidu.tieba.data;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends ClickableSpan {
    final /* synthetic */ an a;
    private String b;
    private String c;
    private Context d;

    public aq(an anVar, Context context, String str, String str2) {
        this.a = anVar;
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
                textPaint.setColor(this.d.getResources().getColor(com.baidu.tieba.r.common_link_text_1));
            } else {
                textPaint.setColor(this.d.getResources().getColor(com.baidu.tieba.r.common_link_text));
            }
        }
        textPaint.setUnderlineText(false);
        textPaint.setFakeBoldText(false);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.b != null && this.c != null && this.d != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new bh(this.d, this.c, this.b, null, "pb_floor")));
        }
    }
}
