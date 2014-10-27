package com.baidu.tieba.guide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends Dialog implements a {
    private TextView JM;
    private View aFZ;
    private TextView aKS;
    private View aKT;
    private LinearLayout aKU;
    private View.OnClickListener aKV;
    private LinearLayout aKW;
    private Context mContext;

    public e(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.aFZ = View.inflate(this.mContext, com.baidu.tieba.w.new_user_box, null);
        setContentView(this.aFZ);
        setCanceledOnTouchOutside(true);
        this.aKW = (LinearLayout) this.aFZ.findViewById(com.baidu.tieba.v.box_close_layout);
        this.JM = (TextView) this.aFZ.findViewById(com.baidu.tieba.v.prompt_title);
        this.aKS = (TextView) this.aFZ.findViewById(com.baidu.tieba.v.prompt_sub_title);
        this.aKT = this.aFZ.findViewById(com.baidu.tieba.v.view_layout);
        this.aKU = (LinearLayout) findViewById(com.baidu.tieba.v.layout_content);
        this.aKT.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aKV = onClickListener;
        this.aKW.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.j.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.JM.setText(tag.getBname());
        this.aKS.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new f(this, card, this.aKV).getView();
            this.aKU.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.aKU.addView(com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.new_user_line_item, null));
            }
            ((TbImageView) this.aKU.findViewWithTag(card.getAvatar())).c(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds120);
        if ((getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds188) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void fk(int i) {
        View findViewWithTag = this.aKU.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new f(this, findViewWithTag).cs(true);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void fl(int i) {
        View findViewWithTag = this.aKU.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new f(this, findViewWithTag).cs(false);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public View getRootView() {
        return this.aFZ;
    }
}
