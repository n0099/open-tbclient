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
        super(context, com.baidu.tieba.homepage.personalize.data.h.cyY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
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
        cc.ST().ib("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar, int i) {
        if (gVar != null && !StringUtils.isNull(gVar.Uu)) {
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
        private View bjk;
        private TextView cyg;
        private TextView cym;
        private TextView cyn;
        private LinearLayout cyo;
        private LinearLayout cyp;
        private com.baidu.tieba.homepage.personalize.data.h cyq;
        private View.OnClickListener cyr;
        private View.OnClickListener cys;
        private View.OnClickListener cyt;

        public a(View view) {
            super(view);
            this.amZ = 3;
            this.cyr = new z(this);
            this.cys = new aa(this);
            this.cyt = new ab(this);
            this.cyg = (TextView) view.findViewById(w.h.new_user_guide_tip);
            this.bjk = view.findViewById(w.h.new_user_guide_close);
            this.cym = (TextView) view.findViewById(w.h.new_user_guide_man);
            this.cyn = (TextView) view.findViewById(w.h.new_user_guide_woman);
            this.cyo = (LinearLayout) view.findViewById(w.h.new_user_guide_sex_layout);
            this.cyp = (LinearLayout) view.findViewById(w.h.new_user_guide_age_layout);
            this.cym.setOnClickListener(this.cys);
            this.cyn.setOnClickListener(this.cys);
            this.bjk.setOnClickListener(this.cyr);
        }

        protected void onChangeSkinType(int i) {
            if (this.amZ != i) {
                aq.k(getView(), w.e.cp_bg_line_d);
                aq.i(this.cyg, w.e.cp_cont_d);
                aq.j(this.bjk, w.g.icon_x_normal);
                this.amZ = i;
            }
            if (this.cyq != null && this.cyq.cyZ.size() == 2) {
                if (this.cyq.cyZ.get(0).cyX) {
                    aq.i(this.cym, w.e.cp_cont_g);
                    aq.j(this.cym, w.g.shape_semi_circle_left_selected);
                } else {
                    aq.i(this.cym, w.e.cp_cont_f);
                    aq.j(this.cym, w.g.shape_semi_circle_left_line);
                }
                if (this.cyq.cyZ.get(1).cyX) {
                    aq.i(this.cyn, w.e.cp_cont_g);
                    aq.j(this.cyn, w.g.shape_semi_circle_right_selected);
                } else {
                    aq.i(this.cyn, w.e.cp_cont_f);
                    aq.j(this.cyn, w.g.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cyp.getChildCount(); i2++) {
                View childAt = this.cyp.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g jG = jG(((TextView) childAt).getText().toString());
                    if (jG != null && jG.cyX) {
                        aq.i(childAt, w.e.cp_cont_g);
                        aq.j(childAt, w.g.shape_semi_circle_all_selected);
                    } else {
                        aq.i(childAt, w.e.cp_cont_f);
                        aq.j(childAt, w.g.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g jG(String str) {
            if (StringUtils.isNull(str) || this.cyq == null || this.cyq.cza == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.cyq.cza) {
                if (gVar != null && str.equals(gVar.Uu)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.cyq = hVar;
                if (hVar.cyZ.size() == 2) {
                    this.cym.setText(hVar.cyZ.get(0).Uu);
                    this.cyn.setText(hVar.cyZ.get(1).Uu);
                } else {
                    this.cyo.setVisibility(8);
                }
                this.cyp.removeAllViews();
                if (hVar.cza.size() > 0) {
                    for (int i = 0; i < hVar.cza.size(); i++) {
                        View jH = jH(hVar.cza.get(i).Uu);
                        if (jH != null) {
                            this.cyp.addView(jH);
                            if (i != hVar.cza.size() - 1) {
                                this.cyp.addView(ajC());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.g> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.hj()) {
                    com.baidu.adp.lib.util.k.showToast(y.this.mContext, w.l.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.g gVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.g gVar2 : list) {
                            if (charSequence.equals(gVar2.Uu)) {
                                gVar2.cyX = !gVar2.cyX;
                                gVar = gVar2;
                            } else {
                                gVar2.cyX = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        y.this.a(gVar, i);
                        TiebaStatic.log(new as("c10982").aa("obj_name", charSequence));
                    }
                }
            }
        }

        private View jH(String str) {
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
            textView.setOnClickListener(this.cyt);
            return textView;
        }

        private View ajC() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
