package com.baidu.tbadk.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private LinkedList<PluginStatus> aIU;
    private HashSet<Integer> aIV;
    MessageListener<?> aIW;
    private TextView akP;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aIU = new LinkedList<>();
        this.aIV = new HashSet<>(10);
        this.aIW = new b(this, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.plugin_error_tip_view, this);
        this.akP = (TextView) findViewById(w.h.plugin_error_guide);
        findViewById(w.h.plugin_error_close).setOnClickListener(new c(this));
        setOnClickListener(this);
        List<PluginStatus> kg = com.baidu.adp.plugin.packageManager.status.a.kf().kg();
        if (kg != null && kg.size() > 0) {
            this.aIU.addAll(kg);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.aIW);
        MessageManager.getInstance().registerListener(2000990, this.aIW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aIW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.aIU.size() > 0) {
            PluginStatus last = this.aIU.getLast();
            if (!this.aIV.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.jj().B("plugin_load_tip", last.kd());
                } else {
                    com.baidu.adp.plugin.b.a.jj().B("plugin_install_tip", last.kd());
                }
                this.akP.setText(String.valueOf(last.getErrorMsg()) + getResources().getString(w.l.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aIU != null && !this.aIU.isEmpty()) {
            PluginStatus last = this.aIU.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.aIU.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.jj().B("plugin_load_tipclick", last.kd());
            } else {
                com.baidu.adp.plugin.b.a.jj().B("plugin_install_tipclick", last.kd());
            }
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this);
        }
        as.d(this, w.g.nonetworkview_bg_selector, i);
    }
}
