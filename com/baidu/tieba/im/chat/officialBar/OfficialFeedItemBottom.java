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
    private TextView knF;
    private TextView knG;
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
        this.knF = (TextView) findViewById(R.id.message_no_image_title);
        this.knG = (TextView) findViewById(R.id.message_info);
        cUm();
    }

    public void cUm() {
        ap.setViewTextColor(this.knG, R.color.CAM_X0107);
        ap.setViewTextColor(this.knF, R.color.CAM_X0105);
    }

    public void setData(a.C0782a c0782a, boolean z) {
        int i = TextUtils.isEmpty(c0782a.text) ? 8 : 0;
        this.knF.setText(c0782a.title);
        this.knG.setText(c0782a.text);
        this.knG.setVisibility(i);
        if (z) {
            this.knF.setVisibility(8);
        } else {
            this.knF.setVisibility(0);
        }
    }

    public void DP(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.knG.getLayoutParams();
        layoutParams.topMargin = i;
        this.knG.setLayoutParams(layoutParams);
    }
}
