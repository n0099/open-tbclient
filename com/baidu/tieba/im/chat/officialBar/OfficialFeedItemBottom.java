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
/* loaded from: classes8.dex */
public class OfficialFeedItemBottom extends LinearLayout {
    private TextView kAk;
    private TextView kAl;
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
        this.kAk = (TextView) findViewById(R.id.message_no_image_title);
        this.kAl = (TextView) findViewById(R.id.message_info);
        cWZ();
    }

    public void cWZ() {
        ao.setViewTextColor(this.kAl, R.color.CAM_X0107);
        ao.setViewTextColor(this.kAk, R.color.CAM_X0105);
    }

    public void setData(a.C0775a c0775a, boolean z) {
        int i = TextUtils.isEmpty(c0775a.text) ? 8 : 0;
        this.kAk.setText(c0775a.title);
        this.kAl.setText(c0775a.text);
        this.kAl.setVisibility(i);
        if (z) {
            this.kAk.setVisibility(8);
        } else {
            this.kAk.setVisibility(0);
        }
    }

    public void Eb(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kAl.getLayoutParams();
        layoutParams.topMargin = i;
        this.kAl.setLayoutParams(layoutParams);
    }
}
