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
    private ImageView dWj;
    private View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.ifC.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View iei;
    private b ifA;
    private ac ifB;
    private ImageView ifC;
    private ImageView ifD;
    private TextView ifE;
    private View ifF;
    private TextView ifx;
    private TextView ify;
    private TextView ifz;
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.ifx = (TextView) view.findViewById(R.id.to_user_name);
        this.ify = (TextView) view.findViewById(R.id.content);
        this.ifz = (TextView) view.findViewById(R.id.sender);
        this.iei = view.findViewById(R.id.share_view);
        this.dWj = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.ifC = (ImageView) view.findViewById(R.id.close_button);
        this.ifC.setOnClickListener(this.eHN);
        this.ifD = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.ifD.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.ifD.setLayoutParams(layoutParams);
        this.ifE = (TextView) view.findViewById(R.id.qr_view_intro);
        this.ifF = view.findViewById(R.id.layout_content);
        this.ifF.setBackground(crC());
        this.iei.setBackground(crC());
        this.ifA = new b(tbPageContext);
        this.ifA.crE();
        crD();
        this.ifB = new ac(tbPageContext);
        this.ifB.a(view, this.iei, this);
        this.ifB.setData(this.ifA.url, this.ifA.fname);
        this.ifB.setFrom(5);
    }

    private GradientDrawable crC() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.cp_bg_line_d), ap.getColor(R.color.cp_bg_line_d)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void crD() {
        this.ifx.setText("你好，朋友！");
        this.ify.setText(this.ifA.crG());
        this.ifz.setText(this.ifA.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        zg(this.ifA.shareUrl);
    }

    private void zg(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dWj.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.ifC, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.ifx, R.color.cp_cont_b);
        ap.setViewTextColor(this.ify, R.color.cp_cont_b);
        ap.setViewTextColor(this.ifz, R.color.cp_cont_d);
        ap.setViewTextColor(this.ifE, R.color.cp_cont_d);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cqY() {
        this.iei.setBackground(crC());
        this.ifD.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cqZ() {
        this.iei.setBackground(new ColorDrawable(ap.getColor(R.color.cp_bg_line_d)));
        this.ifD.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
