package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class f extends RelativeLayout {
    private TbImageView aTR;
    private TextView ayA;
    private Context mContext;
    private com.baidu.adp.lib.c.b mItemViewLongClickListener;
    private int mPosition;
    private TextView mTitle;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mItemViewLongClickListener = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.msg_multi_pic_text_top_view, this, true);
        this.aTR = (TbImageView) findViewById(com.baidu.tieba.w.top_content_pic);
        this.aTR.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(com.baidu.tieba.w.top_title);
        this.ayA = (TextView) findViewById(com.baidu.tieba.w.show_time);
        setOnLongClickListener(new g(this));
    }

    public void a(TbPageContext<?> tbPageContext, p pVar, View view, int i) {
        setPadding((int) this.mContext.getResources().getDimension(com.baidu.tieba.u.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.multi_top_padding_bottom));
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.title)) {
                str = pVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(pVar.url)) {
                setOnClickListener(new h(this, tbPageContext, pVar, i));
            }
            if (!TextUtils.isEmpty(pVar.src)) {
                this.aTR.setTag(pVar.src);
                this.aTR.d(pVar.src, 10, false);
            }
        }
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

    public void reset() {
        this.mTitle.setText("");
        this.aTR.setBackgroundDrawable(null);
        this.aTR.setImageDrawable(null);
        this.ayA.setVisibility(8);
        this.ayA.setText("");
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
        this.aTR.setAutoChangeStyle(z);
        bc.a(this.mTitle, com.baidu.tieba.t.cp_cont_g, 1, skinType);
        bc.a(this.ayA, com.baidu.tieba.t.official_time_text, 1, skinType);
    }
}
