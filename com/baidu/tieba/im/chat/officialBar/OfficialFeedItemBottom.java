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
/* loaded from: classes20.dex */
public class OfficialFeedItemBottom extends LinearLayout {
    private TextView iUo;
    private TextView iUp;
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
        this.iUo = (TextView) findViewById(R.id.message_no_image_title);
        this.iUp = (TextView) findViewById(R.id.message_info);
        crB();
    }

    public void crB() {
        ao.setViewTextColor(this.iUp, R.color.cp_cont_j);
        ao.setViewTextColor(this.iUo, R.color.cp_cont_b);
    }

    public void setData(a.C0667a c0667a, boolean z) {
        int i = TextUtils.isEmpty(c0667a.text) ? 8 : 0;
        this.iUo.setText(c0667a.title);
        this.iUp.setText(c0667a.text);
        this.iUp.setVisibility(i);
        if (z) {
            this.iUo.setVisibility(8);
        } else {
            this.iUo.setVisibility(0);
        }
    }

    public void yv(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iUp.getLayoutParams();
        layoutParams.topMargin = i;
        this.iUp.setLayoutParams(layoutParams);
    }
}
