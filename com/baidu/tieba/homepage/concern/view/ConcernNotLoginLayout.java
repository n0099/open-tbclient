package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes16.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {
    private ImageView itF;
    private TextView itG;
    private TBSpecificationBtn itH;
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
        this.itF = (ImageView) inflate.findViewById(R.id.iv_concern_not_login_emotion_pic);
        this.itG = (TextView) inflate.findViewById(R.id.tv_concern_you_not_login);
        this.itH = (TBSpecificationBtn) inflate.findViewById(R.id.tv_concern_login_and_see_more);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.itH.setText(context.getResources().getString(R.string.concern_login_and_see_more));
        this.itH.setTextSize(R.dimen.tbds42);
        this.itH.setTextHorizontalCenter(true);
        this.itH.setConfig(bVar);
        this.itH.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_concern_login_and_see_more) {
            bf.checkUpIsLogin(this.mContext);
            HomePageStatic.irA = true;
        }
    }

    public void onChangeSkinType(int i) {
        ao.setImageResource(this.itF, R.drawable.new_pic_emotion_09);
        ao.setViewTextColor(this.itG, R.color.cp_cont_j);
        if (this.itH != null) {
            this.itH.bci();
        }
    }
}
