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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends ClickableSpan {
    private String eOt;
    private int eOu;
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

    public void oO(int i) {
        this.eOu = i;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public void oP(int i) {
        this.urlType = i;
    }

    public void zv(String str) {
        this.eOt = str;
    }

    public String getLink() {
        return this.mUrl;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.textColor != -1) {
            textPaint.setColor(an.getColor(this.textColor));
        } else if (blq()) {
            textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_link_tip_c));
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        textPaint.setUnderlineText(false);
        if (this.color != -1) {
            textPaint.bgColor = this.color;
        } else if (this.eOu == 1 && blr()) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                textPaint.bgColor = an.getColor(R.color.cp_bg_line_c);
            } else {
                textPaint.bgColor = an.getColor(R.color.cp_bg_line_z);
            }
        } else if (this.eOu == 2) {
            textPaint.bgColor = an.getColor(R.color.transparent);
        }
    }

    private boolean blq() {
        switch (this.mType) {
            case 2:
            case 16:
            case 18:
                return true;
            default:
                return false;
        }
    }

    public boolean blr() {
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
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK, new a(this.mType, this.mUrl, this.eOt));
        if (this.mType == 2) {
            if (this.urlType != 1) {
                if (this.urlType == 2) {
                    i = 1;
                } else {
                    i2 = 2;
                    i = 1;
                }
            }
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).ag("obj_source", i2).ag("obj_type", i));
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
                    iVar.al(context, str);
                    return;
                case 18:
                    iVar.f(context, str, true);
                    return;
                case 32:
                    iVar.am(context, str);
                    return;
                case 64:
                    iVar.an(context, str);
                    return;
                case 128:
                    iVar.ao(context, str);
                    return;
                case 256:
                    iVar.s(context, str, str2);
                    return;
                case 1024:
                    iVar.ap(context, str);
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
