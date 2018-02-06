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
    private i axP;
    private int bfL;
    private int bvs;
    private LinearLayout.LayoutParams bvu;
    private int bvv;
    private int bvw;
    private TextView bvx;
    private View bvy;
    private com.baidu.tieba.emotion.editortool.a dod;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> doe;
    private EmotionTabWidgetView.a dof;
    private LinearLayout dog;
    private ImageView doh;
    private boolean doi;
    private TbImageView doj;
    private boolean dok;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvs = -1;
        this.doi = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvs = -1;
        this.doi = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bvs = -1;
        this.doi = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.dod = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.dod.setOrientation(0);
        this.dod.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dod.setBaselineAligned(false);
        addView(this.dod);
        this.bvv = getResources().getDimensionPixelSize(d.e.ds8);
        this.bvw = getResources().getDimensionPixelSize(d.e.ds10);
        this.bvu = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.dod.setPadding(0, 0, 0, 0);
        apT();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.dok = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.doe = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.doo = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.dom = tbImageView;
        if (cVar.Lr() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.bvw, this.bvv, this.bvw, this.bvv);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.t(getContext(), d.e.ds12), l.t(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.don = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.dod.addView(relativeLayout, this.dod.getChildCount() - 1, this.bvu);
            if (cVar.Lt() != null) {
                cVar.Lt().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.dok && this.bfL == 1) {
                view.setBackgroundColor(aj.getColor(d.C0140d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0140d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0140d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0140d.common_color_10287));
            }
            if (this.doj == null) {
                this.doj = tbImageView;
                this.doj.setForegroundColor(aj.getColor(d.C0140d.common_color_10022));
            }
            aj.f(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.bfL);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.bvw, this.bvv, this.bvw, this.bvv);
            View view2 = new View(getContext());
            aVar.don = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.dod.addView(linearLayout, this.dod.getChildCount() - 1, this.bvu);
            EmotionGroupType Lr = cVar.Lr();
            if (Lr == EmotionGroupType.LOCAL) {
                if (cVar.Ls() != null) {
                    cVar.Ls().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dod.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (Lr == EmotionGroupType.PROMOTION) {
                if (cVar.Lt() != null) {
                    cVar.Lt().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (Lr == EmotionGroupType.BIG_EMOTION) {
                if (this.doi) {
                    if (cVar.Ls() != null) {
                        cVar.Ls().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.dod.getChildCount() - 3));
                } else {
                    if (cVar.Lt() != null) {
                        cVar.Lt().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).Bc();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Lr == EmotionGroupType.USER_COLLECT) {
                if (cVar.Lt() != null) {
                    cVar.Lt().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dod.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Lr == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Lt() != null) {
                    cVar.Lt().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.dok && this.bfL == 1) {
                view2.setBackgroundColor(aj.getColor(d.C0140d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0140d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0140d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0140d.common_color_10287));
            }
            if (this.doj == null) {
                this.doj = tbImageView;
                this.doj.setForegroundColor(aj.getColor(d.C0140d.common_color_10022));
            }
            aj.f(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.bfL);
        }
        return tbImageView;
    }

    public void apT() {
        this.doh = new ImageView(getContext());
        this.doh.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.doh.setPadding(this.bvw, this.bvv, this.bvw, this.bvv);
        this.dog = new LinearLayout(getContext());
        this.dog.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.doh.setLayoutParams(layoutParams);
        aj.b(this.doh, d.f.face_store, this.bfL);
        this.dog.addView(this.doh);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.g(view, d.C0140d.common_color_10288, this.bfL);
        this.dog.addView(view);
        this.bvx = new TextView(getContext());
        this.bvx.setGravity(17);
        this.bvx.setTextSize(10.0f);
        this.bvx.setText("N");
        this.bvx.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dod.addView(this.dog, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.dod.setNewView(this.bvx);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.dod.setNewViewVisible(true);
        } else {
            this.dod.setNewViewVisible(false);
        }
        this.dog.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.bvx != null) {
                    EmotionTabHorizonScrollView.this.dod.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.axP != null) {
                    EmotionTabHorizonScrollView.this.axP.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.oJ()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.bvy = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.bvy.setLayoutParams(layoutParams3);
        this.dod.addView(this.bvy);
        if (!appResponseToIntentClass) {
            this.dog.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void C(int i, boolean z) {
        this.doi = z;
        int i2 = i + 1;
        int childCount = this.dod.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.doe.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Lr() == EmotionGroupType.BIG_EMOTION || cVar.Lr() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.dod.getChildAt(i2)).getChildAt(0);
                if (!this.doi) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).Bc();
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
        int childCount = this.dod.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dod.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).doo;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.dog.setVisibility(8);
        } else {
            this.dog.setVisibility(0);
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
        if (i != this.bvs) {
            if (this.bvs != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dod.getChildAt(this.bvs + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.bfL == 0) {
                        color = getResources().getColor(d.C0140d.common_color_10287);
                    } else {
                        color = aj.getColor(d.C0140d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bvs = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dod.getChildAt(this.bvs + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.doe.get(this.bvs);
            if (cVar.Ls() != null) {
                cVar.Ls().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.C0140d.common_color_10022));
                this.doj = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bvs = -1;
        this.dod.removeAllViews();
        apT();
        gB(this.bfL);
    }

    public void gB(int i) {
        int color;
        this.bfL = i;
        if (this.doh != null) {
            aj.b(this.doh, d.f.face_store, i);
        }
        if (this.dog != null) {
            aj.f(this.dog, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.dog.getChildCount() > 0) {
                aj.g(this.dog.getChildAt(1), d.C0140d.common_color_10288, i);
            }
        }
        if (this.bvy != null) {
            aj.f(this.bvy, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.bvx != null) {
            aj.f(this.bvx, d.f.icon_news_head_prompt_one, i);
            aj.b(this.bvx, d.C0140d.cp_cont_i, 1, i);
        }
        int childCount = this.dod.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.dod.getChildAt(i2);
            if (childAt != null) {
                aj.f(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.dom != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0140d.common_color_10287);
                        } else {
                            color = aj.getColor(d.C0140d.common_color_10287);
                        }
                        aVar.dom.setForegroundColor(color);
                    }
                    if (aVar.don != null) {
                        aj.g(aVar.don, d.C0140d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.doj != null) {
            this.doj.setForegroundColor(aj.getColor(d.C0140d.common_color_10022));
            if (this.doj.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.doj.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.dof = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axP = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aUS;

        private b(int i) {
            this.aUS = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.doj) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.C0140d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.doj != null) {
                    if (!EmotionTabHorizonScrollView.this.dok) {
                        EmotionTabHorizonScrollView.this.doj.setForegroundColor(aj.getColor(d.C0140d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.doj.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0140d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.doj = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aUS);
            EmotionTabHorizonScrollView.this.dof.hT(this.aUS);
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
        TbImageView dom;
        View don;
        com.baidu.tbadk.editortools.emotiontool.c doo;

        private a() {
        }
    }
}
