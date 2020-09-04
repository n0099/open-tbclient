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
/* loaded from: classes20.dex */
public class OfficialFeedItemBottom extends LinearLayout {
    private TextView jjs;
    private TextView jjt;
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
        this.jjs = (TextView) findViewById(R.id.message_no_image_title);
        this.jjt = (TextView) findViewById(R.id.message_info);
        cCu();
    }

    public void cCu() {
        ap.setViewTextColor(this.jjt, R.color.cp_cont_j);
        ap.setViewTextColor(this.jjs, R.color.cp_cont_b);
    }

    public void setData(a.C0719a c0719a, boolean z) {
        int i = TextUtils.isEmpty(c0719a.text) ? 8 : 0;
        this.jjs.setText(c0719a.title);
        this.jjt.setText(c0719a.text);
        this.jjt.setVisibility(i);
        if (z) {
            this.jjs.setVisibility(8);
        } else {
            this.jjs.setVisibility(0);
        }
    }

    public void AP(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jjt.getLayoutParams();
        layoutParams.topMargin = i;
        this.jjt.setLayoutParams(layoutParams);
    }
}
