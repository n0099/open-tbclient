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
    private TextView JN;
    private int UC;
    private com.baidu.adp.lib.c.b aOZ;
    private TbImageView aRd;
    private Context mContext;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOZ = null;
        this.mContext = context;
        nu();
        setOnLongClickListener(new d(this));
    }

    private void nu() {
        setOrientation(0);
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.msg_multi_pic_text_bottom_view, this, true);
        this.aRd = (TbImageView) findViewById(com.baidu.tieba.v.bottom_content_pic);
        this.JN = (TextView) findViewById(com.baidu.tieba.v.bottom_title);
    }

    public void a(p pVar, View view) {
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.title)) {
                str = pVar.title;
            }
            this.JN.setText(str);
            if (!TextUtils.isEmpty(pVar.url)) {
                setOnClickListener(new e(this, pVar));
            }
            if (!TextUtils.isEmpty(pVar.src)) {
                this.aRd.setTag(pVar.src);
                this.aRd.c(pVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.JN.setText("");
        this.aRd.setBackgroundDrawable(null);
        this.aRd.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aOZ = bVar;
    }

    public void setPosition(int i) {
        this.UC = i;
    }

    public void cG(boolean z) {
        com.baidu.tbadk.core.util.aw.a(this.JN, com.baidu.tieba.s.official_msg_bottom_text, 1, z ? 1 : 0);
    }
}
