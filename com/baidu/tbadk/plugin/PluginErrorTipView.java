package com.baidu.tbadk.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private LinkedList<PluginStatus> aCg;
    private HashSet<Integer> aCh;
    MessageListener<?> aCi;
    private TextView afi;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCg = new LinkedList<>();
        this.aCh = new HashSet<>(10);
        this.aCi = new b(this, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(r.j.plugin_error_tip_view, this);
        this.afi = (TextView) findViewById(r.h.plugin_error_guide);
        findViewById(r.h.plugin_error_close).setOnClickListener(new c(this));
        setOnClickListener(this);
        List<PluginStatus> jk = com.baidu.adp.plugin.packageManager.status.a.jj().jk();
        if (jk != null && jk.size() > 0) {
            this.aCg.addAll(jk);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.aCi);
        MessageManager.getInstance().registerListener(2000990, this.aCi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aCi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.aCg.size() > 0) {
            PluginStatus last = this.aCg.getLast();
            if (!this.aCh.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.im().D("plugin_load_tip", last.jh());
                } else {
                    com.baidu.adp.plugin.b.a.im().D("plugin_install_tip", last.jh());
                }
                this.afi.setText(String.valueOf(last.getErrorMsg()) + getResources().getString(r.l.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCg != null && !this.aCg.isEmpty()) {
            PluginStatus last = this.aCg.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.aCg.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.im().D("plugin_load_tipclick", last.jh());
            } else {
                com.baidu.adp.plugin.b.a.im().D("plugin_install_tipclick", last.jh());
            }
        }
    }

    public void onChangeSkinType(g<?> gVar, int i) {
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ai(i == 1);
            ((TbPageContext) gVar).getLayoutMode().v(this);
        }
        ap.d(this, r.g.nonetworkview_bg_selector, i);
    }
}
