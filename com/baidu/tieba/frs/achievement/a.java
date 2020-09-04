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
/* loaded from: classes16.dex */
public class a implements ac.a {
    private TbPageContext context;
    private ImageView dTZ;
    private View.OnClickListener eFG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.hYy.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View hXe;
    private TextView hYA;
    private View hYB;
    private TextView hYt;
    private TextView hYu;
    private TextView hYv;
    private b hYw;
    private ac hYx;
    private ImageView hYy;
    private ImageView hYz;
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.hYt = (TextView) view.findViewById(R.id.to_user_name);
        this.hYu = (TextView) view.findViewById(R.id.content);
        this.hYv = (TextView) view.findViewById(R.id.sender);
        this.hXe = view.findViewById(R.id.share_view);
        this.dTZ = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.hYy = (ImageView) view.findViewById(R.id.close_button);
        this.hYy.setOnClickListener(this.eFG);
        this.hYz = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.hYz.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.hYz.setLayoutParams(layoutParams);
        this.hYA = (TextView) view.findViewById(R.id.qr_view_intro);
        this.hYB = view.findViewById(R.id.layout_content);
        this.hYB.setBackground(cop());
        this.hXe.setBackground(cop());
        this.hYw = new b(tbPageContext);
        this.hYw.cor();
        coq();
        this.hYx = new ac(tbPageContext);
        this.hYx.a(view, this.hXe, this);
        this.hYx.setData(this.hYw.url, this.hYw.fname);
        this.hYx.setFrom(5);
    }

    private GradientDrawable cop() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.cp_bg_line_d), ap.getColor(R.color.cp_bg_line_d)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void coq() {
        this.hYt.setText("你好，朋友！");
        this.hYu.setText(this.hYw.cot());
        this.hYv.setText(this.hYw.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        yL(this.hYw.shareUrl);
    }

    private void yL(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dTZ.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.hYy, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.hYt, R.color.cp_cont_b);
        ap.setViewTextColor(this.hYu, R.color.cp_cont_b);
        ap.setViewTextColor(this.hYv, R.color.cp_cont_d);
        ap.setViewTextColor(this.hYA, R.color.cp_cont_d);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cnL() {
        this.hXe.setBackground(cop());
        this.hYz.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cnM() {
        this.hXe.setBackground(new ColorDrawable(ap.getColor(R.color.cp_bg_line_d)));
        this.hYz.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
