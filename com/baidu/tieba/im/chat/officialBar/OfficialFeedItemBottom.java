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
    private TextView jZo;
    private TextView jZp;
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
        this.jZo = (TextView) findViewById(R.id.message_no_image_title);
        this.jZp = (TextView) findViewById(R.id.message_info);
        cPr();
    }

    public void cPr() {
        ap.setViewTextColor(this.jZp, R.color.cp_cont_j);
        ap.setViewTextColor(this.jZo, R.color.cp_cont_b);
    }

    public void setData(a.C0764a c0764a, boolean z) {
        int i = TextUtils.isEmpty(c0764a.text) ? 8 : 0;
        this.jZo.setText(c0764a.title);
        this.jZp.setText(c0764a.text);
        this.jZp.setVisibility(i);
        if (z) {
            this.jZo.setVisibility(8);
        } else {
            this.jZo.setVisibility(0);
        }
    }

    public void CC(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jZp.getLayoutParams();
        layoutParams.topMargin = i;
        this.jZp.setLayoutParams(layoutParams);
    }
}
