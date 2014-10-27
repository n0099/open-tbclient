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
/* loaded from: classes.dex */
public class i extends Dialog implements a {
    private TextView JM;
    private View aFZ;
    private TextView aKS;
    private View aKT;
    private LinearLayout aKW;
    private InterestFrsData.Tag aLe;
    private g aLf;
    private GridView aLg;
    private Context mContext;

    public i(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.aFZ = View.inflate(this.mContext, com.baidu.tieba.w.new_user_img_box, null);
        this.aLf = new g(this.mContext);
        setCanceledOnTouchOutside(true);
        this.aKW = (LinearLayout) this.aFZ.findViewById(com.baidu.tieba.v.box_close_layout);
        this.aLg = (GridView) this.aFZ.findViewById(com.baidu.tieba.v.layout_content);
        this.aLg.setAdapter((ListAdapter) this.aLf);
        this.aLg.setSelector(com.baidu.tieba.s.transparent);
        setContentView(this.aFZ);
        this.JM = (TextView) this.aFZ.findViewById(com.baidu.tieba.v.prompt_title);
        this.aKS = (TextView) this.aFZ.findViewById(com.baidu.tieba.v.prompt_sub_title);
        this.aKT = this.aFZ.findViewById(com.baidu.tieba.v.view_layout);
        this.aKT.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.aLe = tag;
        if (this.aLe != null) {
            this.JM.setText(tag.getBname());
            this.aKS.setText(tag.getBdesc());
            this.aLf.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void fk(int i) {
        this.aLf.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.guide.a
    public void fl(int i) {
        this.aLf.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aKW.setOnClickListener(onClickListener);
        this.aLf.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.guide.a
    public View getRootView() {
        return this.aFZ;
    }

    @Override // android.app.Dialog, com.baidu.tieba.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.j.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}
