package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends ClickableSpan {
    private String ffA;
    private int ffB;
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

    public f(int i, String str) {
        this.mUrl = str;
        this.mType = i;
    }

    public void rr(int i) {
        this.ffB = i;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public void rs(int i) {
        this.urlType = i;
    }

    public void CT(String str) {
        this.ffA = str;
    }

    public String getLink() {
        return this.mUrl;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.textColor != -1) {
            textPaint.setColor(ap.getColor(this.textColor));
        } else if (bxZ()) {
            textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_link_tip_c));
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        textPaint.setUnderlineText(false);
        if (this.color != -1) {
            textPaint.bgColor = this.color;
        } else if (this.ffB == 1 && bya()) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                textPaint.bgColor = ap.getColor(R.color.cp_bg_line_c);
            } else {
                textPaint.bgColor = ap.getColor(R.color.cp_bg_line_z);
            }
        } else if (this.ffB == 2) {
            textPaint.bgColor = ap.getColor(R.color.transparent);
        }
    }

    private boolean bxZ() {
        switch (this.mType) {
            case 2:
            case 16:
            case 18:
                return true;
            default:
                return false;
        }
    }

    public boolean bya() {
        switch (this.mType) {
            case 16:
            case 18:
                return true;
            case 17:
            default:
                return false;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        int i = 2;
        int i2 = 1;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK, new a(this.mType, this.mUrl, this.ffA));
        if (this.mType == 2) {
            if (this.urlType != 1) {
                if (this.urlType == 2) {
                    i = 1;
                } else {
                    i2 = 2;
                    i = 1;
                }
            }
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).ai("obj_source", i2).ai("obj_type", i));
        }
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public static void a(Context context, i iVar, int i, String str, String str2) {
        if (iVar != null) {
            switch (i) {
                case 2:
                    iVar.f(context, str, false);
                    return;
                case 16:
                    iVar.aq(context, str);
                    return;
                case 18:
                    iVar.f(context, str, true);
                    return;
                case 32:
                    iVar.ar(context, str);
                    return;
                case 64:
                    iVar.as(context, str);
                    return;
                case 128:
                    iVar.at(context, str);
                    return;
                case 256:
                    iVar.r(context, str, str2);
                    return;
                case 1024:
                    iVar.au(context, str);
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof i)) {
            a(tbPageContext.getPageActivity(), (i) tbPageContext.getOrignalPage(), i, str, str2);
        }
    }

    public static void a(TbPageContext<?> tbPageContext, i iVar, int i, String str, String str2) {
        if (tbPageContext != null && iVar != null) {
            a(tbPageContext.getPageActivity(), iVar, i, str, str2);
        }
    }
}
