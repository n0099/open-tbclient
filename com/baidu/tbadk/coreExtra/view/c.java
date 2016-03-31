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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends HorizontalScrollView {
    private int anK;
    private int anL;
    private Runnable anM;
    private TbPageContextSupport anN;
    private ImageView[] anO;
    private View anP;
    private View anQ;
    private a anR;
    private boolean anS;
    private String anT;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void eK(String str);
    }

    public c(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.anK = 0;
        this.anL = 0;
        this.anM = new d(this);
        this.mContext = null;
        this.anO = null;
        this.anP = null;
        this.anQ = null;
        this.anR = null;
        this.anS = true;
        this.anT = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.anN = tbPageContextSupport;
        this.anR = aVar;
        if (str != null) {
            this.anT = str;
        }
        init();
    }

    private void init() {
        this.anK = (int) this.mContext.getResources().getDimension(t.e.ds4);
        this.anL = (int) this.mContext.getResources().getDimension(t.e.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.anL, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(t.b.fiter_name);
        this.anO = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = LayoutInflater.from(this.mContext).inflate(t.h.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(t.g.filter_immage);
            imageView.setPadding(this.anK, this.anK, this.anK, this.anK);
            imageView.setTag(textView);
            imageView.setOnClickListener(new e(this));
            if (substring.equals(this.anT)) {
                this.anP = inflate;
                this.anQ = imageView;
                imageView.setBackgroundResource(t.f.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eJ(substring));
            this.anO[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.anP != null) {
            post(this.anM);
        }
    }

    public String getSelectedFilter() {
        return this.anQ != null ? (String) ((View) this.anQ.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.anS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(View view) {
        if (this.anS && view != this.anQ && Br()) {
            if (this.anQ != null) {
                this.anQ.setBackgroundDrawable(null);
                ((TextView) this.anQ.getTag()).setSelected(false);
            }
            this.anQ = view;
            view.setBackgroundResource(t.f.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.anT = (String) textView.getTag();
            if (this.anR != null) {
                this.anR.eK(this.anT);
            }
        }
    }

    private boolean Br() {
        PluginPackageManager.PluginStatus bz = PluginPackageManager.ls().bz(PluginCenter.NAME_MOTUSDK);
        if (bz == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bz == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), t.j.plugin_config_not_found);
            return false;
        } else if (bz == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.ls().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bz == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.anN.getPageContext(), t.j.plugin_muto_not_install, new f(this), new g(this));
            return false;
        } else {
            return true;
        }
    }

    public static int eJ(String str) {
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
