package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.a;
/* loaded from: classes.dex */
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    public TextView itA;
    private View itB;
    private View itC;
    private View itD;
    public ImageView itE;
    public LinearLayout itF;
    public View itG;
    public View itH;
    protected RelativeLayout itx;
    protected TextView ity;
    public TextView itz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(BaseCardInfo baseCardInfo) {
        a((c<T>) ((com.baidu.tieba.card.data.a) baseCardInfo));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.itx = null;
        this.ity = null;
        this.itz = null;
        this.itA = null;
        this.itB = null;
        this.itC = null;
        this.itD = null;
        this.itF = null;
        ap(getView());
    }

    private void ap(View view) {
        this.itx = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.ity = (TextView) view.findViewById(R.id.item_group_title);
        this.itz = (TextView) view.findViewById(R.id.item_right_tv);
        this.itA = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.itB = view.findViewById(R.id.divider_line_top);
        this.itC = view.findViewById(R.id.divider_line_middle);
        this.itD = view.findViewById(R.id.divider_line_bottom);
        this.itF = (LinearLayout) view.findViewById(R.id.card_container);
        this.itG = view.findViewById(R.id.divider_card);
        this.itH = view.findViewById(R.id.divider_card_top);
        this.itE = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cuD() {
        if (getFrom() != null && getFrom().equals("home")) {
            ao.setViewTextColor(this.ity, R.color.CAM_X0109, 1);
            this.itE.setVisibility(8);
        } else {
            ao.setViewTextColor(this.ity, R.color.CAM_X0106, 1);
            ao.setImageResource(this.itE, R.drawable.icon_arrow_tab);
        }
        ao.setViewTextColor(this.itz, R.color.CAM_X0304, 1);
        ao.setViewTextColor(this.itA, R.color.CAM_X0109, 1);
        ao.setBackgroundColor(getView(), R.color.CAM_X0201);
        ao.setBackgroundColor(this.itB, R.color.CAM_X0204);
        ao.setBackgroundColor(this.itC, R.color.CAM_X0204);
        ao.setBackgroundColor(this.itD, R.color.CAM_X0204);
        ao.setBackgroundColor(this.itG, R.color.CAM_X0204);
        ao.setBackgroundColor(this.itH, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            cuD();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.ity.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.itz.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.itH.setVisibility(0);
        } else {
            this.itH.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.itG.setVisibility(0);
        } else {
            this.itG.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.itA.setVisibility(0);
            this.itD.setVisibility(0);
            this.itC.setVisibility(0);
            this.itA.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.itA.setTag(str);
                this.itA.setOnClickListener(this);
                return;
            }
            return;
        }
        this.itA.setVisibility(8);
        this.itD.setVisibility(8);
        this.itC.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.itA == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                be.bwu().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void yt(int i) {
        if (this.itB != null && this.itB.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.itB.getLayoutParams();
            layoutParams.height = i;
            this.itB.setLayoutParams(layoutParams);
        }
        if (this.itC != null && this.itC.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.itC.getLayoutParams();
            layoutParams2.height = i;
            this.itC.setLayoutParams(layoutParams2);
        }
        if (this.itD != null && this.itD.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.itD.getLayoutParams();
            layoutParams3.height = i;
            this.itD.setLayoutParams(layoutParams3);
        }
    }

    public void pn(boolean z) {
        if (this.itG != null) {
            this.itG.setVisibility(z ? 0 : 8);
        }
    }
}
