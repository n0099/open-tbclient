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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.o0.f0.g;
import c.a.p0.c0.l.g.d.a;
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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class AlaEnterEffectFragment extends AbsFragment {
    public static /* synthetic */ Interceptable $ic;
    public static final String t;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f31486b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31487c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31488d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f31489e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f31490f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.c0.l.g.d.c.a f31491g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.c0.l.g.d.a f31492h;
    public g i;
    public AlaNetRefreshView j;
    public TextView k;
    public View l;
    public View m;
    public ImageView n;
    public TextView o;
    public RelativeLayout p;
    public CustomMessageListener q;
    public a.b r;
    public CustomMessageListener s;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaEnterEffectFragment alaEnterEffectFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEnterEffectFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f31491g == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            this.a.f31491g.e((String) customResponsedMessage.getData(), true);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectFragment a;

        public b(AlaEnterEffectFragment alaEnterEffectFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEnterEffectFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) {
                super.onLoaded((b) aVar, str, i);
                if (aVar == null || aVar.p() == null) {
                    return;
                }
                this.a.f31489e.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.a.f31489e.setImageBitmap(BitmapHelper.fastblur(aVar.p(), 15, 0.75f));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectFragment a;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.a.a.K0();
                    this.a.a.M0();
                    this.a.a.f31492h.d();
                }
            }
        }

        public c(AlaEnterEffectFragment alaEnterEffectFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEnterEffectFragment;
        }

        @Override // c.a.p0.c0.l.g.d.a.b
        public void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, alaGetEnterEffectResponsedMessage) == null) {
                this.a.d();
                this.a.K0();
                if (alaGetEnterEffectResponsedMessage == null || alaGetEnterEffectResponsedMessage.getError() != 0) {
                    this.a.O0(TbadkCoreApplication.getCurrentPortrait());
                    this.a.f31488d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0200, 0));
                    this.a.f31487c.setText(TbadkCoreApplication.getCurrentAccountNameShow());
                    if (l.z()) {
                        this.a.N0(R.drawable.pic_live_empty04, R.string.obfuscated_res_0x7f0f022b, false, null);
                        return;
                    } else {
                        this.a.N0(R.drawable.pic_live_empty03, R.string.obfuscated_res_0x7f0f022c, true, new a(this));
                        return;
                    }
                }
                this.a.O0(alaGetEnterEffectResponsedMessage.getPortrait());
                this.a.f31487c.setText(alaGetEnterEffectResponsedMessage.getUserName());
                this.a.f31488d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0200, Integer.valueOf(alaGetEnterEffectResponsedMessage.getEnterEffectCount())));
                List<n> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
                this.a.f31491g.c(effectList);
                if (ListUtils.isEmpty(effectList) || !l.H()) {
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
                            this.a.f31491g.d(alaEnterEffectData.gift.giftId, 102);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AlaEnterEffectFragment alaEnterEffectFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEnterEffectFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof WrapDownloadData)) {
                WrapDownloadData wrapDownloadData = (WrapDownloadData) customResponsedMessage.getData();
                if (wrapDownloadData.status != 4 || (downloadData = wrapDownloadData.data) == null || StringUtils.isNull(downloadData.getId())) {
                    return;
                }
                this.a.f31491g.d(downloadData.getId(), 101);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1787056138, "Lcom/baidu/tieba/ala/personcenter/privilege/entereffect/AlaEnterEffectFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1787056138, "Lcom/baidu/tieba/ala/personcenter/privilege/entereffect/AlaEnterEffectFragment;");
                return;
            }
        }
        t = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0204);
    }

    public AlaEnterEffectFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new a(this, AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS);
        this.r = new c(this);
        this.s = new d(this, AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS);
    }

    public void K0() {
        AlaNetRefreshView alaNetRefreshView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (alaNetRefreshView = this.j) == null) {
            return;
        }
        alaNetRefreshView.dettachView(this.p);
    }

    public final void L0() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.a) == null) {
            return;
        }
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f0901cd);
        this.f31486b = headImageView;
        headImageView.setIsRound(true);
        this.f31489e = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0901ce);
        this.f31487c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901d5);
        this.f31488d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901c8);
        this.k = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901ca);
        this.m = this.a.findViewById(R.id.obfuscated_res_0x7f0901d4);
        this.n = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0908bd);
        this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0908bf);
        this.p = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0901d1);
        this.f31490f = (BdTypeListView) this.a.findViewById(R.id.obfuscated_res_0x7f0901d2);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f0908c7);
        this.l = findViewById;
        this.f31490f.setEmptyView(findViewById);
        this.f31491g = new c.a.p0.c0.l.g.d.c.a(getPageContext(), this.f31490f);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.i == null) {
                this.i = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ab));
            }
            this.i.attachView(this.a, false);
        }
    }

    public void N0(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), onClickListener}) == null) {
            if (this.j == null) {
                this.j = new AlaNetRefreshView(getContext());
            }
            this.j.setImageResource(i);
            this.j.setNetFailTipText(getContext().getString(i2));
            this.j.onChangeSkinType();
            this.j.setIsShowRefreshButton(z);
            if (z) {
                this.j.setOnRefreshClickListener(onClickListener);
            }
            this.j.attachView(this.p);
        }
    }

    public final void O0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (!StringUtils.isNull(str)) {
                this.f31486b.J(str, 25, false);
                c.a.d.f.l.d.h().m(str, 25, new b(this), null);
                return;
            }
            this.f31486b.J(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.f31489e.J(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
    }

    public final void d() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gVar = this.i) == null) {
            return;
        }
        gVar.dettachView(this.a);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public int getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? t : (String) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 1001 && i2 == -1 && intent != null) {
                this.f31491g.f(intent.getStringExtra(AlaEnterEffectDetailActivity.KEY_SELECTED_EFFECT_ID), intent.getBooleanExtra(AlaEnterEffectDetailActivity.KEY_STATUS_IS_SELECTED, false));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            g gVar = this.i;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            AlaNetRefreshView alaNetRefreshView = this.j;
            if (alaNetRefreshView != null) {
                alaNetRefreshView.onChangeSkinType();
            }
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f31487c, R.color.common_color_10310, 1, i);
            SkinManager.setViewTextColor(this.f31488d, R.color.white_alpha70, 1, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0106, 1, i);
            if (i == 1) {
                ImageView imageView = this.n;
                if (imageView != null) {
                    imageView.setAlpha(0.4f);
                }
                View view = this.m;
                if (view != null) {
                    view.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha60));
                    return;
                }
                return;
            }
            ImageView imageView2 = this.n;
            if (imageView2 != null) {
                imageView2.setAlpha(1.0f);
            }
            View view2 = this.m;
            if (view2 != null) {
                view2.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha30));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.s);
            registerListener(this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            this.a = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00f1, (ViewGroup) null);
            L0();
            this.f31492h = new c.a.p0.c0.l.g.d.a(getPageContext(), this.r);
            M0();
            this.f31492h.d();
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            d();
            c.a.p0.c0.l.g.d.a aVar = this.f31492h;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                TiebaStatic.log("c13335");
            }
        }
    }
}
