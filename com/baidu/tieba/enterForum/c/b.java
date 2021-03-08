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
    private boolean akH;
    private RoundRelativeLayout iTm;
    private ImageView iTn;
    private ImageView iTo;
    private ImageView iTp;
    private TextView iTq;
    private TextView iTr;
    private int iTs;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.iTm = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.iTn = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.iTo = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.iTq = (TextView) this.mView.findViewById(R.id.square_title);
        this.iTr = (TextView) this.mView.findViewById(R.id.square_desc);
        this.iTp = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.iTq.setText(R.string.forum_square_title);
        this.iTr.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                ar arVar = new ar("c13645");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.aq("obj_locate", 1);
                arVar.aq("obj_type", b.this.akH ? 5 : 1);
                arVar.aq("obj_source", b.this.akH ? 1 : 3);
                TiebaStatic.log(arVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.iTs = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.iTm.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.iTm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iTm.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.iTs) {
                    marginLayoutParams.bottomMargin = this.iTs;
                    this.iTm.requestLayout();
                }
            }
        } else if (this.iTm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iTm.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.iTm.requestLayout();
            }
        }
        ap.setBackgroundColor(this.iTm, R.color.CAM_X0206);
        SvgManager.bsU().a(this.iTn, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ap.setImageResource(this.iTo, R.drawable.pic_mask_square_circle);
        SvgManager.bsU().a(this.iTp, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.iTq, R.color.CAM_X0105);
        ap.setViewTextColor(this.iTr, R.color.CAM_X0108);
    }

    public void setHasLikeForum(boolean z) {
        this.akH = z;
    }
}
