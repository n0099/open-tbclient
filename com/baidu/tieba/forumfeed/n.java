package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {
    final /* synthetic */ j b;
    private final TextView c;
    private final TextView d;
    private final ImageView e;
    private final LinearLayout g;
    private final Button h;
    private final View i;
    private Bitmap f = null;
    public boolean a = false;

    public n(j jVar, Context context, View view) {
        this.b = jVar;
        this.i = view;
        this.c = (TextView) view.findViewById(u.tip1);
        this.d = (TextView) view.findViewById(u.tip2);
        this.e = (ImageView) view.findViewById(u.nodata_img_bg);
        this.h = (Button) view.findViewById(u.btn_go);
        this.g = (LinearLayout) view.findViewById(u.layout_btn_go);
        this.h.setOnClickListener(new o(this, context));
    }

    public void a() {
        LinearLayout linearLayout;
        this.a = false;
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.e.setBackgroundDrawable(null);
        if (this.f != null) {
            if (!this.f.isRecycled()) {
                this.f.recycle();
            }
            this.f = null;
        }
        this.g.setVisibility(8);
        int i = TbadkApplication.m252getInst().getSkinType() == 1 ? r.forumfeed_frs_bg_1 : r.forumfeed_frs_bg;
        linearLayout = this.b.k;
        linearLayout.setBackgroundResource(i);
    }

    public void b() {
        LinearLayout linearLayout;
        this.a = true;
        a(TbadkApplication.m252getInst().getSkinType());
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.g.setVisibility(0);
        linearLayout = this.b.k;
        linearLayout.setBackgroundColor(0);
    }

    public void a(int i) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        if (i == 1) {
            this.i.setBackgroundResource(r.forumfeed_frs_bg_1);
            if (this.a) {
                baseFragmentActivity2 = this.b.c;
                this.f = com.baidu.tbadk.core.util.d.b(baseFragmentActivity2, t.pic_emotion01_1);
            }
        } else if (this.a) {
            this.i.setBackgroundResource(r.forumfeed_frs_bg);
            baseFragmentActivity = this.b.c;
            this.f = com.baidu.tbadk.core.util.d.b(baseFragmentActivity, t.pic_emotion01);
        }
        if (this.a && this.f != null) {
            this.e.setBackgroundDrawable(new BitmapDrawable(TbadkApplication.m252getInst().getContext().getResources(), this.f));
        }
    }
}
