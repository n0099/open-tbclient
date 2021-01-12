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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.y;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class a implements y.a {
    private TbPageContext context;
    private ImageView eGN;
    private View jeJ;
    private TextView jfZ;
    private TextView jga;
    private TextView jgb;
    private b jgc;
    private y jgd;
    private ImageView jge;
    private ImageView jgf;
    private TextView jgg;
    private View jgh;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.jge.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.jfZ = (TextView) view.findViewById(R.id.to_user_name);
        this.jga = (TextView) view.findViewById(R.id.content);
        this.jgb = (TextView) view.findViewById(R.id.sender);
        this.jeJ = view.findViewById(R.id.share_view);
        this.eGN = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.jge = (ImageView) view.findViewById(R.id.close_button);
        this.jge.setOnClickListener(this.onClickListener);
        this.jgf = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.jgf.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.jgf.setLayoutParams(layoutParams);
        this.jgg = (TextView) view.findViewById(R.id.qr_view_intro);
        this.jgh = view.findViewById(R.id.layout_content);
        this.jgh.setBackground(cDG());
        this.jeJ.setBackground(cDG());
        this.jgc = new b(tbPageContext);
        this.jgc.cDI();
        cDH();
        this.jgd = new y(tbPageContext);
        this.jgd.a(view, this.jeJ, this);
        this.jgd.setData(this.jgc.url, this.jgc.fname);
        this.jgd.setFrom(5);
    }

    private GradientDrawable cDG() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ao.getColor(R.color.CAM_X0201), ao.getColor(R.color.CAM_X0201)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cDH() {
        this.jfZ.setText("你好，朋友！");
        this.jga.setText(this.jgc.cDK());
        this.jgb.setText(this.jgc.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        zo(this.jgc.shareUrl);
    }

    private void zo(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eGN.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ao.setImageResource(this.jge, R.drawable.icon_popup_shut_n);
        ao.setViewTextColor(this.jfZ, R.color.CAM_X0105);
        ao.setViewTextColor(this.jga, R.color.CAM_X0105);
        ao.setViewTextColor(this.jgb, R.color.CAM_X0109);
        ao.setViewTextColor(this.jgg, R.color.CAM_X0109);
    }

    @Override // com.baidu.tieba.frs.y.a
    public void cDc() {
        this.jeJ.setBackground(cDG());
        this.jgf.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.y.a
    public void cDd() {
        this.jeJ.setBackground(new ColorDrawable(ao.getColor(R.color.CAM_X0201)));
        this.jgf.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
