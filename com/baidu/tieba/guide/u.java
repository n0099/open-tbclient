package com.baidu.tieba.guide;

import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.model.bx;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    private NewUserGuideActivity a;
    private InterestFrsData.Tag b;
    private a c;
    private ar d;
    private bx e;
    private boolean f = false;

    public u(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag) {
        this.a = newUserGuideActivity;
        this.b = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.c = new s(this.a, R.style.NewUserDialog);
        } else if (btype == 2) {
            this.c = new d(this.a, R.style.NewUserDialog);
        } else if (btype == 3) {
            this.c = new k(this.a, R.style.NewUserDialog);
        }
        this.c.a(newUserGuideActivity.g());
        this.d = new ar();
        this.d.setLoadDataCallBack(new v(this));
        this.e = new bx();
        this.e.a(new w(this));
        this.c.a(this);
        this.c.a(this.b);
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
        if (view.getId() == R.id.box_close_layout) {
            this.c.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.e.a(card.getFname(), card.getFid());
            } else {
                this.d.a(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void a() {
        if (!this.f) {
            this.f = true;
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(200L);
            scaleAnimation.setAnimationListener(new x(this));
            this.c.a().setAnimation(scaleAnimation);
            this.c.show();
        }
    }
}
