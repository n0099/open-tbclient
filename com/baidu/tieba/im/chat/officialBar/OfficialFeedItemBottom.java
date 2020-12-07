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
    private TextView knD;
    private TextView knE;
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
        this.knD = (TextView) findViewById(R.id.message_no_image_title);
        this.knE = (TextView) findViewById(R.id.message_info);
        cUl();
    }

    public void cUl() {
        ap.setViewTextColor(this.knE, R.color.CAM_X0107);
        ap.setViewTextColor(this.knD, R.color.CAM_X0105);
    }

    public void setData(a.C0782a c0782a, boolean z) {
        int i = TextUtils.isEmpty(c0782a.text) ? 8 : 0;
        this.knD.setText(c0782a.title);
        this.knE.setText(c0782a.text);
        this.knE.setVisibility(i);
        if (z) {
            this.knD.setVisibility(8);
        } else {
            this.knD.setVisibility(0);
        }
    }

    public void DP(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.knE.getLayoutParams();
        layoutParams.topMargin = i;
        this.knE.setLayoutParams(layoutParams);
    }
}
