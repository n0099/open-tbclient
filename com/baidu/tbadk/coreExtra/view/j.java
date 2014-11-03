package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* loaded from: classes.dex */
public class j extends HorizontalScrollView {
    private int NK;
    private int NL;
    private Runnable NM;
    private ImageView[] NN;
    private View NO;
    private View NP;
    private o NQ;
    private boolean NR;
    private String NS;
    private Context mContext;

    public j(Context context, o oVar, String str) {
        super(context);
        this.NK = 0;
        this.NL = 0;
        this.NM = new k(this);
        this.mContext = null;
        this.NN = null;
        this.NO = null;
        this.NP = null;
        this.NQ = null;
        this.NR = true;
        this.NS = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = context;
        this.NQ = oVar;
        if (str != null) {
            this.NS = str;
        }
        init();
    }

    private void init() {
        this.NK = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds4);
        this.NL = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.NL, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(com.baidu.tieba.q.fiter_name);
        this.NN = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.filter_item, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.v.filter_immage);
            imageView.setPadding(this.NK, this.NK, this.NK, this.NK);
            imageView.setTag(textView);
            imageView.setOnClickListener(new l(this));
            if (substring.equals(this.NS)) {
                this.NO = inflate;
                this.NP = imageView;
                imageView.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(cK(substring));
            this.NN[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.NO != null) {
            post(this.NM);
        }
    }

    public String getSelectedFilter() {
        return this.NP != null ? (String) ((View) this.NP.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.NR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view) {
        if (this.NR && view != this.NP && pY()) {
            if (this.NP != null) {
                this.NP.setBackgroundDrawable(null);
                ((TextView) this.NP.getTag()).setSelected(false);
            }
            this.NP = view;
            view.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.NS = (String) textView.getTag();
            if (this.NQ != null) {
                this.NQ.cL(this.NS);
            }
        }
    }

    private boolean pY() {
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_MOTUSDK);
        if (pluginByName == null) {
            ConfigInfos.PluginConfig netConfigInfo = PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_MOTUSDK);
            if (netConfigInfo == null) {
                UtilHelper.showToast(getContext(), com.baidu.tieba.y.plugin_config_not_found);
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(this.mContext, netConfigInfo)));
            return false;
        } else if (!pluginByName.checkEnable()) {
            com.baidu.tbadk.coreExtra.util.a.a((BaseActivity) this.mContext, com.baidu.tieba.y.plugin_muto_not_install, new m(this), new n(this));
            return false;
        } else {
            return true;
        }
    }

    public static int cK(String str) {
        if (str == null) {
            return com.baidu.tieba.u.motu_filter_normal;
        }
        if (str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            return com.baidu.tieba.u.motu_filter_normal;
        }
        if (str.equals("clvivid")) {
            return com.baidu.tieba.u.motu_filter_skin;
        }
        if (str.equals("cllomoscenery")) {
            return com.baidu.tieba.u.motu_filter_lomo;
        }
        if (str.equals("clcaisefupian")) {
            return com.baidu.tieba.u.motu_filter_classichdr;
        }
        if (str.equals("clm3")) {
            return com.baidu.tieba.u.motu_filter_nashiv;
        }
        if (str.equals("cqiuse")) {
            return com.baidu.tieba.u.motu_filter_fleeting;
        }
        if (str.equals("clzaoan")) {
            return com.baidu.tieba.u.motu_filter_bluetone;
        }
        if (str.equals("clfuguscenery")) {
            return com.baidu.tieba.u.motu_filter_elegant;
        }
        if (str.equals("clheibai")) {
            return com.baidu.tieba.u.motu_filter_gray;
        }
        return com.baidu.tieba.u.motu_filter_normal;
    }
}
