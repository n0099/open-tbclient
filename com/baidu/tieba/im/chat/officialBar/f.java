package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class f extends RelativeLayout {
    private TextView JM;
    private int Uy;
    private com.baidu.adp.lib.c.b aOL;
    private TbImageView aQP;
    private TextView auh;
    private Context mContext;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOL = null;
        this.mContext = context;
        nu();
    }

    private void nu() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.msg_multi_pic_text_top_view, this, true);
        this.aQP = (TbImageView) findViewById(com.baidu.tieba.v.top_content_pic);
        this.JM = (TextView) findViewById(com.baidu.tieba.v.top_title);
        this.auh = (TextView) findViewById(com.baidu.tieba.v.show_time);
        setOnLongClickListener(new g(this));
    }

    public void a(p pVar, View view) {
        setPadding((int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_top_padding_bottom));
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.title)) {
                str = pVar.title;
            }
            this.JM.setText(str);
            if (!TextUtils.isEmpty(pVar.url)) {
                setOnClickListener(new h(this, pVar));
            }
            if (!TextUtils.isEmpty(pVar.src)) {
                this.aQP.setTag(pVar.src);
                this.aQP.c(pVar.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auh.setVisibility(8);
            this.auh.setText("");
            return;
        }
        this.auh.setVisibility(0);
        this.auh.setText(str);
    }

    public void reset() {
        this.JM.setText("");
        this.aQP.setBackgroundDrawable(null);
        this.aQP.setImageDrawable(null);
        this.auh.setVisibility(8);
        this.auh.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aOL = bVar;
    }

    public void setPosition(int i) {
        this.Uy = i;
    }

    public void cG(boolean z) {
        int i = z ? 1 : 0;
        com.baidu.tbadk.core.util.aw.a(this.JM, com.baidu.tieba.s.official_msg_top_text, 1, i);
        com.baidu.tbadk.core.util.aw.a(this.auh, com.baidu.tieba.s.official_time_text, 1, i);
    }
}
