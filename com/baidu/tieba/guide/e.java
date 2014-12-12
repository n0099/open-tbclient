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
import com.baidu.tieba.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends Dialog implements a {
    private View aNa;
    private LinearLayout aNb;
    private View.OnClickListener aNc;
    private View aNd;
    private LinearLayout aNe;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public e(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.aNd = View.inflate(this.mContext, x.new_user_box, null);
        setContentView(this.aNd);
        setCanceledOnTouchOutside(true);
        this.aNe = (LinearLayout) this.aNd.findViewById(com.baidu.tieba.w.box_close_layout);
        this.mTitle = (TextView) this.aNd.findViewById(com.baidu.tieba.w.prompt_title);
        this.mSubTitle = (TextView) this.aNd.findViewById(com.baidu.tieba.w.prompt_sub_title);
        this.aNa = this.aNd.findViewById(com.baidu.tieba.w.view_layout);
        this.aNb = (LinearLayout) findViewById(com.baidu.tieba.w.layout_content);
        this.aNa.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.v.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aNc = onClickListener;
        this.aNe.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.k.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.mTitle.setText(tag.getBname());
        this.mSubTitle.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new f(this, card, this.aNc).getView();
            this.aNb.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.aNb.addView(com.baidu.adp.lib.g.b.ek().inflate(this.mContext, x.new_user_line_item, null));
            }
            ((TbImageView) this.aNb.findViewWithTag(card.getAvatar())).d(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds120);
        if ((getContext().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds188) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void fl(int i) {
        View findViewWithTag = this.aNb.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new f(this, findViewWithTag).cg(true);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void fm(int i) {
        View findViewWithTag = this.aNb.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new f(this, findViewWithTag).cg(false);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public View getRootView() {
        return this.aNd;
    }
}
