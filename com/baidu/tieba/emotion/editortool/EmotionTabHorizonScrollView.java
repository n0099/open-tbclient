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
import com.baidu.tbadk.core.util.am;
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
    private EditorTools FO;
    private int Ni;
    private LinearLayout.LayoutParams cyk;
    private int dzw;
    private int dzx;
    private TextView dzy;
    private View dzz;
    private EmotionLinearLayout fSq;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fSr;
    private EmotionTabWidgetView.a fSs;
    private LinearLayout fSt;
    private ImageView fSu;
    private boolean fSv;
    private TbImageView fSw;
    private boolean fSx;
    private int from;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.fSv = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.fSv = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.fSv = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.fSq = new EmotionLinearLayout(getContext());
        this.fSq.setOrientation(0);
        this.fSq.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fSq.setBaselineAligned(false);
        addView(this.fSq);
        this.dzw = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.dzx = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.cyk = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.fSq.setPadding(0, 0, 0, 0);
        bxm();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.fSx = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.fSr = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.fSB = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.fSz = tbImageView;
        if (cVar.aOG() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.dzx, this.dzw, this.dzx, this.dzw);
            ImageView imageView = new ImageView(getContext());
            am.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.fSA = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.fSq.addView(relativeLayout, this.fSq.getChildCount() - 1, this.cyk);
            if (cVar.aOI() != null) {
                cVar.aOI().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.fSx && (this.Ni == 1 || this.Ni == 4)) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.fSw == null) {
                this.fSw = tbImageView;
                this.fSw.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.Ni);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.dzx, this.dzw, this.dzx, this.dzw);
            View view2 = new View(getContext());
            aVar.fSA = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.fSq.addView(linearLayout, this.fSq.getChildCount() - 1, this.cyk);
            EmotionGroupType aOG = cVar.aOG();
            if (aOG == EmotionGroupType.LOCAL) {
                if (cVar.aOH() != null) {
                    cVar.aOH().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.fSq.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (aOG == EmotionGroupType.PROMOTION) {
                if (cVar.aOI() != null) {
                    cVar.aOI().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (aOG == EmotionGroupType.BIG_EMOTION) {
                if (this.fSv) {
                    if (cVar.aOH() != null) {
                        cVar.aOH().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.fSq.getChildCount() - 3));
                } else {
                    if (cVar.aOI() != null) {
                        cVar.aOI().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aEF();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (aOG == EmotionGroupType.USER_COLLECT) {
                if (cVar.aOI() != null) {
                    cVar.aOI().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.fSq.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (aOG == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.aOI() != null) {
                    cVar.aOI().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.fSx && (this.Ni == 1 || this.Ni == 4)) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.fSw == null) {
                this.fSw = tbImageView;
                this.fSw.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.Ni);
        }
        return tbImageView;
    }

    public void bxm() {
        this.fSu = new ImageView(getContext());
        this.fSu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fSu.setPadding(this.dzx, this.dzw, this.dzx, this.dzw);
        this.fSt = new LinearLayout(getContext());
        this.fSt.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.fSu.setLayoutParams(layoutParams);
        am.setImageResource(this.fSu, R.drawable.face_store, this.Ni);
        this.fSt.addView(this.fSu);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.setBackgroundColor(view, R.color.common_color_10288, this.Ni);
        this.fSt.addView(view);
        this.dzy = new TextView(getContext());
        this.dzy.setGravity(17);
        this.dzy.setTextSize(10.0f);
        this.dzy.setText("N");
        this.dzy.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.fSq.addView(this.fSt, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.fSq.setNewView(this.dzy);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.fSq.setNewViewVisible(true);
        } else {
            this.fSq.setNewViewVisible(false);
        }
        this.fSt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.dzy != null) {
                    EmotionTabHorizonScrollView.this.fSq.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.FO != null) {
                    EmotionTabHorizonScrollView.this.FO.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.dzz = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.dzz.setLayoutParams(layoutParams3);
        this.fSq.addView(this.dzz);
        if (!appResponseToIntentClass) {
            this.fSt.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.fSv = z;
        int i2 = i + 1;
        int childCount = this.fSq.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.fSr.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.aOG() == EmotionGroupType.BIG_EMOTION || cVar.aOG() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.fSq.getChildAt(i2)).getChildAt(0);
                if (!this.fSv) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aEF();
                        }
                    });
                    if (cVar.aOI() != null) {
                        cVar.aOI().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.aOH() != null) {
                    cVar.aOH().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.fSq.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fSq.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).fSB;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.fSt.setVisibility(8);
        } else {
            this.fSt.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.aOG() == EmotionGroupType.BIG_EMOTION || cVar.aOG() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.fSq.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.Ni == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.fSq.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.fSr.get(this.mCurrentIndex);
            if (cVar.aOH() != null) {
                cVar.aOH().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.fSw = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.fSq.removeAllViews();
        bxm();
        onChangeSkin(this.Ni);
    }

    public void onChangeSkin(int i) {
        int color;
        this.Ni = i;
        if (this.fSu != null) {
            am.setImageResource(this.fSu, R.drawable.face_store, i);
        }
        if (this.fSt != null) {
            am.setBackgroundResource(this.fSt, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.fSt.getChildCount() > 0) {
                am.setBackgroundColor(this.fSt.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.dzz != null) {
            am.setBackgroundResource(this.dzz, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.dzy != null) {
            am.setBackgroundResource(this.dzy, R.drawable.icon_news_head_prompt_one, i);
            am.setViewTextColor(this.dzy, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.fSq.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.fSq.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.fSz != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.fSz.setForegroundColor(color);
                    }
                    if (aVar.fSA != null) {
                        am.setBackgroundColor(aVar.fSA, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.fSw != null) {
            this.fSw.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.fSw.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fSw.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.fSs = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
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
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.fSw) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.fSw != null) {
                    if (!EmotionTabHorizonScrollView.this.fSx) {
                        EmotionTabHorizonScrollView.this.fSw.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.fSw.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.fSw = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.fSs.mA(this.mTabIndex);
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
        View fSA;
        com.baidu.tbadk.editortools.emotiontool.c fSB;
        TbImageView fSz;

        private a() {
        }
    }
}
