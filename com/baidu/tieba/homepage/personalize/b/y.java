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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public y(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.czc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: af */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, r.j.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, a aVar) {
        aVar.a(hVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        cc.Rx().ih("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar, int i) {
        if (gVar != null && !StringUtils.isNull(gVar.OZ)) {
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
        private int ahp;
        private View bcE;
        private TextView cyk;
        private TextView cyq;
        private TextView cyr;
        private LinearLayout cys;
        private LinearLayout cyt;
        private com.baidu.tieba.homepage.personalize.data.h cyu;
        private View.OnClickListener cyv;
        private View.OnClickListener cyw;
        private View.OnClickListener cyx;

        public a(View view) {
            super(view);
            this.ahp = 3;
            this.cyv = new z(this);
            this.cyw = new aa(this);
            this.cyx = new ab(this);
            this.cyk = (TextView) view.findViewById(r.h.new_user_guide_tip);
            this.bcE = view.findViewById(r.h.new_user_guide_close);
            this.cyq = (TextView) view.findViewById(r.h.new_user_guide_man);
            this.cyr = (TextView) view.findViewById(r.h.new_user_guide_woman);
            this.cys = (LinearLayout) view.findViewById(r.h.new_user_guide_sex_layout);
            this.cyt = (LinearLayout) view.findViewById(r.h.new_user_guide_age_layout);
            this.cyq.setOnClickListener(this.cyw);
            this.cyr.setOnClickListener(this.cyw);
            this.bcE.setOnClickListener(this.cyv);
        }

        protected void onChangeSkinType(int i) {
            if (this.ahp != i) {
                ap.k(getView(), r.e.cp_bg_line_d);
                ap.i((View) this.cyk, r.e.cp_cont_d);
                ap.j(this.bcE, r.g.icon_x_normal);
                this.ahp = i;
            }
            if (this.cyu != null && this.cyu.czd.size() == 2) {
                if (this.cyu.czd.get(0).czb) {
                    ap.i((View) this.cyq, r.e.cp_cont_g);
                    ap.j((View) this.cyq, r.g.shape_semi_circle_left_selected);
                } else {
                    ap.i((View) this.cyq, r.e.cp_cont_f);
                    ap.j((View) this.cyq, r.g.shape_semi_circle_left_line);
                }
                if (this.cyu.czd.get(1).czb) {
                    ap.i((View) this.cyr, r.e.cp_cont_g);
                    ap.j((View) this.cyr, r.g.shape_semi_circle_right_selected);
                } else {
                    ap.i((View) this.cyr, r.e.cp_cont_f);
                    ap.j((View) this.cyr, r.g.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cyt.getChildCount(); i2++) {
                View childAt = this.cyt.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g jZ = jZ(((TextView) childAt).getText().toString());
                    if (jZ != null && jZ.czb) {
                        ap.i(childAt, r.e.cp_cont_g);
                        ap.j(childAt, r.g.shape_semi_circle_all_selected);
                    } else {
                        ap.i(childAt, r.e.cp_cont_f);
                        ap.j(childAt, r.g.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g jZ(String str) {
            if (StringUtils.isNull(str) || this.cyu == null || this.cyu.cze == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.cyu.cze) {
                if (gVar != null && str.equals(gVar.OZ)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.cyu = hVar;
                if (hVar.czd.size() == 2) {
                    this.cyq.setText(hVar.czd.get(0).OZ);
                    this.cyr.setText(hVar.czd.get(1).OZ);
                } else {
                    this.cys.setVisibility(8);
                }
                this.cyt.removeAllViews();
                if (hVar.cze.size() > 0) {
                    for (int i = 0; i < hVar.cze.size(); i++) {
                        View ka = ka(hVar.cze.get(i).OZ);
                        if (ka != null) {
                            this.cyt.addView(ka);
                            if (i != hVar.cze.size() - 1) {
                                this.cyt.addView(akw());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.g> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.gk()) {
                    com.baidu.adp.lib.util.k.showToast(y.this.mContext, r.l.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.g gVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.g gVar2 : list) {
                            if (charSequence.equals(gVar2.OZ)) {
                                gVar2.czb = !gVar2.czb;
                                gVar = gVar2;
                            } else {
                                gVar2.czb = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        y.this.a(gVar, i);
                        TiebaStatic.log(new ar("c10982").ab("obj_name", charSequence));
                    }
                }
            }
        }

        private View ka(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds110), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds60)));
            textView.setOnClickListener(this.cyx);
            return textView;
        }

        private View akw() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
