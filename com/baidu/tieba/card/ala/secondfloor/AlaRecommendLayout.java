package com.baidu.tieba.card.ala.secondfloor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ek6;
import com.baidu.tieba.fk6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
/* loaded from: classes5.dex */
public class AlaRecommendLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public View c;
    public TextView d;
    public BdRecyclerView e;
    public AlaRecommendListAdapter f;
    public List<AlaLiveInfo> g;
    public String h;
    public String i;
    public boolean j;
    public CustomMessageListener k;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaRecommendLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaRecommendLayout alaRecommendLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendLayout, Integer.valueOf(i)};
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
            this.a = alaRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.UpdateAttentionData data;
            AlaUserInfo alaUserInfo;
            Long l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && !data.isAttention && !StringUtils.isNull(data.toUid) && this.a.g != null) {
                for (AlaLiveInfo alaLiveInfo : this.a.g) {
                    if (alaLiveInfo != null && (alaUserInfo = alaLiveInfo.user_info) != null && (l = alaUserInfo.user_id) != null && data.toUid.equals(l.toString())) {
                        this.a.g.remove(alaLiveInfo);
                        this.a.e();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlaRecommendLayout(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.i = "0";
        this.k = new a(this, 2001115);
        this.a = context;
        b();
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.j) {
                this.b = 4;
            } else {
                this.b = i;
            }
            this.d.setTextColor(SkinManager.getColor(this.b, (int) R.color.CAM_X0105));
            this.f.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && view2 != null && view2.getId() == R.id.ala_recommend_list_more) {
            c(null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setDarkMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j = z;
            this.f.x(z);
        }
    }

    public void setData(fk6 fk6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, fk6Var) == null) && fk6Var != null && !ListUtils.isEmpty(fk6Var.c())) {
            this.g = fk6Var.c();
            this.h = fk6Var.d();
            e();
        }
    }

    public void setFid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.i = str;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.ala_recommend_layout, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.d = (TextView) findViewById(R.id.ala_recommend_list_more_text);
            View findViewById = findViewById(R.id.ala_recommend_list_more);
            this.c = findViewById;
            findViewById.setOnClickListener(this);
            this.e = (BdRecyclerView) findViewById(R.id.ala_recommend_list);
            AlaRecommendListAdapter alaRecommendListAdapter = new AlaRecommendListAdapter(this.a);
            this.f = alaRecommendListAdapter;
            this.e.setAdapter(alaRecommendListAdapter);
            this.e.setClipChildren(false);
            this.e.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
            this.e.setItemAnimator(new DefaultItemAnimator());
            int dimens = BdUtilHelper.getDimens(this.a, R.dimen.M_W_X001);
            this.e.addItemDecoration(new CommonSpaceItemDecoration(dimens, BdUtilHelper.getDimens(this.a, R.dimen.M_W_X003), dimens));
            BdRecyclerView bdRecyclerView = this.e;
            bdRecyclerView.setPadding(bdRecyclerView.getPaddingLeft(), BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds27), this.e.getPaddingRight(), BdUtilHelper.getDimens(this.e.getContext(), R.dimen.M_H_X005));
        }
    }

    public final void c(YyExtData yyExtData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yyExtData) == null) && ViewHelper.checkUpIsLogin(this.a)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveTabMyConcernActivityConfig(this.a, this.h)));
            TiebaStatic.log(ek6.d("c13624", ek6.f(this.h), YYLiveUtil.calculateLiveType(yyExtData), TiebaStatic.YYValues.YY_LIVE, this.i));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || ListUtils.isEmpty(this.g)) {
            return;
        }
        this.f.y(this.g, this.h);
        this.f.notifyDataSetChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().registerListener(this.k);
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.k);
            super.onDetachedFromWindow();
        }
    }
}
