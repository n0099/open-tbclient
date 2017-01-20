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
    private int anl;
    private int anm;
    private TbPageContextSupport ann;
    private ImageView[] ano;
    private View anp;
    private View anq;
    private a anr;
    private boolean ans;
    private String ant;
    private Context mContext;
    private Runnable scrollRunnable;

    /* loaded from: classes.dex */
    public interface a {
        void eK(String str);
    }

    public c(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.anl = 0;
        this.anm = 0;
        this.scrollRunnable = new d(this);
        this.mContext = null;
        this.ano = null;
        this.anp = null;
        this.anq = null;
        this.anr = null;
        this.ans = true;
        this.ant = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.ann = tbPageContextSupport;
        this.anr = aVar;
        if (str != null) {
            this.ant = str;
        }
        init();
    }

    private void init() {
        this.anl = (int) this.mContext.getResources().getDimension(r.f.ds4);
        this.anm = (int) this.mContext.getResources().getDimension(r.f.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.anm, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(r.b.fiter_name);
        this.ano = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = LayoutInflater.from(this.mContext).inflate(r.j.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.h.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(r.h.filter_immage);
            imageView.setPadding(this.anl, this.anl, this.anl, this.anl);
            imageView.setTag(textView);
            imageView.setOnClickListener(new e(this));
            if (substring.equals(this.ant)) {
                this.anp = inflate;
                this.anq = imageView;
                imageView.setBackgroundResource(r.g.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eJ(substring));
            this.ano[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.anp != null) {
            post(this.scrollRunnable);
        }
    }

    public String getSelectedFilter() {
        return this.anq != null ? (String) ((View) this.anq.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.ans = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(View view) {
        if (this.ans && view != this.anq && Ay()) {
            if (this.anq != null) {
                this.anq.setBackgroundDrawable(null);
                ((TextView) this.anq.getTag()).setSelected(false);
            }
            this.anq = view;
            view.setBackgroundResource(r.g.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.ant = (String) textView.getTag();
            if (this.anr != null) {
                this.anr.eK(this.ant);
            }
        }
    }

    private boolean Ay() {
        PluginPackageManager.PluginStatus bt = PluginPackageManager.iz().bt(PluginCenter.NAME_MOTUSDK);
        if (bt == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bt == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), r.l.plugin_config_not_found);
            return false;
        } else if (bt == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.iz().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bt == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.ann.getPageContext(), r.l.plugin_muto_not_install, new f(this), new g(this));
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
