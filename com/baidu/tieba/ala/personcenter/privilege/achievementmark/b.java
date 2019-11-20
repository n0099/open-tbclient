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
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> ceu;
    private a eyb;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.ceu = null;
        this.ceu = tbPageContext;
        this.eyb = aVar;
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
        C0383b c0383b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0383b c0383b2 = new C0383b();
            c0383b2.eye = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0383b2.eyf = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0383b2.eyg = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0383b2.eyh = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0383b2.eyi = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0383b2.eyj = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0383b2.eyk = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0383b2.eyl = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0383b2.eyn = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0383b2.eyo = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0383b2.eyp = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0383b2.eyq = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0383b2.eyr = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0383b2.eys = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0383b2.eyt = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0383b2.eyu = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0383b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0383b = c0383b2;
        } else {
            c0383b = (C0383b) view.getTag();
        }
        a(c0383b);
        if (aVar != null) {
            if (aVar.oi(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b oi = aVar.oi(0);
                c0383b.eyh.setVisibility(0);
                c0383b.eye.setText(oi.aXN() == null ? "" : oi.aXN());
                if (oi.aXO() != null) {
                    c0383b.eyf.setDefaultBgResource(R.color.transparent);
                    c0383b.eyf.startLoad(oi.aXO(), 10, false);
                }
                b(c0383b.eyg, oi.aXP());
                b(c0383b.eyf, oi.aXP());
                a(c0383b.eyi, oi.aXT(), oi.price);
                c0383b.eyh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.eyb != null) {
                            b.this.eyb.a(aVar.oi(0));
                        }
                    }
                });
            } else {
                c0383b.eyh.setVisibility(4);
                c0383b.eyh.setOnClickListener(null);
            }
            if (aVar.oi(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b oi2 = aVar.oi(1);
                c0383b.eyn.setVisibility(0);
                c0383b.eyj.setText(oi2.aXN() == null ? "" : oi2.aXN());
                if (oi2.aXO() != null) {
                    c0383b.eyk.setDefaultBgResource(R.color.transparent);
                    c0383b.eyk.startLoad(oi2.aXO(), 10, false);
                }
                b(c0383b.eyl, oi2.aXP());
                b(c0383b.eyk, oi2.aXP());
                a(c0383b.eyo, oi2.aXT(), oi2.price);
                c0383b.eyn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.eyb != null) {
                            b.this.eyb.a(aVar.oi(1));
                        }
                    }
                });
            } else {
                c0383b.eyn.setVisibility(4);
                c0383b.eyn.setOnClickListener(null);
            }
            if (aVar.oi(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b oi3 = aVar.oi(2);
                c0383b.eys.setVisibility(0);
                c0383b.eyp.setText(oi3.aXN() == null ? "" : oi3.aXN());
                if (oi3.aXO() != null) {
                    c0383b.eyq.setDefaultBgResource(R.color.transparent);
                    c0383b.eyq.startLoad(oi3.aXO(), 10, false);
                }
                b(c0383b.eyr, oi3.aXP());
                b(c0383b.eyq, oi3.aXP());
                a(c0383b.eyt, oi3.aXT(), oi3.price);
                c0383b.eys.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.eyb != null) {
                            b.this.eyb.a(aVar.oi(2));
                        }
                    }
                });
            } else {
                c0383b.eys.setVisibility(4);
                c0383b.eys.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0383b.eyu.setVisibility(0);
            } else {
                c0383b.eyu.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.aXJ() != null) {
                c0383b.title.setVisibility(0);
                c0383b.title.setText(aVar.aXJ());
            } else {
                c0383b.title.setVisibility(8);
            }
        }
        view.setTag(c0383b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.ceu.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.ceu.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.ceu.getResources().getDimensionPixelSize(R.dimen.ds4));
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setText(AlaStringHelper.formatLowercasekDou(j));
            return;
        }
        textView.setVisibility(8);
    }

    private void b(TbImageView tbImageView, int i) {
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

    private void a(C0383b c0383b) {
        if (c0383b != null) {
            am.setViewTextColor(c0383b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0383b.eye, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0383b.eyj, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0383b.eyp, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0383b.eyi, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0383b.eyo, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0383b.eyt, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0383b.eyf.setDefaultResource(R.drawable.pic_live_honor_1);
                c0383b.eyf.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0383b.eyk.setDefaultResource(R.drawable.pic_live_honor_1);
                c0383b.eyk.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0383b.eyq.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0383b.eyf.setDefaultResource(R.drawable.pic_live_honor);
                c0383b.eyf.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0383b.eyk.setDefaultResource(R.drawable.pic_live_honor);
                c0383b.eyk.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0383b.eyq.setDefaultResource(R.drawable.pic_live_honor);
            }
            am.setBackgroundColor(c0383b.eyu, R.color.cp_bg_line_c);
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
            this.list = bI(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> bI(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].ul(list.get(i3).aXJ());
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
                        aVar.ul(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].aXJ());
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
    /* loaded from: classes6.dex */
    public class C0383b {
        TextView eye;
        TbImageView eyf;
        TextView eyg;
        RelativeLayout eyh;
        TextView eyi;
        TextView eyj;
        TbImageView eyk;
        TextView eyl;
        RelativeLayout eyn;
        TextView eyo;
        TextView eyp;
        TbImageView eyq;
        TextView eyr;
        RelativeLayout eys;
        TextView eyt;
        View eyu;
        TextView title;

        private C0383b() {
        }
    }
}
