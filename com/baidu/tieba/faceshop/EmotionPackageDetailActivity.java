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
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tieba.c9;
import com.baidu.tieba.dc6;
import com.baidu.tieba.ec6;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.EmotionPackageDetailModel;
import com.baidu.tieba.faceshop.packagedetail.PackageDetailListView;
import com.baidu.tieba.gi;
import com.baidu.tieba.hk8;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupShareModel;
import com.baidu.tieba.oa6;
import com.baidu.tieba.pg;
import com.baidu.tieba.pi;
import com.baidu.tieba.ri;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.vr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionPackageDetailActivity extends BaseActivity<EmotionPackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public EmotionPackageData B;
    public int C;
    public vr4 D;
    public vr4 E;
    public ImageView F;
    public NewFaceGroupDownloadModel G;
    public NewFaceGroupShareModel H;
    public String I;
    public View J;
    public LikeModel K;
    public ec6 L;
    public int M;
    public final CustomMessageListener N;
    public final CustomMessageListener O;
    public c9 P;
    public CustomMessageListener Q;
    public EmotionPackageDetailModel a;
    public RelativeLayout b;
    public NoDataView c;
    public NavigationBar d;
    public NoNetworkView e;
    public PackageDetailListView f;
    public View g;
    public TbImageView h;
    public View i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public HeadImageView n;
    public TextView o;
    public k p;
    public View q;
    public View r;
    public View s;
    public View t;
    public ImageView u;
    public TextView v;
    public TextView w;
    public ImageView x;
    public TextView y;
    public View z;

    /* loaded from: classes4.dex */
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
                gi.a(this.a.w);
                ri.N(this.b.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0451));
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && pi.z() && this.a.a != null && this.a.c != null && this.a.c.getVisibility() == 0) {
                this.a.c.setVisibility(8);
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                emotionPackageDetailActivity.showLoadingView(emotionPackageDetailActivity.b, false, ri.f(this.a, R.dimen.obfuscated_res_0x7f0702bb));
                this.a.a.F(this.a.C);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage.getCmd() != 2921063 || this.a.B == null || this.a.v == null || this.a.t == null || this.a.l == null) {
                return;
            }
            SkinManager.setImageResource(this.a.u, R.drawable.icon_bar_downloaded);
            this.a.v.setText(R.string.obfuscated_res_0x7f0f027a);
            SkinManager.setViewTextColor(this.a.v, (int) R.color.CAM_X0109);
            this.a.t.setEnabled(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            this.a.B.download++;
            this.a.l.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d26), StringHelper.numberUniform(this.a.B.download)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.a.B));
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* loaded from: classes4.dex */
        public class a implements vr4.e {
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

            @Override // com.baidu.tieba.vr4.e
            public void onClick(vr4 vr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                    this.a.a.l2();
                    vr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements vr4.e {
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

            @Override // com.baidu.tieba.vr4.e
            public void onClick(vr4 vr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                    vr4Var.dismiss();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && pi.z()) {
                if (this.a.D == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                    emotionPackageDetailActivity.D = new vr4(emotionPackageDetailActivity.getPageContext().getPageActivity());
                    this.a.D.setMessageId(R.string.obfuscated_res_0x7f0f0d24);
                    this.a.D.setPositiveButton(R.string.obfuscated_res_0x7f0f0d25, new a(this));
                    this.a.D.setNegativeButton(R.string.obfuscated_res_0x7f0f04ea, new b(this));
                    this.a.D.setCancelable(true);
                    this.a.D.create(this.a.getPageContext());
                }
                this.a.D.show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends c9 {
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

        @Override // com.baidu.tieba.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                emotionPackageDetailActivity.hideLoadingView(emotionPackageDetailActivity.b);
                this.a.w.setVisibility(8);
                this.a.c.setVisibility(8);
                this.a.r.setVisibility(0);
                this.a.f.setVisibility(0);
                if (obj != null && (obj instanceof EmotionPackageData)) {
                    this.a.B = (EmotionPackageData) obj;
                    this.a.p.e(this.a.B.pics);
                    this.a.h.setGifIconSupport(false);
                    if (this.a.B.forum_id > 0) {
                        this.a.J.setVisibility(0);
                        this.a.n.K(this.a.B.forum_avatar, 10, false);
                        this.a.o.setText(this.a.B.forum_name);
                    } else {
                        this.a.n.K(this.a.B.avatar, 10, false);
                        this.a.o.setText(this.a.B.author);
                    }
                    this.a.h.K(this.a.B.cover, 10, false);
                    this.a.j.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d29), Integer.valueOf(this.a.B.num)));
                    this.a.l.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d26), StringHelper.numFormatOverWan(this.a.B.download)));
                    this.a.m.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d2b), StringHelper.numFormatOverWan(this.a.B.share)));
                    this.a.k.setText(this.a.B.name);
                    if (this.a.B.owner == null || !this.a.B.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.a.F.setVisibility(8);
                    } else {
                        this.a.F.setVisibility(0);
                        if (this.a.B.status == 4 || this.a.B.status == 2) {
                            this.a.F.setEnabled(false);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.F, R.drawable.obfuscated_res_0x7f0809f9, R.color.white_alpha100, null);
                        } else {
                            this.a.F.setEnabled(true);
                        }
                    }
                    if (this.a.B.status == 5 && this.a.B.forum_id > 0) {
                        this.a.s.setVisibility(0);
                        this.a.r.setVisibility(8);
                        this.a.l.setVisibility(8);
                        this.a.m.setVisibility(8);
                        int top = this.a.n.getTop();
                        float bottom = (this.a.l.getBottom() - this.a.k.getBottom()) + ri.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070207) + this.a.n.getHeight();
                        this.a.n.setY(bottom);
                        this.a.o.setY(bottom);
                        if (this.a.B.owner == null || !this.a.B.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                            this.a.w.setVisibility(0);
                            TextView textView = this.a.w;
                            EmotionPackageDetailActivity emotionPackageDetailActivity2 = this.a;
                            textView.setText(emotionPackageDetailActivity2.r2(emotionPackageDetailActivity2.B.vote_num));
                            this.a.w.setY(top);
                            if (this.a.B.has_vote == 1) {
                                this.a.k2();
                            } else {
                                SkinManager.setBackgroundColor(this.a.q, R.color.CAM_X0204);
                            }
                        } else {
                            this.a.y.setText(R.string.obfuscated_res_0x7f0f0d27);
                            this.a.x.setVisibility(8);
                            this.a.F.setVisibility(8);
                            this.a.w.setVisibility(8);
                            SkinManager.setViewTextColor(this.a.y, (int) R.color.CAM_X0109);
                            this.a.s.setEnabled(false);
                        }
                    }
                    if (oa6.c().e("" + this.a.C)) {
                        this.a.v.setText(R.string.obfuscated_res_0x7f0f027a);
                        SkinManager.setViewTextColor(this.a.v, (int) R.color.CAM_X0109);
                        SkinManager.setImageResource(this.a.u, R.drawable.icon_bar_downloaded);
                        this.a.t.setEnabled(false);
                        return;
                    }
                    int i = this.a.B.status;
                    if (i != 0) {
                        if (i == 1) {
                            this.a.t.setVisibility(0);
                            this.a.v.setText(R.string.obfuscated_res_0x7f0f04fd);
                            SkinManager.setViewTextColor(this.a.v, (int) R.color.CAM_X0302);
                            SkinManager.setImageResource(this.a.u, R.drawable.icon_bar_download);
                            this.a.t.setEnabled(true);
                            return;
                        } else if (i == 2) {
                            this.a.t.setVisibility(0);
                            SkinManager.setImageResource(this.a.u, R.drawable.icon_illegal_off);
                            SkinManager.setViewTextColor(this.a.v, (int) R.color.CAM_X0109);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.F, R.drawable.obfuscated_res_0x7f0809f9, R.color.white_alpha100, null);
                            this.a.v.setText(R.string.obfuscated_res_0x7f0f05fa);
                            this.a.t.setEnabled(false);
                            return;
                        } else if (i != 3) {
                            if (i != 4) {
                                this.a.t.setVisibility(8);
                                return;
                            }
                            this.a.t.setVisibility(0);
                            SkinManager.setImageResource(this.a.u, R.drawable.icon_illegal_off);
                            SkinManager.setViewTextColor(this.a.v, (int) R.color.CAM_X0109);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.F, R.drawable.obfuscated_res_0x7f0809f9, R.color.white_alpha100, null);
                            this.a.v.setText(R.string.obfuscated_res_0x7f0f05f9);
                            this.a.t.setEnabled(false);
                            return;
                        }
                    }
                    this.a.t.setVisibility(0);
                    this.a.v.setText(R.string.obfuscated_res_0x7f0f04fd);
                    SkinManager.setViewTextColor(this.a.v, (int) R.color.CAM_X0302);
                    SkinManager.setImageResource(this.a.u, R.drawable.icon_bar_download);
                    this.a.t.setEnabled(true);
                    return;
                }
                ri.N(this.a.getActivity(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d28));
                this.a.c.setVisibility(0);
                this.a.r.setVisibility(8);
                this.a.f.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    SkinManager.setViewTextColor(this.a.v, (int) R.color.CAM_X0205);
                    this.a.v.setText(R.string.obfuscated_res_0x7f0f0d20);
                    SkinManager.setImageResource(this.a.u, R.drawable.icon_bar_downloaded);
                    this.a.t.setEnabled(false);
                    ri.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04ba);
                    this.a.setResult(-1);
                    this.a.finish();
                    return;
                }
                ri.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04b1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements EmotionPackageDetailModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* loaded from: classes4.dex */
        public class a implements vr4.e {
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

            @Override // com.baidu.tieba.vr4.e
            public void onClick(vr4 vr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                    vr4Var.dismiss();
                    this.a.a.s.setEnabled(true);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements vr4.e {
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

            @Override // com.baidu.tieba.vr4.e
            public void onClick(vr4 vr4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) || this.a.a.B == null || TextUtils.isEmpty(this.a.a.B.forum_name)) {
                    return;
                }
                this.a.a.m2();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage.getError() == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921062, this.a.B));
                this.a.k2();
                if (this.a.w != null && this.a.w.isShown()) {
                    TextView textView = this.a.w;
                    EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                    textView.setText(emotionPackageDetailActivity.q2(emotionPackageDetailActivity.M + 1));
                }
                ri.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0d34);
            } else if (httpResponsedMessage.getError() == 170003) {
                if (this.a.E == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity2 = this.a;
                    emotionPackageDetailActivity2.E = new vr4(emotionPackageDetailActivity2.getPageContext().getPageActivity());
                    this.a.E.setMessageId(R.string.obfuscated_res_0x7f0f0d23);
                    this.a.E.setNegativeButton(R.string.obfuscated_res_0x7f0f0d21, new a(this));
                    this.a.E.setPositiveButton(R.string.obfuscated_res_0x7f0f0d22, new b(this));
                    this.a.E.create(this.a.getPageContext());
                    this.a.E.setCancelable(true);
                }
                this.a.E.show();
            } else {
                this.a.s.setEnabled(true);
                if (httpResponsedMessage.getErrorString() == null) {
                    errorString = this.a.getString(R.string.obfuscated_res_0x7f0f0d33);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                ri.N(this.a.getActivity(), errorString);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends c9 {
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

        @Override // com.baidu.tieba.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.K.getErrorCode() != 22) {
                    if (AntiHelper.m(this.a.K.getErrorCode(), this.a.K.getErrorString())) {
                        AntiHelper.u(this.a.getPageContext().getPageActivity(), this.a.K.getErrorString());
                    } else if (this.a.K.getErrorCode() != 0) {
                        ri.N(this.a.getActivity(), this.a.K.getErrorString());
                        EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                        emotionPackageDetailActivity.showToast(emotionPackageDetailActivity.K.getErrorString());
                    } else {
                        hk8 hk8Var = (hk8) obj;
                        if (hk8Var != null) {
                            TbadkApplication.getInst().addLikeForum(this.a.B.forum_name);
                            hk8Var.x(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, hk8Var));
                        } else {
                            ri.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0c40);
                        }
                    }
                } else {
                    ri.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0828);
                }
                this.a.s.setEnabled(true);
                this.a.E.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof dc6)) {
                dc6 dc6Var = (dc6) customResponsedMessage.getData();
                int i = dc6Var.a;
                if (i == 0) {
                    ri.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04fc);
                    SkinManager.setImageResource(this.a.u, R.drawable.icon_bar_downloaded);
                    this.a.v.setText(R.string.obfuscated_res_0x7f0f027a);
                    SkinManager.setViewTextColor(this.a.v, (int) R.color.CAM_X0109);
                    this.a.t.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                    this.a.B.download++;
                    this.a.l.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d26), StringHelper.numberUniform(this.a.B.download)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.a.B));
                } else if (i == 1) {
                    ri.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0501);
                    this.a.t.setEnabled(true);
                } else if (i == 2) {
                    int i2 = dc6Var.b;
                    if (i2 > 0 && i2 < 100) {
                        ri.K(this.a.getActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0d2f));
                    } else if (i2 >= 100) {
                        ri.J(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04fc);
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
        this.N = new b(this, 2000994);
        this.O = new c(this, 2921063);
        this.P = new f(this);
        this.Q = new j(this, 2921375);
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == null) {
                this.a = new EmotionPackageDetailModel();
            }
            this.a.setLoadDataCallBack(this.P);
            this.a.F(this.C);
            this.M = 0;
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.y.setText(R.string.obfuscated_res_0x7f0f0d2e);
            SkinManager.setImageResource(this.x, R.drawable.icon_bar_voted);
            SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0109);
            this.s.setEnabled(false);
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.E(this.C, new g(this));
        }
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.K == null) {
                this.K = new LikeModel(getPageContext());
            }
            this.K.setFrom("emotion_vote_follow");
            this.K.setLoadDataCallBack(new i(this));
            LikeModel likeModel = this.K;
            EmotionPackageData emotionPackageData = this.B;
            likeModel.Q(emotionPackageData.forum_name, String.valueOf(emotionPackageData.forum_id));
        }
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.C < 0) {
                return;
            }
            if (this.G == null) {
                this.G = new NewFaceGroupDownloadModel();
            }
            this.t.setEnabled(false);
            this.G.z(Integer.toString(this.C), Boolean.TRUE, null);
        }
    }

    public PackageDetailListView o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (PackageDetailListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 24007 && !TextUtils.isEmpty(this.I) && this.I.contains("emoticonpackage") && (split = this.I.split("/")) != null && split.length > 0 && intent.getIntExtra("extra_share_status", 2) == 1) {
                String str = split[split.length - 1];
                if (this.H == null) {
                    this.H = new NewFaceGroupShareModel();
                }
                this.H.z(str);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSkinType = i2;
            getLayoutMode().l(i2 == 1);
            getLayoutMode().k(this.b);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0304);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
            if (i2 != 1 && i2 != 4) {
                SkinManager.setBackgroundColor(this.r, R.color.white_alpha100, i2);
            } else {
                SkinManager.setBackgroundColor(this.r, R.color.common_color_10311, i2);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0201_1, i2);
            }
            SkinManager.setBackgroundColor(this.A, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
            NoDataView noDataView = this.c;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            ec6 ec6Var = this.L;
            if (ec6Var != null) {
                ec6Var.y(i2);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            super.onClick(view2);
            if (pi.z()) {
                if (view2 == this.t) {
                    n2();
                } else if (view2 == this.z) {
                    t2();
                } else if (view2 != this.n && view2 != this.o) {
                    if (view2 == this.s) {
                        u2(this.C);
                    }
                } else {
                    EmotionPackageData emotionPackageData = this.B;
                    if (emotionPackageData == null || TextUtils.isEmpty(emotionPackageData.owner)) {
                        return;
                    }
                    if (this.B.forum_id > 0) {
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.B.forum_name, null)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(pg.g(this.B.owner, 0L), this.B.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            int intExtra = getIntent().getIntExtra("pck_id", -1);
            this.C = intExtra;
            if (intExtra < 0) {
                finish();
                return;
            }
            setContentView(R.layout.obfuscated_res_0x7f0d025c);
            s2();
            showLoadingView(this.b, false, ri.f(this, R.dimen.obfuscated_res_0x7f0702bb));
            initData();
            registerListener(this.N);
            registerListener(this.O);
            registerListener(this.Q);
            TiebaStatic.log("c12330");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            EmotionPackageDetailModel emotionPackageDetailModel = this.a;
            if (emotionPackageDetailModel != null) {
                emotionPackageDetailModel.cancelLoadData();
            }
            NewFaceGroupDownloadModel newFaceGroupDownloadModel = this.G;
            if (newFaceGroupDownloadModel != null) {
                newFaceGroupDownloadModel.cancelLoadData();
            }
            NewFaceGroupShareModel newFaceGroupShareModel = this.H;
            if (newFaceGroupShareModel != null) {
                newFaceGroupShareModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            ec6 ec6Var = this.L;
            if (ec6Var != null) {
                ec6Var.s();
            }
        }
    }

    public SwipeBackLayout p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mSwipeBackLayout : (SwipeBackLayout) invokeV.objValue;
    }

    public final String q2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.M = i2;
            return String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0570), String.valueOf(i2));
        }
        return (String) invokeI.objValue;
    }

    public final String r2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            try {
                this.M = Integer.valueOf(str).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0570), str);
        }
        return (String) invokeL.objValue;
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0908b5);
            this.d = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091626);
            this.c = NoDataViewFactory.a(getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07026c)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c61), null);
            SkinManager.setViewTextColor(this.d.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0d2c)), (int) R.color.CAM_X0105);
            this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.F = new ImageView(getPageContext().getPageActivity());
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.F, R.drawable.obfuscated_res_0x7f0809f9, R.color.white_alpha100, null);
            this.F.setPadding(0, ri.f(this, R.dimen.obfuscated_res_0x7f0701d5), ri.f(this, R.dimen.obfuscated_res_0x7f07029b), ri.f(this, R.dimen.obfuscated_res_0x7f0701d5));
            this.F.setLayoutParams(layoutParams);
            this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.F, new e(this));
            this.e = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f0916a7);
            if (pi.A()) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
            this.e.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f = (PackageDetailListView) findViewById(R.id.obfuscated_res_0x7f091751);
            this.p = new k(this, null);
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d025d, (ViewGroup) null);
            this.g = inflate;
            this.f.addHeaderView(inflate);
            this.h = (TbImageView) this.g.findViewById(R.id.obfuscated_res_0x7f0908b4);
            this.J = this.g.findViewById(R.id.obfuscated_res_0x7f0908b7);
            this.i = this.g.findViewById(R.id.obfuscated_res_0x7f0907f7);
            this.j = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090883);
            this.k = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0908b6);
            this.l = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091750);
            this.m = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091756);
            this.w = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f09088a);
            HeadImageView headImageView = (HeadImageView) this.g.findViewById(R.id.obfuscated_res_0x7f09174c);
            this.n = headImageView;
            headImageView.setIsRound(true);
            this.n.setOnClickListener(this);
            TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f09174d);
            this.o = textView;
            textView.setOnClickListener(this);
            this.f.setAdapter((ListAdapter) this.p);
            this.q = findViewById(R.id.obfuscated_res_0x7f090027);
            this.r = findViewById(R.id.obfuscated_res_0x7f09174f);
            this.A = findViewById(R.id.obfuscated_res_0x7f0906e6);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0912b2);
            this.t = findViewById;
            findViewById.setOnClickListener(this);
            this.u = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912b5);
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f0912be);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f091bf1);
            this.z = findViewById2;
            findViewById2.setOnClickListener(this);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f091757);
            this.s = findViewById3;
            findViewById3.setOnClickListener(this);
            this.x = (ImageView) findViewById(R.id.obfuscated_res_0x7f0925cc);
            this.y = (TextView) findViewById(R.id.obfuscated_res_0x7f0925dd);
            this.L = new ec6(this);
        }
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
            if (this.B == null) {
                return;
            }
            ShareItem shareItem = new ShareItem();
            shareItem.u = this.B.name;
            shareItem.v = getString(R.string.obfuscated_res_0x7f0f0d30);
            shareItem.w = "https://tieba.baidu.com/n/interact/emoticonpackage/" + this.C;
            shareItem.y = Uri.parse(this.B.cover);
            shareItem.o = true;
            this.I = shareItem.w;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public final void u2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.s.setEnabled(false);
            this.a.G(i2, new h(this));
        }
    }

    /* loaded from: classes4.dex */
    public class k extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<EmotionPackageData.SingleEmotionData> a;
        public int b;
        public final /* synthetic */ EmotionPackageDetailActivity c;

        /* loaded from: classes4.dex */
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (singleEmotionData = (EmotionPackageData.SingleEmotionData) this.c.a.get(this.a)) == null || singleEmotionData.id < 0 || this.c.c.C < 0 || !pi.z()) {
                    return;
                }
                EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(this.c.c.getPageContext().getPageActivity(), this.c.c.C, singleEmotionData.id, this.b.w());
                emotionDetailActivityConfig.setFromEmotionPackage(true);
                this.c.c.sendMessage(new CustomMessage(2002001, emotionDetailActivityConfig));
            }
        }

        /* loaded from: classes4.dex */
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
            this.b = (ri.k(TbadkCoreApplication.getInst()) - ri.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07027e)) / 4;
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
                            a2.setDefaultResource(R.drawable.obfuscated_res_0x7f080bc3);
                            a2.K(this.a.get(i3).thumbnail, 10, false);
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

        public final void e(List<EmotionPackageData.SingleEmotionData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
                return;
            }
            this.a.clear();
            this.a.addAll(new ArrayList(list));
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int size = this.a.size() / 4;
                return this.a.size() % 4 > 0 ? size + 1 : size;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
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
                    view3 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d0682, viewGroup, false);
                    TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091752);
                    bVar.a = tbImageView;
                    ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                    layoutParams.height = this.b;
                    bVar.a.setLayoutParams(layoutParams);
                    SkinManager.setBackgroundColor(bVar.a, R.color.CAM_X0201);
                    TbImageView tbImageView2 = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091753);
                    bVar.b = tbImageView2;
                    ViewGroup.LayoutParams layoutParams2 = tbImageView2.getLayoutParams();
                    layoutParams2.height = this.b;
                    bVar.b.setLayoutParams(layoutParams2);
                    SkinManager.setBackgroundColor(bVar.b, R.color.CAM_X0201);
                    TbImageView tbImageView3 = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091754);
                    bVar.c = tbImageView3;
                    ViewGroup.LayoutParams layoutParams3 = tbImageView3.getLayoutParams();
                    layoutParams3.height = this.b;
                    bVar.c.setLayoutParams(layoutParams3);
                    SkinManager.setBackgroundColor(bVar.c, R.color.CAM_X0201);
                    TbImageView tbImageView4 = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091755);
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

        public /* synthetic */ k(EmotionPackageDetailActivity emotionPackageDetailActivity, b bVar) {
            this(emotionPackageDetailActivity);
        }
    }
}
