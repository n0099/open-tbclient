package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.j KO;
    private int aBT;
    private LinearLayout.LayoutParams aBV;
    private int aBW;
    private int aBX;
    private TextView aBY;
    private View aBZ;
    private int amZ;
    private i bFb;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFc;
    private EmotionTabWidgetView.a bFd;
    private LinearLayout bFe;
    private ImageView bFf;
    private boolean bFg;
    private TbImageView bFh;
    private boolean bFi;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBT = -1;
        this.bFg = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBT = -1;
        this.bFg = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aBT = -1;
        this.bFg = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bFb = new i(getContext());
        this.bFb.setOrientation(0);
        this.bFb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bFb.setBaselineAligned(false);
        addView(this.bFb);
        this.aBW = getResources().getDimensionPixelSize(w.f.ds8);
        this.aBX = getResources().getDimensionPixelSize(w.f.ds10);
        this.aBV = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds122), -1);
        this.bFb.setPadding(0, 0, 0, 0);
        Wh();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bFi = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bFc = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a(null);
        aVar.bFm = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bFk = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aBX, this.aBW, this.aBX, this.aBW);
        View view = new View(getContext());
        aVar.bFl = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bFb.addView(linearLayout, this.bFb.getChildCount() - 1, this.aBV);
        EmotionGroupType DC = cVar.DC();
        if (DC == EmotionGroupType.LOCAL) {
            if (cVar.DD() != null) {
                cVar.DD().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bFb.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.local_emotion));
        } else if (DC == EmotionGroupType.PROMOTION) {
            if (cVar.DE() != null) {
                cVar.DE().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(w.l.download_promotion_emotion)) + cVar.getGroupId());
        } else if (DC == EmotionGroupType.BIG_EMOTION) {
            if (this.bFg) {
                if (cVar.DD() != null) {
                    cVar.DD().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this, this.bFb.getChildCount() - 3, null));
            } else {
                if (cVar.DE() != null) {
                    cVar.DE().e(tbImageView);
                }
                tbImageView.setOnClickListener(new n(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (!this.bFi && this.amZ == 1) {
            view.setBackgroundColor(aq.getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(aq.getColor(w.e.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(w.e.common_color_10287));
        }
        if (this.bFh == null) {
            this.bFh = tbImageView;
            this.bFh.setForegroundColor(aq.getColor(w.e.common_color_10022));
        }
        aq.d(linearLayout, w.g.bg_emotion_tab_horizonscrollview, this.amZ);
        return tbImageView;
    }

    public void Wh() {
        this.bFf = new ImageView(getContext());
        this.bFf.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bFf.setPadding(this.aBX, this.aBW, this.aBX, this.aBW);
        this.bFe = new LinearLayout(getContext());
        this.bFe.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bFf.setLayoutParams(layoutParams);
        aq.c(this.bFf, w.g.icon_store, this.amZ);
        this.bFe.addView(this.bFf);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aq.e(view, w.e.common_color_10288, this.amZ);
        this.bFe.addView(view);
        this.aBY = new TextView(getContext());
        this.aBY.setGravity(17);
        this.aBY.setTextSize(10.0f);
        this.aBY.setText("N");
        this.aBY.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bFb.addView(this.bFe, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1));
        this.bFb.setNewView(this.aBY);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bFb.setNewViewVisible(true);
        } else {
            this.bFb.setNewViewVisible(false);
        }
        this.bFe.setOnClickListener(new o(this));
        this.aBZ = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aBZ.setLayoutParams(layoutParams3);
        this.bFb.addView(this.aBZ);
        if (!appResponseToIntentClass) {
            this.bFe.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void l(int i, boolean z) {
        this.bFg = z;
        int i2 = i + 1;
        int childCount = this.bFb.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFc.get(i2 - 1);
        if (i2 < childCount && cVar.DC() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bFb.getChildAt(i2)).getChildAt(0);
            if (!this.bFg) {
                tbImageView.setOnClickListener(new p(this));
                if (cVar.DE() != null) {
                    cVar.DE().e(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new b(this, i2 - 1, null));
            if (cVar.DD() != null) {
                cVar.DD().e(tbImageView);
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bFb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bFb.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bFm;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bFe.setVisibility(8);
        } else {
            this.bFe.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.DC() == EmotionGroupType.BIG_EMOTION || cVar.DC() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aBT) {
            if (this.aBT != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bFb.getChildAt(this.aBT + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.amZ == 0) {
                        color = getResources().getColor(w.e.common_color_10287);
                    } else {
                        color = aq.getColor(w.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aBT = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bFb.getChildAt(this.aBT + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(w.h.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFc.get(this.aBT);
            if (cVar.DD() != null) {
                cVar.DD().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aq.getColor(w.e.common_color_10022));
                this.bFh = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aBT = -1;
        this.bFb.removeAllViews();
        Wh();
        m17do(this.amZ);
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(int i) {
        int color;
        this.amZ = i;
        if (this.bFf != null) {
            aq.c(this.bFf, w.g.icon_store, i);
        }
        if (this.bFe != null) {
            aq.d(this.bFe, w.g.bg_emotion_tab_horizonscrollview, i);
            if (this.bFe.getChildCount() > 0) {
                aq.e(this.bFe.getChildAt(1), w.e.common_color_10288, i);
            }
        }
        if (this.aBZ != null) {
            aq.d(this.aBZ, w.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aBY != null) {
            aq.d(this.aBY, w.g.icon_news_head_prompt_one, i);
            aq.b(this.aBY, w.e.cp_cont_i, 1, i);
        }
        int childCount = this.bFb.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bFb.getChildAt(i2);
            if (childAt != null) {
                aq.d(childAt, w.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bFk != null) {
                        if (i == 0) {
                            color = getResources().getColor(w.e.common_color_10287);
                        } else {
                            color = aq.getColor(w.e.common_color_10287);
                        }
                        aVar.bFk.setForegroundColor(color);
                    }
                    if (aVar.bFl != null) {
                        aq.e(aVar.bFl, w.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bFh != null) {
            this.bFh.setForegroundColor(aq.getColor(w.e.common_color_10022));
            if (this.bFh.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bFh.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bFd = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KO = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aeg;

        private b(int i) {
            this.aeg = i;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bFh) {
                ((TbImageView) view).setForegroundColor(aq.getColor(w.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bFh != null) {
                    if (!EmotionTabHorizonScrollView.this.bFi) {
                        EmotionTabHorizonScrollView.this.bFh.setForegroundColor(aq.getColor(w.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bFh.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(w.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bFh = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aeg);
            EmotionTabHorizonScrollView.this.bFd.eQ(this.aeg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        /* synthetic */ c(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, c cVar) {
            this(str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            switch (EmotionTabHorizonScrollView.this.from) {
                case 1:
                    str = "faceshop_from_write_promotion";
                    break;
                case 2:
                    str = "faceshop_from_pchat_promotion";
                    break;
                case 3:
                    str = "faceshop_from_gchat_promotion";
                    break;
                default:
                    str = "";
                    break;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), this.mGroupId, false, str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView bFk;
        View bFl;
        com.baidu.tbadk.editortools.emotiontool.c bFm;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
