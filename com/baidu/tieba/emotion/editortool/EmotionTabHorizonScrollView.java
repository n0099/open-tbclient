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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes13.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools abk;
    private int ajq;
    private LinearLayout.LayoutParams dZK;
    private int fld;
    private int fle;
    private TextView flf;
    private View flg;
    private int from;
    private EmotionLinearLayout iaU;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iaV;
    private EmotionTabWidgetView.a iaW;
    private LinearLayout iaX;
    private ImageView iaY;
    private boolean iaZ;
    private TbImageView iba;
    private boolean ibb;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.iaZ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.iaZ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.iaZ = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.iaU = new EmotionLinearLayout(getContext());
        this.iaU.setOrientation(0);
        this.iaU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iaU.setBaselineAligned(false);
        addView(this.iaU);
        this.fld = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fle = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.dZK = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.iaU.setPadding(0, 0, 0, 0);
        cnW();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.ibb = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.iaV = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.ibf = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.ibd = tbImageView;
        if (cVar.bxs() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.fle, this.fld, this.fle, this.fld);
            ImageView imageView = new ImageView(getContext());
            ap.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.ibe = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.iaU.addView(relativeLayout, this.iaU.getChildCount() - 1, this.dZK);
            if (cVar.bxu() != null) {
                cVar.bxu().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.ibb && (this.ajq == 1 || this.ajq == 4)) {
                view.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.iba == null) {
                this.iba = tbImageView;
                this.iba.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ajq);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.fle, this.fld, this.fle, this.fld);
            View view2 = new View(getContext());
            aVar.ibe = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.iaU.addView(linearLayout, this.iaU.getChildCount() - 1, this.dZK);
            EmotionGroupType bxs = cVar.bxs();
            if (bxs == EmotionGroupType.LOCAL) {
                if (cVar.bxt() != null) {
                    cVar.bxt().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.iaU.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bxs == EmotionGroupType.PROMOTION) {
                if (cVar.bxu() != null) {
                    cVar.bxu().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bxs == EmotionGroupType.BIG_EMOTION) {
                if (this.iaZ) {
                    if (cVar.bxt() != null) {
                        cVar.bxt().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.iaU.getChildCount() - 3));
                } else {
                    if (cVar.bxu() != null) {
                        cVar.bxu().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bmI();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bxs == EmotionGroupType.USER_COLLECT) {
                if (cVar.bxu() != null) {
                    cVar.bxu().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.iaU.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bxs == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bxu() != null) {
                    cVar.bxu().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.ibb && (this.ajq == 1 || this.ajq == 4)) {
                view2.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.iba == null) {
                this.iba = tbImageView;
                this.iba.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ajq);
        }
        return tbImageView;
    }

    public void cnW() {
        this.iaY = new ImageView(getContext());
        this.iaY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iaY.setPadding(this.fle, this.fld, this.fle, this.fld);
        this.iaX = new LinearLayout(getContext());
        this.iaX.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.iaY.setLayoutParams(layoutParams);
        ap.setImageResource(this.iaY, R.drawable.face_store, this.ajq);
        this.iaX.addView(this.iaY);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ap.setBackgroundColor(view, R.color.common_color_10288, this.ajq);
        this.iaX.addView(view);
        this.flf = new TextView(getContext());
        this.flf.setGravity(17);
        this.flf.setTextSize(10.0f);
        this.flf.setText("N");
        this.flf.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.iaU.addView(this.iaX, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.iaU.setNewView(this.flf);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.iaU.setNewViewVisible(true);
        } else {
            this.iaU.setNewViewVisible(false);
        }
        this.iaX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.flf != null) {
                    EmotionTabHorizonScrollView.this.iaU.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.abk != null) {
                    EmotionTabHorizonScrollView.this.abk.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.flg = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.flg.setLayoutParams(layoutParams3);
        this.iaU.addView(this.flg);
        if (!appResponseToIntentClass) {
            this.iaX.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.iaZ = z;
        int i2 = i + 1;
        int childCount = this.iaU.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.iaV.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bxs() == EmotionGroupType.BIG_EMOTION || cVar.bxs() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.iaU.getChildAt(i2)).getChildAt(0);
                if (!this.iaZ) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bmI();
                        }
                    });
                    if (cVar.bxu() != null) {
                        cVar.bxu().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bxt() != null) {
                    cVar.bxt().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.iaU.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iaU.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).ibf;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.iaX.setVisibility(8);
        } else {
            this.iaX.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bxs() == EmotionGroupType.BIG_EMOTION || cVar.bxs() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.iaU.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ajq == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ap.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.iaU.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.iaV.get(this.mCurrentIndex);
            if (cVar.bxt() != null) {
                cVar.bxt().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ap.getColor(R.color.common_color_10022));
                this.iba = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.iaU.removeAllViews();
        cnW();
        onChangeSkin(this.ajq);
    }

    public void onChangeSkin(int i) {
        int color;
        this.ajq = i;
        if (this.iaY != null) {
            ap.setImageResource(this.iaY, R.drawable.face_store, i);
        }
        if (this.iaX != null) {
            ap.setBackgroundResource(this.iaX, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.iaX.getChildCount() > 0) {
                ap.setBackgroundColor(this.iaX.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.flg != null) {
            ap.setBackgroundResource(this.flg, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.flf != null) {
            ap.setBackgroundResource(this.flf, R.drawable.icon_news_head_prompt_one, i);
            ap.setViewTextColor(this.flf, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.iaU.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.iaU.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.ibd != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ap.getColor(R.color.common_color_10287);
                        }
                        aVar.ibd.setForegroundColor(color);
                    }
                    if (aVar.ibe != null) {
                        ap.setBackgroundColor(aVar.ibe, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.iba != null) {
            this.iba.setForegroundColor(ap.getColor(R.color.common_color_10022));
            if (this.iba.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iba.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.iaW = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!EmotionTabHorizonScrollView.this.abk.ra(5).bxo() && (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.iaV.get(this.mTabIndex)).bxs() == EmotionGroupType.USER_COLLECT || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.iaV.get(this.mTabIndex)).bxs() == EmotionGroupType.BIG_EMOTION)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921500, true));
                return;
            }
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.iba) {
                ((TbImageView) view).setForegroundColor(ap.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.iba != null) {
                    if (!EmotionTabHorizonScrollView.this.ibb) {
                        EmotionTabHorizonScrollView.this.iba.setForegroundColor(ap.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.iba.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.iba = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.iaW.ro(this.mTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
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
    /* loaded from: classes13.dex */
    public static class a {
        TbImageView ibd;
        View ibe;
        com.baidu.tbadk.editortools.emotiontool.c ibf;

        private a() {
        }
    }
}
