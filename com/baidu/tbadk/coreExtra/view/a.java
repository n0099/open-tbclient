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
    private int avj;
    private int avk;
    private TbPageContextSupport avl;
    private ImageView[] avm;
    private View avn;
    private View avo;
    private InterfaceC0051a avp;
    private boolean avq;
    private String avr;
    private Context mContext;
    private Runnable scrollRunnable;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0051a {
        void ff(String str);
    }

    public a(TbPageContextSupport tbPageContextSupport, InterfaceC0051a interfaceC0051a, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.avj = 0;
        this.avk = 0;
        this.scrollRunnable = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.a.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (a.this.avn != null) {
                    int childCount = ((LinearLayout) a.this.getChildAt(0)).getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            i = 0;
                            break;
                        }
                        View childAt = ((LinearLayout) a.this.getChildAt(0)).getChildAt(i2);
                        if (childAt != a.this.avn) {
                            i2++;
                        } else {
                            i = childAt.getRight();
                            break;
                        }
                    }
                    a.this.avn = null;
                    int width = i - a.this.getWidth();
                    if (width > 0) {
                        a.this.scrollBy(width, 0);
                    }
                }
            }
        };
        this.mContext = null;
        this.avm = null;
        this.avn = null;
        this.avo = null;
        this.avp = null;
        this.avq = true;
        this.avr = "normal";
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.avl = tbPageContextSupport;
        this.avp = interfaceC0051a;
        if (str != null) {
            this.avr = str;
        }
        init();
    }

    private void init() {
        this.avj = (int) this.mContext.getResources().getDimension(d.f.ds4);
        this.avk = (int) this.mContext.getResources().getDimension(d.f.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.avk, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(d.b.fiter_name);
        this.avm = new ImageView[stringArray.length];
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(d.h.filter_immage);
            imageView.setPadding(this.avj, this.avj, this.avj, this.avj);
            imageView.setTag(textView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.J(view);
                }
            });
            if (substring.equals(this.avr)) {
                this.avn = inflate;
                this.avo = imageView;
                imageView.setBackgroundResource(d.g.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(fe(substring));
            this.avm[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.avn != null) {
            post(this.scrollRunnable);
        }
    }

    public String getSelectedFilter() {
        return this.avo != null ? (String) ((View) this.avo.getTag()).getTag() : "normal";
    }

    public void setCanbeClick(boolean z) {
        this.avq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(View view) {
        if (this.avq && view != this.avo && Bd()) {
            if (this.avo != null) {
                this.avo.setBackgroundDrawable(null);
                ((TextView) this.avo.getTag()).setSelected(false);
            }
            this.avo = view;
            view.setBackgroundResource(d.g.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.avr = (String) textView.getTag();
            if (this.avp != null) {
                this.avp.ff(this.avr);
            }
        }
    }

    private boolean Bd() {
        PluginPackageManager.PluginStatus bs = PluginPackageManager.jw().bs(PluginCenter.NAME_MOTUSDK);
        if (bs == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bs == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), d.l.plugin_config_not_found);
            return false;
        } else if (bs == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.jw().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bs == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.e.a.a(this.avl.getPageContext(), d.l.plugin_muto_not_install, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.a.3
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

    public static int fe(String str) {
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
