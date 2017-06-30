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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public aa(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.cKM);
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
        cf.VN().iL("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar, int i) {
        if (gVar != null && !StringUtils.isNull(gVar.Tw)) {
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
        private int aoa;
        private View bqP;
        private TextView cJY;
        private TextView cKe;
        private TextView cKf;
        private LinearLayout cKg;
        private LinearLayout cKh;
        private com.baidu.tieba.homepage.personalize.data.h cKi;
        private View.OnClickListener cKj;
        private View.OnClickListener cKk;
        private View.OnClickListener cKl;

        public a(View view) {
            super(view);
            this.aoa = 3;
            this.cKj = new ab(this);
            this.cKk = new ac(this);
            this.cKl = new ad(this);
            this.cJY = (TextView) view.findViewById(w.h.new_user_guide_tip);
            this.bqP = view.findViewById(w.h.new_user_guide_close);
            this.cKe = (TextView) view.findViewById(w.h.new_user_guide_man);
            this.cKf = (TextView) view.findViewById(w.h.new_user_guide_woman);
            this.cKg = (LinearLayout) view.findViewById(w.h.new_user_guide_sex_layout);
            this.cKh = (LinearLayout) view.findViewById(w.h.new_user_guide_age_layout);
            this.cKe.setOnClickListener(this.cKk);
            this.cKf.setOnClickListener(this.cKk);
            this.bqP.setOnClickListener(this.cKj);
        }

        protected void onChangeSkinType(int i) {
            if (this.aoa != i) {
                as.k(getView(), w.e.cp_bg_line_d);
                as.i(this.cJY, w.e.cp_cont_d);
                as.j(this.bqP, w.g.icon_x_normal);
                this.aoa = i;
            }
            if (this.cKi != null && this.cKi.cKN.size() == 2) {
                if (this.cKi.cKN.get(0).isSelect) {
                    as.i(this.cKe, w.e.cp_cont_g);
                    as.j(this.cKe, w.g.shape_semi_circle_left_selected);
                } else {
                    as.i(this.cKe, w.e.cp_cont_f);
                    as.j(this.cKe, w.g.shape_semi_circle_left_line);
                }
                if (this.cKi.cKN.get(1).isSelect) {
                    as.i(this.cKf, w.e.cp_cont_g);
                    as.j(this.cKf, w.g.shape_semi_circle_right_selected);
                } else {
                    as.i(this.cKf, w.e.cp_cont_f);
                    as.j(this.cKf, w.g.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cKh.getChildCount(); i2++) {
                View childAt = this.cKh.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g kV = kV(((TextView) childAt).getText().toString());
                    if (kV != null && kV.isSelect) {
                        as.i(childAt, w.e.cp_cont_g);
                        as.j(childAt, w.g.shape_semi_circle_all_selected);
                    } else {
                        as.i(childAt, w.e.cp_cont_f);
                        as.j(childAt, w.g.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g kV(String str) {
            if (StringUtils.isNull(str) || this.cKi == null || this.cKi.cKO == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.cKi.cKO) {
                if (gVar != null && str.equals(gVar.Tw)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.cKi = hVar;
                if (hVar.cKN.size() == 2) {
                    this.cKe.setText(hVar.cKN.get(0).Tw);
                    this.cKf.setText(hVar.cKN.get(1).Tw);
                } else {
                    this.cKg.setVisibility(8);
                }
                this.cKh.removeAllViews();
                if (hVar.cKO.size() > 0) {
                    for (int i = 0; i < hVar.cKO.size(); i++) {
                        View kW = kW(hVar.cKO.get(i).Tw);
                        if (kW != null) {
                            this.cKh.addView(kW);
                            if (i != hVar.cKO.size() - 1) {
                                this.cKh.addView(amQ());
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
                    com.baidu.adp.lib.util.k.showToast(aa.this.mContext, w.l.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.g gVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.g gVar2 : list) {
                            if (charSequence.equals(gVar2.Tw)) {
                                gVar2.isSelect = !gVar2.isSelect;
                                gVar = gVar2;
                            } else {
                                gVar2.isSelect = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        aa.this.a(gVar, i);
                        TiebaStatic.log(new au("c10982").Z("obj_name", charSequence));
                    }
                }
            }
        }

        private View kW(String str) {
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
            textView.setOnClickListener(this.cKl);
            return textView;
        }

        private View amQ() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
