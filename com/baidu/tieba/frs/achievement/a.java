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
    private ImageView ewC;
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iMS.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View iLy;
    private TextView iMN;
    private TextView iMO;
    private TextView iMP;
    private b iMQ;
    private ac iMR;
    private ImageView iMS;
    private ImageView iMT;
    private TextView iMU;
    private View iMV;
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.iMN = (TextView) view.findViewById(R.id.to_user_name);
        this.iMO = (TextView) view.findViewById(R.id.content);
        this.iMP = (TextView) view.findViewById(R.id.sender);
        this.iLy = view.findViewById(R.id.share_view);
        this.ewC = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.iMS = (ImageView) view.findViewById(R.id.close_button);
        this.iMS.setOnClickListener(this.fii);
        this.iMT = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.iMT.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.iMT.setLayoutParams(layoutParams);
        this.iMU = (TextView) view.findViewById(R.id.qr_view_intro);
        this.iMV = view.findViewById(R.id.layout_content);
        this.iMV.setBackground(cAI());
        this.iLy.setBackground(cAI());
        this.iMQ = new b(tbPageContext);
        this.iMQ.cAK();
        cAJ();
        this.iMR = new ac(tbPageContext);
        this.iMR.a(view, this.iLy, this);
        this.iMR.setData(this.iMQ.url, this.iMQ.fname);
        this.iMR.setFrom(5);
    }

    private GradientDrawable cAI() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.cp_bg_line_d), ap.getColor(R.color.cp_bg_line_d)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cAJ() {
        this.iMN.setText("你好，朋友！");
        this.iMO.setText(this.iMQ.cAM());
        this.iMP.setText(this.iMQ.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        Az(this.iMQ.shareUrl);
    }

    private void Az(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.ewC.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.iMS, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.iMN, R.color.cp_cont_b);
        ap.setViewTextColor(this.iMO, R.color.cp_cont_b);
        ap.setViewTextColor(this.iMP, R.color.cp_cont_d);
        ap.setViewTextColor(this.iMU, R.color.cp_cont_d);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cAe() {
        this.iLy.setBackground(cAI());
        this.iMT.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cAf() {
        this.iLy.setBackground(new ColorDrawable(ap.getColor(R.color.cp_bg_line_d)));
        this.iMT.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
