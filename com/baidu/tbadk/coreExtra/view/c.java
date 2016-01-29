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
    private a anA;
    private boolean anB;
    private String anC;
    private int ant;
    private int anu;
    private Runnable anv;
    private TbPageContextSupport anw;
    private ImageView[] anx;
    private View any;
    private View anz;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void eD(String str);
    }

    public c(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.ant = 0;
        this.anu = 0;
        this.anv = new d(this);
        this.mContext = null;
        this.anx = null;
        this.any = null;
        this.anz = null;
        this.anA = null;
        this.anB = true;
        this.anC = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.anw = tbPageContextSupport;
        this.anA = aVar;
        if (str != null) {
            this.anC = str;
        }
        init();
    }

    private void init() {
        this.ant = (int) this.mContext.getResources().getDimension(t.e.ds4);
        this.anu = (int) this.mContext.getResources().getDimension(t.e.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.anu, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(t.b.fiter_name);
        this.anx = new ImageView[stringArray.length];
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
            imageView.setPadding(this.ant, this.ant, this.ant, this.ant);
            imageView.setTag(textView);
            imageView.setOnClickListener(new e(this));
            if (substring.equals(this.anC)) {
                this.any = inflate;
                this.anz = imageView;
                imageView.setBackgroundResource(t.f.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eC(substring));
            this.anx[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.any != null) {
            post(this.anv);
        }
    }

    public String getSelectedFilter() {
        return this.anz != null ? (String) ((View) this.anz.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.anB = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(View view) {
        if (this.anB && view != this.anz && AO()) {
            if (this.anz != null) {
                this.anz.setBackgroundDrawable(null);
                ((TextView) this.anz.getTag()).setSelected(false);
            }
            this.anz = view;
            view.setBackgroundResource(t.f.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.anC = (String) textView.getTag();
            if (this.anA != null) {
                this.anA.eD(this.anC);
            }
        }
    }

    private boolean AO() {
        PluginPackageManager.PluginStatus bB = PluginPackageManager.lD().bB(PluginCenter.NAME_MOTUSDK);
        if (bB == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bB == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), t.j.plugin_config_not_found);
            return false;
        } else if (bB == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.lD().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bB == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.anw.getPageContext(), t.j.plugin_muto_not_install, new f(this), new g(this));
            return false;
        } else {
            return true;
        }
    }

    public static int eC(String str) {
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
