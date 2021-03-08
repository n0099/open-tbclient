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
    public View iwA;
    public View iwB;
    protected RelativeLayout iwr;
    protected TextView iws;
    public TextView iwt;
    public TextView iwu;
    private View iwv;
    private View iww;
    private View iwx;
    public ImageView iwy;
    public LinearLayout iwz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(BaseCardInfo baseCardInfo) {
        a((c<T>) ((com.baidu.tieba.card.data.a) baseCardInfo));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.iwr = null;
        this.iws = null;
        this.iwt = null;
        this.iwu = null;
        this.iwv = null;
        this.iww = null;
        this.iwx = null;
        this.iwz = null;
        am(getView());
    }

    private void am(View view) {
        this.iwr = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.iws = (TextView) view.findViewById(R.id.item_group_title);
        this.iwt = (TextView) view.findViewById(R.id.item_right_tv);
        this.iwu = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.iwv = view.findViewById(R.id.divider_line_top);
        this.iww = view.findViewById(R.id.divider_line_middle);
        this.iwx = view.findViewById(R.id.divider_line_bottom);
        this.iwz = (LinearLayout) view.findViewById(R.id.card_container);
        this.iwA = view.findViewById(R.id.divider_card);
        this.iwB = view.findViewById(R.id.divider_card_top);
        this.iwy = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void csj() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.iws, R.color.CAM_X0109, 1);
            this.iwy.setVisibility(8);
        } else {
            ap.setViewTextColor(this.iws, R.color.CAM_X0106, 1);
            ap.setImageResource(this.iwy, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.iwt, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.iwu, R.color.CAM_X0109, 1);
        ap.setBackgroundColor(getView(), R.color.CAM_X0201);
        ap.setBackgroundColor(this.iwv, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iww, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iwx, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iwA, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iwB, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            csj();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.iws.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.iwt.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.iwB.setVisibility(0);
        } else {
            this.iwB.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.iwA.setVisibility(0);
        } else {
            this.iwA.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.iwu.setVisibility(0);
            this.iwx.setVisibility(0);
            this.iww.setVisibility(0);
            this.iwu.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.iwu.setTag(str);
                this.iwu.setOnClickListener(this);
                return;
            }
            return;
        }
        this.iwu.setVisibility(8);
        this.iwx.setVisibility(8);
        this.iww.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iwu == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                bf.bsY().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void wX(int i) {
        if (this.iwv != null && this.iwv.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.iwv.getLayoutParams();
            layoutParams.height = i;
            this.iwv.setLayoutParams(layoutParams);
        }
        if (this.iww != null && this.iww.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.iww.getLayoutParams();
            layoutParams2.height = i;
            this.iww.setLayoutParams(layoutParams2);
        }
        if (this.iwx != null && this.iwx.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.iwx.getLayoutParams();
            layoutParams3.height = i;
            this.iwx.setLayoutParams(layoutParams3);
        }
    }

    public void pt(boolean z) {
        if (this.iwA != null) {
            this.iwA.setVisibility(z ? 0 : 8);
        }
    }
}
