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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private LinkedList<PluginStatus> aHG;
    private HashSet<Integer> aHH;
    MessageListener<?> aHI;
    private TextView akc;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHG = new LinkedList<>();
        this.aHH = new HashSet<>(10);
        this.aHI = new b(this, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.plugin_error_tip_view, this);
        this.akc = (TextView) findViewById(w.h.plugin_error_guide);
        findViewById(w.h.plugin_error_close).setOnClickListener(new c(this));
        setOnClickListener(this);
        List<PluginStatus> ki = com.baidu.adp.plugin.packageManager.status.a.kh().ki();
        if (ki != null && ki.size() > 0) {
            this.aHG.addAll(ki);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.aHI);
        MessageManager.getInstance().registerListener(2000990, this.aHI);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aHI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.aHG.size() > 0) {
            PluginStatus last = this.aHG.getLast();
            if (!this.aHH.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.jk().B("plugin_load_tip", last.kf());
                } else {
                    com.baidu.adp.plugin.b.a.jk().B("plugin_install_tip", last.kf());
                }
                this.akc.setText(String.valueOf(last.getErrorMsg()) + getResources().getString(w.l.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aHG != null && !this.aHG.isEmpty()) {
            PluginStatus last = this.aHG.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.aHG.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.jk().B("plugin_load_tipclick", last.kf());
            } else {
                com.baidu.adp.plugin.b.a.jk().B("plugin_install_tipclick", last.kf());
            }
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this);
        }
        aq.d(this, w.g.nonetworkview_bg_selector, i);
    }
}
