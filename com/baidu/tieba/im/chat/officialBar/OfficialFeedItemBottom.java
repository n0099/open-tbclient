package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes25.dex */
public class OfficialFeedItemBottom extends LinearLayout {
    private TextView jrW;
    private TextView jrX;
    private Context mContext;

    public OfficialFeedItemBottom(Context context) {
        this(context, null);
    }

    public OfficialFeedItemBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setOrientation(1);
        LayoutInflater.from(this.mContext).inflate(R.layout.official_feed_item_bottom, (ViewGroup) this, true);
        this.jrW = (TextView) findViewById(R.id.message_no_image_title);
        this.jrX = (TextView) findViewById(R.id.message_info);
        cGa();
    }

    public void cGa() {
        ap.setViewTextColor(this.jrX, R.color.cp_cont_j);
        ap.setViewTextColor(this.jrW, R.color.cp_cont_b);
    }

    public void setData(a.C0716a c0716a, boolean z) {
        int i = TextUtils.isEmpty(c0716a.text) ? 8 : 0;
        this.jrW.setText(c0716a.title);
        this.jrX.setText(c0716a.text);
        this.jrX.setVisibility(i);
        if (z) {
            this.jrW.setVisibility(8);
        } else {
            this.jrW.setVisibility(0);
        }
    }

    public void Bq(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jrX.getLayoutParams();
        layoutParams.topMargin = i;
        this.jrX.setLayoutParams(layoutParams);
    }
}
