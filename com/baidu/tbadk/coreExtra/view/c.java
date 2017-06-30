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
    private int atP;
    private int atQ;
    private TbPageContextSupport atR;
    private ImageView[] atS;
    private View atT;
    private View atU;
    private a atV;
    private boolean atW;
    private String atX;
    private Context mContext;
    private Runnable scrollRunnable;

    /* loaded from: classes.dex */
    public interface a {
        void eW(String str);
    }

    public c(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.atP = 0;
        this.atQ = 0;
        this.scrollRunnable = new d(this);
        this.mContext = null;
        this.atS = null;
        this.atT = null;
        this.atU = null;
        this.atV = null;
        this.atW = true;
        this.atX = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.atR = tbPageContextSupport;
        this.atV = aVar;
        if (str != null) {
            this.atX = str;
        }
        init();
    }

    private void init() {
        this.atP = (int) this.mContext.getResources().getDimension(w.f.ds4);
        this.atQ = (int) this.mContext.getResources().getDimension(w.f.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.atQ, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(w.b.fiter_name);
        this.atS = new ImageView[stringArray.length];
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
            imageView.setPadding(this.atP, this.atP, this.atP, this.atP);
            imageView.setTag(textView);
            imageView.setOnClickListener(new e(this));
            if (substring.equals(this.atX)) {
                this.atT = inflate;
                this.atU = imageView;
                imageView.setBackgroundResource(w.g.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eV(substring));
            this.atS[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.atT != null) {
            post(this.scrollRunnable);
        }
    }

    public String getSelectedFilter() {
        return this.atU != null ? (String) ((View) this.atU.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.atW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(View view) {
        if (this.atW && view != this.atU && AP()) {
            if (this.atU != null) {
                this.atU.setBackgroundDrawable(null);
                ((TextView) this.atU.getTag()).setSelected(false);
            }
            this.atU = view;
            view.setBackgroundResource(w.g.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.atX = (String) textView.getTag();
            if (this.atV != null) {
                this.atV.eW(this.atX);
            }
        }
    }

    private boolean AP() {
        PluginPackageManager.PluginStatus bn = PluginPackageManager.jw().bn(PluginCenter.NAME_MOTUSDK);
        if (bn == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bn == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), w.l.plugin_config_not_found);
            return false;
        } else if (bn == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.jw().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bn == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.d.a.a(this.atR.getPageContext(), w.l.plugin_muto_not_install, new f(this), new g(this));
            return false;
        } else {
            return true;
        }
    }

    public static int eV(String str) {
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
