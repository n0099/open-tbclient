package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes22.dex */
public class b {
    private boolean aiL;
    private TextView imA;
    private TextView imB;
    private int imC;
    private RoundRelativeLayout imw;
    private ImageView imx;
    private ImageView imy;
    private ImageView imz;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.imw = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.imx = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.imy = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.imA = (TextView) this.mView.findViewById(R.id.square_title);
        this.imB = (TextView) this.mView.findViewById(R.id.square_desc);
        this.imz = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.imA.setText(R.string.forum_square_title);
        this.imB.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                aq aqVar = new aq("c13645");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.aj("obj_locate", 1);
                aqVar.aj("obj_type", b.this.aiL ? 5 : 1);
                aqVar.aj("obj_source", b.this.aiL ? 1 : 3);
                TiebaStatic.log(aqVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.imC = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.imw.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.imw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.imw.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.imC) {
                    marginLayoutParams.bottomMargin = this.imC;
                    this.imw.requestLayout();
                }
            }
        } else if (this.imw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.imw.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.imw.requestLayout();
            }
        }
        ap.setBackgroundColor(this.imw, R.color.cp_bg_line_g);
        SvgManager.boN().a(this.imx, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ap.setImageResource(this.imy, R.drawable.pic_mask_square_circle);
        SvgManager.boN().a(this.imz, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.imA, R.color.cp_cont_b);
        ap.setViewTextColor(this.imB, R.color.cp_cont_c);
    }

    public void setHasLikeForum(boolean z) {
        this.aiL = z;
    }
}
