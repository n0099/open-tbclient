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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.a;
/* loaded from: classes.dex */
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    protected RelativeLayout iuI;
    protected TextView iuJ;
    public TextView iuK;
    public TextView iuL;
    private View iuM;
    private View iuN;
    private View iuO;
    public ImageView iuP;
    public LinearLayout iuQ;
    public View iuR;
    public View iuS;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(BaseCardInfo baseCardInfo) {
        a((c<T>) ((com.baidu.tieba.card.data.a) baseCardInfo));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.iuI = null;
        this.iuJ = null;
        this.iuK = null;
        this.iuL = null;
        this.iuM = null;
        this.iuN = null;
        this.iuO = null;
        this.iuQ = null;
        am(getView());
    }

    private void am(View view) {
        this.iuI = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.iuJ = (TextView) view.findViewById(R.id.item_group_title);
        this.iuK = (TextView) view.findViewById(R.id.item_right_tv);
        this.iuL = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.iuM = view.findViewById(R.id.divider_line_top);
        this.iuN = view.findViewById(R.id.divider_line_middle);
        this.iuO = view.findViewById(R.id.divider_line_bottom);
        this.iuQ = (LinearLayout) view.findViewById(R.id.card_container);
        this.iuR = view.findViewById(R.id.divider_card);
        this.iuS = view.findViewById(R.id.divider_card_top);
        this.iuP = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void csd() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.iuJ, R.color.CAM_X0109, 1);
            this.iuP.setVisibility(8);
        } else {
            ap.setViewTextColor(this.iuJ, R.color.CAM_X0106, 1);
            ap.setImageResource(this.iuP, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.iuK, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.iuL, R.color.CAM_X0109, 1);
        ap.setBackgroundColor(getView(), R.color.CAM_X0201);
        ap.setBackgroundColor(this.iuM, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iuN, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iuO, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iuR, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iuS, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            csd();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.iuJ.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.iuK.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.iuS.setVisibility(0);
        } else {
            this.iuS.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.iuR.setVisibility(0);
        } else {
            this.iuR.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.iuL.setVisibility(0);
            this.iuO.setVisibility(0);
            this.iuN.setVisibility(0);
            this.iuL.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.iuL.setTag(str);
                this.iuL.setOnClickListener(this);
                return;
            }
            return;
        }
        this.iuL.setVisibility(8);
        this.iuO.setVisibility(8);
        this.iuN.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iuL == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                bf.bsV().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void wW(int i) {
        if (this.iuM != null && this.iuM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.iuM.getLayoutParams();
            layoutParams.height = i;
            this.iuM.setLayoutParams(layoutParams);
        }
        if (this.iuN != null && this.iuN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.iuN.getLayoutParams();
            layoutParams2.height = i;
            this.iuN.setLayoutParams(layoutParams2);
        }
        if (this.iuO != null && this.iuO.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.iuO.getLayoutParams();
            layoutParams3.height = i;
            this.iuO.setLayoutParams(layoutParams3);
        }
    }

    public void pt(boolean z) {
        if (this.iuR != null) {
            this.iuR.setVisibility(z ? 0 : 8);
        }
    }
}
