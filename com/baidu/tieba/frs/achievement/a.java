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
            if (view.getId() == a.this.iYw.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View iXc;
    private TextView iYr;
    private TextView iYs;
    private TextView iYt;
    private b iYu;
    private ab iYv;
    private ImageView iYw;
    private ImageView iYx;
    private TextView iYy;
    private View iYz;
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.iYr = (TextView) view.findViewById(R.id.to_user_name);
        this.iYs = (TextView) view.findViewById(R.id.content);
        this.iYt = (TextView) view.findViewById(R.id.sender);
        this.iXc = view.findViewById(R.id.share_view);
        this.eBV = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.iYw = (ImageView) view.findViewById(R.id.close_button);
        this.iYw.setOnClickListener(this.foP);
        this.iYx = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.iYx.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.iYx.setLayoutParams(layoutParams);
        this.iYy = (TextView) view.findViewById(R.id.qr_view_intro);
        this.iYz = view.findViewById(R.id.layout_content);
        this.iYz.setBackground(cEB());
        this.iXc.setBackground(cEB());
        this.iYu = new b(tbPageContext);
        this.iYu.cED();
        cEC();
        this.iYv = new ab(tbPageContext);
        this.iYv.a(view, this.iXc, this);
        this.iYv.setData(this.iYu.url, this.iYu.fname);
        this.iYv.setFrom(5);
    }

    private GradientDrawable cEB() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.CAM_X0201), ap.getColor(R.color.CAM_X0201)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cEC() {
        this.iYr.setText("你好，朋友！");
        this.iYs.setText(this.iYu.cEF());
        this.iYt.setText(this.iYu.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        AB(this.iYu.shareUrl);
    }

    private void AB(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eBV.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.iYw, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.iYr, R.color.CAM_X0105);
        ap.setViewTextColor(this.iYs, R.color.CAM_X0105);
        ap.setViewTextColor(this.iYt, R.color.CAM_X0109);
        ap.setViewTextColor(this.iYy, R.color.CAM_X0109);
    }

    @Override // com.baidu.tieba.frs.ab.a
    public void cDX() {
        this.iXc.setBackground(cEB());
        this.iYx.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.ab.a
    public void cDY() {
        this.iXc.setBackground(new ColorDrawable(ap.getColor(R.color.CAM_X0201)));
        this.iYx.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
