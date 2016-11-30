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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.j, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public x(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.j.cMR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public a a(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, r.h.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.j jVar, a aVar) {
        aVar.a(jVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        bx.Pl().hU("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.i iVar, int i) {
        if (iVar != null && !StringUtils.isNull(iVar.PW)) {
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, iVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            } else if (i == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, iVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int aiA;
        private TextView cLW;
        private View cLX;
        private TextView cMd;
        private TextView cMe;
        private LinearLayout cMf;
        private LinearLayout cMg;
        private com.baidu.tieba.homepage.personalize.data.j cMh;
        private View.OnClickListener cMi;
        private View.OnClickListener cMj;
        private View.OnClickListener cMk;

        public a(View view) {
            super(view);
            this.aiA = 3;
            this.cMi = new y(this);
            this.cMj = new z(this);
            this.cMk = new aa(this);
            this.cLW = (TextView) view.findViewById(r.g.new_user_guide_tip);
            this.cLX = view.findViewById(r.g.new_user_guide_close);
            this.cMd = (TextView) view.findViewById(r.g.new_user_guide_man);
            this.cMe = (TextView) view.findViewById(r.g.new_user_guide_woman);
            this.cMf = (LinearLayout) view.findViewById(r.g.new_user_guide_sex_layout);
            this.cMg = (LinearLayout) view.findViewById(r.g.new_user_guide_age_layout);
            this.cMd.setOnClickListener(this.cMj);
            this.cMe.setOnClickListener(this.cMj);
            this.cLX.setOnClickListener(this.cMi);
        }

        protected void onChangeSkinType(int i) {
            if (this.aiA != i) {
                at.l(getView(), r.d.cp_bg_line_d);
                at.j((View) this.cLW, r.d.cp_cont_d);
                at.k(this.cLX, r.f.icon_x_normal);
                this.aiA = i;
            }
            if (this.cMh != null && this.cMh.cMS.size() == 2) {
                if (this.cMh.cMS.get(0).cMQ) {
                    at.j((View) this.cMd, r.d.cp_cont_g);
                    at.k(this.cMd, r.f.shape_semi_circle_left_selected);
                } else {
                    at.j((View) this.cMd, r.d.cp_cont_f);
                    at.k(this.cMd, r.f.shape_semi_circle_left_line);
                }
                if (this.cMh.cMS.get(1).cMQ) {
                    at.j((View) this.cMe, r.d.cp_cont_g);
                    at.k(this.cMe, r.f.shape_semi_circle_right_selected);
                } else {
                    at.j((View) this.cMe, r.d.cp_cont_f);
                    at.k(this.cMe, r.f.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cMg.getChildCount(); i2++) {
                View childAt = this.cMg.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.i lh = lh(((TextView) childAt).getText().toString());
                    if (lh != null && lh.cMQ) {
                        at.j(childAt, r.d.cp_cont_g);
                        at.k(childAt, r.f.shape_semi_circle_all_selected);
                    } else {
                        at.j(childAt, r.d.cp_cont_f);
                        at.k(childAt, r.f.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.i lh(String str) {
            if (StringUtils.isNull(str) || this.cMh == null || this.cMh.cMT == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.i iVar : this.cMh.cMT) {
                if (iVar != null && str.equals(iVar.PW)) {
                    return iVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.j jVar) {
            if (jVar != null) {
                this.cMh = jVar;
                if (jVar.cMS.size() == 2) {
                    this.cMd.setText(jVar.cMS.get(0).PW);
                    this.cMe.setText(jVar.cMS.get(1).PW);
                } else {
                    this.cMf.setVisibility(8);
                }
                this.cMg.removeAllViews();
                if (jVar.cMT.size() > 0) {
                    for (int i = 0; i < jVar.cMT.size(); i++) {
                        View li = li(jVar.cMT.get(i).PW);
                        if (li != null) {
                            this.cMg.addView(li);
                            if (i != jVar.cMT.size() - 1) {
                                this.cMg.addView(aoO());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.i> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.gm()) {
                    com.baidu.adp.lib.util.k.showToast(x.this.mContext, r.j.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.i iVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.i iVar2 : list) {
                            if (charSequence.equals(iVar2.PW)) {
                                iVar2.cMQ = !iVar2.cMQ;
                                iVar = iVar2;
                            } else {
                                iVar2.cMQ = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        x.this.a(iVar, i);
                        TiebaStatic.log(new av("c10982").ab("obj_name", charSequence));
                    }
                }
            }
        }

        private View li(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds110), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds60)));
            textView.setOnClickListener(this.cMk);
            return textView;
        }

        private View aoO() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
