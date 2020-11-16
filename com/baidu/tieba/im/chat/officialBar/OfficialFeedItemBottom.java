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
    private TextView jZY;
    private TextView jZZ;
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
        this.jZY = (TextView) findViewById(R.id.message_no_image_title);
        this.jZZ = (TextView) findViewById(R.id.message_info);
        cOX();
    }

    public void cOX() {
        ap.setViewTextColor(this.jZZ, R.color.CAM_X0107);
        ap.setViewTextColor(this.jZY, R.color.CAM_X0105);
    }

    public void setData(a.C0766a c0766a, boolean z) {
        int i = TextUtils.isEmpty(c0766a.text) ? 8 : 0;
        this.jZY.setText(c0766a.title);
        this.jZZ.setText(c0766a.text);
        this.jZZ.setVisibility(i);
        if (z) {
            this.jZY.setVisibility(8);
        } else {
            this.jZY.setVisibility(0);
        }
    }

    public void Da(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jZZ.getLayoutParams();
        layoutParams.topMargin = i;
        this.jZZ.setLayoutParams(layoutParams);
    }
}
