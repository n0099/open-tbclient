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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends ClickableSpan {
    private String eDX;
    private int eDY;
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

    public void oo(int i) {
        this.eDY = i;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public void op(int i) {
        this.urlType = i;
    }

    public void zc(String str) {
        this.eDX = str;
    }

    public String getLink() {
        return this.mUrl;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.textColor != -1) {
            textPaint.setColor(am.getColor(this.textColor));
        } else if (biP()) {
            textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_link_tip_c));
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        textPaint.setUnderlineText(false);
        if (this.color != -1) {
            textPaint.bgColor = this.color;
        } else if (this.eDY == 1 && biP()) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                textPaint.bgColor = am.getColor(R.color.cp_bg_line_c);
            } else {
                textPaint.bgColor = am.getColor(R.color.cp_bg_line_z);
            }
        } else if (this.eDY == 2) {
            textPaint.bgColor = am.getColor(R.color.transparent);
        }
    }

    private boolean biP() {
        switch (this.mType) {
            case 2:
            case 16:
            case 18:
                return true;
            default:
                return false;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        int i = 2;
        int i2 = 1;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK, new a(this.mType, this.mUrl, this.eDX));
        if (this.mType == 2) {
            if (this.urlType != 1) {
                if (this.urlType == 2) {
                    i = 1;
                } else {
                    i2 = 2;
                    i = 1;
                }
            }
            TiebaStatic.log(new an(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).ag("obj_source", i2).ag("obj_type", i));
        }
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public static void a(Context context, h hVar, int i, String str, String str2) {
        if (hVar != null) {
            switch (i) {
                case 2:
                    hVar.f(context, str, false);
                    return;
                case 16:
                    hVar.al(context, str);
                    return;
                case 18:
                    hVar.f(context, str, true);
                    return;
                case 32:
                    hVar.am(context, str);
                    return;
                case 64:
                    hVar.an(context, str);
                    return;
                case 128:
                    hVar.ao(context, str);
                    return;
                case 256:
                    hVar.s(context, str, str2);
                    return;
                case 1024:
                    hVar.ap(context, str);
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof h)) {
            a(tbPageContext.getPageActivity(), (h) tbPageContext.getOrignalPage(), i, str, str2);
        }
    }

    public static void a(TbPageContext<?> tbPageContext, h hVar, int i, String str, String str2) {
        if (tbPageContext != null && hVar != null) {
            a(tbPageContext.getPageActivity(), hVar, i, str, str2);
        }
    }
}
