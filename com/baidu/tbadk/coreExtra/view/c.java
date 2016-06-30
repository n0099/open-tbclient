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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c extends HorizontalScrollView {
    private int ake;
    private int akf;
    private Runnable akg;
    private TbPageContextSupport akh;
    private ImageView[] aki;
    private View akj;
    private View akk;
    private a akl;
    private boolean akm;
    private String akn;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void eL(String str);
    }

    public c(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.ake = 0;
        this.akf = 0;
        this.akg = new d(this);
        this.mContext = null;
        this.aki = null;
        this.akj = null;
        this.akk = null;
        this.akl = null;
        this.akm = true;
        this.akn = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.akh = tbPageContextSupport;
        this.akl = aVar;
        if (str != null) {
            this.akn = str;
        }
        init();
    }

    private void init() {
        this.ake = (int) this.mContext.getResources().getDimension(u.e.ds4);
        this.akf = (int) this.mContext.getResources().getDimension(u.e.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.akf, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(u.b.fiter_name);
        this.aki = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = LayoutInflater.from(this.mContext).inflate(u.h.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.g.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(u.g.filter_immage);
            imageView.setPadding(this.ake, this.ake, this.ake, this.ake);
            imageView.setTag(textView);
            imageView.setOnClickListener(new e(this));
            if (substring.equals(this.akn)) {
                this.akj = inflate;
                this.akk = imageView;
                imageView.setBackgroundResource(u.f.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eK(substring));
            this.aki[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.akj != null) {
            post(this.akg);
        }
    }

    public String getSelectedFilter() {
        return this.akk != null ? (String) ((View) this.akk.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.akm = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(View view) {
        if (this.akm && view != this.akk && zr()) {
            if (this.akk != null) {
                this.akk.setBackgroundDrawable(null);
                ((TextView) this.akk.getTag()).setSelected(false);
            }
            this.akk = view;
            view.setBackgroundResource(u.f.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.akn = (String) textView.getTag();
            if (this.akl != null) {
                this.akl.eL(this.akn);
            }
        }
    }

    private boolean zr() {
        PluginPackageManager.PluginStatus bs = PluginPackageManager.hH().bs(PluginCenter.NAME_MOTUSDK);
        if (bs == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bs == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), u.j.plugin_config_not_found);
            return false;
        } else if (bs == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.hH().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bs == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.akh.getPageContext(), u.j.plugin_muto_not_install, new f(this), new g(this));
            return false;
        } else {
            return true;
        }
    }

    public static int eK(String str) {
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
