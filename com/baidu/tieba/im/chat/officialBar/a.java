package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    LinearLayout Mg;
    ChatImageWithTailView aSA;
    TbRichTextView aSy;
    TextView aSz;
    Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setOrientation(1);
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.official_history_item, this, true);
        setClickable(false);
        setFocusable(false);
        this.Mg = (LinearLayout) findViewById(com.baidu.tieba.w.history_container);
        this.aSz = (TextView) findViewById(com.baidu.tieba.w.history_send_time);
        this.aSy = (TbRichTextView) findViewById(com.baidu.tieba.w.history_txt);
        this.aSA = (ChatImageWithTailView) findViewById(com.baidu.tieba.w.history_pic);
        ax.i(this.Mg, com.baidu.tieba.v.selector_history_multi_single_bg);
        ax.b(this.aSz, com.baidu.tieba.t.official_time_text, 1);
        ax.b(this.aSy, com.baidu.tieba.t.cp_cont_c, 1);
    }

    public void setTime(String str) {
        this.aSz.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.aSy;
    }

    public ChatImageWithTailView getImageView() {
        return this.aSA;
    }

    public void C(View view) {
        this.Mg.setBackgroundDrawable(null);
        this.Mg.removeAllViews();
        this.Mg.addView(view);
    }
}
