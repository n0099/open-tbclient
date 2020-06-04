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
    private TbPageContext<?> dIF;
    private a gpS;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.dIF = null;
        this.dIF = tbPageContext;
        this.gpS = aVar;
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
        C0586b c0586b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0586b c0586b2 = new C0586b();
            c0586b2.gpV = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0586b2.gpW = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0586b2.gpX = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0586b2.gpY = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0586b2.gpZ = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0586b2.gqa = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0586b2.gqb = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0586b2.gqc = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0586b2.gqd = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0586b2.gqe = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0586b2.gqf = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0586b2.gqg = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0586b2.gqh = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0586b2.gqi = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0586b2.gqj = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0586b2.gqk = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0586b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0586b = c0586b2;
        } else {
            c0586b = (C0586b) view.getTag();
        }
        a(c0586b);
        if (aVar != null) {
            if (aVar.rN(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b rN = aVar.rN(0);
                c0586b.gpY.setVisibility(0);
                c0586b.gpV.setText(rN.bIA() == null ? "" : rN.bIA());
                if (rN.bIB() != null) {
                    c0586b.gpW.setDefaultBgResource(R.color.transparent);
                    c0586b.gpW.startLoad(rN.bIB(), 10, false);
                }
                c(c0586b.gpX, rN.bIC());
                c(c0586b.gpW, rN.bIC());
                a(c0586b.gpZ, rN.bIG(), rN.price);
                c0586b.gpY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gpS != null) {
                            b.this.gpS.a(aVar.rN(0));
                        }
                    }
                });
            } else {
                c0586b.gpY.setVisibility(4);
                c0586b.gpY.setOnClickListener(null);
            }
            if (aVar.rN(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b rN2 = aVar.rN(1);
                c0586b.gqd.setVisibility(0);
                c0586b.gqa.setText(rN2.bIA() == null ? "" : rN2.bIA());
                if (rN2.bIB() != null) {
                    c0586b.gqb.setDefaultBgResource(R.color.transparent);
                    c0586b.gqb.startLoad(rN2.bIB(), 10, false);
                }
                c(c0586b.gqc, rN2.bIC());
                c(c0586b.gqb, rN2.bIC());
                a(c0586b.gqe, rN2.bIG(), rN2.price);
                c0586b.gqd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gpS != null) {
                            b.this.gpS.a(aVar.rN(1));
                        }
                    }
                });
            } else {
                c0586b.gqd.setVisibility(4);
                c0586b.gqd.setOnClickListener(null);
            }
            if (aVar.rN(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b rN3 = aVar.rN(2);
                c0586b.gqi.setVisibility(0);
                c0586b.gqf.setText(rN3.bIA() == null ? "" : rN3.bIA());
                if (rN3.bIB() != null) {
                    c0586b.gqg.setDefaultBgResource(R.color.transparent);
                    c0586b.gqg.startLoad(rN3.bIB(), 10, false);
                }
                c(c0586b.gqh, rN3.bIC());
                c(c0586b.gqg, rN3.bIC());
                a(c0586b.gqj, rN3.bIG(), rN3.price);
                c0586b.gqi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gpS != null) {
                            b.this.gpS.a(aVar.rN(2));
                        }
                    }
                });
            } else {
                c0586b.gqi.setVisibility(4);
                c0586b.gqi.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0586b.gqk.setVisibility(0);
            } else {
                c0586b.gqk.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.bIw() != null) {
                c0586b.title.setVisibility(0);
                c0586b.title.setText(aVar.bIw());
            } else {
                c0586b.title.setVisibility(8);
            }
        }
        view.setTag(c0586b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.dIF.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.dIF.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0586b c0586b) {
        if (c0586b != null) {
            am.setViewTextColor(c0586b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0586b.gpV, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0586b.gqa, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0586b.gqf, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0586b.gpZ, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0586b.gqe, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0586b.gqj, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0586b.gpW.setDefaultResource(R.drawable.pic_live_honor_1);
                c0586b.gpW.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0586b.gqb.setDefaultResource(R.drawable.pic_live_honor_1);
                c0586b.gqb.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0586b.gqg.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0586b.gpW.setDefaultResource(R.drawable.pic_live_honor);
                c0586b.gpW.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0586b.gqb.setDefaultResource(R.drawable.pic_live_honor);
                c0586b.gqb.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0586b.gqg.setDefaultResource(R.drawable.pic_live_honor);
            }
            am.setBackgroundColor(c0586b.gqk, R.color.cp_bg_line_c);
        }
    }

    private void c(TextView textView, int i) {
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
            this.list = bN(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> bN(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].CY(list.get(i3).bIw());
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
                        aVar.CY(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].bIw());
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
    public class C0586b {
        TextView gpV;
        TbImageView gpW;
        TextView gpX;
        RelativeLayout gpY;
        TextView gpZ;
        TextView gqa;
        TbImageView gqb;
        TextView gqc;
        RelativeLayout gqd;
        TextView gqe;
        TextView gqf;
        TbImageView gqg;
        TextView gqh;
        RelativeLayout gqi;
        TextView gqj;
        View gqk;
        TextView title;

        private C0586b() {
        }
    }
}
