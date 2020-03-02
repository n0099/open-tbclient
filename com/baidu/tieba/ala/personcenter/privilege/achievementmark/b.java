package com.baidu.tieba.ala.personcenter.privilege.achievementmark;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> cVh;
    private a fvp;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.cVh = null;
        this.cVh = tbPageContext;
        this.fvp = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.list != null) {
            return this.list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.list == null || i >= this.list.size()) {
            return null;
        }
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0479b c0479b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0479b c0479b2 = new C0479b();
            c0479b2.fvs = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0479b2.fvt = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0479b2.fvu = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0479b2.fvv = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0479b2.fvw = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0479b2.fvx = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0479b2.fvy = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0479b2.fvz = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0479b2.fvA = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0479b2.fvB = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0479b2.fvC = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0479b2.fvD = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0479b2.fvE = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0479b2.fvF = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0479b2.fvG = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0479b2.fvH = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0479b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0479b = c0479b2;
        } else {
            c0479b = (C0479b) view.getTag();
        }
        a(c0479b);
        if (aVar != null) {
            if (aVar.qN(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b qN = aVar.qN(0);
                c0479b.fvv.setVisibility(0);
                c0479b.fvs.setText(qN.bsr() == null ? "" : qN.bsr());
                if (qN.bss() != null) {
                    c0479b.fvt.setDefaultBgResource(R.color.transparent);
                    c0479b.fvt.startLoad(qN.bss(), 10, false);
                }
                b(c0479b.fvu, qN.bst());
                c(c0479b.fvt, qN.bst());
                a(c0479b.fvw, qN.bsx(), qN.price);
                c0479b.fvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.fvp != null) {
                            b.this.fvp.a(aVar.qN(0));
                        }
                    }
                });
            } else {
                c0479b.fvv.setVisibility(4);
                c0479b.fvv.setOnClickListener(null);
            }
            if (aVar.qN(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b qN2 = aVar.qN(1);
                c0479b.fvA.setVisibility(0);
                c0479b.fvx.setText(qN2.bsr() == null ? "" : qN2.bsr());
                if (qN2.bss() != null) {
                    c0479b.fvy.setDefaultBgResource(R.color.transparent);
                    c0479b.fvy.startLoad(qN2.bss(), 10, false);
                }
                b(c0479b.fvz, qN2.bst());
                c(c0479b.fvy, qN2.bst());
                a(c0479b.fvB, qN2.bsx(), qN2.price);
                c0479b.fvA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.fvp != null) {
                            b.this.fvp.a(aVar.qN(1));
                        }
                    }
                });
            } else {
                c0479b.fvA.setVisibility(4);
                c0479b.fvA.setOnClickListener(null);
            }
            if (aVar.qN(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b qN3 = aVar.qN(2);
                c0479b.fvF.setVisibility(0);
                c0479b.fvC.setText(qN3.bsr() == null ? "" : qN3.bsr());
                if (qN3.bss() != null) {
                    c0479b.fvD.setDefaultBgResource(R.color.transparent);
                    c0479b.fvD.startLoad(qN3.bss(), 10, false);
                }
                b(c0479b.fvE, qN3.bst());
                c(c0479b.fvD, qN3.bst());
                a(c0479b.fvG, qN3.bsx(), qN3.price);
                c0479b.fvF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.fvp != null) {
                            b.this.fvp.a(aVar.qN(2));
                        }
                    }
                });
            } else {
                c0479b.fvF.setVisibility(4);
                c0479b.fvF.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0479b.fvH.setVisibility(0);
            } else {
                c0479b.fvH.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.bsn() != null) {
                c0479b.title.setVisibility(0);
                c0479b.title.setText(aVar.bsn());
            } else {
                c0479b.title.setVisibility(8);
            }
        }
        view.setTag(c0479b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.cVh.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.cVh.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.cVh.getResources().getDimensionPixelSize(R.dimen.ds4));
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setText(AlaStringHelper.formatLowercasekDou(j));
            return;
        }
        textView.setVisibility(8);
    }

    private void c(TbImageView tbImageView, int i) {
        if (tbImageView != null) {
            if (i == 0) {
                tbImageView.setAlpha(0.5f);
            } else if (i == 3) {
                tbImageView.setAlpha(0.2f);
            } else {
                tbImageView.setAlpha(1);
            }
        }
    }

    private void a(C0479b c0479b) {
        if (c0479b != null) {
            am.setViewTextColor(c0479b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0479b.fvs, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0479b.fvx, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0479b.fvC, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0479b.fvw, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0479b.fvB, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0479b.fvG, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0479b.fvt.setDefaultResource(R.drawable.pic_live_honor_1);
                c0479b.fvt.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0479b.fvy.setDefaultResource(R.drawable.pic_live_honor_1);
                c0479b.fvy.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0479b.fvD.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0479b.fvt.setDefaultResource(R.drawable.pic_live_honor);
                c0479b.fvt.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0479b.fvy.setDefaultResource(R.drawable.pic_live_honor);
                c0479b.fvy.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0479b.fvD.setDefaultResource(R.drawable.pic_live_honor);
            }
            am.setBackgroundColor(c0479b.fvH, R.color.cp_bg_line_c);
        }
    }

    private void b(TextView textView, int i) {
        if (textView != null) {
            if (i == 0) {
                textView.setText(R.string.ala_achievement_mark_status_unlock);
                am.setViewTextColor(textView, (int) R.color.cp_cont_d);
                am.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
            } else if (i == 1) {
                textView.setText(R.string.ala_achievement_mark_status_wear);
                am.setViewTextColor(textView, (int) R.color.live_cp_other_b);
                am.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
            } else if (i == 2) {
                textView.setText(R.string.ala_achievement_mark_status_lock);
                am.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
                am.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
            } else if (i == 3) {
                textView.setText(R.string.ala_achievement_mark_status_expired);
                am.setViewTextColor(textView, (int) R.color.cp_cont_d);
                am.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
            } else {
                textView.setVisibility(4);
            }
        }
    }

    public void setData(List<c> list) {
        if (list != null) {
            if (this.list != null && this.list.size() > 0) {
                this.list.clear();
            }
            this.list = bH(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> bH(List<c> list) {
        int i;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                break;
            }
            List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b> list2 = list.get(i3).getList();
            int size = list2.size();
            if (size % 3 == 0) {
                i = size / 3;
            } else {
                i = (size / 3) + 1;
            }
            com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][] bVarArr = (com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) Array.newInstance(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b.class, i, 3);
            for (int i4 = 0; i4 < size; i4++) {
                bVarArr[i4 / 3][i4 % 3] = list2.get(i4);
                bVarArr[i4 / 3][i4 % 3].zE(list.get(i3).bsn());
            }
            arrayList2.add(bVarArr);
            i2 = i3 + 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= arrayList2.size()) {
                return arrayList;
            }
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 < ((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6)).length) {
                    com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = new com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a();
                    if (((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6)).length == 1) {
                        aVar.setType(1);
                    } else if (((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6)).length > 1 && i8 == 0) {
                        aVar.setType(2);
                    } else if (((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6)).length > 1 && i8 == ((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6)).length - 1) {
                        aVar.setType(3);
                    } else {
                        aVar.setType(4);
                    }
                    if (i6 == arrayList2.size() - 1) {
                        if (aVar.getType() == 1) {
                            aVar.setType(2);
                        } else if (aVar.getType() == 3) {
                            aVar.setType(4);
                        }
                    }
                    int i9 = 0;
                    while (true) {
                        int i10 = i9;
                        if (i10 >= 3) {
                            break;
                        }
                        if (((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[i8][i10] != null) {
                            aVar.b(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[i8][i10]);
                        }
                        i9 = i10 + 1;
                    }
                    if (((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0] != null) {
                        aVar.zE(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].bsn());
                    }
                    arrayList.add(aVar);
                    i7 = i8 + 1;
                }
            }
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0479b {
        RelativeLayout fvA;
        TextView fvB;
        TextView fvC;
        TbImageView fvD;
        TextView fvE;
        RelativeLayout fvF;
        TextView fvG;
        View fvH;
        TextView fvs;
        TbImageView fvt;
        TextView fvu;
        RelativeLayout fvv;
        TextView fvw;
        TextView fvx;
        TbImageView fvy;
        TextView fvz;
        TextView title;

        private C0479b() {
        }
    }
}
