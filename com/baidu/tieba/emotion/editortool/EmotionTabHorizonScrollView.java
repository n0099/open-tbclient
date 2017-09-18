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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private i Jp;
    private int aEn;
    private LinearLayout.LayoutParams aEp;
    private int aEq;
    private int aEr;
    private TextView aEs;
    private View aEt;
    private int apQ;
    private com.baidu.tieba.emotion.editortool.a cbq;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cbr;
    private EmotionTabWidgetView.a cbs;
    private LinearLayout cbt;
    private ImageView cbu;
    private boolean cbv;
    private TbImageView cbw;
    private boolean cbx;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEn = -1;
        this.cbv = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEn = -1;
        this.cbv = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aEn = -1;
        this.cbv = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cbq = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.cbq.setOrientation(0);
        this.cbq.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cbq.setBaselineAligned(false);
        addView(this.cbq);
        this.aEq = getResources().getDimensionPixelSize(d.f.ds8);
        this.aEr = getResources().getDimensionPixelSize(d.f.ds10);
        this.aEp = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds122), -1);
        this.cbq.setPadding(0, 0, 0, 0);
        acy();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.cbx = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cbr = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.cbB = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.cbz = tbImageView;
        if (cVar.Dk() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aEr, this.aEq, this.aEr, this.aEq);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.g.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, k.f(getContext(), d.f.ds12), k.f(getContext(), d.f.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.cbA = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.cbq.addView(relativeLayout, this.cbq.getChildCount() - 1, this.aEp);
            if (cVar.Dm() != null) {
                cVar.Dm().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.cbx && this.apQ == 1) {
                view.setBackgroundColor(aj.getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.e.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.e.common_color_10287));
            }
            if (this.cbw == null) {
                this.cbw = tbImageView;
                this.cbw.setForegroundColor(aj.getColor(d.e.common_color_10022));
            }
            aj.d(relativeLayout, d.g.bg_emotion_tab_horizonscrollview, this.apQ);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aEr, this.aEq, this.aEr, this.aEq);
            View view2 = new View(getContext());
            aVar.cbA = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.cbq.addView(linearLayout, this.cbq.getChildCount() - 1, this.aEp);
            EmotionGroupType Dk = cVar.Dk();
            if (Dk == EmotionGroupType.LOCAL) {
                if (cVar.Dl() != null) {
                    cVar.Dl().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cbq.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.local_emotion));
            } else if (Dk == EmotionGroupType.PROMOTION) {
                if (cVar.Dm() != null) {
                    cVar.Dm().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_promotion_emotion) + cVar.getGroupId());
            } else if (Dk == EmotionGroupType.BIG_EMOTION) {
                if (this.cbv) {
                    if (cVar.Dl() != null) {
                        cVar.Dl().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.cbq.getChildCount() - 3));
                } else {
                    if (cVar.Dm() != null) {
                        cVar.Dm().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tw();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Dk == EmotionGroupType.USER_COLLECT) {
                if (cVar.Dm() != null) {
                    cVar.Dm().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cbq.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Dk == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Dm() != null) {
                    cVar.Dm().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.cbx && this.apQ == 1) {
                view2.setBackgroundColor(aj.getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.e.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.e.common_color_10287));
            }
            if (this.cbw == null) {
                this.cbw = tbImageView;
                this.cbw.setForegroundColor(aj.getColor(d.e.common_color_10022));
            }
            aj.d(linearLayout, d.g.bg_emotion_tab_horizonscrollview, this.apQ);
        }
        return tbImageView;
    }

    public void acy() {
        this.cbu = new ImageView(getContext());
        this.cbu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cbu.setPadding(this.aEr, this.aEq, this.aEr, this.aEq);
        this.cbt = new LinearLayout(getContext());
        this.cbt.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cbu.setLayoutParams(layoutParams);
        aj.b(this.cbu, d.g.face_store, this.apQ);
        this.cbt.addView(this.cbu);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.e(view, d.e.common_color_10288, this.apQ);
        this.cbt.addView(view);
        this.aEs = new TextView(getContext());
        this.aEs.setGravity(17);
        this.aEs.setTextSize(10.0f);
        this.aEs.setText("N");
        this.aEs.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cbq.addView(this.cbt, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1));
        this.cbq.setNewView(this.aEs);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.cbq.setNewViewVisible(true);
        } else {
            this.cbq.setNewViewVisible(false);
        }
        this.cbt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aEs != null) {
                    EmotionTabHorizonScrollView.this.cbq.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Jp != null) {
                    EmotionTabHorizonScrollView.this.Jp.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (com.baidu.adp.lib.util.i.hi()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    k.showToast(EmotionTabHorizonScrollView.this.getContext(), d.l.neterror);
                }
            }
        });
        this.aEt = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aEt.setLayoutParams(layoutParams3);
        this.cbq.addView(this.aEt);
        if (!appResponseToIntentClass) {
            this.cbt.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void m(int i, boolean z) {
        this.cbv = z;
        int i2 = i + 1;
        int childCount = this.cbq.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbr.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Dk() == EmotionGroupType.BIG_EMOTION || cVar.Dk() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.cbq.getChildAt(i2)).getChildAt(0);
                if (!this.cbv) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tw();
                        }
                    });
                    if (cVar.Dm() != null) {
                        cVar.Dm().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Dl() != null) {
                    cVar.Dl().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.cbq.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cbq.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).cbB;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.cbt.setVisibility(8);
        } else {
            this.cbt.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Dk() == EmotionGroupType.BIG_EMOTION || cVar.Dk() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aEn) {
            if (this.aEn != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cbq.getChildAt(this.aEn + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.apQ == 0) {
                        color = getResources().getColor(d.e.common_color_10287);
                    } else {
                        color = aj.getColor(d.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aEn = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cbq.getChildAt(this.aEn + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(d.h.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbr.get(this.aEn);
            if (cVar.Dl() != null) {
                cVar.Dl().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.e.common_color_10022));
                this.cbw = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aEn = -1;
        this.cbq.removeAllViews();
        acy();
        du(this.apQ);
    }

    public void du(int i) {
        int color;
        this.apQ = i;
        if (this.cbu != null) {
            aj.b(this.cbu, d.g.face_store, i);
        }
        if (this.cbt != null) {
            aj.d(this.cbt, d.g.bg_emotion_tab_horizonscrollview, i);
            if (this.cbt.getChildCount() > 0) {
                aj.e(this.cbt.getChildAt(1), d.e.common_color_10288, i);
            }
        }
        if (this.aEt != null) {
            aj.d(this.aEt, d.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aEs != null) {
            aj.d(this.aEs, d.g.icon_news_head_prompt_one, i);
            aj.b(this.aEs, d.e.cp_cont_i, 1, i);
        }
        int childCount = this.cbq.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.cbq.getChildAt(i2);
            if (childAt != null) {
                aj.d(childAt, d.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.cbz != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.e.common_color_10287);
                        } else {
                            color = aj.getColor(d.e.common_color_10287);
                        }
                        aVar.cbz.setForegroundColor(color);
                    }
                    if (aVar.cbA != null) {
                        aj.e(aVar.cbA, d.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.cbw != null) {
            this.cbw.setForegroundColor(aj.getColor(d.e.common_color_10022));
            if (this.cbw.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cbw.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.cbs = aVar;
    }

    public void setEditorTools(i iVar) {
        this.Jp = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int afb;

        private b(int i) {
            this.afb = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.cbw) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.cbw != null) {
                    if (!EmotionTabHorizonScrollView.this.cbx) {
                        EmotionTabHorizonScrollView.this.cbw.setForegroundColor(aj.getColor(d.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.cbw.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.cbw = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.afb);
            EmotionTabHorizonScrollView.this.cbs.eT(this.afb);
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
            if (com.baidu.adp.lib.g.b.g(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.g(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        View cbA;
        com.baidu.tbadk.editortools.emotiontool.c cbB;
        TbImageView cbz;

        private a() {
        }
    }
}
