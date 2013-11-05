package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d implements q {

    /* renamed from: a */
    CreateGroupStepActivity f1493a;
    View b;
    HeadImageView c;
    ImageView d;
    Button e;
    private com.baidu.adp.widget.ImageView.e f = null;
    private f g = null;

    public d(CreateGroupStepActivity createGroupStepActivity) {
        this.f1493a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f1493a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.d = (ImageView) this.b.findViewById(R.id.step3_img_bg);
        this.c = (HeadImageView) this.b.findViewById(R.id.step3_img_scr);
        this.e = (Button) this.b.findViewById(R.id.create_group3);
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public int b() {
        return 3;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public int a() {
        return R.string.group_create_step_done_tip;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public int c() {
        return R.string.group_create_step3;
    }

    public void d() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.f = null;
        this.g = new f(this);
        this.g.execute(new Object[0]);
    }

    public ImageView e() {
        return this.d;
    }

    public Button h() {
        return this.e;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public View f() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public void g() {
        this.d.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public void i() {
        this.f1493a.m().a(TiebaApplication.g().as() == 1);
        this.f1493a.m().a(this.b);
        this.c.b();
    }
}
