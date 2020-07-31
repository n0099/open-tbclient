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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.a;
/* loaded from: classes15.dex */
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    public View gUA;
    protected RelativeLayout gUq;
    protected TextView gUr;
    public TextView gUs;
    public TextView gUt;
    private View gUu;
    private View gUv;
    private View gUw;
    public ImageView gUx;
    public LinearLayout gUy;
    public View gUz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((c<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gUq = null;
        this.gUr = null;
        this.gUs = null;
        this.gUt = null;
        this.gUu = null;
        this.gUv = null;
        this.gUw = null;
        this.gUy = null;
        aj(getView());
    }

    private void aj(View view) {
        this.gUq = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.gUr = (TextView) view.findViewById(R.id.item_group_title);
        this.gUs = (TextView) view.findViewById(R.id.item_right_tv);
        this.gUt = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.gUu = view.findViewById(R.id.divider_line_top);
        this.gUv = view.findViewById(R.id.divider_line_middle);
        this.gUw = view.findViewById(R.id.divider_line_bottom);
        this.gUy = (LinearLayout) view.findViewById(R.id.card_container);
        this.gUz = view.findViewById(R.id.divider_card);
        this.gUA = view.findViewById(R.id.divider_card_top);
        this.gUx = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void bRo() {
        if (getFrom() != null && getFrom().equals("home")) {
            ao.setViewTextColor(this.gUr, R.color.cp_cont_d, 1);
            this.gUx.setVisibility(8);
        } else {
            ao.setViewTextColor(this.gUr, R.color.cp_cont_f, 1);
            ao.setImageResource(this.gUx, R.drawable.icon_arrow_tab);
        }
        ao.setViewTextColor(this.gUs, R.color.cp_link_tip_c, 1);
        ao.setViewTextColor(this.gUt, R.color.cp_cont_d, 1);
        ao.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.gUu, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.gUv, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.gUw, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.gUz, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.gUA, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            bRo();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.gUr.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.gUs.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.gUA.setVisibility(0);
        } else {
            this.gUA.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.gUz.setVisibility(0);
        } else {
            this.gUz.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.gUt.setVisibility(0);
            this.gUw.setVisibility(0);
            this.gUv.setVisibility(0);
            this.gUt.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.gUt.setTag(str);
                this.gUt.setOnClickListener(this);
                return;
            }
            return;
        }
        this.gUt.setVisibility(8);
        this.gUw.setVisibility(8);
        this.gUv.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gUt == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                bd.baV().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void tb(int i) {
        if (this.gUu != null && this.gUu.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gUu.getLayoutParams();
            layoutParams.height = i;
            this.gUu.setLayoutParams(layoutParams);
        }
        if (this.gUv != null && this.gUv.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.gUv.getLayoutParams();
            layoutParams2.height = i;
            this.gUv.setLayoutParams(layoutParams2);
        }
        if (this.gUw != null && this.gUw.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.gUw.getLayoutParams();
            layoutParams3.height = i;
            this.gUw.setLayoutParams(layoutParams3);
        }
    }

    public void mz(boolean z) {
        if (this.gUz != null) {
            this.gUz.setVisibility(z ? 0 : 8);
        }
    }
}
