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
import d.b.b.a.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TextView f13989e;

    /* renamed from: f  reason: collision with root package name */
    public Context f13990f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<PluginStatus> f13991g;

    /* renamed from: h  reason: collision with root package name */
    public HashSet<Integer> f13992h;
    public MessageListener<?> i;
    public MessageListener<?> j;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PluginStatus)) {
                return;
            }
            PluginErrorTipView.this.f13991g.add((PluginStatus) customResponsedMessage.getData());
            PluginErrorTipView.this.f();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PluginStatus)) {
                return;
            }
            PluginStatus pluginStatus = (PluginStatus) customResponsedMessage.getData();
            synchronized (PluginErrorTipView.this.f13991g) {
                Iterator it = PluginErrorTipView.this.f13991g.iterator();
                while (it.hasNext()) {
                    PluginStatus pluginStatus2 = (PluginStatus) it.next();
                    if (StringHelper.equals(pluginStatus.getPkgName(), pluginStatus2.getPkgName())) {
                        PluginErrorTipView.this.f13991g.remove(pluginStatus2);
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
            if (PluginErrorTipView.this.f13991g.size() > 0) {
                PluginErrorTipView.this.f13992h.add(Integer.valueOf(((PluginStatus) PluginErrorTipView.this.f13991g.getLast()).getErrorCode()));
            }
            PluginErrorTipView.this.setVisibility(8);
        }
    }

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public final void d(Context context, AttributeSet attributeSet) {
        this.f13990f = context;
        LayoutInflater.from(context).inflate(R.layout.plugin_error_tip_view, this);
        this.f13989e = (TextView) findViewById(R.id.plugin_error_guide);
        findViewById(R.id.plugin_error_close).setOnClickListener(new c());
        setOnClickListener(this);
        List<PluginStatus> a2 = d.b.b.h.j.h.a.b().a();
        if (a2 != null && a2.size() > 0) {
            this.f13991g.addAll(a2);
            f();
            return;
        }
        setVisibility(8);
    }

    public void e(f<?> fVar, int i) {
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(i == 1);
            tbPageContext.getLayoutMode().j(this);
        }
        SkinManager.setBackgroundResource(this, R.drawable.nonetworkview_bg_selector, i);
    }

    public final void f() {
        if (this.f13991g.size() > 0) {
            PluginStatus last = this.f13991g.getLast();
            if (this.f13992h.contains(Integer.valueOf(last.getErrorCode()))) {
                return;
            }
            if (last.getErrorCode() >= 100) {
                d.b.b.h.h.a.b().i("plugin_load_tip", last.getPkgName());
            } else {
                d.b.b.h.h.a.b().i("plugin_install_tip", last.getPkgName());
            }
            TextView textView = this.f13989e;
            textView.setText(last.getErrorMsg() + getResources().getString(R.string.pluginstatus_click_detail));
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.i);
        MessageManager.getInstance().registerListener(2000992, this.j);
        MessageManager.getInstance().registerListener(2000990, this.i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinkedList<PluginStatus> linkedList = this.f13991g;
        if (linkedList == null || linkedList.isEmpty()) {
            return;
        }
        PluginStatus last = this.f13991g.getLast();
        PluginErrorTipActivity.startByPlugiStatus(this.f13990f, last);
        this.f13991g.clear();
        f();
        if (last.getErrorCode() >= 100) {
            d.b.b.h.h.a.b().i("plugin_load_tipclick", last.getPkgName());
        } else {
            d.b.b.h.h.a.b().i("plugin_install_tipclick", last.getPkgName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.i);
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13991g = new LinkedList<>();
        this.f13992h = new HashSet<>(10);
        this.i = new a(0);
        this.j = new b(0);
        d(context, attributeSet);
    }
}
