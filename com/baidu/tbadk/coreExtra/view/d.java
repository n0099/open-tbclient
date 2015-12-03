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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends HorizontalScrollView {
    private View alA;
    private a alB;
    private boolean alC;
    private String alD;
    private int alu;
    private int alv;
    private Runnable alw;
    private TbPageContextSupport alx;
    private ImageView[] aly;
    private View alz;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void eB(String str);
    }

    public d(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.alu = 0;
        this.alv = 0;
        this.alw = new e(this);
        this.mContext = null;
        this.aly = null;
        this.alz = null;
        this.alA = null;
        this.alB = null;
        this.alC = true;
        this.alD = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.alx = tbPageContextSupport;
        this.alB = aVar;
        if (str != null) {
            this.alD = str;
        }
        init();
    }

    private void init() {
        this.alu = (int) this.mContext.getResources().getDimension(n.d.ds4);
        this.alv = (int) this.mContext.getResources().getDimension(n.d.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.alv, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(n.b.fiter_name);
        this.aly = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = LayoutInflater.from(this.mContext).inflate(n.g.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(n.f.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(n.f.filter_immage);
            imageView.setPadding(this.alu, this.alu, this.alu, this.alu);
            imageView.setTag(textView);
            imageView.setOnClickListener(new f(this));
            if (substring.equals(this.alD)) {
                this.alz = inflate;
                this.alA = imageView;
                imageView.setBackgroundResource(n.e.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eA(substring));
            this.aly[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.alz != null) {
            post(this.alw);
        }
    }

    public String getSelectedFilter() {
        return this.alA != null ? (String) ((View) this.alA.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.alC = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(View view) {
        if (this.alC && view != this.alA && zK()) {
            if (this.alA != null) {
                this.alA.setBackgroundDrawable(null);
                ((TextView) this.alA.getTag()).setSelected(false);
            }
            this.alA = view;
            view.setBackgroundResource(n.e.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.alD = (String) textView.getTag();
            if (this.alB != null) {
                this.alB.eB(this.alD);
            }
        }
    }

    private boolean zK() {
        PluginPackageManager.PluginStatus by = PluginPackageManager.lU().by(PluginCenter.NAME_MOTUSDK);
        if (by == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (by == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), n.i.plugin_config_not_found);
            return false;
        } else if (by == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.lU().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (by == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.alx.getPageContext(), n.i.plugin_muto_not_install, new g(this), new h(this));
            return false;
        } else {
            return true;
        }
    }

    public static int eA(String str) {
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
