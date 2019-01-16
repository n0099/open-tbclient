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
import com.baidu.tieba.e;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools Tj;
    private int aMj;
    private int bbQ;
    private int bbR;
    private TextView bbS;
    private View bbT;
    private EmotionLinearLayout dqm;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dqn;
    private EmotionTabWidgetView.a dqo;
    private LinearLayout dqp;
    private ImageView dqq;
    private boolean dqr;
    private TbImageView dqs;
    private boolean dqt;
    private int from;
    private int mCurrentIndex;
    private LinearLayout.LayoutParams mParams;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.dqr = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.dqr = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.dqr = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.dqm = new EmotionLinearLayout(getContext());
        this.dqm.setOrientation(0);
        this.dqm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dqm.setBaselineAligned(false);
        addView(this.dqm);
        this.bbQ = getResources().getDimensionPixelSize(e.C0210e.ds8);
        this.bbR = getResources().getDimensionPixelSize(e.C0210e.ds10);
        this.mParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds122), -1);
        this.dqm.setPadding(0, 0, 0, 0);
        avK();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.dqt = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dqn = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.dqx = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.dqv = tbImageView;
        if (cVar.ME() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.bbR, this.bbQ, this.bbR, this.bbQ);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, e.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.h(getContext(), e.C0210e.ds12), l.h(getContext(), e.C0210e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.dqw = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.dqm.addView(relativeLayout, this.dqm.getChildCount() - 1, this.mParams);
            if (cVar.MG() != null) {
                cVar.MG().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.dqt && this.aMj == 1) {
                view.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.dqs == null) {
                this.dqs = tbImageView;
                this.dqs.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(relativeLayout, e.f.bg_emotion_tab_horizonscrollview, this.aMj);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.bbR, this.bbQ, this.bbR, this.bbQ);
            View view2 = new View(getContext());
            aVar.dqw = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.dqm.addView(linearLayout, this.dqm.getChildCount() - 1, this.mParams);
            EmotionGroupType ME = cVar.ME();
            if (ME == EmotionGroupType.LOCAL) {
                if (cVar.MF() != null) {
                    cVar.MF().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dqm.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.local_emotion));
            } else if (ME == EmotionGroupType.PROMOTION) {
                if (cVar.MG() != null) {
                    cVar.MG().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (ME == EmotionGroupType.BIG_EMOTION) {
                if (this.dqr) {
                    if (cVar.MF() != null) {
                        cVar.MF().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.dqm.getChildCount() - 3));
                } else {
                    if (cVar.MG() != null) {
                        cVar.MG().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).Ca();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (ME == EmotionGroupType.USER_COLLECT) {
                if (cVar.MG() != null) {
                    cVar.MG().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dqm.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (ME == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.MG() != null) {
                    cVar.MG().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.dqt && this.aMj == 1) {
                view2.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.dqs == null) {
                this.dqs = tbImageView;
                this.dqs.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(linearLayout, e.f.bg_emotion_tab_horizonscrollview, this.aMj);
        }
        return tbImageView;
    }

    public void avK() {
        this.dqq = new ImageView(getContext());
        this.dqq.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dqq.setPadding(this.bbR, this.bbQ, this.bbR, this.bbQ);
        this.dqp = new LinearLayout(getContext());
        this.dqp.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dqq.setLayoutParams(layoutParams);
        al.b(this.dqq, e.f.face_store, this.aMj);
        this.dqp.addView(this.dqq);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.e(view, e.d.common_color_10288, this.aMj);
        this.dqp.addView(view);
        this.bbS = new TextView(getContext());
        this.bbS.setGravity(17);
        this.bbS.setTextSize(10.0f);
        this.bbS.setText("N");
        this.bbS.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dqm.addView(this.dqp, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds106), -1));
        this.dqm.setNewView(this.bbS);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.dqm.setNewViewVisible(true);
        } else {
            this.dqm.setNewViewVisible(false);
        }
        this.dqp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.bbS != null) {
                    EmotionTabHorizonScrollView.this.dqm.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Tj != null) {
                    EmotionTabHorizonScrollView.this.Tj.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.kV()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), e.j.neterror);
                }
            }
        });
        this.bbT = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.bbT.setLayoutParams(layoutParams3);
        this.dqm.addView(this.bbT);
        if (!appResponseToIntentClass) {
            this.dqp.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.dqr = z;
        int i2 = i + 1;
        int childCount = this.dqm.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.dqn.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.ME() == EmotionGroupType.BIG_EMOTION || cVar.ME() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.dqm.getChildAt(i2)).getChildAt(0);
                if (!this.dqr) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).Ca();
                        }
                    });
                    if (cVar.MG() != null) {
                        cVar.MG().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.MF() != null) {
                    cVar.MF().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.dqm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dqm.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).dqx;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.dqp.setVisibility(8);
        } else {
            this.dqp.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.ME() == EmotionGroupType.BIG_EMOTION || cVar.ME() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dqm.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aMj == 0) {
                        color = getResources().getColor(e.d.common_color_10287);
                    } else {
                        color = al.getColor(e.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dqm.getChildAt(this.mCurrentIndex + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(e.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dqn.get(this.mCurrentIndex);
            if (cVar.MF() != null) {
                cVar.MF().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(e.d.common_color_10022));
                this.dqs = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.dqm.removeAllViews();
        avK();
        eD(this.aMj);
    }

    public void eD(int i) {
        int color;
        this.aMj = i;
        if (this.dqq != null) {
            al.b(this.dqq, e.f.face_store, i);
        }
        if (this.dqp != null) {
            al.d(this.dqp, e.f.bg_emotion_tab_horizonscrollview, i);
            if (this.dqp.getChildCount() > 0) {
                al.e(this.dqp.getChildAt(1), e.d.common_color_10288, i);
            }
        }
        if (this.bbT != null) {
            al.d(this.bbT, e.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.bbS != null) {
            al.d(this.bbS, e.f.icon_news_head_prompt_one, i);
            al.b(this.bbS, e.d.cp_cont_i, 1, i);
        }
        int childCount = this.dqm.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.dqm.getChildAt(i2);
            if (childAt != null) {
                al.d(childAt, e.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.dqv != null) {
                        if (i == 0) {
                            color = getResources().getColor(e.d.common_color_10287);
                        } else {
                            color = al.getColor(e.d.common_color_10287);
                        }
                        aVar.dqv.setForegroundColor(color);
                    }
                    if (aVar.dqw != null) {
                        al.e(aVar.dqw, e.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.dqs != null) {
            this.dqs.setForegroundColor(al.getColor(e.d.common_color_10022));
            if (this.dqs.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dqs.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.dqo = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        private final int aAv;

        private b(int i) {
            this.aAv = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.dqs) {
                ((TbImageView) view).setForegroundColor(al.getColor(e.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.dqs != null) {
                    if (!EmotionTabHorizonScrollView.this.dqt) {
                        EmotionTabHorizonScrollView.this.dqs.setForegroundColor(al.getColor(e.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.dqs.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(e.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.dqs = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aAv);
            EmotionTabHorizonScrollView.this.dqo.fW(this.aAv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
    public static class a {
        TbImageView dqv;
        View dqw;
        com.baidu.tbadk.editortools.emotiontool.c dqx;

        private a() {
        }
    }
}
