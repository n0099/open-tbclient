package com.baidu.tieba.enterForum.b;

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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    private FrameLayout gJX;
    private ImageView gJY;
    private TextView gJZ;
    private View.OnClickListener gKa;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.gJX = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.gJY = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.gJZ = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.gJX.setOnClickListener(this);
        this.gJY.setOnClickListener(this);
        this.gJZ.setOnClickListener(this);
        if (this.gJX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gJX.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.gJX.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void WT() {
        com.baidu.tbadk.core.util.e.a.aPu().kM(R.color.cp_bg_line_e).kP(R.color.cp_cont_b_alpha42).kR(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).P(this.tbds52).aR(this.gJX);
        am.setViewTextColor(this.gJZ, (int) R.color.cp_cont_b);
        SvgManager.aOU().a(this.gJY, R.drawable.ic_icon_pure_createba16, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void w(View.OnClickListener onClickListener) {
        this.gKa = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.gJX || view == this.gJY || view == this.gJZ) && this.gKa != null) {
            this.gKa.onClick(view);
        }
    }
}
