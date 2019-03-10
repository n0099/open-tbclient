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
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools VM;
    private int bUJ;
    private int biR;
    private LinearLayout.LayoutParams bju;
    private int clv;
    private int clw;
    private TextView clx;
    private View cly;
    private EmotionLinearLayout eAk;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAl;
    private EmotionTabWidgetView.a eAm;
    private LinearLayout eAn;
    private ImageView eAo;
    private boolean eAp;
    private TbImageView eAq;
    private boolean eAr;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.biR = -1;
        this.eAp = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.biR = -1;
        this.eAp = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.biR = -1;
        this.eAp = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.eAk = new EmotionLinearLayout(getContext());
        this.eAk.setOrientation(0);
        this.eAk.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eAk.setBaselineAligned(false);
        addView(this.eAk);
        this.clv = getResources().getDimensionPixelSize(d.e.ds8);
        this.clw = getResources().getDimensionPixelSize(d.e.ds10);
        this.bju = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.eAk.setPadding(0, 0, 0, 0);
        aVC();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.eAr = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eAl = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.eAv = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.eAt = tbImageView;
        if (cVar.amj() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.clw, this.clv, this.clw, this.clv);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.h(getContext(), d.e.ds12), l.h(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.eAu = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.eAk.addView(relativeLayout, this.eAk.getChildCount() - 1, this.bju);
            if (cVar.aml() != null) {
                cVar.aml().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.eAr && this.bUJ == 1) {
                view.setBackgroundColor(al.getColor(d.C0236d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(d.C0236d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0236d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0236d.common_color_10287));
            }
            if (this.eAq == null) {
                this.eAq = tbImageView;
                this.eAq.setForegroundColor(al.getColor(d.C0236d.common_color_10022));
            }
            al.e(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.bUJ);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.clw, this.clv, this.clw, this.clv);
            View view2 = new View(getContext());
            aVar.eAu = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.eAk.addView(linearLayout, this.eAk.getChildCount() - 1, this.bju);
            EmotionGroupType amj = cVar.amj();
            if (amj == EmotionGroupType.LOCAL) {
                if (cVar.amk() != null) {
                    cVar.amk().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eAk.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (amj == EmotionGroupType.PROMOTION) {
                if (cVar.aml() != null) {
                    cVar.aml().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (amj == EmotionGroupType.BIG_EMOTION) {
                if (this.eAp) {
                    if (cVar.amk() != null) {
                        cVar.amk().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.eAk.getChildCount() - 3));
                } else {
                    if (cVar.aml() != null) {
                        cVar.aml().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).abh();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (amj == EmotionGroupType.USER_COLLECT) {
                if (cVar.aml() != null) {
                    cVar.aml().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eAk.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (amj == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.aml() != null) {
                    cVar.aml().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.eAr && this.bUJ == 1) {
                view2.setBackgroundColor(al.getColor(d.C0236d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(d.C0236d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0236d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0236d.common_color_10287));
            }
            if (this.eAq == null) {
                this.eAq = tbImageView;
                this.eAq.setForegroundColor(al.getColor(d.C0236d.common_color_10022));
            }
            al.e(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.bUJ);
        }
        return tbImageView;
    }

    public void aVC() {
        this.eAo = new ImageView(getContext());
        this.eAo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eAo.setPadding(this.clw, this.clv, this.clw, this.clv);
        this.eAn = new LinearLayout(getContext());
        this.eAn.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.eAo.setLayoutParams(layoutParams);
        al.b(this.eAo, d.f.face_store, this.bUJ);
        this.eAn.addView(this.eAo);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.f(view, d.C0236d.common_color_10288, this.bUJ);
        this.eAn.addView(view);
        this.clx = new TextView(getContext());
        this.clx.setGravity(17);
        this.clx.setTextSize(10.0f);
        this.clx.setText("N");
        this.clx.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.eAk.addView(this.eAn, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.eAk.setNewView(this.clx);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.eAk.setNewViewVisible(true);
        } else {
            this.eAk.setNewViewVisible(false);
        }
        this.eAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.clx != null) {
                    EmotionTabHorizonScrollView.this.eAk.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.VM != null) {
                    EmotionTabHorizonScrollView.this.VM.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.kY()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.cly = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.cly.setLayoutParams(layoutParams3);
        this.eAk.addView(this.cly);
        if (!appResponseToIntentClass) {
            this.eAn.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eAp = z;
        int i2 = i + 1;
        int childCount = this.eAk.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.eAl.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.amj() == EmotionGroupType.BIG_EMOTION || cVar.amj() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.eAk.getChildAt(i2)).getChildAt(0);
                if (!this.eAp) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).abh();
                        }
                    });
                    if (cVar.aml() != null) {
                        cVar.aml().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.amk() != null) {
                    cVar.amk().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.eAk.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eAk.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).eAv;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.eAn.setVisibility(8);
        } else {
            this.eAn.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.amj() == EmotionGroupType.BIG_EMOTION || cVar.amj() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.biR) {
            if (this.biR != -1) {
                LinearLayout linearLayout = (LinearLayout) this.eAk.getChildAt(this.biR + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.bUJ == 0) {
                        color = getResources().getColor(d.C0236d.common_color_10287);
                    } else {
                        color = al.getColor(d.C0236d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.biR = i;
            LinearLayout linearLayout2 = (LinearLayout) this.eAk.getChildAt(this.biR + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eAl.get(this.biR);
            if (cVar.amk() != null) {
                cVar.amk().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(d.C0236d.common_color_10022));
                this.eAq = tbImageView2;
            }
        }
    }

    public void reset() {
        this.biR = -1;
        this.eAk.removeAllViews();
        aVC();
        ij(this.bUJ);
    }

    public void ij(int i) {
        int color;
        this.bUJ = i;
        if (this.eAo != null) {
            al.b(this.eAo, d.f.face_store, i);
        }
        if (this.eAn != null) {
            al.e(this.eAn, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.eAn.getChildCount() > 0) {
                al.f(this.eAn.getChildAt(1), d.C0236d.common_color_10288, i);
            }
        }
        if (this.cly != null) {
            al.e(this.cly, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.clx != null) {
            al.e(this.clx, d.f.icon_news_head_prompt_one, i);
            al.c(this.clx, d.C0236d.cp_btn_a, 1, i);
        }
        int childCount = this.eAk.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.eAk.getChildAt(i2);
            if (childAt != null) {
                al.e(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.eAt != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0236d.common_color_10287);
                        } else {
                            color = al.getColor(d.C0236d.common_color_10287);
                        }
                        aVar.eAt.setForegroundColor(color);
                    }
                    if (aVar.eAu != null) {
                        al.f(aVar.eAu, d.C0236d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.eAq != null) {
            this.eAq.setForegroundColor(al.getColor(d.C0236d.common_color_10022));
            if (this.eAq.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.eAq.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.eAm = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.VM = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private final int bIq;

        private b(int i) {
            this.bIq = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.eAq) {
                ((TbImageView) view).setForegroundColor(al.getColor(d.C0236d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.eAq != null) {
                    if (!EmotionTabHorizonScrollView.this.eAr) {
                        EmotionTabHorizonScrollView.this.eAq.setForegroundColor(al.getColor(d.C0236d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.eAq.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0236d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.eAq = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.bIq);
            EmotionTabHorizonScrollView.this.eAm.jH(this.bIq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
    public static class a {
        TbImageView eAt;
        View eAu;
        com.baidu.tbadk.editortools.emotiontool.c eAv;

        private a() {
        }
    }
}
