package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.j0.r.q.a2;
/* loaded from: classes4.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f13779e;

    /* renamed from: f  reason: collision with root package name */
    public View f13780f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f13781g;

    /* renamed from: h  reason: collision with root package name */
    public View f13782h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f13783i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public NoActiveStopAlaPlayAnimationView o;
    public ProgressBar p;
    public FrameLayout q;
    public Animation r;
    public boolean s;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.s = false;
        a(context);
    }

    public final void a(Context context) {
        this.f13779e = context;
        this.r = AnimationUtils.loadAnimation(context, R.anim.video_cover_fade_out);
        View inflate = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.f13780f = inflate;
        this.q = (FrameLayout) inflate.findViewById(R.id.fade_out_view_root);
        TbImageView tbImageView = (TbImageView) this.f13780f.findViewById(R.id.live_cover);
        this.f13781g = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.f13781g.setAutoChangeStyle(false);
        View findViewById = this.f13780f.findViewById(R.id.head_root_view);
        this.f13782h = findViewById;
        findViewById.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.f13783i = (HeadImageView) this.f13780f.findViewById(R.id.hostheader_image);
        this.j = (TextView) this.f13780f.findViewById(R.id.hostheader_name);
        this.k = (TextView) this.f13780f.findViewById(R.id.hostheader_id);
        this.f13783i.setIsRound(true);
        this.f13783i.setAutoChangeStyle(false);
        this.l = (TextView) this.f13780f.findViewById(R.id.tvSquareTitle);
        this.m = (TextView) this.f13780f.findViewById(R.id.tvLiveCount);
        this.n = (ImageView) this.f13780f.findViewById(R.id.image_video_play);
        NoActiveStopAlaPlayAnimationView noActiveStopAlaPlayAnimationView = (NoActiveStopAlaPlayAnimationView) this.f13780f.findViewById(R.id.ala_play);
        this.o = noActiveStopAlaPlayAnimationView;
        noActiveStopAlaPlayAnimationView.setFromSpecialForum(this.s);
        SkinManager.setImageResource(this.n, R.drawable.btn_icon_play_live_on_n);
        this.p = (ProgressBar) this.f13780f.findViewById(R.id.auto_video_loading_progress);
        b();
    }

    public void b() {
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
    }

    public void c() {
        if (!this.s) {
            this.o.c();
        }
        this.q.clearAnimation();
    }

    public void d() {
        if (this.s) {
            this.n.setVisibility(8);
            this.p.setVisibility(8);
            this.o.setVisibility(8);
        }
        this.q.startAnimation(this.r);
    }

    public void e() {
        if (this.s) {
            return;
        }
        this.o.b();
    }

    public void f() {
        this.q.clearAnimation();
    }

    public void setData(a2 a2Var) {
        if (a2Var == null || a2Var.q1() == null || a2Var.T() == null) {
            return;
        }
        AlaInfoData q1 = a2Var.q1();
        this.f13781g.V(q1.cover, 10, false);
        AlaUserInfoData alaUserInfoData = q1.user_info;
        if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
            this.f13782h.setVisibility(0);
            this.f13783i.V(alaUserInfoData.portrait, 10, false);
            this.j.setText(a2Var.T().getName_show());
            this.k.setText(String.format(this.f13779e.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
        } else {
            this.f13782h.setVisibility(8);
        }
        this.l.setText(a2Var.y1());
        this.m.setText(this.f13779e.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(q1.audience_count)));
        if (this.s) {
            return;
        }
        this.o.b();
    }

    public void setFromSpecialForum(boolean z) {
        this.s = z;
        this.n.setVisibility(8);
        this.p.setVisibility(8);
        this.o.setVisibility(8);
        this.o.setFromSpecialForum(this.s);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = false;
        a(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = false;
        a(context);
    }
}
