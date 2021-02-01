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
    private RoundRelativeLayout iRp;
    private ImageView iRq;
    private ImageView iRr;
    private ImageView iRs;
    private TextView iRt;
    private TextView iRu;
    private int iRv;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.iRp = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.iRq = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.iRr = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.iRt = (TextView) this.mView.findViewById(R.id.square_title);
        this.iRu = (TextView) this.mView.findViewById(R.id.square_desc);
        this.iRs = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.iRt.setText(R.string.forum_square_title);
        this.iRu.setText(R.string.forum_square_desc);
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
        this.iRv = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.iRp.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.iRp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iRp.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.iRv) {
                    marginLayoutParams.bottomMargin = this.iRv;
                    this.iRp.requestLayout();
                }
            }
        } else if (this.iRp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iRp.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.iRp.requestLayout();
            }
        }
        ap.setBackgroundColor(this.iRp, R.color.CAM_X0206);
        SvgManager.bsR().a(this.iRq, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ap.setImageResource(this.iRr, R.drawable.pic_mask_square_circle);
        SvgManager.bsR().a(this.iRs, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.iRt, R.color.CAM_X0105);
        ap.setViewTextColor(this.iRu, R.color.CAM_X0108);
    }

    public void setHasLikeForum(boolean z) {
        this.ajp = z;
    }
}
