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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes2.dex */
public class b {
    private boolean akr;
    private RoundRelativeLayout iQo;
    private ImageView iQp;
    private ImageView iQq;
    private ImageView iQr;
    private TextView iQs;
    private TextView iQt;
    private int iQu;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.iQo = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.iQp = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.iQq = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.iQs = (TextView) this.mView.findViewById(R.id.square_title);
        this.iQt = (TextView) this.mView.findViewById(R.id.square_desc);
        this.iQr = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.iQs.setText(R.string.forum_square_title);
        this.iQt.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                aq aqVar = new aq("c13645");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.an("obj_locate", 1);
                aqVar.an("obj_type", b.this.akr ? 5 : 1);
                aqVar.an("obj_source", b.this.akr ? 1 : 3);
                TiebaStatic.log(aqVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.iQu = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.iQo.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.bsa()) {
            if (this.iQo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iQo.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.iQu) {
                    marginLayoutParams.bottomMargin = this.iQu;
                    this.iQo.requestLayout();
                }
            }
        } else if (this.iQo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iQo.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.iQo.requestLayout();
            }
        }
        ao.setBackgroundColor(this.iQo, R.color.CAM_X0206);
        SvgManager.bwq().a(this.iQp, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ao.setImageResource(this.iQq, R.drawable.pic_mask_square_circle);
        SvgManager.bwq().a(this.iQr, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.iQs, R.color.CAM_X0105);
        ao.setViewTextColor(this.iQt, R.color.CAM_X0108);
    }

    public void setHasLikeForum(boolean z) {
        this.akr = z;
    }
}
