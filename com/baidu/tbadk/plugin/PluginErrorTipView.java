package com.baidu.tbadk.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private TextView bQW;
    private LinkedList<PluginStatus> crO;
    private HashSet<Integer> crP;
    MessageListener<?> crQ;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.crO = new LinkedList<>();
        this.crP = new HashSet<>(10);
        this.crQ = new CustomMessageListener(0) { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                    PluginErrorTipView.this.crO.add((PluginStatus) customResponsedMessage.getData());
                    PluginErrorTipView.this.update();
                }
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.plugin_error_tip_view, this);
        this.bQW = (TextView) findViewById(d.g.plugin_error_guide);
        findViewById(d.g.plugin_error_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PluginErrorTipView.this.crO.size() > 0) {
                    PluginErrorTipView.this.crP.add(Integer.valueOf(((PluginStatus) PluginErrorTipView.this.crO.getLast()).getErrorCode()));
                }
                PluginErrorTipView.this.setVisibility(8);
            }
        });
        setOnClickListener(this);
        List<PluginStatus> nT = com.baidu.adp.plugin.packageManager.status.a.nS().nT();
        if (nT != null && nT.size() > 0) {
            this.crO.addAll(nT);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.crQ);
        MessageManager.getInstance().registerListener(2000990, this.crQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.crQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.crO.size() > 0) {
            PluginStatus last = this.crO.getLast();
            if (!this.crP.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.mS().H("plugin_load_tip", last.nQ());
                } else {
                    com.baidu.adp.plugin.b.a.mS().H("plugin_install_tip", last.nQ());
                }
                this.bQW.setText(last.getErrorMsg() + getResources().getString(d.j.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.crO != null && !this.crO.isEmpty()) {
            PluginStatus last = this.crO.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.crO.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.mS().H("plugin_load_tipclick", last.nQ());
            } else {
                com.baidu.adp.plugin.b.a.mS().H("plugin_install_tipclick", last.nQ());
            }
        }
    }

    public void onChangeSkinType(e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(i == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this);
        }
        al.e(this, d.f.nonetworkview_bg_selector, i);
    }
}
