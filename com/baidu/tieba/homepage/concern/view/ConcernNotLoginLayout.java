package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes2.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {
    private ImageView dBQ;
    private TextView dBR;
    private TextView dBS;
    private Context mContext;

    public ConcernNotLoginLayout(Context context) {
        super(context);
        init(context);
    }

    public ConcernNotLoginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ConcernNotLoginLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.concern_not_login_layout, (ViewGroup) this, true);
        this.mContext = context;
        this.dBQ = (ImageView) inflate.findViewById(d.g.iv_concern_not_login_emotion_pic);
        this.dBR = (TextView) inflate.findViewById(d.g.tv_concern_you_not_login);
        this.dBS = (TextView) inflate.findViewById(d.g.tv_concern_login_and_see_more);
        this.dBS.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.tv_concern_login_and_see_more) {
            az.aK(this.mContext);
            HomePageStatic.dAc = true;
        }
    }

    public void onChangeSkinType(int i) {
        ak.c(this.dBQ, d.f.pic_jinba_login);
        ak.h(this.dBR, d.C0126d.cp_cont_b);
        ak.h(this.dBS, d.C0126d.cp_cont_i);
        ak.i(this.dBS, d.f.btn_all_blue);
    }
}
