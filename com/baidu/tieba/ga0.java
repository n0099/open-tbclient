package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.LiveTabFeedView;
import com.baidu.live.business.base.LiveBaseFragment;
import com.baidu.live.business.listener.LiveFeedBannerListener;
import com.baidu.live.business.listener.LiveFeedFollowListener;
import com.baidu.live.business.listener.LiveFeedToolListener;
import com.baidu.live.business.listener.TabFeedActionListener;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.LiveFeedModel;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveBannerWrapData;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveFeedData;
import com.baidu.live.business.model.data.LiveFeedToolWrapData;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveFollowEntity;
import com.baidu.live.business.model.data.LiveFollowWrapData;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveTabWrapData;
import com.baidu.live.business.view.smarttab.SmartTabLayout;
import com.baidu.live.feedfollow.view.LiveFeedFollowView;
import com.baidu.live.feedpage.interfaces.ILiveFeedOther;
import com.baidu.live.feedpage.interfaces.ILiveFeedRefresh;
import com.baidu.searchbox.download.lightdownload.LightFileUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.bumptech.glide.load.engine.GlideException;
import java.util.Map;
/* loaded from: classes6.dex */
public class ga0 implements fc0<ha0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public final BroadcastReceiver B;
    public final String a;
    public final int b;
    public Context c;
    public FragmentManager d;
    public LiveTabFeedView e;
    public LiveFeedModel f;
    public String g;
    public String h;
    public LiveFeedConfig i;
    public boolean j;
    public boolean k;
    public h l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public boolean s;
    public Flow t;
    public Flow u;
    public Flow v;
    public ILiveFeedRefresh.OnRefreshListener w;
    public ILiveFeedModel.OnDataLoadCallback x;
    public boolean y;
    public String z;

    /* loaded from: classes6.dex */
    public class a implements ILiveFeedModel.OnDataLoadCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga0 a;

        public a(ga0 ga0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga0Var;
        }

        @Override // com.baidu.live.business.model.ILiveFeedModel.OnDataLoadCallback
        public void onFail(int i, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, map) == null) && map != null && !TextUtils.isEmpty(map.get(LightFileUtils.DIRCTORY_DOWNLOAD_RESOURCE)) && TextUtils.equals(this.a.g, map.get(LightFileUtils.DIRCTORY_DOWNLOAD_RESOURCE))) {
                LiveFeedData liveFeedData = new LiveFeedData();
                liveFeedData.getDataByCache(i, str, true, true);
                this.a.y(liveFeedData);
            }
        }

        @Override // com.baidu.live.business.model.ILiveFeedModel.OnDataLoadCallback
        public void onSuccess(LiveFeedData liveFeedData, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedData, map) == null) {
                if (liveFeedData == null) {
                    onFail(-100, "数据解析失败", map);
                } else if (this.a.f.getFollowResource().equals(liveFeedData.resource)) {
                    this.a.G(liveFeedData.followWrapData);
                } else {
                    this.a.y(liveFeedData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TabFeedActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga0 a;

        public b(ga0 ga0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga0Var;
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onSearchShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048579, this, z) != null) {
                return;
            }
            this.a.H(z);
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onClickErrorRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h0();
            }
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onClickSearch() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.c0();
            }
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onClickStartLive(View view2, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, textView) != null) {
                return;
            }
            this.a.I(view2, textView);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements LiveFeedBannerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga0 a;

        public c(ga0 ga0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga0Var;
        }

        @Override // com.baidu.live.business.listener.LiveFeedBannerListener
        public void onBannerShow(@NonNull LiveBannerEntity liveBannerEntity) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) {
                LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                if (liveHostInfo == null) {
                    str = "";
                } else {
                    str = liveHostInfo.uk;
                }
                ma0.g(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, str, ma0.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
            }
        }

        @Override // com.baidu.live.business.listener.LiveFeedBannerListener
        public void onClickBanner(@Nullable LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.BannerCmdInfo bannerCmdInfo;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bannerCmdInfo = liveBannerEntity.cmdInfo) != null && !xc0.a(bannerCmdInfo.action)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    if (liveHostInfo == null) {
                        str = "";
                    } else {
                        str = liveHostInfo.uk;
                    }
                    ma0.f(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, str, ma0.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveBannerEntity.cmdInfo.action);
                    return;
                }
                LiveFeedPageSdk.getInstance().getInvoker().showToast(this.a.c, this.a.c.getResources().getString(R.string.obfuscated_res_0x7f0f0bc3));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements LiveFeedFollowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga0 a;

        public d(ga0 ga0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga0Var;
        }

        @Override // com.baidu.live.business.listener.LiveFeedFollowListener
        public void onClickFollow(@NonNull LiveFollowEntity liveFollowEntity, int i) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, liveFollowEntity, i) == null) {
                String n = ma0.n(this.a.h);
                if (liveFollowEntity.isMore) {
                    if (liveFollowEntity.cmd != null) {
                        LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveFollowEntity.cmd);
                    }
                    ma0.k(this.a.c, this.a.a, n);
                    return;
                }
                LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveFollowEntity.cmd);
                LiveHostInfo liveHostInfo = liveFollowEntity.hostInfo;
                if (liveHostInfo == null) {
                    str = "";
                } else {
                    str = liveHostInfo.uk;
                }
                ma0.i(this.a.c, this.a.a, str, n, i + 1, liveFollowEntity.roomId, liveFollowEntity.nid, liveFollowEntity.statInfo);
            }
        }

        @Override // com.baidu.live.business.listener.LiveFeedFollowListener
        public void onFollowShow(@NonNull LiveFollowEntity liveFollowEntity, int i) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFollowEntity, i) == null) {
                String n = ma0.n(this.a.h);
                if (liveFollowEntity.isMore) {
                    ma0.l(this.a.c, this.a.a, n);
                    return;
                }
                LiveHostInfo liveHostInfo = liveFollowEntity.hostInfo;
                if (liveHostInfo == null) {
                    str = "";
                } else {
                    str = liveHostInfo.uk;
                }
                ma0.j(this.a.c, this.a.a, str, n, i + 1, liveFollowEntity.roomId, liveFollowEntity.nid, liveFollowEntity.statInfo);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements LiveBaseFragment.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga0 a;

        public e(ga0 ga0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga0Var;
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onFeedReserveHeaderItemClick(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                ma0.x(this.a.c, this.a.h, this.a.a, Boolean.FALSE, str);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onShowToast(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && LiveFeedPageSdk.getInstance().getInvoker() != null) {
                LiveFeedPageSdk.getInstance().getInvoker().showToast(this.a.c, str);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onBannerItemClick(LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.BannerCmdInfo bannerCmdInfo;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bannerCmdInfo = liveBannerEntity.cmdInfo) != null && !xc0.a(bannerCmdInfo.action)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    if (liveHostInfo == null) {
                        str = "";
                    } else {
                        str = liveHostInfo.uk;
                    }
                    ma0.f(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, str, ma0.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveBannerEntity.cmdInfo.action);
                    return;
                }
                LiveFeedPageSdk.getInstance().getInvoker().showToast(this.a.c, this.a.c.getResources().getString(R.string.obfuscated_res_0x7f0f0bc3));
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onBannerItemShow(LiveBannerEntity liveBannerEntity) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveBannerEntity) == null) {
                LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                if (liveHostInfo == null) {
                    str = "";
                } else {
                    str = liveHostInfo.uk;
                }
                ma0.g(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, str, ma0.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onClickFeedItemRoom(LiveRoomEntity liveRoomEntity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, liveRoomEntity, i) == null) {
                String a = va0.a(liveRoomEntity);
                LiveFeedPageSdk.liveLog("FeedItemClick: position: $position  scheme: $scheme");
                if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, a);
                }
                ma0.q(this.a.h, this.a.a, Boolean.FALSE, liveRoomEntity, this.a.c, i);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onFeedStabilityLog(LiveFeedWrapData liveFeedWrapData, int i) {
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, liveFeedWrapData, i) == null) {
                if (uc0.c(liveFeedWrapData.roomInfoList)) {
                    size = 0;
                } else {
                    size = liveFeedWrapData.roomInfoList.size();
                }
                ma0.h(this.a.c, this.a.a, ma0.n(this.a.h), liveFeedWrapData.errCode, liveFeedWrapData.errMsg, liveFeedWrapData.tab, liveFeedWrapData.subTab, liveFeedWrapData.sessionId, size, i, liveFeedWrapData.refreshType, liveFeedWrapData.refreshIndex);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onTabPageShowLog(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
                ga0 ga0Var = this.a;
                ga0Var.t = ma0.s(ga0Var.c, true, this.a.a, ma0.n(this.a.h), str, str2, null);
                LiveFeedPageSdk.liveLog("LivePageLog onShowLog  " + str + GlideException.IndentedAppendable.INDENT + str2 + "   " + this.a.t.hashCode());
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onFeedItemRoomShow(LiveRoomEntity liveRoomEntity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, liveRoomEntity, i) == null) {
                ma0.q(this.a.h, this.a.a, Boolean.TRUE, liveRoomEntity, this.a.c, i);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onSlideLoadMore(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
                ma0.C(this.a.c, this.a.a, ma0.n(this.a.h), str, str2);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onHitCache(String str, String str2, String str3, String str4, String str5, int i, LiveFeedWrapData liveFeedWrapData, LiveFeedWrapData liveFeedWrapData2) {
            int i2;
            int i3;
            String str6;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, str5, Integer.valueOf(i), liveFeedWrapData, liveFeedWrapData2}) == null) && liveFeedWrapData.isCacheData) {
                if (i == -101) {
                    i2 = 1;
                } else if (liveFeedWrapData2 != null && liveFeedWrapData2.errCode != 0) {
                    i2 = 3;
                } else {
                    i2 = 2;
                }
                Context context = this.a.c;
                String str7 = this.a.a;
                String n = ma0.n(this.a.h);
                if (liveFeedWrapData2 == null) {
                    i3 = -100;
                } else {
                    i3 = liveFeedWrapData2.errCode;
                }
                if (liveFeedWrapData2 == null) {
                    str6 = "";
                } else {
                    str6 = liveFeedWrapData2.errMsg;
                }
                ma0.r(context, str7, n, i3, str6, str4, str5, str, str2, str3, i2, "feed", liveFeedWrapData.cacheTime, System.currentTimeMillis(), 1);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onItemLabelClickListener(String str, int i, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048583, this, str, i, liveRoomEntity) == null) {
                ma0.B(this.a.c, this.a.a, ma0.n(this.a.h), i, liveRoomEntity);
                if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, str);
                }
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onItemPlayerEnd(int i, String str, String str2, int i2, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), liveRoomEntity}) == null) {
                if (i == 1) {
                    if (this.a.u != null && liveRoomEntity != null) {
                        ma0.v(this.a.c, false, this.a.a, ma0.n(this.a.h), i2, str, str2, liveRoomEntity, this.a.u);
                        this.a.u = null;
                    }
                } else if (i == 2 && this.a.v != null && liveRoomEntity != null) {
                    ma0.v(this.a.c, false, this.a.a, ma0.n(this.a.h), i2, str, str2, liveRoomEntity, this.a.v);
                    this.a.v = null;
                }
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onItemPlayerStart(int i, String str, String str2, int i2, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), liveRoomEntity}) == null) {
                if (i == 1) {
                    ga0 ga0Var = this.a;
                    ga0Var.u = ma0.v(ga0Var.c, true, this.a.a, ma0.n(this.a.h), i2, str, str2, liveRoomEntity, null);
                } else if (i == 2) {
                    ga0 ga0Var2 = this.a;
                    ga0Var2.v = ma0.v(ga0Var2.c, true, this.a.a, ma0.n(this.a.h), i2, str, str2, liveRoomEntity, null);
                }
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onTabPageHideLog(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) && this.a.t != null) {
                LiveFeedPageSdk.liveLog("LivePageLog onHintLog  " + str + GlideException.IndentedAppendable.INDENT + str2 + "   " + this.a.t.hashCode());
                ma0.s(this.a.c, false, this.a.a, ma0.n(this.a.h), str, str2, this.a.t);
                this.a.t = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements LiveFeedToolListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga0 a;

        public f(ga0 ga0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga0Var;
        }

        @Override // com.baidu.live.business.listener.LiveFeedToolListener
        public void onItemClick(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ma0.A(this.a.c, this.a.h, this.a.a, Boolean.FALSE, str);
            }
        }

        @Override // com.baidu.live.business.listener.LiveFeedToolListener
        public void onItemShow(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                ma0.A(this.a.c, this.a.h, this.a.a, Boolean.TRUE, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga0 this$0;

        public g(ga0 ga0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = ga0Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.R();
                boolean f = sa0.f(context);
                if (!f || this.this$0.o) {
                    this.this$0.o = f;
                    return;
                }
                this.this$0.o = true;
                if (this.this$0.m) {
                    LiveFeedPageSdk.liveLog("网络变化: Tab 可用，Feed 刷新");
                    this.this$0.V();
                    return;
                }
                LiveFeedPageSdk.liveLog("网络变化: 全页面刷新");
                this.this$0.Q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;

        public h() {
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
            this.a = LiveFeedPageSdk.REFRESH_TIME;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b = System.currentTimeMillis();
            }
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || j <= 0) {
                return;
            }
            this.a = j;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LiveFeedPageSdk.liveLog("onShow   " + (System.currentTimeMillis() - this.b));
                if (System.currentTimeMillis() - this.b > this.a) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public ga0(Context context, int i, FragmentManager fragmentManager, String str, String str2, boolean z, String str3, String str4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), fragmentManager, str, str2, Boolean.valueOf(z), str3, str4, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
        this.l = new h(null);
        this.x = new a(this);
        this.A = false;
        this.B = new g(this);
        this.c = context;
        this.a = str2;
        this.d = fragmentManager;
        this.h = str;
        this.q = str3;
        this.r = str4;
        this.s = z2;
        this.p = z;
        this.l.b = System.currentTimeMillis();
        LiveFeedPageSdk.IMMERSION.equals(this.h);
        this.b = i;
        ic0.a().d(this, ia0.class, this);
        ic0.a().d(this, ka0.class, this);
        ic0.a().d(this, ja0.class, this);
        ic0.a().d(this, la0.class, this);
        O();
        LiveFeedModel liveFeedModel = new LiveFeedModel(this.h, this.a);
        this.f = liveFeedModel;
        this.e.setFeedModel(liveFeedModel);
        this.g = this.f.getInitResource();
        this.e.F(this.h, this.p, this.b, this.d, this.q, this.r);
    }

    public final void G(LiveFollowWrapData liveFollowWrapData) {
        boolean z;
        LiveFeedConfig.AbSwitchConfig abSwitchConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, liveFollowWrapData) == null) && this.e != null) {
            LiveFeedConfig liveFeedConfig = this.i;
            if (liveFeedConfig != null && (abSwitchConfig = liveFeedConfig.abSwitchConfig) != null && abSwitchConfig.otherNewStyle) {
                z = true;
            } else {
                z = false;
            }
            this.e.y(liveFollowWrapData, z, this.i);
        }
    }

    public final void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                i0();
                ma0.H(this.c);
                return;
            }
            N(false);
        }
    }

    public final void J(int i) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.A(i);
        }
    }

    public final void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.j0(false);
            }
            if (z) {
                ua0.d("sp_search_guide_show", true);
            }
        }
    }

    public void S(String str) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.P(str);
        }
    }

    public void U(ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, onLoadMoreListener) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.R(onLoadMoreListener);
        }
    }

    public void W(ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onRefreshListener) == null) {
            if (this.A) {
                LiveTabFeedView liveTabFeedView = this.e;
                if (liveTabFeedView != null) {
                    liveTabFeedView.S(onRefreshListener);
                    return;
                }
                return;
            }
            this.w = onRefreshListener;
            h0();
        }
    }

    public void X(int i) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.T(i);
        }
    }

    public final void f0(LiveBannerWrapData liveBannerWrapData) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, liveBannerWrapData) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.a0(liveBannerWrapData);
        }
    }

    public void v(ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, liveFeedStatusListener) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.q(liveFeedStatusListener);
        }
    }

    public final void L(LiveFeedToolWrapData liveFeedToolWrapData, LiveFeedConfig liveFeedConfig) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, liveFeedToolWrapData, liveFeedConfig) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.C(liveFeedToolWrapData, liveFeedConfig);
        }
    }

    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public RecyclerView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getMSubTipLayout();
            }
            return null;
        }
        return (RecyclerView) invokeV.objValue;
    }

    public SmartTabLayout C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getMSmartTabLayout();
            }
            return null;
        }
        return (SmartTabLayout) invokeV.objValue;
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getMViewPager();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.D();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.L();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.k0();
            }
            h0();
        }
    }

    public final void R() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.M();
        }
    }

    public void V() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.S(null);
        }
    }

    public final void Y() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.U();
        }
    }

    public void a0() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.W();
        }
    }

    public void b0() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.X();
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            N(true);
            ma0.G(this.c);
            LiveFeedPageSdk.getInstance().startLiveSearchActivity(this.c);
        }
    }

    public final void h0() {
        LiveFeedModel liveFeedModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (liveFeedModel = this.f) != null) {
            liveFeedModel.reqInit(this.x);
        }
    }

    public final void i0() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && !ua0.a("sp_search_guide_show", false) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.j0(true);
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.c != null && this.n) {
            LiveFeedPageSdk.liveLog("解注册网络变化广播");
            this.c.unregisterReceiver(this.B);
            this.n = false;
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.u();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.v();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public LiveFeedFollowView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getFeedFollowView();
            }
            return null;
        }
        return (LiveFeedFollowView) invokeV.objValue;
    }

    public final void E(LiveFeedConfig liveFeedConfig) {
        boolean z;
        LiveFeedConfig.AbSwitchConfig abSwitchConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, liveFeedConfig) == null) {
            this.i = liveFeedConfig;
            if (liveFeedConfig != null && (abSwitchConfig = liveFeedConfig.abSwitchConfig) != null && abSwitchConfig.newTab) {
                z = true;
            } else {
                z = false;
            }
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.setTabStyle(z);
            }
            if (liveFeedConfig != null) {
                this.l.b(liveFeedConfig.timeoutRefreshTime * 1000);
            }
        }
    }

    public final void F(LiveFeedData liveFeedData) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, liveFeedData) == null) && liveFeedData != null) {
            E(liveFeedData.feedConfig);
            f0(liveFeedData.bannerWrapData);
            K(liveFeedData);
            J(xa0.a());
            G(liveFeedData.followWrapData);
            L(liveFeedData.toolWrapData, liveFeedData.feedConfig);
            if (this.s && (liveTabFeedView = this.e) != null) {
                this.s = false;
                liveTabFeedView.setExpanded(false);
            }
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            LiveFeedPageSdk.liveLog("onUserVisibleHint " + this.k + " " + z);
            if (this.j == z) {
                return;
            }
            this.j = z;
            if (z) {
                Z();
                g0();
                return;
            }
            Y();
            j0();
        }
    }

    public final void I(View view2, TextView textView) {
        String defaultStartLiveScheme;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, textView) == null) {
            LiveFeedConfig liveFeedConfig = this.i;
            if (liveFeedConfig != null && !TextUtils.isEmpty(liveFeedConfig.startLiveScheme)) {
                defaultStartLiveScheme = this.i.startLiveScheme;
            } else {
                defaultStartLiveScheme = LiveFeedPageSdk.getInstance().getDefaultStartLiveScheme();
            }
            if (LiveFeedPageSdk.getInstance().getHKInvoker() != null) {
                LiveFeedPageSdk.getInstance().getHKInvoker().clickStartLive(view2, textView, defaultStartLiveScheme);
            } else if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.c, defaultStartLiveScheme);
            }
        }
    }

    public void d0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, str, str2) == null) {
            LiveFeedPageSdk.liveLog("D8800088 onTabSelectedEvent 新值 subTabType = " + str + ", thirdTabType = " + str2);
            LiveFeedPageSdk.liveLog("D8800088 onTabSelectedEvent 旧值 mSubTabType = " + this.q + ", mThirdTabType = " + this.r);
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.Y(str, str2);
            }
        }
    }

    public final void K(LiveFeedData liveFeedData) {
        LiveTabWrapData liveTabWrapData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, liveFeedData) != null) || liveFeedData == null) {
            return;
        }
        xa0.b();
        if (!this.A && (liveTabWrapData = liveFeedData.tabWrapData) != null && !uc0.c(liveTabWrapData.tabList)) {
            this.A = true;
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.B(liveFeedData);
            }
            if (liveFeedData.tabWrapData.isCacheData) {
                Context context = this.c;
                String str = this.a;
                String n = ma0.n(this.h);
                LiveTabWrapData liveTabWrapData2 = liveFeedData.tabWrapData;
                ma0.r(context, str, n, liveTabWrapData2.errCode, liveTabWrapData2.errMsg, liveFeedData.logId, liveFeedData.resource, "", "", "", liveTabWrapData2.cacheCause, "tab", liveTabWrapData2.cacheTime, System.currentTimeMillis(), 1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fc0
    public void call(ha0 ha0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, ha0Var) == null) && ha0Var != null && ha0Var.a() == this.b) {
            LiveFeedPageSdk.liveLog("LiveEventBus event: " + ha0Var.getClass() + GlideException.IndentedAppendable.INDENT + ha0Var.a());
            if (ha0Var instanceof ia0) {
                LiveBannerWrapData liveBannerWrapData = ((ia0) ha0Var).b;
                if (liveBannerWrapData != null) {
                    f0(liveBannerWrapData);
                }
            } else if (ha0Var instanceof ka0) {
                LiveFollowWrapData liveFollowWrapData = ((ka0) ha0Var).b;
                if (liveFollowWrapData != null) {
                    G(liveFollowWrapData);
                }
            } else if (ha0Var instanceof ja0) {
                this.l.c();
            } else if (ha0Var instanceof la0) {
                la0 la0Var = (la0) ha0Var;
                boolean z = la0Var.b;
                this.y = z;
                String str = la0Var.c;
                this.z = str;
                LiveTabFeedView liveTabFeedView = this.e;
                if (liveTabFeedView != null) {
                    liveTabFeedView.l0(z, str);
                }
            }
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            LiveTabFeedView liveTabFeedView = new LiveTabFeedView(this.c);
            this.e = liveTabFeedView;
            liveTabFeedView.setFeedActionListener(new b(this));
            this.e.setFeedBannerListener(new c(this));
            this.e.setFeedFollowListener(new d(this));
            this.e.setSubTabPageListener(new e(this));
            this.e.setFeedToolListener(new f(this));
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ic0.a().e(this);
            j0();
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.Q();
            }
            this.k = true;
            xa0.b();
            this.p = false;
            wb0.d(String.valueOf(this.b));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.V();
            }
            if (this.l.a()) {
                LiveTabFeedView liveTabFeedView2 = this.e;
                if (liveTabFeedView2 != null) {
                    liveTabFeedView2.S(null);
                }
            } else {
                LiveFeedModel liveFeedModel = this.f;
                if (liveFeedModel != null && !this.k) {
                    liveFeedModel.reqFollow(this.x);
                }
            }
            this.k = false;
        }
    }

    public final void g0() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (context = this.c) != null && !this.n) {
            this.o = sa0.f(context);
            LiveFeedPageSdk.liveLog("注册网络变化广播");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
            this.c.registerReceiver(this.B, intentFilter);
            this.n = true;
        }
    }

    public final void y(LiveFeedData liveFeedData) {
        LiveTabWrapData liveTabWrapData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, liveFeedData) == null) {
            ILiveFeedRefresh.OnRefreshListener onRefreshListener = this.w;
            if (onRefreshListener != null) {
                onRefreshListener.onPullRefreshEnd();
            }
            if (liveFeedData != null) {
                this.y = liveFeedData.isMinor;
                LiveFeedConfig liveFeedConfig = liveFeedData.feedConfig;
                if (liveFeedConfig != null) {
                    this.z = liveFeedConfig.minorUfoUrl;
                }
            }
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.l0(this.y, this.z);
            }
            if (liveFeedData != null && (liveTabWrapData = liveFeedData.tabWrapData) != null && !uc0.c(liveTabWrapData.tabList)) {
                F(liveFeedData);
                LiveTabFeedView liveTabFeedView2 = this.e;
                if (liveTabFeedView2 != null) {
                    liveTabFeedView2.g0();
                }
                this.m = true;
                if (!liveFeedData.tabWrapData.isCacheData) {
                    this.l.c();
                    return;
                }
                return;
            }
            LiveTabFeedView liveTabFeedView3 = this.e;
            if (liveTabFeedView3 != null) {
                liveTabFeedView3.h0();
            }
            this.m = false;
        }
    }
}
