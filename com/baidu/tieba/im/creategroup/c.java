package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class c implements q {

    /* renamed from: a  reason: collision with root package name */
    CreateGroupStepActivity f1492a;
    View b;
    ImageView c;
    EditText d;

    public EditText d() {
        return this.d;
    }

    public int e() {
        return com.baidu.tieba.im.d.f.a(this.d);
    }

    public c(CreateGroupStepActivity createGroupStepActivity) {
        this.f1492a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f1492a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.d = (EditText) this.b.findViewById(R.id.step1_group_name);
        this.c = (ImageView) this.b.findViewById(R.id.step1_img_bg);
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public int a() {
        return R.string.group_create_step_tip;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public int c() {
        return R.string.group_create_step1;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public int b() {
        return 1;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public View f() {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1492a, "create_g_name", "pv", 1);
        }
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public void g() {
        this.c.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public void i() {
        this.f1492a.m().a(TiebaApplication.g().as() == 1);
        this.f1492a.m().a(this.b);
    }
}
