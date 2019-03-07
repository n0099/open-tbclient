package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes4.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {
    private ImageView fHD;
    private TextView fHE;
    private TextView fHF;
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
        View inflate = LayoutInflater.from(context).inflate(d.h.concern_not_login_layout, (ViewGroup) this, true);
        this.mContext = context;
        this.fHD = (ImageView) inflate.findViewById(d.g.iv_concern_not_login_emotion_pic);
        this.fHE = (TextView) inflate.findViewById(d.g.tv_concern_you_not_login);
        this.fHF = (TextView) inflate.findViewById(d.g.tv_concern_login_and_see_more);
        this.fHF.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.tv_concern_login_and_see_more) {
            bc.cZ(this.mContext);
            HomePageStatic.fFM = true;
        }
    }

    public void onChangeSkinType(int i) {
        al.c(this.fHD, d.f.pic_jinba_login);
        al.j(this.fHE, d.C0236d.cp_cont_b);
        al.j(this.fHF, d.C0236d.cp_btn_a);
        al.k(this.fHF, d.f.btn_all_blue);
    }
}
