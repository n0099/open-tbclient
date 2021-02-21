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
    private View jkE;
    private TextView jlU;
    private TextView jlV;
    private TextView jlW;
    private b jlX;
    private y jlY;
    private ImageView jlZ;
    private ImageView jma;
    private TextView jmb;
    private View jmc;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.jlZ.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.jlU = (TextView) view.findViewById(R.id.to_user_name);
        this.jlV = (TextView) view.findViewById(R.id.content);
        this.jlW = (TextView) view.findViewById(R.id.sender);
        this.jkE = view.findViewById(R.id.share_view);
        this.eIT = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.jlZ = (ImageView) view.findViewById(R.id.close_button);
        this.jlZ.setOnClickListener(this.onClickListener);
        this.jma = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.jma.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.jma.setLayoutParams(layoutParams);
        this.jmb = (TextView) view.findViewById(R.id.qr_view_intro);
        this.jmc = view.findViewById(R.id.layout_content);
        this.jmc.setBackground(cEZ());
        this.jkE.setBackground(cEZ());
        this.jlX = new b(tbPageContext);
        this.jlX.cFb();
        cFa();
        this.jlY = new y(tbPageContext);
        this.jlY.a(view, this.jkE, this);
        this.jlY.setData(this.jlX.url, this.jlX.fname);
        this.jlY.setFrom(5);
    }

    private GradientDrawable cEZ() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.CAM_X0201), ap.getColor(R.color.CAM_X0201)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cFa() {
        this.jlU.setText("你好，朋友！");
        this.jlV.setText(this.jlX.cFd());
        this.jlW.setText(this.jlX.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        zF(this.jlX.shareUrl);
    }

    private void zF(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eIT.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.jlZ, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.jlU, R.color.CAM_X0105);
        ap.setViewTextColor(this.jlV, R.color.CAM_X0105);
        ap.setViewTextColor(this.jlW, R.color.CAM_X0109);
        ap.setViewTextColor(this.jmb, R.color.CAM_X0109);
    }

    @Override // com.baidu.tieba.frs.y.a
    public void cEv() {
        this.jkE.setBackground(cEZ());
        this.jma.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.y.a
    public void cEw() {
        this.jkE.setBackground(new ColorDrawable(ap.getColor(R.color.CAM_X0201)));
        this.jma.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
