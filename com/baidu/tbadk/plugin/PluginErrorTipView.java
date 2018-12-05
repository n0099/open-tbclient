package com.baidu.tbadk.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private TextView aHX;
    private LinkedList<PluginStatus> bhg;
    private HashSet<Integer> bhh;
    MessageListener<?> bhi;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bhg = new LinkedList<>();
        this.bhh = new HashSet<>(10);
        this.bhi = new CustomMessageListener(0) { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                    PluginErrorTipView.this.bhg.add((PluginStatus) customResponsedMessage.getData());
                    PluginErrorTipView.this.update();
                }
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.plugin_error_tip_view, this);
        this.aHX = (TextView) findViewById(e.g.plugin_error_guide);
        findViewById(e.g.plugin_error_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PluginErrorTipView.this.bhg.size() > 0) {
                    PluginErrorTipView.this.bhh.add(Integer.valueOf(((PluginStatus) PluginErrorTipView.this.bhg.getLast()).getErrorCode()));
                }
                PluginErrorTipView.this.setVisibility(8);
            }
        });
        setOnClickListener(this);
        List<PluginStatus> nK = com.baidu.adp.plugin.packageManager.status.a.nJ().nK();
        if (nK != null && nK.size() > 0) {
            this.bhg.addAll(nK);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.bhi);
        MessageManager.getInstance().registerListener(2000990, this.bhi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bhi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.bhg.size() > 0) {
            PluginStatus last = this.bhg.getLast();
            if (!this.bhh.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.mN().I("plugin_load_tip", last.nH());
                } else {
                    com.baidu.adp.plugin.b.a.mN().I("plugin_install_tip", last.nH());
                }
                this.aHX.setText(last.getErrorMsg() + getResources().getString(e.j.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bhg != null && !this.bhg.isEmpty()) {
            PluginStatus last = this.bhg.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.bhg.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.mN().I("plugin_load_tipclick", last.nH());
            } else {
                com.baidu.adp.plugin.b.a.mN().I("plugin_install_tipclick", last.nH());
            }
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(i == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this);
        }
        al.d(this, e.f.nonetworkview_bg_selector, i);
    }
}
