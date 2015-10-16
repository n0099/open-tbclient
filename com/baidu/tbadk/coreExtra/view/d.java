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
    private int ajE;
    private int ajF;
    private Runnable ajG;
    private TbPageContextSupport ajH;
    private ImageView[] ajI;
    private View ajJ;
    private View ajK;
    private a ajL;
    private boolean ajM;
    private String ajN;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void er(String str);
    }

    public d(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.ajE = 0;
        this.ajF = 0;
        this.ajG = new e(this);
        this.mContext = null;
        this.ajI = null;
        this.ajJ = null;
        this.ajK = null;
        this.ajL = null;
        this.ajM = true;
        this.ajN = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.ajH = tbPageContextSupport;
        this.ajL = aVar;
        if (str != null) {
            this.ajN = str;
        }
        init();
    }

    private void init() {
        this.ajE = (int) this.mContext.getResources().getDimension(i.d.ds4);
        this.ajF = (int) this.mContext.getResources().getDimension(i.d.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.ajF, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(i.b.fiter_name);
        this.ajI = new ImageView[stringArray.length];
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
            imageView.setPadding(this.ajE, this.ajE, this.ajE, this.ajE);
            imageView.setTag(textView);
            imageView.setOnClickListener(new f(this));
            if (substring.equals(this.ajN)) {
                this.ajJ = inflate;
                this.ajK = imageView;
                imageView.setBackgroundResource(i.e.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eq(substring));
            this.ajI[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ajJ != null) {
            post(this.ajG);
        }
    }

    public String getSelectedFilter() {
        return this.ajK != null ? (String) ((View) this.ajK.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.ajM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(View view) {
        if (this.ajM && view != this.ajK && yM()) {
            if (this.ajK != null) {
                this.ajK.setBackgroundDrawable(null);
                ((TextView) this.ajK.getTag()).setSelected(false);
            }
            this.ajK = view;
            view.setBackgroundResource(i.e.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.ajN = (String) textView.getTag();
            if (this.ajL != null) {
                this.ajL.er(this.ajN);
            }
        }
    }

    private boolean yM() {
        PluginPackageManager.PluginStatus bw = PluginPackageManager.lR().bw(PluginCenter.NAME_MOTUSDK);
        if (bw == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bw == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), i.h.plugin_config_not_found);
            return false;
        } else if (bw == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.lR().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bw == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.ajH.getPageContext(), i.h.plugin_muto_not_install, new g(this), new h(this));
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
