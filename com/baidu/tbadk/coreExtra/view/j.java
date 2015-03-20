package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class j extends HorizontalScrollView {
    private int adZ;
    private int aea;
    private Runnable aeb;
    private TbPageContextSupport aec;
    private ImageView[] aed;
    private View aee;
    private View aef;
    private o aeg;
    private boolean aeh;
    private String aei;
    private Context mContext;

    public j(TbPageContextSupport tbPageContextSupport, o oVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.adZ = 0;
        this.aea = 0;
        this.aeb = new k(this);
        this.mContext = null;
        this.aed = null;
        this.aee = null;
        this.aef = null;
        this.aeg = null;
        this.aeh = true;
        this.aei = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.aec = tbPageContextSupport;
        this.aeg = oVar;
        if (str != null) {
            this.aei = str;
        }
        init();
    }

    private void init() {
        this.adZ = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds4);
        this.aea = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.aea, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(com.baidu.tieba.q.fiter_name);
        this.aed = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.filter_item, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.v.filter_immage);
            imageView.setPadding(this.adZ, this.adZ, this.adZ, this.adZ);
            imageView.setTag(textView);
            imageView.setOnClickListener(new l(this));
            if (substring.equals(this.aei)) {
                this.aee = inflate;
                this.aef = imageView;
                imageView.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(dK(substring));
            this.aed[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aee != null) {
            post(this.aeb);
        }
    }

    public String getSelectedFilter() {
        return this.aef != null ? (String) ((View) this.aef.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.aeh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view) {
        if (this.aeh && view != this.aef && wU()) {
            if (this.aef != null) {
                this.aef.setBackgroundDrawable(null);
                ((TextView) this.aef.getTag()).setSelected(false);
            }
            this.aef = view;
            view.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.aei = (String) textView.getTag();
            if (this.aeg != null) {
                this.aeg.dL(this.aei);
            }
        }
    }

    private boolean wU() {
        PluginPackageManager.PluginStatus br = PluginPackageManager.ls().br(PluginCenter.NAME_MOTUSDK);
        if (br == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (br == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), com.baidu.tieba.y.plugin_config_not_found);
            return false;
        } else if (br == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.ls().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (br == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.util.a.a(this.aec.getPageContext(), com.baidu.tieba.y.plugin_muto_not_install, new m(this), new n(this));
            return false;
        } else {
            return true;
        }
    }

    public static int dK(String str) {
        if (TbadkCoreApplication.getMotuFilterImageMap() == null || TbadkCoreApplication.getMotuFilterImageMap().size() == 0) {
            return 0;
        }
        if (str == null || str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            return TbadkCoreApplication.getMotuFilterImageMap().get(WriteImageActivityConfig.FILTER_NAME_NORMAL).intValue();
        }
        if (str.equals("clvivid")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clvivid").intValue();
        }
        if (str.equals("cllomoscenery")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("cllomoscenery").intValue();
        }
        if (str.equals("clcaisefupian")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clcaisefupian").intValue();
        }
        if (str.equals("clm3")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clm3").intValue();
        }
        if (str.equals("cqiuse")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("cqiuse").intValue();
        }
        if (str.equals("clzaoan")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clzaoan").intValue();
        }
        if (str.equals("clfuguscenery")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clfuguscenery").intValue();
        }
        if (str.equals("clheibai")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clheibai").intValue();
        }
        return TbadkCoreApplication.getMotuFilterImageMap().get(WriteImageActivityConfig.FILTER_NAME_NORMAL).intValue();
    }
}
