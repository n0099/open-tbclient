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
    private FrameLayout ite;
    private ImageView itf;
    private TextView itg;
    private View.OnClickListener ith;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.ite = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.itf = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.itg = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.ite.setOnClickListener(this);
        this.itf.setOnClickListener(this);
        this.itg.setOnClickListener(this);
        if (this.ite.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.ite.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.ite.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void apf() {
        com.baidu.tbadk.core.util.e.a.brc().pG(R.color.CAM_X0205).pL(R.color.cp_cont_b_alpha42).pN(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).ac(this.tbds52).bn(this.ite);
        ap.setViewTextColor(this.itg, R.color.CAM_X0105);
        SvgManager.bqB().a(this.itf, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void x(View.OnClickListener onClickListener) {
        this.ith = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ite || view == this.itf || view == this.itg) && this.ith != null) {
            this.ith.onClick(view);
        }
    }
}
