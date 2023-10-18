package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.EmotionPackageDetailModel;
import com.baidu.tieba.faceshop.packagedetail.PackageDetailListView;
import com.baidu.tieba.g4;
import com.baidu.tieba.hz4;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupShareModel;
import com.baidu.tieba.o07;
import com.baidu.tieba.p07;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.zy6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class EmotionPackageDetailActivity extends BaseActivity<EmotionPackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public EmotionPackageData C;
    public int D;
    public hz4 E;
    public hz4 F;
    public ImageView G;
    public NewFaceGroupDownloadModel H;
    public NewFaceGroupShareModel I;
    public String J;
    public View K;
    public LikeModel L;
    public p07 M;
    public int N;
    public final CustomMessageListener O;
    public final CustomMessageListener P;
    public g4 Q;
    public CustomMessageListener R;
    public final String a;
    public EmotionPackageDetailModel b;
    public RelativeLayout c;
    public NoDataView d;
    public NavigationBar e;
    public NoNetworkView f;
    public PackageDetailListView g;
    public View h;
    public TbImageView i;
    public View j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public HeadImageView o;
    public TextView p;
    public k q;
    public View r;
    public View s;
    public View t;
    public View u;
    public ImageView v;
    public TextView w;
    public TextView x;
    public ImageView y;
    public TextView z;

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* loaded from: classes5.dex */
        public class a implements hz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, hz4Var) != null) {
                    return;
                }
                this.a.a.I1();
                hz4Var.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements hz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                }
            }
        }

        public e(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionPackageDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
                return;
            }
            if (this.a.E == null) {
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                emotionPackageDetailActivity.E = new hz4(emotionPackageDetailActivity.getPageContext().getPageActivity());
                this.a.E.setMessageId(R.string.obfuscated_res_0x7f0f0f49);
                this.a.E.setPositiveButton(R.string.obfuscated_res_0x7f0f0f4a, new a(this));
                this.a.E.setNegativeButton(R.string.obfuscated_res_0x7f0f0596, new b(this));
                this.a.E.setCancelable(true);
                this.a.E.create(this.a.getPageContext());
            }
            this.a.E.show();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements EmotionPackageDetailModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* loaded from: classes5.dex */
        public class a implements hz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                    this.a.a.t.setEnabled(true);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements hz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, hz4Var) != null) || this.a.a.C == null || TextUtils.isEmpty(this.a.a.C.forum_name)) {
                    return;
                }
                this.a.a.J1();
            }
        }

        public h(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionPackageDetailActivity;
        }

        @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.e
        public void a(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage.getError() == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921062, this.a.C));
                this.a.G1();
                if (this.a.x != null && this.a.x.isShown()) {
                    TextView textView = this.a.x;
                    EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                    textView.setText(emotionPackageDetailActivity.N1(emotionPackageDetailActivity.N + 1));
                }
                BdUtilHelper.showToast(this.a.getActivity(), (int) R.string.obfuscated_res_0x7f0f0f59);
            } else if (httpResponsedMessage.getError() == 170003) {
                if (this.a.F == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity2 = this.a;
                    emotionPackageDetailActivity2.F = new hz4(emotionPackageDetailActivity2.getPageContext().getPageActivity());
                    this.a.F.setMessageId(R.string.obfuscated_res_0x7f0f0f48);
                    this.a.F.setNegativeButton(R.string.obfuscated_res_0x7f0f0f46, new a(this));
                    this.a.F.setPositiveButton(R.string.obfuscated_res_0x7f0f0f47, new b(this));
                    this.a.F.create(this.a.getPageContext());
                    this.a.F.setCancelable(true);
                }
                this.a.F.show();
            } else {
                this.a.t.setEnabled(true);
                if (httpResponsedMessage.getErrorString() == null) {
                    errorString = this.a.getString(R.string.obfuscated_res_0x7f0f0f58);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                BdUtilHelper.showToast(this.a.getActivity(), errorString);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<EmotionPackageData.SingleEmotionData> a;
        public int b;
        public final /* synthetic */ EmotionPackageDetailActivity c;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
        }

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ TbImageView b;
            public final /* synthetic */ k c;

            public a(k kVar, int i, TbImageView tbImageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Integer.valueOf(i), tbImageView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = kVar;
                this.a = i;
                this.b = tbImageView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EmotionPackageData.SingleEmotionData singleEmotionData;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (singleEmotionData = (EmotionPackageData.SingleEmotionData) this.c.a.get(this.a)) == null || singleEmotionData.id < 0 || this.c.c.D < 0 || !BdNetTypeUtil.isNetWorkAvailable()) {
                    return;
                }
                EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(this.c.c.getPageContext().getPageActivity(), this.c.c.D, singleEmotionData.id, this.b.isGif());
                emotionDetailActivityConfig.setFromEmotionPackage(true);
                this.c.c.sendMessage(new CustomMessage(2002001, emotionDetailActivityConfig));
            }
        }

        /* loaded from: classes5.dex */
        public class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public TbImageView a;
            public TbImageView b;
            public TbImageView c;
            public TbImageView d;

            public b(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public TbImageView a(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    return null;
                                }
                                return this.d;
                            }
                            return this.c;
                        }
                        return this.b;
                    }
                    return this.a;
                }
                return (TbImageView) invokeI.objValue;
            }

            public /* synthetic */ b(k kVar, b bVar) {
                this(kVar);
            }
        }

        public k(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = emotionPackageDetailActivity;
            this.a = new ArrayList();
            this.b = (BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - BdUtilHelper.getDimens(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07039e)) / 4;
        }

        public /* synthetic */ k(EmotionPackageDetailActivity emotionPackageDetailActivity, b bVar) {
            this(emotionPackageDetailActivity);
        }

        public final void e(List<EmotionPackageData.SingleEmotionData> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || list == null) {
                return;
            }
            this.a.clear();
            this.a.addAll(new ArrayList(list));
            notifyDataSetChanged();
        }

        public final void c(int i, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bVar) == null) {
                for (int i2 = 0; i2 < 4; i2++) {
                    TbImageView a2 = bVar.a(i2);
                    if (a2 != null) {
                        int i3 = (i * 4) + i2;
                        if (i3 < this.a.size() && i3 >= 0) {
                            a2.setVisibility(0);
                            a2.setTag(null);
                            a2.setDefaultResource(R.drawable.img_default_100);
                            a2.startLoad(this.a.get(i3).thumbnail, 10, false);
                            a2.invalidate();
                            a2.setOnClickListener(new a(this, i3, a2));
                        } else {
                            a2.setVisibility(4);
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: d */
        public List<EmotionPackageData.SingleEmotionData> getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                ArrayList arrayList = new ArrayList();
                for (int size = this.a.size() / 4; size < (this.a.size() / 4) + 4; size++) {
                    if (size > 0 && size < this.a.size()) {
                        arrayList.add(this.a.get(size));
                    }
                }
                return this.a;
            }
            return (List) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int size = this.a.size() / 4;
                if (this.a.size() % 4 > 0) {
                    return size + 1;
                }
                return size;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            View view3;
            b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    bVar = new b(this, null);
                    view3 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d0768, viewGroup, false);
                    TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091a77);
                    bVar.a = tbImageView;
                    ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                    layoutParams.height = this.b;
                    bVar.a.setLayoutParams(layoutParams);
                    SkinManager.setBackgroundColor(bVar.a, R.color.CAM_X0201);
                    TbImageView tbImageView2 = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091a78);
                    bVar.b = tbImageView2;
                    ViewGroup.LayoutParams layoutParams2 = tbImageView2.getLayoutParams();
                    layoutParams2.height = this.b;
                    bVar.b.setLayoutParams(layoutParams2);
                    SkinManager.setBackgroundColor(bVar.b, R.color.CAM_X0201);
                    TbImageView tbImageView3 = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091a79);
                    bVar.c = tbImageView3;
                    ViewGroup.LayoutParams layoutParams3 = tbImageView3.getLayoutParams();
                    layoutParams3.height = this.b;
                    bVar.c.setLayoutParams(layoutParams3);
                    SkinManager.setBackgroundColor(bVar.c, R.color.CAM_X0201);
                    TbImageView tbImageView4 = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091a7a);
                    bVar.d = tbImageView4;
                    ViewGroup.LayoutParams layoutParams4 = tbImageView4.getLayoutParams();
                    layoutParams4.height = this.b;
                    bVar.d.setLayoutParams(layoutParams4);
                    SkinManager.setBackgroundColor(bVar.d, R.color.CAM_X0201);
                    view3.setTag(bVar);
                } else {
                    view3 = view2;
                    bVar = (b) view2.getTag();
                }
                c(i, bVar);
                return view3;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ EmotionPackageDetailActivity b;

        public a(EmotionPackageDetailActivity emotionPackageDetailActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = emotionPackageDetailActivity;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AndroidUtils.copyToClipboard(this.a.linkUrl);
                BdUtilHelper.showToast(this.b.getPageContext().getPageActivity(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionPackageDetailActivity emotionPackageDetailActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, Integer.valueOf(i)};
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
            this.a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable() && this.a.b != null && this.a.d != null && this.a.d.getVisibility() == 0) {
                this.a.d.setVisibility(8);
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                emotionPackageDetailActivity.showLoadingView(emotionPackageDetailActivity.c, false, BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f0703d5));
                this.a.b.T(this.a.D);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EmotionPackageDetailActivity emotionPackageDetailActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, Integer.valueOf(i)};
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
            this.a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921063 && this.a.C != null && this.a.w != null && this.a.u != null && this.a.m != null) {
                SkinManager.setImageResource(this.a.v, R.drawable.icon_bar_downloaded);
                this.a.w.setText(R.string.already_downloaded);
                SkinManager.setViewTextColor(this.a.w, (int) R.color.CAM_X0109);
                this.a.u.setEnabled(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                this.a.C.download++;
                this.a.m.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0f4b), StringHelper.numberUniform(this.a.C.download)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.a.C));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        public d(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionPackageDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends g4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        public f(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionPackageDetailActivity;
        }

        @Override // com.baidu.tieba.g4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                emotionPackageDetailActivity.hideLoadingView(emotionPackageDetailActivity.c);
                this.a.x.setVisibility(8);
                this.a.d.setVisibility(8);
                this.a.s.setVisibility(0);
                this.a.g.setVisibility(0);
                if (obj == null || !(obj instanceof EmotionPackageData)) {
                    BdUtilHelper.showToast(this.a.getActivity(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f4d));
                    this.a.d.setVisibility(0);
                    this.a.s.setVisibility(8);
                    this.a.g.setVisibility(8);
                    return;
                }
                this.a.C = (EmotionPackageData) obj;
                this.a.q.e(this.a.C.pics);
                this.a.i.setGifIconSupport(false);
                if (this.a.C.forum_id > 0) {
                    this.a.K.setVisibility(0);
                    this.a.o.startLoad(this.a.C.forum_avatar, 10, false);
                    this.a.p.setText(this.a.C.forum_name);
                } else {
                    this.a.o.startLoad(this.a.C.avatar, 10, false);
                    this.a.p.setText(this.a.C.author);
                }
                this.a.i.startLoad(this.a.C.cover, 10, false);
                this.a.k.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0f4e), Integer.valueOf(this.a.C.num)));
                this.a.m.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0f4b), StringHelper.numFormatOverWan(this.a.C.download)));
                this.a.n.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0f50), StringHelper.numFormatOverWan(this.a.C.share)));
                this.a.l.setText(this.a.C.name);
                if (this.a.C.owner != null && this.a.C.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.a.G.setVisibility(0);
                    if (this.a.C.status != 4 && this.a.C.status != 2) {
                        this.a.G.setEnabled(true);
                    } else {
                        this.a.G.setEnabled(false);
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.G, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                    }
                } else {
                    this.a.G.setVisibility(8);
                }
                if (this.a.C.status == 5 && this.a.C.forum_id > 0) {
                    this.a.t.setVisibility(0);
                    this.a.s.setVisibility(8);
                    this.a.m.setVisibility(8);
                    this.a.n.setVisibility(8);
                    int top = this.a.o.getTop();
                    float bottom = (this.a.m.getBottom() - this.a.l.getBottom()) + BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070207) + this.a.o.getHeight();
                    this.a.o.setY(bottom);
                    this.a.p.setY(bottom);
                    if (this.a.C.owner != null && this.a.C.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.a.z.setText(R.string.obfuscated_res_0x7f0f0f4c);
                        this.a.y.setVisibility(8);
                        this.a.G.setVisibility(8);
                        this.a.x.setVisibility(8);
                        SkinManager.setViewTextColor(this.a.z, (int) R.color.CAM_X0109);
                        this.a.t.setEnabled(false);
                    } else {
                        this.a.x.setVisibility(0);
                        TextView textView = this.a.x;
                        EmotionPackageDetailActivity emotionPackageDetailActivity2 = this.a;
                        textView.setText(emotionPackageDetailActivity2.O1(emotionPackageDetailActivity2.C.vote_num));
                        this.a.x.setY(top);
                        if (this.a.C.has_vote == 1) {
                            this.a.G1();
                        } else {
                            SkinManager.setBackgroundColor(this.a.r, R.color.CAM_X0204);
                        }
                    }
                }
                if (zy6.c().e("" + this.a.D)) {
                    this.a.w.setText(R.string.already_downloaded);
                    SkinManager.setViewTextColor(this.a.w, (int) R.color.CAM_X0109);
                    SkinManager.setImageResource(this.a.v, R.drawable.icon_bar_downloaded);
                    this.a.u.setEnabled(false);
                    return;
                }
                int i = this.a.C.status;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    this.a.u.setVisibility(8);
                                    return;
                                }
                                this.a.u.setVisibility(0);
                                SkinManager.setImageResource(this.a.v, R.drawable.icon_illegal_off);
                                SkinManager.setViewTextColor(this.a.w, (int) R.color.CAM_X0109);
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.G, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                                this.a.w.setText(R.string.obfuscated_res_0x7f0f0714);
                                this.a.u.setEnabled(false);
                                return;
                            }
                        } else {
                            this.a.u.setVisibility(0);
                            SkinManager.setImageResource(this.a.v, R.drawable.icon_illegal_off);
                            SkinManager.setViewTextColor(this.a.w, (int) R.color.CAM_X0109);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.G, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                            this.a.w.setText(R.string.obfuscated_res_0x7f0f0715);
                            this.a.u.setEnabled(false);
                            return;
                        }
                    } else {
                        this.a.u.setVisibility(0);
                        this.a.w.setText(R.string.obfuscated_res_0x7f0f05b6);
                        SkinManager.setViewTextColor(this.a.w, (int) R.color.CAM_X0302);
                        SkinManager.setImageResource(this.a.v, R.drawable.icon_bar_download);
                        this.a.u.setEnabled(true);
                        return;
                    }
                }
                this.a.u.setVisibility(0);
                this.a.w.setText(R.string.obfuscated_res_0x7f0f05b6);
                SkinManager.setViewTextColor(this.a.w, (int) R.color.CAM_X0302);
                SkinManager.setImageResource(this.a.v, R.drawable.icon_bar_download);
                this.a.u.setEnabled(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements EmotionPackageDetailModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        public g(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionPackageDetailActivity;
        }

        @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.d
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    SkinManager.setViewTextColor(this.a.w, (int) R.color.CAM_X0205);
                    this.a.w.setText(R.string.obfuscated_res_0x7f0f0f45);
                    SkinManager.setImageResource(this.a.v, R.drawable.icon_bar_downloaded);
                    this.a.u.setEnabled(false);
                    BdUtilHelper.showToast(this.a.getActivity(), (int) R.string.delete_success);
                    this.a.setResult(-1);
                    this.a.finish();
                    return;
                }
                BdUtilHelper.showToast(this.a.getActivity(), (int) R.string.delete_fail);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends g4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        public i(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionPackageDetailActivity;
        }

        @Override // com.baidu.tieba.g4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.L.getErrorCode() == 22) {
                    BdUtilHelper.showToast(this.a.getActivity(), (int) R.string.had_liked_forum);
                } else if (AntiHelper.m(this.a.L.getErrorCode(), this.a.L.getErrorString())) {
                    AntiHelper.u(this.a.getPageContext().getPageActivity(), this.a.L.getErrorString());
                } else if (this.a.L.getErrorCode() != 0) {
                    BdUtilHelper.showToast(this.a.getActivity(), this.a.L.getErrorString());
                    EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                    emotionPackageDetailActivity.showToast(emotionPackageDetailActivity.L.getErrorString());
                } else {
                    LikeReturnData likeReturnData = (LikeReturnData) obj;
                    if (likeReturnData != null) {
                        TbadkApplication.getInst().addLikeForum(this.a.C.forum_name);
                        likeReturnData.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
                    } else {
                        BdUtilHelper.showToast(this.a.getActivity(), (int) R.string.obfuscated_res_0x7f0f0e4f);
                    }
                }
                this.a.t.setEnabled(true);
                this.a.F.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(EmotionPackageDetailActivity emotionPackageDetailActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, Integer.valueOf(i)};
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
            this.a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof o07)) {
                o07 o07Var = (o07) customResponsedMessage.getData();
                int i = o07Var.a;
                if (i == 0) {
                    BdUtilHelper.showToast(this.a.getActivity(), (int) R.string.down_state_success);
                    SkinManager.setImageResource(this.a.v, R.drawable.icon_bar_downloaded);
                    this.a.w.setText(R.string.already_downloaded);
                    SkinManager.setViewTextColor(this.a.w, (int) R.color.CAM_X0109);
                    this.a.u.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                    this.a.C.download++;
                    this.a.m.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0f4b), StringHelper.numberUniform(this.a.C.download)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.a.C));
                } else if (i == 1) {
                    BdUtilHelper.showToast(this.a.getActivity(), (int) R.string.download_error);
                    this.a.u.setEnabled(true);
                } else if (i == 2) {
                    int i2 = o07Var.b;
                    if (i2 > 0 && i2 < 100) {
                        BdUtilHelper.showLongToast(this.a.getActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0f54));
                    } else if (i2 >= 100) {
                        BdUtilHelper.showLongToast(this.a.getActivity(), (int) R.string.down_state_success);
                    }
                }
            }
        }
    }

    public EmotionPackageDetailActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = TbConfig.TIEBA_ADDRESS + "n/interact/emoticonpackage/";
        this.O = new b(this, 2000994);
        this.P = new c(this, 2921063);
        this.Q = new f(this);
        this.R = new j(this, 2921375);
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
        if (this.D < 0) {
            return;
        }
        if (this.H == null) {
            this.H = new NewFaceGroupDownloadModel();
        }
        this.u.setEnabled(false);
        this.H.N(Integer.toString(this.D), Boolean.TRUE, null);
    }

    public final String N1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.N = i2;
            return String.format(getResources().getString(R.string.obfuscated_res_0x7f0f066a), String.valueOf(i2));
        }
        return (String) invokeI.objValue;
    }

    public final void R1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.t.setEnabled(false);
            this.b.U(i2, new h(this));
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.z.setText(R.string.obfuscated_res_0x7f0f0f53);
            SkinManager.setImageResource(this.y, R.drawable.icon_bar_voted);
            SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0109);
            this.t.setEnabled(false);
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.S(this.D, new g(this));
        }
    }

    public PackageDetailListView L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (PackageDetailListView) invokeV.objValue;
    }

    public SwipeBackLayout M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mSwipeBackLayout;
        }
        return (SwipeBackLayout) invokeV.objValue;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.b == null) {
                this.b = new EmotionPackageDetailModel();
            }
            this.b.setLoadDataCallBack(this.Q);
            this.b.T(this.D);
            this.N = 0;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            EmotionPackageDetailModel emotionPackageDetailModel = this.b;
            if (emotionPackageDetailModel != null) {
                emotionPackageDetailModel.cancelLoadData();
            }
            NewFaceGroupDownloadModel newFaceGroupDownloadModel = this.H;
            if (newFaceGroupDownloadModel != null) {
                newFaceGroupDownloadModel.cancelLoadData();
            }
            NewFaceGroupShareModel newFaceGroupShareModel = this.I;
            if (newFaceGroupShareModel != null) {
                newFaceGroupShareModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            p07 p07Var = this.M;
            if (p07Var != null) {
                p07Var.s();
            }
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.L == null) {
                this.L = new LikeModel(getPageContext());
            }
            this.L.setFrom("emotion_vote_follow");
            this.L.setLoadDataCallBack(new i(this));
            LikeModel likeModel = this.L;
            EmotionPackageData emotionPackageData = this.C;
            likeModel.f0(emotionPackageData.forum_name, String.valueOf(emotionPackageData.forum_id));
        }
    }

    public final String O1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            try {
                this.N = Integer.valueOf(str).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return String.format(getResources().getString(R.string.obfuscated_res_0x7f0f066a), str);
        }
        return (String) invokeL.objValue;
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0909f3);
            this.e = (NavigationBar) findViewById(R.id.navigation_bar);
            this.d = NoDataViewFactory.a(getPageContext().getPageActivity(), this.c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07038f)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0e78), null);
            SkinManager.setViewTextColor(this.e.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0f51)), (int) R.color.CAM_X0105);
            this.e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.G = new ImageView(getPageContext().getPageActivity());
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.G, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
            this.G.setPadding(0, BdUtilHelper.getDimens(this, R.dimen.obfuscated_res_0x7f0701d5), BdUtilHelper.getDimens(this, R.dimen.obfuscated_res_0x7f0703b9), BdUtilHelper.getDimens(this, R.dimen.obfuscated_res_0x7f0701d5));
            this.G.setLayoutParams(layoutParams);
            this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.G, new e(this));
            this.f = (NoNetworkView) findViewById(R.id.no_network_view);
            if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
            }
            this.f.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.g = (PackageDetailListView) findViewById(R.id.obfuscated_res_0x7f091a76);
            this.q = new k(this, null);
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d02ae, (ViewGroup) null);
            this.h = inflate;
            this.g.addHeaderView(inflate);
            this.i = (TbImageView) this.h.findViewById(R.id.obfuscated_res_0x7f0909f2);
            this.K = this.h.findViewById(R.id.obfuscated_res_0x7f0909f5);
            this.j = this.h.findViewById(R.id.obfuscated_res_0x7f090918);
            this.k = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0909c0);
            this.l = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0909f4);
            this.m = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f091a75);
            this.n = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f091a7b);
            this.x = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0909c7);
            HeadImageView headImageView = (HeadImageView) this.h.findViewById(R.id.obfuscated_res_0x7f091a71);
            this.o = headImageView;
            headImageView.setIsRound(true);
            this.o.setOnClickListener(this);
            TextView textView = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f091a72);
            this.p = textView;
            textView.setOnClickListener(this);
            this.g.setAdapter((ListAdapter) this.q);
            this.r = findViewById(R.id.obfuscated_res_0x7f09002b);
            this.s = findViewById(R.id.obfuscated_res_0x7f091a74);
            this.B = findViewById(R.id.obfuscated_res_0x7f0907ed);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0914fe);
            this.u = findViewById;
            findViewById.setOnClickListener(this);
            this.v = (ImageView) findViewById(R.id.obfuscated_res_0x7f091502);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f09150e);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f091f59);
            this.A = findViewById2;
            findViewById2.setOnClickListener(this);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f091a7c);
            this.t = findViewById3;
            findViewById3.setOnClickListener(this);
            this.y = (ImageView) findViewById(R.id.obfuscated_res_0x7f0929db);
            this.z = (TextView) findViewById(R.id.obfuscated_res_0x7f0929ec);
            this.M = new p07(this);
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
            if (this.C == null) {
                return;
            }
            ShareItem shareItem = new ShareItem();
            shareItem.title = this.C.name;
            shareItem.content = getString(R.string.obfuscated_res_0x7f0f0f55);
            shareItem.linkUrl = this.a + this.D;
            shareItem.imageUri = Uri.parse(this.C.cover);
            shareItem.isFromEmotionPackage = true;
            this.J = shareItem.linkUrl;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 24007 && !TextUtils.isEmpty(this.J) && this.J.contains("emoticonpackage") && (split = this.J.split("/")) != null && split.length > 0 && intent.getIntExtra("extra_share_status", 2) == 1) {
                String str = split[split.length - 1];
                if (this.I == null) {
                    this.I = new NewFaceGroupShareModel();
                }
                this.I.N(str);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSkinType = i2;
            BDLayoutMode layoutMode = getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            getLayoutMode().onModeChanged(this.c);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0304);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
            if (i2 == 4) {
                SkinManager.setBackgroundColor(this.s, R.color.common_color_10311, i2);
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201_2, i2);
            } else {
                SkinManager.setBackgroundColor(this.s, R.color.white_alpha100, i2);
            }
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0205);
            NoDataView noDataView = this.d;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            p07 p07Var = this.M;
            if (p07Var != null) {
                p07Var.y(i2);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            super.onClick(view2);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                return;
            }
            if (view2 == this.u) {
                K1();
            } else if (view2 == this.A) {
                Q1();
            } else if (view2 != this.o && view2 != this.p) {
                if (view2 == this.t) {
                    R1(this.D);
                }
            } else {
                EmotionPackageData emotionPackageData = this.C;
                if (emotionPackageData != null && !TextUtils.isEmpty(emotionPackageData.owner)) {
                    if (this.C.forum_id > 0) {
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.C.forum_name, null)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(JavaTypesHelper.toLong(this.C.owner, 0L), this.C.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            int intExtra = getIntent().getIntExtra("pck_id", -1);
            this.D = intExtra;
            if (intExtra < 0) {
                finish();
                return;
            }
            setContentView(R.layout.obfuscated_res_0x7f0d02ad);
            P1();
            showLoadingView(this.c, false, BdUtilHelper.getDimens(this, R.dimen.obfuscated_res_0x7f0703d5));
            initData();
            registerListener(this.O);
            registerListener(this.P);
            registerListener(this.R);
            TiebaStatic.log("c12330");
        }
    }
}
