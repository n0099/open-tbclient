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
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.repackage.co;
import com.repackage.fg;
import com.repackage.gg;
import com.repackage.gs4;
import com.repackage.h05;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class NestedScrollHeader extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public PublishButton b;
    public TbImageView c;
    public TextView d;
    public f e;
    public Bitmap f;
    public float g;
    public View h;
    public ImageView i;
    public Context j;
    public View.OnClickListener k;
    public CustomMessageListener l;
    public CustomMessageListener m;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollHeader a;

        public a(NestedScrollHeader nestedScrollHeader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollHeader;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(api = 16)
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.getLayoutParams() instanceof AppBarLayout.LayoutParams) {
                    AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) this.a.getLayoutParams();
                    layoutParams.setScrollFlags(5);
                    this.a.setLayoutParams(layoutParams);
                }
                this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends fg<co> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ NestedScrollHeader b;

        public b(NestedScrollHeader nestedScrollHeader, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nestedScrollHeader;
            this.a = str;
        }

        @Override // com.repackage.fg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.repackage.fg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        public void onLoaded(co coVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coVar, str, i) == null) {
                super.onLoaded((b) coVar, str, i);
                if (coVar == null || coVar.p() == null || coVar.p().isRecycled()) {
                    this.b.f = null;
                    this.b.c.setImageResource(R.drawable.obfuscated_res_0x7f0807c3);
                    this.b.c.setTag(R.id.obfuscated_res_0x7f090d9c, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                this.b.f = coVar.p();
                this.b.c.setImageBitmap(this.b.f);
                this.b.c.setTag(R.id.obfuscated_res_0x7f090d9c, this.a);
                this.b.c.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollHeader a;

        public c(NestedScrollHeader nestedScrollHeader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollHeader;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                try {
                    if (this.a.c == view2) {
                        Object tag = this.a.c.getTag(R.id.obfuscated_res_0x7f090d9c);
                        if (tag instanceof String) {
                            String str = (String) tag;
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            if (this.a.e != null) {
                                this.a.e.a(str);
                            }
                            this.a.m();
                        }
                    } else if (this.a.d != view2) {
                        if (this.a.b != view2) {
                            if (this.a.i == view2) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("open_flag", "1");
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.j, "GameCenterListPage", hashMap)));
                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_GAMECENTER).param("obj_type", "1"));
                            }
                        } else if (WriteActivityConfig.isAsyncWriting()) {
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new h05(1)));
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.UBS_TEST_PUBLISH_BUTTON_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(this.a.getContext(), "", false)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollHeader a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(NestedScrollHeader nestedScrollHeader, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader, Integer.valueOf(i)};
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
            this.a = nestedScrollHeader;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollHeader a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(NestedScrollHeader nestedScrollHeader, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader, Integer.valueOf(i)};
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
            this.a = nestedScrollHeader;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && this.a.c.getVisibility() == 0) {
                this.a.o();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (ImageView) invokeV.objValue;
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4012);
            this.j = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04a5, (ViewGroup) this, true);
            this.b = (PublishButton) findViewById(R.id.obfuscated_res_0x7f091998);
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091f36);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091c53);
            this.h = findViewById(R.id.obfuscated_res_0x7f090c3c);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c30);
            this.b.setOnClickListener(this.k);
            this.d.setOnClickListener(this.k);
            this.i.setOnClickListener(this.k);
            if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
            getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
            n();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4013);
        }
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.c.setOnClickListener(this.k);
            MessageManager.getInstance().registerListener(this.l);
            MessageManager.getInstance().registerListener(this.m);
            o();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
            statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
            TiebaStatic.log(statisticItem);
        }
    }

    public void n() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        gs4 d2 = gs4.d(this.d);
        d2.v(R.color.CAM_X0109);
        d2.n(R.string.J_X01);
        d2.f(R.color.CAM_X0210);
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - this.g, TbadkCoreApplication.getInst().getSkinType());
        WebPManager.setMaskDrawable(this.i, R.drawable.icon_home_new_games, WebPManager.ResourceStateType.NORMAL);
        Bitmap bitmap = this.f;
        if (bitmap == null) {
            SkinManager.setImageResource(this.c, R.drawable.obfuscated_res_0x7f0807c3);
        } else {
            TbImageView tbImageView = this.c;
            if (tbImageView != null) {
                tbImageView.setImageBitmap(bitmap);
            }
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a29, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL);
        pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
        this.d.setCompoundDrawables(pureDrawable, null, null, null);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
            String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
            if (!TextUtils.isEmpty(missionEntranceUrl) && !TextUtils.isEmpty(missionEntranceIcon)) {
                gg.h().m(missionEntranceIcon, 10, new b(this, missionEntranceUrl), null);
                return;
            }
            this.f = null;
            this.c.setTag(R.id.obfuscated_res_0x7f090d9c, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.c.setImageResource(R.drawable.obfuscated_res_0x7f0807c3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.l);
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5009);
            super.onLayout(z, i, i2, i3, i4);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5010);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5001);
            super.onMeasure(i, i2);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5002);
        }
    }

    public void p(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048587, this, f2) == null) || f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.g = f2;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
        if (this.c.getVisibility() == 0 && this.c.getAlpha() != f2) {
            this.c.setAlpha(f2);
        }
        if (this.i.getVisibility() == 0 && this.i.getAlpha() != f2) {
            this.i.setAlpha(f2);
        }
        if (this.d.getAlpha() != f2) {
            this.d.setAlpha(f2);
        }
        if (this.b.getVisibility() != 0 || this.b.getAlpha() == f2) {
            return;
        }
        this.b.setAlpha(f2);
        this.b.setScrollAlpha(f2);
    }

    public void setEntranceJumpListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            this.e = fVar;
        }
    }

    public void setGameLayoutVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.h.setVisibility(z ? 0 : 8);
        }
    }

    public void setSearchHint(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.d.setText(str);
    }

    public void setTaskViewVisible(boolean z) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (tbImageView = this.c) == null) {
            return;
        }
        tbImageView.setVisibility(z ? 0 : 8);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.g = 1.0f;
        this.k = new c(this);
        this.l = new d(this, 2921396);
        this.m = new e(this, 2001371);
        k(context);
    }
}
