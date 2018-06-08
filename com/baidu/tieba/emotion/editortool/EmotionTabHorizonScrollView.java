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
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools Qh;
    private int aOd;
    private LinearLayout.LayoutParams aOf;
    private int aOg;
    private int aOh;
    private TextView aOi;
    private View aOj;
    private int ayX;
    private EmotionLinearLayout cQm;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cQn;
    private EmotionTabWidgetView.a cQo;
    private LinearLayout cQp;
    private ImageView cQq;
    private boolean cQr;
    private TbImageView cQs;
    private boolean cQt;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOd = -1;
        this.cQr = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOd = -1;
        this.cQr = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aOd = -1;
        this.cQr = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cQm = new EmotionLinearLayout(getContext());
        this.cQm.setOrientation(0);
        this.cQm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cQm.setBaselineAligned(false);
        addView(this.cQm);
        this.aOg = getResources().getDimensionPixelSize(d.e.ds8);
        this.aOh = getResources().getDimensionPixelSize(d.e.ds10);
        this.aOf = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.cQm.setPadding(0, 0, 0, 0);
        aoh();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.cQt = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cQn = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.cQx = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.cQv = tbImageView;
        if (cVar.Hv() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aOh, this.aOg, this.aOh, this.aOg);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.e(getContext(), d.e.ds12), l.e(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.cQw = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.cQm.addView(relativeLayout, this.cQm.getChildCount() - 1, this.aOf);
            if (cVar.Hx() != null) {
                cVar.Hx().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.cQt && this.ayX == 1) {
                view.setBackgroundColor(al.getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(d.C0141d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0141d.common_color_10287));
            }
            if (this.cQs == null) {
                this.cQs = tbImageView;
                this.cQs.setForegroundColor(al.getColor(d.C0141d.common_color_10022));
            }
            al.d(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.ayX);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aOh, this.aOg, this.aOh, this.aOg);
            View view2 = new View(getContext());
            aVar.cQw = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.cQm.addView(linearLayout, this.cQm.getChildCount() - 1, this.aOf);
            EmotionGroupType Hv = cVar.Hv();
            if (Hv == EmotionGroupType.LOCAL) {
                if (cVar.Hw() != null) {
                    cVar.Hw().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cQm.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.local_emotion));
            } else if (Hv == EmotionGroupType.PROMOTION) {
                if (cVar.Hx() != null) {
                    cVar.Hx().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.download_promotion_emotion) + cVar.getGroupId());
            } else if (Hv == EmotionGroupType.BIG_EMOTION) {
                if (this.cQr) {
                    if (cVar.Hw() != null) {
                        cVar.Hw().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.cQm.getChildCount() - 3));
                } else {
                    if (cVar.Hx() != null) {
                        cVar.Hx().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.k.emotion_cant_show)).xi();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Hv == EmotionGroupType.USER_COLLECT) {
                if (cVar.Hx() != null) {
                    cVar.Hx().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cQm.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Hv == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Hx() != null) {
                    cVar.Hx().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.cQt && this.ayX == 1) {
                view2.setBackgroundColor(al.getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(d.C0141d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0141d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0141d.common_color_10287));
            }
            if (this.cQs == null) {
                this.cQs = tbImageView;
                this.cQs.setForegroundColor(al.getColor(d.C0141d.common_color_10022));
            }
            al.d(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.ayX);
        }
        return tbImageView;
    }

    public void aoh() {
        this.cQq = new ImageView(getContext());
        this.cQq.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cQq.setPadding(this.aOh, this.aOg, this.aOh, this.aOg);
        this.cQp = new LinearLayout(getContext());
        this.cQp.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cQq.setLayoutParams(layoutParams);
        al.b(this.cQq, d.f.face_store, this.ayX);
        this.cQp.addView(this.cQq);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.e(view, d.C0141d.common_color_10288, this.ayX);
        this.cQp.addView(view);
        this.aOi = new TextView(getContext());
        this.aOi.setGravity(17);
        this.aOi.setTextSize(10.0f);
        this.aOi.setText("N");
        this.aOi.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cQm.addView(this.cQp, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.cQm.setNewView(this.aOi);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.cQm.setNewViewVisible(true);
        } else {
            this.cQm.setNewViewVisible(false);
        }
        this.cQp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aOi != null) {
                    EmotionTabHorizonScrollView.this.cQm.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Qh != null) {
                    EmotionTabHorizonScrollView.this.Qh.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.jD()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.k.neterror);
                }
            }
        });
        this.aOj = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aOj.setLayoutParams(layoutParams3);
        this.cQm.addView(this.aOj);
        if (!appResponseToIntentClass) {
            this.cQp.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cQr = z;
        int i2 = i + 1;
        int childCount = this.cQm.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.cQn.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Hv() == EmotionGroupType.BIG_EMOTION || cVar.Hv() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.cQm.getChildAt(i2)).getChildAt(0);
                if (!this.cQr) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.k.emotion_cant_show)).xi();
                        }
                    });
                    if (cVar.Hx() != null) {
                        cVar.Hx().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Hw() != null) {
                    cVar.Hw().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.cQm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cQm.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).cQx;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.cQp.setVisibility(8);
        } else {
            this.cQp.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Hv() == EmotionGroupType.BIG_EMOTION || cVar.Hv() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aOd) {
            if (this.aOd != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cQm.getChildAt(this.aOd + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ayX == 0) {
                        color = getResources().getColor(d.C0141d.common_color_10287);
                    } else {
                        color = al.getColor(d.C0141d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aOd = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cQm.getChildAt(this.aOd + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cQn.get(this.aOd);
            if (cVar.Hw() != null) {
                cVar.Hw().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(d.C0141d.common_color_10022));
                this.cQs = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aOd = -1;
        this.cQm.removeAllViews();
        aoh();
        dC(this.ayX);
    }

    public void dC(int i) {
        int color;
        this.ayX = i;
        if (this.cQq != null) {
            al.b(this.cQq, d.f.face_store, i);
        }
        if (this.cQp != null) {
            al.d(this.cQp, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.cQp.getChildCount() > 0) {
                al.e(this.cQp.getChildAt(1), d.C0141d.common_color_10288, i);
            }
        }
        if (this.aOj != null) {
            al.d(this.aOj, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aOi != null) {
            al.d(this.aOi, d.f.icon_news_head_prompt_one, i);
            al.b(this.aOi, d.C0141d.cp_cont_i, 1, i);
        }
        int childCount = this.cQm.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.cQm.getChildAt(i2);
            if (childAt != null) {
                al.d(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.cQv != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0141d.common_color_10287);
                        } else {
                            color = al.getColor(d.C0141d.common_color_10287);
                        }
                        aVar.cQv.setForegroundColor(color);
                    }
                    if (aVar.cQw != null) {
                        al.e(aVar.cQw, d.C0141d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.cQs != null) {
            this.cQs.setForegroundColor(al.getColor(d.C0141d.common_color_10022));
            if (this.cQs.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cQs.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.cQo = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aog;

        private b(int i) {
            this.aog = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.cQs) {
                ((TbImageView) view).setForegroundColor(al.getColor(d.C0141d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.cQs != null) {
                    if (!EmotionTabHorizonScrollView.this.cQt) {
                        EmotionTabHorizonScrollView.this.cQs.setForegroundColor(al.getColor(d.C0141d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.cQs.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0141d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.cQs = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aog);
            EmotionTabHorizonScrollView.this.cQo.eX(this.aog);
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.g(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView cQv;
        View cQw;
        com.baidu.tbadk.editortools.emotiontool.c cQx;

        private a() {
        }
    }
}
