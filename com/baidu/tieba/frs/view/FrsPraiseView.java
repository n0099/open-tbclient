package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tieba.view.UserPhotoLayout;
/* loaded from: classes.dex */
public class FrsPraiseView extends RelativeLayout {
    private Context a;
    private View b;
    private TextView c;
    private ImageView d;
    private UserPhotoLayout e;
    private PraiseData f;
    private com.baidu.tbadk.core.util.b g;
    private LinearLayout h;
    private String i;
    private ImageView j;

    public FrsPraiseView(Context context) {
        this(context, null, 0);
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        this.b = View.inflate(this.a, com.baidu.tieba.a.i.frs_item_praise, this);
        this.h = (LinearLayout) this.b.findViewById(com.baidu.tieba.a.h.frs_go_praise_list_btn);
        this.c = (TextView) this.b.findViewById(com.baidu.tieba.a.h.frs_go_praise_list_num);
        this.d = (ImageView) this.b.findViewById(com.baidu.tieba.a.h.frs_go_praise_list_love);
        this.e = (UserPhotoLayout) this.b.findViewById(com.baidu.tieba.a.h.frs_go_praise_list_photo);
        this.j = (ImageView) this.b.findViewById(com.baidu.tieba.a.h.frs_go_praise_list_im);
        this.h.setOnClickListener(new k(this));
        this.e.setOnChildClickListener(new l(this));
    }

    public void setImageLoad(com.baidu.tbadk.core.util.b bVar) {
        this.g = bVar;
        this.e.setImageLoad(this.g);
    }

    public final void a(PraiseData praiseData, String str, boolean z) {
        if (praiseData != null) {
            this.i = str;
            this.f = praiseData;
            if (this.f.getNum() > 0) {
                this.c.setText(new StringBuilder(String.valueOf(this.f.getNum())).toString());
            }
            this.e.a(this.f.getUser(), z);
        }
    }

    public final void a(int i) {
        if (i == 1) {
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_praise_view_praise_num_1));
            this.d.setImageResource(com.baidu.tieba.a.g.icon_hand_disable_1);
            this.j.setImageResource(com.baidu.tieba.a.g.icon_frs_ba_arrows_1);
            return;
        }
        this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_praise_view_praise_num));
        this.d.setImageResource(com.baidu.tieba.a.g.icon_hand_disable);
        this.j.setImageResource(com.baidu.tieba.a.g.icon_frs_ba_arrows);
    }
}
