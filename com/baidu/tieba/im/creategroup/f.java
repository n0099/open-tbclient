package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class f implements v {
    CreateGroupStepActivity a;
    View b;
    HeadImageView c;
    ImageView d;
    Button e;
    private com.baidu.adp.widget.ImageView.e f = null;
    private h g = null;

    public f(CreateGroupStepActivity createGroupStepActivity) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.d = (ImageView) this.b.findViewById(R.id.step3_img_bg);
        this.c = (HeadImageView) this.b.findViewById(R.id.step3_img_scr);
        this.e = (Button) this.b.findViewById(R.id.create_group3);
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int b() {
        return 3;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int c() {
        return R.string.group_create_step_tip;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int d() {
        return R.string.group_create_step3;
    }

    public void e() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.f = null;
        this.g = new h(this);
        this.g.execute(new Object[0]);
    }

    public ImageView f() {
        return this.d;
    }

    public Button g() {
        return this.e;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public View a() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public void j() {
        this.d.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public void k() {
        this.a.getLayoutMode().a(TiebaApplication.h().an() == 1);
        this.a.getLayoutMode().a(this.b);
        this.c.e();
    }
}
