package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes2.dex */
public class b {
    private boolean ajA;
    private RoundRelativeLayout iLH;
    private ImageView iLI;
    private ImageView iLJ;
    private ImageView iLK;
    private TextView iLL;
    private TextView iLM;
    private int iLN;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.iLH = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.iLI = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.iLJ = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.iLL = (TextView) this.mView.findViewById(R.id.square_title);
        this.iLM = (TextView) this.mView.findViewById(R.id.square_desc);
        this.iLK = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.iLL.setText(R.string.forum_square_title);
        this.iLM.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                aq aqVar = new aq("c13645");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.an("obj_locate", 1);
                aqVar.an("obj_type", b.this.ajA ? 5 : 1);
                aqVar.an("obj_source", b.this.ajA ? 1 : 3);
                TiebaStatic.log(aqVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.iLN = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.iLH.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.boh()) {
            if (this.iLH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iLH.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.iLN) {
                    marginLayoutParams.bottomMargin = this.iLN;
                    this.iLH.requestLayout();
                }
            }
        } else if (this.iLH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iLH.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.iLH.requestLayout();
            }
        }
        ao.setBackgroundColor(this.iLH, R.color.CAM_X0206);
        SvgManager.bsx().a(this.iLI, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ao.setImageResource(this.iLJ, R.drawable.pic_mask_square_circle);
        SvgManager.bsx().a(this.iLK, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.iLL, R.color.CAM_X0105);
        ao.setViewTextColor(this.iLM, R.color.CAM_X0108);
    }

    public void setHasLikeForum(boolean z) {
        this.ajA = z;
    }
}
