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
import com.baidu.tieba.frs.y;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class a implements y.a {
    private TbPageContext context;
    private ImageView eIT;
    private View jkq;
    private TextView jlG;
    private TextView jlH;
    private TextView jlI;
    private b jlJ;
    private y jlK;
    private ImageView jlL;
    private ImageView jlM;
    private TextView jlN;
    private View jlO;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.jlL.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.jlG = (TextView) view.findViewById(R.id.to_user_name);
        this.jlH = (TextView) view.findViewById(R.id.content);
        this.jlI = (TextView) view.findViewById(R.id.sender);
        this.jkq = view.findViewById(R.id.share_view);
        this.eIT = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.jlL = (ImageView) view.findViewById(R.id.close_button);
        this.jlL.setOnClickListener(this.onClickListener);
        this.jlM = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.jlM.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.jlM.setLayoutParams(layoutParams);
        this.jlN = (TextView) view.findViewById(R.id.qr_view_intro);
        this.jlO = view.findViewById(R.id.layout_content);
        this.jlO.setBackground(cES());
        this.jkq.setBackground(cES());
        this.jlJ = new b(tbPageContext);
        this.jlJ.cEU();
        cET();
        this.jlK = new y(tbPageContext);
        this.jlK.a(view, this.jkq, this);
        this.jlK.setData(this.jlJ.url, this.jlJ.fname);
        this.jlK.setFrom(5);
    }

    private GradientDrawable cES() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.CAM_X0201), ap.getColor(R.color.CAM_X0201)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cET() {
        this.jlG.setText("你好，朋友！");
        this.jlH.setText(this.jlJ.cEW());
        this.jlI.setText(this.jlJ.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        zF(this.jlJ.shareUrl);
    }

    private void zF(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eIT.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.jlL, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.jlG, R.color.CAM_X0105);
        ap.setViewTextColor(this.jlH, R.color.CAM_X0105);
        ap.setViewTextColor(this.jlI, R.color.CAM_X0109);
        ap.setViewTextColor(this.jlN, R.color.CAM_X0109);
    }

    @Override // com.baidu.tieba.frs.y.a
    public void cEo() {
        this.jkq.setBackground(cES());
        this.jlM.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.y.a
    public void cEp() {
        this.jkq.setBackground(new ColorDrawable(ap.getColor(R.color.CAM_X0201)));
        this.jlM.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
