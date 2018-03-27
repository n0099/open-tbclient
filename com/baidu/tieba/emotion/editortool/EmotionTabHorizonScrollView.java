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
    private i axH;
    private int bfC;
    private int bvi;
    private LinearLayout.LayoutParams bvk;
    private int bvl;
    private int bvm;
    private TextView bvn;
    private View bvo;
    private com.baidu.tieba.emotion.editortool.a dnT;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dnU;
    private EmotionTabWidgetView.a dnV;
    private LinearLayout dnW;
    private ImageView dnX;
    private boolean dnY;
    private TbImageView dnZ;
    private boolean doa;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvi = -1;
        this.dnY = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvi = -1;
        this.dnY = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bvi = -1;
        this.dnY = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.dnT = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.dnT.setOrientation(0);
        this.dnT.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dnT.setBaselineAligned(false);
        addView(this.dnT);
        this.bvl = getResources().getDimensionPixelSize(d.e.ds8);
        this.bvm = getResources().getDimensionPixelSize(d.e.ds10);
        this.bvk = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.dnT.setPadding(0, 0, 0, 0);
        apT();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.doa = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dnU = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.dof = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.dod = tbImageView;
        if (cVar.Lr() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.bvm, this.bvl, this.bvm, this.bvl);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.t(getContext(), d.e.ds12), l.t(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.doe = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.dnT.addView(relativeLayout, this.dnT.getChildCount() - 1, this.bvk);
            if (cVar.Lt() != null) {
                cVar.Lt().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.doa && this.bfC == 1) {
                view.setBackgroundColor(aj.getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0141d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0141d.common_color_10287));
            }
            if (this.dnZ == null) {
                this.dnZ = tbImageView;
                this.dnZ.setForegroundColor(aj.getColor(d.C0141d.common_color_10022));
            }
            aj.f(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.bfC);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.bvm, this.bvl, this.bvm, this.bvl);
            View view2 = new View(getContext());
            aVar.doe = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.dnT.addView(linearLayout, this.dnT.getChildCount() - 1, this.bvk);
            EmotionGroupType Lr = cVar.Lr();
            if (Lr == EmotionGroupType.LOCAL) {
                if (cVar.Ls() != null) {
                    cVar.Ls().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dnT.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (Lr == EmotionGroupType.PROMOTION) {
                if (cVar.Lt() != null) {
                    cVar.Lt().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (Lr == EmotionGroupType.BIG_EMOTION) {
                if (this.dnY) {
                    if (cVar.Ls() != null) {
                        cVar.Ls().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.dnT.getChildCount() - 3));
                } else {
                    if (cVar.Lt() != null) {
                        cVar.Lt().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).Bd();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Lr == EmotionGroupType.USER_COLLECT) {
                if (cVar.Lt() != null) {
                    cVar.Lt().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dnT.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Lr == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Lt() != null) {
                    cVar.Lt().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.doa && this.bfC == 1) {
                view2.setBackgroundColor(aj.getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0141d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0141d.common_color_10287));
            }
            if (this.dnZ == null) {
                this.dnZ = tbImageView;
                this.dnZ.setForegroundColor(aj.getColor(d.C0141d.common_color_10022));
            }
            aj.f(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.bfC);
        }
        return tbImageView;
    }

    public void apT() {
        this.dnX = new ImageView(getContext());
        this.dnX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dnX.setPadding(this.bvm, this.bvl, this.bvm, this.bvl);
        this.dnW = new LinearLayout(getContext());
        this.dnW.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dnX.setLayoutParams(layoutParams);
        aj.b(this.dnX, d.f.face_store, this.bfC);
        this.dnW.addView(this.dnX);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.g(view, d.C0141d.common_color_10288, this.bfC);
        this.dnW.addView(view);
        this.bvn = new TextView(getContext());
        this.bvn.setGravity(17);
        this.bvn.setTextSize(10.0f);
        this.bvn.setText("N");
        this.bvn.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dnT.addView(this.dnW, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.dnT.setNewView(this.bvn);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.dnT.setNewViewVisible(true);
        } else {
            this.dnT.setNewViewVisible(false);
        }
        this.dnW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.bvn != null) {
                    EmotionTabHorizonScrollView.this.dnT.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.axH != null) {
                    EmotionTabHorizonScrollView.this.axH.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.oJ()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.bvo = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.bvo.setLayoutParams(layoutParams3);
        this.dnT.addView(this.bvo);
        if (!appResponseToIntentClass) {
            this.dnW.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void C(int i, boolean z) {
        this.dnY = z;
        int i2 = i + 1;
        int childCount = this.dnT.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.dnU.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Lr() == EmotionGroupType.BIG_EMOTION || cVar.Lr() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.dnT.getChildAt(i2)).getChildAt(0);
                if (!this.dnY) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).Bd();
                        }
                    });
                    if (cVar.Lt() != null) {
                        cVar.Lt().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Ls() != null) {
                    cVar.Ls().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.dnT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dnT.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).dof;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.dnW.setVisibility(8);
        } else {
            this.dnW.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Lr() == EmotionGroupType.BIG_EMOTION || cVar.Lr() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.bvi) {
            if (this.bvi != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dnT.getChildAt(this.bvi + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.bfC == 0) {
                        color = getResources().getColor(d.C0141d.common_color_10287);
                    } else {
                        color = aj.getColor(d.C0141d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bvi = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dnT.getChildAt(this.bvi + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dnU.get(this.bvi);
            if (cVar.Ls() != null) {
                cVar.Ls().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.C0141d.common_color_10022));
                this.dnZ = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bvi = -1;
        this.dnT.removeAllViews();
        apT();
        gB(this.bfC);
    }

    public void gB(int i) {
        int color;
        this.bfC = i;
        if (this.dnX != null) {
            aj.b(this.dnX, d.f.face_store, i);
        }
        if (this.dnW != null) {
            aj.f(this.dnW, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.dnW.getChildCount() > 0) {
                aj.g(this.dnW.getChildAt(1), d.C0141d.common_color_10288, i);
            }
        }
        if (this.bvo != null) {
            aj.f(this.bvo, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.bvn != null) {
            aj.f(this.bvn, d.f.icon_news_head_prompt_one, i);
            aj.b(this.bvn, d.C0141d.cp_cont_i, 1, i);
        }
        int childCount = this.dnT.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.dnT.getChildAt(i2);
            if (childAt != null) {
                aj.f(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.dod != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0141d.common_color_10287);
                        } else {
                            color = aj.getColor(d.C0141d.common_color_10287);
                        }
                        aVar.dod.setForegroundColor(color);
                    }
                    if (aVar.doe != null) {
                        aj.g(aVar.doe, d.C0141d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.dnZ != null) {
            this.dnZ.setForegroundColor(aj.getColor(d.C0141d.common_color_10022));
            if (this.dnZ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dnZ.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.dnV = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axH = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aUI;

        private b(int i) {
            this.aUI = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.dnZ) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.C0141d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.dnZ != null) {
                    if (!EmotionTabHorizonScrollView.this.doa) {
                        EmotionTabHorizonScrollView.this.dnZ.setForegroundColor(aj.getColor(d.C0141d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.dnZ.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0141d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.dnZ = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aUI);
            EmotionTabHorizonScrollView.this.dnV.hT(this.aUI);
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.h(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView dod;
        View doe;
        com.baidu.tbadk.editortools.emotiontool.c dof;

        private a() {
        }
    }
}
