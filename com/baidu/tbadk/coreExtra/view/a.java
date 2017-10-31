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
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends HorizontalScrollView {
    private int auC;
    private int auD;
    private TbPageContextSupport auE;
    private ImageView[] auF;
    private View auG;
    private View auH;
    private InterfaceC0052a auI;
    private boolean auJ;
    private String auK;
    private Context mContext;
    private Runnable scrollRunnable;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0052a {
        void fe(String str);
    }

    public a(TbPageContextSupport tbPageContextSupport, InterfaceC0052a interfaceC0052a, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.auC = 0;
        this.auD = 0;
        this.scrollRunnable = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.a.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (a.this.auG != null) {
                    int childCount = ((LinearLayout) a.this.getChildAt(0)).getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            i = 0;
                            break;
                        }
                        View childAt = ((LinearLayout) a.this.getChildAt(0)).getChildAt(i2);
                        if (childAt != a.this.auG) {
                            i2++;
                        } else {
                            i = childAt.getRight();
                            break;
                        }
                    }
                    a.this.auG = null;
                    int width = i - a.this.getWidth();
                    if (width > 0) {
                        a.this.scrollBy(width, 0);
                    }
                }
            }
        };
        this.mContext = null;
        this.auF = null;
        this.auG = null;
        this.auH = null;
        this.auI = null;
        this.auJ = true;
        this.auK = "normal";
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.auE = tbPageContextSupport;
        this.auI = interfaceC0052a;
        if (str != null) {
            this.auK = str;
        }
        init();
    }

    private void init() {
        this.auC = (int) this.mContext.getResources().getDimension(d.e.ds4);
        this.auD = (int) this.mContext.getResources().getDimension(d.e.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.auD, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(d.b.fiter_name);
        this.auF = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(d.g.filter_immage);
            imageView.setPadding(this.auC, this.auC, this.auC, this.auC);
            imageView.setTag(textView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.K(view);
                }
            });
            if (substring.equals(this.auK)) {
                this.auG = inflate;
                this.auH = imageView;
                imageView.setBackgroundResource(d.f.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(fd(substring));
            this.auF[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.auG != null) {
            post(this.scrollRunnable);
        }
    }

    public String getSelectedFilter() {
        return this.auH != null ? (String) ((View) this.auH.getTag()).getTag() : "normal";
    }

    public void setCanbeClick(boolean z) {
        this.auJ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(View view) {
        if (this.auJ && view != this.auH && AE()) {
            if (this.auH != null) {
                this.auH.setBackgroundDrawable(null);
                ((TextView) this.auH.getTag()).setSelected(false);
            }
            this.auH = view;
            view.setBackgroundResource(d.f.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.auK = (String) textView.getTag();
            if (this.auI != null) {
                this.auI.fe(this.auK);
            }
        }
    }

    private boolean AE() {
        PluginPackageManager.PluginStatus bs = PluginPackageManager.js().bs(PluginCenter.NAME_MOTUSDK);
        if (bs == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bs == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), d.j.plugin_config_not_found);
            return false;
        } else if (bs == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.js().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bs == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.auE.getPageContext(), d.j.plugin_muto_not_install, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(a.this.mContext, PluginCenter.NAME_MOTUSDK)));
                    aVar.dismiss();
                }
            }, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            return false;
        } else {
            return true;
        }
    }

    public static int fd(String str) {
        if (TbadkCoreApplication.getMotuFilterImageMap() == null || TbadkCoreApplication.getMotuFilterImageMap().size() == 0) {
            return 0;
        }
        if (str == null || str.equals("normal")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("normal").intValue();
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
        return TbadkCoreApplication.getMotuFilterImageMap().get("normal").intValue();
    }
}
