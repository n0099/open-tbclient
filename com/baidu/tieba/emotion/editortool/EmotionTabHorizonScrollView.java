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
/* loaded from: classes2.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools CJ;
    private int apz;
    private LinearLayout.LayoutParams bIH;
    private int cHr;
    private int cHs;
    private TextView cHt;
    private View cHu;
    private int csg;
    private EmotionLinearLayout eYe;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eYf;
    private EmotionTabWidgetView.a eYg;
    private LinearLayout eYh;
    private ImageView eYi;
    private boolean eYj;
    private TbImageView eYk;
    private boolean eYl;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apz = -1;
        this.eYj = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apz = -1;
        this.eYj = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.apz = -1;
        this.eYj = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.eYe = new EmotionLinearLayout(getContext());
        this.eYe.setOrientation(0);
        this.eYe.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eYe.setBaselineAligned(false);
        addView(this.eYe);
        this.cHr = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.cHs = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.bIH = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.eYe.setPadding(0, 0, 0, 0);
        bdk();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.eYl = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eYf = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.eYp = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.eYn = tbImageView;
        if (cVar.aum() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.cHs, this.cHr, this.cHs, this.cHr);
            ImageView imageView = new ImageView(getContext());
            am.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.eYo = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.eYe.addView(relativeLayout, this.eYe.getChildCount() - 1, this.bIH);
            if (cVar.auo() != null) {
                cVar.auo().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.eYl && (this.csg == 1 || this.csg == 4)) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.eYk == null) {
                this.eYk = tbImageView;
                this.eYk.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.csg);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.cHs, this.cHr, this.cHs, this.cHr);
            View view2 = new View(getContext());
            aVar.eYo = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.eYe.addView(linearLayout, this.eYe.getChildCount() - 1, this.bIH);
            EmotionGroupType aum = cVar.aum();
            if (aum == EmotionGroupType.LOCAL) {
                if (cVar.aun() != null) {
                    cVar.aun().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eYe.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (aum == EmotionGroupType.PROMOTION) {
                if (cVar.auo() != null) {
                    cVar.auo().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (aum == EmotionGroupType.BIG_EMOTION) {
                if (this.eYj) {
                    if (cVar.aun() != null) {
                        cVar.aun().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.eYe.getChildCount() - 3));
                } else {
                    if (cVar.auo() != null) {
                        cVar.auo().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).akR();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (aum == EmotionGroupType.USER_COLLECT) {
                if (cVar.auo() != null) {
                    cVar.auo().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eYe.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (aum == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.auo() != null) {
                    cVar.auo().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.eYl && (this.csg == 1 || this.csg == 4)) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.eYk == null) {
                this.eYk = tbImageView;
                this.eYk.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.csg);
        }
        return tbImageView;
    }

    public void bdk() {
        this.eYi = new ImageView(getContext());
        this.eYi.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eYi.setPadding(this.cHs, this.cHr, this.cHs, this.cHr);
        this.eYh = new LinearLayout(getContext());
        this.eYh.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.eYi.setLayoutParams(layoutParams);
        am.setImageResource(this.eYi, R.drawable.face_store, this.csg);
        this.eYh.addView(this.eYi);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.setBackgroundColor(view, R.color.common_color_10288, this.csg);
        this.eYh.addView(view);
        this.cHt = new TextView(getContext());
        this.cHt.setGravity(17);
        this.cHt.setTextSize(10.0f);
        this.cHt.setText("N");
        this.cHt.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.eYe.addView(this.eYh, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.eYe.setNewView(this.cHt);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.eYe.setNewViewVisible(true);
        } else {
            this.eYe.setNewViewVisible(false);
        }
        this.eYh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.cHt != null) {
                    EmotionTabHorizonScrollView.this.eYe.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.CJ != null) {
                    EmotionTabHorizonScrollView.this.CJ.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.cHu = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.cHu.setLayoutParams(layoutParams3);
        this.eYe.addView(this.cHu);
        if (!appResponseToIntentClass) {
            this.eYh.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eYj = z;
        int i2 = i + 1;
        int childCount = this.eYe.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.eYf.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.aum() == EmotionGroupType.BIG_EMOTION || cVar.aum() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.eYe.getChildAt(i2)).getChildAt(0);
                if (!this.eYj) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).akR();
                        }
                    });
                    if (cVar.auo() != null) {
                        cVar.auo().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.aun() != null) {
                    cVar.aun().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.eYe.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eYe.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).eYp;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.eYh.setVisibility(8);
        } else {
            this.eYh.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.aum() == EmotionGroupType.BIG_EMOTION || cVar.aum() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.apz) {
            if (this.apz != -1) {
                LinearLayout linearLayout = (LinearLayout) this.eYe.getChildAt(this.apz + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.csg == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.apz = i;
            LinearLayout linearLayout2 = (LinearLayout) this.eYe.getChildAt(this.apz + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eYf.get(this.apz);
            if (cVar.aun() != null) {
                cVar.aun().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.eYk = tbImageView2;
            }
        }
    }

    public void reset() {
        this.apz = -1;
        this.eYe.removeAllViews();
        bdk();
        onChangeSkin(this.csg);
    }

    public void onChangeSkin(int i) {
        int color;
        this.csg = i;
        if (this.eYi != null) {
            am.setImageResource(this.eYi, R.drawable.face_store, i);
        }
        if (this.eYh != null) {
            am.setBackgroundResource(this.eYh, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.eYh.getChildCount() > 0) {
                am.setBackgroundColor(this.eYh.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.cHu != null) {
            am.setBackgroundResource(this.cHu, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.cHt != null) {
            am.setBackgroundResource(this.cHt, R.drawable.icon_news_head_prompt_one, i);
            am.setViewTextColor(this.cHt, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.eYe.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.eYe.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.eYn != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.eYn.setForegroundColor(color);
                    }
                    if (aVar.eYo != null) {
                        am.setBackgroundColor(aVar.eYo, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.eYk != null) {
            this.eYk.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.eYk.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.eYk.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.eYg = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.eYk) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.eYk != null) {
                    if (!EmotionTabHorizonScrollView.this.eYl) {
                        EmotionTabHorizonScrollView.this.eYk.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.eYk.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.eYk = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.eYg.jV(this.mTabIndex);
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
            if (com.baidu.adp.lib.g.b.toInt(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.toInt(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        TbImageView eYn;
        View eYo;
        com.baidu.tbadk.editortools.emotiontool.c eYp;

        private a() {
        }
    }
}
