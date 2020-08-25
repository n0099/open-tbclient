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
/* loaded from: classes20.dex */
public class OfficialFeedItemBottom extends LinearLayout {
    private TextView jjm;
    private TextView jjn;
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
        this.jjm = (TextView) findViewById(R.id.message_no_image_title);
        this.jjn = (TextView) findViewById(R.id.message_info);
        cCt();
    }

    public void cCt() {
        ap.setViewTextColor(this.jjn, R.color.cp_cont_j);
        ap.setViewTextColor(this.jjm, R.color.cp_cont_b);
    }

    public void setData(a.C0719a c0719a, boolean z) {
        int i = TextUtils.isEmpty(c0719a.text) ? 8 : 0;
        this.jjm.setText(c0719a.title);
        this.jjn.setText(c0719a.text);
        this.jjn.setVisibility(i);
        if (z) {
            this.jjm.setVisibility(8);
        } else {
            this.jjm.setVisibility(0);
        }
    }

    public void AP(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jjn.getLayoutParams();
        layoutParams.topMargin = i;
        this.jjn.setLayoutParams(layoutParams);
    }
}
