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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends ClickableSpan {
    private String fYS;
    private int fYT;
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

    public void so(int i) {
        this.fYT = i;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public void sp(int i) {
        this.urlType = i;
    }

    public void Ej(String str) {
        this.fYS = str;
    }

    public String getLink() {
        return this.mUrl;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.textColor != -1) {
            textPaint.setColor(ap.getColor(this.textColor));
        } else if (bIc()) {
            textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0304));
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        textPaint.setUnderlineText(false);
        if (this.color != -1) {
            textPaint.bgColor = this.color;
        } else if (this.fYT == 1 && bId()) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                textPaint.bgColor = ap.getColor(R.color.CAM_X0204);
            } else {
                textPaint.bgColor = ap.getColor(R.color.cp_bg_line_z);
            }
        } else if (this.fYT == 2) {
            textPaint.bgColor = ap.getColor(R.color.transparent);
        }
    }

    private boolean bIc() {
        switch (this.mType) {
            case 2:
            case 16:
            case 18:
            case 39:
                return true;
            default:
                return false;
        }
    }

    public boolean bId() {
        switch (this.mType) {
            case 2:
            case 16:
            case 18:
            case 39:
                return true;
            default:
                return false;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        int i;
        int i2;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK, new a(this.mType, this.mUrl, this.fYS));
        if (this.mType == 2) {
            if (this.urlType == 1) {
                i = 2;
                i2 = 1;
            } else if (this.urlType == 2) {
                i = 1;
                i2 = 1;
            } else {
                i = 1;
                i2 = 2;
            }
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).aq("obj_source", i2).aq("obj_type", i));
        }
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public static void a(Context context, h hVar, int i, String str, String str2) {
        if (hVar != null) {
            switch (i) {
                case 2:
                    hVar.g(context, str, false);
                    return;
                case 16:
                    hVar.aE(context, str);
                    return;
                case 18:
                    hVar.g(context, str, true);
                    return;
                case 32:
                    hVar.aF(context, str);
                    return;
                case 64:
                    hVar.aG(context, str);
                    return;
                case 128:
                    hVar.aH(context, str);
                    return;
                case 256:
                    hVar.u(context, str, str2);
                    return;
                case 1024:
                    hVar.aI(context, str);
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
