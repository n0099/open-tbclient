package com.baidu.tieba.guide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class i extends Dialog implements a {
    private View aNa;
    private View aNd;
    private LinearLayout aNe;
    private InterestFrsData.Tag aNm;
    private g aNn;
    private GridView aNo;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public i(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.aNd = View.inflate(this.mContext, x.new_user_img_box, null);
        this.aNn = new g(this.mContext);
        setCanceledOnTouchOutside(true);
        this.aNe = (LinearLayout) this.aNd.findViewById(com.baidu.tieba.w.box_close_layout);
        this.aNo = (GridView) this.aNd.findViewById(com.baidu.tieba.w.layout_content);
        this.aNo.setAdapter((ListAdapter) this.aNn);
        this.aNo.setSelector(com.baidu.tieba.t.transparent);
        setContentView(this.aNd);
        this.mTitle = (TextView) this.aNd.findViewById(com.baidu.tieba.w.prompt_title);
        this.mSubTitle = (TextView) this.aNd.findViewById(com.baidu.tieba.w.prompt_sub_title);
        this.aNa = this.aNd.findViewById(com.baidu.tieba.w.view_layout);
        this.aNa.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.v.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.aNm = tag;
        if (this.aNm != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.aNn.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void fl(int i) {
        this.aNn.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.guide.a
    public void fm(int i) {
        this.aNn.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aNe.setOnClickListener(onClickListener);
        this.aNn.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.guide.a
    public View getRootView() {
        return this.aNd;
    }

    @Override // android.app.Dialog, com.baidu.tieba.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.k.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}
