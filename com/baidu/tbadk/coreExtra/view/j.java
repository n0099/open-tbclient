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
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class j extends HorizontalScrollView {
    private int TX;
    private int TY;
    private Runnable TZ;
    private TbPageContextSupport Ua;
    private ImageView[] Ub;
    private View Uc;
    private View Ud;
    private o Ue;
    private boolean Uf;
    private String Ug;
    private Context mContext;

    public j(TbPageContextSupport tbPageContextSupport, o oVar, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.TX = 0;
        this.TY = 0;
        this.TZ = new k(this);
        this.mContext = null;
        this.Ub = null;
        this.Uc = null;
        this.Ud = null;
        this.Ue = null;
        this.Uf = true;
        this.Ug = WriteImageActivityConfig.FILTER_NAME_NORMAL;
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.Ua = tbPageContextSupport;
        this.Ue = oVar;
        if (str != null) {
            this.Ug = str;
        }
        init();
    }

    private void init() {
        this.TX = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds4);
        this.TY = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.TY, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(com.baidu.tieba.r.fiter_name);
        this.Ub = new ImageView[stringArray.length];
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
            imageView.setPadding(this.TX, this.TX, this.TX, this.TX);
            imageView.setTag(textView);
            imageView.setOnClickListener(new l(this));
            if (substring.equals(this.Ug)) {
                this.Uc = inflate;
                this.Ud = imageView;
                imageView.setBackgroundResource(com.baidu.tieba.v.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(dC(substring));
            this.Ub[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Uc != null) {
            post(this.TZ);
        }
    }

    public String getSelectedFilter() {
        return this.Ud != null ? (String) ((View) this.Ud.getTag()).getTag() : WriteImageActivityConfig.FILTER_NAME_NORMAL;
    }

    public void setCanbeClick(boolean z) {
        this.Uf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view) {
        if (this.Uf && view != this.Ud && tB()) {
            if (this.Ud != null) {
                this.Ud.setBackgroundDrawable(null);
                ((TextView) this.Ud.getTag()).setSelected(false);
            }
            this.Ud = view;
            view.setBackgroundResource(com.baidu.tieba.v.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.Ug = (String) textView.getTag();
            if (this.Ue != null) {
                this.Ue.dD(this.Ug);
            }
        }
    }

    private boolean tB() {
        PluginPackageManager.PluginStatus bj = PluginPackageManager.hV().bj(PluginCenter.NAME_MOTUSDK);
        if (bj == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bj == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), com.baidu.tieba.z.plugin_config_not_found);
            return false;
        } else if (bj == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.hV().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bj == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.util.a.a(this.Ua.getPageContext(), com.baidu.tieba.z.plugin_muto_not_install, new m(this), new n(this));
            return false;
        } else {
            return true;
        }
    }

    public static int dC(String str) {
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
