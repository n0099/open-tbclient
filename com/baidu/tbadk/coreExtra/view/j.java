package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.View;
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
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class j extends HorizontalScrollView {
    private int afl;
    private int afm;
    private Runnable afn;
    private TbPageContextSupport afo;
    private ImageView[] afp;
    private View afq;
    private View afr;
    private o afs;
    private boolean aft;
    private String afu;
    private Context mContext;

    public j(TbPageContextSupport tbPageContextSupport, o oVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.afl = 0;
        this.afm = 0;
        this.afn = new k(this);
        this.mContext = null;
        this.afp = null;
        this.afq = null;
        this.afr = null;
        this.afs = null;
        this.aft = true;
        this.afu = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.afo = tbPageContextSupport;
        this.afs = oVar;
        if (str != null) {
            this.afu = str;
        }
        init();
    }

    private void init() {
        this.afl = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds4);
        this.afm = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.afm, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(com.baidu.tieba.l.fiter_name);
        this.afp = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.filter_item, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.q.filter_immage);
            imageView.setPadding(this.afl, this.afl, this.afl, this.afl);
            imageView.setTag(textView);
            imageView.setOnClickListener(new l(this));
            if (substring.equals(this.afu)) {
                this.afq = inflate;
                this.afr = imageView;
                imageView.setBackgroundResource(com.baidu.tieba.p.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(ee(substring));
            this.afp[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.afq != null) {
            post(this.afn);
        }
    }

    public String getSelectedFilter() {
        return this.afr != null ? (String) ((View) this.afr.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.aft = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(View view) {
        if (this.aft && view != this.afr && xN()) {
            if (this.afr != null) {
                this.afr.setBackgroundDrawable(null);
                ((TextView) this.afr.getTag()).setSelected(false);
            }
            this.afr = view;
            view.setBackgroundResource(com.baidu.tieba.p.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.afu = (String) textView.getTag();
            if (this.afs != null) {
                this.afs.ef(this.afu);
            }
        }
    }

    private boolean xN() {
        PluginPackageManager.PluginStatus bB = PluginPackageManager.lM().bB(PluginCenter.NAME_MOTUSDK);
        if (bB == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bB == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), com.baidu.tieba.t.plugin_config_not_found);
            return false;
        } else if (bB == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.lM().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bB == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.util.a.a(this.afo.getPageContext(), com.baidu.tieba.t.plugin_muto_not_install, new m(this), new n(this));
            return false;
        } else {
            return true;
        }
    }

    public static int ee(String str) {
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
