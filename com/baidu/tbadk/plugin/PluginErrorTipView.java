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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private LinkedList<PluginStatus> aKX;
    private HashSet<Integer> aKY;
    MessageListener<?> aKZ;
    private TextView ami;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKX = new LinkedList<>();
        this.aKY = new HashSet<>(10);
        this.aKZ = new CustomMessageListener(0) { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                    PluginErrorTipView.this.aKX.add((PluginStatus) customResponsedMessage.getData());
                    PluginErrorTipView.this.update();
                }
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.plugin_error_tip_view, this);
        this.ami = (TextView) findViewById(d.h.plugin_error_guide);
        findViewById(d.h.plugin_error_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PluginErrorTipView.this.aKX.size() > 0) {
                    PluginErrorTipView.this.aKY.add(Integer.valueOf(((PluginStatus) PluginErrorTipView.this.aKX.getLast()).getErrorCode()));
                }
                PluginErrorTipView.this.setVisibility(8);
            }
        });
        setOnClickListener(this);
        List<PluginStatus> kg = com.baidu.adp.plugin.packageManager.status.a.kf().kg();
        if (kg != null && kg.size() > 0) {
            this.aKX.addAll(kg);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.aKZ);
        MessageManager.getInstance().registerListener(2000990, this.aKZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aKZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.aKX.size() > 0) {
            PluginStatus last = this.aKX.getLast();
            if (!this.aKY.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.jj().B("plugin_load_tip", last.kd());
                } else {
                    com.baidu.adp.plugin.b.a.jj().B("plugin_install_tip", last.kd());
                }
                this.ami.setText(last.getErrorMsg() + getResources().getString(d.l.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aKX != null && !this.aKX.isEmpty()) {
            PluginStatus last = this.aKX.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.aKX.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.jj().B("plugin_load_tipclick", last.kd());
            } else {
                com.baidu.adp.plugin.b.a.jj().B("plugin_install_tipclick", last.kd());
            }
        }
    }

    public void onChangeSkinType(e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this);
        }
        aj.d(this, d.g.nonetworkview_bg_selector, i);
    }
}
