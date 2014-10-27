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
    private TextView JM;
    private int Uy;
    private com.baidu.adp.lib.c.b aOL;
    private TextView aSf;
    private View aSg;
    private TextView aSh;
    private ImageView aSi;
    private TbImageView atZ;
    private TextView auh;
    private Context mContext;

    public ba(Context context) {
        this(context, null);
    }

    public ba(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ba(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOL = null;
        this.mContext = context;
        nu();
    }

    private void nu() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.msg_single_pic_text_view, this, true);
        this.JM = (TextView) findViewById(com.baidu.tieba.v.single_title);
        this.aSf = (TextView) findViewById(com.baidu.tieba.v.single_abstract);
        this.atZ = (TbImageView) findViewById(com.baidu.tieba.v.single_content_pic);
        this.aSh = (TextView) findViewById(com.baidu.tieba.v.read_all);
        this.aSi = (ImageView) findViewById(com.baidu.tieba.v.arrow);
        this.aSg = findViewById(com.baidu.tieba.v.single_divider);
        this.auh = (TextView) findViewById(com.baidu.tieba.v.show_time_single);
        setOnLongClickListener(new bb(this));
    }

    public void a(p pVar, View view) {
        setPadding(0, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.multi_padding_left_right), 0, 0);
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.title)) {
                str = pVar.title;
            }
            this.JM.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(pVar.text)) {
                str2 = pVar.text;
            }
            this.aSf.setText(str2);
            if (!TextUtils.isEmpty(pVar.url)) {
                setOnClickListener(new bc(this, pVar));
            }
            if (!TextUtils.isEmpty(pVar.src)) {
                this.atZ.setTag(pVar.src);
                this.atZ.setAutoChangeStyle(false);
                this.atZ.c(pVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.JM.setText("");
        this.aSf.setText("");
        this.atZ.setBackgroundDrawable(null);
        this.atZ.setImageDrawable(null);
        this.auh.setText("");
        this.auh.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aOL = bVar;
    }

    public void setPosition(int i) {
        this.Uy = i;
    }

    public void cG(boolean z) {
        int i = z ? 1 : 0;
        com.baidu.tbadk.core.util.aw.a(this.JM, com.baidu.tieba.s.official_msg_bottom_text, 1, i);
        com.baidu.tbadk.core.util.aw.a(this.aSf, com.baidu.tieba.s.official_abstract, 1, i);
        com.baidu.tbadk.core.util.aw.a(this.aSh, com.baidu.tieba.s.official_msg_bottom_text, 1, i);
        com.baidu.tbadk.core.util.aw.c(this.aSi, com.baidu.tieba.u.icon_ba_top_arrow_big, i);
        com.baidu.tbadk.core.util.aw.a(this.auh, com.baidu.tieba.s.official_time_text, 1, i);
        com.baidu.tbadk.core.util.aw.c(this.aSg, com.baidu.tieba.u.multi_single_divider_selector, i);
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
}
