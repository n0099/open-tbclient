package com.baidu.tieba.frs.achievement;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ac;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes22.dex */
public class a implements ac.a {
    private TbPageContext context;
    private ImageView eqJ;
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iGV.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View iFB;
    private TextView iGQ;
    private TextView iGR;
    private TextView iGS;
    private b iGT;
    private ac iGU;
    private ImageView iGV;
    private ImageView iGW;
    private TextView iGX;
    private View iGY;
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.iGQ = (TextView) view.findViewById(R.id.to_user_name);
        this.iGR = (TextView) view.findViewById(R.id.content);
        this.iGS = (TextView) view.findViewById(R.id.sender);
        this.iFB = view.findViewById(R.id.share_view);
        this.eqJ = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.iGV = (ImageView) view.findViewById(R.id.close_button);
        this.iGV.setOnClickListener(this.fcr);
        this.iGW = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.iGW.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.iGW.setLayoutParams(layoutParams);
        this.iGX = (TextView) view.findViewById(R.id.qr_view_intro);
        this.iGY = view.findViewById(R.id.layout_content);
        this.iGY.setBackground(cyh());
        this.iFB.setBackground(cyh());
        this.iGT = new b(tbPageContext);
        this.iGT.cyj();
        cyi();
        this.iGU = new ac(tbPageContext);
        this.iGU.a(view, this.iFB, this);
        this.iGU.setData(this.iGT.url, this.iGT.fname);
        this.iGU.setFrom(5);
    }

    private GradientDrawable cyh() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.cp_bg_line_d), ap.getColor(R.color.cp_bg_line_d)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cyi() {
        this.iGQ.setText("你好，朋友！");
        this.iGR.setText(this.iGT.cyl());
        this.iGS.setText(this.iGT.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        Al(this.iGT.shareUrl);
    }

    private void Al(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eqJ.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.iGV, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.iGQ, R.color.cp_cont_b);
        ap.setViewTextColor(this.iGR, R.color.cp_cont_b);
        ap.setViewTextColor(this.iGS, R.color.cp_cont_d);
        ap.setViewTextColor(this.iGX, R.color.cp_cont_d);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cxD() {
        this.iFB.setBackground(cyh());
        this.iGW.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cxE() {
        this.iFB.setBackground(new ColorDrawable(ap.getColor(R.color.cp_bg_line_d)));
        this.iGW.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
