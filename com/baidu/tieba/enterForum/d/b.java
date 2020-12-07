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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes22.dex */
public class b {
    private boolean ajP;
    private RoundRelativeLayout iEa;
    private ImageView iEb;
    private ImageView iEc;
    private ImageView iEd;
    private TextView iEe;
    private TextView iEf;
    private int iEg;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.iEa = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.iEb = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.iEc = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.iEe = (TextView) this.mView.findViewById(R.id.square_title);
        this.iEf = (TextView) this.mView.findViewById(R.id.square_desc);
        this.iEd = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.iEe.setText(R.string.forum_square_title);
        this.iEf.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                ar arVar = new ar("c13645");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.al("obj_locate", 1);
                arVar.al("obj_type", b.this.ajP ? 5 : 1);
                arVar.al("obj_source", b.this.ajP ? 1 : 3);
                TiebaStatic.log(arVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.iEg = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.iEa.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.iEa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iEa.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.iEg) {
                    marginLayoutParams.bottomMargin = this.iEg;
                    this.iEa.requestLayout();
                }
            }
        } else if (this.iEa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iEa.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.iEa.requestLayout();
            }
        }
        ap.setBackgroundColor(this.iEa, R.color.CAM_X0206);
        SvgManager.btW().a(this.iEb, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ap.setImageResource(this.iEc, R.drawable.pic_mask_square_circle);
        SvgManager.btW().a(this.iEd, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.iEe, R.color.CAM_X0105);
        ap.setViewTextColor(this.iEf, R.color.CAM_X0108);
    }

    public void setHasLikeForum(boolean z) {
        this.ajP = z;
    }
}
