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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes2.dex */
public class b {
    private boolean ajp;
    private RoundRelativeLayout iRD;
    private ImageView iRE;
    private ImageView iRF;
    private ImageView iRG;
    private TextView iRH;
    private TextView iRI;
    private int iRJ;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.iRD = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.iRE = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.iRF = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.iRH = (TextView) this.mView.findViewById(R.id.square_title);
        this.iRI = (TextView) this.mView.findViewById(R.id.square_desc);
        this.iRG = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.iRH.setText(R.string.forum_square_title);
        this.iRI.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                ar arVar = new ar("c13645");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.ap("obj_locate", 1);
                arVar.ap("obj_type", b.this.ajp ? 5 : 1);
                arVar.ap("obj_source", b.this.ajp ? 1 : 3);
                TiebaStatic.log(arVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.iRJ = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.iRD.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.iRD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iRD.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.iRJ) {
                    marginLayoutParams.bottomMargin = this.iRJ;
                    this.iRD.requestLayout();
                }
            }
        } else if (this.iRD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iRD.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.iRD.requestLayout();
            }
        }
        ap.setBackgroundColor(this.iRD, R.color.CAM_X0206);
        SvgManager.bsR().a(this.iRE, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ap.setImageResource(this.iRF, R.drawable.pic_mask_square_circle);
        SvgManager.bsR().a(this.iRG, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.iRH, R.color.CAM_X0105);
        ap.setViewTextColor(this.iRI, R.color.CAM_X0108);
    }

    public void setHasLikeForum(boolean z) {
        this.ajp = z;
    }
}
