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
import com.baidu.tieba.frs.ab;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes22.dex */
public class a implements ab.a {
    private TbPageContext context;
    private ImageView eBV;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iYy.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View iXe;
    private TextView iYA;
    private View iYB;
    private TextView iYt;
    private TextView iYu;
    private TextView iYv;
    private b iYw;
    private ab iYx;
    private ImageView iYy;
    private ImageView iYz;
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.iYt = (TextView) view.findViewById(R.id.to_user_name);
        this.iYu = (TextView) view.findViewById(R.id.content);
        this.iYv = (TextView) view.findViewById(R.id.sender);
        this.iXe = view.findViewById(R.id.share_view);
        this.eBV = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.iYy = (ImageView) view.findViewById(R.id.close_button);
        this.iYy.setOnClickListener(this.foP);
        this.iYz = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.iYz.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.iYz.setLayoutParams(layoutParams);
        this.iYA = (TextView) view.findViewById(R.id.qr_view_intro);
        this.iYB = view.findViewById(R.id.layout_content);
        this.iYB.setBackground(cEC());
        this.iXe.setBackground(cEC());
        this.iYw = new b(tbPageContext);
        this.iYw.cEE();
        cED();
        this.iYx = new ab(tbPageContext);
        this.iYx.a(view, this.iXe, this);
        this.iYx.setData(this.iYw.url, this.iYw.fname);
        this.iYx.setFrom(5);
    }

    private GradientDrawable cEC() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.CAM_X0201), ap.getColor(R.color.CAM_X0201)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cED() {
        this.iYt.setText("你好，朋友！");
        this.iYu.setText(this.iYw.cEG());
        this.iYv.setText(this.iYw.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        AB(this.iYw.shareUrl);
    }

    private void AB(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eBV.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.iYy, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.iYt, R.color.CAM_X0105);
        ap.setViewTextColor(this.iYu, R.color.CAM_X0105);
        ap.setViewTextColor(this.iYv, R.color.CAM_X0109);
        ap.setViewTextColor(this.iYA, R.color.CAM_X0109);
    }

    @Override // com.baidu.tieba.frs.ab.a
    public void cDY() {
        this.iXe.setBackground(cEC());
        this.iYz.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.ab.a
    public void cDZ() {
        this.iXe.setBackground(new ColorDrawable(ap.getColor(R.color.CAM_X0201)));
        this.iYz.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
