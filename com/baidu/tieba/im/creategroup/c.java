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
public class c implements v {

    /* renamed from: a  reason: collision with root package name */
    CreateGroupStepActivity f1620a;
    View b;
    ImageView c;
    EditText d;
    TextView e;

    public c(CreateGroupStepActivity createGroupStepActivity) {
        this.f1620a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f1620a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.c = (ImageView) this.b.findViewById(R.id.step2_img_bg);
        this.d = (EditText) this.b.findViewById(R.id.step2_group_info);
        this.e = (TextView) this.b.findViewById(R.id.step2_group_info_count);
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int c() {
        return R.string.group_create_step_tip;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int b() {
        return 2;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int d() {
        return R.string.group_create_step2;
    }

    public EditText e() {
        return this.d;
    }

    public TextView f() {
        return this.e;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public View a() {
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.f1620a, "create_g_intro", "pv", 1);
        }
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public void j() {
        this.c.setBackgroundDrawable(null);
    }

    public void g() {
        this.f1620a.getLayoutMode().a(TiebaApplication.h().an() == 1);
        this.f1620a.getLayoutMode().a(this.e);
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public void k() {
        this.f1620a.getLayoutMode().a(TiebaApplication.h().an() == 1);
        this.f1620a.getLayoutMode().a(this.b);
        if (TiebaApplication.h().an() == 1) {
            this.d.setHintTextColor(this.f1620a.getResources().getColor(R.color.create_group_input_hintcolor_1));
        } else {
            this.d.setHintTextColor(this.f1620a.getResources().getColor(R.color.create_group_input_hintcolor));
        }
    }
}
