package com.baidu.tbadk.widget.richText;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class h extends ClickableSpan {
    private String aFR;
    private int mType;
    private String mUrl;

    /* loaded from: classes.dex */
    public static class a {
        public String subType;
        public int type;
        public String url;

        public a(int i, String str, String str2) {
            this.type = i;
            this.url = str;
            this.subType = str2;
        }
    }

    public h(int i, String str) {
        this.mType = 0;
        this.mUrl = null;
        this.mUrl = str;
        this.mType = i;
    }

    public void gA(String str) {
        this.aFR = str;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK, new a(this.mType, this.mUrl, this.aFR)));
    }

    public static void a(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof m)) {
            m mVar = (m) tbPageContext.getOrignalPage();
            Activity pageActivity = tbPageContext.getPageActivity();
            switch (i) {
                case 2:
                    mVar.B(pageActivity, str);
                    return;
                case 16:
                    mVar.A(pageActivity, str);
                    return;
                case 32:
                    mVar.C(pageActivity, str);
                    return;
                case 64:
                    mVar.D(pageActivity, str);
                    return;
                case 128:
                    mVar.E(pageActivity, str);
                    return;
                case 256:
                    mVar.d(pageActivity, str, str2);
                    return;
                case 1024:
                    mVar.F(pageActivity, str);
                    return;
                default:
                    return;
            }
        }
    }
}
