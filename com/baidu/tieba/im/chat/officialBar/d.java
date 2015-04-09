package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private com.baidu.adp.lib.c.b aXt;
    private TbImageView aYN;
    private int aYO;
    private String aYP;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXt = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new e(this));
    }

    private void initView() {
        setOrientation(0);
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.msg_multi_pic_text_bottom_view, this, true);
        this.aYN = (TbImageView) findViewById(com.baidu.tieba.v.bottom_content_pic);
        this.aYN.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(com.baidu.tieba.v.bottom_title);
    }

    public void a(TbPageContext<?> tbPageContext, q qVar, View view, int i) {
        if (qVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(qVar.title)) {
                str = qVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(qVar.url)) {
                setOnClickListener(new f(this, tbPageContext, qVar, i));
            }
            if (!TextUtils.isEmpty(qVar.src)) {
                this.aYN.setTag(qVar.src);
                this.aYN.c(qVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.aYN.setBackgroundDrawable(null);
        this.aYN.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aXt = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.aYO = i;
    }

    public void setTaskInfo(String str) {
        this.aYP = str;
    }

    public void cr(boolean z) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.aYN.setAutoChangeStyle(z);
        ba.a(this.mTitle, com.baidu.tieba.s.official_msg_bottom_text, 1, skinType);
    }
}
