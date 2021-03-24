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
        public ConcernTabLiveItemView f14913a;

        /* renamed from: b  reason: collision with root package name */
        public View f14914b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f14915c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14916d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14917e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14918f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14919g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14920h;
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
                    ConcernTabLiveItemView.this.m.f14919g.setVisibility(8);
                    ConcernTabLiveItemView.this.m.f14920h.setVisibility(0);
                    TiebaStatic.log(new StatisticItem("c12897"));
                }
            }
        }

        public ViewHolder(ConcernTabLiveItemView concernTabLiveItemView) {
            super(concernTabLiveItemView.m());
            this.j = new a();
            this.f14913a = concernTabLiveItemView;
            View m = concernTabLiveItemView.m();
            this.f14914b = m;
            TbImageView tbImageView = (TbImageView) m.findViewById(R.id.protrait);
            this.f14915c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.f14915c.setIsRound(true);
            this.f14915c.setAutoChangeStyle(false);
            this.f14915c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14916d = (TextView) this.f14914b.findViewById(R.id.live_title);
            this.f14917e = (TextView) this.f14914b.findViewById(R.id.living_tag);
            this.i = this.f14914b.findViewById(R.id.devider_line);
            Drawable drawable = SkinManager.getDrawable(ConcernTabLiveItemView.this.f62181g.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.f62181g.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.f62181g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f14917e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f14918f = (TextView) this.f14914b.findViewById(R.id.user_name);
            this.f14919g = (TextView) this.f14914b.findViewById(R.id.follow_btn);
            this.f14920h = (TextView) this.f14914b.findViewById(R.id.followed_btn);
            this.f14919g.setOnClickListener(this.j);
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
        SkinManager.setViewTextColor(this.m.f14916d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m.f14918f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f14920h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m.f14919g, R.color.common_color_10140);
        SkinManager.setViewTextColor(this.m.f14917e, R.color.CAM_X0109);
        SkinManager.getDrawable(this.f62181g.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f62181g.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.f62181g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.m.f14917e.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f62181g.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setBackgroundColor(this.m.i, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: w */
    public void n(f fVar) {
        UserData userData = fVar.f60540e;
        if (userData != null) {
            if (!StringUtils.isNull(userData.getPortrait())) {
                this.m.f14915c.W(fVar.f60540e.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.f60540e.getName_show())) {
                this.m.f14916d.setText(fVar.f60540e.getName_show());
            }
            if (fVar.f60542g) {
                if (fVar.f60540e.hadConcerned()) {
                    this.m.f14919g.setVisibility(8);
                    this.m.f14920h.setVisibility(0);
                } else {
                    this.m.f14919g.setVisibility(0);
                    this.m.f14920h.setVisibility(8);
                }
            } else {
                this.m.f14919g.setVisibility(8);
                this.m.f14920h.setVisibility(8);
            }
            this.m.f14919g.setTag(fVar.f60540e);
        }
        AlaInfoData alaInfoData = fVar.f60541f;
        if (alaInfoData != null) {
            this.m.f14914b.setTag(alaInfoData);
            if (!StringUtils.isNull(fVar.f60541f.description)) {
                String str = fVar.f60541f.description;
                int i = this.o;
                if (fVar.f60542g) {
                    i -= 9;
                }
                if (k.byteLength(str) > i) {
                    str = StringHelper.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
                }
                this.m.f14918f.setText(str);
            }
        }
        if (fVar.f60542g) {
            TiebaStatic.log(new StatisticItem("c12895"));
        } else {
            TiebaStatic.log(new StatisticItem("c12893"));
        }
        this.m.f14919g.setTag(fVar.f60540e);
        o(l(), TbadkCoreApplication.getInst().getSkinType());
    }
}
