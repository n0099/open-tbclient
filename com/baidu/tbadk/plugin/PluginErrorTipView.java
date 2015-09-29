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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private TextView aeh;
    private LinkedList<com.baidu.adp.plugin.packageManager.a.a> ayp;
    private HashSet<Integer> ayq;
    MessageListener<?> ayr;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ayp = new LinkedList<>();
        this.ayq = new HashSet<>(10);
        this.ayr = new b(this, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.plugin_error_tip_view, this);
        this.aeh = (TextView) findViewById(i.f.plugin_error_guide);
        findViewById(i.f.plugin_error_close).setOnClickListener(new c(this));
        setOnClickListener(this);
        List<com.baidu.adp.plugin.packageManager.a.a> mu = com.baidu.adp.plugin.packageManager.a.b.mt().mu();
        if (mu != null && mu.size() > 0) {
            this.ayp.addAll(mu);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.ayr);
        MessageManager.getInstance().registerListener(2000990, this.ayr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ayr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.ayp.size() > 0) {
            com.baidu.adp.plugin.packageManager.a.a last = this.ayp.getLast();
            if (!this.ayq.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.lF().I("plugin_load_tip", last.getPkgName());
                } else {
                    com.baidu.adp.plugin.b.a.lF().I("plugin_install_tip", last.getPkgName());
                }
                this.aeh.setText(String.valueOf(last.getErrorMsg()) + getResources().getString(i.h.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ayp != null && !this.ayp.isEmpty()) {
            com.baidu.adp.plugin.packageManager.a.a last = this.ayp.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.ayp.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.lF().I("plugin_load_tipclick", last.getPkgName());
            } else {
                com.baidu.adp.plugin.b.a.lF().I("plugin_install_tipclick", last.getPkgName());
            }
        }
    }

    public void onChangeSkinType(h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        am.c(this, i.e.nonetworkview_bg_selector, i);
    }
}
