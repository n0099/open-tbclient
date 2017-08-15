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
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public m(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.cWK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, d.j.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, a aVar) {
        aVar.a(hVar);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        u.WX().jh("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar, int i) {
        if (gVar != null && !StringUtils.isNull(gVar.Vn)) {
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
    public class a extends j.a {
        private int aqm;
        private View bwQ;
        private TextView cSq;
        private TextView cWd;
        private TextView cWe;
        private LinearLayout cWf;
        private LinearLayout cWg;
        private com.baidu.tieba.homepage.personalize.data.h cWh;
        private View.OnClickListener cWi;
        private View.OnClickListener cWj;
        private View.OnClickListener cWk;

        public a(View view) {
            super(view);
            this.aqm = 3;
            this.cWi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log("c10984");
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE));
                }
            };
            this.cWj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.cWh != null) {
                        a.this.a(a.this.cWh.cWL, view2, 1);
                    }
                }
            };
            this.cWk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.m.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.cWh != null) {
                        a.this.a(a.this.cWh.cWM, view2, 2);
                    }
                }
            };
            this.cSq = (TextView) view.findViewById(d.h.new_user_guide_tip);
            this.bwQ = view.findViewById(d.h.new_user_guide_close);
            this.cWd = (TextView) view.findViewById(d.h.new_user_guide_man);
            this.cWe = (TextView) view.findViewById(d.h.new_user_guide_woman);
            this.cWf = (LinearLayout) view.findViewById(d.h.new_user_guide_sex_layout);
            this.cWg = (LinearLayout) view.findViewById(d.h.new_user_guide_age_layout);
            this.cWd.setOnClickListener(this.cWj);
            this.cWe.setOnClickListener(this.cWj);
            this.bwQ.setOnClickListener(this.cWi);
        }

        protected void onChangeSkinType(int i) {
            if (this.aqm != i) {
                ai.k(getView(), d.e.cp_bg_line_d);
                ai.i(this.cSq, d.e.cp_cont_d);
                ai.j(this.bwQ, d.g.icon_x_normal);
                this.aqm = i;
            }
            if (this.cWh != null && this.cWh.cWL.size() == 2) {
                if (this.cWh.cWL.get(0).isSelect) {
                    ai.i(this.cWd, d.e.cp_cont_g);
                    ai.j(this.cWd, d.g.shape_semi_circle_left_selected);
                } else {
                    ai.i(this.cWd, d.e.cp_cont_f);
                    ai.j(this.cWd, d.g.shape_semi_circle_left_line);
                }
                if (this.cWh.cWL.get(1).isSelect) {
                    ai.i(this.cWe, d.e.cp_cont_g);
                    ai.j(this.cWe, d.g.shape_semi_circle_right_selected);
                } else {
                    ai.i(this.cWe, d.e.cp_cont_f);
                    ai.j(this.cWe, d.g.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cWg.getChildCount(); i2++) {
                View childAt = this.cWg.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g lt = lt(((TextView) childAt).getText().toString());
                    if (lt != null && lt.isSelect) {
                        ai.i(childAt, d.e.cp_cont_g);
                        ai.j(childAt, d.g.shape_semi_circle_all_selected);
                    } else {
                        ai.i(childAt, d.e.cp_cont_f);
                        ai.j(childAt, d.g.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g lt(String str) {
            if (StringUtils.isNull(str) || this.cWh == null || this.cWh.cWM == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.cWh.cWM) {
                if (gVar != null && str.equals(gVar.Vn)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.cWh = hVar;
                if (hVar.cWL.size() == 2) {
                    this.cWd.setText(hVar.cWL.get(0).Vn);
                    this.cWe.setText(hVar.cWL.get(1).Vn);
                } else {
                    this.cWf.setVisibility(8);
                }
                this.cWg.removeAllViews();
                if (hVar.cWM.size() > 0) {
                    for (int i = 0; i < hVar.cWM.size(); i++) {
                        View lu = lu(hVar.cWM.get(i).Vn);
                        if (lu != null) {
                            this.cWg.addView(lu);
                            if (i != hVar.cWM.size() - 1) {
                                this.cWg.addView(apq());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.g> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.hr()) {
                    com.baidu.adp.lib.util.k.showToast(m.this.mContext, d.l.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.g gVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.g gVar2 : list) {
                            if (charSequence.equals(gVar2.Vn)) {
                                gVar2.isSelect = !gVar2.isSelect;
                            } else {
                                gVar2.isSelect = false;
                                gVar2 = gVar;
                            }
                            gVar = gVar2;
                        }
                        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        m.this.a(gVar, i);
                        TiebaStatic.log(new aj("c10982").aa("obj_name", charSequence));
                    }
                }
            }
        }

        private View lu(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds110), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60)));
            textView.setOnClickListener(this.cWk);
            return textView;
        }

        private View apq() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
