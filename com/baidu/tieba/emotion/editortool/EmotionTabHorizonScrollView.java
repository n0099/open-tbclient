package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.l Cw;
    private int afy;
    private int aue;
    private LinearLayout.LayoutParams aug;
    private int auh;
    private int aui;
    private TextView auj;
    private View auk;
    private h btE;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> btF;
    private EmotionTabWidgetView.a btG;
    private LinearLayout btH;
    private ImageView btI;
    private boolean btJ;
    private TbImageView btK;
    private boolean btL;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aue = -1;
        this.btJ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aue = -1;
        this.btJ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aue = -1;
        this.btJ = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.btE = new h(getContext());
        this.btE.setOrientation(0);
        this.btE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.btE.setBaselineAligned(false);
        addView(this.btE);
        this.auh = getResources().getDimensionPixelSize(u.e.ds8);
        this.aui = getResources().getDimensionPixelSize(u.e.ds10);
        this.aug = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(u.e.ds122), -1);
        this.btE.setPadding(0, 0, 0, 0);
        RW();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.btL = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.btF = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        av.d(linearLayout, u.f.bg_emotion_tab_horizonscrollview, this.afy);
        c cVar2 = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.btL) {
            tbImageView.setForegroundColor(av.getColor(u.d.common_color_10287));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(u.d.common_color_10287));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar2.btN = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aui, this.auh, this.aui, this.auh);
        View view = new View(getContext());
        cVar2.btO = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds2);
        if (!this.btL) {
            view.setBackgroundColor(av.getColor(u.d.common_color_10288));
        } else {
            view.setBackgroundColor(getResources().getColor(u.d.common_color_10288));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(cVar2);
        this.btE.addView(linearLayout, this.btE.getChildCount() - 1, this.aug);
        EmotionGroupType BF = cVar.BF();
        if (BF == EmotionGroupType.LOCAL) {
            if (cVar.BG() != null) {
                cVar.BG().e(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.btE.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m10getInst().getResources().getString(u.j.local_emotion));
        } else if (BF == EmotionGroupType.PROMOTION) {
            if (cVar.BH() != null) {
                cVar.BH().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m10getInst().getResources().getString(u.j.download_promotion_emotion)) + cVar.getGroupId());
        } else if (BF == EmotionGroupType.BIG_EMOTION) {
            if (this.btJ) {
                if (cVar.BG() != null) {
                    cVar.BG().e(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.btE.getChildCount() - 3, null));
            } else {
                if (cVar.BH() != null) {
                    cVar.BH().e(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (this.btK == null) {
            this.btK = tbImageView;
            this.btK.setForegroundColor(av.getColor(u.d.common_color_10022));
        }
        return tbImageView;
    }

    public void RW() {
        this.btI = new ImageView(getContext());
        this.btI.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.btI.setPadding(this.aui, this.auh, this.aui, this.auh);
        this.btH = new LinearLayout(getContext());
        this.btH.setContentDescription(TbadkCoreApplication.m10getInst().getResources().getString(u.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.btI.setLayoutParams(layoutParams);
        av.c(this.btI, u.f.icon_store, this.afy);
        this.btH.addView(this.btI);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(u.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        av.e(view, u.d.common_color_10288, this.afy);
        this.btH.addView(view);
        this.auj = new TextView(getContext());
        this.auj.setGravity(17);
        this.auj.setTextSize(10.0f);
        this.auj.setText("N");
        this.auj.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.btE.addView(this.btH, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(u.e.ds106), -1));
        this.btE.setNewView(this.auj);
        boolean appResponseToIntentClass = TbadkCoreApplication.m10getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m10getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.btE.setNewViewVisible(true);
        } else {
            this.btE.setNewViewVisible(false);
        }
        this.btH.setOnClickListener(new n(this));
        this.auk = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.auk.setLayoutParams(layoutParams3);
        this.btE.addView(this.auk);
        if (!appResponseToIntentClass) {
            this.btH.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void z(int i, boolean z) {
        this.btJ = z;
        int i2 = i + 1;
        int childCount = this.btE.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.btF.get(i2 - 1);
        if (i2 < childCount && cVar.BF() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.btE.getChildAt(i2)).getChildAt(0);
            if (!this.btJ) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.BH() != null) {
                    cVar.BH().e(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new a(this, i2 - 1, null));
            if (cVar.BG() != null) {
                cVar.BG().e(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aue) {
            if (this.aue != -1) {
                LinearLayout linearLayout = (LinearLayout) this.btE.getChildAt(this.aue + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.afy == 0) {
                        color = getResources().getColor(u.d.common_color_10287);
                    } else {
                        color = av.getColor(u.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aue = i;
            LinearLayout linearLayout2 = (LinearLayout) this.btE.getChildAt(this.aue + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(u.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.btF.get(this.aue);
            if (cVar.BG() != null) {
                cVar.BG().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(av.getColor(u.d.common_color_10022));
                this.btK = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aue = -1;
        this.btE.removeAllViews();
        RW();
        cX(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void cX(int i) {
        int color;
        this.afy = i;
        if (this.btI != null) {
            av.c(this.btI, u.f.icon_store, i);
        }
        if (this.btH != null) {
            av.d(this.btH, u.f.bg_emotion_tab_horizonscrollview, i);
            if (this.btH.getChildCount() > 0) {
                av.e(this.btH.getChildAt(1), u.d.common_color_10288, i);
            }
        }
        if (this.auk != null) {
            av.d(this.auk, u.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.auj != null) {
            av.d(this.auj, u.f.icon_news_head_prompt_one, i);
            av.b(this.auj, u.d.cp_cont_i, 1, i);
        }
        int childCount = this.btE.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.btE.getChildAt(i2);
            if (childAt != null) {
                av.d(childAt, u.f.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.btN != null) {
                        if (i == 0) {
                            color = getResources().getColor(u.d.common_color_10287);
                        } else {
                            color = av.getColor(u.d.common_color_10287);
                        }
                        cVar.btN.setForegroundColor(color);
                    }
                    if (cVar.btO != null) {
                        av.e(cVar.btO, u.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.btK != null) {
            this.btK.setForegroundColor(av.getColor(u.d.common_color_10022));
            if (this.btK.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.btK.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.btG = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.Cw = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int Wv;

        private a(int i) {
            this.Wv = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.btK) {
                ((TbImageView) view).setForegroundColor(av.getColor(u.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.btK != null) {
                    if (!EmotionTabHorizonScrollView.this.btL) {
                        EmotionTabHorizonScrollView.this.btK.setForegroundColor(av.getColor(u.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.btK.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(u.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.btK = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.Wv);
            EmotionTabHorizonScrollView.this.btG.eA(this.Wv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final String mGroupId;

        private b(String str) {
            this.mGroupId = str;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, b bVar) {
            this(str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            switch (EmotionTabHorizonScrollView.this.from) {
                case 1:
                    str = "faceshop_from_write_promotion";
                    break;
                case 2:
                    str = "faceshop_from_pchat_promotion";
                    break;
                case 3:
                    str = "faceshop_from_gchat_promotion";
                    break;
                default:
                    str = "";
                    break;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), this.mGroupId, false, str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        TbImageView btN;
        View btO;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
