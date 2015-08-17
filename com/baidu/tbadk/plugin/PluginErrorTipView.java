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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private TextView aeL;
    private LinkedList<com.baidu.adp.plugin.packageManager.a.a> ayi;
    private HashSet<Integer> ayj;
    MessageListener<?> ayk;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ayi = new LinkedList<>();
        this.ayj = new HashSet<>(10);
        this.ayk = new b(this, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.plugin_error_tip_view, this);
        this.aeL = (TextView) findViewById(i.f.plugin_error_guide);
        findViewById(i.f.plugin_error_close).setOnClickListener(new c(this));
        setOnClickListener(this);
        List<com.baidu.adp.plugin.packageManager.a.a> mw = com.baidu.adp.plugin.packageManager.a.b.mv().mw();
        if (mw != null && mw.size() > 0) {
            this.ayi.addAll(mw);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.ayk);
        MessageManager.getInstance().registerListener(2000990, this.ayk);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ayk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.ayi.size() > 0) {
            com.baidu.adp.plugin.packageManager.a.a last = this.ayi.getLast();
            if (!this.ayj.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.lH().bi("plugin_load_tip");
                } else {
                    com.baidu.adp.plugin.b.a.lH().bi("plugin_install_tip");
                }
                this.aeL.setText(String.valueOf(last.getErrorMsg()) + getResources().getString(i.C0057i.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ayi != null && !this.ayi.isEmpty()) {
            com.baidu.adp.plugin.packageManager.a.a last = this.ayi.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.ayi.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.lH().bi("plugin_load_tipclick");
            } else {
                com.baidu.adp.plugin.b.a.lH().bi("plugin_install_tipclick");
            }
        }
    }

    public void onChangeSkinType(h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        al.c(this, i.e.nonetworkview_bg_selector, i);
    }
}
