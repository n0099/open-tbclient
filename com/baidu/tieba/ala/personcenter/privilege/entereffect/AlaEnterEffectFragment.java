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
import b.a.e.e.p.j;
import b.a.e.l.e.n;
import b.a.q0.g0.g;
import b.a.r0.w.l.g.d.a;
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
/* loaded from: classes9.dex */
public class AlaEnterEffectFragment extends AbsFragment {
    public static /* synthetic */ Interceptable $ic;
    public static final String x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f47220e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f47221f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47222g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47223h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f47224i;
    public BdTypeListView j;
    public b.a.r0.w.l.g.d.c.a k;
    public b.a.r0.w.l.g.d.a l;
    public g m;
    public AlaNetRefreshView n;
    public TextView o;
    public View p;
    public View q;
    public ImageView r;
    public TextView s;
    public RelativeLayout t;
    public CustomMessageListener u;
    public a.b v;
    public CustomMessageListener w;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaEnterEffectFragment f47225a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaEnterEffectFragment alaEnterEffectFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47225a = alaEnterEffectFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f47225a.k == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            this.f47225a.k.e((String) customResponsedMessage.getData(), true);
        }
    }

    /* loaded from: classes9.dex */
    public class b extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaEnterEffectFragment f47226a;

        public b(AlaEnterEffectFragment alaEnterEffectFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47226a = alaEnterEffectFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar == null || aVar.p() == null) {
                    return;
                }
                this.f47226a.f47224i.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f47226a.f47224i.setImageBitmap(BitmapHelper.fastblur(aVar.p(), 15, 0.75f));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaEnterEffectFragment f47227a;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f47228e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47228e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f47228e.f47227a.hideNetRefreshView();
                    this.f47228e.f47227a.showLoadingView();
                    this.f47228e.f47227a.l.d();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47227a = alaEnterEffectFragment;
        }

        @Override // b.a.r0.w.l.g.d.a.b
        public void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, alaGetEnterEffectResponsedMessage) == null) {
                this.f47227a.hideLoadingView();
                this.f47227a.hideNetRefreshView();
                if (alaGetEnterEffectResponsedMessage == null || alaGetEnterEffectResponsedMessage.getError() != 0) {
                    this.f47227a.i(TbadkCoreApplication.getCurrentPortrait());
                    this.f47227a.f47223h.setText(this.f47227a.getString(R.string.ala_enter_effect_count, 0));
                    this.f47227a.f47222g.setText(TbadkCoreApplication.getCurrentAccountNameShow());
                    if (j.z()) {
                        this.f47227a.showNetRefreshView(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                        return;
                    } else {
                        this.f47227a.showNetRefreshView(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, new a(this));
                        return;
                    }
                }
                this.f47227a.i(alaGetEnterEffectResponsedMessage.getPortrait());
                this.f47227a.f47222g.setText(alaGetEnterEffectResponsedMessage.getUserName());
                this.f47227a.f47223h.setText(this.f47227a.getString(R.string.ala_enter_effect_count, Integer.valueOf(alaGetEnterEffectResponsedMessage.getEnterEffectCount())));
                List<n> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
                this.f47227a.k.c(effectList);
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
                            this.f47227a.k.d(alaEnterEffectData.gift.giftId, 102);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaEnterEffectFragment f47229a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AlaEnterEffectFragment alaEnterEffectFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47229a = alaEnterEffectFragment;
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
                this.f47229a.k.d(downloadData.getId(), 101);
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
        x = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_enter_effect_fragment_title);
    }

    public AlaEnterEffectFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = new a(this, AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS);
        this.v = new c(this);
        this.w = new d(this, AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public int getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? x : (String) invokeV.objValue;
    }

    public final void hideLoadingView() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.m) == null) {
            return;
        }
        gVar.dettachView(this.f47220e);
    }

    public void hideNetRefreshView() {
        AlaNetRefreshView alaNetRefreshView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (alaNetRefreshView = this.n) == null) {
            return;
        }
        alaNetRefreshView.dettachView(this.t);
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (!StringUtils.isNull(str)) {
                this.f47221f.startLoad(str, 25, false);
                b.a.e.e.l.d.h().m(str, 25, new b(this), null);
                return;
            }
            this.f47221f.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.f47224i.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
    }

    public final void initView() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (view = this.f47220e) == null) {
            return;
        }
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.ala_enter_effect_header);
        this.f47221f = headImageView;
        headImageView.setIsRound(true);
        this.f47224i = (TbImageView) this.f47220e.findViewById(R.id.ala_enter_effect_header_container_bg);
        this.f47222g = (TextView) this.f47220e.findViewById(R.id.ala_enter_effect_name);
        this.f47223h = (TextView) this.f47220e.findViewById(R.id.ala_enter_effect_count);
        this.o = (TextView) this.f47220e.findViewById(R.id.ala_enter_effect_description_txt);
        this.q = this.f47220e.findViewById(R.id.ala_enter_effect_mask);
        this.r = (ImageView) this.f47220e.findViewById(R.id.empty_image);
        this.s = (TextView) this.f47220e.findViewById(R.id.empty_text);
        this.t = (RelativeLayout) this.f47220e.findViewById(R.id.ala_enter_effect_list_layout);
        this.j = (BdTypeListView) this.f47220e.findViewById(R.id.ala_enter_effect_list_view);
        View findViewById = this.f47220e.findViewById(R.id.emptyview);
        this.p = findViewById;
        this.j.setEmptyView(findViewById);
        this.k = new b.a.r0.w.l.g.d.c.a(getPageContext(), this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 1001 && i3 == -1 && intent != null) {
                this.k.f(intent.getStringExtra(AlaEnterEffectDetailActivity.KEY_SELECTED_EFFECT_ID), intent.getBooleanExtra(AlaEnterEffectDetailActivity.KEY_STATUS_IS_SELECTED, false));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.m;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            AlaNetRefreshView alaNetRefreshView = this.n;
            if (alaNetRefreshView != null) {
                alaNetRefreshView.onChangeSkinType();
            }
            SkinManager.setBackgroundColor(this.f47220e, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f47222g, R.color.common_color_10310, 1, i2);
            SkinManager.setViewTextColor(this.f47223h, R.color.white_alpha70, 1, i2);
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
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.w);
            registerListener(this.u);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f47220e = LayoutInflater.from(getContext()).inflate(R.layout.ala_enter_effect_fragment_layout, (ViewGroup) null);
            initView();
            this.l = new b.a.r0.w.l.g.d.a(getPageContext(), this.v);
            showLoadingView();
            this.l.d();
            return this.f47220e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            hideLoadingView();
            b.a.r0.w.l.g.d.a aVar = this.l;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                TiebaStatic.log("c13335");
            }
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.m == null) {
                this.m = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            }
            this.m.attachView(this.f47220e, false);
        }
    }

    public void showNetRefreshView(int i2, int i3, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), onClickListener}) == null) {
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
    }
}
