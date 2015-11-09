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
    private int ajJ;
    private int ajK;
    private Runnable ajL;
    private TbPageContextSupport ajM;
    private ImageView[] ajN;
    private View ajO;
    private View ajP;
    private a ajQ;
    private boolean ajR;
    private String ajS;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void er(String str);
    }

    public d(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.ajJ = 0;
        this.ajK = 0;
        this.ajL = new e(this);
        this.mContext = null;
        this.ajN = null;
        this.ajO = null;
        this.ajP = null;
        this.ajQ = null;
        this.ajR = true;
        this.ajS = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.ajM = tbPageContextSupport;
        this.ajQ = aVar;
        if (str != null) {
            this.ajS = str;
        }
        init();
    }

    private void init() {
        this.ajJ = (int) this.mContext.getResources().getDimension(i.d.ds4);
        this.ajK = (int) this.mContext.getResources().getDimension(i.d.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.ajK, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(i.b.fiter_name);
        this.ajN = new ImageView[stringArray.length];
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
            imageView.setPadding(this.ajJ, this.ajJ, this.ajJ, this.ajJ);
            imageView.setTag(textView);
            imageView.setOnClickListener(new f(this));
            if (substring.equals(this.ajS)) {
                this.ajO = inflate;
                this.ajP = imageView;
                imageView.setBackgroundResource(i.e.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eq(substring));
            this.ajN[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ajO != null) {
            post(this.ajL);
        }
    }

    public String getSelectedFilter() {
        return this.ajP != null ? (String) ((View) this.ajP.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.ajR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(View view) {
        if (this.ajR && view != this.ajP && yO()) {
            if (this.ajP != null) {
                this.ajP.setBackgroundDrawable(null);
                ((TextView) this.ajP.getTag()).setSelected(false);
            }
            this.ajP = view;
            view.setBackgroundResource(i.e.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.ajS = (String) textView.getTag();
            if (this.ajQ != null) {
                this.ajQ.er(this.ajS);
            }
        }
    }

    private boolean yO() {
        PluginPackageManager.PluginStatus bu = PluginPackageManager.lS().bu(PluginCenter.NAME_MOTUSDK);
        if (bu == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bu == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), i.h.plugin_config_not_found);
            return false;
        } else if (bu == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.lS().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bu == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.ajM.getPageContext(), i.h.plugin_muto_not_install, new g(this), new h(this));
            return false;
        } else {
            return true;
        }
    }

    public static int eq(String str) {
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
