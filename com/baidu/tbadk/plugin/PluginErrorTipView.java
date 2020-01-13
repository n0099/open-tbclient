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
    private LinkedList<PluginStatus> dAS;
    private HashSet<Integer> dAT;
    MessageListener<?> dAU;
    MessageListener<?> dAV;
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
        this.dAS = new LinkedList<>();
        this.dAT = new HashSet<>(10);
        this.dAU = new CustomMessageListener(0) { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                    PluginErrorTipView.this.dAS.add((PluginStatus) customResponsedMessage.getData());
                    PluginErrorTipView.this.update();
                }
            }
        };
        this.dAV = new CustomMessageListener(0) { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                    PluginStatus pluginStatus = (PluginStatus) customResponsedMessage.getData();
                    synchronized (PluginErrorTipView.this.dAS) {
                        Iterator it = PluginErrorTipView.this.dAS.iterator();
                        while (it.hasNext()) {
                            PluginStatus pluginStatus2 = (PluginStatus) it.next();
                            if (aq.equals(pluginStatus.getPkgName(), pluginStatus2.getPkgName())) {
                                PluginErrorTipView.this.dAS.remove(pluginStatus2);
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
                if (PluginErrorTipView.this.dAS.size() > 0) {
                    PluginErrorTipView.this.dAT.add(Integer.valueOf(((PluginStatus) PluginErrorTipView.this.dAS.getLast()).getErrorCode()));
                }
                PluginErrorTipView.this.setVisibility(8);
            }
        });
        setOnClickListener(this);
        List<PluginStatus> jN = com.baidu.adp.plugin.packageManager.status.a.jM().jN();
        if (jN != null && jN.size() > 0) {
            this.dAS.addAll(jN);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_INSTALL_FAIL, this.dAU);
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_INSTALL_SUCCESS, this.dAV);
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOAD_FAIL, this.dAU);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dAU);
        MessageManager.getInstance().unRegisterListener(this.dAV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.dAS.size() > 0) {
            PluginStatus last = this.dAS.getLast();
            if (!this.dAT.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.iN().u("plugin_load_tip", last.getPkgName());
                } else {
                    com.baidu.adp.plugin.b.a.iN().u("plugin_install_tip", last.getPkgName());
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
        if (this.dAS != null && !this.dAS.isEmpty()) {
            PluginStatus last = this.dAS.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.dAS.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.iN().u("plugin_load_tipclick", last.getPkgName());
            } else {
                com.baidu.adp.plugin.b.a.iN().u("plugin_install_tipclick", last.getPkgName());
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
