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
/* loaded from: classes16.dex */
public class b {
    private boolean ahX;
    private RoundRelativeLayout hDY;
    private ImageView hDZ;
    private ImageView hEa;
    private ImageView hEb;
    private TextView hEc;
    private TextView hEd;
    private int hEe;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.hDY = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.hDZ = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.hEa = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.hEc = (TextView) this.mView.findViewById(R.id.square_title);
        this.hEd = (TextView) this.mView.findViewById(R.id.square_desc);
        this.hEb = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.hEc.setText(R.string.forum_square_title);
        this.hEd.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                aq aqVar = new aq("c13645");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai("obj_type", b.this.ahX ? 5 : 1);
                aqVar.ai("obj_source", b.this.ahX ? 1 : 3);
                TiebaStatic.log(aqVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.hEe = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.hDY.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.hDY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hDY.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.hEe) {
                    marginLayoutParams.bottomMargin = this.hEe;
                    this.hDY.requestLayout();
                }
            }
        } else if (this.hDY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hDY.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.hDY.requestLayout();
            }
        }
        ap.setBackgroundColor(this.hDY, R.color.cp_bg_line_g);
        SvgManager.bjq().a(this.hDZ, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ap.setImageResource(this.hEa, R.drawable.pic_mask_square_circle);
        SvgManager.bjq().a(this.hEb, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.hEc, R.color.cp_cont_b);
        ap.setViewTextColor(this.hEd, R.color.cp_cont_c);
    }

    public void setHasLikeForum(boolean z) {
        this.ahX = z;
    }
}
