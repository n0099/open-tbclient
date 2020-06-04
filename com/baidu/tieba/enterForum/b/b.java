package com.baidu.tieba.enterForum.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes9.dex */
public class b {
    private boolean gOf;
    private RoundRelativeLayout gZe;
    private ImageView gZf;
    private ImageView gZg;
    private ImageView gZh;
    private TextView gZi;
    private TextView gZj;
    private int gZk;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.gZe = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.gZf = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.gZg = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.gZi = (TextView) this.mView.findViewById(R.id.square_title);
        this.gZj = (TextView) this.mView.findViewById(R.id.square_desc);
        this.gZh = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.gZi.setText(R.string.forum_square_title);
        this.gZj.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.b(b.this.mPageContext, null);
                an anVar = new an("c13645");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.ag("obj_locate", 1);
                anVar.ag("obj_type", b.this.gOf ? 5 : 1);
                anVar.ag("obj_source", b.this.gOf ? 1 : 3);
                TiebaStatic.log(anVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.gZk = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.gZe.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (bVar.isTop()) {
            if (this.gZe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gZe.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.gZk) {
                    marginLayoutParams.bottomMargin = this.gZk;
                    this.gZe.requestLayout();
                }
            }
        } else if (this.gZe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gZe.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.gZe.requestLayout();
            }
        }
        am.setBackgroundColor(this.gZe, R.color.cp_bg_line_g);
        SvgManager.aUW().a(this.gZf, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.gZg, R.drawable.pic_mask_square_circle);
        SvgManager.aUW().a(this.gZh, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.gZi, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gZj, (int) R.color.cp_cont_c);
    }

    public void setHasLikeForum(boolean z) {
        this.gOf = z;
    }
}
