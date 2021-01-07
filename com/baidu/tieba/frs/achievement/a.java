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
    private ImageView eLy;
    private View jjr;
    private TextView jkG;
    private TextView jkH;
    private TextView jkI;
    private b jkJ;
    private y jkK;
    private ImageView jkL;
    private ImageView jkM;
    private TextView jkN;
    private View jkO;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.jkL.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.jkG = (TextView) view.findViewById(R.id.to_user_name);
        this.jkH = (TextView) view.findViewById(R.id.content);
        this.jkI = (TextView) view.findViewById(R.id.sender);
        this.jjr = view.findViewById(R.id.share_view);
        this.eLy = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.jkL = (ImageView) view.findViewById(R.id.close_button);
        this.jkL.setOnClickListener(this.onClickListener);
        this.jkM = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.jkM.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.jkM.setLayoutParams(layoutParams);
        this.jkN = (TextView) view.findViewById(R.id.qr_view_intro);
        this.jkO = view.findViewById(R.id.layout_content);
        this.jkO.setBackground(cHy());
        this.jjr.setBackground(cHy());
        this.jkJ = new b(tbPageContext);
        this.jkJ.cHA();
        cHz();
        this.jkK = new y(tbPageContext);
        this.jkK.a(view, this.jjr, this);
        this.jkK.setData(this.jkJ.url, this.jkJ.fname);
        this.jkK.setFrom(5);
    }

    private GradientDrawable cHy() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ao.getColor(R.color.CAM_X0201), ao.getColor(R.color.CAM_X0201)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cHz() {
        this.jkG.setText("你好，朋友！");
        this.jkH.setText(this.jkJ.cHC());
        this.jkI.setText(this.jkJ.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        Az(this.jkJ.shareUrl);
    }

    private void Az(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eLy.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ao.setImageResource(this.jkL, R.drawable.icon_popup_shut_n);
        ao.setViewTextColor(this.jkG, R.color.CAM_X0105);
        ao.setViewTextColor(this.jkH, R.color.CAM_X0105);
        ao.setViewTextColor(this.jkI, R.color.CAM_X0109);
        ao.setViewTextColor(this.jkN, R.color.CAM_X0109);
    }

    @Override // com.baidu.tieba.frs.y.a
    public void cGU() {
        this.jjr.setBackground(cHy());
        this.jkM.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.y.a
    public void cGV() {
        this.jjr.setBackground(new ColorDrawable(ao.getColor(R.color.CAM_X0201)));
        this.jkM.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
