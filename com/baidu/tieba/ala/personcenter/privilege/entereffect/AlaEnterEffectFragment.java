package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.a06;
import com.baidu.tieba.ah;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.c06;
import com.baidu.tieba.eo;
import com.baidu.tieba.j95;
import com.baidu.tieba.pn;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
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
    public c06 g;
    public a06 h;
    public j95 i;
    public AlaNetRefreshView j;
    public TextView k;
    public View l;
    public View m;
    public ImageView n;
    public TextView o;
    public RelativeLayout p;
    public CustomMessageListener q;
    public a06.b r;
    public CustomMessageListener s;

    /* loaded from: classes3.dex */
    public class c implements a06.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectFragment a;

        /* loaded from: classes3.dex */
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
                    this.a.a.z1();
                    this.a.a.B1();
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

        @Override // com.baidu.tieba.a06.b
        public void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, alaGetEnterEffectResponsedMessage) != null) {
                return;
            }
            this.a.m();
            this.a.z1();
            if (alaGetEnterEffectResponsedMessage == null || alaGetEnterEffectResponsedMessage.getError() != 0) {
                this.a.D1(TbadkCoreApplication.getCurrentPortrait());
                this.a.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f020b, 0));
                this.a.c.setText(TbadkCoreApplication.getCurrentAccountNameShow());
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.C1(R.drawable.pic_live_empty04, R.string.obfuscated_res_0x7f0f0236, false, null);
                    return;
                } else {
                    this.a.C1(R.drawable.pic_live_empty03, R.string.obfuscated_res_0x7f0f0237, true, new a(this));
                    return;
                }
            }
            this.a.D1(alaGetEnterEffectResponsedMessage.getPortrait());
            this.a.c.setText(alaGetEnterEffectResponsedMessage.getUserName());
            this.a.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f020b, Integer.valueOf(alaGetEnterEffectResponsedMessage.getEnterEffectCount())));
            List<eo> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
            this.a.g.c(effectList);
            if (!ListUtils.isEmpty(effectList) && BdNetTypeUtil.isWifiNet()) {
                for (eo eoVar : effectList) {
                    if (eoVar instanceof AlaEnterEffectData) {
                        AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) eoVar;
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

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.g != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.g.e((String) customResponsedMessage.getData(), true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends zg {
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
        @Override // com.baidu.tieba.zg
        public void onLoaded(pn pnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, pnVar, str, i) == null) {
                super.onLoaded((b) pnVar, str, i);
                if (pnVar != null && pnVar.p() != null) {
                    this.a.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.a.e.setImageBitmap(BitmapHelper.fastblur(pnVar.p(), 15, 0.75f));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
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
        t = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f020f);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return t;
        }
        return (String) invokeV.objValue;
    }

    public final void m() {
        j95 j95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (j95Var = this.i) != null) {
            j95Var.dettachView(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            m();
            a06 a06Var = this.h;
            if (a06Var != null) {
                a06Var.c();
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

    public void z1() {
        AlaNetRefreshView alaNetRefreshView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (alaNetRefreshView = this.j) != null) {
            alaNetRefreshView.dettachView(this.p);
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

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.i == null) {
                this.i = new j95(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b2));
            }
            this.i.attachView(this.a, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.s);
            registerListener(this.q);
        }
    }

    public final void A1() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (view2 = this.a) == null) {
            return;
        }
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901d2);
        this.b = headImageView;
        headImageView.setIsRound(true);
        this.e = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0901d3);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901da);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901cd);
        this.k = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901cf);
        this.m = this.a.findViewById(R.id.obfuscated_res_0x7f0901d9);
        this.n = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0908eb);
        this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0908ed);
        this.p = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0901d6);
        this.f = (BdTypeListView) this.a.findViewById(R.id.obfuscated_res_0x7f0901d7);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f0908f5);
        this.l = findViewById;
        this.f.setEmptyView(findViewById);
        this.g = new c06(getPageContext(), this.f);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void C1(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), onClickListener}) == null) {
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

    public final void D1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (!StringUtils.isNull(str)) {
                this.b.L(str, 25, false);
                ah.h().m(str, 25, new b(this), null);
                return;
            }
            this.b.L(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.e.L(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 1001 && i2 == -1 && intent != null) {
                this.g.f(intent.getStringExtra("key_selected_effect_id"), intent.getBooleanExtra("key_status_is_selected", false));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            j95 j95Var = this.i;
            if (j95Var != null) {
                j95Var.onChangeSkinType();
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
            if (i == 1) {
                ImageView imageView = this.n;
                if (imageView != null) {
                    imageView.setAlpha(0.4f);
                }
                View view2 = this.m;
                if (view2 != null) {
                    view2.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha60));
                    return;
                }
                return;
            }
            ImageView imageView2 = this.n;
            if (imageView2 != null) {
                imageView2.setAlpha(1.0f);
            }
            View view3 = this.m;
            if (view3 != null) {
                view3.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha30));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            this.a = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00ed, (ViewGroup) null);
            A1();
            this.h = new a06(getPageContext(), this.r);
            B1();
            this.h.d();
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }
}
