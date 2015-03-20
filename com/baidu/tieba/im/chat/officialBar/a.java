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
    LinearLayout XG;
    TbRichTextView aYm;
    TextView aYn;
    ChatImageWithTailView aYo;
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
        this.XG = (LinearLayout) findViewById(com.baidu.tieba.v.history_container);
        this.aYn = (TextView) findViewById(com.baidu.tieba.v.history_send_time);
        this.aYm = (TbRichTextView) findViewById(com.baidu.tieba.v.history_txt);
        this.aYo = (ChatImageWithTailView) findViewById(com.baidu.tieba.v.history_pic);
        ba.i(this.XG, com.baidu.tieba.u.selector_history_multi_single_bg);
        ba.b(this.aYn, com.baidu.tieba.s.official_time_text, 1);
        this.aYm.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_c));
        this.aYo.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.aYn.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.aYm;
    }

    public ChatImageWithTailView getImageView() {
        return this.aYo;
    }

    public void A(View view) {
        this.XG.setBackgroundDrawable(null);
        this.XG.removeAllViews();
        this.XG.addView(view);
    }
}
