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
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.v.d.f.c.f;
import d.a.n0.z.b;
/* loaded from: classes4.dex */
public class ConcernTabLiveItemView extends b<f> {
    public ViewHolder m;
    public TbPageContext n;
    public int o;

    /* loaded from: classes4.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ConcernTabLiveItemView f13933a;

        /* renamed from: b  reason: collision with root package name */
        public View f13934b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f13935c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13936d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f13937e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f13938f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f13939g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f13940h;

        /* renamed from: i  reason: collision with root package name */
        public View f13941i;
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
                    ConcernTabLiveItemView.this.m.f13939g.setVisibility(8);
                    ConcernTabLiveItemView.this.m.f13940h.setVisibility(0);
                    TiebaStatic.log(new StatisticItem("c12897"));
                }
            }
        }

        public ViewHolder(ConcernTabLiveItemView concernTabLiveItemView) {
            super(concernTabLiveItemView.m());
            this.j = new a();
            this.f13933a = concernTabLiveItemView;
            View m = concernTabLiveItemView.m();
            this.f13934b = m;
            TbImageView tbImageView = (TbImageView) m.findViewById(R.id.protrait);
            this.f13935c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.f13935c.setIsRound(true);
            this.f13935c.setAutoChangeStyle(false);
            this.f13935c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f13936d = (TextView) this.f13934b.findViewById(R.id.live_title);
            this.f13937e = (TextView) this.f13934b.findViewById(R.id.living_tag);
            this.f13941i = this.f13934b.findViewById(R.id.devider_line);
            Drawable drawable = SkinManager.getDrawable(ConcernTabLiveItemView.this.f67160g.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.f67160g.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.f67160g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f13937e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f13938f = (TextView) this.f13934b.findViewById(R.id.user_name);
            this.f13939g = (TextView) this.f13934b.findViewById(R.id.follow_btn);
            this.f13940h = (TextView) this.f13934b.findViewById(R.id.followed_btn);
            this.f13939g.setOnClickListener(this.j);
        }
    }

    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = 28;
        this.n = tbPageContext;
        this.m = new ViewHolder(this);
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.special_bar_concern_live_item;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.m.f13936d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m.f13938f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f13940h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f13939g, R.color.common_color_10140);
        SkinManager.setViewTextColor(this.m.f13937e, R.color.CAM_X0109);
        SkinManager.getDrawable(this.f67160g.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f67160g.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.f67160g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.m.f13937e.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f67160g.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setBackgroundColor(this.m.f13941i, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: v */
    public void n(f fVar) {
        UserData userData = fVar.f65440e;
        if (userData != null) {
            if (!StringUtils.isNull(userData.getPortrait())) {
                this.m.f13935c.U(fVar.f65440e.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.f65440e.getName_show())) {
                this.m.f13936d.setText(fVar.f65440e.getName_show());
            }
            if (fVar.f65442g) {
                if (fVar.f65440e.hadConcerned()) {
                    this.m.f13939g.setVisibility(8);
                    this.m.f13940h.setVisibility(0);
                } else {
                    this.m.f13939g.setVisibility(0);
                    this.m.f13940h.setVisibility(8);
                }
            } else {
                this.m.f13939g.setVisibility(8);
                this.m.f13940h.setVisibility(8);
            }
            this.m.f13939g.setTag(fVar.f65440e);
        }
        AlaInfoData alaInfoData = fVar.f65441f;
        if (alaInfoData != null) {
            this.m.f13934b.setTag(alaInfoData);
            if (!StringUtils.isNull(fVar.f65441f.description)) {
                String str = fVar.f65441f.description;
                int i2 = this.o;
                if (fVar.f65442g) {
                    i2 -= 9;
                }
                if (k.byteLength(str) > i2) {
                    str = StringHelper.cutChineseAndEnglishWithSuffix(str, i2, StringHelper.STRING_MORE);
                }
                this.m.f13938f.setText(str);
            }
        }
        if (fVar.f65442g) {
            TiebaStatic.log(new StatisticItem("c12895"));
        } else {
            StatisticItem statisticItem = new StatisticItem("c12893");
            AlaInfoData alaInfoData2 = fVar.f65441f;
            if (alaInfoData2 != null && alaInfoData2.isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(statisticItem, fVar.f65441f.mYyExtData);
            }
            TiebaStatic.log(statisticItem);
        }
        this.m.f13939g.setTag(fVar.f65440e);
        o(k(), TbadkCoreApplication.getInst().getSkinType());
    }
}
