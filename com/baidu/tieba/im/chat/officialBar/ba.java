package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class ba extends RelativeLayout {
    private TextView JN;
    private int UC;
    private com.baidu.adp.lib.c.b aOZ;
    private TextView aSt;
    private View aSu;
    private TextView aSv;
    private ImageView aSw;
    private TbImageView aui;
    private TextView auq;
    private Context mContext;

    public ba(Context context) {
        this(context, null);
    }

    public ba(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ba(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOZ = null;
        this.mContext = context;
        nu();
    }

    private void nu() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.msg_single_pic_text_view, this, true);
        this.JN = (TextView) findViewById(com.baidu.tieba.v.single_title);
        this.aSt = (TextView) findViewById(com.baidu.tieba.v.single_abstract);
        this.aui = (TbImageView) findViewById(com.baidu.tieba.v.single_content_pic);
        this.aSv = (TextView) findViewById(com.baidu.tieba.v.read_all);
        this.aSw = (ImageView) findViewById(com.baidu.tieba.v.arrow);
        this.aSu = findViewById(com.baidu.tieba.v.single_divider);
        this.auq = (TextView) findViewById(com.baidu.tieba.v.show_time_single);
        setOnLongClickListener(new bb(this));
    }

    public void a(p pVar, View view) {
        setPadding(0, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), 0, 0);
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.title)) {
                str = pVar.title;
            }
            this.JN.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(pVar.text)) {
                str2 = pVar.text;
            }
            this.aSt.setText(str2);
            if (!TextUtils.isEmpty(pVar.url)) {
                setOnClickListener(new bc(this, pVar));
            }
            if (!TextUtils.isEmpty(pVar.src)) {
                this.aui.setTag(pVar.src);
                this.aui.setAutoChangeStyle(false);
                this.aui.c(pVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.JN.setText("");
        this.aSt.setText("");
        this.aui.setBackgroundDrawable(null);
        this.aui.setImageDrawable(null);
        this.auq.setText("");
        this.auq.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aOZ = bVar;
    }

    public void setPosition(int i) {
        this.UC = i;
    }

    public void cG(boolean z) {
        int i = z ? 1 : 0;
        com.baidu.tbadk.core.util.aw.a(this.JN, com.baidu.tieba.s.official_msg_bottom_text, 1, i);
        com.baidu.tbadk.core.util.aw.a(this.aSt, com.baidu.tieba.s.official_abstract, 1, i);
        com.baidu.tbadk.core.util.aw.a(this.aSv, com.baidu.tieba.s.official_msg_bottom_text, 1, i);
        com.baidu.tbadk.core.util.aw.c(this.aSw, com.baidu.tieba.u.icon_ba_top_arrow_big, i);
        com.baidu.tbadk.core.util.aw.a(this.auq, com.baidu.tieba.s.official_time_text, 1, i);
        com.baidu.tbadk.core.util.aw.c(this.aSu, com.baidu.tieba.u.multi_single_divider_selector, i);
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
}
