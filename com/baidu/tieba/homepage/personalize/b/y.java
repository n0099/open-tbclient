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
import com.baidu.tieba.card.ca;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public y(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.cww);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
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
        ca.To().ib("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar, int i) {
        if (gVar != null && !StringUtils.isNull(gVar.TP)) {
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            } else if (i == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int ane;
        private View blR;
        private TextView cvH;
        private TextView cvN;
        private TextView cvO;
        private LinearLayout cvP;
        private LinearLayout cvQ;
        private com.baidu.tieba.homepage.personalize.data.h cvR;
        private View.OnClickListener cvS;
        private View.OnClickListener cvT;
        private View.OnClickListener cvU;

        public a(View view) {
            super(view);
            this.ane = 3;
            this.cvS = new z(this);
            this.cvT = new aa(this);
            this.cvU = new ab(this);
            this.cvH = (TextView) view.findViewById(w.h.new_user_guide_tip);
            this.blR = view.findViewById(w.h.new_user_guide_close);
            this.cvN = (TextView) view.findViewById(w.h.new_user_guide_man);
            this.cvO = (TextView) view.findViewById(w.h.new_user_guide_woman);
            this.cvP = (LinearLayout) view.findViewById(w.h.new_user_guide_sex_layout);
            this.cvQ = (LinearLayout) view.findViewById(w.h.new_user_guide_age_layout);
            this.cvN.setOnClickListener(this.cvT);
            this.cvO.setOnClickListener(this.cvT);
            this.blR.setOnClickListener(this.cvS);
        }

        protected void onChangeSkinType(int i) {
            if (this.ane != i) {
                aq.k(getView(), w.e.cp_bg_line_d);
                aq.i(this.cvH, w.e.cp_cont_d);
                aq.j(this.blR, w.g.icon_x_normal);
                this.ane = i;
            }
            if (this.cvR != null && this.cvR.cwx.size() == 2) {
                if (this.cvR.cwx.get(0).cwv) {
                    aq.i(this.cvN, w.e.cp_cont_g);
                    aq.j(this.cvN, w.g.shape_semi_circle_left_selected);
                } else {
                    aq.i(this.cvN, w.e.cp_cont_f);
                    aq.j(this.cvN, w.g.shape_semi_circle_left_line);
                }
                if (this.cvR.cwx.get(1).cwv) {
                    aq.i(this.cvO, w.e.cp_cont_g);
                    aq.j(this.cvO, w.g.shape_semi_circle_right_selected);
                } else {
                    aq.i(this.cvO, w.e.cp_cont_f);
                    aq.j(this.cvO, w.g.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cvQ.getChildCount(); i2++) {
                View childAt = this.cvQ.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g jN = jN(((TextView) childAt).getText().toString());
                    if (jN != null && jN.cwv) {
                        aq.i(childAt, w.e.cp_cont_g);
                        aq.j(childAt, w.g.shape_semi_circle_all_selected);
                    } else {
                        aq.i(childAt, w.e.cp_cont_f);
                        aq.j(childAt, w.g.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g jN(String str) {
            if (StringUtils.isNull(str) || this.cvR == null || this.cvR.cwy == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.cvR.cwy) {
                if (gVar != null && str.equals(gVar.TP)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.cvR = hVar;
                if (hVar.cwx.size() == 2) {
                    this.cvN.setText(hVar.cwx.get(0).TP);
                    this.cvO.setText(hVar.cwx.get(1).TP);
                } else {
                    this.cvP.setVisibility(8);
                }
                this.cvQ.removeAllViews();
                if (hVar.cwy.size() > 0) {
                    for (int i = 0; i < hVar.cwy.size(); i++) {
                        View jO = jO(hVar.cwy.get(i).TP);
                        if (jO != null) {
                            this.cvQ.addView(jO);
                            if (i != hVar.cwy.size() - 1) {
                                this.cvQ.addView(ahP());
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
                            if (charSequence.equals(gVar2.TP)) {
                                gVar2.cwv = !gVar2.cwv;
                                gVar = gVar2;
                            } else {
                                gVar2.cwv = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        y.this.a(gVar, i);
                        TiebaStatic.log(new as("c10982").aa("obj_name", charSequence));
                    }
                }
            }
        }

        private View jO(String str) {
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
            textView.setOnClickListener(this.cvU);
            return textView;
        }

        private View ahP() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
