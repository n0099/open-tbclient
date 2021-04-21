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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.j0.t.d.f.c.f;
import d.b.j0.x.b;
/* loaded from: classes4.dex */
public class ConcernTabLiveItemView extends b<f> {
    public ViewHolder m;
    public TbPageContext n;
    public int o;

    /* loaded from: classes4.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ConcernTabLiveItemView f14585a;

        /* renamed from: b  reason: collision with root package name */
        public View f14586b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f14587c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14588d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14589e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14590f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14591g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14592h;
        public View i;
        public View.OnClickListener j;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.follow_btn && (view.getTag() instanceof UserData)) {
                    if (!l.C()) {
                        ConcernTabLiveItemView.this.n.showToast(R.string.neterror);
                        return;
                    }
                    UserData userData = (UserData) view.getTag();
                    AlaAttentionManager.getInstance().updateAttention(String.valueOf(userData.getUserId()), new AlaAttentionData(userData.getPortrait(), String.valueOf(userData.getUserId()), "1", true, null));
                    ConcernTabLiveItemView.this.m.f14591g.setVisibility(8);
                    ConcernTabLiveItemView.this.m.f14592h.setVisibility(0);
                    TiebaStatic.log(new StatisticItem("c12897"));
                }
            }
        }

        public ViewHolder(ConcernTabLiveItemView concernTabLiveItemView) {
            super(concernTabLiveItemView.m());
            this.j = new a();
            this.f14585a = concernTabLiveItemView;
            View m = concernTabLiveItemView.m();
            this.f14586b = m;
            TbImageView tbImageView = (TbImageView) m.findViewById(R.id.protrait);
            this.f14587c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.f14587c.setIsRound(true);
            this.f14587c.setAutoChangeStyle(false);
            this.f14587c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14588d = (TextView) this.f14586b.findViewById(R.id.live_title);
            this.f14589e = (TextView) this.f14586b.findViewById(R.id.living_tag);
            this.i = this.f14586b.findViewById(R.id.devider_line);
            Drawable drawable = SkinManager.getDrawable(ConcernTabLiveItemView.this.f64178g.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.f64178g.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.f64178g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f14589e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f14590f = (TextView) this.f14586b.findViewById(R.id.user_name);
            this.f14591g = (TextView) this.f14586b.findViewById(R.id.follow_btn);
            this.f14592h = (TextView) this.f14586b.findViewById(R.id.followed_btn);
            this.f14591g.setOnClickListener(this.j);
        }
    }

    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = 28;
        this.n = tbPageContext;
        this.m = new ViewHolder(this);
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.special_bar_concern_live_item;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setViewTextColor(this.m.f14588d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m.f14590f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f14592h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f14591g, R.color.common_color_10140);
        SkinManager.setViewTextColor(this.m.f14589e, R.color.CAM_X0109);
        SkinManager.getDrawable(this.f64178g.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f64178g.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.f64178g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.m.f14589e.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f64178g.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setBackgroundColor(this.m.i, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: w */
    public void n(f fVar) {
        UserData userData = fVar.f62526e;
        if (userData != null) {
            if (!StringUtils.isNull(userData.getPortrait())) {
                this.m.f14587c.W(fVar.f62526e.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.f62526e.getName_show())) {
                this.m.f14588d.setText(fVar.f62526e.getName_show());
            }
            if (fVar.f62528g) {
                if (fVar.f62526e.hadConcerned()) {
                    this.m.f14591g.setVisibility(8);
                    this.m.f14592h.setVisibility(0);
                } else {
                    this.m.f14591g.setVisibility(0);
                    this.m.f14592h.setVisibility(8);
                }
            } else {
                this.m.f14591g.setVisibility(8);
                this.m.f14592h.setVisibility(8);
            }
            this.m.f14591g.setTag(fVar.f62526e);
        }
        AlaInfoData alaInfoData = fVar.f62527f;
        if (alaInfoData != null) {
            this.m.f14586b.setTag(alaInfoData);
            if (!StringUtils.isNull(fVar.f62527f.description)) {
                String str = fVar.f62527f.description;
                int i = this.o;
                if (fVar.f62528g) {
                    i -= 9;
                }
                if (k.byteLength(str) > i) {
                    str = StringHelper.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
                }
                this.m.f14590f.setText(str);
            }
        }
        if (fVar.f62528g) {
            TiebaStatic.log(new StatisticItem("c12895"));
        } else {
            TiebaStatic.log(new StatisticItem("c12893"));
        }
        this.m.f14591g.setTag(fVar.f62526e);
        o(l(), TbadkCoreApplication.getInst().getSkinType());
    }
}
