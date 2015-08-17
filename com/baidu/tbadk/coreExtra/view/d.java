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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d extends HorizontalScrollView {
    private boolean akA;
    private String akB;
    private int aks;
    private int akt;
    private Runnable aku;
    private TbPageContextSupport akv;
    private ImageView[] akw;
    private View akx;
    private View aky;
    private a akz;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void ei(String str);
    }

    public d(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.aks = 0;
        this.akt = 0;
        this.aku = new e(this);
        this.mContext = null;
        this.akw = null;
        this.akx = null;
        this.aky = null;
        this.akz = null;
        this.akA = true;
        this.akB = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.akv = tbPageContextSupport;
        this.akz = aVar;
        if (str != null) {
            this.akB = str;
        }
        init();
    }

    private void init() {
        this.aks = (int) this.mContext.getResources().getDimension(i.d.ds4);
        this.akt = (int) this.mContext.getResources().getDimension(i.d.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.akt, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(i.b.fiter_name);
        this.akw = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = LayoutInflater.from(this.mContext).inflate(i.g.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(i.f.filter_immage);
            imageView.setPadding(this.aks, this.aks, this.aks, this.aks);
            imageView.setTag(textView);
            imageView.setOnClickListener(new f(this));
            if (substring.equals(this.akB)) {
                this.akx = inflate;
                this.aky = imageView;
                imageView.setBackgroundResource(i.e.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eh(substring));
            this.akw[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.akx != null) {
            post(this.aku);
        }
    }

    public String getSelectedFilter() {
        return this.aky != null ? (String) ((View) this.aky.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.akA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(View view) {
        if (this.akA && view != this.aky && yW()) {
            if (this.aky != null) {
                this.aky.setBackgroundDrawable(null);
                ((TextView) this.aky.getTag()).setSelected(false);
            }
            this.aky = view;
            view.setBackgroundResource(i.e.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.akB = (String) textView.getTag();
            if (this.akz != null) {
                this.akz.ei(this.akB);
            }
        }
    }

    private boolean yW() {
        PluginPackageManager.PluginStatus bv = PluginPackageManager.lT().bv(PluginCenter.NAME_MOTUSDK);
        if (bv == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bv == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), i.C0057i.plugin_config_not_found);
            return false;
        } else if (bv == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.lT().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bv == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.util.a.a(this.akv.getPageContext(), i.C0057i.plugin_muto_not_install, new g(this), new h(this));
            return false;
        } else {
            return true;
        }
    }

    public static int eh(String str) {
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
