package com.baidu.tbadk.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.a.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f48454e;

    /* renamed from: f  reason: collision with root package name */
    public Context f48455f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<PluginStatus> f48456g;

    /* renamed from: h  reason: collision with root package name */
    public HashSet<Integer> f48457h;

    /* renamed from: i  reason: collision with root package name */
    public MessageListener<?> f48458i;

    /* renamed from: j  reason: collision with root package name */
    public MessageListener<?> f48459j;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PluginErrorTipView f48460a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PluginErrorTipView pluginErrorTipView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginErrorTipView, Integer.valueOf(i2)};
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
            this.f48460a = pluginErrorTipView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                this.f48460a.f48456g.add((PluginStatus) customResponsedMessage.getData());
                this.f48460a.e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PluginErrorTipView f48461a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PluginErrorTipView pluginErrorTipView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginErrorTipView, Integer.valueOf(i2)};
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
            this.f48461a = pluginErrorTipView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                PluginStatus pluginStatus = (PluginStatus) customResponsedMessage.getData();
                synchronized (this.f48461a.f48456g) {
                    Iterator it = this.f48461a.f48456g.iterator();
                    while (it.hasNext()) {
                        PluginStatus pluginStatus2 = (PluginStatus) it.next();
                        if (StringHelper.equals(pluginStatus.getPkgName(), pluginStatus2.getPkgName())) {
                            this.f48461a.f48456g.remove(pluginStatus2);
                        }
                    }
                }
                this.f48461a.e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginErrorTipView f48462e;

        public c(PluginErrorTipView pluginErrorTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginErrorTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48462e = pluginErrorTipView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f48462e.f48456g.size() > 0) {
                    this.f48462e.f48457h.add(Integer.valueOf(((PluginStatus) this.f48462e.f48456g.getLast()).getErrorCode()));
                }
                this.f48462e.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PluginErrorTipView(Context context) {
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

    public final void d(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) {
            this.f48455f = context;
            LayoutInflater.from(context).inflate(R.layout.plugin_error_tip_view, this);
            this.f48454e = (TextView) findViewById(R.id.plugin_error_guide);
            findViewById(R.id.plugin_error_close).setOnClickListener(new c(this));
            setOnClickListener(this);
            List<PluginStatus> a2 = c.a.e.h.j.h.a.b().a();
            if (a2 != null && a2.size() > 0) {
                this.f48456g.addAll(a2);
                e();
                return;
            }
            setVisibility(8);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f48456g.size() > 0) {
                PluginStatus last = this.f48456g.getLast();
                if (this.f48457h.contains(Integer.valueOf(last.getErrorCode()))) {
                    return;
                }
                if (last.getErrorCode() >= 100) {
                    c.a.e.h.h.a.b().i("plugin_load_tip", last.getPkgName());
                } else {
                    c.a.e.h.h.a.b().i("plugin_install_tip", last.getPkgName());
                }
                TextView textView = this.f48454e;
                textView.setText(last.getErrorMsg() + getResources().getString(R.string.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(2000991, this.f48458i);
            MessageManager.getInstance().registerListener(2000992, this.f48459j);
            MessageManager.getInstance().registerListener(2000990, this.f48458i);
        }
    }

    public void onChangeSkinType(f<?> fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, fVar, i2) == null) {
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(i2 == 1);
                tbPageContext.getLayoutMode().j(this);
            }
            SkinManager.setBackgroundResource(this, R.drawable.nonetworkview_bg_selector, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinkedList<PluginStatus> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (linkedList = this.f48456g) == null || linkedList.isEmpty()) {
            return;
        }
        PluginStatus last = this.f48456g.getLast();
        PluginErrorTipActivity.startByPlugiStatus(this.f48455f, last);
        this.f48456g.clear();
        e();
        if (last.getErrorCode() >= 100) {
            c.a.e.h.h.a.b().i("plugin_load_tipclick", last.getPkgName());
        } else {
            c.a.e.h.h.a.b().i("plugin_install_tipclick", last.getPkgName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.f48458i);
            MessageManager.getInstance().unRegisterListener(this.f48459j);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
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
    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f48456g = new LinkedList<>();
        this.f48457h = new HashSet<>(10);
        this.f48458i = new a(this, 0);
        this.f48459j = new b(this, 0);
        d(context, attributeSet);
    }
}
