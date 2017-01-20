package com.baidu.tbadk.widget.richText;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends ClickableSpan {
    private String aHr;
    private int aHs;
    private int color = -1;
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

    public b(int i, String str) {
        this.mType = 0;
        this.mUrl = null;
        this.mUrl = str;
        this.mType = i;
    }

    public void fz(int i) {
        this.aHs = i;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void gz(String str) {
        this.aHr = str;
    }

    public String getLink() {
        return this.mUrl;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        if (this.color != -1) {
            textPaint.bgColor = this.color;
        } else if (this.aHs == 1) {
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                textPaint.bgColor = ap.getColor(r.e.cp_bg_line_c);
            } else {
                textPaint.bgColor = ap.getColor(r.e.cp_bg_line_z);
            }
        } else if (this.aHs == 2) {
            textPaint.bgColor = ap.getColor(r.e.transparent);
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK, new a(this.mType, this.mUrl, this.aHr)));
    }

    public static void a(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof d)) {
            d dVar = (d) tbPageContext.getOrignalPage();
            Activity pageActivity = tbPageContext.getPageActivity();
            switch (i) {
                case 2:
                    dVar.B(pageActivity, str);
                    return;
                case 16:
                    dVar.A(pageActivity, str);
                    return;
                case 18:
                    dVar.B(pageActivity, str);
                    return;
                case 32:
                    dVar.C(pageActivity, str);
                    return;
                case 64:
                    dVar.D(pageActivity, str);
                    return;
                case 128:
                    dVar.E(pageActivity, str);
                    return;
                case 256:
                    dVar.d(pageActivity, str, str2);
                    return;
                case 1024:
                    dVar.F(pageActivity, str);
                    return;
                default:
                    return;
            }
        }
    }
}
