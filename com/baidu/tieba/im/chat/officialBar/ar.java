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
    private TextView aUX;
    private View aUY;
    private TextView aUZ;
    private ImageView aVa;
    private View aVb;
    private TextView aVc;
    private TextView aVd;
    private TbImageView ayo;
    private TextView ayx;
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
        this.aUX = (TextView) findViewById(com.baidu.tieba.w.single_abstract);
        this.ayo = (TbImageView) findViewById(com.baidu.tieba.w.single_content_pic);
        this.ayo.setAutoChangeStyle(false);
        this.aUZ = (TextView) findViewById(com.baidu.tieba.w.read_all);
        this.aVa = (ImageView) findViewById(com.baidu.tieba.w.arrow);
        this.aUY = findViewById(com.baidu.tieba.w.single_divider);
        this.ayx = (TextView) findViewById(com.baidu.tieba.w.show_time_single);
        this.aVb = findViewById(com.baidu.tieba.w.office_msg_priase_include);
        this.aVc = (TextView) this.aVb.findViewById(com.baidu.tieba.w.office_msg_praise_text);
        this.aVd = (TextView) this.aVb.findViewById(com.baidu.tieba.w.office_msg_praise_number);
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
            this.aUX.setText(str2);
            if (!TextUtils.isEmpty(pVar.url)) {
                setOnClickListener(new at(this, tbPageContext, pVar, i));
            }
            if (!TextUtils.isEmpty(pVar.src)) {
                this.ayo.setTag(pVar.src);
                this.ayo.d(pVar.src, 10, false);
            }
            long j = pVar.aUe;
            long j2 = pVar.aUg;
            if (j <= 0 && j2 <= 0) {
                this.aVb.setVisibility(8);
                return;
            }
            if (j <= 0) {
                this.aVc.setVisibility(4);
            } else {
                this.aVc.setVisibility(0);
                this.aVc.setText(a(pVar));
            }
            if (j2 <= 0) {
                this.aVd.setVisibility(4);
                return;
            }
            this.aVd.setVisibility(0);
            this.aVd.setText(new StringBuilder(String.valueOf(pVar.aUg)).toString());
        }
    }

    private String a(p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar.aUd + pVar.aUe + pVar.aUf;
    }

    public void reset() {
        this.mTitle.setText("");
        this.aUX.setText("");
        this.ayo.setBackgroundDrawable(null);
        this.ayo.setImageDrawable(null);
        this.ayx.setText("");
        this.ayx.setVisibility(8);
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
        this.ayo.setAutoChangeStyle(z);
        bc.a(this.mTitle, com.baidu.tieba.t.official_msg_bottom_text, 1, skinType);
        bc.a(this.aUX, com.baidu.tieba.t.cp_cont_c, 1, skinType);
        bc.a(this.aUZ, com.baidu.tieba.t.official_msg_bottom_text, 1, skinType);
        bc.c(this.aVa, com.baidu.tieba.v.icon_ba_top_arrow_big, skinType);
        bc.a(this.ayx, com.baidu.tieba.t.official_time_text, 1, skinType);
        bc.c(this.aUY, com.baidu.tieba.v.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ayx.setVisibility(8);
            this.ayx.setText("");
            return;
        }
        this.ayx.setVisibility(0);
        this.ayx.setText(str);
    }
}
