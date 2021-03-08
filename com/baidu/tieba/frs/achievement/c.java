package com.baidu.tieba.frs.achievement;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class c {
    private TbPageContext context;
    private View.OnClickListener jnC;
    private TextView jnE;
    private TextView jnF;
    private TextView jnG;
    private b jnH;
    private TBSpecificationBtn joc;
    private TBSpecificationBtn jod;
    private View joe;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.joc.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.zd(2);
            } else if (view.getId() == c.this.jod.getId()) {
                if (c.this.jnC != null) {
                    c.this.jnC.onClick(view);
                }
                c.this.zd(1);
            }
        }
    };
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.jnE = (TextView) view.findViewById(R.id.to_user_name);
        this.jnF = (TextView) view.findViewById(R.id.content);
        this.jnG = (TextView) view.findViewById(R.id.sender);
        this.joc = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pS(R.color.CAM_X0618);
        this.joc.setConfig(cVar);
        this.joc.setTextSize(R.dimen.tbds42);
        this.joc.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.joc.setOnClickListener(this.onClickListener);
        this.jod = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.aY(R.color.CAM_X0302, R.color.CAM_X0101);
        this.jod.setConfig(bVar);
        this.jod.setTextSize(R.dimen.tbds42);
        this.jod.setText(tbPageContext.getString(R.string.go_to_share));
        this.jod.setOnClickListener(this.onClickListener);
        this.joe = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.joe.setBackground(gradientDrawable);
        this.jnH = new b(tbPageContext);
        this.jnH.cFh();
        cFg();
        TiebaStatic.log(new ar("c13893").aq("obj_source", (this.jnH.jnU == null || !this.jnH.jnU.equals("bazhu")) ? 2 : 1).dR("fid", this.jnH.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cFg() {
        this.jnE.setText(this.jnH.nickName + ":");
        this.jnF.setText(this.jnH.cFi());
        this.jnG.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zd(int i) {
        TiebaStatic.log(new ar("c13892").aq("obj_type", i).aq("obj_source", (this.jnH.jnU == null || !this.jnH.jnU.equals("bazhu")) ? 2 : 1).dR("fid", this.jnH.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void B(View.OnClickListener onClickListener) {
        this.jnC = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.jnE, R.color.CAM_X0101);
        ap.setViewTextColor(this.jnF, R.color.CAM_X0101);
        ap.setViewTextColor(this.jnG, R.color.CAM_X0109);
    }
}
