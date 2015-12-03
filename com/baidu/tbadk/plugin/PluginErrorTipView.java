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
    private TextView afk;
    private LinkedList<com.baidu.adp.plugin.packageManager.a.a> azu;
    private HashSet<Integer> azv;
    MessageListener<?> azw;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azu = new LinkedList<>();
        this.azv = new HashSet<>(10);
        this.azw = new b(this, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(n.g.plugin_error_tip_view, this);
        this.afk = (TextView) findViewById(n.f.plugin_error_guide);
        findViewById(n.f.plugin_error_close).setOnClickListener(new c(this));
        setOnClickListener(this);
        List<com.baidu.adp.plugin.packageManager.a.a> my = com.baidu.adp.plugin.packageManager.a.b.mx().my();
        if (my != null && my.size() > 0) {
            this.azu.addAll(my);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.azw);
        MessageManager.getInstance().registerListener(2000990, this.azw);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.azw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.azu.size() > 0) {
            com.baidu.adp.plugin.packageManager.a.a last = this.azu.getLast();
            if (!this.azv.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.lI().F("plugin_load_tip", last.getPkgName());
                } else {
                    com.baidu.adp.plugin.b.a.lI().F("plugin_install_tip", last.getPkgName());
                }
                this.afk.setText(String.valueOf(last.getErrorMsg()) + getResources().getString(n.i.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.azu != null && !this.azu.isEmpty()) {
            com.baidu.adp.plugin.packageManager.a.a last = this.azu.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.azu.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.lI().F("plugin_load_tipclick", last.getPkgName());
            } else {
                com.baidu.adp.plugin.b.a.lI().F("plugin_install_tipclick", last.getPkgName());
            }
        }
    }

    public void onChangeSkinType(h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().af(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        as.c(this, n.e.nonetworkview_bg_selector, i);
    }
}
