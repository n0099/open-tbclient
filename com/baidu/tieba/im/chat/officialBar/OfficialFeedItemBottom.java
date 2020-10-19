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
/* loaded from: classes26.dex */
public class OfficialFeedItemBottom extends LinearLayout {
    private TextView jGT;
    private TextView jGU;
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
        this.jGT = (TextView) findViewById(R.id.message_no_image_title);
        this.jGU = (TextView) findViewById(R.id.message_info);
        cJJ();
    }

    public void cJJ() {
        ap.setViewTextColor(this.jGU, R.color.cp_cont_j);
        ap.setViewTextColor(this.jGT, R.color.cp_cont_b);
    }

    public void setData(a.C0734a c0734a, boolean z) {
        int i = TextUtils.isEmpty(c0734a.text) ? 8 : 0;
        this.jGT.setText(c0734a.title);
        this.jGU.setText(c0734a.text);
        this.jGU.setVisibility(i);
        if (z) {
            this.jGT.setVisibility(8);
        } else {
            this.jGT.setVisibility(0);
        }
    }

    public void BW(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jGU.getLayoutParams();
        layoutParams.topMargin = i;
        this.jGU.setLayoutParams(layoutParams);
    }
}
