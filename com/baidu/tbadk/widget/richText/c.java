package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends ClickableSpan {
    private String cCZ;
    private int cDa;
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

    public c(int i, String str) {
        this.mType = 0;
        this.mUrl = null;
        this.mUrl = str;
        this.mType = i;
    }

    public void kL(int i) {
        this.cDa = i;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public void kM(int i) {
        this.urlType = i;
    }

    public void qa(String str) {
        this.cCZ = str;
    }

    public String getLink() {
        return this.mUrl;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.textColor != -1) {
            textPaint.setColor(al.getColor(this.textColor));
        } else if (18 == this.mType || 2 == this.mType) {
            textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0277d.cp_link_tip_c));
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        textPaint.setUnderlineText(false);
        if (this.color != -1) {
            textPaint.bgColor = this.color;
        } else if (this.cDa == 1 && (this.mType == 18 || this.mType == 2)) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                textPaint.bgColor = al.getColor(d.C0277d.cp_bg_line_c);
            } else {
                textPaint.bgColor = al.getColor(d.C0277d.cp_bg_line_z);
            }
        } else if (this.cDa == 2) {
            textPaint.bgColor = al.getColor(d.C0277d.transparent);
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        int i = 2;
        int i2 = 1;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001332, new a(this.mType, this.mUrl, this.cCZ));
        if (this.mType == 2) {
            if (this.urlType != 1) {
                if (this.urlType == 2) {
                    i = 1;
                } else {
                    i2 = 2;
                    i = 1;
                }
            }
            TiebaStatic.log(new am("c11972").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2).T("obj_type", i));
        }
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public static void a(Context context, e eVar, int i, String str, String str2) {
        if (eVar != null) {
            switch (i) {
                case 2:
                    eVar.e(context, str, false);
                    return;
                case 16:
                    eVar.ay(context, str);
                    return;
                case 18:
                    eVar.e(context, str, true);
                    return;
                case 32:
                    eVar.az(context, str);
                    return;
                case 64:
                    eVar.aA(context, str);
                    return;
                case 128:
                    eVar.aB(context, str);
                    return;
                case 256:
                    eVar.k(context, str, str2);
                    return;
                case 1024:
                    eVar.aC(context, str);
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof e)) {
            a(tbPageContext.getPageActivity(), (e) tbPageContext.getOrignalPage(), i, str, str2);
        }
    }
}
