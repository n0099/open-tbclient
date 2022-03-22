package com.baidu.tbadk.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.a.f;
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
/* loaded from: classes5.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public Context f30610b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<PluginStatus> f30611c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<Integer> f30612d;

    /* renamed from: e  reason: collision with root package name */
    public MessageListener<?> f30613e;

    /* renamed from: f  reason: collision with root package name */
    public MessageListener<?> f30614f;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginErrorTipView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PluginErrorTipView pluginErrorTipView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginErrorTipView, Integer.valueOf(i)};
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
            this.a = pluginErrorTipView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                this.a.f30611c.add((PluginStatus) customResponsedMessage.getData());
                this.a.update();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginErrorTipView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PluginErrorTipView pluginErrorTipView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginErrorTipView, Integer.valueOf(i)};
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
            this.a = pluginErrorTipView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                PluginStatus pluginStatus = (PluginStatus) customResponsedMessage.getData();
                synchronized (this.a.f30611c) {
                    Iterator it = this.a.f30611c.iterator();
                    while (it.hasNext()) {
                        PluginStatus pluginStatus2 = (PluginStatus) it.next();
                        if (StringHelper.equals(pluginStatus.getPkgName(), pluginStatus2.getPkgName())) {
                            this.a.f30611c.remove(pluginStatus2);
                        }
                    }
                }
                this.a.update();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginErrorTipView a;

        public c(PluginErrorTipView pluginErrorTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginErrorTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginErrorTipView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f30611c.size() > 0) {
                    this.a.f30612d.add(Integer.valueOf(((PluginStatus) this.a.f30611c.getLast()).getErrorCode()));
                }
                this.a.setVisibility(8);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if (this.f30611c.size() > 0) {
                PluginStatus last = this.f30611c.getLast();
                if (this.f30612d.contains(Integer.valueOf(last.getErrorCode()))) {
                    return;
                }
                if (last.getErrorCode() >= 100) {
                    c.a.d.j.h.a.b().i("plugin_load_tip", last.getPkgName());
                } else {
                    c.a.d.j.h.a.b().i("plugin_install_tip", last.getPkgName());
                }
                TextView textView = this.a;
                textView.setText(last.getErrorMsg() + getResources().getString(R.string.obfuscated_res_0x7f0f0e81));
                setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }

    public final void d(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) {
            this.f30610b = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06f2, this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091868);
            findViewById(R.id.obfuscated_res_0x7f091867).setOnClickListener(new c(this));
            setOnClickListener(this);
            List<PluginStatus> a2 = c.a.d.j.j.g.a.b().a();
            if (a2 != null && a2.size() > 0) {
                this.f30611c.addAll(a2);
                update();
                return;
            }
            setVisibility(8);
        }
    }

    public void e(f<?> fVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, i) == null) {
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(i == 1);
                tbPageContext.getLayoutMode().j(this);
            }
            SkinManager.setBackgroundResource(this, R.drawable.nonetworkview_bg_selector, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(2000991, this.f30613e);
            MessageManager.getInstance().registerListener(2000992, this.f30614f);
            MessageManager.getInstance().registerListener(2000990, this.f30613e);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinkedList<PluginStatus> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (linkedList = this.f30611c) == null || linkedList.isEmpty()) {
            return;
        }
        PluginStatus last = this.f30611c.getLast();
        PluginErrorTipActivity.startByPlugiStatus(this.f30610b, last);
        this.f30611c.clear();
        update();
        if (last.getErrorCode() >= 100) {
            c.a.d.j.h.a.b().i("plugin_load_tipclick", last.getPkgName());
        } else {
            c.a.d.j.h.a.b().i("plugin_install_tipclick", last.getPkgName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.f30613e);
            MessageManager.getInstance().unRegisterListener(this.f30614f);
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
    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
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
        this.f30611c = new LinkedList<>();
        this.f30612d = new HashSet<>(10);
        this.f30613e = new a(this, 0);
        this.f30614f = new b(this, 0);
        d(context, attributeSet);
    }
}
