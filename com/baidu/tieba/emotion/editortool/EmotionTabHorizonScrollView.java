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
    private i Jb;
    private int aEm;
    private LinearLayout.LayoutParams aEo;
    private int aEp;
    private int aEq;
    private TextView aEr;
    private View aEs;
    private int aph;
    private com.baidu.tieba.emotion.editortool.a ciX;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ciY;
    private EmotionTabWidgetView.a ciZ;
    private LinearLayout cja;
    private ImageView cjb;
    private boolean cjc;
    private TbImageView cjd;
    private boolean cje;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEm = -1;
        this.cjc = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEm = -1;
        this.cjc = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aEm = -1;
        this.cjc = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.ciX = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.ciX.setOrientation(0);
        this.ciX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ciX.setBaselineAligned(false);
        addView(this.ciX);
        this.aEp = getResources().getDimensionPixelSize(d.e.ds8);
        this.aEq = getResources().getDimensionPixelSize(d.e.ds10);
        this.aEo = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.ciX.setPadding(0, 0, 0, 0);
        aeC();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.cje = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.ciY = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.cji = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.cjg = tbImageView;
        if (cVar.Di() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aEq, this.aEp, this.aEq, this.aEp);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.f(getContext(), d.e.ds12), l.f(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.cjh = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.ciX.addView(relativeLayout, this.ciX.getChildCount() - 1, this.aEo);
            if (cVar.Dk() != null) {
                cVar.Dk().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.cje && this.aph == 1) {
                view.setBackgroundColor(aj.getColor(d.C0080d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0080d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0080d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0080d.common_color_10287));
            }
            if (this.cjd == null) {
                this.cjd = tbImageView;
                this.cjd.setForegroundColor(aj.getColor(d.C0080d.common_color_10022));
            }
            aj.d(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.aph);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aEq, this.aEp, this.aEq, this.aEp);
            View view2 = new View(getContext());
            aVar.cjh = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.ciX.addView(linearLayout, this.ciX.getChildCount() - 1, this.aEo);
            EmotionGroupType Di = cVar.Di();
            if (Di == EmotionGroupType.LOCAL) {
                if (cVar.Dj() != null) {
                    cVar.Dj().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ciX.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (Di == EmotionGroupType.PROMOTION) {
                if (cVar.Dk() != null) {
                    cVar.Dk().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (Di == EmotionGroupType.BIG_EMOTION) {
                if (this.cjc) {
                    if (cVar.Dj() != null) {
                        cVar.Dj().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.ciX.getChildCount() - 3));
                } else {
                    if (cVar.Dk() != null) {
                        cVar.Dk().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).tq();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Di == EmotionGroupType.USER_COLLECT) {
                if (cVar.Dk() != null) {
                    cVar.Dk().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ciX.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Di == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Dk() != null) {
                    cVar.Dk().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.cje && this.aph == 1) {
                view2.setBackgroundColor(aj.getColor(d.C0080d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0080d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0080d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0080d.common_color_10287));
            }
            if (this.cjd == null) {
                this.cjd = tbImageView;
                this.cjd.setForegroundColor(aj.getColor(d.C0080d.common_color_10022));
            }
            aj.d(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.aph);
        }
        return tbImageView;
    }

    public void aeC() {
        this.cjb = new ImageView(getContext());
        this.cjb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cjb.setPadding(this.aEq, this.aEp, this.aEq, this.aEp);
        this.cja = new LinearLayout(getContext());
        this.cja.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cjb.setLayoutParams(layoutParams);
        aj.b(this.cjb, d.f.face_store, this.aph);
        this.cja.addView(this.cjb);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.e(view, d.C0080d.common_color_10288, this.aph);
        this.cja.addView(view);
        this.aEr = new TextView(getContext());
        this.aEr.setGravity(17);
        this.aEr.setTextSize(10.0f);
        this.aEr.setText("N");
        this.aEr.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.ciX.addView(this.cja, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.ciX.setNewView(this.aEr);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.ciX.setNewViewVisible(true);
        } else {
            this.ciX.setNewViewVisible(false);
        }
        this.cja.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aEr != null) {
                    EmotionTabHorizonScrollView.this.ciX.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Jb != null) {
                    EmotionTabHorizonScrollView.this.Jb.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.hh()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.aEs = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aEs.setLayoutParams(layoutParams3);
        this.ciX.addView(this.aEs);
        if (!appResponseToIntentClass) {
            this.cja.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void m(int i, boolean z) {
        this.cjc = z;
        int i2 = i + 1;
        int childCount = this.ciX.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.ciY.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Di() == EmotionGroupType.BIG_EMOTION || cVar.Di() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.ciX.getChildAt(i2)).getChildAt(0);
                if (!this.cjc) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).tq();
                        }
                    });
                    if (cVar.Dk() != null) {
                        cVar.Dk().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Dj() != null) {
                    cVar.Dj().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.ciX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ciX.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).cji;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.cja.setVisibility(8);
        } else {
            this.cja.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Di() == EmotionGroupType.BIG_EMOTION || cVar.Di() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aEm) {
            if (this.aEm != -1) {
                LinearLayout linearLayout = (LinearLayout) this.ciX.getChildAt(this.aEm + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aph == 0) {
                        color = getResources().getColor(d.C0080d.common_color_10287);
                    } else {
                        color = aj.getColor(d.C0080d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aEm = i;
            LinearLayout linearLayout2 = (LinearLayout) this.ciX.getChildAt(this.aEm + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ciY.get(this.aEm);
            if (cVar.Dj() != null) {
                cVar.Dj().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.C0080d.common_color_10022));
                this.cjd = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aEm = -1;
        this.ciX.removeAllViews();
        aeC();
        dD(this.aph);
    }

    public void dD(int i) {
        int color;
        this.aph = i;
        if (this.cjb != null) {
            aj.b(this.cjb, d.f.face_store, i);
        }
        if (this.cja != null) {
            aj.d(this.cja, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.cja.getChildCount() > 0) {
                aj.e(this.cja.getChildAt(1), d.C0080d.common_color_10288, i);
            }
        }
        if (this.aEs != null) {
            aj.d(this.aEs, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aEr != null) {
            aj.d(this.aEr, d.f.icon_news_head_prompt_one, i);
            aj.b(this.aEr, d.C0080d.cp_cont_i, 1, i);
        }
        int childCount = this.ciX.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.ciX.getChildAt(i2);
            if (childAt != null) {
                aj.d(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.cjg != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0080d.common_color_10287);
                        } else {
                            color = aj.getColor(d.C0080d.common_color_10287);
                        }
                        aVar.cjg.setForegroundColor(color);
                    }
                    if (aVar.cjh != null) {
                        aj.e(aVar.cjh, d.C0080d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.cjd != null) {
            this.cjd.setForegroundColor(aj.getColor(d.C0080d.common_color_10022));
            if (this.cjd.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cjd.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.ciZ = aVar;
    }

    public void setEditorTools(i iVar) {
        this.Jb = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aeH;

        private b(int i) {
            this.aeH = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.cjd) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.C0080d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.cjd != null) {
                    if (!EmotionTabHorizonScrollView.this.cje) {
                        EmotionTabHorizonScrollView.this.cjd.setForegroundColor(aj.getColor(d.C0080d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.cjd.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0080d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.cjd = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aeH);
            EmotionTabHorizonScrollView.this.ciZ.fc(this.aeH);
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
        TbImageView cjg;
        View cjh;
        com.baidu.tbadk.editortools.emotiontool.c cji;

        private a() {
        }
    }
}
