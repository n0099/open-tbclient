package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes3.dex */
public class a extends LinearLayout {
    LinearLayout bcr;
    TbRichTextView exf;
    TextView exg;
    ChatImageWithTailView exh;
    Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setOrientation(1);
        LayoutInflater.from(this.mContext).inflate(d.h.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.bcr = (LinearLayout) findViewById(d.g.history_container);
        this.exg = (TextView) findViewById(d.g.history_send_time);
        this.exf = (TbRichTextView) findViewById(d.g.history_txt);
        this.exh = (ChatImageWithTailView) findViewById(d.g.history_pic);
        aj.s(this.bcr, d.f.selector_history_multi_single_bg);
        aj.e(this.exg, d.C0141d.common_color_10067, 1);
        this.exf.setTextColor(aj.getColor(d.C0141d.cp_cont_c));
        this.exh.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.exg.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.exf;
    }

    public ChatImageWithTailView getImageView() {
        return this.exh;
    }

    public void bZ(View view) {
        this.bcr.setBackgroundDrawable(null);
        this.bcr.removeAllViews();
        this.bcr.addView(view);
    }
}
