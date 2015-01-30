package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class ar extends RelativeLayout {
    private TextView aUY;
    private View aUZ;
    private TextView aVa;
    private ImageView aVb;
    private View aVc;
    private TextView aVd;
    private TextView aVe;
    private TextView ayA;
    private TbImageView ayr;
    private Context mContext;
    private com.baidu.adp.lib.c.b mItemViewLongClickListener;
    private int mPosition;
    private TextView mTitle;

    public ar(Context context) {
        this(context, null);
    }

    public ar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mItemViewLongClickListener = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.msg_single_pic_text_view, this, true);
        this.mTitle = (TextView) findViewById(com.baidu.tieba.w.single_title);
        this.aUY = (TextView) findViewById(com.baidu.tieba.w.single_abstract);
        this.ayr = (TbImageView) findViewById(com.baidu.tieba.w.single_content_pic);
        this.ayr.setAutoChangeStyle(false);
        this.aVa = (TextView) findViewById(com.baidu.tieba.w.read_all);
        this.aVb = (ImageView) findViewById(com.baidu.tieba.w.arrow);
        this.aUZ = findViewById(com.baidu.tieba.w.single_divider);
        this.ayA = (TextView) findViewById(com.baidu.tieba.w.show_time_single);
        this.aVc = findViewById(com.baidu.tieba.w.office_msg_priase_include);
        this.aVd = (TextView) this.aVc.findViewById(com.baidu.tieba.w.office_msg_praise_text);
        this.aVe = (TextView) this.aVc.findViewById(com.baidu.tieba.w.office_msg_praise_number);
        setOnLongClickListener(new as(this));
    }

    public void a(TbPageContext<?> tbPageContext, p pVar, View view, int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.multi_padding_left_right), 0, 0);
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.title)) {
                str = pVar.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(pVar.text)) {
                str2 = pVar.text;
            }
            this.aUY.setText(str2);
            if (!TextUtils.isEmpty(pVar.url)) {
                setOnClickListener(new at(this, tbPageContext, pVar, i));
            }
            if (!TextUtils.isEmpty(pVar.src)) {
                this.ayr.setTag(pVar.src);
                this.ayr.d(pVar.src, 10, false);
            }
            long j = pVar.aUf;
            long j2 = pVar.aUh;
            if (j <= 0 && j2 <= 0) {
                this.aVc.setVisibility(8);
                return;
            }
            if (j <= 0) {
                this.aVd.setVisibility(4);
            } else {
                this.aVd.setVisibility(0);
                this.aVd.setText(a(pVar));
            }
            if (j2 <= 0) {
                this.aVe.setVisibility(4);
                return;
            }
            this.aVe.setVisibility(0);
            this.aVe.setText(new StringBuilder(String.valueOf(pVar.aUh)).toString());
        }
    }

    private String a(p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar.aUe + pVar.aUf + pVar.aUg;
    }

    public void reset() {
        this.mTitle.setText("");
        this.aUY.setText("");
        this.ayr.setBackgroundDrawable(null);
        this.ayr.setImageDrawable(null);
        this.ayA.setText("");
        this.ayA.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.mItemViewLongClickListener = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void cy(boolean z) {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.ayr.setAutoChangeStyle(z);
        bc.a(this.mTitle, com.baidu.tieba.t.official_msg_bottom_text, 1, skinType);
        bc.a(this.aUY, com.baidu.tieba.t.cp_cont_c, 1, skinType);
        bc.a(this.aVa, com.baidu.tieba.t.official_msg_bottom_text, 1, skinType);
        bc.c(this.aVb, com.baidu.tieba.v.icon_ba_top_arrow_big, skinType);
        bc.a(this.ayA, com.baidu.tieba.t.official_time_text, 1, skinType);
        bc.c(this.aUZ, com.baidu.tieba.v.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ayA.setVisibility(8);
            this.ayA.setText("");
            return;
        }
        this.ayA.setVisibility(0);
        this.ayA.setText(str);
    }
}
