package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class ar extends RelativeLayout {
    private TextView aTI;
    private View aTJ;
    private TextView aTK;
    private ImageView aTL;
    private TextView axA;
    private TbImageView axr;
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
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.msg_single_pic_text_view, this, true);
        this.mTitle = (TextView) findViewById(com.baidu.tieba.w.single_title);
        this.aTI = (TextView) findViewById(com.baidu.tieba.w.single_abstract);
        this.axr = (TbImageView) findViewById(com.baidu.tieba.w.single_content_pic);
        this.axr.setAutoChangeStyle(false);
        this.aTK = (TextView) findViewById(com.baidu.tieba.w.read_all);
        this.aTL = (ImageView) findViewById(com.baidu.tieba.w.arrow);
        this.aTJ = findViewById(com.baidu.tieba.w.single_divider);
        this.axA = (TextView) findViewById(com.baidu.tieba.w.show_time_single);
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
            this.aTI.setText(str2);
            if (!TextUtils.isEmpty(pVar.url)) {
                setOnClickListener(new at(this, tbPageContext, pVar, i));
            }
            if (!TextUtils.isEmpty(pVar.src)) {
                this.axr.setTag(pVar.src);
                this.axr.d(pVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.aTI.setText("");
        this.axr.setBackgroundDrawable(null);
        this.axr.setImageDrawable(null);
        this.axA.setText("");
        this.axA.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.mItemViewLongClickListener = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void cu(boolean z) {
        int i = z ? 1 : 0;
        ax.a(this.mTitle, com.baidu.tieba.t.official_msg_bottom_text, 1, i);
        ax.a(this.aTI, com.baidu.tieba.t.cp_cont_c, 1, i);
        ax.a(this.aTK, com.baidu.tieba.t.official_msg_bottom_text, 1, i);
        ax.c(this.aTL, com.baidu.tieba.v.icon_ba_top_arrow_big, i);
        ax.a(this.axA, com.baidu.tieba.t.official_time_text, 1, i);
        ax.c(this.aTJ, com.baidu.tieba.v.multi_single_divider_selector, i);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axA.setVisibility(8);
            this.axA.setText("");
            return;
        }
        this.axA.setVisibility(0);
        this.axA.setText(str);
    }
}
