package com.baidu.tbadk.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private TextView acd;
    private LinkedList<com.baidu.adp.plugin.packageManager.a.a> azD;
    private HashSet<Integer> azE;
    MessageListener<?> azF;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azD = new LinkedList<>();
        this.azE = new HashSet<>(10);
        this.azF = new b(this, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(u.h.plugin_error_tip_view, this);
        this.acd = (TextView) findViewById(u.g.plugin_error_guide);
        findViewById(u.g.plugin_error_close).setOnClickListener(new c(this));
        setOnClickListener(this);
        List<com.baidu.adp.plugin.packageManager.a.a> is = com.baidu.adp.plugin.packageManager.a.b.ir().is();
        if (is != null && is.size() > 0) {
            this.azD.addAll(is);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.azF);
        MessageManager.getInstance().registerListener(2000990, this.azF);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.azF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.azD.size() > 0) {
            com.baidu.adp.plugin.packageManager.a.a last = this.azD.getLast();
            if (!this.azE.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.hu().D("plugin_load_tip", last.ip());
                } else {
                    com.baidu.adp.plugin.b.a.hu().D("plugin_install_tip", last.ip());
                }
                this.acd.setText(String.valueOf(last.getErrorMsg()) + getResources().getString(u.j.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.azD != null && !this.azD.isEmpty()) {
            com.baidu.adp.plugin.packageManager.a.a last = this.azD.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.azD.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.hu().D("plugin_load_tipclick", last.ip());
            } else {
                com.baidu.adp.plugin.b.a.hu().D("plugin_install_tipclick", last.ip());
            }
        }
    }

    public void onChangeSkinType(h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(i == 1);
            ((TbPageContext) hVar).getLayoutMode().w(this);
        }
        av.d(this, u.f.nonetworkview_bg_selector, i);
    }
}
