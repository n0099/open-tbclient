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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes21.dex */
public class b {
    private boolean aiQ;
    private RoundRelativeLayout iti;
    private ImageView itj;
    private ImageView itk;
    private ImageView itl;
    private TextView itm;
    private TextView itn;
    private int ito;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.iti = (RoundRelativeLayout) this.mView.findViewById(R.id.square_background);
        this.itj = (ImageView) this.mView.findViewById(R.id.square_left_img);
        this.itk = (ImageView) this.mView.findViewById(R.id.square_right_img);
        this.itm = (TextView) this.mView.findViewById(R.id.square_title);
        this.itn = (TextView) this.mView.findViewById(R.id.square_desc);
        this.itl = (ImageView) this.mView.findViewById(R.id.iv_right_arrow);
        this.itm.setText(R.string.forum_square_title);
        this.itn.setText(R.string.forum_square_desc);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(b.this.mPageContext, null);
                ar arVar = new ar("c13645");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.ak("obj_locate", 1);
                arVar.ak("obj_type", b.this.aiQ ? 5 : 1);
                arVar.ak("obj_source", b.this.aiQ ? 1 : 3);
                TiebaStatic.log(arVar);
            }
        });
        this.tbds90 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds90);
        this.ito = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds58);
        this.iti.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar.isTop()) {
            if (this.iti.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iti.getLayoutParams();
                if (marginLayoutParams.bottomMargin != this.ito) {
                    marginLayoutParams.bottomMargin = this.ito;
                    this.iti.requestLayout();
                }
            }
        } else if (this.iti.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iti.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.iti.requestLayout();
            }
        }
        ap.setBackgroundColor(this.iti, R.color.CAM_X0206);
        SvgManager.bqB().a(this.itj, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        ap.setImageResource(this.itk, R.drawable.pic_mask_square_circle);
        SvgManager.bqB().a(this.itl, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.itm, R.color.CAM_X0105);
        ap.setViewTextColor(this.itn, R.color.CAM_X0108);
    }

    public void setHasLikeForum(boolean z) {
        this.aiQ = z;
    }
}
