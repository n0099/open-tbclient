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
    private RoundRelativeLayout iEc;
    private ImageView iEd;
    private ImageView iEe;
    private ImageView iEf;
    private TextView iEg;
    private TextView iEh;
    private int iEi;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.iEc = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.iEd = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.iEe = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.iEg = (TextView) this.mView.findViewById(R.id.square_title);
        this.iEh = (TextView) this.mView.findViewById(R.id.square_desc);
        this.iEf = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.iEg.setText(R.string.forum_square_title);
        this.iEh.setText(R.string.forum_square_desc);
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
        this.iEi = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.iEc.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.iEc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iEc.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.iEi) {
                    marginLayoutParams.bottomMargin = this.iEi;
                    this.iEc.requestLayout();
                }
            }
        } else if (this.iEc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iEc.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.iEc.requestLayout();
            }
        }
        ap.setBackgroundColor(this.iEc, R.color.CAM_X0206);
        SvgManager.btW().a(this.iEd, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ap.setImageResource(this.iEe, R.drawable.pic_mask_square_circle);
        SvgManager.btW().a(this.iEf, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.iEg, R.color.CAM_X0105);
        ap.setViewTextColor(this.iEh, R.color.CAM_X0108);
    }

    public void setHasLikeForum(boolean z) {
        this.ajP = z;
    }
}
