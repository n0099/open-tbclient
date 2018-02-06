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
    private LinkedList<PluginStatus> bBS;
    private HashSet<Integer> bBT;
    MessageListener<?> bBU;
    private TextView bcj;
    private Context mContext;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBS = new LinkedList<>();
        this.bBT = new HashSet<>(10);
        this.bBU = new CustomMessageListener(0) { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                    PluginErrorTipView.this.bBS.add((PluginStatus) customResponsedMessage.getData());
                    PluginErrorTipView.this.update();
                }
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.plugin_error_tip_view, this);
        this.bcj = (TextView) findViewById(d.g.plugin_error_guide);
        findViewById(d.g.plugin_error_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PluginErrorTipView.this.bBS.size() > 0) {
                    PluginErrorTipView.this.bBT.add(Integer.valueOf(((PluginStatus) PluginErrorTipView.this.bBS.getLast()).getErrorCode()));
                }
                PluginErrorTipView.this.setVisibility(8);
            }
        });
        setOnClickListener(this);
        List<PluginStatus> rC = com.baidu.adp.plugin.packageManager.status.a.rB().rC();
        if (rC != null && rC.size() > 0) {
            this.bBS.addAll(rC);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(2000991, this.bBU);
        MessageManager.getInstance().registerListener(2000990, this.bBU);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bBU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.bBS.size() > 0) {
            PluginStatus last = this.bBS.getLast();
            if (!this.bBT.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.qF().A("plugin_load_tip", last.rz());
                } else {
                    com.baidu.adp.plugin.b.a.qF().A("plugin_install_tip", last.rz());
                }
                this.bcj.setText(last.getErrorMsg() + getResources().getString(d.j.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bBS != null && !this.bBS.isEmpty()) {
            PluginStatus last = this.bBS.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.bBS.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.qF().A("plugin_load_tipclick", last.rz());
            } else {
                com.baidu.adp.plugin.b.a.qF().A("plugin_install_tipclick", last.rz());
            }
        }
    }

    public void onChangeSkinType(e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().aQ(i == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this);
        }
        aj.f(this, d.f.nonetworkview_bg_selector, i);
    }
}
