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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools Qj;
    private int aOZ;
    private LinearLayout.LayoutParams aPb;
    private int aPc;
    private int aPd;
    private TextView aPe;
    private View aPf;
    private int azP;
    private EmotionLinearLayout cOh;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cOi;
    private EmotionTabWidgetView.a cOj;
    private LinearLayout cOk;
    private ImageView cOl;
    private boolean cOm;
    private TbImageView cOn;
    private boolean cOo;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOZ = -1;
        this.cOm = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOZ = -1;
        this.cOm = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aOZ = -1;
        this.cOm = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cOh = new EmotionLinearLayout(getContext());
        this.cOh.setOrientation(0);
        this.cOh.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cOh.setBaselineAligned(false);
        addView(this.cOh);
        this.aPc = getResources().getDimensionPixelSize(d.e.ds8);
        this.aPd = getResources().getDimensionPixelSize(d.e.ds10);
        this.aPb = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.cOh.setPadding(0, 0, 0, 0);
        anB();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.cOo = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cOi = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.cOs = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.cOq = tbImageView;
        if (cVar.HN() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aPd, this.aPc, this.aPd, this.aPc);
            ImageView imageView = new ImageView(getContext());
            am.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.e(getContext(), d.e.ds12), l.e(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.cOr = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.cOh.addView(relativeLayout, this.cOh.getChildCount() - 1, this.aPb);
            if (cVar.HP() != null) {
                cVar.HP().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.cOo && this.azP == 1) {
                view.setBackgroundColor(am.getColor(d.C0142d.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(d.C0142d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0142d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0142d.common_color_10287));
            }
            if (this.cOn == null) {
                this.cOn = tbImageView;
                this.cOn.setForegroundColor(am.getColor(d.C0142d.common_color_10022));
            }
            am.d(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.azP);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aPd, this.aPc, this.aPd, this.aPc);
            View view2 = new View(getContext());
            aVar.cOr = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.cOh.addView(linearLayout, this.cOh.getChildCount() - 1, this.aPb);
            EmotionGroupType HN = cVar.HN();
            if (HN == EmotionGroupType.LOCAL) {
                if (cVar.HO() != null) {
                    cVar.HO().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cOh.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.local_emotion));
            } else if (HN == EmotionGroupType.PROMOTION) {
                if (cVar.HP() != null) {
                    cVar.HP().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.download_promotion_emotion) + cVar.getGroupId());
            } else if (HN == EmotionGroupType.BIG_EMOTION) {
                if (this.cOm) {
                    if (cVar.HO() != null) {
                        cVar.HO().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.cOh.getChildCount() - 3));
                } else {
                    if (cVar.HP() != null) {
                        cVar.HP().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.k.emotion_cant_show)).xv();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (HN == EmotionGroupType.USER_COLLECT) {
                if (cVar.HP() != null) {
                    cVar.HP().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cOh.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (HN == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.HP() != null) {
                    cVar.HP().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.cOo && this.azP == 1) {
                view2.setBackgroundColor(am.getColor(d.C0142d.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(d.C0142d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0142d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0142d.common_color_10287));
            }
            if (this.cOn == null) {
                this.cOn = tbImageView;
                this.cOn.setForegroundColor(am.getColor(d.C0142d.common_color_10022));
            }
            am.d(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.azP);
        }
        return tbImageView;
    }

    public void anB() {
        this.cOl = new ImageView(getContext());
        this.cOl.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cOl.setPadding(this.aPd, this.aPc, this.aPd, this.aPc);
        this.cOk = new LinearLayout(getContext());
        this.cOk.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cOl.setLayoutParams(layoutParams);
        am.b(this.cOl, d.f.face_store, this.azP);
        this.cOk.addView(this.cOl);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.e(view, d.C0142d.common_color_10288, this.azP);
        this.cOk.addView(view);
        this.aPe = new TextView(getContext());
        this.aPe.setGravity(17);
        this.aPe.setTextSize(10.0f);
        this.aPe.setText("N");
        this.aPe.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cOh.addView(this.cOk, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.cOh.setNewView(this.aPe);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.cOh.setNewViewVisible(true);
        } else {
            this.cOh.setNewViewVisible(false);
        }
        this.cOk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aPe != null) {
                    EmotionTabHorizonScrollView.this.cOh.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Qj != null) {
                    EmotionTabHorizonScrollView.this.Qj.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.jD()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.k.neterror);
                }
            }
        });
        this.aPf = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aPf.setLayoutParams(layoutParams3);
        this.cOh.addView(this.aPf);
        if (!appResponseToIntentClass) {
            this.cOk.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cOm = z;
        int i2 = i + 1;
        int childCount = this.cOh.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.cOi.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.HN() == EmotionGroupType.BIG_EMOTION || cVar.HN() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.cOh.getChildAt(i2)).getChildAt(0);
                if (!this.cOm) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.k.emotion_cant_show)).xv();
                        }
                    });
                    if (cVar.HP() != null) {
                        cVar.HP().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.HO() != null) {
                    cVar.HO().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.cOh.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cOh.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).cOs;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.cOk.setVisibility(8);
        } else {
            this.cOk.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.HN() == EmotionGroupType.BIG_EMOTION || cVar.HN() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aOZ) {
            if (this.aOZ != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cOh.getChildAt(this.aOZ + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.azP == 0) {
                        color = getResources().getColor(d.C0142d.common_color_10287);
                    } else {
                        color = am.getColor(d.C0142d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aOZ = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cOh.getChildAt(this.aOZ + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cOi.get(this.aOZ);
            if (cVar.HO() != null) {
                cVar.HO().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(d.C0142d.common_color_10022));
                this.cOn = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aOZ = -1;
        this.cOh.removeAllViews();
        anB();
        dD(this.azP);
    }

    public void dD(int i) {
        int color;
        this.azP = i;
        if (this.cOl != null) {
            am.b(this.cOl, d.f.face_store, i);
        }
        if (this.cOk != null) {
            am.d(this.cOk, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.cOk.getChildCount() > 0) {
                am.e(this.cOk.getChildAt(1), d.C0142d.common_color_10288, i);
            }
        }
        if (this.aPf != null) {
            am.d(this.aPf, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aPe != null) {
            am.d(this.aPe, d.f.icon_news_head_prompt_one, i);
            am.b(this.aPe, d.C0142d.cp_cont_i, 1, i);
        }
        int childCount = this.cOh.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.cOh.getChildAt(i2);
            if (childAt != null) {
                am.d(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.cOq != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0142d.common_color_10287);
                        } else {
                            color = am.getColor(d.C0142d.common_color_10287);
                        }
                        aVar.cOq.setForegroundColor(color);
                    }
                    if (aVar.cOr != null) {
                        am.e(aVar.cOr, d.C0142d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.cOn != null) {
            this.cOn.setForegroundColor(am.getColor(d.C0142d.common_color_10022));
            if (this.cOn.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cOn.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.cOj = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Qj = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aoG;

        private b(int i) {
            this.aoG = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.cOn) {
                ((TbImageView) view).setForegroundColor(am.getColor(d.C0142d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.cOn != null) {
                    if (!EmotionTabHorizonScrollView.this.cOo) {
                        EmotionTabHorizonScrollView.this.cOn.setForegroundColor(am.getColor(d.C0142d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.cOn.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0142d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.cOn = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aoG);
            EmotionTabHorizonScrollView.this.cOj.eY(this.aoG);
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.g(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView cOq;
        View cOr;
        com.baidu.tbadk.editortools.emotiontool.c cOs;

        private a() {
        }
    }
}
