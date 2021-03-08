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
/* loaded from: classes7.dex */
public class OfficialFeedItemBottom extends LinearLayout {
    private TextView kGb;
    private TextView kGc;
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
        this.kGb = (TextView) findViewById(R.id.message_no_image_title);
        this.kGc = (TextView) findViewById(R.id.message_info);
        cVt();
    }

    public void cVt() {
        ap.setViewTextColor(this.kGc, R.color.CAM_X0107);
        ap.setViewTextColor(this.kGb, R.color.CAM_X0105);
    }

    public void setData(a.C0767a c0767a, boolean z) {
        int i = TextUtils.isEmpty(c0767a.text) ? 8 : 0;
        this.kGb.setText(c0767a.title);
        this.kGc.setText(c0767a.text);
        this.kGc.setVisibility(i);
        if (z) {
            this.kGb.setVisibility(8);
        } else {
            this.kGb.setVisibility(0);
        }
    }

    public void CP(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kGc.getLayoutParams();
        layoutParams.topMargin = i;
        this.kGc.setLayoutParams(layoutParams);
    }
}
