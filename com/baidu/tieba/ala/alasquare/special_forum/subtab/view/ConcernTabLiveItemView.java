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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.i0.t.d.f.c.f;
import d.b.i0.x.b;
/* loaded from: classes4.dex */
public class ConcernTabLiveItemView extends b<f> {
    public ViewHolder m;
    public TbPageContext n;
    public int o;

    /* loaded from: classes4.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ConcernTabLiveItemView f14914a;

        /* renamed from: b  reason: collision with root package name */
        public View f14915b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f14916c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14917d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14918e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14919f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14920g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14921h;
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
                    ConcernTabLiveItemView.this.m.f14920g.setVisibility(8);
                    ConcernTabLiveItemView.this.m.f14921h.setVisibility(0);
                    TiebaStatic.log(new StatisticItem("c12897"));
                }
            }
        }

        public ViewHolder(ConcernTabLiveItemView concernTabLiveItemView) {
            super(concernTabLiveItemView.m());
            this.j = new a();
            this.f14914a = concernTabLiveItemView;
            View m = concernTabLiveItemView.m();
            this.f14915b = m;
            TbImageView tbImageView = (TbImageView) m.findViewById(R.id.protrait);
            this.f14916c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.f14916c.setIsRound(true);
            this.f14916c.setAutoChangeStyle(false);
            this.f14916c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14917d = (TextView) this.f14915b.findViewById(R.id.live_title);
            this.f14918e = (TextView) this.f14915b.findViewById(R.id.living_tag);
            this.i = this.f14915b.findViewById(R.id.devider_line);
            Drawable drawable = SkinManager.getDrawable(ConcernTabLiveItemView.this.f62182g.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.f62182g.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.f62182g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f14918e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f14919f = (TextView) this.f14915b.findViewById(R.id.user_name);
            this.f14920g = (TextView) this.f14915b.findViewById(R.id.follow_btn);
            this.f14921h = (TextView) this.f14915b.findViewById(R.id.followed_btn);
            this.f14920g.setOnClickListener(this.j);
        }
    }

    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = 28;
        this.n = tbPageContext;
        this.m = new ViewHolder(this);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.special_bar_concern_live_item;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setViewTextColor(this.m.f14917d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m.f14919f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f14921h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f14920g, R.color.common_color_10140);
        SkinManager.setViewTextColor(this.m.f14918e, R.color.CAM_X0109);
        SkinManager.getDrawable(this.f62182g.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f62182g.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.f62182g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.m.f14918e.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f62182g.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setBackgroundColor(this.m.i, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: w */
    public void n(f fVar) {
        UserData userData = fVar.f60541e;
        if (userData != null) {
            if (!StringUtils.isNull(userData.getPortrait())) {
                this.m.f14916c.W(fVar.f60541e.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.f60541e.getName_show())) {
                this.m.f14917d.setText(fVar.f60541e.getName_show());
            }
            if (fVar.f60543g) {
                if (fVar.f60541e.hadConcerned()) {
                    this.m.f14920g.setVisibility(8);
                    this.m.f14921h.setVisibility(0);
                } else {
                    this.m.f14920g.setVisibility(0);
                    this.m.f14921h.setVisibility(8);
                }
            } else {
                this.m.f14920g.setVisibility(8);
                this.m.f14921h.setVisibility(8);
            }
            this.m.f14920g.setTag(fVar.f60541e);
        }
        AlaInfoData alaInfoData = fVar.f60542f;
        if (alaInfoData != null) {
            this.m.f14915b.setTag(alaInfoData);
            if (!StringUtils.isNull(fVar.f60542f.description)) {
                String str = fVar.f60542f.description;
                int i = this.o;
                if (fVar.f60543g) {
                    i -= 9;
                }
                if (k.byteLength(str) > i) {
                    str = StringHelper.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
                }
                this.m.f14919f.setText(str);
            }
        }
        if (fVar.f60543g) {
            TiebaStatic.log(new StatisticItem("c12895"));
        } else {
            TiebaStatic.log(new StatisticItem("c12893"));
        }
        this.m.f14920g.setTag(fVar.f60541e);
        o(l(), TbadkCoreApplication.getInst().getSkinType());
    }
}
