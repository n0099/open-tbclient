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
    private TextView kDL;
    private TextView kDM;
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
        this.kDL = (TextView) findViewById(R.id.message_no_image_title);
        this.kDM = (TextView) findViewById(R.id.message_info);
        cVf();
    }

    public void cVf() {
        ap.setViewTextColor(this.kDM, R.color.CAM_X0107);
        ap.setViewTextColor(this.kDL, R.color.CAM_X0105);
    }

    public void setData(a.C0760a c0760a, boolean z) {
        int i = TextUtils.isEmpty(c0760a.text) ? 8 : 0;
        this.kDL.setText(c0760a.title);
        this.kDM.setText(c0760a.text);
        this.kDM.setVisibility(i);
        if (z) {
            this.kDL.setVisibility(8);
        } else {
            this.kDL.setVisibility(0);
        }
    }

    public void CM(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kDM.getLayoutParams();
        layoutParams.topMargin = i;
        this.kDM.setLayoutParams(layoutParams);
    }
}
