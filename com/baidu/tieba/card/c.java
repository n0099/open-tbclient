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
/* loaded from: classes20.dex */
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    protected RelativeLayout hWd;
    protected TextView hWe;
    public TextView hWf;
    public TextView hWg;
    private View hWh;
    private View hWi;
    private View hWj;
    public ImageView hWk;
    public LinearLayout hWl;
    public View hWm;
    public View hWn;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(BaseCardInfo baseCardInfo) {
        a((c<T>) ((com.baidu.tieba.card.data.a) baseCardInfo));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hWd = null;
        this.hWe = null;
        this.hWf = null;
        this.hWg = null;
        this.hWh = null;
        this.hWi = null;
        this.hWj = null;
        this.hWl = null;
        al(getView());
    }

    private void al(View view) {
        this.hWd = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.hWe = (TextView) view.findViewById(R.id.item_group_title);
        this.hWf = (TextView) view.findViewById(R.id.item_right_tv);
        this.hWg = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.hWh = view.findViewById(R.id.divider_line_top);
        this.hWi = view.findViewById(R.id.divider_line_middle);
        this.hWj = view.findViewById(R.id.divider_line_bottom);
        this.hWl = (LinearLayout) view.findViewById(R.id.card_container);
        this.hWm = view.findViewById(R.id.divider_card);
        this.hWn = view.findViewById(R.id.divider_card_top);
        this.hWk = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cnw() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.hWe, R.color.CAM_X0109, 1);
            this.hWk.setVisibility(8);
        } else {
            ap.setViewTextColor(this.hWe, R.color.CAM_X0106, 1);
            ap.setImageResource(this.hWk, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.hWf, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.hWg, R.color.CAM_X0109, 1);
        ap.setBackgroundColor(getView(), R.color.CAM_X0201);
        ap.setBackgroundColor(this.hWh, R.color.CAM_X0204);
        ap.setBackgroundColor(this.hWi, R.color.CAM_X0204);
        ap.setBackgroundColor(this.hWj, R.color.CAM_X0204);
        ap.setBackgroundColor(this.hWm, R.color.CAM_X0204);
        ap.setBackgroundColor(this.hWn, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            cnw();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.hWe.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.hWf.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.hWn.setVisibility(0);
        } else {
            this.hWn.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.hWm.setVisibility(0);
        } else {
            this.hWm.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.hWg.setVisibility(0);
            this.hWj.setVisibility(0);
            this.hWi.setVisibility(0);
            this.hWg.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.hWg.setTag(str);
                this.hWg.setOnClickListener(this);
                return;
            }
            return;
        }
        this.hWg.setVisibility(8);
        this.hWj.setVisibility(8);
        this.hWi.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hWg == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                bf.bqF().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void xz(int i) {
        if (this.hWh != null && this.hWh.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hWh.getLayoutParams();
            layoutParams.height = i;
            this.hWh.setLayoutParams(layoutParams);
        }
        if (this.hWi != null && this.hWi.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.hWi.getLayoutParams();
            layoutParams2.height = i;
            this.hWi.setLayoutParams(layoutParams2);
        }
        if (this.hWj != null && this.hWj.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.hWj.getLayoutParams();
            layoutParams3.height = i;
            this.hWj.setLayoutParams(layoutParams3);
        }
    }

    public void os(boolean z) {
        if (this.hWm != null) {
            this.hWm.setVisibility(z ? 0 : 8);
        }
    }
}
