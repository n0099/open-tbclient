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
    private RelativeLayout jus;
    private EMTextView jut;
    private EMTextView juu;
    private final int juv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
    private Context mContext;
    private View mRootView;

    public a(Context context) {
        this.mContext = context;
        eO(context);
    }

    private void eO(Context context) {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.forum_rules_unaudited, (ViewGroup) null);
            this.jus = (RelativeLayout) this.mRootView.findViewById(R.id.unaudited);
            this.jut = (EMTextView) this.mRootView.findViewById(R.id.unaudited_title);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getResources().getString(R.string.forum_rules_unaudited_alert));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.setLeftPadding(l.getDimens(context, R.dimen.tbds0));
            eMRichTextAnyIconSpan.setRightPadding(l.getDimens(context, R.dimen.M_W_X002));
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.jut.setText(spannableStringBuilder);
            this.juu = (EMTextView) this.mRootView.findViewById(R.id.unaudited_content);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.bwV().qq(0).ae(this.juv).b("TL_BR", R.color.CAM_X0212, R.color.CAM_X0212).bwX(), com.baidu.tbadk.core.util.f.a.b.bwV().qq(0).ae(this.juv).Cr("#4D000000").bwX()});
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(255);
            }
        } else if (layerDrawable.getDrawable(1) != null) {
            layerDrawable.getDrawable(1).setAlpha(0);
        }
        this.jus.setBackgroundDrawable(layerDrawable);
        c.bv(this.jut).pC(R.color.CAM_X0109);
        c.bv(this.juu).pC(R.color.CAM_X0109);
    }

    public void La(String str) {
        if (this.juu != null) {
            this.juu.setText(str);
        }
    }

    public void b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jus != null) {
            this.jus.setVisibility(0);
            bdTypeRecyclerView.addHeaderView(this.jus);
        }
    }

    public void c(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jus != null) {
            this.jus.setVisibility(8);
            bdTypeRecyclerView.removeHeaderView(this.jus);
        }
    }
}
