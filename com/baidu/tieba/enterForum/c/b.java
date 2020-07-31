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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes16.dex */
public class b {
    private boolean agM;
    private RoundRelativeLayout hrb;
    private ImageView hrc;
    private ImageView hrd;
    private ImageView hre;
    private TextView hrf;
    private TextView hrg;
    private int hrh;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.hrb = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.hrc = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.hrd = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.hrf = (TextView) this.mView.findViewById(R.id.square_title);
        this.hrg = (TextView) this.mView.findViewById(R.id.square_desc);
        this.hre = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.hrf.setText(R.string.forum_square_title);
        this.hrg.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                ap apVar = new ap("c13645");
                apVar.t("uid", TbadkApplication.getCurrentAccountId());
                apVar.ah("obj_locate", 1);
                apVar.ah("obj_type", b.this.agM ? 5 : 1);
                apVar.ah("obj_source", b.this.agM ? 1 : 3);
                TiebaStatic.log(apVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.hrh = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.hrb.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.hrb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hrb.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.hrh) {
                    marginLayoutParams.bottomMargin = this.hrh;
                    this.hrb.requestLayout();
                }
            }
        } else if (this.hrb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hrb.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.hrb.requestLayout();
            }
        }
        ao.setBackgroundColor(this.hrb, R.color.cp_bg_line_g);
        SvgManager.baR().a(this.hrc, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ao.setImageResource(this.hrd, R.drawable.pic_mask_square_circle);
        SvgManager.baR().a(this.hre, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.hrf, R.color.cp_cont_b);
        ao.setViewTextColor(this.hrg, R.color.cp_cont_c);
    }

    public void setHasLikeForum(boolean z) {
        this.agM = z;
    }
}
