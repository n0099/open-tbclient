package com.baidu.tbadk.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.c.a.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TextView f12903e;

    /* renamed from: f  reason: collision with root package name */
    public Context f12904f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<PluginStatus> f12905g;

    /* renamed from: h  reason: collision with root package name */
    public HashSet<Integer> f12906h;

    /* renamed from: i  reason: collision with root package name */
    public MessageListener<?> f12907i;
    public MessageListener<?> j;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PluginStatus)) {
                return;
            }
            PluginErrorTipView.this.f12905g.add((PluginStatus) customResponsedMessage.getData());
            PluginErrorTipView.this.f();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PluginStatus)) {
                return;
            }
            PluginStatus pluginStatus = (PluginStatus) customResponsedMessage.getData();
            synchronized (PluginErrorTipView.this.f12905g) {
                Iterator it = PluginErrorTipView.this.f12905g.iterator();
                while (it.hasNext()) {
                    PluginStatus pluginStatus2 = (PluginStatus) it.next();
                    if (StringHelper.equals(pluginStatus.getPkgName(), pluginStatus2.getPkgName())) {
                        PluginErrorTipView.this.f12905g.remove(pluginStatus2);
                    }
                }
            }
            PluginErrorTipView.this.f();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PluginErrorTipView.this.f12905g.size() > 0) {
                PluginErrorTipView.this.f12906h.add(Integer.valueOf(((PluginStatus) PluginErrorTipView.this.f12905g.getLast()).getErrorCode()));
            }
            PluginErrorTipView.this.setVisibility(8);
        }
    }

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public final void d(Context context, AttributeSet attributeSet) {
        this.f12904f = context;
        LayoutInflater.from(context).inflate(R.layout.plugin_error_tip_view, this);
        this.f12903e = (TextView) findViewById(R.id.plugin_error_guide);
        findViewById(R.id.plugin_error_close).setOnClickListener(new c());
        setOnClickListener(this);
        List<PluginStatus> a2 = d.a.c.h.j.h.a.b().a();
        if (a2 != null && a2.size() > 0) {
            this.f12905g.addAll(a2);
            f();
            return;
        }
        setVisibility(8);
    }

    public void e(f<?> fVar, int i2) {
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(i2 == 1);
            tbPageContext.getLayoutMode().j(this);
        }
        SkinManager.setBackgroundResource(this, R.drawable.nonetworkview_bg_selector, i2);
    }

    public final void f() {
        if (this.f12905g.size() > 0) {
            PluginStatus last = this.f12905g.getLast();
            if (this.f12906h.contains(Integer.valueOf(last.getErrorCode()))) {
                return;
            }
            if (last.getErrorCode() >= 100) {
                d.a.c.h.h.a.b().i("plugin_load_tip", last.getPkgName());
            } else {
                d.a.c.h.h.a.b().i("plugin_install_tip", last.getPkgName());
            }
            TextView textView = this.f12903e;
            textView.setText(last.getErrorMsg() + getResources().getString(R.string.pluginstatus_click_detail));
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.f12907i);
        MessageManager.getInstance().registerListener(2000992, this.j);
        MessageManager.getInstance().registerListener(2000990, this.f12907i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinkedList<PluginStatus> linkedList = this.f12905g;
        if (linkedList == null || linkedList.isEmpty()) {
            return;
        }
        PluginStatus last = this.f12905g.getLast();
        PluginErrorTipActivity.startByPlugiStatus(this.f12904f, last);
        this.f12905g.clear();
        f();
        if (last.getErrorCode() >= 100) {
            d.a.c.h.h.a.b().i("plugin_load_tipclick", last.getPkgName());
        } else {
            d.a.c.h.h.a.b().i("plugin_install_tipclick", last.getPkgName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.f12907i);
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12905g = new LinkedList<>();
        this.f12906h = new HashSet<>(10);
        this.f12907i = new a(0);
        this.j = new b(0);
        d(context, attributeSet);
    }
}
