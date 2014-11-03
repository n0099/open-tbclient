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
    private TextView JN;
    private View aGj;
    private TextView aLg;
    private View aLh;
    private LinearLayout aLk;
    private InterestFrsData.Tag aLs;
    private g aLt;
    private GridView aLu;
    private Context mContext;

    public i(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.aGj = View.inflate(this.mContext, com.baidu.tieba.w.new_user_img_box, null);
        this.aLt = new g(this.mContext);
        setCanceledOnTouchOutside(true);
        this.aLk = (LinearLayout) this.aGj.findViewById(com.baidu.tieba.v.box_close_layout);
        this.aLu = (GridView) this.aGj.findViewById(com.baidu.tieba.v.layout_content);
        this.aLu.setAdapter((ListAdapter) this.aLt);
        this.aLu.setSelector(com.baidu.tieba.s.transparent);
        setContentView(this.aGj);
        this.JN = (TextView) this.aGj.findViewById(com.baidu.tieba.v.prompt_title);
        this.aLg = (TextView) this.aGj.findViewById(com.baidu.tieba.v.prompt_sub_title);
        this.aLh = this.aGj.findViewById(com.baidu.tieba.v.view_layout);
        this.aLh.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.aLs = tag;
        if (this.aLs != null) {
            this.JN.setText(tag.getBname());
            this.aLg.setText(tag.getBdesc());
            this.aLt.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void fk(int i) {
        this.aLt.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.guide.a
    public void fl(int i) {
        this.aLt.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aLk.setOnClickListener(onClickListener);
        this.aLt.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.guide.a
    public View getRootView() {
        return this.aGj;
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
