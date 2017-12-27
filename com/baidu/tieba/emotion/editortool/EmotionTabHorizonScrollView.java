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
    private i axO;
    private int bdE;
    private int bsN;
    private LinearLayout.LayoutParams bsP;
    private int bsQ;
    private int bsR;
    private TextView bsS;
    private View bsT;
    private com.baidu.tieba.emotion.editortool.a dgp;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dgq;
    private EmotionTabWidgetView.a dgr;
    private LinearLayout dgs;
    private ImageView dgt;
    private boolean dgu;
    private TbImageView dgv;
    private boolean dgw;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsN = -1;
        this.dgu = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsN = -1;
        this.dgu = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bsN = -1;
        this.dgu = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.dgp = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.dgp.setOrientation(0);
        this.dgp.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dgp.setBaselineAligned(false);
        addView(this.dgp);
        this.bsQ = getResources().getDimensionPixelSize(d.e.ds8);
        this.bsR = getResources().getDimensionPixelSize(d.e.ds10);
        this.bsP = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.dgp.setPadding(0, 0, 0, 0);
        anW();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.dgw = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dgq = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.dgA = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.dgy = tbImageView;
        if (cVar.KU() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.bsR, this.bsQ, this.bsR, this.bsQ);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.s(getContext(), d.e.ds12), l.s(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.dgz = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.dgp.addView(relativeLayout, this.dgp.getChildCount() - 1, this.bsP);
            if (cVar.KW() != null) {
                cVar.KW().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.dgw && this.bdE == 1) {
                view.setBackgroundColor(aj.getColor(d.C0108d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0108d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0108d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0108d.common_color_10287));
            }
            if (this.dgv == null) {
                this.dgv = tbImageView;
                this.dgv.setForegroundColor(aj.getColor(d.C0108d.common_color_10022));
            }
            aj.f(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.bdE);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.bsR, this.bsQ, this.bsR, this.bsQ);
            View view2 = new View(getContext());
            aVar.dgz = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.dgp.addView(linearLayout, this.dgp.getChildCount() - 1, this.bsP);
            EmotionGroupType KU = cVar.KU();
            if (KU == EmotionGroupType.LOCAL) {
                if (cVar.KV() != null) {
                    cVar.KV().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dgp.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (KU == EmotionGroupType.PROMOTION) {
                if (cVar.KW() != null) {
                    cVar.KW().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (KU == EmotionGroupType.BIG_EMOTION) {
                if (this.dgu) {
                    if (cVar.KV() != null) {
                        cVar.KV().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.dgp.getChildCount() - 3));
                } else {
                    if (cVar.KW() != null) {
                        cVar.KW().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).AQ();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (KU == EmotionGroupType.USER_COLLECT) {
                if (cVar.KW() != null) {
                    cVar.KW().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dgp.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (KU == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.KW() != null) {
                    cVar.KW().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.dgw && this.bdE == 1) {
                view2.setBackgroundColor(aj.getColor(d.C0108d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0108d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0108d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0108d.common_color_10287));
            }
            if (this.dgv == null) {
                this.dgv = tbImageView;
                this.dgv.setForegroundColor(aj.getColor(d.C0108d.common_color_10022));
            }
            aj.f(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.bdE);
        }
        return tbImageView;
    }

    public void anW() {
        this.dgt = new ImageView(getContext());
        this.dgt.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dgt.setPadding(this.bsR, this.bsQ, this.bsR, this.bsQ);
        this.dgs = new LinearLayout(getContext());
        this.dgs.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dgt.setLayoutParams(layoutParams);
        aj.b(this.dgt, d.f.face_store, this.bdE);
        this.dgs.addView(this.dgt);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.g(view, d.C0108d.common_color_10288, this.bdE);
        this.dgs.addView(view);
        this.bsS = new TextView(getContext());
        this.bsS.setGravity(17);
        this.bsS.setTextSize(10.0f);
        this.bsS.setText("N");
        this.bsS.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dgp.addView(this.dgs, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.dgp.setNewView(this.bsS);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.dgp.setNewViewVisible(true);
        } else {
            this.dgp.setNewViewVisible(false);
        }
        this.dgs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.bsS != null) {
                    EmotionTabHorizonScrollView.this.dgp.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.axO != null) {
                    EmotionTabHorizonScrollView.this.axO.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.oI()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.bsT = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.bsT.setLayoutParams(layoutParams3);
        this.dgp.addView(this.bsT);
        if (!appResponseToIntentClass) {
            this.dgs.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void y(int i, boolean z) {
        this.dgu = z;
        int i2 = i + 1;
        int childCount = this.dgp.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.dgq.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.KU() == EmotionGroupType.BIG_EMOTION || cVar.KU() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.dgp.getChildAt(i2)).getChildAt(0);
                if (!this.dgu) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).AQ();
                        }
                    });
                    if (cVar.KW() != null) {
                        cVar.KW().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.KV() != null) {
                    cVar.KV().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.dgp.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dgp.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).dgA;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.dgs.setVisibility(8);
        } else {
            this.dgs.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.KU() == EmotionGroupType.BIG_EMOTION || cVar.KU() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.bsN) {
            if (this.bsN != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dgp.getChildAt(this.bsN + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.bdE == 0) {
                        color = getResources().getColor(d.C0108d.common_color_10287);
                    } else {
                        color = aj.getColor(d.C0108d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bsN = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dgp.getChildAt(this.bsN + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dgq.get(this.bsN);
            if (cVar.KV() != null) {
                cVar.KV().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.C0108d.common_color_10022));
                this.dgv = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bsN = -1;
        this.dgp.removeAllViews();
        anW();
        gC(this.bdE);
    }

    public void gC(int i) {
        int color;
        this.bdE = i;
        if (this.dgt != null) {
            aj.b(this.dgt, d.f.face_store, i);
        }
        if (this.dgs != null) {
            aj.f(this.dgs, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.dgs.getChildCount() > 0) {
                aj.g(this.dgs.getChildAt(1), d.C0108d.common_color_10288, i);
            }
        }
        if (this.bsT != null) {
            aj.f(this.bsT, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.bsS != null) {
            aj.f(this.bsS, d.f.icon_news_head_prompt_one, i);
            aj.b(this.bsS, d.C0108d.cp_cont_i, 1, i);
        }
        int childCount = this.dgp.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.dgp.getChildAt(i2);
            if (childAt != null) {
                aj.f(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.dgy != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0108d.common_color_10287);
                        } else {
                            color = aj.getColor(d.C0108d.common_color_10287);
                        }
                        aVar.dgy.setForegroundColor(color);
                    }
                    if (aVar.dgz != null) {
                        aj.g(aVar.dgz, d.C0108d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.dgv != null) {
            this.dgv.setForegroundColor(aj.getColor(d.C0108d.common_color_10022));
            if (this.dgv.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dgv.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.dgr = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axO = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aTl;

        private b(int i) {
            this.aTl = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.dgv) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.C0108d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.dgv != null) {
                    if (!EmotionTabHorizonScrollView.this.dgw) {
                        EmotionTabHorizonScrollView.this.dgv.setForegroundColor(aj.getColor(d.C0108d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.dgv.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0108d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.dgv = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aTl);
            EmotionTabHorizonScrollView.this.dgr.hZ(this.aTl);
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
        com.baidu.tbadk.editortools.emotiontool.c dgA;
        TbImageView dgy;
        View dgz;

        private a() {
        }
    }
}
