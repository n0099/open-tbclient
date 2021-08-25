package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.u.j;
import c.a.q0.i3.i0.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class NestedScrollHeader extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PublishButton f51984e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f51985f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51986g;

    /* renamed from: h  reason: collision with root package name */
    public f f51987h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f51988i;

    /* renamed from: j  reason: collision with root package name */
    public float f51989j;
    public View k;
    public ImageView l;
    public Context m;
    public View.OnClickListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NestedScrollHeader f51990e;

        public a(NestedScrollHeader nestedScrollHeader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51990e = nestedScrollHeader;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(api = 16)
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f51990e.getLayoutParams() instanceof AppBarLayout.LayoutParams) {
                    AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) this.f51990e.getLayoutParams();
                    layoutParams.setScrollFlags(5);
                    this.f51990e.setLayoutParams(layoutParams);
                }
                this.f51990e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51991a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NestedScrollHeader f51992b;

        public b(NestedScrollHeader nestedScrollHeader, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51992b = nestedScrollHeader;
            this.f51991a = str;
        }

        @Override // c.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // c.a.e.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar == null || aVar.p() == null || aVar.p().isRecycled()) {
                    this.f51992b.f51988i = null;
                    this.f51992b.f51985f.setImageResource(R.drawable.icon_mask_coin44);
                    this.f51992b.f51985f.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                this.f51992b.f51988i = aVar.p();
                this.f51992b.f51985f.setImageBitmap(this.f51992b.f51988i);
                this.f51992b.f51985f.setTag(R.id.homepage_mission_entrance_url, this.f51991a);
                this.f51992b.f51985f.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NestedScrollHeader f51993e;

        public c(NestedScrollHeader nestedScrollHeader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51993e = nestedScrollHeader;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                try {
                    if (this.f51993e.f51985f == view) {
                        Object tag = this.f51993e.f51985f.getTag(R.id.homepage_mission_entrance_url);
                        if (tag instanceof String) {
                            String str = (String) tag;
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            if (this.f51993e.f51987h != null) {
                                this.f51993e.f51987h.a(str);
                            }
                            this.f51993e.l();
                        }
                    } else if (this.f51993e.f51986g != view) {
                        if (this.f51993e.f51984e != view) {
                            if (this.f51993e.l == view) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("open_flag", "1");
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.f51993e.m, "GameCenterListPage", hashMap)));
                            }
                        } else if (WriteActivityConfig.isAsyncWriting()) {
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new j(1)));
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.UBS_TEST_PUBLISH_BUTTON_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(this.f51993e.getContext(), "", false)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NestedScrollHeader f51994a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(NestedScrollHeader nestedScrollHeader, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader, Integer.valueOf(i2)};
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
            this.f51994a = nestedScrollHeader;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f51994a.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NestedScrollHeader f51995a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(NestedScrollHeader nestedScrollHeader, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader, Integer.valueOf(i2)};
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
            this.f51995a = nestedScrollHeader;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && this.f51995a.f51985f.getVisibility() == 0) {
                this.f51995a.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
        }
    }

    public ImageView getTaskView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51985f : (ImageView) invokeV.objValue;
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4012);
            this.m = context;
            LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
            this.f51984e = (PublishButton) findViewById(R.id.publish_btn);
            this.f51985f = (TbImageView) findViewById(R.id.task);
            this.f51986g = (TextView) findViewById(R.id.search);
            this.k = findViewById(R.id.game_layout);
            this.l = (ImageView) findViewById(R.id.game_center);
            this.f51984e.setOnClickListener(this.n);
            this.f51985f.setOnClickListener(this.n);
            this.f51986g.setOnClickListener(this.n);
            this.l.setOnClickListener(this.n);
            if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.p);
            getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
            m();
            onChangeSkinType();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4013);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
            statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
            String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
            if (!TextUtils.isEmpty(missionEntranceUrl) && !TextUtils.isEmpty(missionEntranceIcon)) {
                c.a.e.e.l.d.h().m(missionEntranceIcon, 10, new b(this, missionEntranceUrl), null);
                return;
            }
            this.f51988i = null;
            this.f51985f.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.f51985f.setImageResource(R.drawable.icon_mask_coin44);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.f51986g);
            d2.u(R.color.CAM_X0109);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0210);
            SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - this.f51989j, TbadkCoreApplication.getInst().getSkinType());
            WebPManager.setMaskDrawable(this.l, R.drawable.icon_home_new_games, WebPManager.ResourceStateType.NORMAL);
            Bitmap bitmap = this.f51988i;
            if (bitmap == null) {
                SkinManager.setImageResource(this.f51985f, R.drawable.icon_mask_coin44);
            } else {
                TbImageView tbImageView = this.f51985f;
                if (tbImageView != null) {
                    tbImageView.setImageBitmap(bitmap);
                }
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_search_scan, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL);
            pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
            this.f51986g.setCompoundDrawables(pureDrawable, null, null, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5009);
            super.onLayout(z, i2, i3, i4, i5);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5010);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5001);
            super.onMeasure(i2, i3);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5002);
        }
    }

    public void setEntranceJumpListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.f51987h = fVar;
        }
    }

    public void setGameLayoutVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.k.setVisibility(z ? 0 : 8);
        }
    }

    public void setSearchHint(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f51986g.setText(str);
    }

    public void setTaskViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f51985f.setVisibility(z ? 0 : 8);
        }
    }

    public void updateContentAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048590, this, f2) == null) || f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.f51989j = f2;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
        if (this.f51985f.getVisibility() == 0 && this.f51985f.getAlpha() != f2) {
            this.f51985f.setAlpha(f2);
        }
        if (this.l.getVisibility() == 0 && this.l.getAlpha() != f2) {
            this.l.setAlpha(f2);
        }
        if (this.f51986g.getAlpha() != f2) {
            this.f51986g.setAlpha(f2);
        }
        if (this.f51984e.getVisibility() != 0 || this.f51984e.getAlpha() == f2) {
            return;
        }
        this.f51984e.setAlpha(f2);
        this.f51984e.setScrollAlpha(f2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f51989j = 1.0f;
        this.n = new c(this);
        this.o = new d(this, 2921396);
        this.p = new e(this, 2001371);
        k(context);
    }
}
