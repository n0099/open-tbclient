package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.j0.t.d.f.c.f;
import d.a.j0.x.b;
/* loaded from: classes4.dex */
public class ConcernTabLiveItemView extends b<f> {
    public ViewHolder m;
    public TbPageContext n;
    public int o;

    /* loaded from: classes4.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ConcernTabLiveItemView f14658a;

        /* renamed from: b  reason: collision with root package name */
        public View f14659b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f14660c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14661d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14662e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14663f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14664g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14665h;

        /* renamed from: i  reason: collision with root package name */
        public View f14666i;
        public View.OnClickListener j;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.follow_btn && (view.getTag() instanceof UserData)) {
                    if (!l.D()) {
                        ConcernTabLiveItemView.this.n.showToast(R.string.neterror);
                        return;
                    }
                    UserData userData = (UserData) view.getTag();
                    AlaAttentionManager.getInstance().updateAttention(String.valueOf(userData.getUserId()), new AlaAttentionData(userData.getPortrait(), String.valueOf(userData.getUserId()), "1", true, null));
                    ConcernTabLiveItemView.this.m.f14664g.setVisibility(8);
                    ConcernTabLiveItemView.this.m.f14665h.setVisibility(0);
                    TiebaStatic.log(new StatisticItem("c12897"));
                }
            }
        }

        public ViewHolder(ConcernTabLiveItemView concernTabLiveItemView) {
            super(concernTabLiveItemView.l());
            this.j = new a();
            this.f14658a = concernTabLiveItemView;
            View l = concernTabLiveItemView.l();
            this.f14659b = l;
            TbImageView tbImageView = (TbImageView) l.findViewById(R.id.protrait);
            this.f14660c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.f14660c.setIsRound(true);
            this.f14660c.setAutoChangeStyle(false);
            this.f14660c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14661d = (TextView) this.f14659b.findViewById(R.id.live_title);
            this.f14662e = (TextView) this.f14659b.findViewById(R.id.living_tag);
            this.f14666i = this.f14659b.findViewById(R.id.devider_line);
            Drawable drawable = SkinManager.getDrawable(ConcernTabLiveItemView.this.f62438g.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.f62438g.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.f62438g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f14662e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f14663f = (TextView) this.f14659b.findViewById(R.id.user_name);
            this.f14664g = (TextView) this.f14659b.findViewById(R.id.follow_btn);
            this.f14665h = (TextView) this.f14659b.findViewById(R.id.followed_btn);
            this.f14664g.setOnClickListener(this.j);
        }
    }

    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = 28;
        this.n = tbPageContext;
        this.m = new ViewHolder(this);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.special_bar_concern_live_item;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.m.f14661d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m.f14663f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f14665h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f14664g, R.color.common_color_10140);
        SkinManager.setViewTextColor(this.m.f14662e, R.color.CAM_X0109);
        SkinManager.getDrawable(this.f62438g.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f62438g.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.f62438g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.m.f14662e.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f62438g.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setBackgroundColor(this.m.f14666i, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: u */
    public void m(f fVar) {
        UserData userData = fVar.f60714e;
        if (userData != null) {
            if (!StringUtils.isNull(userData.getPortrait())) {
                this.m.f14660c.V(fVar.f60714e.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.f60714e.getName_show())) {
                this.m.f14661d.setText(fVar.f60714e.getName_show());
            }
            if (fVar.f60716g) {
                if (fVar.f60714e.hadConcerned()) {
                    this.m.f14664g.setVisibility(8);
                    this.m.f14665h.setVisibility(0);
                } else {
                    this.m.f14664g.setVisibility(0);
                    this.m.f14665h.setVisibility(8);
                }
            } else {
                this.m.f14664g.setVisibility(8);
                this.m.f14665h.setVisibility(8);
            }
            this.m.f14664g.setTag(fVar.f60714e);
        }
        AlaInfoData alaInfoData = fVar.f60715f;
        if (alaInfoData != null) {
            this.m.f14659b.setTag(alaInfoData);
            if (!StringUtils.isNull(fVar.f60715f.description)) {
                String str = fVar.f60715f.description;
                int i2 = this.o;
                if (fVar.f60716g) {
                    i2 -= 9;
                }
                if (k.byteLength(str) > i2) {
                    str = StringHelper.cutChineseAndEnglishWithSuffix(str, i2, StringHelper.STRING_MORE);
                }
                this.m.f14663f.setText(str);
            }
        }
        if (fVar.f60716g) {
            TiebaStatic.log(new StatisticItem("c12895"));
        } else {
            TiebaStatic.log(new StatisticItem("c12893"));
        }
        this.m.f14664g.setTag(fVar.f60714e);
        n(k(), TbadkCoreApplication.getInst().getSkinType());
    }
}
