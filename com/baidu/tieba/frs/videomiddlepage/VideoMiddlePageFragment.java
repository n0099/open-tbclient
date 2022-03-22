package com.baidu.tieba.frs.videomiddlepage;

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
import c.a.d.o.e.q;
import c.a.p0.f1.j1.g;
import c.a.p0.f1.t2.h;
import c.a.p0.f1.t2.i;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
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
/* loaded from: classes5.dex */
public class VideoMiddlePageFragment extends BaseFragment implements h, c.a.p0.f1.t2.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public RecyclerView.OnScrollListener F;
    public CustomMessageListener G;
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayoutManager f32908b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f32909c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f32910d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f1.t2.f f32911e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32912f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f32913g;

    /* renamed from: h  reason: collision with root package name */
    public View f32914h;
    public ImageView i;
    public PbListView j;
    public View k;
    public int l;
    public boolean m;
    public NoNetworkView n;
    public String o;
    public List<BaseCardInfo> p;
    public c.a.o0.r.l0.a q;
    public int r;
    public c.a.p0.f1.t2.d s;
    public boolean t;
    public String u;
    public boolean v;
    public HashMap w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoMiddlePageFragment videoMiddlePageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment, Integer.valueOf(i)};
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
            if (this.a.i != null) {
                if (Config.EXCEPTION_MEMORY_LOW.equals(str)) {
                    this.a.i.setAlpha(0.2f);
                } else if ("high".equals(str)) {
                    this.a.i.setAlpha(1.0f);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoMiddlePageFragment videoMiddlePageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment, Integer.valueOf(i)};
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
            this.a = videoMiddlePageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (l.z()) {
                    if (this.a.n != null) {
                        this.a.n.setVisibility(8);
                    }
                    if (!l.x() || c.a.p0.n4.h.c().d()) {
                        return;
                    }
                    if (this.a.f32911e == null || !this.a.f32911e.k()) {
                        if (this.a.f32911e == null || !this.a.f32911e.n()) {
                            return;
                        }
                        this.a.getPageContext().showToast((int) R.string.obfuscated_res_0x7f0f14da);
                        return;
                    }
                    this.a.getPageContext().showToast((int) R.string.obfuscated_res_0x7f0f14da);
                } else if (this.a.n != null) {
                    this.a.n.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(VideoMiddlePageFragment videoMiddlePageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment, Integer.valueOf(i)};
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
            this.a = videoMiddlePageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && this.a.f32911e != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.a) {
                this.a.f32911e.o(data.f30338c, data.f30339d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageFragment a;

        public d(VideoMiddlePageFragment videoMiddlePageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.getPageContext().getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageFragment a;

        public e(VideoMiddlePageFragment videoMiddlePageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && (recyclerView instanceof BdTypeRecyclerView)) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                this.a.l = i;
                if (i != 0) {
                    if (i == 1) {
                        this.a.i.setAlpha(1.0f);
                        return;
                    }
                    return;
                }
                if (bdTypeRecyclerView.getLastVisiblePosition() > bdTypeRecyclerView.getCount() - 2 && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                    this.a.a.h(this.a.o);
                    this.a.a.f();
                }
                this.a.Q0(bdTypeRecyclerView);
                c.a.p0.z3.c.g().h(this.a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) && (recyclerView instanceof BdTypeRecyclerView)) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (this.a.f32911e != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > this.a.f32911e.g() || bdTypeRecyclerView.getLastVisiblePosition() < this.a.f32911e.g()) {
                        this.a.f32911e.e();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(VideoMiddlePageFragment videoMiddlePageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageFragment, Integer.valueOf(i)};
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
            this.a = videoMiddlePageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f32911e == null) {
                return;
            }
            this.a.f32911e.p();
        }
    }

    public VideoMiddlePageFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32912f = true;
        this.r = -1;
        this.t = false;
        this.v = false;
        this.z = 4;
        this.A = 7;
        this.B = 4;
        this.C = new a(this, 2921317);
        this.D = new b(this, 2000994);
        this.E = new c(this, 2001115);
        this.F = new e(this);
        this.G = new f(this, 2921414);
        this.w = new HashMap();
    }

    public static VideoMiddlePageFragment L0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("PARAM_FROM", str);
            bundle.putString("PARAM_FID", str2);
            VideoMiddlePageFragment videoMiddlePageFragment = new VideoMiddlePageFragment();
            videoMiddlePageFragment.setArguments(bundle);
            return videoMiddlePageFragment;
        }
        return (VideoMiddlePageFragment) invokeLL.objValue;
    }

    public final int J0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int i2 = i + 1;
            int i3 = this.z;
            int i4 = 1;
            if (i2 > i3 - 1) {
                int i5 = i2 - (i3 - 1);
                if (i5 >= i3 - 1) {
                    i4 = 1 + (i5 % (this.A - 1));
                }
            } else {
                i4 = 0;
            }
            return i4 + i;
        }
        return invokeI.intValue;
    }

    public c.a.p0.f1.t2.a K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.f1.t2.f fVar = this.f32911e;
            if (fVar != null) {
                return fVar.f();
            }
            return null;
        }
        return (c.a.p0.f1.t2.a) invokeV.objValue;
    }

    public int M0(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            int height = view.getHeight();
            if (rect.top == 0 && rect.bottom == height) {
                return 100;
            }
            int i = rect.top;
            if (i > 0) {
                return ((height - i) * 100) / height;
            }
            int i2 = rect.bottom;
            if (i2 <= 0 || i2 >= height) {
                return 100;
            }
            return (i2 * 100) / height;
        }
        return invokeL.intValue;
    }

    public final boolean N0(g gVar) {
        InterceptResult invokeL;
        i iVar;
        VideoSerializeVideoThreadInfo e2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gVar)) == null) ? (!"0".equals(gVar.f14123b) || (iVar = this.a) == null || iVar.e() == null || (e2 = this.a.e()) == null || e2.video == null || !TextUtils.equals(e2.title, gVar.t) || !TextUtils.equals(e2.video.videoUrl, gVar.getVideoUrl())) ? false : true : invokeL.booleanValue;
    }

    public void O0(int i) {
        c.a.p0.f1.t2.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || this.f32909c == null || (fVar = this.f32911e) == null) {
            return;
        }
        if (i == 1) {
            if (fVar.n()) {
                this.f32911e.z();
            } else if (this.f32911e.k()) {
                this.f32911e.A();
            }
        }
        if (i == 2) {
            this.f32911e.A();
            if (this.f32911e.n()) {
                this.f32911e.v();
            }
        }
    }

    public boolean P0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            c.a.p0.f1.t2.f fVar = this.f32911e;
            if (fVar == null) {
                return false;
            }
            return fVar.s(i);
        }
        return invokeI.booleanValue;
    }

    public final void Q0(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdTypeRecyclerView) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition() - bdTypeRecyclerView.getHeaderViewsCount();
            int i = 0;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            if (bdTypeRecyclerView.getChildCount() > 0 && ((bdTypeRecyclerView.getChildAt(0) instanceof RelativeLayout) || (bdTypeRecyclerView.getChildAt(0) instanceof c.a.p0.b2.o.l.e))) {
                i = M0(bdTypeRecyclerView.getChildAt(0));
            } else if (bdTypeRecyclerView.getChildCount() > 1) {
                i = M0(bdTypeRecyclerView.getChildAt(1));
            }
            if (!this.f32911e.m(firstVisiblePosition) || i < 95) {
                firstVisiblePosition += this.f32911e.i(firstVisiblePosition);
            }
            this.f32911e.d(firstVisiblePosition);
        }
    }

    public final void R0(List<BaseCardInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, list, z) == null) {
            if (this.f32911e != null && !ListUtils.isEmpty(list)) {
                if (this.f32912f) {
                    this.f32911e.w(list, true);
                    this.f32912f = false;
                } else {
                    this.f32911e.w(list, false);
                }
            }
            if (z) {
                return;
            }
            this.j.N();
        }
    }

    @Override // c.a.p0.f1.t2.h
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
        }
    }

    @Override // c.a.p0.f1.t2.h
    public void d() {
        c.a.o0.r.l0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.h(false);
    }

    @Override // c.a.p0.f1.t2.h
    public void h(List<BaseCardInfo> list, boolean z, boolean z2) {
        i iVar;
        g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList arrayList = null;
            c.a.e.d dVar = null;
            if (!ListUtils.isEmpty(list)) {
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    this.z = TbadkCoreApplication.getInst().getAdAdSense().m;
                    this.A = TbadkCoreApplication.getInst().getAdAdSense().o;
                    this.B = TbadkCoreApplication.getInst().getAdAdSense().n;
                }
                ArrayList arrayList2 = new ArrayList();
                int size = list.size();
                int i = 0;
                while (true) {
                    if (size <= 0) {
                        break;
                    }
                    boolean z3 = (size - (this.z - 1)) % (this.A - 1) == 0;
                    boolean z4 = i - size == this.B;
                    if (i <= this.B) {
                        z4 = size == 1;
                    }
                    if (z3) {
                        i iVar2 = this.a;
                        c.a.e.h f2 = c.a.e.c.f(3, iVar2 != null ? iVar2.d() : 0, 0, "", "", J0(size));
                        f2.a(this.w);
                        dVar = c.a.e.d.e(f2);
                        c.a.p0.b2.o.k.a.b(arrayList2, dVar, 0);
                        i = size + 1;
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
                if (!this.t && this.p.size() > 0 && (iVar = this.a) != null && iVar.e() != null) {
                    String str = this.a.e().threadId;
                    if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof g)) {
                        g gVar = (g) arrayList2.get(0);
                        if (str.equals(gVar.f14123b) || N0(gVar)) {
                            if (!StringUtils.isNull(gVar.v.n) || ((aVar = gVar.v.o) != null && aVar.a())) {
                                this.f32911e.B(gVar);
                            }
                            if (this.p.get(0) != null) {
                                this.p.get(0).setTrigger(gVar.getTrigger());
                            }
                            arrayList2.remove(gVar);
                        }
                        this.t = true;
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                this.p.addAll(arrayList);
            }
            if (this.v) {
                return;
            }
            R0(arrayList, z);
        }
    }

    @Override // c.a.p0.f1.t2.h
    public void m0(c.a.p0.f1.t2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            this.n.c(getPageContext(), i);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                z = !this.m;
                this.m = true;
                this.f32913g.setVisibility(8);
                this.x = this.f32909c.getFirstVisiblePosition();
                View childAt = this.f32909c.getChildAt(0);
                this.y = childAt != null ? childAt.getTop() : 0;
            } else {
                z = this.m;
                this.m = false;
                this.f32913g.setVisibility(0);
            }
            c.a.p0.f1.t2.f fVar = this.f32911e;
            if (fVar != null) {
                fVar.q(configuration);
            }
            if (!z || this.m || K0() == null || this.x == this.f32909c.getFirstVisiblePosition()) {
                return;
            }
            ((LinearLayoutManager) this.f32909c.getLayoutManager()).scrollToPositionWithOffset(this.x, this.y);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.p0.z3.c.g().i(getUniqueId());
            this.a = new i(this);
            Intent intent = getPageContext().getPageActivity().getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra("PARAM_FID");
                String stringExtra2 = intent.getStringExtra("st_type");
                String stringExtra3 = intent.getStringExtra("yuelaou_locate");
                this.a.i(stringExtra);
                this.a.j(stringExtra3);
                this.a.k(stringExtra2);
                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra("param_video_thread_info");
                if (videoSerializeVideoThreadInfo != null) {
                    this.w.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                    this.w.put("thread_id", videoSerializeVideoThreadInfo.threadId);
                }
                this.a.l(videoSerializeVideoThreadInfo);
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.o = arguments.getString("PARAM_FROM");
                this.u = arguments.getString("PARAM_FID");
            }
            i iVar = this.a;
            if (iVar != null) {
                iVar.h(this.o);
                this.a.g();
            }
            registerListener(this.D);
            registerListener(this.E);
            registerListener(this.C);
            registerListener(this.G);
            new c.a.p0.l4.d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) ? layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02f4, viewGroup, false) : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            c.a.p0.z3.c.g().k(getUniqueId());
            i iVar = this.a;
            if (iVar != null) {
                iVar.c();
            }
            c.a.p0.f1.t2.f fVar = this.f32911e;
            if (fVar != null) {
                fVar.r();
            }
            c.a.p0.f1.t2.d dVar = this.s;
            if (dVar != null) {
                dVar.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f32909c.getPreLoadHandle() : (q) invokeV.objValue;
    }

    @Override // c.a.p0.f1.t2.h
    public void onLoadFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            c.a.p0.f1.t2.f fVar = this.f32911e;
            if (fVar != null) {
                fVar.x(true);
                this.r = this.f32911e.g();
            }
            O0(1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        c.a.p0.f1.t2.f fVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            c.a.p0.f1.t2.f fVar2 = this.f32911e;
            if (fVar2 != null) {
                fVar2.x(false);
            }
            if (this.f32912f) {
                return;
            }
            O0(2);
            if (this.f32911e.n() || (fVar = this.f32911e) == null || (i = this.r) == -1) {
                return;
            }
            fVar.d(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStop();
            c.a.p0.z3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            view.setFocusableInTouchMode(true);
            this.f32908b = new LinearLayoutManager(getContext());
            this.k = new View(getPageContext().getPageActivity());
            this.k.setLayoutParams(new AbsListView.LayoutParams(-1, n.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702ff) + n.f(getPageContext().getPageActivity(), R.dimen.tbds42)));
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.obfuscated_res_0x7f09234b);
            this.f32909c = bdTypeRecyclerView;
            bdTypeRecyclerView.s(this.k);
            this.f32909c.setLayoutManager(this.f32908b);
            this.f32909c.setFadingEdgeLength(0);
            this.f32909c.setBackgroundColor(SkinManager.getColor(R.color.transparent));
            this.f32909c.setOverScrollMode(2);
            this.f32909c.setScrollable(this);
            this.f32910d = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0906c9);
            this.n = (NoNetworkView) view.findViewById(R.id.obfuscated_res_0x7f09159c);
            if (!l.z()) {
                this.n.setVisibility(0);
            }
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.j = pbListView;
            pbListView.u(false);
            this.j.a();
            this.j.y();
            this.j.p(R.color.CAM_X0105);
            this.j.D(getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
            this.j.F(R.color.CAM_X0109);
            this.j.B(R.color.CAM_X0106);
            this.f32909c.setNextPage(this.j);
            this.j.M(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds804));
            this.f32909c.setOnScrollListener(this.F);
            this.f32911e = new c.a.p0.f1.t2.f(getPageContext(), this.f32909c, this, true, this.o, this.u, getUniqueId());
            NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.obfuscated_res_0x7f091519);
            this.f32913g = navigationBar;
            navigationBar.getBarBgView().setAlpha(0.0f);
            this.f32913g.getTopCoverBgView().setAlpha(1.0f);
            this.f32913g.hideBottomLine();
            if (DeviceInfoUtil.isReno3()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f32913g.getLayoutParams();
                layoutParams.topMargin = n.f(getPageContext().getPageActivity(), R.dimen.tbds40);
                this.f32913g.setLayoutParams(layoutParams);
            }
            View addSystemImageButton = this.f32913g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            this.f32914h = addSystemImageButton;
            ImageView imageView = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09246f);
            this.i = imageView;
            imageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
            this.p = new ArrayList();
            c.a.p0.f1.t2.d dVar = new c.a.p0.f1.t2.d();
            this.s = dVar;
            dVar.e(this.a);
            g b2 = this.s.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(b2);
            h(arrayList, true, false);
        }
    }

    @Override // c.a.p0.f1.t2.c
    public void p0(int i) {
        c.a.p0.f1.t2.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i) == null) || (fVar = this.f32911e) == null) {
            return;
        }
        fVar.y(i - 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? l.H() || c.a.p0.n4.h.c().d() : invokeV.booleanValue;
    }
}
