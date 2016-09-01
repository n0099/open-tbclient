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
    private int aoa;
    private int aob;
    private Runnable aoc;
    private TbPageContextSupport aod;
    private ImageView[] aoe;
    private View aof;
    private View aog;
    private a aoh;
    private boolean aoi;
    private String aoj;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void eM(String str);
    }

    public c(TbPageContextSupport tbPageContextSupport, a aVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.aoa = 0;
        this.aob = 0;
        this.aoc = new d(this);
        this.mContext = null;
        this.aoe = null;
        this.aof = null;
        this.aog = null;
        this.aoh = null;
        this.aoi = true;
        this.aoj = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.aod = tbPageContextSupport;
        this.aoh = aVar;
        if (str != null) {
            this.aoj = str;
        }
        init();
    }

    private void init() {
        this.aoa = (int) this.mContext.getResources().getDimension(t.e.ds4);
        this.aob = (int) this.mContext.getResources().getDimension(t.e.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.aob, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(t.b.fiter_name);
        this.aoe = new ImageView[stringArray.length];
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
            imageView.setPadding(this.aoa, this.aoa, this.aoa, this.aoa);
            imageView.setTag(textView);
            imageView.setOnClickListener(new e(this));
            if (substring.equals(this.aoj)) {
                this.aof = inflate;
                this.aog = imageView;
                imageView.setBackgroundResource(t.f.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(eL(substring));
            this.aoe[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aof != null) {
            post(this.aoc);
        }
    }

    public String getSelectedFilter() {
        return this.aog != null ? (String) ((View) this.aog.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.aoi = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(View view) {
        if (this.aoi && view != this.aog && AG()) {
            if (this.aog != null) {
                this.aog.setBackgroundDrawable(null);
                ((TextView) this.aog.getTag()).setSelected(false);
            }
            this.aog = view;
            view.setBackgroundResource(t.f.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.aoj = (String) textView.getTag();
            if (this.aoh != null) {
                this.aoh.eM(this.aoj);
            }
        }
    }

    private boolean AG() {
        PluginPackageManager.PluginStatus bu = PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK);
        if (bu == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bu == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), t.j.plugin_config_not_found);
            return false;
        } else if (bu == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.iB().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bu == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.aod.getPageContext(), t.j.plugin_muto_not_install, new f(this), new g(this));
            return false;
        } else {
            return true;
        }
    }

    public static int eL(String str) {
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
