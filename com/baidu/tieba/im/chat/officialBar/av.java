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
    private TbImageView aGJ;
    private TextView aGS;
    private com.baidu.adp.lib.c.b aXt;
    private TextView bab;
    private View bac;
    private TextView bad;
    private ImageView bae;
    private View baf;
    private TextView bag;
    private TextView bah;
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
        this.aXt = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.msg_single_pic_text_view, this, true);
        this.mTitle = (TextView) findViewById(com.baidu.tieba.v.single_title);
        this.bab = (TextView) findViewById(com.baidu.tieba.v.single_abstract);
        this.aGJ = (TbImageView) findViewById(com.baidu.tieba.v.single_content_pic);
        this.aGJ.setAutoChangeStyle(false);
        this.bad = (TextView) findViewById(com.baidu.tieba.v.read_all);
        this.bae = (ImageView) findViewById(com.baidu.tieba.v.arrow);
        this.bac = findViewById(com.baidu.tieba.v.single_divider);
        this.aGS = (TextView) findViewById(com.baidu.tieba.v.show_time_single);
        this.baf = findViewById(com.baidu.tieba.v.office_msg_priase_include);
        this.bag = (TextView) this.baf.findViewById(com.baidu.tieba.v.office_msg_praise_text);
        this.bah = (TextView) this.baf.findViewById(com.baidu.tieba.v.office_msg_praise_number);
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
            this.bab.setText(str2);
            if (!TextUtils.isEmpty(qVar.url)) {
                setOnClickListener(new ax(this, tbPageContext, qVar, i));
            }
            if (!TextUtils.isEmpty(qVar.src)) {
                this.aGJ.setTag(qVar.src);
                this.aGJ.c(qVar.src, 10, false);
            }
            long j = qVar.aZb;
            long j2 = qVar.aZd;
            if (j <= 0 && j2 <= 0) {
                this.baf.setVisibility(8);
                return;
            }
            if (j <= 0) {
                this.bag.setVisibility(4);
            } else {
                this.bag.setVisibility(0);
                this.bag.setText(a(qVar));
            }
            if (j2 <= 0) {
                this.bah.setVisibility(4);
            } else {
                this.bah.setVisibility(0);
                this.bah.setText(new StringBuilder(String.valueOf(qVar.aZd)).toString());
            }
            ViewGroup.LayoutParams layoutParams = this.bab.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.bab.setLayoutParams(marginLayoutParams);
            }
        }
    }

    private String a(q qVar) {
        if (qVar == null) {
            return null;
        }
        return qVar.aZa + qVar.aZb + qVar.aZc;
    }

    public void reset() {
        this.mTitle.setText("");
        this.bab.setText("");
        this.aGJ.setBackgroundDrawable(null);
        this.aGJ.setImageDrawable(null);
        this.aGS.setText("");
        this.aGS.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aXt = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void cr(boolean z) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.aGJ.setAutoChangeStyle(z);
        ba.a(this.mTitle, com.baidu.tieba.s.official_msg_bottom_text, 1, skinType);
        ba.a(this.bab, com.baidu.tieba.s.cp_cont_c, 1, skinType);
        ba.a(this.bad, com.baidu.tieba.s.official_msg_bottom_text, 1, skinType);
        ba.c(this.bae, com.baidu.tieba.u.icon_ba_top_arrow_big, skinType);
        ba.a(this.aGS, com.baidu.tieba.s.official_time_text, 1, skinType);
        ba.c(this.bac, com.baidu.tieba.u.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aGS.setVisibility(8);
            this.aGS.setText("");
            return;
        }
        this.aGS.setVisibility(0);
        this.aGS.setText(str);
    }
}
