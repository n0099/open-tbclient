package com.baidu.tieba.guide;

import android.app.Dialog;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.ae;
import com.baidu.tieba.model.be;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    private NewUserGuideActivity a;
    private InterestFrsData.Tag b;
    private a c;
    private ae d;
    private be e;

    public u(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, q qVar) {
        this.a = newUserGuideActivity;
        this.b = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.c = new s(this.a, z.NewUserDialog);
        } else if (btype == 2) {
            this.c = new e(this.a, z.NewUserDialog);
        } else if (btype == 3) {
            this.c = new i(this.a, z.NewUserDialog);
        }
        this.d = new ae();
        this.d.setLoadDataCallBack(new v(this));
        this.e = new be();
        this.e.a(new w(this));
        this.c.a(this);
        this.c.a(this.b);
        ((Dialog) this.c).setOnDismissListener(new x(this, qVar));
    }

    public void a(int i, boolean z) {
        for (int i2 = 0; i2 < this.b.getCard_list().size(); i2++) {
            if (this.b.getCard_list().get(i2).getFid() == i) {
                this.b.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.box_close_layout) {
            this.c.hide();
        } else if ((view.getId() == com.baidu.tieba.v.ll_like || view.getId() == com.baidu.tieba.v.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.e.a(card.getFname(), card.getFid());
            } else {
                this.d.a(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void a() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
        scaleAnimation.setDuration(350L);
        this.c.a().setAnimation(scaleAnimation);
        this.c.show();
    }
}
