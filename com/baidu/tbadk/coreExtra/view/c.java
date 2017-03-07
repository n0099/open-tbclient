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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends HorizontalScrollView {
    private int asG;
    private int asH;
    private TbPageContextSupport asI;
    private ImageView[] asJ;
    private View asK;
    private View asL;
    private a asM;
    private boolean asN;
    private String asO;
    private Context mContext;
    private Runnable scrollRunnable;

    /* loaded from: classes.dex */
    public interface a {
        void ez(String str);
    }

    public c(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.asG = 0;
        this.asH = 0;
        this.scrollRunnable = new d(this);
        this.mContext = null;
        this.asJ = null;
        this.asK = null;
        this.asL = null;
        this.asM = null;
        this.asN = true;
        this.asO = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.asI = tbPageContextSupport;
        this.asM = aVar;
        if (str != null) {
            this.asO = str;
        }
        init();
    }

    private void init() {
        this.asG = (int) this.mContext.getResources().getDimension(w.f.ds4);
        this.asH = (int) this.mContext.getResources().getDimension(w.f.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.asH, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(w.b.fiter_name);
        this.asJ = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(w.h.filter_immage);
            imageView.setPadding(this.asG, this.asG, this.asG, this.asG);
            imageView.setTag(textView);
            imageView.setOnClickListener(new e(this));
            if (substring.equals(this.asO)) {
                this.asK = inflate;
                this.asL = imageView;
                imageView.setBackgroundResource(w.g.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(ey(substring));
            this.asJ[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.asK != null) {
            post(this.scrollRunnable);
        }
    }

    public String getSelectedFilter() {
        return this.asL != null ? (String) ((View) this.asL.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.asN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(View view) {
        if (this.asN && view != this.asL && AR()) {
            if (this.asL != null) {
                this.asL.setBackgroundDrawable(null);
                ((TextView) this.asL.getTag()).setSelected(false);
            }
            this.asL = view;
            view.setBackgroundResource(w.g.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.asO = (String) textView.getTag();
            if (this.asM != null) {
                this.asM.ez(this.asO);
            }
        }
    }

    private boolean AR() {
        PluginPackageManager.PluginStatus bn = PluginPackageManager.jt().bn(PluginCenter.NAME_MOTUSDK);
        if (bn == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bn == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), w.l.plugin_config_not_found);
            return false;
        } else if (bn == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.jt().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bn == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.d.a.a(this.asI.getPageContext(), w.l.plugin_muto_not_install, new f(this), new g(this));
            return false;
        } else {
            return true;
        }
    }

    public static int ey(String str) {
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
