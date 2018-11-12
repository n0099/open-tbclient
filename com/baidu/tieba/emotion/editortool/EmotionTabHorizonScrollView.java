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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools Ta;
    private int aIf;
    private int aXF;
    private int aXG;
    private TextView aXH;
    private View aXI;
    private EmotionLinearLayout dgb;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dgc;
    private EmotionTabWidgetView.a dgd;
    private LinearLayout dge;
    private ImageView dgf;
    private boolean dgg;
    private TbImageView dgh;
    private boolean dgi;
    private int from;
    private int mCurrentIndex;
    private LinearLayout.LayoutParams mParams;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.dgg = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.dgg = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.dgg = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.dgb = new EmotionLinearLayout(getContext());
        this.dgb.setOrientation(0);
        this.dgb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dgb.setBaselineAligned(false);
        addView(this.dgb);
        this.aXF = getResources().getDimensionPixelSize(e.C0200e.ds8);
        this.aXG = getResources().getDimensionPixelSize(e.C0200e.ds10);
        this.mParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0200e.ds122), -1);
        this.dgb.setPadding(0, 0, 0, 0);
        asL();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.dgi = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dgc = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.dgm = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.dgk = tbImageView;
        if (cVar.Li() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aXG, this.aXF, this.aXG, this.aXF);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, e.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.h(getContext(), e.C0200e.ds12), l.h(getContext(), e.C0200e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.dgl = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0200e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.dgb.addView(relativeLayout, this.dgb.getChildCount() - 1, this.mParams);
            if (cVar.Lk() != null) {
                cVar.Lk().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.dgi && this.aIf == 1) {
                view.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.dgh == null) {
                this.dgh = tbImageView;
                this.dgh.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(relativeLayout, e.f.bg_emotion_tab_horizonscrollview, this.aIf);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aXG, this.aXF, this.aXG, this.aXF);
            View view2 = new View(getContext());
            aVar.dgl = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0200e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.dgb.addView(linearLayout, this.dgb.getChildCount() - 1, this.mParams);
            EmotionGroupType Li = cVar.Li();
            if (Li == EmotionGroupType.LOCAL) {
                if (cVar.Lj() != null) {
                    cVar.Lj().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dgb.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.local_emotion));
            } else if (Li == EmotionGroupType.PROMOTION) {
                if (cVar.Lk() != null) {
                    cVar.Lk().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (Li == EmotionGroupType.BIG_EMOTION) {
                if (this.dgg) {
                    if (cVar.Lj() != null) {
                        cVar.Lj().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.dgb.getChildCount() - 3));
                } else {
                    if (cVar.Lk() != null) {
                        cVar.Lk().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).AJ();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Li == EmotionGroupType.USER_COLLECT) {
                if (cVar.Lk() != null) {
                    cVar.Lk().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dgb.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Li == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Lk() != null) {
                    cVar.Lk().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.dgi && this.aIf == 1) {
                view2.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.dgh == null) {
                this.dgh = tbImageView;
                this.dgh.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(linearLayout, e.f.bg_emotion_tab_horizonscrollview, this.aIf);
        }
        return tbImageView;
    }

    public void asL() {
        this.dgf = new ImageView(getContext());
        this.dgf.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dgf.setPadding(this.aXG, this.aXF, this.aXG, this.aXF);
        this.dge = new LinearLayout(getContext());
        this.dge.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dgf.setLayoutParams(layoutParams);
        al.b(this.dgf, e.f.face_store, this.aIf);
        this.dge.addView(this.dgf);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0200e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.e(view, e.d.common_color_10288, this.aIf);
        this.dge.addView(view);
        this.aXH = new TextView(getContext());
        this.aXH.setGravity(17);
        this.aXH.setTextSize(10.0f);
        this.aXH.setText("N");
        this.aXH.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dgb.addView(this.dge, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0200e.ds106), -1));
        this.dgb.setNewView(this.aXH);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.dgb.setNewViewVisible(true);
        } else {
            this.dgb.setNewViewVisible(false);
        }
        this.dge.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aXH != null) {
                    EmotionTabHorizonScrollView.this.dgb.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Ta != null) {
                    EmotionTabHorizonScrollView.this.Ta.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.kV()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), e.j.neterror);
                }
            }
        });
        this.aXI = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aXI.setLayoutParams(layoutParams3);
        this.dgb.addView(this.aXI);
        if (!appResponseToIntentClass) {
            this.dge.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.dgg = z;
        int i2 = i + 1;
        int childCount = this.dgb.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.dgc.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Li() == EmotionGroupType.BIG_EMOTION || cVar.Li() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.dgb.getChildAt(i2)).getChildAt(0);
                if (!this.dgg) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).AJ();
                        }
                    });
                    if (cVar.Lk() != null) {
                        cVar.Lk().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Lj() != null) {
                    cVar.Lj().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.dgb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dgb.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).dgm;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.dge.setVisibility(8);
        } else {
            this.dge.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Li() == EmotionGroupType.BIG_EMOTION || cVar.Li() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dgb.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aIf == 0) {
                        color = getResources().getColor(e.d.common_color_10287);
                    } else {
                        color = al.getColor(e.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dgb.getChildAt(this.mCurrentIndex + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(e.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dgc.get(this.mCurrentIndex);
            if (cVar.Lj() != null) {
                cVar.Lj().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(e.d.common_color_10022));
                this.dgh = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.dgb.removeAllViews();
        asL();
        eo(this.aIf);
    }

    public void eo(int i) {
        int color;
        this.aIf = i;
        if (this.dgf != null) {
            al.b(this.dgf, e.f.face_store, i);
        }
        if (this.dge != null) {
            al.d(this.dge, e.f.bg_emotion_tab_horizonscrollview, i);
            if (this.dge.getChildCount() > 0) {
                al.e(this.dge.getChildAt(1), e.d.common_color_10288, i);
            }
        }
        if (this.aXI != null) {
            al.d(this.aXI, e.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aXH != null) {
            al.d(this.aXH, e.f.icon_news_head_prompt_one, i);
            al.b(this.aXH, e.d.cp_cont_i, 1, i);
        }
        int childCount = this.dgb.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.dgb.getChildAt(i2);
            if (childAt != null) {
                al.d(childAt, e.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.dgk != null) {
                        if (i == 0) {
                            color = getResources().getColor(e.d.common_color_10287);
                        } else {
                            color = al.getColor(e.d.common_color_10287);
                        }
                        aVar.dgk.setForegroundColor(color);
                    }
                    if (aVar.dgl != null) {
                        al.e(aVar.dgl, e.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.dgh != null) {
            this.dgh.setForegroundColor(al.getColor(e.d.common_color_10022));
            if (this.dgh.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dgh.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.dgd = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        private final int awt;

        private b(int i) {
            this.awt = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.dgh) {
                ((TbImageView) view).setForegroundColor(al.getColor(e.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.dgh != null) {
                    if (!EmotionTabHorizonScrollView.this.dgi) {
                        EmotionTabHorizonScrollView.this.dgh.setForegroundColor(al.getColor(e.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.dgh.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(e.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.dgh = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.awt);
            EmotionTabHorizonScrollView.this.dgd.fH(this.awt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.g.b.l(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.l(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TbImageView dgk;
        View dgl;
        com.baidu.tbadk.editortools.emotiontool.c dgm;

        private a() {
        }
    }
}
