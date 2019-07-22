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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes4.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {
    private ImageView gdm;
    private TextView gdn;
    private TextView gdo;
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
        this.gdm = (ImageView) inflate.findViewById(R.id.iv_concern_not_login_emotion_pic);
        this.gdn = (TextView) inflate.findViewById(R.id.tv_concern_you_not_login);
        this.gdo = (TextView) inflate.findViewById(R.id.tv_concern_login_and_see_more);
        this.gdo.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_concern_login_and_see_more) {
            bd.cF(this.mContext);
            HomePageStatic.gbw = true;
        }
    }

    public void onChangeSkinType(int i) {
        am.c(this.gdm, (int) R.drawable.new_pic_emotion_01);
        am.j(this.gdn, R.color.cp_cont_b);
        am.j(this.gdo, R.color.cp_btn_a);
        am.k(this.gdo, R.drawable.btn_all_blue);
    }
}
