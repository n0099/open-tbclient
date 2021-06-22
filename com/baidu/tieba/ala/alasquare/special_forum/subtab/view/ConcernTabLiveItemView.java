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
import d.a.o0.v.d.f.c.f;
import d.a.o0.z.b;
/* loaded from: classes4.dex */
public class ConcernTabLiveItemView extends b<f> {
    public ViewHolder m;
    public TbPageContext n;
    public int o;

    /* loaded from: classes4.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ConcernTabLiveItemView f14015a;

        /* renamed from: b  reason: collision with root package name */
        public View f14016b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f14017c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14018d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14019e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14020f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14021g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14022h;

        /* renamed from: i  reason: collision with root package name */
        public View f14023i;
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
                    ConcernTabLiveItemView.this.m.f14021g.setVisibility(8);
                    ConcernTabLiveItemView.this.m.f14022h.setVisibility(0);
                    TiebaStatic.log(new StatisticItem("c12897"));
                }
            }
        }

        public ViewHolder(ConcernTabLiveItemView concernTabLiveItemView) {
            super(concernTabLiveItemView.m());
            this.j = new a();
            this.f14015a = concernTabLiveItemView;
            View m = concernTabLiveItemView.m();
            this.f14016b = m;
            TbImageView tbImageView = (TbImageView) m.findViewById(R.id.protrait);
            this.f14017c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.f14017c.setIsRound(true);
            this.f14017c.setAutoChangeStyle(false);
            this.f14017c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14018d = (TextView) this.f14016b.findViewById(R.id.live_title);
            this.f14019e = (TextView) this.f14016b.findViewById(R.id.living_tag);
            this.f14023i = this.f14016b.findViewById(R.id.devider_line);
            Drawable drawable = SkinManager.getDrawable(ConcernTabLiveItemView.this.f67285g.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.f67285g.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.f67285g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f14019e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f14020f = (TextView) this.f14016b.findViewById(R.id.user_name);
            this.f14021g = (TextView) this.f14016b.findViewById(R.id.follow_btn);
            this.f14022h = (TextView) this.f14016b.findViewById(R.id.followed_btn);
            this.f14021g.setOnClickListener(this.j);
        }
    }

    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = 28;
        this.n = tbPageContext;
        this.m = new ViewHolder(this);
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.special_bar_concern_live_item;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.m.f14018d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m.f14020f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f14022h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f14021g, R.color.common_color_10140);
        SkinManager.setViewTextColor(this.m.f14019e, R.color.CAM_X0109);
        SkinManager.getDrawable(this.f67285g.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f67285g.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.f67285g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.m.f14019e.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f67285g.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setBackgroundColor(this.m.f14023i, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: v */
    public void n(f fVar) {
        UserData userData = fVar.f65565e;
        if (userData != null) {
            if (!StringUtils.isNull(userData.getPortrait())) {
                this.m.f14017c.U(fVar.f65565e.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.f65565e.getName_show())) {
                this.m.f14018d.setText(fVar.f65565e.getName_show());
            }
            if (fVar.f65567g) {
                if (fVar.f65565e.hadConcerned()) {
                    this.m.f14021g.setVisibility(8);
                    this.m.f14022h.setVisibility(0);
                } else {
                    this.m.f14021g.setVisibility(0);
                    this.m.f14022h.setVisibility(8);
                }
            } else {
                this.m.f14021g.setVisibility(8);
                this.m.f14022h.setVisibility(8);
            }
            this.m.f14021g.setTag(fVar.f65565e);
        }
        AlaInfoData alaInfoData = fVar.f65566f;
        if (alaInfoData != null) {
            this.m.f14016b.setTag(alaInfoData);
            if (!StringUtils.isNull(fVar.f65566f.description)) {
                String str = fVar.f65566f.description;
                int i2 = this.o;
                if (fVar.f65567g) {
                    i2 -= 9;
                }
                if (k.byteLength(str) > i2) {
                    str = StringHelper.cutChineseAndEnglishWithSuffix(str, i2, StringHelper.STRING_MORE);
                }
                this.m.f14020f.setText(str);
            }
        }
        if (fVar.f65567g) {
            TiebaStatic.log(new StatisticItem("c12895"));
        } else {
            StatisticItem statisticItem = new StatisticItem("c12893");
            AlaInfoData alaInfoData2 = fVar.f65566f;
            if (alaInfoData2 != null && alaInfoData2.isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(statisticItem, fVar.f65566f.mYyExtData);
            }
            TiebaStatic.log(statisticItem);
        }
        this.m.f14021g.setTag(fVar.f65565e);
        o(k(), TbadkCoreApplication.getInst().getSkinType());
    }
}
