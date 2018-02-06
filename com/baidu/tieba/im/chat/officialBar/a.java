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
    LinearLayout bcD;
    TbRichTextView exr;
    TextView exs;
    ChatImageWithTailView exu;
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
        this.bcD = (LinearLayout) findViewById(d.g.history_container);
        this.exs = (TextView) findViewById(d.g.history_send_time);
        this.exr = (TbRichTextView) findViewById(d.g.history_txt);
        this.exu = (ChatImageWithTailView) findViewById(d.g.history_pic);
        aj.s(this.bcD, d.f.selector_history_multi_single_bg);
        aj.e(this.exs, d.C0140d.common_color_10067, 1);
        this.exr.setTextColor(aj.getColor(d.C0140d.cp_cont_c));
        this.exu.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.exs.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.exr;
    }

    public ChatImageWithTailView getImageView() {
        return this.exu;
    }

    public void bZ(View view) {
        this.bcD.setBackgroundDrawable(null);
        this.bcD.removeAllViews();
        this.bcD.addView(view);
    }
}
