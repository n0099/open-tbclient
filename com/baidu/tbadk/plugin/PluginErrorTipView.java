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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private LinkedList<com.baidu.adp.plugin.packageManager.a.a> aAX;
    private HashSet<Integer> aAY;
    MessageListener<?> aAZ;
    private TextView afW;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aAX = new LinkedList<>();
        this.aAY = new HashSet<>(10);
        this.aAZ = new b(this, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(n.h.plugin_error_tip_view, this);
        this.afW = (TextView) findViewById(n.g.plugin_error_guide);
        findViewById(n.g.plugin_error_close).setOnClickListener(new c(this));
        setOnClickListener(this);
        List<com.baidu.adp.plugin.packageManager.a.a> lW = com.baidu.adp.plugin.packageManager.a.b.lV().lW();
        if (lW != null && lW.size() > 0) {
            this.aAX.addAll(lW);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.aAZ);
        MessageManager.getInstance().registerListener(2000990, this.aAZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aAZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.aAX.size() > 0) {
            com.baidu.adp.plugin.packageManager.a.a last = this.aAX.getLast();
            if (!this.aAY.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.lf().E("plugin_load_tip", last.getPkgName());
                } else {
                    com.baidu.adp.plugin.b.a.lf().E("plugin_install_tip", last.getPkgName());
                }
                this.afW.setText(String.valueOf(last.getErrorMsg()) + getResources().getString(n.j.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aAX != null && !this.aAX.isEmpty()) {
            com.baidu.adp.plugin.packageManager.a.a last = this.aAX.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.aAX.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.lf().E("plugin_load_tipclick", last.getPkgName());
            } else {
                com.baidu.adp.plugin.b.a.lf().E("plugin_install_tipclick", last.getPkgName());
            }
        }
    }

    public void onChangeSkinType(h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ac(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        as.c(this, n.f.nonetworkview_bg_selector, i);
    }
}
