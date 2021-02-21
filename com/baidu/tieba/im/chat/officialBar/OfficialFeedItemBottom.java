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
/* loaded from: classes8.dex */
public class OfficialFeedItemBottom extends LinearLayout {
    private TextView kDZ;
    private TextView kEa;
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
        this.kDZ = (TextView) findViewById(R.id.message_no_image_title);
        this.kEa = (TextView) findViewById(R.id.message_info);
        cVm();
    }

    public void cVm() {
        ap.setViewTextColor(this.kEa, R.color.CAM_X0107);
        ap.setViewTextColor(this.kDZ, R.color.CAM_X0105);
    }

    public void setData(a.C0761a c0761a, boolean z) {
        int i = TextUtils.isEmpty(c0761a.text) ? 8 : 0;
        this.kDZ.setText(c0761a.title);
        this.kEa.setText(c0761a.text);
        this.kEa.setVisibility(i);
        if (z) {
            this.kDZ.setVisibility(8);
        } else {
            this.kDZ.setVisibility(0);
        }
    }

    public void CM(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kEa.getLayoutParams();
        layoutParams.topMargin = i;
        this.kEa.setLayoutParams(layoutParams);
    }
}
