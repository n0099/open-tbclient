package com.baidu.tieba.guide;

import android.app.Dialog;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.af;
import com.baidu.tieba.model.bc;
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    private NewUserGuideActivity a;
    private InterestFrsData.Tag b;
    private a c;
    private af d;
    private bc e;

    public x(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, t tVar) {
        this.a = newUserGuideActivity;
        this.b = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.c = new v(this.a, com.baidu.tieba.v.NewUserDialog);
        } else if (btype == 2) {
            this.c = new e(this.a, com.baidu.tieba.v.NewUserDialog);
        } else if (btype == 3) {
            this.c = new l(this.a, com.baidu.tieba.v.NewUserDialog);
        }
        this.c.a(newUserGuideActivity.g());
        this.d = new af();
        this.d.setLoadDataCallBack(new y(this));
        this.e = new bc();
        this.e.a(new z(this));
        this.c.a(this);
        this.c.a(this.b);
        ((Dialog) this.c).setOnDismissListener(new aa(this, tVar));
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
        if (view.getId() == com.baidu.tieba.r.box_close_layout) {
            this.c.hide();
        } else if ((view.getId() == com.baidu.tieba.r.ll_like || view.getId() == com.baidu.tieba.r.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
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
