package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class j extends HorizontalScrollView {
    private int Ua;
    private int Ub;
    private Runnable Uc;
    private TbPageContextSupport Ud;
    private ImageView[] Ue;
    private View Uf;
    private View Ug;
    private o Uh;
    private boolean Ui;
    private String Uj;
    private Context mContext;

    public j(TbPageContextSupport tbPageContextSupport, o oVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.Ua = 0;
        this.Ub = 0;
        this.Uc = new k(this);
        this.mContext = null;
        this.Ue = null;
        this.Uf = null;
        this.Ug = null;
        this.Uh = null;
        this.Ui = true;
        this.Uj = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.Ud = tbPageContextSupport;
        this.Uh = oVar;
        if (str != null) {
            this.Uj = str;
        }
        init();
    }

    private void init() {
        this.Ua = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds4);
        this.Ub = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.Ub, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(com.baidu.tieba.r.fiter_name);
        this.Ue = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.filter_item, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.w.filter_immage);
            imageView.setPadding(this.Ua, this.Ua, this.Ua, this.Ua);
            imageView.setTag(textView);
            imageView.setOnClickListener(new l(this));
            if (substring.equals(this.Uj)) {
                this.Uf = inflate;
                this.Ug = imageView;
                imageView.setBackgroundResource(com.baidu.tieba.v.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(dF(substring));
            this.Ue[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Uf != null) {
            post(this.Uc);
        }
    }

    public String getSelectedFilter() {
        return this.Ug != null ? (String) ((View) this.Ug.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.Ui = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view) {
        if (this.Ui && view != this.Ug && tH()) {
            if (this.Ug != null) {
                this.Ug.setBackgroundDrawable(null);
                ((TextView) this.Ug.getTag()).setSelected(false);
            }
            this.Ug = view;
            view.setBackgroundResource(com.baidu.tieba.v.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.Uj = (String) textView.getTag();
            if (this.Uh != null) {
                this.Uh.dG(this.Uj);
            }
        }
    }

    private boolean tH() {
        PluginPackageManager.PluginStatus bm = PluginPackageManager.ic().bm("com.baidu.tieba.pluginMotu");
        if (bm == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bm == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), com.baidu.tieba.z.plugin_config_not_found);
            return false;
        } else if (bm == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.ic().getPluginConfig("com.baidu.tieba.pluginMotu"))));
            return false;
        } else if (bm == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.util.a.a(this.Ud.getPageContext(), com.baidu.tieba.z.plugin_muto_not_install, new m(this), new n(this));
            return false;
        } else {
            return true;
        }
    }

    public static int dF(String str) {
        if (str == null) {
            return com.baidu.tieba.v.motu_filter_normal;
        }
        if (str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            return com.baidu.tieba.v.motu_filter_normal;
        }
        if (str.equals("clvivid")) {
            return com.baidu.tieba.v.motu_filter_skin;
        }
        if (str.equals("cllomoscenery")) {
            return com.baidu.tieba.v.motu_filter_lomo;
        }
        if (str.equals("clcaisefupian")) {
            return com.baidu.tieba.v.motu_filter_classichdr;
        }
        if (str.equals("clm3")) {
            return com.baidu.tieba.v.motu_filter_nashiv;
        }
        if (str.equals("cqiuse")) {
            return com.baidu.tieba.v.motu_filter_fleeting;
        }
        if (str.equals("clzaoan")) {
            return com.baidu.tieba.v.motu_filter_bluetone;
        }
        if (str.equals("clfuguscenery")) {
            return com.baidu.tieba.v.motu_filter_elegant;
        }
        if (str.equals("clheibai")) {
            return com.baidu.tieba.v.motu_filter_gray;
        }
        return com.baidu.tieba.v.motu_filter_normal;
    }
}
