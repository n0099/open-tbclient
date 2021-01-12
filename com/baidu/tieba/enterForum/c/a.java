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
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private FrameLayout iLD;
    private ImageView iLE;
    private TextView iLF;
    private View.OnClickListener iLG;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.iLD = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.iLE = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.iLF = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.iLD.setOnClickListener(this);
        this.iLE.setOnClickListener(this);
        this.iLF.setOnClickListener(this);
        if (this.iLD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.iLD.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.iLD.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void apL() {
        com.baidu.tbadk.core.util.f.a.btb().oK(R.color.CAM_X0205).oP(R.color.cp_cont_b_alpha42).oR(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).ae(this.tbds52).bz(this.iLD);
        ao.setViewTextColor(this.iLF, R.color.CAM_X0105);
        SvgManager.bsx().a(this.iLE, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void y(View.OnClickListener onClickListener) {
        this.iLG = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iLD || view == this.iLE || view == this.iLF) && this.iLG != null) {
            this.iLG.onClick(view);
        }
    }
}
