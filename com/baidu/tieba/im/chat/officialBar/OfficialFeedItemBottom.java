package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes7.dex */
public class OfficialFeedItemBottom extends LinearLayout {
    private TextView kvF;
    private TextView kvG;
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
        this.kvF = (TextView) findViewById(R.id.message_no_image_title);
        this.kvG = (TextView) findViewById(R.id.message_info);
        cTh();
    }

    public void cTh() {
        ao.setViewTextColor(this.kvG, R.color.CAM_X0107);
        ao.setViewTextColor(this.kvF, R.color.CAM_X0105);
    }

    public void setData(a.C0758a c0758a, boolean z) {
        int i = TextUtils.isEmpty(c0758a.text) ? 8 : 0;
        this.kvF.setText(c0758a.title);
        this.kvG.setText(c0758a.text);
        this.kvG.setVisibility(i);
        if (z) {
            this.kvF.setVisibility(8);
        } else {
            this.kvF.setVisibility(0);
        }
    }

    public void Cu(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kvG.getLayoutParams();
        layoutParams.topMargin = i;
        this.kvG.setLayoutParams(layoutParams);
    }
}
