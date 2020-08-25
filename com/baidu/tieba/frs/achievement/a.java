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
    private ImageView dTV;
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.hYs.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View hWY;
    private TextView hYn;
    private TextView hYo;
    private TextView hYp;
    private b hYq;
    private ac hYr;
    private ImageView hYs;
    private ImageView hYt;
    private TextView hYu;
    private View hYv;
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.hYn = (TextView) view.findViewById(R.id.to_user_name);
        this.hYo = (TextView) view.findViewById(R.id.content);
        this.hYp = (TextView) view.findViewById(R.id.sender);
        this.hWY = view.findViewById(R.id.share_view);
        this.dTV = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.hYs = (ImageView) view.findViewById(R.id.close_button);
        this.hYs.setOnClickListener(this.eFC);
        this.hYt = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.hYt.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.hYt.setLayoutParams(layoutParams);
        this.hYu = (TextView) view.findViewById(R.id.qr_view_intro);
        this.hYv = view.findViewById(R.id.layout_content);
        this.hYv.setBackground(coo());
        this.hWY.setBackground(coo());
        this.hYq = new b(tbPageContext);
        this.hYq.coq();
        cop();
        this.hYr = new ac(tbPageContext);
        this.hYr.a(view, this.hWY, this);
        this.hYr.setData(this.hYq.url, this.hYq.fname);
        this.hYr.setFrom(5);
    }

    private GradientDrawable coo() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.cp_bg_line_d), ap.getColor(R.color.cp_bg_line_d)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cop() {
        this.hYn.setText("你好，朋友！");
        this.hYo.setText(this.hYq.cos());
        this.hYp.setText(this.hYq.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        yK(this.hYq.shareUrl);
    }

    private void yK(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dTV.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.hYs, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.hYn, R.color.cp_cont_b);
        ap.setViewTextColor(this.hYo, R.color.cp_cont_b);
        ap.setViewTextColor(this.hYp, R.color.cp_cont_d);
        ap.setViewTextColor(this.hYu, R.color.cp_cont_d);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cnK() {
        this.hWY.setBackground(coo());
        this.hYt.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.ac.a
    public void cnL() {
        this.hWY.setBackground(new ColorDrawable(ap.getColor(R.color.cp_bg_line_d)));
        this.hYt.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
