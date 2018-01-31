package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes2.dex */
public class b extends FrameLayout {
    private TbImageView egX;
    private TbImageView egY;
    private a egZ;

    /* loaded from: classes2.dex */
    public interface a {
        void aBr();

        void aBs();
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        Context context = getContext();
        this.egX = new TbImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.s(context, d.e.tbds156), l.s(context, d.e.tbds156));
        layoutParams.gravity = 83;
        layoutParams.rightMargin = l.s(context, d.e.tbds26);
        this.egX.setDefaultErrorResource(d.f.icon_quiz_entrance_float_default);
        addView(this.egX, layoutParams);
        this.egY = new TbImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.s(context, d.e.tbds52), l.s(context, d.e.tbds52));
        layoutParams2.gravity = 5;
        this.egY.setAutoChangeStyle(false);
        addView(this.egY, layoutParams2);
        this.egX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.egZ != null) {
                    b.this.egZ.aBr();
                }
            }
        });
        this.egY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.egZ != null) {
                    b.this.egZ.aBs();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(FloatInfo floatInfo) {
        if (floatInfo != null && !StringUtils.isNull(floatInfo.float_url)) {
            this.egX.startLoad(floatInfo.float_url, 10, false);
        }
    }

    public void setCallback(a aVar) {
        this.egZ = aVar;
    }

    public void onChangeSkinType() {
        aj.c(this.egY, d.f.icon_live_close_n);
    }
}
