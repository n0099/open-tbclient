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
    private RoundRelativeLayout gKh;
    private ImageView gKi;
    private ImageView gKj;
    private ImageView gKk;
    private TextView gKl;
    private TextView gKm;
    private int gKn;
    private boolean gzk;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.gKh = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.gKi = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.gKj = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.gKl = (TextView) this.mView.findViewById(R.id.square_title);
        this.gKm = (TextView) this.mView.findViewById(R.id.square_desc);
        this.gKk = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.gKl.setText(R.string.forum_square_title);
        this.gKm.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.b(b.this.mPageContext, null);
                an anVar = new an("c13645");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.af("obj_locate", 1);
                anVar.af("obj_type", b.this.gzk ? 5 : 1);
                anVar.af("obj_source", b.this.gzk ? 1 : 3);
                TiebaStatic.log(anVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.gKn = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.gKh.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (bVar.isTop()) {
            if (this.gKh.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gKh.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.gKn) {
                    marginLayoutParams.bottomMargin = this.gKn;
                    this.gKh.requestLayout();
                }
            }
        } else if (this.gKh.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gKh.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.gKh.requestLayout();
            }
        }
        am.setBackgroundColor(this.gKh, R.color.cp_bg_line_g);
        SvgManager.aOR().a(this.gKi, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.gKj, R.drawable.pic_mask_square_circle);
        SvgManager.aOR().a(this.gKk, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.gKl, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gKm, (int) R.color.cp_cont_c);
    }

    public void setHasLikeForum(boolean z) {
        this.gzk = z;
    }
}
