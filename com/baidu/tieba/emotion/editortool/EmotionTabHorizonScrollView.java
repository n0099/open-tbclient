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
    private EditorTools VO;
    private int bUN;
    private int biW;
    private LinearLayout.LayoutParams bjz;
    private TextView clA;
    private View clB;
    private int cly;
    private int clz;
    private EmotionLinearLayout ezS;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ezT;
    private EmotionTabWidgetView.a ezU;
    private LinearLayout ezV;
    private ImageView ezW;
    private boolean ezX;
    private TbImageView ezY;
    private boolean ezZ;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.biW = -1;
        this.ezX = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.biW = -1;
        this.ezX = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.biW = -1;
        this.ezX = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.ezS = new EmotionLinearLayout(getContext());
        this.ezS.setOrientation(0);
        this.ezS.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ezS.setBaselineAligned(false);
        addView(this.ezS);
        this.cly = getResources().getDimensionPixelSize(d.e.ds8);
        this.clz = getResources().getDimensionPixelSize(d.e.ds10);
        this.bjz = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.ezS.setPadding(0, 0, 0, 0);
        aVz();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.ezZ = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.ezT = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.eAd = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.eAb = tbImageView;
        if (cVar.amf() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.clz, this.cly, this.clz, this.cly);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.h(getContext(), d.e.ds12), l.h(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.eAc = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.ezS.addView(relativeLayout, this.ezS.getChildCount() - 1, this.bjz);
            if (cVar.amh() != null) {
                cVar.amh().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.ezZ && this.bUN == 1) {
                view.setBackgroundColor(al.getColor(d.C0277d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(d.C0277d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0277d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0277d.common_color_10287));
            }
            if (this.ezY == null) {
                this.ezY = tbImageView;
                this.ezY.setForegroundColor(al.getColor(d.C0277d.common_color_10022));
            }
            al.e(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.bUN);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.clz, this.cly, this.clz, this.cly);
            View view2 = new View(getContext());
            aVar.eAc = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.ezS.addView(linearLayout, this.ezS.getChildCount() - 1, this.bjz);
            EmotionGroupType amf = cVar.amf();
            if (amf == EmotionGroupType.LOCAL) {
                if (cVar.amg() != null) {
                    cVar.amg().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ezS.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (amf == EmotionGroupType.PROMOTION) {
                if (cVar.amh() != null) {
                    cVar.amh().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (amf == EmotionGroupType.BIG_EMOTION) {
                if (this.ezX) {
                    if (cVar.amg() != null) {
                        cVar.amg().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.ezS.getChildCount() - 3));
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
                tbImageView.setOnClickListener(new b(this.ezS.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (amf == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.amh() != null) {
                    cVar.amh().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.ezZ && this.bUN == 1) {
                view2.setBackgroundColor(al.getColor(d.C0277d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(d.C0277d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0277d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0277d.common_color_10287));
            }
            if (this.ezY == null) {
                this.ezY = tbImageView;
                this.ezY.setForegroundColor(al.getColor(d.C0277d.common_color_10022));
            }
            al.e(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.bUN);
        }
        return tbImageView;
    }

    public void aVz() {
        this.ezW = new ImageView(getContext());
        this.ezW.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ezW.setPadding(this.clz, this.cly, this.clz, this.cly);
        this.ezV = new LinearLayout(getContext());
        this.ezV.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.ezW.setLayoutParams(layoutParams);
        al.b(this.ezW, d.f.face_store, this.bUN);
        this.ezV.addView(this.ezW);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.f(view, d.C0277d.common_color_10288, this.bUN);
        this.ezV.addView(view);
        this.clA = new TextView(getContext());
        this.clA.setGravity(17);
        this.clA.setTextSize(10.0f);
        this.clA.setText("N");
        this.clA.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.ezS.addView(this.ezV, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.ezS.setNewView(this.clA);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.ezS.setNewViewVisible(true);
        } else {
            this.ezS.setNewViewVisible(false);
        }
        this.ezV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.clA != null) {
                    EmotionTabHorizonScrollView.this.ezS.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.VO != null) {
                    EmotionTabHorizonScrollView.this.VO.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.kY()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.clB = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.clB.setLayoutParams(layoutParams3);
        this.ezS.addView(this.clB);
        if (!appResponseToIntentClass) {
            this.ezV.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.ezX = z;
        int i2 = i + 1;
        int childCount = this.ezS.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.ezT.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.amf() == EmotionGroupType.BIG_EMOTION || cVar.amf() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.ezS.getChildAt(i2)).getChildAt(0);
                if (!this.ezX) {
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
        int childCount = this.ezS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ezS.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).eAd;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.ezV.setVisibility(8);
        } else {
            this.ezV.setVisibility(0);
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
        if (i != this.biW) {
            if (this.biW != -1) {
                LinearLayout linearLayout = (LinearLayout) this.ezS.getChildAt(this.biW + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.bUN == 0) {
                        color = getResources().getColor(d.C0277d.common_color_10287);
                    } else {
                        color = al.getColor(d.C0277d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.biW = i;
            LinearLayout linearLayout2 = (LinearLayout) this.ezS.getChildAt(this.biW + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ezT.get(this.biW);
            if (cVar.amg() != null) {
                cVar.amg().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(d.C0277d.common_color_10022));
                this.ezY = tbImageView2;
            }
        }
    }

    public void reset() {
        this.biW = -1;
        this.ezS.removeAllViews();
        aVz();
        ii(this.bUN);
    }

    public void ii(int i) {
        int color;
        this.bUN = i;
        if (this.ezW != null) {
            al.b(this.ezW, d.f.face_store, i);
        }
        if (this.ezV != null) {
            al.e(this.ezV, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.ezV.getChildCount() > 0) {
                al.f(this.ezV.getChildAt(1), d.C0277d.common_color_10288, i);
            }
        }
        if (this.clB != null) {
            al.e(this.clB, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.clA != null) {
            al.e(this.clA, d.f.icon_news_head_prompt_one, i);
            al.c(this.clA, d.C0277d.cp_btn_a, 1, i);
        }
        int childCount = this.ezS.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.ezS.getChildAt(i2);
            if (childAt != null) {
                al.e(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.eAb != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0277d.common_color_10287);
                        } else {
                            color = al.getColor(d.C0277d.common_color_10287);
                        }
                        aVar.eAb.setForegroundColor(color);
                    }
                    if (aVar.eAc != null) {
                        al.f(aVar.eAc, d.C0277d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.ezY != null) {
            this.ezY.setForegroundColor(al.getColor(d.C0277d.common_color_10022));
            if (this.ezY.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ezY.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.ezU = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.VO = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private final int bIu;

        private b(int i) {
            this.bIu = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.ezY) {
                ((TbImageView) view).setForegroundColor(al.getColor(d.C0277d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.ezY != null) {
                    if (!EmotionTabHorizonScrollView.this.ezZ) {
                        EmotionTabHorizonScrollView.this.ezY.setForegroundColor(al.getColor(d.C0277d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.ezY.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0277d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.ezY = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.bIu);
            EmotionTabHorizonScrollView.this.ezU.jG(this.bIu);
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
        TbImageView eAb;
        View eAc;
        com.baidu.tbadk.editortools.emotiontool.c eAd;

        private a() {
        }
    }
}
