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
    private TextView aEx;
    private LinkedList<PluginStatus> bdF;
    private HashSet<Integer> bdG;
    MessageListener<?> bdH;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdF = new LinkedList<>();
        this.bdG = new HashSet<>(10);
        this.bdH = new CustomMessageListener(0) { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                    PluginErrorTipView.this.bdF.add((PluginStatus) customResponsedMessage.getData());
                    PluginErrorTipView.this.update();
                }
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.plugin_error_tip_view, this);
        this.aEx = (TextView) findViewById(e.g.plugin_error_guide);
        findViewById(e.g.plugin_error_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PluginErrorTipView.this.bdF.size() > 0) {
                    PluginErrorTipView.this.bdG.add(Integer.valueOf(((PluginStatus) PluginErrorTipView.this.bdF.getLast()).getErrorCode()));
                }
                PluginErrorTipView.this.setVisibility(8);
            }
        });
        setOnClickListener(this);
        List<PluginStatus> nL = com.baidu.adp.plugin.packageManager.status.a.nK().nL();
        if (nL != null && nL.size() > 0) {
            this.bdF.addAll(nL);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.bdH);
        MessageManager.getInstance().registerListener(2000990, this.bdH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bdH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.bdF.size() > 0) {
            PluginStatus last = this.bdF.getLast();
            if (!this.bdG.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.mO().I("plugin_load_tip", last.nI());
                } else {
                    com.baidu.adp.plugin.b.a.mO().I("plugin_install_tip", last.nI());
                }
                this.aEx.setText(last.getErrorMsg() + getResources().getString(e.j.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bdF != null && !this.bdF.isEmpty()) {
            PluginStatus last = this.bdF.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.bdF.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.mO().I("plugin_load_tipclick", last.nI());
            } else {
                com.baidu.adp.plugin.b.a.mO().I("plugin_install_tipclick", last.nI());
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
