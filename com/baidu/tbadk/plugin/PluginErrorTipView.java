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
import com.baidu.tieba.t;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private LinkedList<com.baidu.adp.plugin.packageManager.a.a> aDA;
    private HashSet<Integer> aDB;
    MessageListener<?> aDC;
    private TextView afD;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDA = new LinkedList<>();
        this.aDB = new HashSet<>(10);
        this.aDC = new b(this, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.plugin_error_tip_view, this);
        this.afD = (TextView) findViewById(t.g.plugin_error_guide);
        findViewById(t.g.plugin_error_close).setOnClickListener(new c(this));
        setOnClickListener(this);
        List<com.baidu.adp.plugin.packageManager.a.a> jm = com.baidu.adp.plugin.packageManager.a.b.jl().jm();
        if (jm != null && jm.size() > 0) {
            this.aDA.addAll(jm);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.aDC);
        MessageManager.getInstance().registerListener(2000990, this.aDC);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aDC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.aDA.size() > 0) {
            com.baidu.adp.plugin.packageManager.a.a last = this.aDA.getLast();
            if (!this.aDB.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.io().D("plugin_load_tip", last.jj());
                } else {
                    com.baidu.adp.plugin.b.a.io().D("plugin_install_tip", last.jj());
                }
                this.afD.setText(String.valueOf(last.getErrorMsg()) + getResources().getString(t.j.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aDA != null && !this.aDA.isEmpty()) {
            com.baidu.adp.plugin.packageManager.a.a last = this.aDA.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.aDA.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.io().D("plugin_load_tipclick", last.jj());
            } else {
                com.baidu.adp.plugin.b.a.io().D("plugin_install_tipclick", last.jj());
            }
        }
    }

    public void onChangeSkinType(h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        av.d(this, t.f.nonetworkview_bg_selector, i);
    }
}
