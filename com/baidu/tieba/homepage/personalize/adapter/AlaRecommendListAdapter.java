package com.baidu.tieba.homepage.personalize.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.k0.a1.g.j.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
/* loaded from: classes4.dex */
public class AlaRecommendListAdapter extends RecyclerView.Adapter<AlaUserInfoViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f16509a;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f16511c;

    /* renamed from: b  reason: collision with root package name */
    public int f16510b = 3;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<Long> f16512d = new HashSet<>();

    /* loaded from: classes4.dex */
    public class AlaUserInfoViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f16513a;

        /* renamed from: b  reason: collision with root package name */
        public ObjectAnimator f16514b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f16515c;

        /* renamed from: d  reason: collision with root package name */
        public HeadImageView f16516d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16517e;

        /* renamed from: f  reason: collision with root package name */
        public TBSpecificationBtn f16518f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16519g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f16520h;

        public AlaUserInfoViewHolder(View view) {
            super(view);
            this.f16513a = view.findViewById(R.id.ala_recommend_container);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.ala_animation_background);
            this.f16520h = tbImageView;
            SkinManager.setImageResource(tbImageView, R.drawable.icon_mask_live);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f16520h, "rotation", 0.0f, 359.0f);
            this.f16514b = ofFloat;
            ofFloat.setRepeatCount(-1);
            this.f16514b.setDuration(10000L);
            this.f16514b.setInterpolator(new LinearInterpolator());
            this.f16515c = (ImageView) view.findViewById(R.id.ala_gradient_background);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.f16516d = headImageView;
            headImageView.setRadius(l.g(AlaRecommendListAdapter.this.f16509a, R.dimen.tbds63));
            this.f16517e = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.f16518f = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            d.a.j0.r.f0.m.a aVar = new d.a.j0.r.f0.m.a();
            aVar.o(R.color.CAM_X0310);
            aVar.k(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            aVar.j(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120), l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.f16518f.setTextSize(R.dimen.tbds26);
            this.f16518f.setClickState(false);
            this.f16518f.setConfig(aVar);
            this.f16519g = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void h(int i2, int i3) {
            if (i2 == AlaRecommendListAdapter.this.f16510b) {
                return;
            }
            SkinManager.setViewTextColor(this.f16518f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f16519g, R.color.CAM_X0105);
            SkinManager.setImageResource(this.f16520h, R.drawable.icon_mask_live);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f16515c, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
            this.f16518f.k();
            if (i3 == 1) {
                SkinManager.setImageResource(this.f16516d, R.drawable.pic_live_hand_n);
            } else if (i3 == 2) {
                SkinManager.setImageResource(this.f16517e, R.drawable.icon_pure_live_moe22);
                HeadImageView headImageView = this.f16516d;
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds63);
                int i4 = R.color.CAM_X0203;
                SkinManager.setBackgroundShapeDrawable(headImageView, g2, i4, i4);
            }
            SkinManager.setViewTextColor(this.f16519g, R.color.CAM_X0105);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a(AlaRecommendListAdapter alaRecommendListAdapter) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
            StatisticItem statisticItem = new StatisticItem("c13621");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", 0);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f16522e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f16523f;

        public b(long j, j jVar) {
            this.f16522e = j;
            this.f16523f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = this.f16522e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(AlaRecommendListAdapter.this.f16509a, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
            StatisticItem statisticItem = new StatisticItem("c13623");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", 0);
            statisticItem.param("tid", this.f16523f.e());
            statisticItem.param("obj_type", this.f16523f.b());
            statisticItem.param(TiebaStatic.Params.STAR_ID, this.f16523f.d());
            statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, this.f16522e);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(AlaRecommendListAdapter.this.f16509a)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveTabMyConcernActivityConfig(AlaRecommendListAdapter.this.f16509a)));
                StatisticItem statisticItem = new StatisticItem("c13624");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", 0);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public AlaRecommendListAdapter(Context context) {
        this.f16509a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder, int i2) {
        List<j> list;
        j jVar;
        if (alaUserInfoViewHolder == null || (list = this.f16511c) == null || list.size() <= i2 || (jVar = this.f16511c.get(i2)) == null) {
            return;
        }
        if (jVar.f() == 1) {
            alaUserInfoViewHolder.f16518f.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
            alaUserInfoViewHolder.f16516d.setImageResource(R.drawable.pic_live_hand_n);
            alaUserInfoViewHolder.f16519g.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
            alaUserInfoViewHolder.f16513a.setOnClickListener(new a(this));
        } else if (jVar.f() == 0) {
            alaUserInfoViewHolder.f16518f.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
            alaUserInfoViewHolder.f16516d.setPlaceHolder(1);
            alaUserInfoViewHolder.f16516d.setDefaultResource(R.drawable.transparent_bg);
            if (!StringUtils.isNull(jVar.c())) {
                alaUserInfoViewHolder.f16516d.V(jVar.c(), 10, false);
            }
            if (StringHelper.getChineseAndEnglishLength(jVar.g()) > 8) {
                alaUserInfoViewHolder.f16519g.setText(StringHelper.cutChineseAndEnglishWithSuffix(jVar.g(), 6, StringHelper.STRING_MORE));
            } else {
                alaUserInfoViewHolder.f16519g.setText(jVar.g());
            }
            long a2 = jVar.a();
            alaUserInfoViewHolder.f16513a.setOnClickListener(new b(a2, jVar));
            if (!this.f16512d.contains(Long.valueOf(a2))) {
                StatisticItem statisticItem = new StatisticItem("c13622");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", 0);
                statisticItem.param("tid", jVar.e());
                statisticItem.param("obj_type", jVar.b());
                statisticItem.param(TiebaStatic.Params.STAR_ID, jVar.d());
                statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, a2);
                TiebaStatic.log(statisticItem);
                this.f16512d.add(Long.valueOf(a2));
            }
        } else if (jVar.f() == 2) {
            alaUserInfoViewHolder.f16518f.setVisibility(8);
            alaUserInfoViewHolder.f16520h.setVisibility(8);
            alaUserInfoViewHolder.f16515c.setVisibility(8);
            alaUserInfoViewHolder.f16519g.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
            alaUserInfoViewHolder.f16517e.setVisibility(0);
            alaUserInfoViewHolder.f16517e.setImageResource(R.drawable.icon_pure_live_moe22);
            alaUserInfoViewHolder.f16513a.setOnClickListener(new c());
        }
        alaUserInfoViewHolder.h(TbadkCoreApplication.getInst().getSkinType(), jVar.f());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public AlaUserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new AlaUserInfoViewHolder(LayoutInflater.from(this.f16509a).inflate(R.layout.ala_recommend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onViewAttachedToWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        ObjectAnimator objectAnimator;
        super.onViewAttachedToWindow(alaUserInfoViewHolder);
        if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.f16514b) == null) {
            return;
        }
        objectAnimator.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<j> list = this.f16511c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<j> list = this.f16511c;
        if (list == null || list.get(i2) == null) {
            return 0;
        }
        return this.f16511c.get(i2).f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onViewDetachedFromWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        ObjectAnimator objectAnimator;
        super.onViewDetachedFromWindow(alaUserInfoViewHolder);
        if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.f16514b) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    public void setData(List<AlaLiveInfo> list) {
        AlaUserInfo alaUserInfo;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f16511c == null) {
            this.f16511c = new ArrayList();
        }
        this.f16511c.clear();
        j jVar = new j();
        jVar.m(1);
        this.f16511c.add(jVar);
        if (list != null && list.size() > 12) {
            list = ListUtils.subList(list, 0, 12);
        }
        for (AlaLiveInfo alaLiveInfo : list) {
            if (alaLiveInfo != null && (alaUserInfo = alaLiveInfo.user_info) != null && !StringUtils.isNull(alaUserInfo.user_name) && alaLiveInfo.live_id.longValue() != 0) {
                j jVar2 = new j();
                jVar2.m(0);
                jVar2.j(alaLiveInfo.user_info.portrait);
                jVar2.n(alaLiveInfo.user_info.user_name);
                jVar2.h(alaLiveInfo.live_id.longValue());
                jVar2.l(alaLiveInfo.thread_id.longValue());
                jVar2.k(alaLiveInfo.user_info.ala_id.longValue());
                jVar2.i(alaLiveInfo.live_type.intValue());
                this.f16511c.add(jVar2);
            }
        }
        if (this.f16511c.size() > 12) {
            j jVar3 = new j();
            jVar3.m(2);
            this.f16511c.add(jVar3);
        }
    }
}
