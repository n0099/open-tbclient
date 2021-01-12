package com.baidu.tieba.frs.forumRule.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a {
    private RelativeLayout jpM;
    private EMTextView jpN;
    private EMTextView jpO;
    private final int jpP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
    private Context mContext;
    private View mRootView;

    public a(Context context) {
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.forum_rules_unaudited, (ViewGroup) null);
            this.jpM = (RelativeLayout) this.mRootView.findViewById(R.id.unaudited);
            this.jpN = (EMTextView) this.mRootView.findViewById(R.id.unaudited_title);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getResources().getString(R.string.forum_rules_unaudited_alert));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.setLeftPadding(l.getDimens(context, R.dimen.tbds0));
            eMRichTextAnyIconSpan.setRightPadding(l.getDimens(context, R.dimen.M_W_X002));
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.jpN.setText(spannableStringBuilder);
            this.jpO = (EMTextView) this.mRootView.findViewById(R.id.unaudited_content);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.btc().oJ(0).ae(this.jpP).b("TL_BR", R.color.CAM_X0212, R.color.CAM_X0212).bte(), com.baidu.tbadk.core.util.f.a.b.btc().oJ(0).ae(this.jpP).Bf("#4D000000").bte()});
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(255);
            }
        } else if (layerDrawable.getDrawable(1) != null) {
            layerDrawable.getDrawable(1).setAlpha(0);
        }
        this.jpM.setBackgroundDrawable(layerDrawable);
        c.bv(this.jpN).nV(R.color.CAM_X0109);
        c.bv(this.jpO).nV(R.color.CAM_X0109);
    }

    public void JP(String str) {
        if (this.jpO != null) {
            this.jpO.setText(str);
        }
    }

    public void b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jpM != null) {
            this.jpM.setVisibility(0);
            bdTypeRecyclerView.addHeaderView(this.jpM);
        }
    }

    public void c(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jpM != null) {
            this.jpM.setVisibility(8);
            bdTypeRecyclerView.removeHeaderView(this.jpM);
        }
    }
}
