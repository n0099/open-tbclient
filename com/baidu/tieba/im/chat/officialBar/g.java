package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class g extends RelativeLayout {
    private TextView aGS;
    private com.baidu.adp.lib.c.b aXt;
    private TbImageView aYN;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXt = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.msg_multi_pic_text_top_view, this, true);
        this.aYN = (TbImageView) findViewById(com.baidu.tieba.v.top_content_pic);
        this.aYN.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(com.baidu.tieba.v.top_title);
        this.aGS = (TextView) findViewById(com.baidu.tieba.v.show_time);
        setOnLongClickListener(new h(this));
    }

    public void a(TbPageContext<?> tbPageContext, q qVar, View view, int i) {
        setPadding((int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_top_padding_bottom));
        if (qVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(qVar.title)) {
                str = qVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(qVar.url)) {
                setOnClickListener(new i(this, tbPageContext, qVar, i));
            }
            if (!TextUtils.isEmpty(qVar.src)) {
                this.aYN.setTag(qVar.src);
                this.aYN.c(qVar.src, 10, false);
            }
        }
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

    public void reset() {
        this.mTitle.setText("");
        this.aYN.setBackgroundDrawable(null);
        this.aYN.setImageDrawable(null);
        this.aGS.setVisibility(8);
        this.aGS.setText("");
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
        this.aYN.setAutoChangeStyle(z);
        ba.a(this.mTitle, com.baidu.tieba.s.cp_cont_g, 1, skinType);
        ba.a(this.aGS, com.baidu.tieba.s.official_time_text, 1, skinType);
    }
}
