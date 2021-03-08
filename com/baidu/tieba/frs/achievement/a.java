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
    private ImageView eKu;
    private View jmn;
    private TextView jnE;
    private TextView jnF;
    private TextView jnG;
    private b jnH;
    private y jnI;
    private ImageView jnJ;
    private ImageView jnK;
    private TextView jnL;
    private View jnM;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.jnJ.getId()) {
                a.this.context.getPageActivity().finish();
            }
        }
    };
    private View rootView;

    public a(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.jnE = (TextView) view.findViewById(R.id.to_user_name);
        this.jnF = (TextView) view.findViewById(R.id.content);
        this.jnG = (TextView) view.findViewById(R.id.sender);
        this.jmn = view.findViewById(R.id.share_view);
        this.eKu = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        this.jnJ = (ImageView) view.findViewById(R.id.close_button);
        this.jnJ.setOnClickListener(this.onClickListener);
        this.jnK = (ImageView) view.findViewById(R.id.img_top);
        ViewGroup.LayoutParams layoutParams = this.jnK.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.height = (int) (((layoutParams.width * 364) * 1.0f) / 980.0f);
        this.jnK.setLayoutParams(layoutParams);
        this.jnL = (TextView) view.findViewById(R.id.qr_view_intro);
        this.jnM = view.findViewById(R.id.layout_content);
        this.jnM.setBackground(cFf());
        this.jmn.setBackground(cFf());
        this.jnH = new b(tbPageContext);
        this.jnH.cFh();
        cFg();
        this.jnI = new y(tbPageContext);
        this.jnI.a(view, this.jmn, this);
        this.jnI.setData(this.jnH.url, this.jnH.fname);
        this.jnI.setFrom(5);
    }

    private GradientDrawable cFf() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ap.getColor(R.color.CAM_X0201), ap.getColor(R.color.CAM_X0201)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.getDimens(this.context.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cFg() {
        this.jnE.setText("你好，朋友！");
        this.jnF.setText(this.jnH.cFj());
        this.jnG.setText(this.jnH.nickName + "\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
        zM(this.jnH.shareUrl);
    }

    private void zM(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eKu.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public void onChangeSkinType(int i) {
        ap.setImageResource(this.jnJ, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.jnE, R.color.CAM_X0105);
        ap.setViewTextColor(this.jnF, R.color.CAM_X0105);
        ap.setViewTextColor(this.jnG, R.color.CAM_X0109);
        ap.setViewTextColor(this.jnL, R.color.CAM_X0109);
    }

    @Override // com.baidu.tieba.frs.y.a
    public void cEB() {
        this.jmn.setBackground(cFf());
        this.jnK.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    @Override // com.baidu.tieba.frs.y.a
    public void cEC() {
        this.jmn.setBackground(new ColorDrawable(ap.getColor(R.color.CAM_X0201)));
        this.jnK.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }
}
