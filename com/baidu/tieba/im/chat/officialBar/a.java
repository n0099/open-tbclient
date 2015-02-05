package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    LinearLayout Mz;
    TbRichTextView aTH;
    TextView aTI;
    ChatImageWithTailView aTJ;
    Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setOrientation(1);
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.official_history_item, this, true);
        setClickable(false);
        setFocusable(false);
        this.Mz = (LinearLayout) findViewById(com.baidu.tieba.w.history_container);
        this.aTI = (TextView) findViewById(com.baidu.tieba.w.history_send_time);
        this.aTH = (TbRichTextView) findViewById(com.baidu.tieba.w.history_txt);
        this.aTJ = (ChatImageWithTailView) findViewById(com.baidu.tieba.w.history_pic);
        bc.i(this.Mz, com.baidu.tieba.v.selector_history_multi_single_bg);
        bc.b(this.aTI, com.baidu.tieba.t.official_time_text, 1);
        this.aTH.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_c));
    }

    public void setTime(String str) {
        this.aTI.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.aTH;
    }

    public ChatImageWithTailView getImageView() {
        return this.aTJ;
    }

    public void C(View view) {
        this.Mz.setBackgroundDrawable(null);
        this.Mz.removeAllViews();
        this.Mz.addView(view);
    }
}
