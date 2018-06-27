package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes2.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {
    private TextView dRA;
    private TextView dRB;
    private ImageView dRz;
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
        this.dRz = (ImageView) inflate.findViewById(d.g.iv_concern_not_login_emotion_pic);
        this.dRA = (TextView) inflate.findViewById(d.g.tv_concern_you_not_login);
        this.dRB = (TextView) inflate.findViewById(d.g.tv_concern_login_and_see_more);
        this.dRB.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.tv_concern_login_and_see_more) {
            bb.aU(this.mContext);
            HomePageStatic.dPJ = true;
        }
    }

    public void onChangeSkinType(int i) {
        am.c(this.dRz, d.f.pic_jinba_login);
        am.h(this.dRA, d.C0142d.cp_cont_b);
        am.h(this.dRB, d.C0142d.cp_cont_i);
        am.i(this.dRB, d.f.btn_all_blue);
    }
}
