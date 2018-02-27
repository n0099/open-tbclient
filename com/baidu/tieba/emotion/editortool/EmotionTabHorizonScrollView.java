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
    private i axG;
    private int bfz;
    private int bvf;
    private LinearLayout.LayoutParams bvh;
    private int bvi;
    private int bvj;
    private TextView bvk;
    private View bvl;
    private com.baidu.tieba.emotion.editortool.a dnQ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dnR;
    private EmotionTabWidgetView.a dnS;
    private LinearLayout dnT;
    private ImageView dnU;
    private boolean dnV;
    private TbImageView dnW;
    private boolean dnX;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvf = -1;
        this.dnV = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvf = -1;
        this.dnV = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bvf = -1;
        this.dnV = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.dnQ = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.dnQ.setOrientation(0);
        this.dnQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dnQ.setBaselineAligned(false);
        addView(this.dnQ);
        this.bvi = getResources().getDimensionPixelSize(d.e.ds8);
        this.bvj = getResources().getDimensionPixelSize(d.e.ds10);
        this.bvh = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.dnQ.setPadding(0, 0, 0, 0);
        apS();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.dnX = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dnR = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.dob = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.dnZ = tbImageView;
        if (cVar.Lq() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.bvj, this.bvi, this.bvj, this.bvi);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.t(getContext(), d.e.ds12), l.t(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.doa = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.dnQ.addView(relativeLayout, this.dnQ.getChildCount() - 1, this.bvh);
            if (cVar.Ls() != null) {
                cVar.Ls().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.dnX && this.bfz == 1) {
                view.setBackgroundColor(aj.getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0141d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0141d.common_color_10287));
            }
            if (this.dnW == null) {
                this.dnW = tbImageView;
                this.dnW.setForegroundColor(aj.getColor(d.C0141d.common_color_10022));
            }
            aj.f(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.bfz);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.bvj, this.bvi, this.bvj, this.bvi);
            View view2 = new View(getContext());
            aVar.doa = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.dnQ.addView(linearLayout, this.dnQ.getChildCount() - 1, this.bvh);
            EmotionGroupType Lq = cVar.Lq();
            if (Lq == EmotionGroupType.LOCAL) {
                if (cVar.Lr() != null) {
                    cVar.Lr().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dnQ.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (Lq == EmotionGroupType.PROMOTION) {
                if (cVar.Ls() != null) {
                    cVar.Ls().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (Lq == EmotionGroupType.BIG_EMOTION) {
                if (this.dnV) {
                    if (cVar.Lr() != null) {
                        cVar.Lr().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.dnQ.getChildCount() - 3));
                } else {
                    if (cVar.Ls() != null) {
                        cVar.Ls().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).Bc();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Lq == EmotionGroupType.USER_COLLECT) {
                if (cVar.Ls() != null) {
                    cVar.Ls().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dnQ.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Lq == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Ls() != null) {
                    cVar.Ls().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.dnX && this.bfz == 1) {
                view2.setBackgroundColor(aj.getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0141d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0141d.common_color_10287));
            }
            if (this.dnW == null) {
                this.dnW = tbImageView;
                this.dnW.setForegroundColor(aj.getColor(d.C0141d.common_color_10022));
            }
            aj.f(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.bfz);
        }
        return tbImageView;
    }

    public void apS() {
        this.dnU = new ImageView(getContext());
        this.dnU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dnU.setPadding(this.bvj, this.bvi, this.bvj, this.bvi);
        this.dnT = new LinearLayout(getContext());
        this.dnT.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dnU.setLayoutParams(layoutParams);
        aj.b(this.dnU, d.f.face_store, this.bfz);
        this.dnT.addView(this.dnU);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.g(view, d.C0141d.common_color_10288, this.bfz);
        this.dnT.addView(view);
        this.bvk = new TextView(getContext());
        this.bvk.setGravity(17);
        this.bvk.setTextSize(10.0f);
        this.bvk.setText("N");
        this.bvk.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dnQ.addView(this.dnT, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.dnQ.setNewView(this.bvk);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.dnQ.setNewViewVisible(true);
        } else {
            this.dnQ.setNewViewVisible(false);
        }
        this.dnT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.bvk != null) {
                    EmotionTabHorizonScrollView.this.dnQ.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.axG != null) {
                    EmotionTabHorizonScrollView.this.axG.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.oJ()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.bvl = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.bvl.setLayoutParams(layoutParams3);
        this.dnQ.addView(this.bvl);
        if (!appResponseToIntentClass) {
            this.dnT.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void C(int i, boolean z) {
        this.dnV = z;
        int i2 = i + 1;
        int childCount = this.dnQ.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.dnR.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Lq() == EmotionGroupType.BIG_EMOTION || cVar.Lq() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.dnQ.getChildAt(i2)).getChildAt(0);
                if (!this.dnV) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).Bc();
                        }
                    });
                    if (cVar.Ls() != null) {
                        cVar.Ls().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Lr() != null) {
                    cVar.Lr().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.dnQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dnQ.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).dob;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.dnT.setVisibility(8);
        } else {
            this.dnT.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Lq() == EmotionGroupType.BIG_EMOTION || cVar.Lq() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.bvf) {
            if (this.bvf != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dnQ.getChildAt(this.bvf + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.bfz == 0) {
                        color = getResources().getColor(d.C0141d.common_color_10287);
                    } else {
                        color = aj.getColor(d.C0141d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bvf = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dnQ.getChildAt(this.bvf + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dnR.get(this.bvf);
            if (cVar.Lr() != null) {
                cVar.Lr().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.C0141d.common_color_10022));
                this.dnW = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bvf = -1;
        this.dnQ.removeAllViews();
        apS();
        gB(this.bfz);
    }

    public void gB(int i) {
        int color;
        this.bfz = i;
        if (this.dnU != null) {
            aj.b(this.dnU, d.f.face_store, i);
        }
        if (this.dnT != null) {
            aj.f(this.dnT, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.dnT.getChildCount() > 0) {
                aj.g(this.dnT.getChildAt(1), d.C0141d.common_color_10288, i);
            }
        }
        if (this.bvl != null) {
            aj.f(this.bvl, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.bvk != null) {
            aj.f(this.bvk, d.f.icon_news_head_prompt_one, i);
            aj.b(this.bvk, d.C0141d.cp_cont_i, 1, i);
        }
        int childCount = this.dnQ.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.dnQ.getChildAt(i2);
            if (childAt != null) {
                aj.f(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.dnZ != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0141d.common_color_10287);
                        } else {
                            color = aj.getColor(d.C0141d.common_color_10287);
                        }
                        aVar.dnZ.setForegroundColor(color);
                    }
                    if (aVar.doa != null) {
                        aj.g(aVar.doa, d.C0141d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.dnW != null) {
            this.dnW.setForegroundColor(aj.getColor(d.C0141d.common_color_10022));
            if (this.dnW.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dnW.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.dnS = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axG = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aUG;

        private b(int i) {
            this.aUG = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.dnW) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.C0141d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.dnW != null) {
                    if (!EmotionTabHorizonScrollView.this.dnX) {
                        EmotionTabHorizonScrollView.this.dnW.setForegroundColor(aj.getColor(d.C0141d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.dnW.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0141d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.dnW = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aUG);
            EmotionTabHorizonScrollView.this.dnS.hT(this.aUG);
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
        TbImageView dnZ;
        View doa;
        com.baidu.tbadk.editortools.emotiontool.c dob;

        private a() {
        }
    }
}
