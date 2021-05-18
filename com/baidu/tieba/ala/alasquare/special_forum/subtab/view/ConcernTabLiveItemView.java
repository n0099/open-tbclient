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
import d.a.k0.t.d.f.c.f;
import d.a.k0.x.b;
/* loaded from: classes4.dex */
public class ConcernTabLiveItemView extends b<f> {
    public ViewHolder m;
    public TbPageContext n;
    public int o;

    /* loaded from: classes4.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ConcernTabLiveItemView f13973a;

        /* renamed from: b  reason: collision with root package name */
        public View f13974b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f13975c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13976d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f13977e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f13978f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f13979g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f13980h;

        /* renamed from: i  reason: collision with root package name */
        public View f13981i;
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
                    ConcernTabLiveItemView.this.m.f13979g.setVisibility(8);
                    ConcernTabLiveItemView.this.m.f13980h.setVisibility(0);
                    TiebaStatic.log(new StatisticItem("c12897"));
                }
            }
        }

        public ViewHolder(ConcernTabLiveItemView concernTabLiveItemView) {
            super(concernTabLiveItemView.l());
            this.j = new a();
            this.f13973a = concernTabLiveItemView;
            View l = concernTabLiveItemView.l();
            this.f13974b = l;
            TbImageView tbImageView = (TbImageView) l.findViewById(R.id.protrait);
            this.f13975c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.f13975c.setIsRound(true);
            this.f13975c.setAutoChangeStyle(false);
            this.f13975c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f13976d = (TextView) this.f13974b.findViewById(R.id.live_title);
            this.f13977e = (TextView) this.f13974b.findViewById(R.id.living_tag);
            this.f13981i = this.f13974b.findViewById(R.id.devider_line);
            Drawable drawable = SkinManager.getDrawable(ConcernTabLiveItemView.this.f63162g.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.f63162g.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.f63162g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f13977e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f13978f = (TextView) this.f13974b.findViewById(R.id.user_name);
            this.f13979g = (TextView) this.f13974b.findViewById(R.id.follow_btn);
            this.f13980h = (TextView) this.f13974b.findViewById(R.id.followed_btn);
            this.f13979g.setOnClickListener(this.j);
        }
    }

    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = 28;
        this.n = tbPageContext;
        this.m = new ViewHolder(this);
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.special_bar_concern_live_item;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.m.f13976d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m.f13978f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f13980h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f13979g, R.color.common_color_10140);
        SkinManager.setViewTextColor(this.m.f13977e, R.color.CAM_X0109);
        SkinManager.getDrawable(this.f63162g.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f63162g.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.f63162g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.m.f13977e.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f63162g.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setBackgroundColor(this.m.f13981i, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: u */
    public void m(f fVar) {
        UserData userData = fVar.f61438e;
        if (userData != null) {
            if (!StringUtils.isNull(userData.getPortrait())) {
                this.m.f13975c.V(fVar.f61438e.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.f61438e.getName_show())) {
                this.m.f13976d.setText(fVar.f61438e.getName_show());
            }
            if (fVar.f61440g) {
                if (fVar.f61438e.hadConcerned()) {
                    this.m.f13979g.setVisibility(8);
                    this.m.f13980h.setVisibility(0);
                } else {
                    this.m.f13979g.setVisibility(0);
                    this.m.f13980h.setVisibility(8);
                }
            } else {
                this.m.f13979g.setVisibility(8);
                this.m.f13980h.setVisibility(8);
            }
            this.m.f13979g.setTag(fVar.f61438e);
        }
        AlaInfoData alaInfoData = fVar.f61439f;
        if (alaInfoData != null) {
            this.m.f13974b.setTag(alaInfoData);
            if (!StringUtils.isNull(fVar.f61439f.description)) {
                String str = fVar.f61439f.description;
                int i2 = this.o;
                if (fVar.f61440g) {
                    i2 -= 9;
                }
                if (k.byteLength(str) > i2) {
                    str = StringHelper.cutChineseAndEnglishWithSuffix(str, i2, StringHelper.STRING_MORE);
                }
                this.m.f13978f.setText(str);
            }
        }
        if (fVar.f61440g) {
            TiebaStatic.log(new StatisticItem("c12895"));
        } else {
            TiebaStatic.log(new StatisticItem("c12893"));
        }
        this.m.f13979g.setTag(fVar.f61438e);
        n(k(), TbadkCoreApplication.getInst().getSkinType());
    }
}
