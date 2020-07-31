package com.baidu.tieba.enterForum.c;

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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a implements View.OnClickListener {
    private FrameLayout hqX;
    private ImageView hqY;
    private TextView hqZ;
    private View.OnClickListener hra;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.hqX = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.hqY = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.hqZ = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.hqX.setOnClickListener(this);
        this.hqY.setOnClickListener(this);
        this.hqZ.setOnClickListener(this);
        if (this.hqX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hqX.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.hqX.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void abM() {
        com.baidu.tbadk.core.util.e.a.bbr().mb(R.color.cp_bg_line_e).me(R.color.cp_cont_b_alpha42).mg(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).Q(this.tbds52).aX(this.hqX);
        ao.setViewTextColor(this.hqZ, R.color.cp_cont_b);
        SvgManager.baR().a(this.hqY, R.drawable.ic_icon_pure_createba16, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void w(View.OnClickListener onClickListener) {
        this.hra = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.hqX || view == this.hqY || view == this.hqZ) && this.hra != null) {
            this.hra.onClick(view);
        }
    }
}
