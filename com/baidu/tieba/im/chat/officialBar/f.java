package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class f extends RelativeLayout {
    private TbImageView aSH;
    private TextView axA;
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
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.msg_multi_pic_text_top_view, this, true);
        this.aSH = (TbImageView) findViewById(com.baidu.tieba.w.top_content_pic);
        this.aSH.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(com.baidu.tieba.w.top_title);
        this.axA = (TextView) findViewById(com.baidu.tieba.w.show_time);
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
                this.aSH.setTag(pVar.src);
                this.aSH.d(pVar.src, 10, false);
            }
        }
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

    public void reset() {
        this.mTitle.setText("");
        this.aSH.setBackgroundDrawable(null);
        this.aSH.setImageDrawable(null);
        this.axA.setVisibility(8);
        this.axA.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.mItemViewLongClickListener = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void cu(boolean z) {
        int i = z ? 1 : 0;
        ax.a(this.mTitle, com.baidu.tieba.t.cp_bg_line_d, 1, i);
        ax.a(this.axA, com.baidu.tieba.t.official_time_text, 1, i);
    }
}
