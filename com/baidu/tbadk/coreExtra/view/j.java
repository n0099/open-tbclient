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
    private int aeh;
    private int aei;
    private Runnable aej;
    private TbPageContextSupport aek;
    private ImageView[] ael;
    private View aem;
    private View aen;
    private o aeo;
    private boolean aep;
    private String aeq;
    private Context mContext;

    public j(TbPageContextSupport tbPageContextSupport, o oVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.aeh = 0;
        this.aei = 0;
        this.aej = new k(this);
        this.mContext = null;
        this.ael = null;
        this.aem = null;
        this.aen = null;
        this.aeo = null;
        this.aep = true;
        this.aeq = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.aek = tbPageContextSupport;
        this.aeo = oVar;
        if (str != null) {
            this.aeq = str;
        }
        init();
    }

    private void init() {
        this.aeh = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds4);
        this.aei = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.aei, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(com.baidu.tieba.q.fiter_name);
        this.ael = new ImageView[stringArray.length];
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
            imageView.setPadding(this.aeh, this.aeh, this.aeh, this.aeh);
            imageView.setTag(textView);
            imageView.setOnClickListener(new l(this));
            if (substring.equals(this.aeq)) {
                this.aem = inflate;
                this.aen = imageView;
                imageView.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(dN(substring));
            this.ael[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aem != null) {
            post(this.aej);
        }
    }

    public String getSelectedFilter() {
        return this.aen != null ? (String) ((View) this.aen.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.aep = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view) {
        if (this.aep && view != this.aen && xa()) {
            if (this.aen != null) {
                this.aen.setBackgroundDrawable(null);
                ((TextView) this.aen.getTag()).setSelected(false);
            }
            this.aen = view;
            view.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.aeq = (String) textView.getTag();
            if (this.aeo != null) {
                this.aeo.dO(this.aeq);
            }
        }
    }

    private boolean xa() {
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
            com.baidu.tbadk.coreExtra.util.a.a(this.aek.getPageContext(), com.baidu.tieba.y.plugin_muto_not_install, new m(this), new n(this));
            return false;
        } else {
            return true;
        }
    }

    public static int dN(String str) {
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
