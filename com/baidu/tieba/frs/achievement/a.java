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
/* loaded from: classes21.dex */
public class a implements ac.a {
    private TbPageContext context;
    private ImageView euT;
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iNF.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View iMl;
    private TextView iNA;
    private TextView iNB;
    private TextView iNC;
    private b iND;
    private ac iNE;
    private ImageView iNF;
    private ImageView iNG;
    private TextView iNH;
    private View iNI;
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.iNA = (TextView) view.findViewById(R.id.to_user_name);
        this.iNB = (TextView) view.findViewById(R.id.content);
        this.iNC = (TextView) view.findViewById(R.id.sender);
        this.iMl = view.findViewById(R.id.share_view);
        this.euT = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.iNF = (ImageView) view.findViewById(R.id.close_button);
        this.iNF.setOnClickListener(this.fhp);
        this.iNG = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.iNG.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.iNG.setLayoutParams(layoutParams);
        this.iNH = (TextView) view.findViewById(R.id.qr_view_intro);
        this.iNI = view.findViewById(R.id.layout_content);
        this.iNI.setBackground(cAl());
        this.iMl.setBackground(cAl());
        this.iND = new b(tbPageContext);
        this.iND.cAn();
        cAm();
        this.iNE = new ac(tbPageContext);
        this.iNE.a(view, this.iMl, this);
        this.iNE.setData(this.iND.url, this.iND.fname);
        this.iNE.setFrom(5);
    }

    private GradientDrawable cAl() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.CAM_X0201), ap.getColor(R.color.CAM_X0201)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cAm() {
        this.iNA.setText("你好，朋友！");
        this.iNB.setText(this.iND.cAp());
        this.iNC.setText(this.iND.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        zU(this.iND.shareUrl);
    }

    private void zU(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.euT.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.iNF, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.iNA, R.color.CAM_X0105);
        ap.setViewTextColor(this.iNB, R.color.CAM_X0105);
        ap.setViewTextColor(this.iNC, R.color.CAM_X0109);
        ap.setViewTextColor(this.iNH, R.color.CAM_X0109);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void czH() {
        this.iMl.setBackground(cAl());
        this.iNG.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void czI() {
        this.iMl.setBackground(new ColorDrawable(ap.getColor(R.color.CAM_X0201)));
        this.iNG.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
