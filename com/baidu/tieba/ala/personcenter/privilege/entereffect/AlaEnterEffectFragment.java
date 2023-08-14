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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
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
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.pf6;
import com.baidu.tieba.rf6;
import com.baidu.tieba.ym;
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
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public TbImageView e;
    public BdTypeListView f;
    public rf6 g;
    public pf6 h;
    public LoadingView i;
    public AlaNetRefreshView j;
    public TextView k;
    public View l;
    public View m;
    public ImageView n;
    public TextView o;
    public RelativeLayout p;
    public CustomMessageListener q;
    public pf6.b r;
    public CustomMessageListener s;

    /* loaded from: classes5.dex */
    public class c implements pf6.b {
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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.Q1();
                    this.a.a.S1();
                    this.a.a.h.d();
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

        @Override // com.baidu.tieba.pf6.b
        public void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, alaGetEnterEffectResponsedMessage) != null) {
                return;
            }
            this.a.hideLoadingView();
            this.a.Q1();
            if (alaGetEnterEffectResponsedMessage == null || alaGetEnterEffectResponsedMessage.getError() != 0) {
                this.a.U1(TbadkCoreApplication.getCurrentPortrait());
                this.a.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0237, 0));
                this.a.c.setText(TbadkCoreApplication.getCurrentAccountNameShow());
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.T1(R.drawable.pic_live_empty04, R.string.obfuscated_res_0x7f0f0263, false, null);
                    return;
                } else {
                    this.a.T1(R.drawable.pic_live_empty03, R.string.obfuscated_res_0x7f0f0264, true, new a(this));
                    return;
                }
            }
            this.a.U1(alaGetEnterEffectResponsedMessage.getPortrait());
            this.a.c.setText(alaGetEnterEffectResponsedMessage.getUserName());
            this.a.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0237, Integer.valueOf(alaGetEnterEffectResponsedMessage.getEnterEffectCount())));
            List<ym> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
            this.a.g.c(effectList);
            if (!ListUtils.isEmpty(effectList) && BdNetTypeUtil.isWifiNet()) {
                for (ym ymVar : effectList) {
                    if (ymVar instanceof AlaEnterEffectData) {
                        AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) ymVar;
                        if (alaEnterEffectData.type == 1 && alaEnterEffectData.downLoadStatus == 100) {
                            AlaDynamicGift alaDynamicGift = alaEnterEffectData.gift;
                            String str = alaDynamicGift.giftId;
                            String str2 = alaDynamicGift.giftZip.zipDownloadUrl;
                            String str3 = alaDynamicGift.giftName;
                            ResourceDownloader.checkAndDownloadResZipInMainThread(str, str2, str3, AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName, AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX, alaEnterEffectData.gift.giftZip.zipMD5, false);
                            this.a.g.d(alaEnterEffectData.gift.giftId, 102);
                        }
                    }
                }
            }
        }
    }

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.g != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.g.e((String) customResponsedMessage.getData(), true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdResourceCallback<BdImage> {
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
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((b) bdImage, str, i);
                if (bdImage != null && bdImage.getRawBitmap() != null) {
                    this.a.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.a.e.setImageBitmap(BitmapHelper.fastblur(bdImage.getRawBitmap(), 15, 0.75f));
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
                if (wrapDownloadData.status == 4 && (downloadData = wrapDownloadData.data) != null && !StringUtils.isNull(downloadData.getId())) {
                    this.a.g.d(downloadData.getId(), 101);
                }
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
        t = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f023b);
    }

    public void Q1() {
        AlaNetRefreshView alaNetRefreshView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (alaNetRefreshView = this.j) != null) {
            alaNetRefreshView.dettachView(this.p);
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return t;
        }
        return (String) invokeV.objValue;
    }

    public final void hideLoadingView() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (loadingView = this.i) != null) {
            loadingView.dettachView(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            hideLoadingView();
            pf6 pf6Var = this.h;
            if (pf6Var != null) {
                pf6Var.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                TiebaStatic.log("c13335");
            }
        }
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

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.i == null) {
                this.i = new LoadingView(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d0));
            }
            this.i.attachView(this.a, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.s);
            registerListener(this.q);
        }
    }

    public final void R1() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (view2 = this.a) == null) {
            return;
        }
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901e2);
        this.b = headImageView;
        headImageView.setIsRound(true);
        this.e = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0901e3);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901ea);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901dd);
        this.k = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901df);
        this.m = this.a.findViewById(R.id.obfuscated_res_0x7f0901e9);
        this.n = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0909f6);
        this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909f8);
        this.p = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0901e6);
        this.f = (BdTypeListView) this.a.findViewById(R.id.obfuscated_res_0x7f0901e7);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f090a03);
        this.l = findViewById;
        this.f.setEmptyView(findViewById);
        this.g = new rf6(getPageContext(), this.f);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void T1(int i, int i2, boolean z, View.OnClickListener onClickListener) {
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

    public final void U1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (!StringUtils.isNull(str)) {
                this.b.startLoad(str, 25, false);
                BdResourceLoader.getInstance().loadResource(str, 25, new b(this), null);
                return;
            }
            this.b.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.e.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 1001 && i2 == -1 && intent != null) {
                this.g.f(intent.getStringExtra("key_selected_effect_id"), intent.getBooleanExtra("key_status_is_selected", false));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            LoadingView loadingView = this.i;
            if (loadingView != null) {
                loadingView.onChangeSkinType();
            }
            AlaNetRefreshView alaNetRefreshView = this.j;
            if (alaNetRefreshView != null) {
                alaNetRefreshView.onChangeSkinType();
            }
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.c, R.color.common_color_10310, 1, i);
            SkinManager.setViewTextColor(this.d, R.color.white_alpha70, 1, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0106, 1, i);
            ImageView imageView = this.n;
            if (imageView != null) {
                imageView.setAlpha(1.0f);
            }
            View view2 = this.m;
            if (view2 != null) {
                view2.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha30));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            this.a = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00f1, (ViewGroup) null);
            R1();
            this.h = new pf6(getPageContext(), this.r);
            S1();
            this.h.d();
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }
}
