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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private FrameLayout iTi;
    private ImageView iTj;
    private TextView iTk;
    private View.OnClickListener iTl;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.iTi = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.iTj = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.iTk = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.iTi.setOnClickListener(this);
        this.iTj.setOnClickListener(this);
        this.iTk.setOnClickListener(this);
        if (this.iTi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.iTi.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.iTi.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void aqm() {
        com.baidu.tbadk.core.util.f.a.bty().oQ(R.color.CAM_X0205).oV(R.color.cp_cont_b_alpha42).oX(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).aj(this.tbds52).bv(this.iTi);
        ap.setViewTextColor(this.iTk, R.color.CAM_X0105);
        SvgManager.bsU().a(this.iTj, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void y(View.OnClickListener onClickListener) {
        this.iTl = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iTi || view == this.iTj || view == this.iTk) && this.iTl != null) {
            this.iTl.onClick(view);
        }
    }
}
