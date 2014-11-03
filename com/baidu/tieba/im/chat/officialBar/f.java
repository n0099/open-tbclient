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
    private TextView JN;
    private int UC;
    private com.baidu.adp.lib.c.b aOZ;
    private TbImageView aRd;
    private TextView auq;
    private Context mContext;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOZ = null;
        this.mContext = context;
        nu();
    }

    private void nu() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.msg_multi_pic_text_top_view, this, true);
        this.aRd = (TbImageView) findViewById(com.baidu.tieba.v.top_content_pic);
        this.JN = (TextView) findViewById(com.baidu.tieba.v.top_title);
        this.auq = (TextView) findViewById(com.baidu.tieba.v.show_time);
        setOnLongClickListener(new g(this));
    }

    public void a(p pVar, View view) {
        setPadding((int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_top_padding_bottom));
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.title)) {
                str = pVar.title;
            }
            this.JN.setText(str);
            if (!TextUtils.isEmpty(pVar.url)) {
                setOnClickListener(new h(this, pVar));
            }
            if (!TextUtils.isEmpty(pVar.src)) {
                this.aRd.setTag(pVar.src);
                this.aRd.c(pVar.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auq.setVisibility(8);
            this.auq.setText("");
            return;
        }
        this.auq.setVisibility(0);
        this.auq.setText(str);
    }

    public void reset() {
        this.JN.setText("");
        this.aRd.setBackgroundDrawable(null);
        this.aRd.setImageDrawable(null);
        this.auq.setVisibility(8);
        this.auq.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aOZ = bVar;
    }

    public void setPosition(int i) {
        this.UC = i;
    }

    public void cG(boolean z) {
        int i = z ? 1 : 0;
        com.baidu.tbadk.core.util.aw.a(this.JN, com.baidu.tieba.s.official_msg_top_text, 1, i);
        com.baidu.tbadk.core.util.aw.a(this.auq, com.baidu.tieba.s.official_time_text, 1, i);
    }
}
