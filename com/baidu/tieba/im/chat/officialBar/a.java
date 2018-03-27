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
    LinearLayout bct;
    TbRichTextView exw;
    TextView exx;
    ChatImageWithTailView exy;
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
        this.bct = (LinearLayout) findViewById(d.g.history_container);
        this.exx = (TextView) findViewById(d.g.history_send_time);
        this.exw = (TbRichTextView) findViewById(d.g.history_txt);
        this.exy = (ChatImageWithTailView) findViewById(d.g.history_pic);
        aj.s(this.bct, d.f.selector_history_multi_single_bg);
        aj.e(this.exx, d.C0141d.common_color_10067, 1);
        this.exw.setTextColor(aj.getColor(d.C0141d.cp_cont_c));
        this.exy.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.exx.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.exw;
    }

    public ChatImageWithTailView getImageView() {
        return this.exy;
    }

    public void bZ(View view) {
        this.bct.setBackgroundDrawable(null);
        this.bct.removeAllViews();
        this.bct.addView(view);
    }
}
