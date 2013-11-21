package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a implements q {

    /* renamed from: a  reason: collision with root package name */
    CreateGroupStepActivity f1572a;
    View b;
    ImageView c;
    EditText d;
    TextView e;

    public a(CreateGroupStepActivity createGroupStepActivity) {
        this.f1572a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f1572a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.c = (ImageView) this.b.findViewById(R.id.step2_img_bg);
        this.d = (EditText) this.b.findViewById(R.id.step2_group_info);
        this.e = (TextView) this.b.findViewById(R.id.step2_group_info_count);
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public int a() {
        return R.string.group_create_step_tip;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public int b() {
        return 2;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public int c() {
        return R.string.group_create_step2;
    }

    public EditText d() {
        return this.d;
    }

    public TextView e() {
        return this.e;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public View f() {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1572a, "create_g_intro", "pv", 1);
        }
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public void g() {
        this.c.setBackgroundDrawable(null);
    }

    public void h() {
        this.f1572a.getLayoutMode().a(TiebaApplication.g().ap() == 1);
        this.f1572a.getLayoutMode().a(this.e);
    }

    @Override // com.baidu.tieba.im.creategroup.q
    public void i() {
        this.f1572a.getLayoutMode().a(TiebaApplication.g().ap() == 1);
        this.f1572a.getLayoutMode().a(this.b);
    }
}
