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
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public aa(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.cCP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
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
        cf.Uw().ie("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar, int i) {
        if (gVar != null && !StringUtils.isNull(gVar.TB)) {
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
    public class a extends z.a {
        private int ana;
        private View bmY;
        private TextView bvI;
        private TextView cCg;
        private TextView cCh;
        private LinearLayout cCi;
        private LinearLayout cCj;
        private com.baidu.tieba.homepage.personalize.data.h cCk;
        private View.OnClickListener cCl;
        private View.OnClickListener cCm;
        private View.OnClickListener cCn;

        public a(View view) {
            super(view);
            this.ana = 3;
            this.cCl = new ab(this);
            this.cCm = new ac(this);
            this.cCn = new ad(this);
            this.bvI = (TextView) view.findViewById(w.h.new_user_guide_tip);
            this.bmY = view.findViewById(w.h.new_user_guide_close);
            this.cCg = (TextView) view.findViewById(w.h.new_user_guide_man);
            this.cCh = (TextView) view.findViewById(w.h.new_user_guide_woman);
            this.cCi = (LinearLayout) view.findViewById(w.h.new_user_guide_sex_layout);
            this.cCj = (LinearLayout) view.findViewById(w.h.new_user_guide_age_layout);
            this.cCg.setOnClickListener(this.cCm);
            this.cCh.setOnClickListener(this.cCm);
            this.bmY.setOnClickListener(this.cCl);
        }

        protected void onChangeSkinType(int i) {
            if (this.ana != i) {
                aq.k(getView(), w.e.cp_bg_line_d);
                aq.i(this.bvI, w.e.cp_cont_d);
                aq.j(this.bmY, w.g.icon_x_normal);
                this.ana = i;
            }
            if (this.cCk != null && this.cCk.cCQ.size() == 2) {
                if (this.cCk.cCQ.get(0).cCO) {
                    aq.i(this.cCg, w.e.cp_cont_g);
                    aq.j(this.cCg, w.g.shape_semi_circle_left_selected);
                } else {
                    aq.i(this.cCg, w.e.cp_cont_f);
                    aq.j(this.cCg, w.g.shape_semi_circle_left_line);
                }
                if (this.cCk.cCQ.get(1).cCO) {
                    aq.i(this.cCh, w.e.cp_cont_g);
                    aq.j(this.cCh, w.g.shape_semi_circle_right_selected);
                } else {
                    aq.i(this.cCh, w.e.cp_cont_f);
                    aq.j(this.cCh, w.g.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cCj.getChildCount(); i2++) {
                View childAt = this.cCj.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g jX = jX(((TextView) childAt).getText().toString());
                    if (jX != null && jX.cCO) {
                        aq.i(childAt, w.e.cp_cont_g);
                        aq.j(childAt, w.g.shape_semi_circle_all_selected);
                    } else {
                        aq.i(childAt, w.e.cp_cont_f);
                        aq.j(childAt, w.g.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g jX(String str) {
            if (StringUtils.isNull(str) || this.cCk == null || this.cCk.cCR == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.cCk.cCR) {
                if (gVar != null && str.equals(gVar.TB)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.cCk = hVar;
                if (hVar.cCQ.size() == 2) {
                    this.cCg.setText(hVar.cCQ.get(0).TB);
                    this.cCh.setText(hVar.cCQ.get(1).TB);
                } else {
                    this.cCi.setVisibility(8);
                }
                this.cCj.removeAllViews();
                if (hVar.cCR.size() > 0) {
                    for (int i = 0; i < hVar.cCR.size(); i++) {
                        View jY = jY(hVar.cCR.get(i).TB);
                        if (jY != null) {
                            this.cCj.addView(jY);
                            if (i != hVar.cCR.size() - 1) {
                                this.cCj.addView(aje());
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
                    com.baidu.adp.lib.util.k.showToast(aa.this.mContext, w.l.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.g gVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.g gVar2 : list) {
                            if (charSequence.equals(gVar2.TB)) {
                                gVar2.cCO = !gVar2.cCO;
                                gVar = gVar2;
                            } else {
                                gVar2.cCO = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        aa.this.a(gVar, i);
                        TiebaStatic.log(new as("c10982").Z("obj_name", charSequence));
                    }
                }
            }
        }

        private View jY(String str) {
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
            textView.setOnClickListener(this.cCn);
            return textView;
        }

        private View aje() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
