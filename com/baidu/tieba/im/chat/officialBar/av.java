package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class av extends RelativeLayout {
    private TbImageView aGB;
    private TextView aGK;
    private com.baidu.adp.lib.c.b aXd;
    private TextView aZL;
    private View aZM;
    private TextView aZN;
    private ImageView aZO;
    private View aZP;
    private TextView aZQ;
    private TextView aZR;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public av(Context context) {
        this(context, null);
    }

    public av(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public av(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXd = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.msg_single_pic_text_view, this, true);
        this.mTitle = (TextView) findViewById(com.baidu.tieba.v.single_title);
        this.aZL = (TextView) findViewById(com.baidu.tieba.v.single_abstract);
        this.aGB = (TbImageView) findViewById(com.baidu.tieba.v.single_content_pic);
        this.aGB.setAutoChangeStyle(false);
        this.aZN = (TextView) findViewById(com.baidu.tieba.v.read_all);
        this.aZO = (ImageView) findViewById(com.baidu.tieba.v.arrow);
        this.aZM = findViewById(com.baidu.tieba.v.single_divider);
        this.aGK = (TextView) findViewById(com.baidu.tieba.v.show_time_single);
        this.aZP = findViewById(com.baidu.tieba.v.office_msg_priase_include);
        this.aZQ = (TextView) this.aZP.findViewById(com.baidu.tieba.v.office_msg_praise_text);
        this.aZR = (TextView) this.aZP.findViewById(com.baidu.tieba.v.office_msg_praise_number);
        setOnLongClickListener(new aw(this));
    }

    public void a(TbPageContext<?> tbPageContext, q qVar, View view, int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), 0, 0);
        if (qVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(qVar.title)) {
                str = qVar.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(qVar.text)) {
                str2 = qVar.text;
            }
            this.aZL.setText(str2);
            if (!TextUtils.isEmpty(qVar.url)) {
                setOnClickListener(new ax(this, tbPageContext, qVar, i));
            }
            if (!TextUtils.isEmpty(qVar.src)) {
                this.aGB.setTag(qVar.src);
                this.aGB.c(qVar.src, 10, false);
            }
            long j = qVar.aYL;
            long j2 = qVar.aYN;
            if (j <= 0 && j2 <= 0) {
                this.aZP.setVisibility(8);
                return;
            }
            if (j <= 0) {
                this.aZQ.setVisibility(4);
            } else {
                this.aZQ.setVisibility(0);
                this.aZQ.setText(a(qVar));
            }
            if (j2 <= 0) {
                this.aZR.setVisibility(4);
            } else {
                this.aZR.setVisibility(0);
                this.aZR.setText(new StringBuilder(String.valueOf(qVar.aYN)).toString());
            }
            ViewGroup.LayoutParams layoutParams = this.aZL.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.aZL.setLayoutParams(marginLayoutParams);
            }
        }
    }

    private String a(q qVar) {
        if (qVar == null) {
            return null;
        }
        return qVar.aYK + qVar.aYL + qVar.aYM;
    }

    public void reset() {
        this.mTitle.setText("");
        this.aZL.setText("");
        this.aGB.setBackgroundDrawable(null);
        this.aGB.setImageDrawable(null);
        this.aGK.setText("");
        this.aGK.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aXd = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void ct(boolean z) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.aGB.setAutoChangeStyle(z);
        ba.a(this.mTitle, com.baidu.tieba.s.official_msg_bottom_text, 1, skinType);
        ba.a(this.aZL, com.baidu.tieba.s.cp_cont_c, 1, skinType);
        ba.a(this.aZN, com.baidu.tieba.s.official_msg_bottom_text, 1, skinType);
        ba.c(this.aZO, com.baidu.tieba.u.icon_ba_top_arrow_big, skinType);
        ba.a(this.aGK, com.baidu.tieba.s.official_time_text, 1, skinType);
        ba.c(this.aZM, com.baidu.tieba.u.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aGK.setVisibility(8);
            this.aGK.setText("");
            return;
        }
        this.aGK.setVisibility(0);
        this.aGK.setText(str);
    }
}
