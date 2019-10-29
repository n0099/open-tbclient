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
import com.baidu.tieba.R;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipView extends RelativeLayout implements View.OnClickListener {
    private LinkedList<PluginStatus> cNw;
    private HashSet<Integer> cNx;
    MessageListener<?> cNy;
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
        this.cNw = new LinkedList<>();
        this.cNx = new HashSet<>(10);
        this.cNy = new CustomMessageListener(0) { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
                    PluginErrorTipView.this.cNw.add((PluginStatus) customResponsedMessage.getData());
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
        findViewById(R.id.plugin_error_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.plugin.PluginErrorTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PluginErrorTipView.this.cNw.size() > 0) {
                    PluginErrorTipView.this.cNx.add(Integer.valueOf(((PluginStatus) PluginErrorTipView.this.cNw.getLast()).getErrorCode()));
                }
                PluginErrorTipView.this.setVisibility(8);
            }
        });
        setOnClickListener(this);
        List<PluginStatus> jw = com.baidu.adp.plugin.packageManager.status.a.jv().jw();
        if (jw != null && jw.size() > 0) {
            this.cNw.addAll(jw);
            update();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_INSTALL_FAIL, this.cNy);
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOAD_FAIL, this.cNy);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cNy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.cNw.size() > 0) {
            PluginStatus last = this.cNw.getLast();
            if (!this.cNx.contains(Integer.valueOf(last.getErrorCode()))) {
                if (last.getErrorCode() >= 100) {
                    com.baidu.adp.plugin.b.a.iv().q("plugin_load_tip", last.getPkgName());
                } else {
                    com.baidu.adp.plugin.b.a.iv().q("plugin_install_tip", last.getPkgName());
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
        if (this.cNw != null && !this.cNw.isEmpty()) {
            PluginStatus last = this.cNw.getLast();
            PluginErrorTipActivity.a(this.mContext, last);
            this.cNw.clear();
            update();
            if (last.getErrorCode() >= 100) {
                com.baidu.adp.plugin.b.a.iv().q("plugin_load_tipclick", last.getPkgName());
            } else {
                com.baidu.adp.plugin.b.a.iv().q("plugin_install_tipclick", last.getPkgName());
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
