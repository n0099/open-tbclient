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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends HorizontalScrollView {
    private int bmg;
    private int bmh;
    private TbPageContextSupport bmi;
    private ImageView[] bmj;
    private View bmk;
    private View bml;
    private InterfaceC0102a bmm;
    private boolean bmn;
    private String bmo;
    private Context mContext;
    private Runnable scrollRunnable;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0102a {
        void fI(String str);
    }

    public a(TbPageContextSupport tbPageContextSupport, InterfaceC0102a interfaceC0102a, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        this.bmg = 0;
        this.bmh = 0;
        this.scrollRunnable = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.a.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (a.this.bmk != null) {
                    int childCount = ((LinearLayout) a.this.getChildAt(0)).getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            i = 0;
                            break;
                        }
                        View childAt = ((LinearLayout) a.this.getChildAt(0)).getChildAt(i2);
                        if (childAt != a.this.bmk) {
                            i2++;
                        } else {
                            i = childAt.getRight();
                            break;
                        }
                    }
                    a.this.bmk = null;
                    int width = i - a.this.getWidth();
                    if (width > 0) {
                        a.this.scrollBy(width, 0);
                    }
                }
            }
        };
        this.mContext = null;
        this.bmj = null;
        this.bmk = null;
        this.bml = null;
        this.bmm = null;
        this.bmn = true;
        this.bmo = "normal";
        this.mContext = tbPageContextSupport.getPageContext().getContext();
        this.bmi = tbPageContextSupport;
        this.bmm = interfaceC0102a;
        if (str != null) {
            this.bmo = str;
        }
        init();
    }

    private void init() {
        this.bmg = (int) this.mContext.getResources().getDimension(d.e.ds4);
        this.bmh = (int) this.mContext.getResources().getDimension(d.e.ds30);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.bmh, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.mContext.getResources().getStringArray(d.b.fiter_name);
        this.bmj = new ImageView[stringArray.length];
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
            imageView.setPadding(this.bmg, this.bmg, this.bmg, this.bmg);
            imageView.setTag(textView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.be(view);
                }
            });
            if (substring.equals(this.bmo)) {
                this.bmk = inflate;
                this.bml = imageView;
                imageView.setBackgroundResource(d.f.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(fH(substring));
            this.bmj[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.bmk != null) {
            post(this.scrollRunnable);
        }
    }

    public String getSelectedFilter() {
        return this.bml != null ? (String) ((View) this.bml.getTag()).getTag() : "normal";
    }

    public void setCanbeClick(boolean z) {
        this.bmn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(View view) {
        if (this.bmn && view != this.bml && Je()) {
            if (this.bml != null) {
                this.bml.setBackgroundDrawable(null);
                ((TextView) this.bml.getTag()).setSelected(false);
            }
            this.bml = view;
            view.setBackgroundResource(d.f.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.bmo = (String) textView.getTag();
            if (this.bmm != null) {
                this.bmm.fI(this.bmo);
            }
        }
    }

    private boolean Je() {
        PluginPackageManager.PluginStatus bA = PluginPackageManager.qS().bA(PluginCenter.NAME_MOTUSDK);
        if (bA == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (bA == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(getContext(), d.j.plugin_config_not_found);
            return false;
        } else if (bA == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(this.mContext, PluginPackageManager.qS().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
            return false;
        } else if (bA == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.d.a.a(this.bmi.getPageContext(), d.j.plugin_muto_not_install, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(a.this.mContext, PluginCenter.NAME_MOTUSDK)));
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

    public static int fH(String str) {
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
