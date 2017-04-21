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
    private int asY;
    private int asZ;
    private TbPageContextSupport ata;
    private ImageView[] atb;
    private View atc;
    private View atd;
    private a ate;
    private boolean atf;
    private String atg;
    private Context mContext;
    private Runnable scrollRunnable;

    /* loaded from: classes.dex */
    public interface a {
        void eF(String str);
    }

    public c(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.asY = 0;
        this.asZ = 0;
        this.scrollRunnable = new d(this);
        this.mContext = null;
        this.atb = null;
        this.atc = null;
        this.atd = null;
        this.ate = null;
        this.atf = true;
        this.atg = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.ata = tbPageContextSupport;
        this.ate = aVar;
        if (str != null) {
            this.atg = str;
        }
        init();
    }

    private void init() {
        this.asY = (int) this.mContext.getResources().getDimension(w.f.ds4);
        this.asZ = (int) this.mContext.getResources().getDimension(w.f.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.asZ, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(w.b.fiter_name);
        this.atb = new ImageView[stringArray.length];
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
            imageView.setPadding(this.asY, this.asY, this.asY, this.asY);
            imageView.setTag(textView);
            imageView.setOnClickListener(new e(this));
            if (substring.equals(this.atg)) {
                this.atc = inflate;
                this.atd = imageView;
                imageView.setBackgroundResource(w.g.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eE(substring));
            this.atb[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.atc != null) {
            post(this.scrollRunnable);
        }
    }

    public String getSelectedFilter() {
        return this.atd != null ? (String) ((View) this.atd.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.atf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(View view) {
        if (this.atf && view != this.atd && Bq()) {
            if (this.atd != null) {
                this.atd.setBackgroundDrawable(null);
                ((TextView) this.atd.getTag()).setSelected(false);
            }
            this.atd = view;
            view.setBackgroundResource(w.g.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.atg = (String) textView.getTag();
            if (this.ate != null) {
                this.ate.eF(this.atg);
            }
        }
    }

    private boolean Bq() {
        PluginPackageManager.PluginStatus bi = PluginPackageManager.jy().bi(PluginCenter.NAME_MOTUSDK);
        if (bi == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bi == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), w.l.plugin_config_not_found);
            return false;
        } else if (bi == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.jy().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bi == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.d.a.a(this.ata.getPageContext(), w.l.plugin_muto_not_install, new f(this), new g(this));
            return false;
        } else {
            return true;
        }
    }

    public static int eE(String str) {
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
