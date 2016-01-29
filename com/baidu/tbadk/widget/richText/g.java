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
public class g extends ClickableSpan {
    private String aFF;
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

    public g(int i, String str) {
        this.mType = 0;
        this.mUrl = null;
        this.mUrl = str;
        this.mType = i;
    }

    public void gh(String str) {
        this.aFF = str;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK, new a(this.mType, this.mUrl, this.aFF)));
    }

    public static void a(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof l)) {
            l lVar = (l) tbPageContext.getOrignalPage();
            Activity pageActivity = tbPageContext.getPageActivity();
            switch (i) {
                case 2:
                    lVar.I(pageActivity, str);
                    return;
                case 16:
                    lVar.H(pageActivity, str);
                    return;
                case 32:
                    lVar.J(pageActivity, str);
                    return;
                case 64:
                    lVar.K(pageActivity, str);
                    return;
                case 128:
                    lVar.L(pageActivity, str);
                    return;
                case 256:
                    lVar.g(pageActivity, str, str2);
                    return;
                case 1024:
                    lVar.M(pageActivity, str);
                    return;
                default:
                    return;
            }
        }
    }
}
