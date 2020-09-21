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
/* loaded from: classes21.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {
    private ImageView iQs;
    private TextView iQt;
    private TBSpecificationBtn iQu;
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
        this.iQs = (ImageView) inflate.findViewById(R.id.iv_concern_not_login_emotion_pic);
        this.iQt = (TextView) inflate.findViewById(R.id.tv_concern_you_not_login);
        this.iQu = (TBSpecificationBtn) inflate.findViewById(R.id.tv_concern_login_and_see_more);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.iQu.setText(context.getResources().getString(R.string.concern_login_and_see_more));
        this.iQu.setTextSize(R.dimen.tbds42);
        this.iQu.setTextHorizontalCenter(true);
        this.iQu.setConfig(aVar);
        this.iQu.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_concern_login_and_see_more) {
            bg.checkUpIsLogin(this.mContext);
            HomePageStatic.iNq = true;
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.iQs, R.drawable.new_pic_emotion_09);
        ap.setViewTextColor(this.iQt, R.color.cp_cont_j);
        if (this.iQu != null) {
            this.iQu.blA();
        }
    }
}
