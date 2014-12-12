package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private TbImageView aSH;
    private Context mContext;
    private com.baidu.adp.lib.c.b mItemViewLongClickListener;
    private int mPosition;
    private TextView mTitle;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemViewLongClickListener = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new d(this));
    }

    private void initView() {
        setOrientation(0);
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.msg_multi_pic_text_bottom_view, this, true);
        this.aSH = (TbImageView) findViewById(com.baidu.tieba.w.bottom_content_pic);
        this.aSH.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(com.baidu.tieba.w.bottom_title);
    }

    public void a(TbPageContext<?> tbPageContext, p pVar, View view, int i) {
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.title)) {
                str = pVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(pVar.url)) {
                setOnClickListener(new e(this, tbPageContext, pVar, i));
            }
            if (!TextUtils.isEmpty(pVar.src)) {
                this.aSH.setTag(pVar.src);
                this.aSH.d(pVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.aSH.setBackgroundDrawable(null);
        this.aSH.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.mItemViewLongClickListener = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void cu(boolean z) {
        ax.a(this.mTitle, com.baidu.tieba.t.official_msg_bottom_text, 1, z ? 1 : 0);
    }
}
