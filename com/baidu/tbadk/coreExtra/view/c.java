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
    private int atc;
    private int atd;
    private TbPageContextSupport ate;
    private ImageView[] atf;
    private View atg;
    private View ath;
    private a ati;
    private boolean atj;
    private String atk;
    private Context mContext;
    private Runnable scrollRunnable;

    /* loaded from: classes.dex */
    public interface a {
        void eE(String str);
    }

    public c(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.atc = 0;
        this.atd = 0;
        this.scrollRunnable = new d(this);
        this.mContext = null;
        this.atf = null;
        this.atg = null;
        this.ath = null;
        this.ati = null;
        this.atj = true;
        this.atk = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.ate = tbPageContextSupport;
        this.ati = aVar;
        if (str != null) {
            this.atk = str;
        }
        init();
    }

    private void init() {
        this.atc = (int) this.mContext.getResources().getDimension(w.f.ds4);
        this.atd = (int) this.mContext.getResources().getDimension(w.f.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.atd, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(w.b.fiter_name);
        this.atf = new ImageView[stringArray.length];
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
            imageView.setPadding(this.atc, this.atc, this.atc, this.atc);
            imageView.setTag(textView);
            imageView.setOnClickListener(new e(this));
            if (substring.equals(this.atk)) {
                this.atg = inflate;
                this.ath = imageView;
                imageView.setBackgroundResource(w.g.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eD(substring));
            this.atf[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.atg != null) {
            post(this.scrollRunnable);
        }
    }

    public String getSelectedFilter() {
        return this.ath != null ? (String) ((View) this.ath.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.atj = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(View view) {
        if (this.atj && view != this.ath && AB()) {
            if (this.ath != null) {
                this.ath.setBackgroundDrawable(null);
                ((TextView) this.ath.getTag()).setSelected(false);
            }
            this.ath = view;
            view.setBackgroundResource(w.g.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.atk = (String) textView.getTag();
            if (this.ati != null) {
                this.ati.eE(this.atk);
            }
        }
    }

    private boolean AB() {
        PluginPackageManager.PluginStatus bi = PluginPackageManager.jx().bi(PluginCenter.NAME_MOTUSDK);
        if (bi == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bi == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), w.l.plugin_config_not_found);
            return false;
        } else if (bi == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.jx().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bi == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.d.a.a(this.ate.getPageContext(), w.l.plugin_muto_not_install, new f(this), new g(this));
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
