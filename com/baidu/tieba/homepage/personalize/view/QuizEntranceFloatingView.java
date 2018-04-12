package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes2.dex */
public class QuizEntranceFloatingView extends FrameLayout {
    private TbImageView dFO;
    private TbImageView dFP;
    private a dFQ;

    /* loaded from: classes2.dex */
    public interface a {
        void axJ();

        void axK();
    }

    public QuizEntranceFloatingView(@NonNull Context context) {
        this(context, null);
    }

    public QuizEntranceFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        Context context = getContext();
        this.dFO = new TbImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.e(context, d.e.tbds156), l.e(context, d.e.tbds156));
        layoutParams.gravity = 83;
        layoutParams.rightMargin = l.e(context, d.e.tbds26);
        this.dFO.setDefaultErrorResource(d.f.icon_quiz_entrance_float_default);
        addView(this.dFO, layoutParams);
        this.dFP = new TbImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.e(context, d.e.tbds52), l.e(context, d.e.tbds52));
        layoutParams2.gravity = 5;
        this.dFP.setAutoChangeStyle(false);
        addView(this.dFP, layoutParams2);
        this.dFO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.QuizEntranceFloatingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (QuizEntranceFloatingView.this.dFQ != null) {
                    QuizEntranceFloatingView.this.dFQ.axJ();
                }
            }
        });
        this.dFP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.QuizEntranceFloatingView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (QuizEntranceFloatingView.this.dFQ != null) {
                    QuizEntranceFloatingView.this.dFQ.axK();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(FloatInfo floatInfo) {
        if (floatInfo != null && !StringUtils.isNull(floatInfo.float_url)) {
            this.dFO.startLoad(floatInfo.float_url, 10, false);
        }
    }

    public void setCallback(a aVar) {
        this.dFQ = aVar;
    }

    public void onChangeSkinType() {
        ak.c(this.dFP, d.f.icon_live_close_n);
    }
}
