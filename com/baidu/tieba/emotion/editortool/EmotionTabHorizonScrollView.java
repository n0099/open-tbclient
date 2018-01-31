package com.baidu.tieba.emotion.editortool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends com.baidu.tbadk.core.view.d {
    private i axQ;
    private int bdS;
    private int btf;
    private LinearLayout.LayoutParams bth;
    private int bti;
    private int btj;
    private TextView btk;
    private View btl;
    private com.baidu.tieba.emotion.editortool.a dlm;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dln;
    private EmotionTabWidgetView.a dlo;
    private LinearLayout dlp;
    private ImageView dlq;
    private boolean dlr;
    private TbImageView dls;
    private boolean dlt;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btf = -1;
        this.dlr = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btf = -1;
        this.dlr = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.btf = -1;
        this.dlr = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.dlm = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.dlm.setOrientation(0);
        this.dlm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dlm.setBaselineAligned(false);
        addView(this.dlm);
        this.bti = getResources().getDimensionPixelSize(d.e.ds8);
        this.btj = getResources().getDimensionPixelSize(d.e.ds10);
        this.bth = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.dlm.setPadding(0, 0, 0, 0);
        ape();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.dlt = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dln = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.dlx = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.dlv = tbImageView;
        if (cVar.KL() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.btj, this.bti, this.btj, this.bti);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.s(getContext(), d.e.ds12), l.s(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.dlw = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.dlm.addView(relativeLayout, this.dlm.getChildCount() - 1, this.bth);
            if (cVar.KN() != null) {
                cVar.KN().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.dlt && this.bdS == 1) {
                view.setBackgroundColor(aj.getColor(d.C0108d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0108d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0108d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0108d.common_color_10287));
            }
            if (this.dls == null) {
                this.dls = tbImageView;
                this.dls.setForegroundColor(aj.getColor(d.C0108d.common_color_10022));
            }
            aj.f(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.bdS);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.btj, this.bti, this.btj, this.bti);
            View view2 = new View(getContext());
            aVar.dlw = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.dlm.addView(linearLayout, this.dlm.getChildCount() - 1, this.bth);
            EmotionGroupType KL = cVar.KL();
            if (KL == EmotionGroupType.LOCAL) {
                if (cVar.KM() != null) {
                    cVar.KM().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dlm.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (KL == EmotionGroupType.PROMOTION) {
                if (cVar.KN() != null) {
                    cVar.KN().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (KL == EmotionGroupType.BIG_EMOTION) {
                if (this.dlr) {
                    if (cVar.KM() != null) {
                        cVar.KM().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.dlm.getChildCount() - 3));
                } else {
                    if (cVar.KN() != null) {
                        cVar.KN().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).AJ();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (KL == EmotionGroupType.USER_COLLECT) {
                if (cVar.KN() != null) {
                    cVar.KN().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dlm.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (KL == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.KN() != null) {
                    cVar.KN().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.dlt && this.bdS == 1) {
                view2.setBackgroundColor(aj.getColor(d.C0108d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0108d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0108d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0108d.common_color_10287));
            }
            if (this.dls == null) {
                this.dls = tbImageView;
                this.dls.setForegroundColor(aj.getColor(d.C0108d.common_color_10022));
            }
            aj.f(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.bdS);
        }
        return tbImageView;
    }

    public void ape() {
        this.dlq = new ImageView(getContext());
        this.dlq.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dlq.setPadding(this.btj, this.bti, this.btj, this.bti);
        this.dlp = new LinearLayout(getContext());
        this.dlp.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dlq.setLayoutParams(layoutParams);
        aj.b(this.dlq, d.f.face_store, this.bdS);
        this.dlp.addView(this.dlq);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.g(view, d.C0108d.common_color_10288, this.bdS);
        this.dlp.addView(view);
        this.btk = new TextView(getContext());
        this.btk.setGravity(17);
        this.btk.setTextSize(10.0f);
        this.btk.setText("N");
        this.btk.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dlm.addView(this.dlp, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.dlm.setNewView(this.btk);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.dlm.setNewViewVisible(true);
        } else {
            this.dlm.setNewViewVisible(false);
        }
        this.dlp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.btk != null) {
                    EmotionTabHorizonScrollView.this.dlm.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.axQ != null) {
                    EmotionTabHorizonScrollView.this.axQ.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.oJ()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.btl = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.btl.setLayoutParams(layoutParams3);
        this.dlm.addView(this.btl);
        if (!appResponseToIntentClass) {
            this.dlp.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void y(int i, boolean z) {
        this.dlr = z;
        int i2 = i + 1;
        int childCount = this.dlm.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.dln.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.KL() == EmotionGroupType.BIG_EMOTION || cVar.KL() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.dlm.getChildAt(i2)).getChildAt(0);
                if (!this.dlr) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).AJ();
                        }
                    });
                    if (cVar.KN() != null) {
                        cVar.KN().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.KM() != null) {
                    cVar.KM().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.dlm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dlm.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).dlx;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.dlp.setVisibility(8);
        } else {
            this.dlp.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.KL() == EmotionGroupType.BIG_EMOTION || cVar.KL() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.btf) {
            if (this.btf != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dlm.getChildAt(this.btf + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.bdS == 0) {
                        color = getResources().getColor(d.C0108d.common_color_10287);
                    } else {
                        color = aj.getColor(d.C0108d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.btf = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dlm.getChildAt(this.btf + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(d.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dln.get(this.btf);
            if (cVar.KM() != null) {
                cVar.KM().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.C0108d.common_color_10022));
                this.dls = tbImageView2;
            }
        }
    }

    public void reset() {
        this.btf = -1;
        this.dlm.removeAllViews();
        ape();
        gz(this.bdS);
    }

    public void gz(int i) {
        int color;
        this.bdS = i;
        if (this.dlq != null) {
            aj.b(this.dlq, d.f.face_store, i);
        }
        if (this.dlp != null) {
            aj.f(this.dlp, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.dlp.getChildCount() > 0) {
                aj.g(this.dlp.getChildAt(1), d.C0108d.common_color_10288, i);
            }
        }
        if (this.btl != null) {
            aj.f(this.btl, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.btk != null) {
            aj.f(this.btk, d.f.icon_news_head_prompt_one, i);
            aj.b(this.btk, d.C0108d.cp_cont_i, 1, i);
        }
        int childCount = this.dlm.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.dlm.getChildAt(i2);
            if (childAt != null) {
                aj.f(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.dlv != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0108d.common_color_10287);
                        } else {
                            color = aj.getColor(d.C0108d.common_color_10287);
                        }
                        aVar.dlv.setForegroundColor(color);
                    }
                    if (aVar.dlw != null) {
                        aj.g(aVar.dlw, d.C0108d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.dls != null) {
            this.dls.setForegroundColor(aj.getColor(d.C0108d.common_color_10022));
            if (this.dls.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dls.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.dlo = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axQ = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aTn;

        private b(int i) {
            this.aTn = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.dls) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.C0108d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.dls != null) {
                    if (!EmotionTabHorizonScrollView.this.dlt) {
                        EmotionTabHorizonScrollView.this.dls.setForegroundColor(aj.getColor(d.C0108d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.dls.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0108d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.dls = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aTn);
            EmotionTabHorizonScrollView.this.dlo.hV(this.aTn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.g.b.h(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.h(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView dlv;
        View dlw;
        com.baidu.tbadk.editortools.emotiontool.c dlx;

        private a() {
        }
    }
}
