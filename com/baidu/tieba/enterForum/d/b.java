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
    private boolean aiK;
    private RoundRelativeLayout hZV;
    private ImageView hZW;
    private ImageView hZX;
    private ImageView hZY;
    private TextView hZZ;
    private TextView iaa;
    private int iab;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.hZV = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.hZW = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.hZX = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.hZZ = (TextView) this.mView.findViewById(R.id.square_title);
        this.iaa = (TextView) this.mView.findViewById(R.id.square_desc);
        this.hZY = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.hZZ.setText(R.string.forum_square_title);
        this.iaa.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                aq aqVar = new aq("c13645");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.aj("obj_locate", 1);
                aqVar.aj("obj_type", b.this.aiK ? 5 : 1);
                aqVar.aj("obj_source", b.this.aiK ? 1 : 3);
                TiebaStatic.log(aqVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.iab = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.hZV.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.hZV.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hZV.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.iab) {
                    marginLayoutParams.bottomMargin = this.iab;
                    this.hZV.requestLayout();
                }
            }
        } else if (this.hZV.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hZV.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.hZV.requestLayout();
            }
        }
        ap.setBackgroundColor(this.hZV, R.color.cp_bg_line_g);
        SvgManager.bmU().a(this.hZW, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ap.setImageResource(this.hZX, R.drawable.pic_mask_square_circle);
        SvgManager.bmU().a(this.hZY, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.hZZ, R.color.cp_cont_b);
        ap.setViewTextColor(this.iaa, R.color.cp_cont_c);
    }

    public void setHasLikeForum(boolean z) {
        this.aiK = z;
    }
}
