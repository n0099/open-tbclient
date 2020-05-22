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
    private boolean gNU;
    private RoundRelativeLayout gYT;
    private ImageView gYU;
    private ImageView gYV;
    private ImageView gYW;
    private TextView gYX;
    private TextView gYY;
    private int gYZ;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.gYT = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.gYU = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.gYV = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.gYX = (TextView) this.mView.findViewById(R.id.square_title);
        this.gYY = (TextView) this.mView.findViewById(R.id.square_desc);
        this.gYW = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.gYX.setText(R.string.forum_square_title);
        this.gYY.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.b(b.this.mPageContext, null);
                an anVar = new an("c13645");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.ag("obj_locate", 1);
                anVar.ag("obj_type", b.this.gNU ? 5 : 1);
                anVar.ag("obj_source", b.this.gNU ? 1 : 3);
                TiebaStatic.log(anVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.gYZ = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.gYT.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (bVar.isTop()) {
            if (this.gYT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gYT.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.gYZ) {
                    marginLayoutParams.bottomMargin = this.gYZ;
                    this.gYT.requestLayout();
                }
            }
        } else if (this.gYT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gYT.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.gYT.requestLayout();
            }
        }
        am.setBackgroundColor(this.gYT, R.color.cp_bg_line_g);
        SvgManager.aUV().a(this.gYU, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.gYV, R.drawable.pic_mask_square_circle);
        SvgManager.aUV().a(this.gYW, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.gYX, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gYY, (int) R.color.cp_cont_c);
    }

    public void setHasLikeForum(boolean z) {
        this.gNU = z;
    }
}
