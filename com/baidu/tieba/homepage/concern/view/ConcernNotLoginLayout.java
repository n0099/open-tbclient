package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes16.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {
    private ImageView iHU;
    private TextView iHV;
    private TBSpecificationBtn iHW;
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
        this.iHU = (ImageView) inflate.findViewById(R.id.iv_concern_not_login_emotion_pic);
        this.iHV = (TextView) inflate.findViewById(R.id.tv_concern_you_not_login);
        this.iHW = (TBSpecificationBtn) inflate.findViewById(R.id.tv_concern_login_and_see_more);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.iHW.setText(context.getResources().getString(R.string.concern_login_and_see_more));
        this.iHW.setTextSize(R.dimen.tbds42);
        this.iHW.setTextHorizontalCenter(true);
        this.iHW.setConfig(aVar);
        this.iHW.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_concern_login_and_see_more) {
            bg.checkUpIsLogin(this.mContext);
            HomePageStatic.iFP = true;
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.iHU, R.drawable.new_pic_emotion_09);
        ap.setViewTextColor(this.iHV, R.color.cp_cont_j);
        if (this.iHW != null) {
            this.iHW.bkF();
        }
    }
}
