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
    private EditorTools VN;
    private int bUM;
    private int biV;
    private LinearLayout.LayoutParams bjy;
    private View clA;
    private int clx;
    private int cly;
    private TextView clz;
    private EmotionLinearLayout ezR;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ezS;
    private EmotionTabWidgetView.a ezT;
    private LinearLayout ezU;
    private ImageView ezV;
    private boolean ezW;
    private TbImageView ezX;
    private boolean ezY;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.biV = -1;
        this.ezW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.biV = -1;
        this.ezW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.biV = -1;
        this.ezW = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.ezR = new EmotionLinearLayout(getContext());
        this.ezR.setOrientation(0);
        this.ezR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ezR.setBaselineAligned(false);
        addView(this.ezR);
        this.clx = getResources().getDimensionPixelSize(d.e.ds8);
        this.cly = getResources().getDimensionPixelSize(d.e.ds10);
        this.bjy = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.ezR.setPadding(0, 0, 0, 0);
        aVz();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.ezY = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.ezS = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.eAc = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.eAa = tbImageView;
        if (cVar.amf() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.cly, this.clx, this.cly, this.clx);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.h(getContext(), d.e.ds12), l.h(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.eAb = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.ezR.addView(relativeLayout, this.ezR.getChildCount() - 1, this.bjy);
            if (cVar.amh() != null) {
                cVar.amh().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.ezY && this.bUM == 1) {
                view.setBackgroundColor(al.getColor(d.C0277d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(d.C0277d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0277d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0277d.common_color_10287));
            }
            if (this.ezX == null) {
                this.ezX = tbImageView;
                this.ezX.setForegroundColor(al.getColor(d.C0277d.common_color_10022));
            }
            al.e(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.bUM);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.cly, this.clx, this.cly, this.clx);
            View view2 = new View(getContext());
            aVar.eAb = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.ezR.addView(linearLayout, this.ezR.getChildCount() - 1, this.bjy);
            EmotionGroupType amf = cVar.amf();
            if (amf == EmotionGroupType.LOCAL) {
                if (cVar.amg() != null) {
                    cVar.amg().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ezR.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (amf == EmotionGroupType.PROMOTION) {
                if (cVar.amh() != null) {
                    cVar.amh().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (amf == EmotionGroupType.BIG_EMOTION) {
                if (this.ezW) {
                    if (cVar.amg() != null) {
                        cVar.amg().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.ezR.getChildCount() - 3));
                } else {
                    if (cVar.amh() != null) {
                        cVar.amh().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).abe();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (amf == EmotionGroupType.USER_COLLECT) {
                if (cVar.amh() != null) {
                    cVar.amh().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ezR.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (amf == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.amh() != null) {
                    cVar.amh().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.ezY && this.bUM == 1) {
                view2.setBackgroundColor(al.getColor(d.C0277d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(d.C0277d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0277d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0277d.common_color_10287));
            }
            if (this.ezX == null) {
                this.ezX = tbImageView;
                this.ezX.setForegroundColor(al.getColor(d.C0277d.common_color_10022));
            }
            al.e(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.bUM);
        }
        return tbImageView;
    }

    public void aVz() {
        this.ezV = new ImageView(getContext());
        this.ezV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ezV.setPadding(this.cly, this.clx, this.cly, this.clx);
        this.ezU = new LinearLayout(getContext());
        this.ezU.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.ezV.setLayoutParams(layoutParams);
        al.b(this.ezV, d.f.face_store, this.bUM);
        this.ezU.addView(this.ezV);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.f(view, d.C0277d.common_color_10288, this.bUM);
        this.ezU.addView(view);
        this.clz = new TextView(getContext());
        this.clz.setGravity(17);
        this.clz.setTextSize(10.0f);
        this.clz.setText("N");
        this.clz.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.ezR.addView(this.ezU, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.ezR.setNewView(this.clz);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.ezR.setNewViewVisible(true);
        } else {
            this.ezR.setNewViewVisible(false);
        }
        this.ezU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.clz != null) {
                    EmotionTabHorizonScrollView.this.ezR.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.VN != null) {
                    EmotionTabHorizonScrollView.this.VN.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.kY()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.clA = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.clA.setLayoutParams(layoutParams3);
        this.ezR.addView(this.clA);
        if (!appResponseToIntentClass) {
            this.ezU.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.ezW = z;
        int i2 = i + 1;
        int childCount = this.ezR.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.ezS.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.amf() == EmotionGroupType.BIG_EMOTION || cVar.amf() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.ezR.getChildAt(i2)).getChildAt(0);
                if (!this.ezW) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).abe();
                        }
                    });
                    if (cVar.amh() != null) {
                        cVar.amh().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.amg() != null) {
                    cVar.amg().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.ezR.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ezR.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).eAc;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.ezU.setVisibility(8);
        } else {
            this.ezU.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.amf() == EmotionGroupType.BIG_EMOTION || cVar.amf() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.biV) {
            if (this.biV != -1) {
                LinearLayout linearLayout = (LinearLayout) this.ezR.getChildAt(this.biV + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.bUM == 0) {
                        color = getResources().getColor(d.C0277d.common_color_10287);
                    } else {
                        color = al.getColor(d.C0277d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.biV = i;
            LinearLayout linearLayout2 = (LinearLayout) this.ezR.getChildAt(this.biV + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ezS.get(this.biV);
            if (cVar.amg() != null) {
                cVar.amg().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(d.C0277d.common_color_10022));
                this.ezX = tbImageView2;
            }
        }
    }

    public void reset() {
        this.biV = -1;
        this.ezR.removeAllViews();
        aVz();
        ii(this.bUM);
    }

    public void ii(int i) {
        int color;
        this.bUM = i;
        if (this.ezV != null) {
            al.b(this.ezV, d.f.face_store, i);
        }
        if (this.ezU != null) {
            al.e(this.ezU, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.ezU.getChildCount() > 0) {
                al.f(this.ezU.getChildAt(1), d.C0277d.common_color_10288, i);
            }
        }
        if (this.clA != null) {
            al.e(this.clA, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.clz != null) {
            al.e(this.clz, d.f.icon_news_head_prompt_one, i);
            al.c(this.clz, d.C0277d.cp_btn_a, 1, i);
        }
        int childCount = this.ezR.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.ezR.getChildAt(i2);
            if (childAt != null) {
                al.e(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.eAa != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0277d.common_color_10287);
                        } else {
                            color = al.getColor(d.C0277d.common_color_10287);
                        }
                        aVar.eAa.setForegroundColor(color);
                    }
                    if (aVar.eAb != null) {
                        al.f(aVar.eAb, d.C0277d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.ezX != null) {
            this.ezX.setForegroundColor(al.getColor(d.C0277d.common_color_10022));
            if (this.ezX.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ezX.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.ezT = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private final int bIt;

        private b(int i) {
            this.bIt = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.ezX) {
                ((TbImageView) view).setForegroundColor(al.getColor(d.C0277d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.ezX != null) {
                    if (!EmotionTabHorizonScrollView.this.ezY) {
                        EmotionTabHorizonScrollView.this.ezX.setForegroundColor(al.getColor(d.C0277d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.ezX.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0277d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.ezX = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.bIt);
            EmotionTabHorizonScrollView.this.ezT.jG(this.bIt);
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
        TbImageView eAa;
        View eAb;
        com.baidu.tbadk.editortools.emotiontool.c eAc;

        private a() {
        }
    }
}
