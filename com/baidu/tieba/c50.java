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
/* loaded from: classes5.dex */
public class c50 implements b70<d50> {
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

    /* loaded from: classes5.dex */
    public class a implements ILiveFeedModel.OnDataLoadCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c50 a;

        public a(c50 c50Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c50Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c50Var;
        }

        @Override // com.baidu.live.business.model.ILiveFeedModel.OnDataLoadCallback
        public void onFail(int i, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, map) == null) && map != null && !TextUtils.isEmpty(map.get(LightFileUtils.DIRCTORY_DOWNLOAD_RESOURCE)) && TextUtils.equals(this.a.g, map.get(LightFileUtils.DIRCTORY_DOWNLOAD_RESOURCE))) {
                LiveFeedData liveFeedData = new LiveFeedData();
                liveFeedData.getDataByCache(i, str, true, true);
                this.a.z(liveFeedData);
            }
        }

        @Override // com.baidu.live.business.model.ILiveFeedModel.OnDataLoadCallback
        public void onSuccess(LiveFeedData liveFeedData, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedData, map) == null) {
                if (liveFeedData == null) {
                    onFail(-100, "数据解析失败", map);
                } else if (this.a.f.getFollowResource().equals(liveFeedData.resource)) {
                    this.a.H(liveFeedData.followWrapData);
                } else {
                    this.a.z(liveFeedData);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TabFeedActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c50 a;

        public b(c50 c50Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c50Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c50Var;
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onSearchShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048579, this, z) != null) {
                return;
            }
            this.a.I(z);
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onClickErrorRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i0();
            }
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onClickSearch() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.d0();
            }
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onClickStartLive(View view2, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, textView) != null) {
                return;
            }
            this.a.J(view2, textView);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements LiveFeedBannerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c50 a;

        public c(c50 c50Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c50Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c50Var;
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
                i50.g(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, str, i50.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
            }
        }

        @Override // com.baidu.live.business.listener.LiveFeedBannerListener
        public void onClickBanner(@Nullable LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.BannerCmdInfo bannerCmdInfo;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bannerCmdInfo = liveBannerEntity.cmdInfo) != null && !t70.a(bannerCmdInfo.action)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    if (liveHostInfo == null) {
                        str = "";
                    } else {
                        str = liveHostInfo.uk;
                    }
                    i50.f(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, str, i50.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveBannerEntity.cmdInfo.action);
                    return;
                }
                LiveFeedPageSdk.getInstance().getInvoker().showToast(this.a.c, this.a.c.getResources().getString(R.string.obfuscated_res_0x7f0f0bd2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements LiveFeedFollowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c50 a;

        public d(c50 c50Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c50Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c50Var;
        }

        @Override // com.baidu.live.business.listener.LiveFeedFollowListener
        public void onClickFollow(@NonNull LiveFollowEntity liveFollowEntity, int i) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, liveFollowEntity, i) == null) {
                String n = i50.n(this.a.h);
                if (liveFollowEntity.isMore) {
                    if (liveFollowEntity.cmd != null) {
                        LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveFollowEntity.cmd);
                    }
                    i50.k(this.a.c, this.a.a, n);
                    return;
                }
                LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveFollowEntity.cmd);
                LiveHostInfo liveHostInfo = liveFollowEntity.hostInfo;
                if (liveHostInfo == null) {
                    str = "";
                } else {
                    str = liveHostInfo.uk;
                }
                i50.i(this.a.c, this.a.a, str, n, i + 1, liveFollowEntity.roomId, liveFollowEntity.nid, liveFollowEntity.statInfo);
            }
        }

        @Override // com.baidu.live.business.listener.LiveFeedFollowListener
        public void onFollowShow(@NonNull LiveFollowEntity liveFollowEntity, int i) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFollowEntity, i) == null) {
                String n = i50.n(this.a.h);
                if (liveFollowEntity.isMore) {
                    i50.l(this.a.c, this.a.a, n);
                    return;
                }
                LiveHostInfo liveHostInfo = liveFollowEntity.hostInfo;
                if (liveHostInfo == null) {
                    str = "";
                } else {
                    str = liveHostInfo.uk;
                }
                i50.j(this.a.c, this.a.a, str, n, i + 1, liveFollowEntity.roomId, liveFollowEntity.nid, liveFollowEntity.statInfo);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements LiveBaseFragment.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c50 a;

        public e(c50 c50Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c50Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c50Var;
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onFeedReserveHeaderItemClick(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                i50.x(this.a.c, this.a.h, this.a.a, Boolean.FALSE, str);
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
                if (liveBannerEntity != null && (bannerCmdInfo = liveBannerEntity.cmdInfo) != null && !t70.a(bannerCmdInfo.action)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    if (liveHostInfo == null) {
                        str = "";
                    } else {
                        str = liveHostInfo.uk;
                    }
                    i50.f(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, str, i50.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveBannerEntity.cmdInfo.action);
                    return;
                }
                LiveFeedPageSdk.getInstance().getInvoker().showToast(this.a.c, this.a.c.getResources().getString(R.string.obfuscated_res_0x7f0f0bd2));
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
                i50.g(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, str, i50.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onClickFeedItemRoom(LiveRoomEntity liveRoomEntity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, liveRoomEntity, i) == null) {
                String a = r50.a(liveRoomEntity);
                LiveFeedPageSdk.liveLog("FeedItemClick: position: $position  scheme: $scheme");
                if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, a);
                }
                i50.q(this.a.h, this.a.a, Boolean.FALSE, liveRoomEntity, this.a.c, i);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onFeedStabilityLog(LiveFeedWrapData liveFeedWrapData, int i) {
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, liveFeedWrapData, i) == null) {
                if (q70.c(liveFeedWrapData.roomInfoList)) {
                    size = 0;
                } else {
                    size = liveFeedWrapData.roomInfoList.size();
                }
                i50.h(this.a.c, this.a.a, i50.n(this.a.h), liveFeedWrapData.errCode, liveFeedWrapData.errMsg, liveFeedWrapData.tab, liveFeedWrapData.subTab, liveFeedWrapData.sessionId, size, i, liveFeedWrapData.refreshType, liveFeedWrapData.refreshIndex);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onTabPageShowLog(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
                c50 c50Var = this.a;
                c50Var.t = i50.s(c50Var.c, true, this.a.a, i50.n(this.a.h), str, str2, null);
                LiveFeedPageSdk.liveLog("LivePageLog onShowLog  " + str + GlideException.IndentedAppendable.INDENT + str2 + "   " + this.a.t.hashCode());
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onFeedItemRoomShow(LiveRoomEntity liveRoomEntity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, liveRoomEntity, i) == null) {
                i50.q(this.a.h, this.a.a, Boolean.TRUE, liveRoomEntity, this.a.c, i);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onSlideLoadMore(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
                i50.C(this.a.c, this.a.a, i50.n(this.a.h), str, str2);
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
                String n = i50.n(this.a.h);
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
                i50.r(context, str7, n, i3, str6, str4, str5, str, str2, str3, i2, "feed", liveFeedWrapData.cacheTime, System.currentTimeMillis(), 1);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onItemLabelClickListener(String str, int i, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048583, this, str, i, liveRoomEntity) == null) {
                i50.B(this.a.c, this.a.a, i50.n(this.a.h), i, liveRoomEntity);
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
                        i50.v(this.a.c, false, this.a.a, i50.n(this.a.h), i2, str, str2, liveRoomEntity, this.a.u);
                        this.a.u = null;
                    }
                } else if (i == 2 && this.a.v != null && liveRoomEntity != null) {
                    i50.v(this.a.c, false, this.a.a, i50.n(this.a.h), i2, str, str2, liveRoomEntity, this.a.v);
                    this.a.v = null;
                }
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onItemPlayerStart(int i, String str, String str2, int i2, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), liveRoomEntity}) == null) {
                if (i == 1) {
                    c50 c50Var = this.a;
                    c50Var.u = i50.v(c50Var.c, true, this.a.a, i50.n(this.a.h), i2, str, str2, liveRoomEntity, null);
                } else if (i == 2) {
                    c50 c50Var2 = this.a;
                    c50Var2.v = i50.v(c50Var2.c, true, this.a.a, i50.n(this.a.h), i2, str, str2, liveRoomEntity, null);
                }
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onTabPageHideLog(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) && this.a.t != null) {
                LiveFeedPageSdk.liveLog("LivePageLog onHintLog  " + str + GlideException.IndentedAppendable.INDENT + str2 + "   " + this.a.t.hashCode());
                i50.s(this.a.c, false, this.a.a, i50.n(this.a.h), str, str2, this.a.t);
                this.a.t = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements LiveFeedToolListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c50 a;

        public f(c50 c50Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c50Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c50Var;
        }

        @Override // com.baidu.live.business.listener.LiveFeedToolListener
        public void onItemClick(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                i50.A(this.a.c, this.a.h, this.a.a, Boolean.FALSE, str);
            }
        }

        @Override // com.baidu.live.business.listener.LiveFeedToolListener
        public void onItemShow(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                i50.A(this.a.c, this.a.h, this.a.a, Boolean.TRUE, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c50 this$0;

        public g(c50 c50Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c50Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = c50Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.S();
                boolean f = o50.f(context);
                if (!f || this.this$0.o) {
                    this.this$0.o = f;
                    return;
                }
                this.this$0.o = true;
                if (this.this$0.m) {
                    LiveFeedPageSdk.liveLog("网络变化: Tab 可用，Feed 刷新");
                    this.this$0.W();
                    return;
                }
                LiveFeedPageSdk.liveLog("网络变化: 全页面刷新");
                this.this$0.R();
            }
        }
    }

    /* loaded from: classes5.dex */
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

    public c50(Context context, int i, FragmentManager fragmentManager, String str, String str2, boolean z, String str3, String str4, boolean z2) {
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
        e70.a().d(this, e50.class, this);
        e70.a().d(this, g50.class, this);
        e70.a().d(this, f50.class, this);
        e70.a().d(this, h50.class, this);
        P();
        LiveFeedModel liveFeedModel = new LiveFeedModel(this.h, this.a);
        this.f = liveFeedModel;
        this.e.setFeedModel(liveFeedModel);
        this.g = this.f.getInitResource();
        this.e.F(this.h, this.p, this.b, this.d, this.q, this.r);
    }

    public final void H(LiveFollowWrapData liveFollowWrapData) {
        boolean z;
        LiveFeedConfig.AbSwitchConfig abSwitchConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, liveFollowWrapData) == null) && this.e != null) {
            LiveFeedConfig liveFeedConfig = this.i;
            if (liveFeedConfig != null && (abSwitchConfig = liveFeedConfig.abSwitchConfig) != null && abSwitchConfig.otherNewStyle) {
                z = true;
            } else {
                z = false;
            }
            this.e.y(liveFollowWrapData, z, this.i);
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                j0();
                i50.H(this.c);
                return;
            }
            O(false);
        }
    }

    public final void K(int i) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.A(i);
        }
    }

    public final void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.j0(false);
            }
            if (z) {
                q50.d("sp_search_guide_show", true);
            }
        }
    }

    public void T(String str) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.P(str);
        }
    }

    public void V(ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLoadMoreListener) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.R(onLoadMoreListener);
        }
    }

    public void X(ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onRefreshListener) == null) {
            if (this.A) {
                LiveTabFeedView liveTabFeedView = this.e;
                if (liveTabFeedView != null) {
                    liveTabFeedView.S(onRefreshListener);
                    return;
                }
                return;
            }
            this.w = onRefreshListener;
            i0();
        }
    }

    public void Y(int i) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.T(i);
        }
    }

    public final void g0(LiveBannerWrapData liveBannerWrapData) {
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

    public final void M(LiveFeedToolWrapData liveFeedToolWrapData, LiveFeedConfig liveFeedConfig) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, liveFeedToolWrapData, liveFeedConfig) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.C(liveFeedToolWrapData, liveFeedConfig);
        }
    }

    public LiveFeedFollowView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getFeedFollowView();
            }
            return null;
        }
        return (LiveFeedFollowView) invokeV.objValue;
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public RecyclerView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getMSubTipLayout();
            }
            return null;
        }
        return (RecyclerView) invokeV.objValue;
    }

    public SmartTabLayout D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getMSmartTabLayout();
            }
            return null;
        }
        return (SmartTabLayout) invokeV.objValue;
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getMViewPager();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.D();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.L();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.k0();
            }
            i0();
        }
    }

    public final void S() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.M();
        }
    }

    public void W() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.S(null);
        }
    }

    public final void Z() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.U();
        }
    }

    public void b0() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.W();
        }
    }

    public void c0() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.X();
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            O(true);
            i50.G(this.c);
            LiveFeedPageSdk.getInstance().startLiveSearchActivity(this.c);
        }
    }

    public final void i0() {
        LiveFeedModel liveFeedModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (liveFeedModel = this.f) != null) {
            liveFeedModel.reqInit(this.x);
        }
    }

    public final void j0() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && !q50.a("sp_search_guide_show", false) && (liveTabFeedView = this.e) != null) {
            liveTabFeedView.j0(true);
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.c != null && this.n) {
            LiveFeedPageSdk.liveLog("解注册网络变化广播");
            this.c.unregisterReceiver(this.B);
            this.n = false;
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.u();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.v();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void F(LiveFeedConfig liveFeedConfig) {
        boolean z;
        LiveFeedConfig.AbSwitchConfig abSwitchConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, liveFeedConfig) == null) {
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

    public final void G(LiveFeedData liveFeedData) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, liveFeedData) == null) && liveFeedData != null) {
            F(liveFeedData.feedConfig);
            g0(liveFeedData.bannerWrapData);
            L(liveFeedData);
            K(t50.a());
            H(liveFeedData.followWrapData);
            M(liveFeedData.toolWrapData, liveFeedData.feedConfig);
            if (this.s && (liveTabFeedView = this.e) != null) {
                this.s = false;
                liveTabFeedView.setExpanded(false);
            }
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            LiveFeedPageSdk.liveLog("onUserVisibleHint " + this.k + " " + z);
            if (this.j == z) {
                return;
            }
            this.j = z;
            if (z) {
                a0();
                h0();
                return;
            }
            Z();
            k0();
        }
    }

    public final void J(View view2, TextView textView) {
        String defaultStartLiveScheme;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, textView) == null) {
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

    public void e0(String str, String str2) {
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

    public final void L(LiveFeedData liveFeedData) {
        LiveTabWrapData liveTabWrapData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, liveFeedData) != null) || liveFeedData == null) {
            return;
        }
        t50.b();
        if (!this.A && (liveTabWrapData = liveFeedData.tabWrapData) != null && !q70.c(liveTabWrapData.tabList)) {
            this.A = true;
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.B(liveFeedData);
            }
            if (liveFeedData.tabWrapData.isCacheData) {
                Context context = this.c;
                String str = this.a;
                String n = i50.n(this.h);
                LiveTabWrapData liveTabWrapData2 = liveFeedData.tabWrapData;
                i50.r(context, str, n, liveTabWrapData2.errCode, liveTabWrapData2.errMsg, liveFeedData.logId, liveFeedData.resource, "", "", "", liveTabWrapData2.cacheCause, "tab", liveTabWrapData2.cacheTime, System.currentTimeMillis(), 1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.b70
    /* renamed from: w */
    public void call(d50 d50Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, d50Var) == null) && d50Var != null && d50Var.a() == this.b) {
            LiveFeedPageSdk.liveLog("LiveEventBus event: " + d50Var.getClass() + GlideException.IndentedAppendable.INDENT + d50Var.a());
            if (d50Var instanceof e50) {
                LiveBannerWrapData liveBannerWrapData = ((e50) d50Var).b;
                if (liveBannerWrapData != null) {
                    g0(liveBannerWrapData);
                }
            } else if (d50Var instanceof g50) {
                LiveFollowWrapData liveFollowWrapData = ((g50) d50Var).b;
                if (liveFollowWrapData != null) {
                    H(liveFollowWrapData);
                }
            } else if (d50Var instanceof f50) {
                this.l.c();
            } else if (d50Var instanceof h50) {
                h50 h50Var = (h50) d50Var;
                boolean z = h50Var.b;
                this.y = z;
                String str = h50Var.c;
                this.z = str;
                LiveTabFeedView liveTabFeedView = this.e;
                if (liveTabFeedView != null) {
                    liveTabFeedView.l0(z, str);
                }
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LiveTabFeedView liveTabFeedView = new LiveTabFeedView(this.c);
            this.e = liveTabFeedView;
            liveTabFeedView.setFeedActionListener(new b(this));
            this.e.setFeedBannerListener(new c(this));
            this.e.setFeedFollowListener(new d(this));
            this.e.setSubTabPageListener(new e(this));
            this.e.setFeedToolListener(new f(this));
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            e70.a().e(this);
            k0();
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.Q();
            }
            this.k = true;
            t50.b();
            this.p = false;
            s60.d(String.valueOf(this.b));
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
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

    public final void h0() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (context = this.c) != null && !this.n) {
            this.o = o50.f(context);
            LiveFeedPageSdk.liveLog("注册网络变化广播");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
            this.c.registerReceiver(this.B, intentFilter);
            this.n = true;
        }
    }

    public final void z(LiveFeedData liveFeedData) {
        LiveTabWrapData liveTabWrapData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, liveFeedData) == null) {
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
            if (liveFeedData != null && (liveTabWrapData = liveFeedData.tabWrapData) != null && !q70.c(liveTabWrapData.tabList)) {
                G(liveFeedData);
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
