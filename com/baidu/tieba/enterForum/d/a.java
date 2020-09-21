package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a implements View.OnClickListener {
    private FrameLayout hKW;
    private ImageView hKX;
    private TextView hKY;
    private View.OnClickListener hKZ;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.hKW = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.hKX = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.hKY = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.hKW.setOnClickListener(this);
        this.hKX.setOnClickListener(this);
        this.hKY.setOnClickListener(this);
        if (this.hKW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hKW.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.hKW.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void aiI() {
        com.baidu.tbadk.core.util.e.a.bkL().or(R.color.cp_bg_line_e).ou(R.color.cp_cont_b_alpha42).ow(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).V(this.tbds52).bb(this.hKW);
        ap.setViewTextColor(this.hKY, R.color.cp_cont_b);
        SvgManager.bkl().a(this.hKX, R.drawable.ic_icon_pure_createba16, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void w(View.OnClickListener onClickListener) {
        this.hKZ = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.hKW || view == this.hKX || view == this.hKY) && this.hKZ != null) {
            this.hKZ.onClick(view);
        }
    }
}
