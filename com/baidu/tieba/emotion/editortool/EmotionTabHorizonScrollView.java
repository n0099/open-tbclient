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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools ZX;
    private int ahx;
    private LinearLayout.LayoutParams dnm;
    private int ewK;
    private int ewL;
    private TextView ewM;
    private View ewN;
    private int from;
    private EmotionLinearLayout gZT;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gZU;
    private EmotionTabWidgetView.a gZV;
    private LinearLayout gZW;
    private ImageView gZX;
    private boolean gZY;
    private TbImageView gZZ;
    private boolean haa;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.gZY = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.gZY = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.gZY = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.gZT = new EmotionLinearLayout(getContext());
        this.gZT.setOrientation(0);
        this.gZT.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.gZT.setBaselineAligned(false);
        addView(this.gZT);
        this.ewK = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.ewL = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.dnm = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.gZT.setPadding(0, 0, 0, 0);
        bQF();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.haa = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.gZU = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.hae = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.hac = tbImageView;
        if (cVar.bfq() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.ewL, this.ewK, this.ewL, this.ewK);
            ImageView imageView = new ImageView(getContext());
            an.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.had = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.gZT.addView(relativeLayout, this.gZT.getChildCount() - 1, this.dnm);
            if (cVar.bfs() != null) {
                cVar.bfs().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.haa && (this.ahx == 1 || this.ahx == 4)) {
                view.setBackgroundColor(an.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(an.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.gZZ == null) {
                this.gZZ = tbImageView;
                this.gZZ.setForegroundColor(an.getColor(R.color.common_color_10022));
            }
            an.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ahx);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.ewL, this.ewK, this.ewL, this.ewK);
            View view2 = new View(getContext());
            aVar.had = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.gZT.addView(linearLayout, this.gZT.getChildCount() - 1, this.dnm);
            EmotionGroupType bfq = cVar.bfq();
            if (bfq == EmotionGroupType.LOCAL) {
                if (cVar.bfr() != null) {
                    cVar.bfr().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.gZT.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bfq == EmotionGroupType.PROMOTION) {
                if (cVar.bfs() != null) {
                    cVar.bfs().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bfq == EmotionGroupType.BIG_EMOTION) {
                if (this.gZY) {
                    if (cVar.bfr() != null) {
                        cVar.bfr().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.gZT.getChildCount() - 3));
                } else {
                    if (cVar.bfs() != null) {
                        cVar.bfs().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aUS();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bfq == EmotionGroupType.USER_COLLECT) {
                if (cVar.bfs() != null) {
                    cVar.bfs().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.gZT.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bfq == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bfs() != null) {
                    cVar.bfs().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.haa && (this.ahx == 1 || this.ahx == 4)) {
                view2.setBackgroundColor(an.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(an.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.gZZ == null) {
                this.gZZ = tbImageView;
                this.gZZ.setForegroundColor(an.getColor(R.color.common_color_10022));
            }
            an.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ahx);
        }
        return tbImageView;
    }

    public void bQF() {
        this.gZX = new ImageView(getContext());
        this.gZX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gZX.setPadding(this.ewL, this.ewK, this.ewL, this.ewK);
        this.gZW = new LinearLayout(getContext());
        this.gZW.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.gZX.setLayoutParams(layoutParams);
        an.setImageResource(this.gZX, R.drawable.face_store, this.ahx);
        this.gZW.addView(this.gZX);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        an.setBackgroundColor(view, R.color.common_color_10288, this.ahx);
        this.gZW.addView(view);
        this.ewM = new TextView(getContext());
        this.ewM.setGravity(17);
        this.ewM.setTextSize(10.0f);
        this.ewM.setText("N");
        this.ewM.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.gZT.addView(this.gZW, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.gZT.setNewView(this.ewM);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.gZT.setNewViewVisible(true);
        } else {
            this.gZT.setNewViewVisible(false);
        }
        this.gZW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.ewM != null) {
                    EmotionTabHorizonScrollView.this.gZT.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.ZX != null) {
                    EmotionTabHorizonScrollView.this.ZX.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.ewN = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.ewN.setLayoutParams(layoutParams3);
        this.gZT.addView(this.ewN);
        if (!appResponseToIntentClass) {
            this.gZW.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.gZY = z;
        int i2 = i + 1;
        int childCount = this.gZT.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.gZU.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bfq() == EmotionGroupType.BIG_EMOTION || cVar.bfq() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.gZT.getChildAt(i2)).getChildAt(0);
                if (!this.gZY) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aUS();
                        }
                    });
                    if (cVar.bfs() != null) {
                        cVar.bfs().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bfr() != null) {
                    cVar.bfr().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.gZT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gZT.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).hae;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.gZW.setVisibility(8);
        } else {
            this.gZW.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bfq() == EmotionGroupType.BIG_EMOTION || cVar.bfq() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.gZT.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ahx == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = an.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.gZT.getChildAt(this.mCurrentIndex + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(R.id.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.gZU.get(this.mCurrentIndex);
            if (cVar.bfr() != null) {
                cVar.bfr().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(an.getColor(R.color.common_color_10022));
                this.gZZ = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.gZT.removeAllViews();
        bQF();
        onChangeSkin(this.ahx);
    }

    public void onChangeSkin(int i) {
        int color;
        this.ahx = i;
        if (this.gZX != null) {
            an.setImageResource(this.gZX, R.drawable.face_store, i);
        }
        if (this.gZW != null) {
            an.setBackgroundResource(this.gZW, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.gZW.getChildCount() > 0) {
                an.setBackgroundColor(this.gZW.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.ewN != null) {
            an.setBackgroundResource(this.ewN, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.ewM != null) {
            an.setBackgroundResource(this.ewM, R.drawable.icon_news_head_prompt_one, i);
            an.setViewTextColor(this.ewM, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.gZT.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.gZT.getChildAt(i2);
            if (childAt != null) {
                an.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.hac != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = an.getColor(R.color.common_color_10287);
                        }
                        aVar.hac.setForegroundColor(color);
                    }
                    if (aVar.had != null) {
                        an.setBackgroundColor(aVar.had, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.gZZ != null) {
            this.gZZ.setForegroundColor(an.getColor(R.color.common_color_10022));
            if (this.gZZ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gZZ.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.gZV = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.ZX = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.gZZ) {
                ((TbImageView) view).setForegroundColor(an.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.gZZ != null) {
                    if (!EmotionTabHorizonScrollView.this.haa) {
                        EmotionTabHorizonScrollView.this.gZZ.setForegroundColor(an.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.gZZ.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.gZZ = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.gZV.nL(this.mTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.f.b.toInt(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.f.b.toInt(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        TbImageView hac;
        View had;
        com.baidu.tbadk.editortools.emotiontool.c hae;

        private a() {
        }
    }
}
