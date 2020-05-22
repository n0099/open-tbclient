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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    MessageListener<?> etA;
    private LinkedList<PluginStatus> etx;
    private HashSet<Integer> ety;
    MessageListener<?> etz;
    private Context mContext;
    private TextView mGuide;

    public PluginErrorTipView(Context context) {
        this(context, null);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginErrorTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.etx = new LinkedList<>();
        this.ety = new HashSet<>(10);
        this.etz = new CustomMessageListener(0) { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                    PluginErrorTipView.this.etx.add((PluginStatus) customResponsedMessage.getData());
                    PluginErrorTipView.this.update();
                }
            }
        };
        this.etA = new CustomMessageListener(0) { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                    PluginStatus pluginStatus = (PluginStatus) customResponsedMessage.getData();
                    synchronized (PluginErrorTipView.this.etx) {
                        Iterator it = PluginErrorTipView.this.etx.iterator();
                        while (it.hasNext()) {
                            PluginStatus pluginStatus2 = (PluginStatus) it.next();
                            if (aq.equals(pluginStatus.getPkgName(), pluginStatus2.getPkgName())) {
                                PluginErrorTipView.this.etx.remove(pluginStatus2);
                            }
                        }
                    }
                    PluginErrorTipView.this.update();
                }
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.plugin_error_tip_view, this);
        this.mGuide = (TextView) findViewById(R.id.plugin_error_guide);
        findViewById(R.id.plugin_error_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PluginErrorTipView.this.etx.size() > 0) {
                    PluginErrorTipView.this.ety.add(Integer.valueOf(((PluginStatus) PluginErrorTipView.this.etx.getLast()).getErrorCode()));
                }
                PluginErrorTipView.this.setVisibility(8);
            }
        });
        setOnClickListener(this);
        List<PluginStatus> oH = com.baidu.adp.plugin.packageManager.status.a.oG().oH();
        if (oH != null && oH.size() > 0) {
            this.etx.addAll(oH);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_INSTALL_FAIL, this.etz);
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_INSTALL_SUCCESS, this.etA);
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOAD_FAIL, this.etz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.etz);
        MessageManager.getInstance().unRegisterListener(this.etA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.etx.size() > 0) {
            PluginStatus last = this.etx.getLast();
            if (!this.ety.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.nH().D("plugin_load_tip", last.getPkgName());
                } else {
                    com.baidu.adp.plugin.b.a.nH().D("plugin_install_tip", last.getPkgName());
                }
                this.mGuide.setText(last.getErrorMsg() + getResources().getString(R.string.pluginstatus_click_detail));
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.etx != null && !this.etx.isEmpty()) {
            PluginStatus last = this.etx.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.etx.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.nH().D("plugin_load_tipclick", last.getPkgName());
            } else {
                com.baidu.adp.plugin.b.a.nH().D("plugin_install_tipclick", last.getPkgName());
            }
        }
    }

    public void onChangeSkinType(e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(i == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this);
        }
        am.setBackgroundResource(this, R.drawable.nonetworkview_bg_selector, i);
    }
}
