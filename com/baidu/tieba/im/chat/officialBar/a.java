package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    LinearLayout XI;
    TbRichTextView aYC;
    TextView aYD;
    ChatImageWithTailView aYE;
    Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setOrientation(1);
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.official_history_item, this, true);
        setClickable(false);
        setFocusable(false);
        this.XI = (LinearLayout) findViewById(com.baidu.tieba.v.history_container);
        this.aYD = (TextView) findViewById(com.baidu.tieba.v.history_send_time);
        this.aYC = (TbRichTextView) findViewById(com.baidu.tieba.v.history_txt);
        this.aYE = (ChatImageWithTailView) findViewById(com.baidu.tieba.v.history_pic);
        ba.i(this.XI, com.baidu.tieba.u.selector_history_multi_single_bg);
        ba.b(this.aYD, com.baidu.tieba.s.official_time_text, 1);
        this.aYC.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_c));
        this.aYE.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.aYD.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.aYC;
    }

    public ChatImageWithTailView getImageView() {
        return this.aYE;
    }

    public void A(View view) {
        this.XI.setBackgroundDrawable(null);
        this.XI.removeAllViews();
        this.XI.addView(view);
    }
}
