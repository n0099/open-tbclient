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
    private TextView jTs;
    private TextView jTt;
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
        this.jTs = (TextView) findViewById(R.id.message_no_image_title);
        this.jTt = (TextView) findViewById(R.id.message_info);
        cMQ();
    }

    public void cMQ() {
        ap.setViewTextColor(this.jTt, R.color.cp_cont_j);
        ap.setViewTextColor(this.jTs, R.color.cp_cont_b);
    }

    public void setData(a.C0750a c0750a, boolean z) {
        int i = TextUtils.isEmpty(c0750a.text) ? 8 : 0;
        this.jTs.setText(c0750a.title);
        this.jTt.setText(c0750a.text);
        this.jTt.setVisibility(i);
        if (z) {
            this.jTs.setVisibility(8);
        } else {
            this.jTs.setVisibility(0);
        }
    }

    public void Cp(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jTt.getLayoutParams();
        layoutParams.topMargin = i;
        this.jTt.setLayoutParams(layoutParams);
    }
}
