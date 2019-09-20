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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes4.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {
    private ImageView gfU;
    private TextView gfV;
    private TextView gfW;
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_not_login_layout, (ViewGroup) this, true);
        this.mContext = context;
        this.gfU = (ImageView) inflate.findViewById(R.id.iv_concern_not_login_emotion_pic);
        this.gfV = (TextView) inflate.findViewById(R.id.tv_concern_you_not_login);
        this.gfW = (TextView) inflate.findViewById(R.id.tv_concern_login_and_see_more);
        this.gfW.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_concern_login_and_see_more) {
            bc.cF(this.mContext);
            HomePageStatic.ged = true;
        }
    }

    public void onChangeSkinType(int i) {
        am.c(this.gfU, (int) R.drawable.new_pic_emotion_01);
        am.j(this.gfV, R.color.cp_cont_b);
        am.j(this.gfW, R.color.cp_cont_a);
        am.k(this.gfW, R.drawable.btn_all_blue);
    }
}
