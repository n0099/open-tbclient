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
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iuz.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private ImageView eil;
    private View itf;
    private ImageView iuA;
    private TextView iuB;
    private View iuC;
    private TextView iuu;
    private TextView iuv;
    private TextView iuw;
    private b iux;
    private ac iuy;
    private ImageView iuz;
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.iuu = (TextView) view.findViewById(R.id.to_user_name);
        this.iuv = (TextView) view.findViewById(R.id.content);
        this.iuw = (TextView) view.findViewById(R.id.sender);
        this.itf = view.findViewById(R.id.share_view);
        this.eil = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.iuz = (ImageView) view.findViewById(R.id.close_button);
        this.iuz.setOnClickListener(this.eTU);
        this.iuA = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.iuA.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.iuA.setLayoutParams(layoutParams);
        this.iuB = (TextView) view.findViewById(R.id.qr_view_intro);
        this.iuC = view.findViewById(R.id.layout_content);
        this.iuC.setBackground(cva());
        this.itf.setBackground(cva());
        this.iux = new b(tbPageContext);
        this.iux.cvc();
        cvb();
        this.iuy = new ac(tbPageContext);
        this.iuy.a(view, this.itf, this);
        this.iuy.setData(this.iux.url, this.iux.fname);
        this.iuy.setFrom(5);
    }

    private GradientDrawable cva() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.cp_bg_line_d), ap.getColor(R.color.cp_bg_line_d)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cvb() {
        this.iuu.setText("你好，朋友！");
        this.iuv.setText(this.iux.cve());
        this.iuw.setText(this.iux.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        zS(this.iux.shareUrl);
    }

    private void zS(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eil.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.iuz, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.iuu, R.color.cp_cont_b);
        ap.setViewTextColor(this.iuv, R.color.cp_cont_b);
        ap.setViewTextColor(this.iuw, R.color.cp_cont_d);
        ap.setViewTextColor(this.iuB, R.color.cp_cont_d);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cuw() {
        this.itf.setBackground(cva());
        this.iuA.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cux() {
        this.itf.setBackground(new ColorDrawable(ap.getColor(R.color.cp_bg_line_d)));
        this.iuA.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
