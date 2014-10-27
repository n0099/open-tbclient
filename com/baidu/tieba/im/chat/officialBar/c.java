package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private TextView JM;
    private int Uy;
    private com.baidu.adp.lib.c.b aOL;
    private TbImageView aQP;
    private Context mContext;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOL = null;
        this.mContext = context;
        nu();
        setOnLongClickListener(new d(this));
    }

    private void nu() {
        setOrientation(0);
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.msg_multi_pic_text_bottom_view, this, true);
        this.aQP = (TbImageView) findViewById(com.baidu.tieba.v.bottom_content_pic);
        this.JM = (TextView) findViewById(com.baidu.tieba.v.bottom_title);
    }

    public void a(p pVar, View view) {
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.title)) {
                str = pVar.title;
            }
            this.JM.setText(str);
            if (!TextUtils.isEmpty(pVar.url)) {
                setOnClickListener(new e(this, pVar));
            }
            if (!TextUtils.isEmpty(pVar.src)) {
                this.aQP.setTag(pVar.src);
                this.aQP.c(pVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.JM.setText("");
        this.aQP.setBackgroundDrawable(null);
        this.aQP.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aOL = bVar;
    }

    public void setPosition(int i) {
        this.Uy = i;
    }

    public void cG(boolean z) {
        com.baidu.tbadk.core.util.aw.a(this.JM, com.baidu.tieba.s.official_msg_bottom_text, 1, z ? 1 : 0);
    }
}
