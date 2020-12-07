package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes22.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {
    private ImageView jMa;
    private TextView jMb;
    private TBSpecificationBtn jMc;
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
        this.jMa = (ImageView) inflate.findViewById(R.id.iv_concern_not_login_emotion_pic);
        this.jMb = (TextView) inflate.findViewById(R.id.tv_concern_you_not_login);
        this.jMb.setTextSize(0, l.getDimens(context, R.dimen.T_X06));
        this.jMc = (TBSpecificationBtn) inflate.findViewById(R.id.tv_concern_login_and_see_more);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.jMc.setText(context.getResources().getString(R.string.concern_login_and_see_more));
        this.jMc.setTextSize(R.dimen.T_X05);
        this.jMc.setTextHorizontalCenter(true);
        this.jMc.setConfig(aVar);
        this.jMc.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_concern_login_and_see_more) {
            bh.checkUpIsLogin(this.mContext);
            HomePageStatic.jIH = true;
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.jMa, R.drawable.new_pic_emotion_09);
        ap.setViewTextColor(this.jMb, R.color.CAM_X0107);
        if (this.jMc != null) {
            this.jMc.bvt();
        }
    }
}
