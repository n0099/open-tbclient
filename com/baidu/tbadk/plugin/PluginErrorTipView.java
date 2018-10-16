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
    private TextView aDH;
    private LinkedList<PluginStatus> bcS;
    private HashSet<Integer> bcT;
    MessageListener<?> bcU;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bcS = new LinkedList<>();
        this.bcT = new HashSet<>(10);
        this.bcU = new CustomMessageListener(0) { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                    PluginErrorTipView.this.bcS.add((PluginStatus) customResponsedMessage.getData());
                    PluginErrorTipView.this.update();
                }
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.plugin_error_tip_view, this);
        this.aDH = (TextView) findViewById(e.g.plugin_error_guide);
        findViewById(e.g.plugin_error_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PluginErrorTipView.this.bcS.size() > 0) {
                    PluginErrorTipView.this.bcT.add(Integer.valueOf(((PluginStatus) PluginErrorTipView.this.bcS.getLast()).getErrorCode()));
                }
                PluginErrorTipView.this.setVisibility(8);
            }
        });
        setOnClickListener(this);
        List<PluginStatus> nN = com.baidu.adp.plugin.packageManager.status.a.nM().nN();
        if (nN != null && nN.size() > 0) {
            this.bcS.addAll(nN);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.bcU);
        MessageManager.getInstance().registerListener(2000990, this.bcU);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bcU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.bcS.size() > 0) {
            PluginStatus last = this.bcS.getLast();
            if (!this.bcT.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.mQ().I("plugin_load_tip", last.nK());
                } else {
                    com.baidu.adp.plugin.b.a.mQ().I("plugin_install_tip", last.nK());
                }
                this.aDH.setText(last.getErrorMsg() + getResources().getString(e.j.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bcS != null && !this.bcS.isEmpty()) {
            PluginStatus last = this.bcS.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.bcS.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.mQ().I("plugin_load_tipclick", last.nK());
            } else {
                com.baidu.adp.plugin.b.a.mQ().I("plugin_install_tipclick", last.nK());
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
