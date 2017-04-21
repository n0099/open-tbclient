package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public y(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.cBp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, w.j.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, a aVar) {
        aVar.a(hVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        cc.TV().ic("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar, int i) {
        if (gVar != null && !StringUtils.isNull(gVar.Uw)) {
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, gVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            } else if (i == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, gVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int amZ;
        private View blu;
        private TextView cAD;
        private TextView cAE;
        private LinearLayout cAF;
        private LinearLayout cAG;
        private com.baidu.tieba.homepage.personalize.data.h cAH;
        private View.OnClickListener cAI;
        private View.OnClickListener cAJ;
        private View.OnClickListener cAK;
        private TextView cAx;

        public a(View view) {
            super(view);
            this.amZ = 3;
            this.cAI = new z(this);
            this.cAJ = new aa(this);
            this.cAK = new ab(this);
            this.cAx = (TextView) view.findViewById(w.h.new_user_guide_tip);
            this.blu = view.findViewById(w.h.new_user_guide_close);
            this.cAD = (TextView) view.findViewById(w.h.new_user_guide_man);
            this.cAE = (TextView) view.findViewById(w.h.new_user_guide_woman);
            this.cAF = (LinearLayout) view.findViewById(w.h.new_user_guide_sex_layout);
            this.cAG = (LinearLayout) view.findViewById(w.h.new_user_guide_age_layout);
            this.cAD.setOnClickListener(this.cAJ);
            this.cAE.setOnClickListener(this.cAJ);
            this.blu.setOnClickListener(this.cAI);
        }

        protected void onChangeSkinType(int i) {
            if (this.amZ != i) {
                aq.k(getView(), w.e.cp_bg_line_d);
                aq.i(this.cAx, w.e.cp_cont_d);
                aq.j(this.blu, w.g.icon_x_normal);
                this.amZ = i;
            }
            if (this.cAH != null && this.cAH.cBq.size() == 2) {
                if (this.cAH.cBq.get(0).cBo) {
                    aq.i(this.cAD, w.e.cp_cont_g);
                    aq.j(this.cAD, w.g.shape_semi_circle_left_selected);
                } else {
                    aq.i(this.cAD, w.e.cp_cont_f);
                    aq.j(this.cAD, w.g.shape_semi_circle_left_line);
                }
                if (this.cAH.cBq.get(1).cBo) {
                    aq.i(this.cAE, w.e.cp_cont_g);
                    aq.j(this.cAE, w.g.shape_semi_circle_right_selected);
                } else {
                    aq.i(this.cAE, w.e.cp_cont_f);
                    aq.j(this.cAE, w.g.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cAG.getChildCount(); i2++) {
                View childAt = this.cAG.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g jH = jH(((TextView) childAt).getText().toString());
                    if (jH != null && jH.cBo) {
                        aq.i(childAt, w.e.cp_cont_g);
                        aq.j(childAt, w.g.shape_semi_circle_all_selected);
                    } else {
                        aq.i(childAt, w.e.cp_cont_f);
                        aq.j(childAt, w.g.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g jH(String str) {
            if (StringUtils.isNull(str) || this.cAH == null || this.cAH.cBr == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.cAH.cBr) {
                if (gVar != null && str.equals(gVar.Uw)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.cAH = hVar;
                if (hVar.cBq.size() == 2) {
                    this.cAD.setText(hVar.cBq.get(0).Uw);
                    this.cAE.setText(hVar.cBq.get(1).Uw);
                } else {
                    this.cAF.setVisibility(8);
                }
                this.cAG.removeAllViews();
                if (hVar.cBr.size() > 0) {
                    for (int i = 0; i < hVar.cBr.size(); i++) {
                        View jI = jI(hVar.cBr.get(i).Uw);
                        if (jI != null) {
                            this.cAG.addView(jI);
                            if (i != hVar.cBr.size() - 1) {
                                this.cAG.addView(akD());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.g> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.hk()) {
                    com.baidu.adp.lib.util.k.showToast(y.this.mContext, w.l.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.g gVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.g gVar2 : list) {
                            if (charSequence.equals(gVar2.Uw)) {
                                gVar2.cBo = !gVar2.cBo;
                                gVar = gVar2;
                            } else {
                                gVar2.cBo = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        y.this.a(gVar, i);
                        TiebaStatic.log(new as("c10982").aa("obj_name", charSequence));
                    }
                }
            }
        }

        private View jI(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds110), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60)));
            textView.setOnClickListener(this.cAK);
            return textView;
        }

        private View akD() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
