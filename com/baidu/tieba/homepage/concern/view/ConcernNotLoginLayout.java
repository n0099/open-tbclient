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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes6.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {
    private ImageView erH;
    private TextView erI;
    private TextView erJ;
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
        View inflate = LayoutInflater.from(context).inflate(e.h.concern_not_login_layout, (ViewGroup) this, true);
        this.mContext = context;
        this.erH = (ImageView) inflate.findViewById(e.g.iv_concern_not_login_emotion_pic);
        this.erI = (TextView) inflate.findViewById(e.g.tv_concern_you_not_login);
        this.erJ = (TextView) inflate.findViewById(e.g.tv_concern_login_and_see_more);
        this.erJ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.tv_concern_login_and_see_more) {
            ba.bJ(this.mContext);
            HomePageStatic.epQ = true;
        }
    }

    public void onChangeSkinType(int i) {
        al.c(this.erH, e.f.pic_jinba_login);
        al.h(this.erI, e.d.cp_cont_b);
        al.h(this.erJ, e.d.cp_cont_i);
        al.i(this.erJ, e.f.btn_all_blue);
    }
}
