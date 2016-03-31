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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private LinkedList<com.baidu.adp.plugin.packageManager.a.a> aCK;
    private HashSet<Integer> aCL;
    MessageListener<?> aCM;
    private TextView agk;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCK = new LinkedList<>();
        this.aCL = new HashSet<>(10);
        this.aCM = new b(this, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.plugin_error_tip_view, this);
        this.agk = (TextView) findViewById(t.g.plugin_error_guide);
        findViewById(t.g.plugin_error_close).setOnClickListener(new c(this));
        setOnClickListener(this);
        List<com.baidu.adp.plugin.packageManager.a.a> mb = com.baidu.adp.plugin.packageManager.a.b.ma().mb();
        if (mb != null && mb.size() > 0) {
            this.aCK.addAll(mb);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.aCM);
        MessageManager.getInstance().registerListener(2000990, this.aCM);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aCM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.aCK.size() > 0) {
            com.baidu.adp.plugin.packageManager.a.a last = this.aCK.getLast();
            if (!this.aCL.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.lf().E("plugin_load_tip", last.getPkgName());
                } else {
                    com.baidu.adp.plugin.b.a.lf().E("plugin_install_tip", last.getPkgName());
                }
                this.agk.setText(String.valueOf(last.getErrorMsg()) + getResources().getString(t.j.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCK != null && !this.aCK.isEmpty()) {
            com.baidu.adp.plugin.packageManager.a.a last = this.aCK.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.aCK.clear();
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
            ((TbPageContext) hVar).getLayoutMode().ab(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        at.c(this, t.f.nonetworkview_bg_selector, i);
    }
}
