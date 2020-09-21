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
/* loaded from: classes21.dex */
public class b {
    private boolean ais;
    private RoundRelativeLayout hLa;
    private ImageView hLb;
    private ImageView hLc;
    private ImageView hLd;
    private TextView hLe;
    private TextView hLf;
    private int hLg;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.hLa = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.hLb = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.hLc = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.hLe = (TextView) this.mView.findViewById(R.id.square_title);
        this.hLf = (TextView) this.mView.findViewById(R.id.square_desc);
        this.hLd = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.hLe.setText(R.string.forum_square_title);
        this.hLf.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                aq aqVar = new aq("c13645");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai("obj_type", b.this.ais ? 5 : 1);
                aqVar.ai("obj_source", b.this.ais ? 1 : 3);
                TiebaStatic.log(aqVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.hLg = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.hLa.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.hLa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hLa.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.hLg) {
                    marginLayoutParams.bottomMargin = this.hLg;
                    this.hLa.requestLayout();
                }
            }
        } else if (this.hLa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hLa.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.hLa.requestLayout();
            }
        }
        ap.setBackgroundColor(this.hLa, R.color.cp_bg_line_g);
        SvgManager.bkl().a(this.hLb, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ap.setImageResource(this.hLc, R.drawable.pic_mask_square_circle);
        SvgManager.bkl().a(this.hLd, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.hLe, R.color.cp_cont_b);
        ap.setViewTextColor(this.hLf, R.color.cp_cont_c);
    }

    public void setHasLikeForum(boolean z) {
        this.ais = z;
    }
}
