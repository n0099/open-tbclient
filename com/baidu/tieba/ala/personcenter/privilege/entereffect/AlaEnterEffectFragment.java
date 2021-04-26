package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.downloader.ResourceDownloader;
import com.baidu.ala.downloader.WrapDownloadData;
import com.baidu.ala.gift.AlaDynamicGift;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.i0.d0.g;
import d.a.j0.t.j.g.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaEnterEffectFragment extends AbsFragment {
    public static final String x = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_enter_effect_fragment_title);

    /* renamed from: e  reason: collision with root package name */
    public View f14828e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f14829f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14830g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14831h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f14832i;
    public BdTypeListView j;
    public d.a.j0.t.j.g.d.c.a k;
    public d.a.j0.t.j.g.d.a l;
    public g m;
    public AlaNetRefreshView n;
    public TextView o;
    public View p;
    public View q;
    public ImageView r;
    public TextView s;
    public RelativeLayout t;
    public CustomMessageListener u = new a(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS);
    public a.b v = new c();
    public CustomMessageListener w = new d(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaEnterEffectFragment.this.k == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            AlaEnterEffectFragment.this.k.e((String) customResponsedMessage.getData(), true);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((b) aVar, str, i2);
            if (aVar == null || aVar.p() == null) {
                return;
            }
            AlaEnterEffectFragment.this.f14832i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            AlaEnterEffectFragment.this.f14832i.setImageBitmap(BitmapHelper.fastblur(aVar.p(), 15, 0.75f));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.b {

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectFragment.this.M0();
                AlaEnterEffectFragment.this.O0();
                AlaEnterEffectFragment.this.l.d();
            }
        }

        public c() {
        }

        @Override // d.a.j0.t.j.g.d.a.b
        public void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage) {
            AlaEnterEffectFragment.this.n();
            AlaEnterEffectFragment.this.M0();
            if (alaGetEnterEffectResponsedMessage == null || alaGetEnterEffectResponsedMessage.getError() != 0) {
                AlaEnterEffectFragment.this.Q0(TbadkCoreApplication.getCurrentPortrait());
                AlaEnterEffectFragment.this.f14831h.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, 0));
                AlaEnterEffectFragment.this.f14830g.setText(TbadkCoreApplication.getCurrentAccountNameShow());
                if (j.z()) {
                    AlaEnterEffectFragment.this.P0(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    return;
                } else {
                    AlaEnterEffectFragment.this.P0(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, new a());
                    return;
                }
            }
            AlaEnterEffectFragment.this.Q0(alaGetEnterEffectResponsedMessage.getPortrait());
            AlaEnterEffectFragment.this.f14830g.setText(alaGetEnterEffectResponsedMessage.getUserName());
            AlaEnterEffectFragment.this.f14831h.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, Integer.valueOf(alaGetEnterEffectResponsedMessage.getEnterEffectCount())));
            List<n> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
            AlaEnterEffectFragment.this.k.c(effectList);
            if (ListUtils.isEmpty(effectList) || !j.H()) {
                return;
            }
            for (n nVar : effectList) {
                if (nVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                    if (alaEnterEffectData.type == 1 && alaEnterEffectData.downLoadStatus == 100) {
                        AlaDynamicGift alaDynamicGift = alaEnterEffectData.gift;
                        String str = alaDynamicGift.giftId;
                        String str2 = alaDynamicGift.giftZip.zipDownloadUrl;
                        String str3 = alaDynamicGift.giftName;
                        ResourceDownloader.checkAndDownloadResZipInMainThread(str, str2, str3, AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName, AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX, alaEnterEffectData.gift.giftZip.zipMD5, false);
                        AlaEnterEffectFragment.this.k.d(alaEnterEffectData.gift.giftId, 102);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof WrapDownloadData)) {
                return;
            }
            WrapDownloadData wrapDownloadData = (WrapDownloadData) customResponsedMessage.getData();
            if (wrapDownloadData.status != 4 || (downloadData = wrapDownloadData.data) == null || StringUtils.isNull(downloadData.getId())) {
                return;
            }
            AlaEnterEffectFragment.this.k.d(downloadData.getId(), 101);
        }
    }

    public void M0() {
        AlaNetRefreshView alaNetRefreshView = this.n;
        if (alaNetRefreshView != null) {
            alaNetRefreshView.dettachView(this.t);
        }
    }

    public final void N0() {
        View view = this.f14828e;
        if (view == null) {
            return;
        }
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.ala_enter_effect_header);
        this.f14829f = headImageView;
        headImageView.setIsRound(true);
        this.f14832i = (TbImageView) this.f14828e.findViewById(R.id.ala_enter_effect_header_container_bg);
        this.f14830g = (TextView) this.f14828e.findViewById(R.id.ala_enter_effect_name);
        this.f14831h = (TextView) this.f14828e.findViewById(R.id.ala_enter_effect_count);
        this.o = (TextView) this.f14828e.findViewById(R.id.ala_enter_effect_description_txt);
        this.q = this.f14828e.findViewById(R.id.ala_enter_effect_mask);
        this.r = (ImageView) this.f14828e.findViewById(R.id.empty_image);
        this.s = (TextView) this.f14828e.findViewById(R.id.empty_text);
        this.t = (RelativeLayout) this.f14828e.findViewById(R.id.ala_enter_effect_list_layout);
        this.j = (BdTypeListView) this.f14828e.findViewById(R.id.ala_enter_effect_list_view);
        View findViewById = this.f14828e.findViewById(R.id.emptyview);
        this.p = findViewById;
        this.j.setEmptyView(findViewById);
        this.k = new d.a.j0.t.j.g.d.c.a(getPageContext(), this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void O0() {
        if (this.m == null) {
            this.m = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.m.attachView(this.f14828e, false);
    }

    public void P0(int i2, int i3, boolean z, View.OnClickListener onClickListener) {
        if (this.n == null) {
            this.n = new AlaNetRefreshView(getContext());
        }
        this.n.setImageResource(i2);
        this.n.setNetFailTipText(getContext().getString(i3));
        this.n.onChangeSkinType();
        this.n.setIsShowRefreshButton(z);
        if (z) {
            this.n.setOnRefreshClickListener(onClickListener);
        }
        this.n.attachView(this.t);
    }

    public final void Q0(String str) {
        if (!StringUtils.isNull(str)) {
            this.f14829f.V(str, 25, false);
            d.a.c.e.l.d.h().m(str, 25, new b(), null);
            return;
        }
        this.f14829f.V(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        this.f14832i.V(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public int getPageType() {
        return 0;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        return x;
    }

    public final void n() {
        g gVar = this.m;
        if (gVar != null) {
            gVar.dettachView(this.f14828e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1001 && i3 == -1 && intent != null) {
            this.k.f(intent.getStringExtra(AlaEnterEffectDetailActivity.KEY_SELECTED_EFFECT_ID), intent.getBooleanExtra(AlaEnterEffectDetailActivity.KEY_STATUS_IS_SELECTED, false));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        g gVar = this.m;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        AlaNetRefreshView alaNetRefreshView = this.n;
        if (alaNetRefreshView != null) {
            alaNetRefreshView.onChangeSkinType();
        }
        SkinManager.setBackgroundColor(this.f14828e, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f14830g, R.color.common_color_10310, 1, i2);
        SkinManager.setViewTextColor(this.f14831h, R.color.white_alpha70, 1, i2);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109, 1, i2);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0106, 1, i2);
        if (i2 == 1) {
            ImageView imageView = this.r;
            if (imageView != null) {
                imageView.setAlpha(0.4f);
            }
            View view = this.q;
            if (view != null) {
                view.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha60));
                return;
            }
            return;
        }
        ImageView imageView2 = this.r;
        if (imageView2 != null) {
            imageView2.setAlpha(1.0f);
        }
        View view2 = this.q;
        if (view2 != null) {
            view2.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha30));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.w);
        registerListener(this.u);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f14828e = LayoutInflater.from(getContext()).inflate(R.layout.ala_enter_effect_fragment_layout, (ViewGroup) null);
        N0();
        this.l = new d.a.j0.t.j.g.d.a(getPageContext(), this.v);
        O0();
        this.l.d();
        return this.f14828e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        n();
        d.a.j0.t.j.g.d.a aVar = this.l;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            TiebaStatic.log("c13335");
        }
    }
}
