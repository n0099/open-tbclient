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
    private int NG;
    private int NH;
    private Runnable NI;
    private ImageView[] NJ;
    private View NK;
    private View NL;
    private o NM;
    private boolean NN;
    private String NO;
    private Context mContext;

    public j(Context context, o oVar, String str) {
        super(context);
        this.NG = 0;
        this.NH = 0;
        this.NI = new k(this);
        this.mContext = null;
        this.NJ = null;
        this.NK = null;
        this.NL = null;
        this.NM = null;
        this.NN = true;
        this.NO = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = context;
        this.NM = oVar;
        if (str != null) {
            this.NO = str;
        }
        init();
    }

    private void init() {
        this.NG = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds4);
        this.NH = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.NH, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(com.baidu.tieba.q.fiter_name);
        this.NJ = new ImageView[stringArray.length];
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
            imageView.setPadding(this.NG, this.NG, this.NG, this.NG);
            imageView.setTag(textView);
            imageView.setOnClickListener(new l(this));
            if (substring.equals(this.NO)) {
                this.NK = inflate;
                this.NL = imageView;
                imageView.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(cK(substring));
            this.NJ[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.NK != null) {
            post(this.NI);
        }
    }

    public String getSelectedFilter() {
        return this.NL != null ? (String) ((View) this.NL.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.NN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view) {
        if (this.NN && view != this.NL && pW()) {
            if (this.NL != null) {
                this.NL.setBackgroundDrawable(null);
                ((TextView) this.NL.getTag()).setSelected(false);
            }
            this.NL = view;
            view.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.NO = (String) textView.getTag();
            if (this.NM != null) {
                this.NM.cL(this.NO);
            }
        }
    }

    private boolean pW() {
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
