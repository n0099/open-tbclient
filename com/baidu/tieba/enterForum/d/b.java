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
    private int isA;
    private RoundRelativeLayout isu;
    private ImageView isv;
    private ImageView isw;
    private ImageView isx;
    private TextView isy;
    private TextView isz;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.isu = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.isv = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.isw = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.isy = (TextView) this.mView.findViewById(R.id.square_title);
        this.isz = (TextView) this.mView.findViewById(R.id.square_desc);
        this.isx = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.isy.setText(R.string.forum_square_title);
        this.isz.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                aq aqVar = new aq("c13645");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.al("obj_locate", 1);
                aqVar.al("obj_type", b.this.aiL ? 5 : 1);
                aqVar.al("obj_source", b.this.aiL ? 1 : 3);
                TiebaStatic.log(aqVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.isA = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.isu.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.isu.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.isu.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.isA) {
                    marginLayoutParams.bottomMargin = this.isA;
                    this.isu.requestLayout();
                }
            }
        } else if (this.isu.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.isu.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.isu.requestLayout();
            }
        }
        ap.setBackgroundColor(this.isu, R.color.cp_bg_line_g);
        SvgManager.brn().a(this.isv, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ap.setImageResource(this.isw, R.drawable.pic_mask_square_circle);
        SvgManager.brn().a(this.isx, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.isy, R.color.cp_cont_b);
        ap.setViewTextColor(this.isz, R.color.cp_cont_c);
    }

    public void setHasLikeForum(boolean z) {
        this.aiL = z;
    }
}
