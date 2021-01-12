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
    protected RelativeLayout ioQ;
    protected TextView ioR;
    public TextView ioS;
    public TextView ioT;
    private View ioU;
    private View ioV;
    private View ioW;
    public ImageView ioX;
    public LinearLayout ioY;
    public View ioZ;
    public View ipa;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(BaseCardInfo baseCardInfo) {
        a((c<T>) ((com.baidu.tieba.card.data.a) baseCardInfo));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ioQ = null;
        this.ioR = null;
        this.ioS = null;
        this.ioT = null;
        this.ioU = null;
        this.ioV = null;
        this.ioW = null;
        this.ioY = null;
        ap(getView());
    }

    private void ap(View view) {
        this.ioQ = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.ioR = (TextView) view.findViewById(R.id.item_group_title);
        this.ioS = (TextView) view.findViewById(R.id.item_right_tv);
        this.ioT = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.ioU = view.findViewById(R.id.divider_line_top);
        this.ioV = view.findViewById(R.id.divider_line_middle);
        this.ioW = view.findViewById(R.id.divider_line_bottom);
        this.ioY = (LinearLayout) view.findViewById(R.id.card_container);
        this.ioZ = view.findViewById(R.id.divider_card);
        this.ipa = view.findViewById(R.id.divider_card_top);
        this.ioX = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cqM() {
        if (getFrom() != null && getFrom().equals("home")) {
            ao.setViewTextColor(this.ioR, R.color.CAM_X0109, 1);
            this.ioX.setVisibility(8);
        } else {
            ao.setViewTextColor(this.ioR, R.color.CAM_X0106, 1);
            ao.setImageResource(this.ioX, R.drawable.icon_arrow_tab);
        }
        ao.setViewTextColor(this.ioS, R.color.CAM_X0304, 1);
        ao.setViewTextColor(this.ioT, R.color.CAM_X0109, 1);
        ao.setBackgroundColor(getView(), R.color.CAM_X0201);
        ao.setBackgroundColor(this.ioU, R.color.CAM_X0204);
        ao.setBackgroundColor(this.ioV, R.color.CAM_X0204);
        ao.setBackgroundColor(this.ioW, R.color.CAM_X0204);
        ao.setBackgroundColor(this.ioZ, R.color.CAM_X0204);
        ao.setBackgroundColor(this.ipa, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            cqM();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.ioR.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.ioS.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.ipa.setVisibility(0);
        } else {
            this.ipa.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.ioZ.setVisibility(0);
        } else {
            this.ioZ.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.ioT.setVisibility(0);
            this.ioW.setVisibility(0);
            this.ioV.setVisibility(0);
            this.ioT.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.ioT.setTag(str);
                this.ioT.setOnClickListener(this);
                return;
            }
            return;
        }
        this.ioT.setVisibility(8);
        this.ioW.setVisibility(8);
        this.ioV.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ioT == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                be.bsB().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void wM(int i) {
        if (this.ioU != null && this.ioU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ioU.getLayoutParams();
            layoutParams.height = i;
            this.ioU.setLayoutParams(layoutParams);
        }
        if (this.ioV != null && this.ioV.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.ioV.getLayoutParams();
            layoutParams2.height = i;
            this.ioV.setLayoutParams(layoutParams2);
        }
        if (this.ioW != null && this.ioW.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.ioW.getLayoutParams();
            layoutParams3.height = i;
            this.ioW.setLayoutParams(layoutParams3);
        }
    }

    public void pj(boolean z) {
        if (this.ioZ != null) {
            this.ioZ.setVisibility(z ? 0 : 8);
        }
    }
}
