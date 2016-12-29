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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.j EM;
    private int aib;
    private int axc;
    private LinearLayout.LayoutParams axe;
    private int axf;
    private int axg;
    private TextView axh;
    private View axi;
    private h bnY;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bnZ;
    private EmotionTabWidgetView.a boa;
    private LinearLayout bob;
    private ImageView boc;
    private boolean bod;
    private TbImageView boe;
    private boolean bof;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axc = -1;
        this.bod = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axc = -1;
        this.bod = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.axc = -1;
        this.bod = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bnY = new h(getContext());
        this.bnY.setOrientation(0);
        this.bnY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bnY.setBaselineAligned(false);
        addView(this.bnY);
        this.axf = getResources().getDimensionPixelSize(r.e.ds8);
        this.axg = getResources().getDimensionPixelSize(r.e.ds10);
        this.axe = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds122), -1);
        this.bnY.setPadding(0, 0, 0, 0);
        So();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bof = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bnZ = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a(null);
        aVar.boj = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.boh = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.axg, this.axf, this.axg, this.axf);
        View view = new View(getContext());
        aVar.boi = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bnY.addView(linearLayout, this.bnY.getChildCount() - 1, this.axe);
        EmotionGroupType CR = cVar.CR();
        if (CR == EmotionGroupType.LOCAL) {
            if (cVar.CS() != null) {
                cVar.CS().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bnY.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(r.j.local_emotion));
        } else if (CR == EmotionGroupType.PROMOTION) {
            if (cVar.CT() != null) {
                cVar.CT().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(r.j.download_promotion_emotion)) + cVar.getGroupId());
        } else if (CR == EmotionGroupType.BIG_EMOTION) {
            if (this.bod) {
                if (cVar.CS() != null) {
                    cVar.CS().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this, this.bnY.getChildCount() - 3, null));
            } else {
                if (cVar.CT() != null) {
                    cVar.CT().e(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (!this.bof) {
            view.setBackgroundColor(ar.getColor(r.d.common_color_10288));
            tbImageView.setForegroundColor(ar.getColor(r.d.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(r.d.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(r.d.common_color_10287));
        }
        if (this.boe == null) {
            this.boe = tbImageView;
            this.boe.setForegroundColor(ar.getColor(r.d.common_color_10022));
        }
        ar.d(linearLayout, r.f.bg_emotion_tab_horizonscrollview, this.aib);
        return tbImageView;
    }

    public void So() {
        this.boc = new ImageView(getContext());
        this.boc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.boc.setPadding(this.axg, this.axf, this.axg, this.axf);
        this.bob = new LinearLayout(getContext());
        this.bob.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(r.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.boc.setLayoutParams(layoutParams);
        ar.c(this.boc, r.f.icon_store, this.aib);
        this.bob.addView(this.boc);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ar.e(view, r.d.common_color_10288, this.aib);
        this.bob.addView(view);
        this.axh = new TextView(getContext());
        this.axh.setGravity(17);
        this.axh.setTextSize(10.0f);
        this.axh.setText("N");
        this.axh.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bnY.addView(this.bob, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds106), -1));
        this.bnY.setNewView(this.axh);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bnY.setNewViewVisible(true);
        } else {
            this.bnY.setNewViewVisible(false);
        }
        this.bob.setOnClickListener(new n(this));
        this.axi = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.axi.setLayoutParams(layoutParams3);
        this.bnY.addView(this.axi);
        if (!appResponseToIntentClass) {
            this.bob.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void m(int i, boolean z) {
        this.bod = z;
        int i2 = i + 1;
        int childCount = this.bnY.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bnZ.get(i2 - 1);
        if (i2 < childCount && cVar.CR() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bnY.getChildAt(i2)).getChildAt(0);
            if (!this.bod) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.CT() != null) {
                    cVar.CT().e(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new b(this, i2 - 1, null));
            if (cVar.CS() != null) {
                cVar.CS().e(tbImageView);
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bnY.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bnY.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).boj;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bob.setVisibility(8);
        } else {
            this.bob.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.CR() == EmotionGroupType.BIG_EMOTION || cVar.CR() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.axc) {
            if (this.axc != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bnY.getChildAt(this.axc + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aib == 0) {
                        color = getResources().getColor(r.d.common_color_10287);
                    } else {
                        color = ar.getColor(r.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.axc = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bnY.getChildAt(this.axc + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(r.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bnZ.get(this.axc);
            if (cVar.CS() != null) {
                cVar.CS().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ar.getColor(r.d.common_color_10022));
                this.boe = tbImageView2;
            }
        }
    }

    public void reset() {
        this.axc = -1;
        this.bnY.removeAllViews();
        So();
        m16do(TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* renamed from: do  reason: not valid java name */
    public void m16do(int i) {
        int color;
        this.aib = i;
        if (this.boc != null) {
            ar.c(this.boc, r.f.icon_store, i);
        }
        if (this.bob != null) {
            ar.d(this.bob, r.f.bg_emotion_tab_horizonscrollview, i);
            if (this.bob.getChildCount() > 0) {
                ar.e(this.bob.getChildAt(1), r.d.common_color_10288, i);
            }
        }
        if (this.axi != null) {
            ar.d(this.axi, r.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.axh != null) {
            ar.d(this.axh, r.f.icon_news_head_prompt_one, i);
            ar.b(this.axh, r.d.cp_cont_i, 1, i);
        }
        int childCount = this.bnY.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bnY.getChildAt(i2);
            if (childAt != null) {
                ar.d(childAt, r.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.boh != null) {
                        if (i == 0) {
                            color = getResources().getColor(r.d.common_color_10287);
                        } else {
                            color = ar.getColor(r.d.common_color_10287);
                        }
                        aVar.boh.setForegroundColor(color);
                    }
                    if (aVar.boi != null) {
                        ar.e(aVar.boi, r.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.boe != null) {
            this.boe.setForegroundColor(ar.getColor(r.d.common_color_10022));
            if (this.boe.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.boe.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.boa = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.EM = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int Zo;

        private b(int i) {
            this.Zo = i;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.boe) {
                ((TbImageView) view).setForegroundColor(ar.getColor(r.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.boe != null) {
                    if (!EmotionTabHorizonScrollView.this.bof) {
                        EmotionTabHorizonScrollView.this.boe.setForegroundColor(ar.getColor(r.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.boe.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(r.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.boe = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.Zo);
            EmotionTabHorizonScrollView.this.boa.eR(this.Zo);
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
        TbImageView boh;
        View boi;
        com.baidu.tbadk.editortools.emotiontool.c boj;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
