package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends HorizontalScrollView {
    private int amA;
    private int amB;
    private Runnable amC;
    private TbPageContextSupport amD;
    private ImageView[] amE;
    private View amF;
    private View amG;
    private a amH;
    private boolean amI;
    private String amJ;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void eE(String str);
    }

    public d(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.amA = 0;
        this.amB = 0;
        this.amC = new e(this);
        this.mContext = null;
        this.amE = null;
        this.amF = null;
        this.amG = null;
        this.amH = null;
        this.amI = true;
        this.amJ = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.amD = tbPageContextSupport;
        this.amH = aVar;
        if (str != null) {
            this.amJ = str;
        }
        init();
    }

    private void init() {
        this.amA = (int) this.mContext.getResources().getDimension(n.e.ds4);
        this.amB = (int) this.mContext.getResources().getDimension(n.e.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.amB, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(n.b.fiter_name);
        this.amE = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = LayoutInflater.from(this.mContext).inflate(n.h.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(n.g.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(n.g.filter_immage);
            imageView.setPadding(this.amA, this.amA, this.amA, this.amA);
            imageView.setTag(textView);
            imageView.setOnClickListener(new f(this));
            if (substring.equals(this.amJ)) {
                this.amF = inflate;
                this.amG = imageView;
                imageView.setBackgroundResource(n.f.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eD(substring));
            this.amE[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.amF != null) {
            post(this.amC);
        }
    }

    public String getSelectedFilter() {
        return this.amG != null ? (String) ((View) this.amG.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.amI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(View view) {
        if (this.amI && view != this.amG && zw()) {
            if (this.amG != null) {
                this.amG.setBackgroundDrawable(null);
                ((TextView) this.amG.getTag()).setSelected(false);
            }
            this.amG = view;
            view.setBackgroundResource(n.f.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.amJ = (String) textView.getTag();
            if (this.amH != null) {
                this.amH.eE(this.amJ);
            }
        }
    }

    private boolean zw() {
        PluginPackageManager.PluginStatus bB = PluginPackageManager.ls().bB(PluginCenter.NAME_MOTUSDK);
        if (bB == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bB == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), n.j.plugin_config_not_found);
            return false;
        } else if (bB == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.ls().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bB == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.amD.getPageContext(), n.j.plugin_muto_not_install, new g(this), new h(this));
            return false;
        } else {
            return true;
        }
    }

    public static int eD(String str) {
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
