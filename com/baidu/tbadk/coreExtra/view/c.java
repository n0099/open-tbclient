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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends HorizontalScrollView {
    private int anI;
    private int anJ;
    private Runnable anK;
    private TbPageContextSupport anL;
    private ImageView[] anM;
    private View anN;
    private View anO;
    private a anP;
    private boolean anQ;
    private String anR;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void eP(String str);
    }

    public c(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.anI = 0;
        this.anJ = 0;
        this.anK = new d(this);
        this.mContext = null;
        this.anM = null;
        this.anN = null;
        this.anO = null;
        this.anP = null;
        this.anQ = true;
        this.anR = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.anL = tbPageContextSupport;
        this.anP = aVar;
        if (str != null) {
            this.anR = str;
        }
        init();
    }

    private void init() {
        this.anI = (int) this.mContext.getResources().getDimension(r.e.ds4);
        this.anJ = (int) this.mContext.getResources().getDimension(r.e.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.anJ, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(r.b.fiter_name);
        this.anM = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = LayoutInflater.from(this.mContext).inflate(r.h.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(r.g.filter_immage);
            imageView.setPadding(this.anI, this.anI, this.anI, this.anI);
            imageView.setTag(textView);
            imageView.setOnClickListener(new e(this));
            if (substring.equals(this.anR)) {
                this.anN = inflate;
                this.anO = imageView;
                imageView.setBackgroundResource(r.f.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eO(substring));
            this.anM[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.anN != null) {
            post(this.anK);
        }
    }

    public String getSelectedFilter() {
        return this.anO != null ? (String) ((View) this.anO.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.anQ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(View view) {
        if (this.anQ && view != this.anO && AJ()) {
            if (this.anO != null) {
                this.anO.setBackgroundDrawable(null);
                ((TextView) this.anO.getTag()).setSelected(false);
            }
            this.anO = view;
            view.setBackgroundResource(r.f.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.anR = (String) textView.getTag();
            if (this.anP != null) {
                this.anP.eP(this.anR);
            }
        }
    }

    private boolean AJ() {
        PluginPackageManager.PluginStatus bu = PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK);
        if (bu == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bu == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), r.j.plugin_config_not_found);
            return false;
        } else if (bu == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.iB().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bu == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.anL.getPageContext(), r.j.plugin_muto_not_install, new f(this), new g(this));
            return false;
        } else {
            return true;
        }
    }

    public static int eO(String str) {
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
