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
    LinearLayout MC;
    TbRichTextView aTI;
    TextView aTJ;
    ChatImageWithTailView aTK;
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
        this.MC = (LinearLayout) findViewById(com.baidu.tieba.w.history_container);
        this.aTJ = (TextView) findViewById(com.baidu.tieba.w.history_send_time);
        this.aTI = (TbRichTextView) findViewById(com.baidu.tieba.w.history_txt);
        this.aTK = (ChatImageWithTailView) findViewById(com.baidu.tieba.w.history_pic);
        bc.i(this.MC, com.baidu.tieba.v.selector_history_multi_single_bg);
        bc.b(this.aTJ, com.baidu.tieba.t.official_time_text, 1);
        bc.b(this.aTI, com.baidu.tieba.t.cp_cont_c, 1);
    }

    public void setTime(String str) {
        this.aTJ.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.aTI;
    }

    public ChatImageWithTailView getImageView() {
        return this.aTK;
    }

    public void C(View view) {
        this.MC.setBackgroundDrawable(null);
        this.MC.removeAllViews();
        this.MC.addView(view);
    }
}
