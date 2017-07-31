package com.baidu.tbadk.widget.richText;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends ClickableSpan {
    private String aRh;
    private int aRi;
    private int mType;
    private String mUrl;
    private int color = -1;
    private int textColor = -1;
    private int urlType = 0;

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

    public void fA(int i) {
        this.aRi = i;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public void fB(int i) {
        this.urlType = i;
    }

    public void gZ(String str) {
        this.aRh = str;
    }

    public String getLink() {
        return this.mUrl;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.textColor != -1) {
            textPaint.setColor(ai.getColor(this.textColor));
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        textPaint.setUnderlineText(false);
        if (this.color != -1) {
            textPaint.bgColor = this.color;
        } else if (this.aRi == 1 && (this.mType == 18 || this.mType == 2)) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                textPaint.bgColor = ai.getColor(d.e.cp_bg_line_c);
            } else {
                textPaint.bgColor = ai.getColor(d.e.cp_bg_line_z);
            }
        } else if (this.aRi == 2) {
            textPaint.bgColor = ai.getColor(d.e.transparent);
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        int i = 2;
        int i2 = 1;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK, new a(this.mType, this.mUrl, this.aRh));
        if (this.mType == 2) {
            if (this.urlType != 1) {
                if (this.urlType == 2) {
                    i = 1;
                } else {
                    i2 = 2;
                    i = 1;
                }
            }
            TiebaStatic.log(new aj("c11972").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2).r("obj_type", i));
        }
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public static void a(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof d)) {
            d dVar = (d) tbPageContext.getOrignalPage();
            Activity pageActivity = tbPageContext.getPageActivity();
            switch (i) {
                case 2:
                    dVar.aa(pageActivity, str);
                    return;
                case 16:
                    dVar.Z(pageActivity, str);
                    return;
                case 18:
                    dVar.aa(pageActivity, str);
                    return;
                case 32:
                    dVar.ab(pageActivity, str);
                    return;
                case 64:
                    dVar.ac(pageActivity, str);
                    return;
                case 128:
                    dVar.ad(pageActivity, str);
                    return;
                case 256:
                    dVar.f(pageActivity, str, str2);
                    return;
                case 1024:
                    dVar.ae(pageActivity, str);
                    return;
                default:
                    return;
            }
        }
    }
}
