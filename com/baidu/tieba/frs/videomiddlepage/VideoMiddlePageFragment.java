package com.baidu.tieba.frs.videomiddlepage;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.d.n.e.q;
import c.a.t0.e1.b3.h;
import c.a.t0.e1.b3.i;
import c.a.t0.e1.t1.g;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes12.dex */
public class VideoMiddlePageFragment extends BaseFragment implements h, c.a.t0.e1.b3.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_PAUSE = 1;
    public static final int STATE_RESUME = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public CustomMessageListener G;
    public CustomMessageListener H;
    public CustomMessageListener I;
    public RecyclerView.OnScrollListener J;
    public CustomMessageListener K;

    /* renamed from: e  reason: collision with root package name */
    public i f43792e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayoutManager f43793f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f43794g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f43795h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.e1.b3.f f43796i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f43797j;
    public NavigationBar k;
    public View l;
    public ImageView m;
    public PbListView n;
    public View o;
    public int p;
    public boolean q;
    public NoNetworkView r;
    public String s;
    public List<BaseCardInfo> t;
    public c.a.s0.s.k0.a u;
    public int v;
    public c.a.t0.e1.b3.d w;
    public boolean x;
    public String y;
    public boolean z;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoMiddlePageFragment videoMiddlePageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment, Integer.valueOf(i2)};
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
            this.a = videoMiddlePageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921317 || customResponsedMessage.getmOrginalMessage() == null || customResponsedMessage.getmOrginalMessage().getExtra() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getmOrginalMessage().getExtra();
            if (this.a.m != null) {
                if ("low".equals(str)) {
                    this.a.m.setAlpha(0.2f);
                } else if ("high".equals(str)) {
                    this.a.m.setAlpha(1.0f);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoMiddlePageFragment videoMiddlePageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment, Integer.valueOf(i2)};
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
            this.a = videoMiddlePageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (l.z()) {
                    if (this.a.r != null) {
                        this.a.r.setVisibility(8);
                    }
                    if (!l.x() || c.a.t0.k4.h.c().d()) {
                        return;
                    }
                    if (this.a.f43796i == null || !this.a.f43796i.k()) {
                        if (this.a.f43796i == null || !this.a.f43796i.n()) {
                            return;
                        }
                        this.a.getPageContext().showToast(R.string.video_mobile_play_tips);
                        return;
                    }
                    this.a.getPageContext().showToast(R.string.video_mobile_play_tips);
                } else if (this.a.r != null) {
                    this.a.r.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(VideoMiddlePageFragment videoMiddlePageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment, Integer.valueOf(i2)};
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
            this.a = videoMiddlePageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && this.a.f43796i != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.a) {
                this.a.f43796i.o(data.f40771c, data.f40772d);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageFragment f43798e;

        public d(VideoMiddlePageFragment videoMiddlePageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43798e = videoMiddlePageFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f43798e.getPageContext().getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageFragment f43799e;

        public e(VideoMiddlePageFragment videoMiddlePageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43799e = videoMiddlePageFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageFragment a;

        public f(VideoMiddlePageFragment videoMiddlePageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && (recyclerView instanceof BdTypeRecyclerView)) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                this.a.p = i2;
                if (i2 != 0) {
                    if (i2 == 1) {
                        this.a.m.setAlpha(1.0f);
                        return;
                    }
                    return;
                }
                if (bdTypeRecyclerView.getLastVisiblePosition() > bdTypeRecyclerView.getCount() - 2 && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                    this.a.f43792e.h(this.a.s);
                    this.a.f43792e.f();
                }
                this.a.o(bdTypeRecyclerView);
                c.a.t0.w3.c.g().h(this.a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) && (recyclerView instanceof BdTypeRecyclerView)) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (this.a.f43796i != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > this.a.f43796i.g() || bdTypeRecyclerView.getLastVisiblePosition() < this.a.f43796i.g()) {
                        this.a.f43796i.e();
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(VideoMiddlePageFragment videoMiddlePageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment, Integer.valueOf(i2)};
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
            this.a = videoMiddlePageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f43796i == null) {
                return;
            }
            this.a.f43796i.p();
        }
    }

    public VideoMiddlePageFragment() {
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
        this.f43797j = true;
        this.v = -1;
        this.x = false;
        this.z = false;
        this.D = 4;
        this.E = 7;
        this.F = 4;
        this.G = new a(this, 2921317);
        this.H = new b(this, 2000994);
        this.I = new c(this, 2001115);
        this.J = new f(this);
        this.K = new g(this, 2921414);
        this.A = new HashMap();
    }

    public static VideoMiddlePageFragment getInstance(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("PARAM_FROM", str);
            bundle.putString("PARAM_FID", str2);
            VideoMiddlePageFragment videoMiddlePageFragment = new VideoMiddlePageFragment();
            videoMiddlePageFragment.setArguments(bundle);
            return videoMiddlePageFragment;
        }
        return (VideoMiddlePageFragment) invokeLL.objValue;
    }

    public c.a.t0.e1.b3.a getCurrentPlayCardView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.t0.e1.b3.f fVar = this.f43796i;
            if (fVar != null) {
                return fVar.f();
            }
            return null;
        }
        return (c.a.t0.e1.b3.a) invokeV.objValue;
    }

    public int getVisibilityPercents(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            int height = view.getHeight();
            if (rect.top == 0 && rect.bottom == height) {
                return 100;
            }
            int i2 = rect.top;
            if (i2 > 0) {
                return ((height - i2) * 100) / height;
            }
            int i3 = rect.bottom;
            if (i3 <= 0 || i3 >= height) {
                return 100;
            }
            return (i3 * 100) / height;
        }
        return invokeL.intValue;
    }

    @Override // c.a.t0.e1.b3.h
    public void hideLoadingView() {
        c.a.s0.s.k0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.u) == null) {
            return;
        }
        aVar.h(false);
    }

    public final int l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = i2 + 1;
            int i4 = this.D;
            int i5 = 1;
            if (i3 > i4 - 1) {
                int i6 = i3 - (i4 - 1);
                if (i6 >= i4 - 1) {
                    i5 = 1 + (i6 % (this.E - 1));
                }
            } else {
                i5 = 0;
            }
            return i5 + i2;
        }
        return invokeI.intValue;
    }

    public final boolean n(c.a.t0.e1.t1.g gVar) {
        InterceptResult invokeL;
        i iVar;
        VideoSerializeVideoThreadInfo e2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) ? (!"0".equals(gVar.f16923f) || (iVar = this.f43792e) == null || iVar.e() == null || (e2 = this.f43792e.e()) == null || e2.video == null || !TextUtils.equals(e2.title, gVar.x) || !TextUtils.equals(e2.video.videoUrl, gVar.getVideoUrl())) ? false : true : invokeL.booleanValue;
    }

    public void notifyVideo(int i2) {
        c.a.t0.e1.b3.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f43794g == null || (fVar = this.f43796i) == null) {
            return;
        }
        if (i2 == 1) {
            if (fVar.n()) {
                this.f43796i.z();
            } else if (this.f43796i.k()) {
                this.f43796i.A();
            }
        }
        if (i2 == 2) {
            this.f43796i.A();
            if (this.f43796i.n()) {
                this.f43796i.v();
            }
        }
    }

    public final void o(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdTypeRecyclerView) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition() - bdTypeRecyclerView.getHeaderViewsCount();
            int i2 = 0;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            if (bdTypeRecyclerView.getChildCount() > 0 && ((bdTypeRecyclerView.getChildAt(0) instanceof RelativeLayout) || (bdTypeRecyclerView.getChildAt(0) instanceof c.a.t0.y1.o.l.e))) {
                i2 = getVisibilityPercents(bdTypeRecyclerView.getChildAt(0));
            } else if (bdTypeRecyclerView.getChildCount() > 1) {
                i2 = getVisibilityPercents(bdTypeRecyclerView.getChildAt(1));
            }
            if (!this.f43796i.m(firstVisiblePosition) || i2 < 95) {
                firstVisiblePosition += this.f43796i.i(firstVisiblePosition);
            }
            this.f43796i.d(firstVisiblePosition);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.r.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                z = !this.q;
                this.q = true;
                this.k.setVisibility(8);
                this.B = this.f43794g.getFirstVisiblePosition();
                View childAt = this.f43794g.getChildAt(0);
                this.C = childAt != null ? childAt.getTop() : 0;
            } else {
                z = this.q;
                this.q = false;
                this.k.setVisibility(0);
            }
            c.a.t0.e1.b3.f fVar = this.f43796i;
            if (fVar != null) {
                fVar.q(configuration);
            }
            if (!z || this.q || getCurrentPlayCardView() == null || this.B == this.f43794g.getFirstVisiblePosition()) {
                return;
            }
            ((LinearLayoutManager) this.f43794g.getLayoutManager()).scrollToPositionWithOffset(this.B, this.C);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.t0.w3.c.g().i(getUniqueId());
            this.f43792e = new i(this);
            Intent intent = getPageContext().getPageActivity().getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra("PARAM_FID");
                String stringExtra2 = intent.getStringExtra("st_type");
                String stringExtra3 = intent.getStringExtra("yuelaou_locate");
                this.f43792e.i(stringExtra);
                this.f43792e.j(stringExtra3);
                this.f43792e.k(stringExtra2);
                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra("param_video_thread_info");
                if (videoSerializeVideoThreadInfo != null) {
                    this.A.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                    this.A.put("thread_id", videoSerializeVideoThreadInfo.threadId);
                }
                this.f43792e.l(videoSerializeVideoThreadInfo);
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.s = arguments.getString("PARAM_FROM");
                this.y = arguments.getString("PARAM_FID");
            }
            i iVar = this.f43792e;
            if (iVar != null) {
                iVar.h(this.s);
                this.f43792e.g();
            }
            registerListener(this.H);
            registerListener(this.I);
            registerListener(this.G);
            registerListener(this.K);
            new c.a.t0.i4.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) ? layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false) : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            c.a.t0.w3.c.g().k(getUniqueId());
            i iVar = this.f43792e;
            if (iVar != null) {
                iVar.c();
            }
            c.a.t0.e1.b3.f fVar = this.f43796i;
            if (fVar != null) {
                fVar.r();
            }
            c.a.t0.e1.b3.d dVar = this.w;
            if (dVar != null) {
                dVar.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f43794g.getPreLoadHandle() : (q) invokeV.objValue;
    }

    public boolean onKeyDown(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            c.a.t0.e1.b3.f fVar = this.f43796i;
            if (fVar == null) {
                return false;
            }
            return fVar.s(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // c.a.t0.e1.b3.h
    public void onLoadFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            c.a.t0.e1.b3.f fVar = this.f43796i;
            if (fVar != null) {
                fVar.x(true);
                this.v = this.f43796i.g();
            }
            notifyVideo(1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        c.a.t0.e1.b3.f fVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            c.a.t0.e1.b3.f fVar2 = this.f43796i;
            if (fVar2 != null) {
                fVar2.x(false);
            }
            if (this.f43797j) {
                return;
            }
            notifyVideo(2);
            if (this.f43796i.n() || (fVar = this.f43796i) == null || (i2 = this.v) == -1) {
                return;
            }
            fVar.d(i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStop();
            c.a.t0.w3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // c.a.t0.e1.b3.c
    public void onVideoContainerForegroundClick(int i2) {
        c.a.t0.e1.b3.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (fVar = this.f43796i) == null) {
            return;
        }
        fVar.y(i2 - 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            view.setFocusableInTouchMode(true);
            this.f43793f = new LinearLayoutManager(getContext());
            this.o = new View(getPageContext().getPageActivity());
            this.o.setLayoutParams(new AbsListView.LayoutParams(-1, n.f(getPageContext().getPageActivity(), R.dimen.ds88) + n.f(getPageContext().getPageActivity(), R.dimen.tbds42)));
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
            this.f43794g = bdTypeRecyclerView;
            bdTypeRecyclerView.addHeaderView(this.o);
            this.f43794g.setLayoutManager(this.f43793f);
            this.f43794g.setFadingEdgeLength(0);
            this.f43794g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
            this.f43794g.setOverScrollMode(2);
            this.f43794g.setScrollable(this);
            this.f43795h = (RelativeLayout) view.findViewById(R.id.container);
            this.r = (NoNetworkView) view.findViewById(R.id.no_network_view);
            if (!l.z()) {
                this.r.setVisibility(0);
            }
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.n = pbListView;
            pbListView.u(false);
            this.n.a();
            this.n.y();
            this.n.p(R.color.CAM_X0105);
            this.n.D(getResources().getString(R.string.list_has_no_more));
            this.n.F(R.color.CAM_X0109);
            this.n.B(R.color.CAM_X0106);
            this.f43794g.setNextPage(this.n);
            this.n.M(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds804));
            this.f43794g.setOnScrollListener(this.J);
            this.f43796i = new c.a.t0.e1.b3.f(getPageContext(), this.f43794g, this, true, this.s, this.y, getUniqueId());
            NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
            this.k = navigationBar;
            navigationBar.getBarBgView().setAlpha(0.0f);
            this.k.getTopCoverBgView().setAlpha(1.0f);
            this.k.hideBottomLine();
            if (DeviceInfoUtil.isReno3()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
                layoutParams.topMargin = n.f(getPageContext().getPageActivity(), R.dimen.tbds40);
                this.k.setLayoutParams(layoutParams);
            }
            View addSystemImageButton = this.k.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            this.l = addSystemImageButton;
            ImageView imageView = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            this.m = imageView;
            imageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
            this.t = new ArrayList();
            c.a.t0.e1.b3.d dVar = new c.a.t0.e1.b3.d();
            this.w = dVar;
            dVar.e(this.f43792e);
            c.a.t0.e1.t1.g b2 = this.w.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(b2);
            setData(arrayList, true, false);
        }
    }

    public final void p(List<BaseCardInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048596, this, list, z) == null) {
            if (this.f43796i != null && !ListUtils.isEmpty(list)) {
                if (this.f43797j) {
                    this.f43796i.w(list, true);
                    this.f43797j = false;
                } else {
                    this.f43796i.w(list, false);
                }
            }
            if (z) {
                return;
            }
            this.n.N();
        }
    }

    @Override // c.a.t0.e1.b3.h
    public void setData(List<BaseCardInfo> list, boolean z, boolean z2) {
        i iVar;
        g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList arrayList = null;
            c.a.e.d dVar = null;
            if (!ListUtils.isEmpty(list)) {
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    this.D = TbadkCoreApplication.getInst().getAdAdSense().m;
                    this.E = TbadkCoreApplication.getInst().getAdAdSense().o;
                    this.F = TbadkCoreApplication.getInst().getAdAdSense().n;
                }
                ArrayList arrayList2 = new ArrayList();
                int size = list.size();
                int i2 = 0;
                while (true) {
                    if (size <= 0) {
                        break;
                    }
                    boolean z3 = (size - (this.D - 1)) % (this.E - 1) == 0;
                    boolean z4 = i2 - size == this.F;
                    if (i2 <= this.F) {
                        z4 = size == 1;
                    }
                    if (z3) {
                        i iVar2 = this.f43792e;
                        c.a.e.h f2 = c.a.e.c.f(3, iVar2 != null ? iVar2.d() : 0, 0, "", "", l(size));
                        f2.a(this.A);
                        dVar = c.a.e.d.g(f2);
                        c.a.t0.y1.o.k.a.b(arrayList2, dVar, 0);
                        i2 = size + 1;
                    }
                    if (z4) {
                        BaseCardInfo baseCardInfo = list.get(size - 1);
                        if (dVar != null && baseCardInfo != null) {
                            baseCardInfo.setTrigger(new c.a.e.g(dVar));
                        }
                    }
                    arrayList2.add(0, list.get(size - 1));
                    size--;
                }
                if (!this.x && this.t.size() > 0 && (iVar = this.f43792e) != null && iVar.e() != null) {
                    String str = this.f43792e.e().threadId;
                    if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof c.a.t0.e1.t1.g)) {
                        c.a.t0.e1.t1.g gVar = (c.a.t0.e1.t1.g) arrayList2.get(0);
                        if (str.equals(gVar.f16923f) || n(gVar)) {
                            if (!StringUtils.isNull(gVar.z.n) || ((aVar = gVar.z.o) != null && aVar.a())) {
                                this.f43796i.B(gVar);
                            }
                            if (this.t.get(0) != null) {
                                this.t.get(0).setTrigger(gVar.getTrigger());
                            }
                            arrayList2.remove(gVar);
                        }
                        this.x = true;
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                this.t.addAll(arrayList);
            }
            if (this.z) {
                return;
            }
            p(arrayList, z);
        }
    }

    @Override // c.a.t0.e1.b3.h
    public void setPresenter(c.a.t0.e1.b3.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gVar) == null) {
        }
    }

    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.u == null) {
                this.u = new c.a.s0.s.k0.a(getPageContext());
            }
            this.u.e(new e(this));
            this.u.i(R.string.loading);
            this.u.h(true);
        }
    }

    @Override // c.a.t0.e1.b3.h
    public void showMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? l.H() || c.a.t0.k4.h.c().d() : invokeV.booleanValue;
    }
}
