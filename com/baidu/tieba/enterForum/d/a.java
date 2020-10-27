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
/* loaded from: classes22.dex */
public class a implements View.OnClickListener {
    private FrameLayout ims;
    private ImageView imt;
    private TextView imu;
    private View.OnClickListener imv;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.ims = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.imt = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.imu = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.ims.setOnClickListener(this);
        this.imt.setOnClickListener(this);
        this.imu.setOnClickListener(this);
        if (this.ims.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.ims.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.ims.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void ann() {
        com.baidu.tbadk.core.util.e.a.bpo().pa(R.color.cp_bg_line_e).pd(R.color.cp_cont_b_alpha42).pf(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).Z(this.tbds52).bg(this.ims);
        ap.setViewTextColor(this.imu, R.color.cp_cont_b);
        SvgManager.boN().a(this.imt, R.drawable.ic_icon_pure_createba16, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void w(View.OnClickListener onClickListener) {
        this.imv = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ims || view == this.imt || view == this.imu) && this.imv != null) {
            this.imv.onClick(view);
        }
    }
}
